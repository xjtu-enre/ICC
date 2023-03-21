package entity.dto;

import java.util.Map;
import java.util.HashMap;

public class ValuesDTO {

  private LocationDTO loc;

  private String iccMechanism;
  private String iccCategory;
  private Map<String, Integer> relationMap = new HashMap<>();

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
