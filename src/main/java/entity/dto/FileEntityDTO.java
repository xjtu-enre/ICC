package entity.dto;

public class FileEntityDTO extends InternalEntityDTO {

  private String file;
  private AdditionalBinDTO additionalBin;

  public FileEntityDTO(int parentId, String file, AdditionalBinDTO additionalBin) {
    super(parentId, "File");
    this.file = file;
    this.additionalBin = additionalBin;
  }

  public FileEntityDTO(int id, String name, String qualifiedName, int parentId, String file, AdditionalBinDTO additionalBin) {
    super(id, name, qualifiedName, parentId, "File");
    this.file = file;
    this.additionalBin = additionalBin;
  }
}
