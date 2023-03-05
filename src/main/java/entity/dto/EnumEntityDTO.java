package entity.dto;

public class EnumEntityDTO extends InternalEntityDTO {

  private String file;
  private AdditionalBinDTO additionalBin;
  private LocationDTO location;
  private String modifiers;
  private String rawType;

  public EnumEntityDTO(int parentId, AdditionalBinDTO additionalBin, LocationDTO location, String modifiers, String rawType) {
    super(parentId, "Enum");
    this.additionalBin = additionalBin;
    this.location = location;
    this.modifiers = modifiers;
    this.rawType = rawType;
  }

  public EnumEntityDTO(int id, String name, String qualifiedName, int parentId, AdditionalBinDTO additionalBin, LocationDTO location, String modifiers, String rawType, String file) {
    super(id, name, qualifiedName, parentId, "Enum");
    this.additionalBin = additionalBin;
    this.location = location;
    this.modifiers = modifiers;
    this.rawType = rawType;
    this.file = file;
  }

  public String getFile() {
    return file;
  }

  public void setFile(String file) {
    this.file = file;
  }

  public AdditionalBinDTO getAdditionalBin() {
    return additionalBin;
  }

  public void setAdditionalBin(AdditionalBinDTO additionalBin) {
    this.additionalBin = additionalBin;
  }

  public LocationDTO getLocation() {
    return location;
  }

  public void setLocation(LocationDTO location) {
    this.location = location;
  }

  public String getModifiers() {
    return modifiers;
  }

  public void setModifiers(String modifiers) {
    this.modifiers = modifiers;
  }

  public String getRawType() {
    return rawType;
  }

  public void setRawType(String rawType) {
    this.rawType = rawType;
  }
}
