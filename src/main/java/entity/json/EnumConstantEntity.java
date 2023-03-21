package entity.json;

import org.json.JSONPropertyName;

public class EnumConstantEntity extends BaseEntity {

  private Location location;
  private String File;
  private String additionalBin;

  public EnumConstantEntity() {
  }

  public EnumConstantEntity(int id, int parentId, String category, String name, String qualifiedName, boolean external, Location location, String file, String additionalBin) {
    super(id, parentId, category, name, qualifiedName, external);
    this.location = location;
    File = file;
    this.additionalBin = additionalBin;
  }

  public Location getLocation() {
    return location;
  }

  public void setLocation(Location location) {
    this.location = location;
  }

  @JSONPropertyName("File")
  public String getFile() {
    return File;
  }

  public void setFile(String file) {
    File = file;
  }

  public String getAdditionalBin() {
    return additionalBin;
  }

  public void setAdditionalBin(String additionalBin) {
    this.additionalBin = additionalBin;
  }
}
