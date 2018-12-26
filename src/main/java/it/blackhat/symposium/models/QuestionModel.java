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
public class QuestionModel implements Question{
    
    private String id, content, title, author, tag;
    Date creationDate, lastModDate;
    private int numSegn;
    
    public QuestionModel(){
        super();
    }
    
    public QuestionModel(String id, String content, String title, String author, String tag){
        this.id = id;
        this.content = content;
        this.title = title;
        this.author = author;
        this.tag = tag;
    }
    
    @Override
    public String getId(){
        return id;
    }
    
    
    public String getContent(){
        return content;
    }
    
    @Override
    public String getTitle(){
        return title;
    }
    
    
    public String getAuthor(){
        return author;
    }
    
    @Override
    public String getTag(){
        return tag;
    }
    
    @Override
    public Date getCreationDate(){
        return creationDate;
    }
    
    @Override
    public Date getLastModDate(){
        return lastModDate;
    }
    
    @Override
    public void setLastModDate(Date lastModDate) {
        this.lastModDate = lastModDate;
    }
    
    @Override
    public void setTag(String tag) {
        this.tag = tag;
    }
}
