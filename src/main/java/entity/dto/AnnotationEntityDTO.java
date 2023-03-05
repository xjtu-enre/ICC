package entity.dto;

public class AnnotationEntityDTO extends InternalEntityDTO {

  private String file;
  private AdditionalBinDTO additionalBin;
  private LocationDTO location;
  private String modifiers;
  private String rawType;

  public AnnotationEntityDTO(int parentId, String file, AdditionalBinDTO additionalBin, String modifiers, String rawType) {
    super(parentId, "Annotation");
    this.file = file;
    this.additionalBin = additionalBin;
    this.modifiers = modifiers;
    this.rawType = rawType;
  }

  public AnnotationEntityDTO(int parentId, String file, AdditionalBinDTO additionalBin, LocationDTO location, String modifiers, String rawType) {
    super(parentId, "Annotation");
    this.file = file;
    this.additionalBin = additionalBin;
    this.location = location;
    this.modifiers = modifiers;
    this.rawType = rawType;
  }

  public AnnotationEntityDTO(int id, String name, String qualifiedName, int parentId, String file, AdditionalBinDTO additionalBin, LocationDTO location, String modifiers, String rawType) {
    super(id, name, qualifiedName, parentId, "Annotation");
    this.file = file;
    this.additionalBin = additionalBin;
    this.location = location;
    this.modifiers = modifiers;
    this.rawType = rawType;
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
