package entity.json;

import java.util.Map;

public class Cell {

  public static class Values {
    private Location loc;
    public Integer Import;
    public Integer Inherit;
    public Integer Call_non_dynamic;
    public Integer Reflect;
    public Integer Set;
    public Integer Call;
    public Integer UseVar;
    public Integer bindVar;
    public Integer Parameter;
    public Integer Cast;
    public Integer Modify;
    public Integer Implement;
    public Integer Override;
    public Integer Annotate;
    public Integer Contain;
    public Integer Define;
    public Integer Typed;

    public Values(Location loc) {
      this.loc = loc;
      this.Import = null;
      this.Inherit = null;
      this.Call_non_dynamic = null;
      this.Reflect = null;
      this.Set = null;
      this.Call = null;
      this.UseVar = null;
      this.bindVar = null;
      this.Parameter = null;
      this.Cast = null;
      this.Modify = null;
      this.Implement = null;
      this.Override = null;
      this.Annotate = null;
      this.Contain = null;
      this.Define = null;
      this.Typed = null;
    }
  }

  private int src;
  private int dest;
  private Values values;

  public Cell() {
  }

  public Cell(int src, int dest, Values values) {
    this.src = src;
    this.dest = dest;
    this.values = values;
  }

  public int getSrc() {
    return src;
  }

  public void setSrc(int src) {
    this.src = src;
  }

  public int getDest() {
    return dest;
  }

  public void setDest(int dest) {
    this.dest = dest;
  }

  public Values getValues() {
    return values;
  }

  public void setValues(Values values) {
    this.values = values;
  }
}
