package entity.dto;

import org.json.JSONPropertyName;

public class VariableEntityDTO extends InternalEntityDTO {

  private String File;
  private AdditionalBinDTO additionalBin;
  private boolean global;
  private LocationDTO location;
  private String modifiers;
  private String rawType;

  private ICCVariableAttributeDTO iccVariableAttribute;

  public VariableEntityDTO(int id, String name, String qualifiedName, int parentId, 
      String File, AdditionalBinDTO additionalBin, boolean global, LocationDTO location, 
      String modifiers, String rawType) {
    super(id, name, qualifiedName, parentId, "Variable");
    this.File = File;
    this.additionalBin = additionalBin;
    this.global = global;
    this.location = location;
    this.modifiers = modifiers;
    this.rawType = rawType;
  }

  @JSONPropertyName("File")
  public String getFile() {
    return this.File;
  }

  public void setFile(String File) {
    this.File = File;
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
