package models;

import nosqlite.annotations.Document;
import nosqlite.annotations.Id;

@Document
public class RentalAmenity {
    @Id
    private String id;
    private String rentalObjectId;
    private String amenityId;

    public RentalAmenity(){

    }

    public RentalAmenity(String id, String rentalObjectId, String amenityId) {
        this.id = id;
        this.rentalObjectId = rentalObjectId;
        this.amenityId = amenityId;
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

    public String getAmenityId() {
        return amenityId;
    }

    public void setAmenityId(String amenityId) {
        this.amenityId = amenityId;
    }

    @Override
    public String toString() {
        return "RentalAmenity{" +
                "id='" + id + '\'' +
                ", rentalObjectId='" + rentalObjectId + '\'' +
                ", amenityId='" + amenityId + '\'' +
                '}';
    }
}
