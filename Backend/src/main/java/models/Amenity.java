package models;

import nosqlite.annotations.Document;
import nosqlite.annotations.Id;
@Document
public class Amenity {

    @Id
    private String id;
    private String title;
    private String iconUrl;

    public Amenity() {
    }

    @Override
    public String toString() {
        return "Amenity{" +
               "id='" + id + '\'' +
               ", text='" + title + '\'' +
               ", iconUrl='" + iconUrl + '\'' +
               '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

}
