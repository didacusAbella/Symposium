/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.blackhat.symposium.unit;

import it.blackhat.symposium.models.Tag;
import it.blackhat.symposium.models.TagModel;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author SDelPiano
 */
public class TagModelTest {
    private Tag tag;

    @Before
    public void setUp() {
        tag = new TagModel(21, "esame");
    }

    @Test
    public void constructorTest() {
        Tag tag1;
        tag1 = new TagModel();
        Assert.assertTrue(tag1 instanceof Tag);
    }

    @Test
    public void fullconstructorTest() {
        TagModel tag2 = new TagModel(22, "Is");
        boolean b1 = (22 == tag2.getId());
        boolean b2 = ("Is".equals(tag2.getName()));
        boolean bTot = b1 && b2;
        Assert.assertTrue(bTot);
    }

    /**
     * Test of getId method, of class TagModel.
     */
    @Test
    public void testGetId() {
        Assert.assertEquals("It should return 21", 21, tag.getId());
    }

    /**
     * Test of getName method, of class TagModel.
     */
    @Test
    public void testGetName() {
        Assert.assertEquals("it should return esame", "esame", tag.getName());
    }

    /**
     * Test of setId method, of class TagModel.
     */
    @Test
    public void testSetId() {
        TagModel tag = new TagModel();
        tag.setId(21);
        Assert.assertEquals("It should return 21", 21, tag.getId());
    }

    /**
     * Test of setName method, of class TagModel.
     */
    @Test
    public void testSetName() {
        TagModel tag = new TagModel();
        tag.setName("esame");
        Assert.assertEquals("It should return esame", "esame", tag.getName());
    }

    @Test
    public void testToString() {
        TagModel tag = new TagModel(21, "esame");
        Assert.assertEquals("TagModel{id = 21, name = esame}", tag.toString());
    }


}
