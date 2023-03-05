package entity.dto;

public class VariableEntityDTO extends InternalEntityDTO {

  private String file;
  private AdditionalBinDTO additionalBin;
  private boolean global;
  private LocationDTO location;
  private String modifiers;
  private String rawType;

  private ICCVariableAttributeDTO iccVariableAttribute;

  public VariableEntityDTO(int id, String name, String qualifiedName, int parentId, 
      String file, AdditionalBinDTO additionalBin, boolean global, LocationDTO location, 
      String modifiers, String rawType) {
    super(id, name, qualifiedName, parentId, "Variable");
    this.file = file;
    this.additionalBin = additionalBin;
    this.global = global;
    this.location = location;
    this.modifiers = modifiers;
    this.rawType = rawType;
  }

  public String getFile() {
    return this.file;
  }

  public void setFile(String file) {
    this.file = file;
  }

  public String getRawType() {
    return rawType;
  }

  public void setRawType(String rawType) {
    this.rawType = rawType;
  }

  public ICCVariableAttributeDTO getIccVariableAttribute() {
    return iccVariableAttribute;
  }

  public void setIccVariableAttribute(ICCVariableAttributeDTO iccVariableAttribute) {
    this.iccVariableAttribute = iccVariableAttribute;
  }
}
