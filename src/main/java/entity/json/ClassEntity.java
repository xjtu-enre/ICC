package entity.json;

public class ClassEntity extends BaseEntity {

  private String modifiers;
  private String File;
  private String additionalBin;
  private int anonymousRank;
  private String rawType;
  private int anonymousBindVar;
  private String innerType;
  private Location location;

  public ClassEntity() {
  }

  public ClassEntity(int id, int parentId, String category, String name, String qualifiedName, boolean external, String modifiers, String file, String additionalBin, int anonymousRank, String rawType, int anonymousBindVar, String innerType, Location location) {
    super(id, parentId, category, name, qualifiedName, external);
    this.modifiers = modifiers;
    File = file;
    this.additionalBin = additionalBin;
    this.anonymousRank = anonymousRank;
    this.rawType = rawType;
    this.anonymousBindVar = anonymousBindVar;
    this.innerType = innerType;
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

  public int getAnonymousRank() {
    return anonymousRank;
  }

  public void setAnonymousRank(int anonymousRank) {
    this.anonymousRank = anonymousRank;
  }

  public String getRawType() {
    return rawType;
  }

  public void setRawType(String rawType) {
    this.rawType = rawType;
  }

  public int getAnonymousBindVar() {
    return anonymousBindVar;
  }

  public void setAnonymousBindVar(int anonymousBindVar) {
    this.anonymousBindVar = anonymousBindVar;
  }

  public String getInnerType() {
    return innerType;
  }

  public void setInnerType(String innerType) {
    this.innerType = innerType;
  }

  public Location getLocation() {
    return location;
  }

  public void setLocation(Location location) {
    this.location = location;
  }
}
