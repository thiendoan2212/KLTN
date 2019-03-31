package com.kltn.motelservice.entity;

import org.hibernate.annotations.NaturalId;

import javax.persistence.*;

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

    private boolean internet;

    @Enumerated(EnumType.STRING)
    @Column(length = 60)
    private ToiletName toilet;

    private double price;

    private boolean mezzanine;

    private int upstair;

    private boolean status;

    private boolean motel;

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

    public Accomodation(double acreage, String address, double electricPrice, double waterPrice, boolean internet,
                        ToiletName toilet, double price, boolean mezzanine, int upstair, boolean status, boolean motel,
                        double xCoordinate, double yCoordinate, Post post, District district) {
        this.acreage = acreage;
        this.address = address;
        this.electricPrice = electricPrice;
        this.waterPrice = waterPrice;
        this.internet = internet;
        this.toilet = toilet;
        this.price = price;
        this.mezzanine = mezzanine;
        this.upstair = upstair;
        this.status = status;
        this.motel = motel;
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
        return internet;
    }

    public void setInternet(boolean internet) {
        this.internet = internet;
    }

    public ToiletName getToilet() {
        return toilet;
    }

    public void setToilet(ToiletName toilet) {
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

    public int getUpstair() {
        return upstair;
    }

    public void setUpstair(int upstair) {
        this.upstair = upstair;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public boolean isMotel() {
        return motel;
    }

    public void setMotel(boolean motel) {
        this.motel = motel;
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
