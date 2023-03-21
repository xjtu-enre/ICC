package entity.dto;

import org.json.JSONPropertyName;

import java.util.List;

public class ClassEntityDTO extends InternalEntityDTO {

  private String File;
  private AdditionalBinDTO additionalBin;
  private Integer anonymousBindVar;
  private Integer anonymousRank;
  private List<Integer> innerType;
  private LocationDTO location;
  private String modifiers;
  private String rawType;

  private ComponentDTO ICCcomponent;



  public ClassEntityDTO(int id, String name, String qualifiedName, int parentId,
                        String rawType, LocationDTO location, String modifiers,
                        int anonymousRank, int anonymousBindVar, String File, AdditionalBinDTO additionalBin) {
    super(id, name, qualifiedName, parentId, "Class");
    this.rawType = rawType;
    this.location = location;
    this.modifiers = modifiers;
    this.File = File;
    this.additionalBin = additionalBin;
    this.anonymousRank = anonymousRank;
    this.anonymousBindVar = anonymousBindVar;
  }

  public ClassEntityDTO(int id, String name, String qualifiedName, int parentId,
                        String rawType, LocationDTO location, String modifiers,
                        String File, AdditionalBinDTO additionalBin, List<Integer> innerType
  ) {
    super(id, name, qualifiedName, parentId, "Class");
    this.rawType = rawType;
    this.location = location;
    this.modifiers = modifiers;
    this.File = File;
    this.additionalBin = additionalBin;
    this.innerType = innerType;
  }

  public ClassEntityDTO(int parentId, String category) {
    super(parentId, category);
  }

  public ClassEntityDTO(int id, String name, String qualifiedName, int parentId, String category) {
    super(id, name, qualifiedName, parentId, category);
  }

  public ComponentDTO getComponent() {
    return ICCcomponent;
  }

  public void setComponent(ComponentDTO component) {
    this.ICCcomponent = component;
  }

  @JSONPropertyName("File")
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

  public Integer getAnonymousBindVar() {
    return anonymousBindVar;
  }

  public void setAnonymousBindVar(Integer anonymousBindVar) {
    this.anonymousBindVar = anonymousBindVar;
  }

  public Integer getAnonymousRank() {
    return anonymousRank;
  }

  public void setAnonymousRank(Integer anonymousRank) {
    this.anonymousRank = anonymousRank;
  }

  public List<Integer> getInnerType() {
    return innerType;
  }

  public void setInnerType(List<Integer> innerType) {
    this.innerType = innerType;
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

  public String getRawType() {
    return rawType;
  }

  public void setRawType(String rawType) {
    this.rawType = rawType;
  }

  public ComponentDTO getICCcomponent() {
    return ICCcomponent;
  }

  public void setICCcomponent(ComponentDTO ICCcomponent) {
    this.ICCcomponent = ICCcomponent;
  }
}
