package entity.dto;

public class EnumConstantEntityDTO extends InternalEntityDTO {

  private String file;
  private AdditionalBinDTO additionalBin;

  public EnumConstantEntityDTO(int parentId, String file, AdditionalBinDTO additionalBin) {
    super(parentId, "Enum Constant");
    this.file = file;
    this.additionalBin = additionalBin;
  }

  public EnumConstantEntityDTO(int id, String name, String qualifiedName, int parentId, String file, AdditionalBinDTO additionalBin) {
    super(id, name, qualifiedName, parentId, "Enum Constant");
    this.file = file;
    this.additionalBin = additionalBin;
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
}
