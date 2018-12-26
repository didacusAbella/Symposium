/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.blackhat.symposium.models;

import java.sql.Date;

/**
 *
 * @author Rodzinka
 */
public class AnswerModel implements Answer {
    
    private String id, content, title, author;
    Date creationDate;
    
    public AnswerModel(){
        super();
    }
    
    public AnswerModel(String id, String content, String title, String author){
        this.id = id;
        this.content = content;
        this.title = title;
        this.author = author;
    }
    
    
    public String getId(){
        return id;
    }
    
    public String getContent(){
        return content;
    }
    
    public String getTitle(){
        return title;
    }
    
    public String getAuthor(){
        return author;
    }
}
