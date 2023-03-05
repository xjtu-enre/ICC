package entity.dto;

public class MethodCallDTO {

  private int src;
  private int dest;
  private String type;

  public MethodCallDTO() {
  }

  public MethodCallDTO(int src, int dest, String type) {
    this.src = src;
    this.dest = dest;
    this.type = type;
  }

  public void setSrc(int src) {
    this.src = src;
  }

  public void setDest(int dest) {
    this.dest = dest;
  }

  public void setType(String type) {
    this.type = type;
  }

  public int getSrc() {
    return this.src;
  }

  public int getDest() {
    return this.dest;
  }

  public String getType() {
    return this.type;
  }
}
