package entity.json;

import org.json.JSONPropertyName;

public class InterfaceEntity extends BaseEntity {

  private String modifiers;
  private String File;
  private String additionalBin;
  private String rawType;
  private Location location;

  public InterfaceEntity() {
  }

  public InterfaceEntity(int id, int parentId, String category, String name, String qualifiedName, boolean external, String modifiers, String file, String additionalBin, String rawType, Location location) {
    super(id, parentId, category, name, qualifiedName, external);
    this.modifiers = modifiers;
    File = file;
    this.additionalBin = additionalBin;
    this.rawType = rawType;
    this.location = location;
  }

  public String getModifiers() {
    return modifiers;
  }

  public void setModifiers(String modifiers) {
    this.modifiers = modifiers;
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
}
