package entity.json;

public class VariableEntity extends BaseEntity {

  private String modifiers;
  private String File;
  private String additionalBin;
  private boolean global;
  private String rawType;
  private Location location;

  public VariableEntity() {
  }


  public VariableEntity(int id, int parentId, String category, String name, String qualifiedName, boolean external, String modifiers, String file, String additionalBin, boolean global, String rawType, Location location) {
    super(id, parentId, category, name, qualifiedName, external);
    this.modifiers = modifiers;
    File = file;
    this.additionalBin = additionalBin;
    this.global = global;
    this.rawType = rawType;
    this.location = location;
  }

  public String getModifiers() {
    return modifiers;
  }

  public void setModifiers(String modifiers) {
    this.modifiers = modifiers;
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

  public boolean isGlobal() {
    return global;
  }

  public void setGlobal(boolean global) {
    this.global = global;
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
