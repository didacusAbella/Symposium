package it.blackhat.symposium.models;

import javax.validation.constraints.NotNull;

/**
 * @author Przemyslaw Szopian
 */
public class StatsModel implements Stats {

  @NotNull
  private int id;

  private int numSigned;

  private int totalReports;

  private int year;

  /**
   * Create an empty StatsModel
   */
  public StatsModel() {
    super();
  }

  /**
   * Create a new Stats with id, numSigned, totalReports and year
   *
   * @param id the stat's id
   * @param numSigned the stat's numSigned
   * @param totalReports the stat's total reports
   * @param year the stat's year
   */
  public StatsModel(int id, int numSigned, int totalReports, int year) {
    this.id = id;
    this.numSigned = numSigned;
    this.totalReports = totalReports;
    this.year = year;
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
  public int getNumSigned() {
    return numSigned;
  }

  @Override
  public void setNumSigned(int numSigned) {
    this.numSigned = numSigned;
  }

  @Override
  public int getTotalReports() {
    return totalReports;
  }

  @Override
  public void setTotalReports(int totalReports) {
    this.totalReports = totalReports;
  }

  @Override
  public int getYear() {
    return year;
  }

  @Override
  public void setYear(int year) {
    this.year = year;
  }

  @Override
  public String toString() {
    return "StatsModel{"
            + "id=" + id
            + ", numSigned=" + numSigned
            + ", totalReports=" + totalReports
            + ", year=" + year
            + "}";
  }
}
