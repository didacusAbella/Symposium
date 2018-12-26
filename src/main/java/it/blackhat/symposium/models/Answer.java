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
public interface Answer {
    
    String getId();
    
    String getContent();
    
    Date getCreationDate();
    
    String getTitle();
    
    String getAuthor();
}
