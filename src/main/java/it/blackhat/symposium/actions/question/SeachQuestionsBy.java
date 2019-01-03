/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.blackhat.symposium.actions.question;

import it.blackhat.symposium.actions.Action;
import it.blackhat.symposium.managers.QuestionManager;
import it.blackhat.symposium.managers.QuestionModelManager;
import it.blackhat.symposium.models.Question;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 *
 * @author acer
 */
public class SeachQuestionsBy implements Action{
    private final QuestionManager quest;
    private final List<String> tags;
    private String word;
    private final Log searchQuestionByLog = LogFactory.getLog(SeachQuestionsBy.class);
    
    public SeachQuestionsBy(){
        quest= new QuestionModelManager();
        tags= new ArrayList<>();
        word= new String();
    }
    
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse res) {
        String parameter = req.getParameter("searchBy");
        findTags(parameter);
        List<Question> questions = new ArrayList<>();
        List<Question> support = new ArrayList<>();
        int flag=0;
        
        for(int i=0;i<tags.size();i++){
            try{
                support.addAll(seachByTag(tags.get(i)));
                if(support.size()>0){
                    if(flag!=0){
                        CollectionUtils.intersection(questions,support);
                    }
                    else{
                        questions.addAll(support);
                        flag=1;
                    }
                }
            }
            catch(SQLException e){
               searchQuestionByLog.error("Errore Interno", e);
            }
            support.clear();
        }
        
        try{
            support.addAll(seachByWords(word));
            if(support.size()>0){
                CollectionUtils.intersection(questions,support);
            }
        }catch(SQLException e){
            searchQuestionByLog.error("Errore Interno", e);
        }
        
        System.out.println("Grandezza :"+questions.size());
        
        for(int i=0;i<questions.size();i++){
            System.out.println("Id : "+questions.get(i).getId());
        }
        
        return "/index.jsp";
    }

    private List<Question> seachByWords(String word) throws SQLException{
            List<Question> questions= quest.seachQuestionByWords(word);
            if(questions.size()>0){
                System.out.println("Ritorna la lista");
                return questions;
            }
            else{
                System.out.println("Ritorna nulla");
                return questions;
            }
    }   
    
    private List<Question> seachByTag(String tag) throws SQLException{
            List<Question> questions = quest.seachQuestionsByTag(tag);
            if(questions.size()>0){
                System.out.println("Ritorna la lista");
                return questions;
            }
            else{
                System.out.println("Ritorna nulla");
                return questions;
            }
    }
    
    private void findTags(String reseach){
        String RegEx = "#([a-zA-Z0-9]+)";
        Pattern patter = Pattern.compile(RegEx);
        Matcher matches = patter.matcher(reseach);
        while(matches.find()){
            tags.add(matches.group(1));
        }
        word = reseach.replaceAll(RegEx, "");
        word = word.trim().replaceAll(" +", " ");
    }
}
