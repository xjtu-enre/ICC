package entity.dto;

public class TypeParameterEntityDTO extends InternalEntityDTO {

  private String File;
  private AdditionalBinDTO additionalBin;
  private LocationDTO location;
  private String rawType;

  public TypeParameterEntityDTO(int id, String name, String qualifiedName, int parentId,
      String File, AdditionalBinDTO additionalBin, LocationDTO location, String rawType) {
    super(id, name, qualifiedName, parentId, "Type Parameter");
    this.File = File;
    this.additionalBin = additionalBin;
    this.location = location;
    this.rawType = rawType;
  }

  public String getFile() {
    return this.File;
  }

  public void setFile(String File) {
    this.File = File;
  }
}
