package entity.json;

import java.util.List;
import java.util.Map;

public class RootEntity {

  private String schemaVersion;
  private List<BaseEntity> variables;
  private List<Cell> cells;
  private Map<String, Integer> entityNum;
  private List<EntityCategory> categories;
  private Map<String, Integer> relationNum;

  public RootEntity() {
  }

  public RootEntity(String schemaVersion, List<BaseEntity> variables, List<Cell> cells, Map<String, Integer> entityNum, List<EntityCategory> categories, Map<String, Integer> relationNum) {
    this.schemaVersion = schemaVersion;
    this.variables = variables;
    this.cells = cells;
    this.entityNum = entityNum;
    this.categories = categories;
    this.relationNum = relationNum;
  }

  public String getSchemaVersion() {
    return schemaVersion;
  }

  public void setSchemaVersion(String schemaVersion) {
    this.schemaVersion = schemaVersion;
  }

  public List<BaseEntity> getVariables() {
    return variables;
  }

  public void setVariables(List<BaseEntity> variables) {
    this.variables = variables;
  }

  public List<Cell> getCells() {
    return cells;
  }

  public void setCells(List<Cell> cells) {
    this.cells = cells;
  }

  public Map<String, Integer> getEntityNum() {
    return entityNum;
  }

  public void setEntityNum(Map<String, Integer> entityNum) {
    this.entityNum = entityNum;
  }

  public List<EntityCategory> getCategories() {
    return categories;
  }

  public void setCategories(List<EntityCategory> categories) {
    this.categories = categories;
  }

  public Map<String, Integer> getRelationNum() {
    return relationNum;
  }

  public void setRelationNum(Map<String, Integer> relationNum) {
    this.relationNum = relationNum;
  }
}
