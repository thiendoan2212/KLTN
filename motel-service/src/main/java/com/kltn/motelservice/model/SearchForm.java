package com.kltn.motelservice.model;

public class SearchForm {
    private double acreageStart;

    private double acreageEnd;

    private double priceStart;

    private double priceEnd;

    private boolean isMotel;

    private long idDistrict;

    public SearchForm() {
    }

    public SearchForm(double acreageStart, double acreageEnd, double priceStart, double priceEnd, boolean isMotel, long idDistrict) {
        this.acreageStart = acreageStart;
        this.acreageEnd = acreageEnd;
        this.priceStart = priceStart;
        this.priceEnd = priceEnd;
        this.isMotel = isMotel;
        this.idDistrict = idDistrict;
    }

    public double getAcreageStart() {
        return acreageStart;
    }

    public void setAcreageStart(double acreageStart) {
        this.acreageStart = acreageStart;
    }

    public double getAcreageEnd() {
        return acreageEnd;
    }

    public void setAcreageEnd(double acreageEnd) {
        this.acreageEnd = acreageEnd;
    }

    public double getPriceStart() {
        return priceStart;
    }

    public void setPriceStart(double priceStart) {
        this.priceStart = priceStart;
    }

    public double getPriceEnd() {
        return priceEnd;
    }

    public void setPriceEnd(double priceEnd) {
        this.priceEnd = priceEnd;
    }

    public boolean isMotel() {
        return isMotel;
    }

    public void setMotel(boolean motel) {
        isMotel = motel;
    }

    public long getIdPost() {
        return idDistrict;
    }

    public void setIdPost(long idDistrict) {
        this.idDistrict = idDistrict;
    }
}
