package entity.dto;

import java.util.List;

public class ClassEntityDTO extends InternalEntityDTO {

  private String file;
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
                        int anonymousRank, int anonymousBindVar, String file, AdditionalBinDTO additionalBin) {
    super(id, name, qualifiedName, parentId, "Class");
    this.rawType = rawType;
    this.location = location;
    this.modifiers = modifiers;
    this.file = file;
    this.additionalBin = additionalBin;
    this.anonymousRank = anonymousRank;
    this.anonymousBindVar = anonymousBindVar;
  }

  public ClassEntityDTO(int id, String name, String qualifiedName, int parentId,
                        String rawType, LocationDTO location, String modifiers,
                        String file, AdditionalBinDTO additionalBin, List<Integer> innerType
  ) {
    super(id, name, qualifiedName, parentId, "Class");
    this.rawType = rawType;
    this.location = location;
    this.modifiers = modifiers;
    this.file = file;
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
}
