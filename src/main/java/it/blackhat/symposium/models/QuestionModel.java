package it.blackhat.symposium.models;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Date;

/**
 * Concrete implementation of Question Interface
 *
 * @author Przemyslaw Szopian
 * @author 2Deimos
 */
public class QuestionModel implements Question {

  @NotNull
  @Size(min = 6, max = 30)
  private String title;

  @NotNull
  @Size(min = 6, max = 200)
  private String content;

  @NotNull
  private String userFk;

  @NotNull
  private Date creationDate;

  @NotNull
  private Date lastUpdate;

  @NotNull
  private int id;

  @NotNull
  private int numReports;

  /**
   * Initialize a void Question
   */
  public QuestionModel() {
    super();
  }

  /**
   * Initialize a new Question
   *
   * @param title title of the question
   * @param content content of the question
   * @param userFk author of the question
   * @param creationDate creation date of the question
   * @param lastUpdate last update date of the question
   * @param id id of the question
   * @param numReports numer of reports of the question
   */
  public QuestionModel(String title, String content, String userFk,
          Date creationDate, Date lastUpdate, int id,
          int numReports) {
    this.title = title;
    this.content = content;
    this.userFk = userFk;
    this.creationDate = creationDate;
    this.lastUpdate = lastUpdate;
    this.id = id;
    this.numReports = numReports;
  }

  @Override
  public String getTitle() {
    return title;
  }

  @Override
  public void setTitle(String title) {
    this.title = title;
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
  public String getUserFk() {
    return userFk;
  }

  @Override
  public void setUserFk(String userFk) {
    this.userFk = userFk;
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
  public Date getLastUpdate() {
    return lastUpdate;
  }

  @Override
  public void setLastUpdate(Date lastUpdate) {
    this.lastUpdate = lastUpdate;
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
  public int getNumReports() {
    return numReports;
  }

  @Override
  public void setNumReports(int numReports) {
    this.numReports = numReports;
  }

  @Override
  public String toString() {
    return "QuestionModel{" + "title='" + title + '\'' + ", content='" + content
            + '\'' + ", userFk='" + userFk
            + '\'' + ", creationDate=" + creationDate + ", lastUpdate="
            + lastUpdate + ", id=" + id
            + ", numReports=" + numReports + '}';
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (!(o instanceof QuestionModel)) {
      return false;
    }
    QuestionModel c = (QuestionModel) o;

    return title.equals(c.title) && content.equals(c.content) && userFk.equals(c.userFk)
            && creationDate.equals(c.creationDate)
            && lastUpdate.equals(c.lastUpdate) && id == c.id
            && numReports == c.numReports;
  }

  @Override
  public int hashCode() {
    int result = 17;
    result = 31 * result + title.hashCode();
    result = 31 * result + content.hashCode();
    result = 31 * result + userFk.hashCode();
    result = 31 * result + creationDate.hashCode();
    result = 31 * result + lastUpdate.hashCode();
    result = 31 * result + id;
    result = 31 * result + numReports;
    return result;
  }
}
