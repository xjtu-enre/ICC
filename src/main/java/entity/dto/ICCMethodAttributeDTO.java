package entity.dto;

public class ICCMethodAttributeDTO {
    private boolean isSend;
    private boolean isReceive;
    private String machanismType;

    public boolean isSend() {
        return isSend;
    }

    public void setSend(boolean send) {
        isSend = send;
    }

    public boolean isReceive() {
        return isReceive;
    }

    public void setReceive(boolean receive) {
        isReceive = receive;
    }

    public String getMachanismType() {
        return machanismType;
    }

    public void setMachanismType(String machanismType) {
        this.machanismType = machanismType;
    }
}
