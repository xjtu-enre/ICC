package entity.dto;

public class InternalEntityDTO extends EntityDTO {

  private int parentId;
  private String category;

  public InternalEntityDTO(int parentId, String category) {
    this.parentId = parentId;
    this.category = category;
  }

  public InternalEntityDTO(int id, String name, String qualifiedName, int parentId, String category) {
    super(id, name, qualifiedName, false);
    this.parentId = parentId;
    this.category = category;
  }

  public String getCategory() {
    return this.category;
  }

  public int getParentId() {
    return parentId;
  }

  public void setParentId(int parentId) {
    this.parentId = parentId;
  }

  public void setCategory(String category) {
    this.category = category;
  }
}
