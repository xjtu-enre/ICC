package entity.json;

public class Enhancement {

  private boolean isGetter;
  private boolean isRecursive;
  private boolean isStatic;
  private boolean isConstructor;
  private boolean isOverride;
  private boolean isSetter;
  private boolean isPublic;
  private boolean isDelegator;
  private boolean isSynchronized;
  private boolean isAbstract;

  public Enhancement() {
  }

  public Enhancement(boolean isGetter, boolean isRecursive, boolean isStatic, boolean isConstructor, boolean isOverride, boolean isSetter, boolean isPublic, boolean isDelegator, boolean isSynchronized, boolean isAbstract) {
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

  public boolean isGetter() {
    return isGetter;
  }

  public void setGetter(boolean getter) {
    isGetter = getter;
  }

  public boolean isRecursive() {
    return isRecursive;
  }

  public void setRecursive(boolean recursive) {
    isRecursive = recursive;
  }

  public boolean isStatic() {
    return isStatic;
  }

  public void setStatic(boolean aStatic) {
    isStatic = aStatic;
  }

  public boolean isConstructor() {
    return isConstructor;
  }

  public void setConstructor(boolean constructor) {
    isConstructor = constructor;
  }

  public boolean isOverride() {
    return isOverride;
  }

  public void setOverride(boolean override) {
    isOverride = override;
  }

  public boolean isSetter() {
    return isSetter;
  }

  public void setSetter(boolean setter) {
    isSetter = setter;
  }

  public boolean isPublic() {
    return isPublic;
  }

  public void setPublic(boolean aPublic) {
    isPublic = aPublic;
  }

  public boolean isDelegator() {
    return isDelegator;
  }

  public void setDelegator(boolean delegator) {
    isDelegator = delegator;
  }

  public boolean isSynchronized() {
    return isSynchronized;
  }

  public void setSynchronized(boolean aSynchronized) {
    isSynchronized = aSynchronized;
  }

  public boolean isAbstract() {
    return isAbstract;
  }

  public void setAbstract(boolean anAbstract) {
    isAbstract = anAbstract;
  }
}
