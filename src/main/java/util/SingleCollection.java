package util;

import entity.dto.EnreDTO;
import entity.dto.MethodEntityDTO;
import entity.json.RootEntity;
import org.eclipse.jdt.core.dom.IMethodBinding;

import java.util.HashMap;
import java.util.Map;

public class SingleCollection {

  private RootEntity root;
  private Map<MethodEntityKey, MethodEntityDTO> methodEntityMap;
  private Map<IMethodBinding, Integer> methodBindingIDMap = new HashMap<>();
  private static SingleCollection singleton = null;

  // new
  private EnreDTO enre;

  private SingleCollection() {
    methodEntityMap = new HashMap<>();
  }

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

  public RootEntity getRoot() {
    return root;
  }

  public void setRoot(RootEntity root) {
    this.root = root;
  }

  public Map<MethodEntityKey, MethodEntityDTO> getMethodEntityMap() {
    return methodEntityMap;
  }

  public void setMethodEntityMap(Map<MethodEntityKey, MethodEntityDTO> methodEntityMap) {
    this.methodEntityMap = methodEntityMap;
  }

  public Map<IMethodBinding, Integer> getMethodBindingIDMap() {
    return methodBindingIDMap;
  }

  public void setMethodBindingIDMap(Map<IMethodBinding, Integer> methodBindingIDMap) {
    this.methodBindingIDMap = methodBindingIDMap;
  }
}
