package entity.json;


public class MethodEntity extends BaseEntity {

  private String modifiers;
  private String File;
  private AdditionalBin additionalBin;
  private String rawType;
  private Enhancement enhancement;
  private Parameter parameter;
  private Location location;


  public MethodEntity() {
  }



  public MethodEntity(int id, int parentId, String category, String name, String qualifiedName, boolean external, String modifiers, String file, AdditionalBin additionalBin, String rawType, Enhancement enhancement, Parameter parameter, Location location) {
    super(id, parentId, category, name, qualifiedName, external);
    this.modifiers = modifiers;
    File = file;
    this.additionalBin = additionalBin;
    this.rawType = rawType;
    this.enhancement = enhancement;
    this.parameter = parameter;
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

  public AdditionalBin getAdditionalBin() {
    return additionalBin;
  }

  public void setAdditionalBin(AdditionalBin additionalBin) {
    this.additionalBin = additionalBin;
  }

  public String getRawType() {
    return rawType;
  }

  public void setRawType(String rawType) {
    this.rawType = rawType;
  }

  public Enhancement getEnhancement() {
    return enhancement;
  }

  public void setEnhancement(Enhancement enhancement) {
    this.enhancement = enhancement;
  }

  public Parameter getParameter() {
    return parameter;
  }

  public void setParameter(Parameter parameter) {
    this.parameter = parameter;
  }

  public Location getLocation() {
    return location;
  }

  public void setLocation(Location location) {
    this.location = location;
  }



  @Override
  public String toString() {
    return super.toString();
  }
}
