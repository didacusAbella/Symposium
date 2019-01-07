package it.blackhat.symposium.unit;

import it.blackhat.symposium.models.Report;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Rayman
 */

public class ReportModelTest {
    private Report report;

    @Before
    public void setUp() {
        report = new it.blackhat.symposium.models.ReportModel(7, "spam", "gay", 2019, "G.MADONNA3@studenti.unisa.it", 21);
    }

    @Test
    public void costructorTest() {
        Report report1;
        report1 = new it.blackhat.symposium.models.ReportModel();
        Assert.assertTrue(report1 instanceof Report);
    }

    @Test
    public void costructFull() {
        Report report2 = new it.blackhat.symposium.models.ReportModel(7, "spam", "gay", 2019, "G.MADONNA3@studenti.unisa.it", 21);
        boolean b1 = (7 == report2.getId());
        boolean b2 = ("spam".equals(report2.getCategory()));
        boolean b3 = ("gay".equals(report2.getCategory()));
        boolean b4 = (2019 == report2.getId());
        boolean b5 = ("G:MADONNA3@studenti.unisa.it".equals(report2.getCategory()));
        boolean b6 = (21 == report2.getId());
        boolean tot = (b1 && b2 && b3 && b4 && b5 && b6);
        Assert.assertTrue(report2 instanceof Report);

    }

    /**
     * test of getId method of class ReportModel
     */
    @Test
    public void getIdTest() {
        Assert.assertEquals("It should return 7", 7, report.getId());
    }

    /**
     * test of setId method of class ReportModel
     */
    @Test
    public void setIdTest() {
        it.blackhat.symposium.models.ReportModel rep = new it.blackhat.symposium.models.ReportModel();
        rep.setId(7);
        Assert.assertEquals("It should return 7", 7, rep.getId());
    }

    /**
     * test of getCategory method of class ReportModel
     */
    @Test
    public void getCategoryTest() {
        Assert.assertEquals("It should return spam", "spam", report.getCategory());
    }

    /**
     * test of setCategory method of class ReportModel
     */
    @Test
    public void setCategoryTest() {
        it.blackhat.symposium.models.ReportModel rep = new it.blackhat.symposium.models.ReportModel();
        rep.setCategory("spam");
        Assert.assertEquals("It should return spam", "spam", rep.getCategory());
    }

    /**
     * test of getReason method of class ReportModel
     */
    @Test
    public void getReasonTest() {
        Assert.assertEquals("It should return gay", "gay", report.getCategory());
    }

    /**
     * test of setReason method of class ReportModel
     */
    @Test
    public void setReasonTest() {
        it.blackhat.symposium.models.ReportModel rep = new it.blackhat.symposium.models.ReportModel();
        rep.setCategory("gay");
        Assert.assertEquals("It should return gay", "gay", rep.getCategory());
    }

    /**
     * test of getUserFk method of class ReportModel
     */
    @Test
    public void getUserFkTest() {
        Assert.assertEquals("It should return G.MADONNA3@studenti.unisa.it", "G.MADONNA3@studenti.unisa.it", report.getCategory());
    }

    /**
     * test of setUserFk method of class ReportModel
     */
    @Test
    public void setUserFkTest() {
        it.blackhat.symposium.models.ReportModel rep = new it.blackhat.symposium.models.ReportModel();
        rep.setCategory("G.MADONNA3@studenti.unisa.it");
        Assert.assertEquals("It should return G.MADONNA3@studenti.unisa.it", "G.MADONNA3@studenti.unisa.it", rep.getCategory());
    }

    /**
     * test of getYear method of class ReportModel
     */
    @Test
    public void getYearTest() {
        Assert.assertEquals("It should return 2019", 2019, report.getId());
    }

    /**
     * test of setYeat method of class ReportModel
     */
    @Test
    public void setYearTest() {
        it.blackhat.symposium.models.ReportModel rep = new it.blackhat.symposium.models.ReportModel();
        rep.setId(2019);
        Assert.assertEquals("It should return 2019", 2019, rep.getId());

    }

    /**
     * test of getQuestionFk method of class ReportModel
     */
    @Test
    public void getQuestionFkTest() {
        Assert.assertEquals("It should return 21", 21, report.getId());
    }

    /**
     * test of setQuestionFk method of class ReportModel
     */
    @Test
    public void setQuestionFkTest() {
        it.blackhat.symposium.models.ReportModel rep = new it.blackhat.symposium.models.ReportModel();
        rep.setId(21);
        Assert.assertEquals("It should return 21", 21, rep.getId());
    }

    /**
     * test of toSting method of class ReportModel
     */
    @Test
    public void toStringTest() {
        String test = "ReportModel{"
                + "id='" + 7
                + ", category='" + "spam" + '\''
                + ", reason='" + "gay" + '\''
                + ", userFk='" + "G.MADONNA3@studenti.unisa.it" + '\''
                + ", questionFk" + 21
                + ", year='" + 2019
                + '}';
        assertEquals(test, report.toString());
    }
}

