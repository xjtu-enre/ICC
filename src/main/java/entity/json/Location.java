package entity.json;

public class Location {

  private int endLine;
  private int endColumn;
  private int startLine;
  private int startColumn;

  public Location() {
  }

  public Location(int endLine, int endColumn, int startLine, int startColumn) {
    this.endLine = endLine;
    this.endColumn = endColumn;
    this.startLine = startLine;
    this.startColumn = startColumn;
  }

  public int getEndLine() {
    return endLine;
  }

  public void setEndLine(int endLine) {
    this.endLine = endLine;
  }

  public int getEndColumn() {
    return endColumn;
  }

  public void setEndColumn(int endColumn) {
    this.endColumn = endColumn;
  }

  public int getStartLine() {
    return startLine;
  }

  public void setStartLine(int startLine) {
    this.startLine = startLine;
  }

  public int getStartColumn() {
    return startColumn;
  }

  public void setStartColumn(int startColumn) {
    this.startColumn = startColumn;
  }
}
