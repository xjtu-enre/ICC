package entity.json;

public class FileEntity extends BaseEntity {

  private String additionalBin;
  private String File;

  public FileEntity() {
  }

  public FileEntity(int id, int parentId, String category, String name, String qualifiedName, boolean external, String additionalBin, String file) {
    super(id, parentId, category, name, qualifiedName, external);
    this.additionalBin = additionalBin;
    File = file;
  }

  public String getAdditionalBin() {
    return additionalBin;
  }

  public void setAdditionalBin(String additionalBin) {
    this.additionalBin = additionalBin;
  }

  public String getFile() {
    return File;
  }

  public void setFile(String file) {
    File = file;
  }
}
