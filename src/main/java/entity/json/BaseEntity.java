package entity.json;

public class BaseEntity {

  private int id;
  private int parentId;
  private String category;
  private String name;
  private String qualifiedName;
  private boolean external;

  public BaseEntity() {
  }

  public BaseEntity(int id, int parentId, String category, String name, String qualifiedName, boolean external) {
    this.id = id;
    this.parentId = parentId;
    this.category = category;
    this.name = name;
    this.qualifiedName = qualifiedName;
    this.external = external;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getParentId() {
    return parentId;
  }

  public void setParentId(int parentId) {
    this.parentId = parentId;
  }

  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getQualifiedName() {
    return qualifiedName;
  }

  public void setQualifiedName(String qualifiedName) {
    this.qualifiedName = qualifiedName;
  }

  public boolean isExternal() {
    return external;
  }

  public void setExternal(boolean external) {
    this.external = external;
  }
}
