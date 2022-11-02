package app.bubbleup.Model;

public class BookingModel {

    public int img;
    public String name;
    public String pickup;
    public String delivered;

    public BookingModel(int img, String name, String pickup, String delivered) {
        this.img = img;
        this.name = name;
        this.pickup = pickup;
        this.delivered = delivered;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPickup() {
        return pickup;
    }

    public void setPickup(String pickup) {
        this.pickup = pickup;
    }

    public String getDelivered() {
        return delivered;
    }

    public void setDelivered(String delivered) {
        this.delivered = delivered;
    }
}
