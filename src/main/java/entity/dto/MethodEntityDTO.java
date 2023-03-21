package entity.dto;


public class MethodEntityDTO extends InternalEntityDTO {

  private String File;
  private AdditionalBinDTO additionalBin;
  private EnhancementDTO enhancement;
  private LocationDTO location;
  private String modifiers;
  private ParameterDTO parameter;
  private String rawType;

  private ICCMethodAttributeDTO iccMethodAttribute;

  public MethodEntityDTO(int parentId, String File, AdditionalBinDTO additionalBin, EnhancementDTO enhancement, LocationDTO location, String modifiers, ParameterDTO parameter, String rawType) {
    super(parentId, "Method");
    this.File = File;
    this.additionalBin = additionalBin;
    this.enhancement = enhancement;
    this.location = location;
    this.modifiers = modifiers;
    this.parameter = parameter;
    this.rawType = rawType;
  }

  public MethodEntityDTO(int id, String name, String qualifiedName, int parentId,
                         String File, AdditionalBinDTO additionalBin, EnhancementDTO enhancement,
                         LocationDTO location, String modifiers, ParameterDTO parameter, String rawType) {
    super(id, name, qualifiedName, parentId, "Method");
    this.File = File;
    this.additionalBin = additionalBin;
    this.enhancement = enhancement;
    this.location = location;
    this.modifiers = modifiers;
    this.parameter = parameter;
    this.rawType = rawType;
  }

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

  public EnhancementDTO getEnhancement() {
    return enhancement;
  }

  public void setEnhancement(EnhancementDTO enhancement) {
    this.enhancement = enhancement;
  }

  public LocationDTO getLocation() {
    return location;
  }

  public void setLocation(LocationDTO location) {
    this.location = location;
  }

  public String getModifiers() {
    return modifiers;
  }

  public void setModifiers(String modifiers) {
    this.modifiers = modifiers;
  }

  public ParameterDTO getParameter() {
    return parameter;
  }

  public void setParameter(ParameterDTO parameter) {
    this.parameter = parameter;
  }

  public String getRawType() {
    return rawType;
  }

  public void setRawType(String rawType) {
    this.rawType = rawType;
  }

  public void setIccMethodAttribute(ICCMethodAttributeDTO iccMethodAttribute) {
    this.iccMethodAttribute = iccMethodAttribute;
  }

  public ICCMethodAttributeDTO getIccMethodAttribute() {
    return iccMethodAttribute;
  }
}
