package models;

import nosqlite.annotations.Id;

public class Amenity {

    @Id
    private String id;
    private String text;
    private String iconUrl;

    public Amenity() {
    }

    @Override
    public String toString() {
        return "Amenity{" +
               "id='" + id + '\'' +
               ", text='" + text + '\'' +
               ", iconUrl='" + iconUrl + '\'' +
               '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

}
