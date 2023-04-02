package util;

import entity.dto.EnreDTO;

import java.util.HashMap;
import java.util.Map;

public class SingleCollection {

  //private Map<MethodEntityKey, MethodEntityDTO> methodEntityMap;
  //private Map<IMethodBinding, Integer> methodBindingIDMap = new HashMap<>();
  private Map<Integer, String> idToQualifiedNameMap = new HashMap<Integer, String>();
  private static SingleCollection singleton = null;

  // new
  private EnreDTO enre;

  //private SingleCollection() {methodEntityMap = new HashMap<>();}

  public EnreDTO getEnreDTO() {
    return this.enre;
  }

  public void setEnreDTO(EnreDTO enre) {
    this.enre = enre;
  }

  public static SingleCollection getInstance() {
    if (singleton == null) {
      singleton = new SingleCollection();
    }
    return singleton;
  }

  public Map<Integer, String> getIdToQualifiedNameMap() {
    return idToQualifiedNameMap;
  }

  public void setIdToQualifiedNameMap(Map<Integer, String> idToQualifiedNameMap) {
    this.idToQualifiedNameMap = idToQualifiedNameMap;
  }

  //public Map<MethodEntityKey, MethodEntityDTO> getMethodEntityMap() {return methodEntityMap;}

  //public void setMethodEntityMap(Map<MethodEntityKey, MethodEntityDTO> methodEntityMap) {this.methodEntityMap = methodEntityMap;}

  //public Map<IMethodBinding, Integer> getMethodBindingIDMap() {return methodBindingIDMap;}

  //public void setMethodBindingIDMap(Map<IMethodBinding, Integer> methodBindingIDMap) {this.methodBindingIDMap = methodBindingIDMap;}
}
