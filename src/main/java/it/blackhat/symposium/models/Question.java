/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.blackhat.symposium.models;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Int;
import java.sql.Date;

/**
 *
 * @author Przemyslaw Szopian
 */
public interface Question {
    
    String getId();
    
    
    String gerContent();
    
    
    Date getCreationDate();
    
    
    Date getLastModDate();
    
    
    String getNumSegn();
    
    
    
    
    
    String getTitle();
    
    
    String getAuthore();
    
    
    String getTag();
    
    
    void setLastModDate(Date lastDate);
    
    
    
    
    
    void setTag(String tag);
}
