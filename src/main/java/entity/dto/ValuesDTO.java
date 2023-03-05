package entity.dto;

import java.util.Map;
import java.util.HashMap;

public class ValuesDTO {

  private LocationDTO loc;

  private String iccMechanism;
  private String iccCategory;
  private Map<String, Integer> relationMap = new HashMap<>();
  private Integer Import;
  private Integer Inherit;
  private Integer Implement;
  private Integer Contain;
  private Integer Call;
  private Integer Parameter;
  private Integer Typed;
  private Integer UseVar;
  private Integer Set;
  private Integer Modify;
  private Integer Annotate;
  private Integer Cast;
  private Integer Override;
  private Integer Reflect;
  private Integer Define;
  private Integer ICC;



  public Map<String, Integer> getRelationMap() {
    return this.relationMap;
  }

  public ValuesDTO() {
  }

  public ValuesDTO(LocationDTO loc) {
    this.loc = loc;
  }

  public LocationDTO getLoc() {
    return loc;
  }

  public void setLoc(LocationDTO loc) {
    this.loc = loc;
  }

  public Integer getImport() {
    return Import;
  }

  public void setImport(Integer anImport) {
    Import = anImport;
  }

  public Integer getInherit() {
    return Inherit;
  }

  public void setInherit(Integer inherit) {
    Inherit = inherit;
  }

  public Integer getImplement() {
    return Implement;
  }

  public void setImplement(Integer implement) {
    Implement = implement;
  }

  public Integer getContain() {
    return Contain;
  }

  public void setContain(Integer contain) {
    Contain = contain;
  }

  public Integer getCall() {
    return Call;
  }

  public void setCall(Integer call) {
    Call = call;
  }

  public Integer getParameter() {
    return Parameter;
  }

  public void setParameter(Integer parameter) {
    Parameter = parameter;
  }

  public Integer getTyped() {
    return Typed;
  }

  public void setTyped(Integer typed) {
    Typed = typed;
  }

  public Integer getUseVar() {
    return UseVar;
  }

  public void setUseVar(Integer useVar) {
    UseVar = useVar;
  }

  public Integer getSet() {
    return Set;
  }

  public void setSet(Integer set) {
    Set = set;
  }

  public Integer getModify() {
    return Modify;
  }

  public void setModify(Integer modify) {
    Modify = modify;
  }

  public Integer getAnnotate() {
    return Annotate;
  }

  public void setAnnotate(Integer annotate) {
    Annotate = annotate;
  }

  public Integer getCast() {
    return Cast;
  }

  public void setCast(Integer cast) {
    Cast = cast;
  }

  public Integer getOverride() {
    return Override;
  }

  public void setOverride(Integer override) {
    Override = override;
  }

  public Integer getReflect() {
    return Reflect;
  }

  public void setReflect(Integer reflect) {
    Reflect = reflect;
  }

  public Integer getDefine() {
    return Define;
  }

  public void setDefine(Integer define) {
    Define = define;
  }

  public Integer getICC() {
    return ICC;
  }

  public void setICC(Integer icc) {
    ICC = icc;
  }

  public String getIccMechanism() {
    return iccMechanism;
  }

  public void setIccMechanism(String iccMechanism) {
    this.iccMechanism = iccMechanism;
  }

  public String getIccCategory() {
    return iccCategory;
  }

  public void setIccCategory(String iccCategory) {
    this.iccCategory = iccCategory;
  }
}
