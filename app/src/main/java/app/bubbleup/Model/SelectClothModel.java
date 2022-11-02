package app.bubbleup.Model;

public class SelectClothModel {

    public int image;
    public String name;
    public String delivery;
    public String time;

    public SelectClothModel(int image, String name, String delivery, String time) {
        this.image = image;
        this.name = name;
        this.delivery = delivery;
        this.time = time;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDelivery() {
        return delivery;
    }

    public void setDelivery(String delivery) {
        this.delivery = delivery;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
