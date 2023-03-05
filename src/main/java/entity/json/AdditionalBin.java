package entity.json;

public class AdditionalBin {

  private int binNum;
  private String binPath;

  public AdditionalBin() {
  }

  public AdditionalBin(int binNum, String binPath) {
    this.binNum = binNum;
    this.binPath = binPath;
  }

  public int getBinNum() {
    return binNum;
  }

  public void setBinNum(int binNum) {
    this.binNum = binNum;
  }

  public String getBinPath() {
    return binPath;
  }

  public void setBinPath(String binPath) {
    this.binPath = binPath;
  }
}
