package models;

import nosqlite.annotations.Document;
import nosqlite.annotations.Id;

import java.util.Date;
import java.util.List;

@Document
public class RentalObject {

    @Id
    private String id;
    private String userId;
    private Date availableFrom;
    private Date availableTo;
    private String freeText;
    private String description;
    private String city;
    private int availableBeds;
    private int adultPrice;
    private int childPrice;
    private List<Amenity> amenities;

    public RentalObject() {
    }

    @Override
    public String toString() {
        return "RentalObject{" +
                "id='" + id + '\'' +
                ", userId='" + userId + '\'' +
                ", availableFrom=" + availableFrom +
                ", availableTo=" + availableTo +
                ", freeText='" + freeText + '\'' +
                ", description='" + description + '\'' +
                ", city='" + city + '\'' +
                ", availableBeds=" + availableBeds +
                ", adultPrice=" + adultPrice +
                ", childPrice=" + childPrice +
                ", amenities=" + amenities +
                '}';
    }

    public int getAdultPrice() {
        return adultPrice;
    }

    public void setAdultPrice(int adultPrice) {
        this.adultPrice = adultPrice;
    }

    public int getChildPrice() {
        return childPrice;
    }

    public void setChildPrice(int childPrice) {
        this.childPrice = childPrice;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getFreeText() {
        return freeText;
    }

    public void setFreeText(String freeText) {
        this.freeText = freeText;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getAvailableBeds() {
        return availableBeds;
    }

    public void setAvailableBeds(int availableBeds) {
        this.availableBeds = availableBeds;
    }

    public List<Amenity> getAmenities() {
        return amenities;
    }

    public void setAmenities(List<Amenity> amenities) {
        this.amenities = amenities;
    }

    public Date getAvailableFrom() {
        return availableFrom;
    }

    public void setAvailableFrom(Date availableFrom) {
        this.availableFrom = availableFrom;
    }

    public Date getAvailableTo() {
        return availableTo;
    }

    public void setAvailableTo(Date availableTo) {
        this.availableTo = availableTo;
    }

}
