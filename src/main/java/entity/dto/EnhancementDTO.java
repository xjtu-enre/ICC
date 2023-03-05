package entity.dto;

public class EnhancementDTO {

  private Boolean isGetter;
  private Boolean isRecursive;
  private Boolean isStatic;
  private Boolean isConstructor;
  private Boolean isOverride;
  private Boolean isSetter;
  private Boolean isPublic;
  private Boolean isDelegator;
  private Boolean isSynchronized;
  private Boolean isAbstract;

  public EnhancementDTO(Boolean isGetter, Boolean isRecursive, Boolean isStatic, Boolean isConstructor, Boolean isOverride, Boolean isSetter, Boolean isPublic, Boolean isDelegator, Boolean isSynchronized, Boolean isAbstract) {
    this.isGetter = isGetter;
    this.isRecursive = isRecursive;
    this.isStatic = isStatic;
    this.isConstructor = isConstructor;
    this.isOverride = isOverride;
    this.isSetter = isSetter;
    this.isPublic = isPublic;
    this.isDelegator = isDelegator;
    this.isSynchronized = isSynchronized;
    this.isAbstract = isAbstract;
  }

  public Boolean getGetter() {
    return isGetter;
  }

  public void setGetter(Boolean getter) {
    isGetter = getter;
  }

  public Boolean getRecursive() {
    return isRecursive;
  }

  public void setRecursive(Boolean recursive) {
    isRecursive = recursive;
  }

  public Boolean getStatic() {
    return isStatic;
  }

  public void setStatic(Boolean aStatic) {
    isStatic = aStatic;
  }

  public Boolean getConstructor() {
    return isConstructor;
  }

  public void setConstructor(Boolean constructor) {
    isConstructor = constructor;
  }

  public Boolean getOverride() {
    return isOverride;
  }

  public void setOverride(Boolean override) {
    isOverride = override;
  }

  public Boolean getSetter() {
    return isSetter;
  }

  public void setSetter(Boolean setter) {
    isSetter = setter;
  }

  public Boolean getPublic() {
    return isPublic;
  }

  public void setPublic(Boolean aPublic) {
    isPublic = aPublic;
  }

  public Boolean getDelegator() {
    return isDelegator;
  }

  public void setDelegator(Boolean delegator) {
    isDelegator = delegator;
  }

  public Boolean getSynchronized() {
    return isSynchronized;
  }

  public void setSynchronized(Boolean aSynchronized) {
    isSynchronized = aSynchronized;
  }

  public Boolean getAbstract() {
    return isAbstract;
  }

  public void setAbstract(Boolean anAbstract) {
    isAbstract = anAbstract;
  }
}
