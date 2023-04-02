package entity.dto;

public class RootXY {
    int methodID;
    int rootX;
    int rootY;

    LocationDTO location;



    public int getMethodID() {
        return methodID;
    }

    public void setMethodID(int methodID) {
        this.methodID = methodID;
    }

    public int getRootX() {
        return rootX;
    }

    public void setRootX(int rootX) {
        this.rootX = rootX;
    }

    public int getRootY() {
        return rootY;
    }

    public void setRootY(int rootY) {
        this.rootY = rootY;
    }

    public LocationDTO getLocation() {
        return location;
    }

    public void setLocation(LocationDTO location) {
        this.location = location;
    }
}
