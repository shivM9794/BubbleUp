package app.bubbleup.Model;

public class Service {

    public int image;
    public String service_name;
    public String sub_cat;

    public Service(int image, String service_name, String sub_cat) {
        this.image = image;
        this.service_name = service_name;
        this.sub_cat = sub_cat;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getService_name() {
        return service_name;
    }

    public void setService_name(String service_name) {
        this.service_name = service_name;
    }

    public String getSub_cat() {
        return sub_cat;
    }

    public void setSub_cat(String sub_cat) {
        this.sub_cat = sub_cat;
    }
}
