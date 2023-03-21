package entity.dto;

public class AnnotationMemberEntityDTO extends InternalEntityDTO {

  private String File;
  private AdditionalBinDTO additionalBin;
  private LocationDTO location;
  private String rawType;

  public AnnotationMemberEntityDTO(int parentId, String File, AdditionalBinDTO additionalBin, LocationDTO location, String rawType) {
    super(parentId, "Annotation Member");
    this.File = File;
    this.additionalBin = additionalBin;
    this.location = location;
    this.rawType = rawType;
  }

  public AnnotationMemberEntityDTO(int id, String name, String qualifiedName, int parentId, String File, AdditionalBinDTO additionalBin, LocationDTO location, String rawType) {
    super(id, name, qualifiedName, parentId, "Annotation Member");
    this.File = File;
    this.additionalBin = additionalBin;
    this.location = location;
    this.rawType = rawType;
  }

  public String getFile() {
    return File;
  }

  public void setFile(String file) {
    File = file;
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

  public String getRawType() {
    return rawType;
  }

  public void setRawType(String rawType) {
    this.rawType = rawType;
  }
}
