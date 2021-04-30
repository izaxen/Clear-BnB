package models;

import nosqlite.annotations.Document;
import nosqlite.annotations.Id;

import java.util.Date;

@Document
public class BookingReceipt {

    @Id
    private String id;
    private String rentalObjectId;
    private String userId;
    private String checkInTime;
    private String checkOutTime;
    private Date startDate;
    private Date endDate;
    private int numAdult;
    private int numChild;
    private int totalPrice;

    private BookingReceipt(){

    }

    public BookingReceipt(String id, String rentalObjectId, String userId,
                          Date startDate, Date endDate, int numAdult,
                          int numChild, int totalPrice) {
        this.id = id;
        this.rentalObjectId = rentalObjectId;
        this.userId = userId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.numAdult = numAdult;
        this.numChild = numChild;
        this.totalPrice = totalPrice;
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRentalObjectId() {
        return rentalObjectId;
    }

    public void setRentalObjectId(String rentalObjectId) {
        this.rentalObjectId = rentalObjectId;
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

    public int getNumAdult() {
        return numAdult;
    }

    public void setNumAdult(int numAdult) {
        this.numAdult = numAdult;
    }

    public int getNumChild() {
        return numChild;
    }

    public void setNumChild(int numChild) {
        this.numChild = numChild;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "BookingRecipe{" +
                "id='" + id + '\'' +
                ", houseId='" + rentalObjectId + '\'' +
                ", userId='" + userId + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", numAdult=" + numAdult +
                ", numChild=" + numChild +
                ", totalPrice=" + totalPrice +
                '}';
    }
}
