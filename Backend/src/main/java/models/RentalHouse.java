package models;

import nosqlite.annotations.Document;
import nosqlite.annotations.Id;

import java.util.Date;

@Document
public class RentalHouse {
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
    private boolean hasWifi;
    private boolean petsAllowed;
    private boolean hasChildChair;
    private boolean hasSmokeAlarm;
    private boolean hasTv;
    private boolean hasParking;
    private boolean hasFireExtinguisher;
    private boolean hasTravelBed;
    private boolean hasFireplace;
    private boolean hasHotWater;
    private boolean smokingAllowed;
    private boolean partyAllowed;


    public RentalHouse(){

    }

    public RentalHouse(String id, String userId, Date startDate, Date endDate,
                       String checkInTime, String checkOutTime, String freeText,
                       String description, String city, int availableBeds, int price,
                       boolean hasWifi, boolean petsAllowed, boolean hasChildChair,
                       boolean hasSmokeAlarm, boolean hasTv, boolean hasParking,
                       boolean hasFireExtinguisher, boolean hasTravelBed,
                       boolean hasFireplace, boolean hasHotWater, boolean smokingAllowed,
                       boolean partyAllowed) {
        this.id = id;
        this.userId = userId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.checkInTime = checkInTime;
        this.checkOutTime = checkOutTime;
        this.freeText = freeText;
        this.description = description;
        this.city = city;
        this.availableBeds = availableBeds;
        this.price = price;
        this.hasWifi = hasWifi;
        this.petsAllowed = petsAllowed;
        this.hasChildChair = hasChildChair;
        this.hasSmokeAlarm = hasSmokeAlarm;
        this.hasTv = hasTv;
        this.hasParking = hasParking;
        this.hasFireExtinguisher = hasFireExtinguisher;
        this.hasTravelBed = hasTravelBed;
        this.hasFireplace = hasFireplace;
        this.hasHotWater = hasHotWater;
        this.smokingAllowed = smokingAllowed;
        this.partyAllowed = partyAllowed;
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

    public boolean isHasWifi() {
        return hasWifi;
    }

    public void setHasWifi(boolean hasWifi) {
        this.hasWifi = hasWifi;
    }

    public boolean isPetsAllowed() {
        return petsAllowed;
    }

    public void setPetsAllowed(boolean petsAllowed) {
        this.petsAllowed = petsAllowed;
    }

    public boolean isHasChildChair() {
        return hasChildChair;
    }

    public void setHasChildChair(boolean hasChildChair) {
        this.hasChildChair = hasChildChair;
    }

    public boolean isHasSmokeAlarm() {
        return hasSmokeAlarm;
    }

    public void setHasSmokeAlarm(boolean hasSmokeAlarm) {
        this.hasSmokeAlarm = hasSmokeAlarm;
    }

    public boolean isHasTv() {
        return hasTv;
    }

    public void setHasTv(boolean hasTv) {
        this.hasTv = hasTv;
    }

    public boolean isHasParking() {
        return hasParking;
    }

    public void setHasParking(boolean hasParking) {
        this.hasParking = hasParking;
    }

    public boolean isHasFireExtinguisher() {
        return hasFireExtinguisher;
    }

    public void setHasFireExtinguisher(boolean hasFireExtinguisher) {
        this.hasFireExtinguisher = hasFireExtinguisher;
    }

    public boolean isHasTravelBed() {
        return hasTravelBed;
    }

    public void setHasTravelBed(boolean hasTravelBed) {
        this.hasTravelBed = hasTravelBed;
    }

    public boolean isHasFireplace() {
        return hasFireplace;
    }

    public void setHasFireplace(boolean hasFireplace) {
        this.hasFireplace = hasFireplace;
    }

    public boolean isHasHotWater() {
        return hasHotWater;
    }

    public void setHasHotWater(boolean hasHotWater) {
        this.hasHotWater = hasHotWater;
    }

    public boolean isSmokingAllowed() {
        return smokingAllowed;
    }

    public void setSmokingAllowed(boolean smokingAllowed) {
        this.smokingAllowed = smokingAllowed;
    }

    public boolean isPartyAllowed() {
        return partyAllowed;
    }

    public void setPartyAllowed(boolean partyAllowed) {
        this.partyAllowed = partyAllowed;
    }

    @Override
    public String toString() {
        return "RentalHouse{" +
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
                ", hasWifi=" + hasWifi +
                ", petsAllowed=" + petsAllowed +
                ", hasChildChair=" + hasChildChair +
                ", hasSmokeAlarm=" + hasSmokeAlarm +
                ", hasTv=" + hasTv +
                ", hasParking=" + hasParking +
                ", hasFireExtinguisher=" + hasFireExtinguisher +
                ", hasTravelBed=" + hasTravelBed +
                ", hasFireplace=" + hasFireplace +
                ", hasHotWater=" + hasHotWater +
                ", smokingAllowed=" + smokingAllowed +
                ", partyAllowed=" + partyAllowed +
                '}';
    }
}
