package app.bubbleup.Model;

public class ServiceModel {

    public String name="";
    public int image;
    public String category="";

    public ServiceModel(String name, int image, String category) {
        this.name = name;
        this.image = image;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
