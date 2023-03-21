package entity.dto;

public class FileEntityDTO extends InternalEntityDTO {

  private String File;
  private AdditionalBinDTO additionalBin;

  public FileEntityDTO(int parentId, String File, AdditionalBinDTO additionalBin) {
    super(parentId, "File");
    this.File = File;
    this.additionalBin = additionalBin;
  }

  public FileEntityDTO(int id, String name, String qualifiedName, int parentId, String File, AdditionalBinDTO additionalBin) {
    super(id, name, qualifiedName, parentId, "File");
    this.File = File;
    this.additionalBin = additionalBin;
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
}
