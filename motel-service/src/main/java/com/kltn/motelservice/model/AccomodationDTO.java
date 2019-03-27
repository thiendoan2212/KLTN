package com.kltn.motelservice.model;

public class AccomodationDTO {
    private long id;

    private double acreage;

    private String address;

    private double electricPrice;

    private double waterPrice;

    private boolean isInternet;

    private boolean isToilet;

    private double price;

    private boolean isMezzanine;

    private boolean isUpstair;

    private boolean isMotel;

    private boolean status;

    private double xCoordinate;

    private double yCoordinate;

//    private Long idPost;

    private PostDTO postDTO;

    private Long idDistrict;

    public AccomodationDTO() {
    }

    public AccomodationDTO(long id, double acreage, String address, double electricPrice, double waterPrice, boolean isInternet,
                           boolean isToilet, double price, boolean isMezzanine, boolean isUpstair, boolean isMotel,
                           boolean status, double xCoordinate, double yCoordinate, PostDTO postDTO, Long idDistrict) {
        this.id = id;
        this.acreage = acreage;
        this.address = address;
        this.electricPrice = electricPrice;
        this.waterPrice = waterPrice;
        this.isInternet = isInternet;
        this.isToilet = isToilet;
        this.price = price;
        this.isMezzanine = isMezzanine;
        this.isUpstair = isUpstair;
        this.isMotel = isMotel;
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
        return isInternet;
    }

    public void setInternet(boolean internet) {
        isInternet = internet;
    }

    public boolean isToilet() {
        return isToilet;
    }

    public void setToilet(boolean toilet) {
        isToilet = toilet;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isMezzanine() {
        return isMezzanine;
    }

    public void setMezzanine(boolean mezzanine) {
        isMezzanine = mezzanine;
    }

    public boolean isUpstair() {
        return isUpstair;
    }

    public void setUpstair(boolean upstair) {
        isUpstair = upstair;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public boolean isMotel() {
        return isMotel;
    }

    public void setMotel(boolean motel) {
        isMotel = motel;
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