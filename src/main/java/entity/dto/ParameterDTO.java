package entity.dto;

public class ParameterDTO {
  private String types;
  private String names;

  public ParameterDTO(String types, String names) {
    this.types = types;
    this.names = names;
  }

  public ParameterDTO() {
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
