package it.blackhat.symposium.models;

/**
 * Interface for represent Tag resource
 *
 * @author Przemyslaw Szopian
 * @author 2Deimos
 */
public interface Tag {

  /**
   * Retrive the id of the tag
   *
   * @return the id
   */
  int getId();

  /**
   * Change the id of the question
   *
   * @param id new id of the tag
   */
  void setId(int id);

  /**
   * Retrieve the name of the tag
   *
   * @return the name of the tag
   */
  String getName();

  /**
   * Change the name of the tag
   *
   * @param name the tag's new name
   */
  void setName(String name);
}
