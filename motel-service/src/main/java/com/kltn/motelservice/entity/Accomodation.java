package com.kltn.motelservice.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "accomodation")
public class Accomodation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    private boolean status;

    private boolean isMotel;

    private double xCoordinate;

    private double yCoordinate;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    private Post post;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "district_id")
    private District district;

    public Accomodation() {
    }

    public Accomodation(double acreage, String address, double electricPrice, double waterPrice, boolean isInternet,
                        boolean isToilet, double price, boolean isMezzanine, boolean isUpstair, boolean status,
                        boolean isMotel, double xCoordinate, double yCoordinate, Post post, District district) {
        this.acreage = acreage;
        this.address = address;
        this.electricPrice = electricPrice;
        this.waterPrice = waterPrice;
        this.isInternet = isInternet;
        this.isToilet = isToilet;
        this.price = price;
        this.isMezzanine = isMezzanine;
        this.isUpstair = isUpstair;
        this.status = status;
        this.isMotel = isMotel;
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        this.post = post;
        this.district = district;
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

    public boolean isMotel() {
        return isMotel;
    }

    public void setMotel(boolean motel) {
        isMotel = motel;
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

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public District getDistrict() {
        return district;
    }

    public void setDistrict(District district) {
        this.district = district;
    }
}
