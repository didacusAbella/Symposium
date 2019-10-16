package it.blackhat.symposium.actions.question;

import it.blackhat.symposium.actions.Action;
import it.blackhat.symposium.managers.QuestionManager;
import it.blackhat.symposium.managers.QuestionModelManager;
import it.blackhat.symposium.models.Question;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 *
 * @author Giuseppe Madonna
 */
public class SeachQuestionByAction implements Action {

  private final QuestionManager quest;
  private final List<String> tags;
  private String word;
  private final Log searchQuestionByLog = LogFactory.getLog(SeachQuestionByAction.class);

  /**
   * Costructor of SeachQuestionsByAction
   */
  public SeachQuestionByAction(DataSource ds) {
    super();
    this.quest = new QuestionModelManager(ds);
    tags = new ArrayList<>();
    word = new String();
  }

  @Override
  public String execute(HttpServletRequest req, HttpServletResponse res) {
    String parameter = req.getParameter("searchBy");
    findTags(parameter);
    List<Question> questions = new ArrayList<>();
    List<Question> support = new ArrayList<>();
    int flag = 0;

    for (int i = 0; i < tags.size(); i++) {
      try {
        support.addAll(seachByTag(tags.get(i)));
        if (support.size() > 0) {
          if (flag != 0) {
            questions = (List<Question>) CollectionUtils.intersection(questions, support);
          } else {
            questions.addAll(support);
            flag = 1;
          }
        }
      } catch (SQLException e) {
        searchQuestionByLog.error("Errore Interno", e);
      }
      support.clear();
    }

    try {
      if (!word.isEmpty()) {
        support.addAll(seachByWords(word));
        if (support.size() > 0) {
          if (flag != 0) {
            questions = (List<Question>) CollectionUtils.union(questions, support);
          } else {
            questions.addAll(support);
            flag = 1;
          }
        }
      }
    } catch (SQLException e) {
      searchQuestionByLog.error("Errore Interno", e);
    }
    Set<Question> finale = new HashSet<>(questions);
    req.setAttribute("questions", finale);
    return "/searchResult.jsp";
  }

  /**
   * Seach questions by words
   *
   * @param word the word used for the search
   * @return a List of the founded Questions
   * @throws SQLException in case of failure
   */
  private List<Question> seachByWords(String word) throws SQLException {
    List<Question> questions = quest.seachQuestionByWords(word);
    if (questions.size() > 0) {
      return questions;
    } else {
      return questions;
    }
  }

  /**
   * Seach questions by tag
   *
   * @param tag the tag used for the seach
   * @return a List of the founded Questions
   * @throws SQLException in case of failure
   */
  private List<Question> seachByTag(String tag) throws SQLException {
    List<Question> questions = quest.seachQuestionsByTag(tag);
    if (questions.size() > 0) {
      return questions;
    } else {
      return questions;
    }
  }

  /**
   * Divide the Tags from the Word
   *
   * @param reseach the String that contain both
   */
  private void findTags(String reseach) {
    String regExp = "#([a-zA-Z0-9]+)";
    Pattern patter = Pattern.compile(regExp);
    Matcher matches = patter.matcher(reseach);
    while (matches.find()) {
      tags.add(matches.group(1));
    }
    word = reseach.replaceAll(regExp, "");
    word = word.trim().replaceAll(" +", "");
  }
}
