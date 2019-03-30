package com.kltn.motelservice.model;

public class AccomodationDTO {
    private long id;

    private double acreage;

    private String address;

    private double electricPrice;

    private double waterPrice;

    private boolean internet;

    private String toilet;

    private double price;

    private boolean mezzanine;

    private boolean upstair;

    private boolean motel;

    private boolean status;

    private double xCoordinate;

    private double yCoordinate;

    private PostDTO postDTO;

    private Long idDistrict;

    public AccomodationDTO() {
    }

    public AccomodationDTO(long id, double acreage, String address, double electricPrice, double waterPrice, boolean internet, String toilet,
                           double price, boolean mezzanine, boolean upstair, boolean motel, boolean status, double xCoordinate,
                           double yCoordinate, PostDTO postDTO, Long idDistrict) {
        this.id = id;
        this.acreage = acreage;
        this.address = address;
        this.electricPrice = electricPrice;
        this.waterPrice = waterPrice;
        this.internet = internet;
        this.toilet = toilet;
        this.price = price;
        this.mezzanine = mezzanine;
        this.upstair = upstair;
        this.motel = motel;
        this.status = status;
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        this.postDTO = postDTO;
        this.idDistrict = idDistrict;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getAcreage() {
        return acreage;
    }

    public void setAcreage(double acreage) {
        this.acreage = acreage;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getElectricPrice() {
        return electricPrice;
    }

    public void setElectricPrice(double electricPrice) {
        this.electricPrice = electricPrice;
    }

    public double getWaterPrice() {
        return waterPrice;
    }

    public void setWaterPrice(double waterPrice) {
        this.waterPrice = waterPrice;
    }

    public boolean isInternet() {
        return internet;
    }

    public void setInternet(boolean internet) {
        this.internet = internet;
    }

    public String getToilet() {
        return toilet;
    }

    public void setToilet(String toilet) {
        this.toilet = toilet;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isMezzanine() {
        return mezzanine;
    }

    public void setMezzanine(boolean mezzanine) {
        this.mezzanine = mezzanine;
    }

    public boolean isUpstair() {
        return upstair;
    }

    public void setUpstair(boolean upstair) {
        this.upstair = upstair;
    }

    public boolean isMotel() {
        return motel;
    }

    public void setMotel(boolean motel) {
        this.motel = motel;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public double getxCoordinate() {
        return xCoordinate;
    }

    public void setxCoordinate(double xCoordinate) {
        this.xCoordinate = xCoordinate;
    }

    public double getyCoordinate() {
        return yCoordinate;
    }

    public void setyCoordinate(double yCoordinate) {
        this.yCoordinate = yCoordinate;
    }

    public PostDTO getPostDTO() {
        return postDTO;
    }

    public void setPostDTO(PostDTO postDTO) {
        this.postDTO = postDTO;
    }

    public Long getIdDistrict() {
        return idDistrict;
    }

    public void setIdDistrict(Long idDistrict) {
        this.idDistrict = idDistrict;
    }
}