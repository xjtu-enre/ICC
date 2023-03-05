package util;

public class MethodEntityKey {

  private String qualifiedName;
  private int startLine;
  private int startColumn;

  public MethodEntityKey() {
  }

  public MethodEntityKey(String qualifiedName, int startLine, int startColumn) {
    this.qualifiedName = qualifiedName;
    this.startLine = startLine;
    this.startColumn = startColumn;
  }

  public String getQualifiedName() {
    return qualifiedName;
  }

  public void setQualifiedName(String qualifiedName) {
    this.qualifiedName = qualifiedName;
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

  @Override
  public int hashCode() {
    return (this.qualifiedName + this.startColumn + this.startLine).hashCode();
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == null) {
      return false;
    }
    if (!(obj instanceof MethodEntityKey)) {
      return false;
    }
    MethodEntityKey another = (MethodEntityKey) obj;
    return this.hashCode() == another.hashCode();
  }

  @Override
  public String toString() {
    return "MethodEntityKey{" +
      "qualifiedName='" + qualifiedName + '\'' +
      ", startLine=" + startLine +
      ", startColumn=" + startColumn +
      '}';
  }
}
