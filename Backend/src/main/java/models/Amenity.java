package models;

public class Amenity {

    private boolean wifi;
    private boolean smartTv;
    private boolean partyAllowed;
    private boolean petsAllowed;
    private boolean smokingAllowed;
    private boolean fireplace;
    private boolean parking;
    private boolean freeParking;
    private boolean selfCheckIn;
    private boolean airCondition;
    private boolean hairDryer;
    private boolean dishwasher;
    private boolean pool;
    private boolean bathtub;
    private boolean iron;
    private boolean elevator;
    private boolean kitchen;
    private boolean heating;
    private boolean bedroomEssentials;
    private boolean bathroomEssentials;
    private boolean coffeeMaker;

    public Amenity() {
    }

    public boolean isWifi() {
        return wifi;
    }

    public void setWifi(boolean wifi) {
        this.wifi = wifi;
    }


    public boolean isSmartTv() {
        return smartTv;
    }

    public void setSmartTv(boolean smartTv) {
        this.smartTv = smartTv;
    }

    public boolean isPartyAllowed() {
        return partyAllowed;
    }

    public void setPartyAllowed(boolean partyAllowed) {
        this.partyAllowed = partyAllowed;
    }

    public boolean isPetsAllowed() {
        return petsAllowed;
    }

    public void setPetsAllowed(boolean petsAllowed) {
        this.petsAllowed = petsAllowed;
    }

    public boolean isSmokingAllowed() {
        return smokingAllowed;
    }

    public void setSmokingAllowed(boolean smokingAllowed) {
        this.smokingAllowed = smokingAllowed;
    }

    public boolean isFireplace() {
        return fireplace;
    }

    public void setFireplace(boolean fireplace) {
        this.fireplace = fireplace;
    }

    public boolean isParking() {
        return parking;
    }

    public void setParking(boolean parking) {
        this.parking = parking;
    }

    public boolean isFreeParking() {
        return freeParking;
    }

    public void setFreeParking(boolean freeParking) {
        this.freeParking = freeParking;
    }

    public boolean isSelfCheckIn() {
        return selfCheckIn;
    }

    public void setSelfCheckIn(boolean selfCheckIn) {
        this.selfCheckIn = selfCheckIn;
    }

    public boolean isAirCondition() {
        return airCondition;
    }

    public void setAirCondition(boolean airCondition) {
        this.airCondition = airCondition;
    }

    public boolean isHairDryer() {
        return hairDryer;
    }

    public void setHairDryer(boolean hairDryer) {
        this.hairDryer = hairDryer;
    }

    public boolean isDishwasher() {
        return dishwasher;
    }

    public void setDishwasher(boolean dishwasher) {
        this.dishwasher = dishwasher;
    }

    public boolean isPool() {
        return pool;
    }

    public void setPool(boolean pool) {
        this.pool = pool;
    }

    public boolean isBathtub() {
        return bathtub;
    }

    public void setBathtub(boolean bathtub) {
        this.bathtub = bathtub;
    }

    public boolean isIron() {
        return iron;
    }

    public void setIron(boolean iron) {
        this.iron = iron;
    }

    public boolean isElevator() {
        return elevator;
    }

    public void setElevator(boolean elevator) {
        this.elevator = elevator;
    }

    public boolean isKitchen() {
        return kitchen;
    }

    public void setKitchen(boolean kitchen) {
        this.kitchen = kitchen;
    }

    public boolean isHeating() {
        return heating;
    }

    public void setHeating(boolean heating) {
        this.heating = heating;
    }

    public boolean isBedroomEssentials() {
        return bedroomEssentials;
    }

    public void setBedroomEssentials(boolean bedroomEssentials) {
        this.bedroomEssentials = bedroomEssentials;
    }

    public boolean isBathroomEssentials() {
        return bathroomEssentials;
    }

    public void setBathroomEssentials(boolean bathroomEssentials) {
        this.bathroomEssentials = bathroomEssentials;
    }

    public boolean isCoffeeMaker() {
        return coffeeMaker;
    }

    public void setCoffeeMaker(boolean coffeeMaker) {
        this.coffeeMaker = coffeeMaker;
    }

    @Override
    public String toString() {
        return "Amenity{" +
               "wifi=" + wifi +
               ", smartTv=" + smartTv +
               ", partyAllowed=" + partyAllowed +
               ", petsAllowed=" + petsAllowed +
               ", smokingAllowed=" + smokingAllowed +
               ", fireplace=" + fireplace +
               ", parking=" + parking +
               ", freeParking=" + freeParking +
               ", selfCheckIn=" + selfCheckIn +
               ", airCondition=" + airCondition +
               ", hairDryer=" + hairDryer +
               ", dishwasher=" + dishwasher +
               ", pool=" + pool +
               ", bathtub=" + bathtub +
               ", iron=" + iron +
               ", elevator=" + elevator +
               ", kitchen=" + kitchen +
               ", heating=" + heating +
               ", bedroomEssentials=" + bedroomEssentials +
               ", bathroomEssentials=" + bathroomEssentials +
               ", coffeeMaker=" + coffeeMaker +
               '}';
    }
}
