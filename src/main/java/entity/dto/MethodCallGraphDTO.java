package entity.dto;

import java.util.List;
import java.util.ArrayList;

public class MethodCallGraphDTO {

  private List<MethodCallDTO> mcg;

  public MethodCallGraphDTO() {
    this.mcg = new ArrayList<>();
  }

  public List<MethodCallDTO> getMcg() {
    return this.mcg;
  }
}
