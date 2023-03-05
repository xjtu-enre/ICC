package entity.json;

import java.util.List;

public class Parameter {

  private String types;
  private String names;

  public Parameter() {
  }

  public Parameter(String types, String names) {
    this.types = types;
    this.names = names;
  }

  public String getTypes() {
    return types;
  }

  public void setTypes(String types) {
    this.types = types;
  }

  public String getNames() {
    return names;
  }

  public void setNames(String names) {
    this.names = names;
  }
}
