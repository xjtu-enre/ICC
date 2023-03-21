package entity.dto;

import org.json.JSONPropertyName;

public class EnumConstantEntityDTO extends InternalEntityDTO {

  private String File;
  private AdditionalBinDTO additionalBin;

  public EnumConstantEntityDTO(int parentId, String File, AdditionalBinDTO additionalBin) {
    super(parentId, "Enum Constant");
    this.File = File;
    this.additionalBin = additionalBin;
  }

  public EnumConstantEntityDTO(int id, String name, String qualifiedName, int parentId, String File, AdditionalBinDTO additionalBin) {
    super(id, name, qualifiedName, parentId, "Enum Constant");
    this.File = File;
    this.additionalBin = additionalBin;
  }

  @JSONPropertyName("File")
  public String getFile() {
    return File;
  }

  public void setFile(String File) {
    this.File = File;
  }

  public AdditionalBinDTO getAdditionalBin() {
    return additionalBin;
  }

  public void setAdditionalBin(AdditionalBinDTO additionalBin) {
    this.additionalBin = additionalBin;
  }
}
