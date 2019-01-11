package it.blackhat.symposium.unit;

import it.blackhat.symposium.helpers.TagExtractor;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import javax.servlet.http.HttpServletRequest;
public class TagExtractorTest {

    @Test
    public void tagExtractorTrue{
        HttpServletRequest req = Mockito.mock(HttpServletRequest.class);
        Mockito.when(req.getParameter("tags")).thenReturn("ferrucci, esame, tsw");
        String[] tags = TagExtractor.extractTag(req);
        Assert.assertTrue(tags.length==3);
    }
    @Test
    public void tagExtractorFalse{
        HttpServletRequest req = Mockito.mock(HttpServletRequest.class);
        Mockito.when(req.getParameter("tags")).thenReturn("ferrucci, esame, tsw");
        String[] tags = TagExtractor.extractTag(req);
        Assert.assertFalse(tags.length==3);
    }
}
