package it.blackhat.symposium.models;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Date;

/**
 * Concrete implementation of Answer Interface
 *
 * @author Przemyslaw Szopian
 * @author 2Deimos
 */
public class AnswerModel implements Answer {

  @NotNull
  private int id;

  @NotNull
  private int questionFk;

  @NotNull
  private String userFk;

  @NotNull
  @Size(min = 1, max = 4096)
  private String content;

  @NotNull
  private Date creationDate;

  private boolean correct;

  /**
   * Initialize a void AnswerModel
   */
  public AnswerModel() {
    super();
  }

  /**
   * Initialize a new Answer
   *
   * @param id the answer's id
   * @param questionFk the answer's related question
   * @param userFk the answer's related author
   * @param content the answer's content
   * @param creationDate the answer's creation date
   * @param correct the answer state (chosen as the best one or not)
   */
  public AnswerModel(int id, int questionFk, String userFk,
          String content, Date creationDate, boolean correct) {
    this.id = id;
    this.questionFk = questionFk;
    this.userFk = userFk;
    this.content = content;
    this.creationDate = creationDate;
    this.correct = correct;
  }

  @Override
  public int getId() {
    return id;
  }

  @Override
  public void setId(int id) {
    this.id = id;
  }

  @Override
  public int getQuestionFk() {
    return questionFk;
  }

  @Override
  public void setQuestionFk(int questionFk) {
    this.questionFk = questionFk;
  }

  @Override
  public String getUserFk() {
    return userFk;
  }

  @Override
  public void setUserFk(String userFk) {
    this.userFk = userFk;
  }

  @Override
  public String getContent() {
    return content;
  }

  @Override
  public void setContent(String content) {
    this.content = content;
  }

  @Override
  public Date getCreationDate() {
    return creationDate;
  }

  @Override
  public void setCreationDate(Date creationDate) {
    this.creationDate = creationDate;
  }

  @Override
  public boolean isCorrect() {
    return correct;
  }

  @Override
  public void setCorrect(boolean correct) {
    this.correct = correct;
  }

  @Override
  public String toString() {
    return "AnswerModel{"
            + "id=" + id
            + ", questionFk=" + questionFk
            + ", userFk=" + userFk
            + ", content=" + content
            + ", creationDate=" + creationDate
            + ", correct=" + correct
            + '}';
  }
}
