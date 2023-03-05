package entity.json;
public class TypeParameterEntity extends BaseEntity {

  private String rawType;
  private Location location;
  private String File;
  private String additionalBin;

  public TypeParameterEntity() {
  }

  public TypeParameterEntity(int id, int parentId, String category, String name, String qualifiedName, boolean external, String rawType, Location location, String file, String additionalBin) {
    super(id, parentId, category, name, qualifiedName, external);
    this.rawType = rawType;
    this.location = location;
    File = file;
    this.additionalBin = additionalBin;
  }

  public String getRawType() {
    return rawType;
  }

  public void setRawType(String rawType) {
    this.rawType = rawType;
  }

  public Location getLocation() {
    return location;
  }

  public void setLocation(Location location) {
    this.location = location;
  }

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
