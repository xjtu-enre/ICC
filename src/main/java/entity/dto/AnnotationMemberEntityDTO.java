package entity.dto;

public class AnnotationMemberEntityDTO extends InternalEntityDTO {

  private String file;
  private AdditionalBinDTO additionalBin;
  private LocationDTO location;
  private String rawType;

  public AnnotationMemberEntityDTO(int parentId, String file, AdditionalBinDTO additionalBin, LocationDTO location, String rawType) {
    super(parentId, "Annotation Member");
    this.file = file;
    this.additionalBin = additionalBin;
    this.location = location;
    this.rawType = rawType;
  }

  public AnnotationMemberEntityDTO(int id, String name, String qualifiedName, int parentId, String file, AdditionalBinDTO additionalBin, LocationDTO location, String rawType) {
    super(id, name, qualifiedName, parentId, "Annotation Member");
    this.file = file;
    this.additionalBin = additionalBin;
    this.location = location;
    this.rawType = rawType;
  }
}
