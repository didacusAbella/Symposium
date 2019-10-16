package it.blackhat.symposium.models;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Concrete implementation of Tag Interface
 *
 * @author Przemyslaw Szopian
 * @author 2Deimos
 */
public class TagModel implements Tag {

  @NotNull
  private int id;

  @NotNull
  @Size(min = 1, max = 40)
  private String name;

  /**
   * create an empty TagModel
   */
  public TagModel() {
    super();
  }

  /**
   * Create a new Tag with id and name.
   *
   * @param id id of the tag
   * @param name tag name of the tag
   */
  public TagModel(int id, String name) {
    this.id = id;
    this.name = name;
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
  public String getName() {
    return name;
  }

  @Override
  public void setName(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return "TagModel{"
            + "id = " + id
            + ", name = " + name
            + "}";
  }
}
