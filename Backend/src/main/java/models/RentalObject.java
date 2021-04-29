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
    private Date startDate;
    private Date endDate;
    private String checkInTime;
    private String checkOutTime;
    private String freeText;
    private String description;
    private String city;
    private int availableBeds;
    private int price;
    private List<Amenity> amenities;

    public RentalObject() {
    }

    @Override
    public String toString() {
        return "RentalObject{" +
               "id='" + id + '\'' +
               ", userId='" + userId + '\'' +
               ", startDate=" + startDate +
               ", endDate=" + endDate +
               ", checkInTime='" + checkInTime + '\'' +
               ", checkOutTime='" + checkOutTime + '\'' +
               ", freeText='" + freeText + '\'' +
               ", description='" + description + '\'' +
               ", city='" + city + '\'' +
               ", availableBeds=" + availableBeds +
               ", price=" + price +
               ", amenities=" + amenities +
               '}';
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

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getCheckInTime() {
        return checkInTime;
    }

    public void setCheckInTime(String checkInTime) {
        this.checkInTime = checkInTime;
    }

    public String getCheckOutTime() {
        return checkOutTime;
    }

    public void setCheckOutTime(String checkOutTime) {
        this.checkOutTime = checkOutTime;
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public List<Amenity> getAmenities() {
        return amenities;
    }

    public void setAmenities(List<Amenity> amenities) {
        this.amenities = amenities;
    }

}
