package entity.dto;

public class TypeParameterEntityDTO extends InternalEntityDTO {

  private String file;
  private AdditionalBinDTO additionalBin;
  private LocationDTO location;
  private String rawType;

  public TypeParameterEntityDTO(int id, String name, String qualifiedName, int parentId,
      String file, AdditionalBinDTO additionalBin, LocationDTO location, String rawType) {
    super(id, name, qualifiedName, parentId, "Type Parameter");
    this.file = file;
    this.additionalBin = additionalBin;
    this.location = location;
    this.rawType = rawType;
  }

  public String getFile() {
    return this.file;
  }

  public void setFile(String file) {
    this.file = file;
  }
}
