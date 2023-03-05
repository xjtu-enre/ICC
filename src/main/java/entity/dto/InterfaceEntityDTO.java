package entity.dto;

public class InterfaceEntityDTO extends InternalEntityDTO {

  private String file;
  private AdditionalBinDTO additionalBin;
  private LocationDTO location;
  private String modifiers;
  private String rawType;

  public InterfaceEntityDTO(int parentId, String file, AdditionalBinDTO additionalBin, LocationDTO location, String modifiers, String rawType) {
    super(parentId, "Interface");
    this.file = file;
    this.additionalBin = additionalBin;
    this.location = location;
    this.modifiers = modifiers;
    this.rawType = rawType;
  }

  public InterfaceEntityDTO(int id, String name, String qualifiedName, int parentId, String file, AdditionalBinDTO additionalBin, LocationDTO location, String modifiers, String rawType) {
    super(id, name, qualifiedName, parentId, "Interface");
    this.file = file;
    this.additionalBin = additionalBin;
    this.location = location;
    this.modifiers = modifiers;
    this.rawType = rawType;
  }
}
