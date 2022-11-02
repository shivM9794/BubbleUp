package app.bubbleup.Model;

public class ShopModel {

    public String name="";
    public String address;
    public String time;
    public int image;

    public ShopModel(String name, String address, String time, int image) {
        this.name = name;
        this.address = address;
        this.time = time;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
