package com.kltn.motelservice.model;

import java.util.List;

public class DistrictDTO {
    private long id;

    private String name;

    private double xCoordinate;

    private double yCoordinate;

    private List<AccomodationDTO> accomodationDTOS;

    public DistrictDTO() {
    }

    public DistrictDTO(long id, String name, double xCoordinate, double yCoordinate, List<AccomodationDTO> accomodationDTOS) {
        this.id = id;
        this.name = name;
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        this.accomodationDTOS = accomodationDTOS;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public List<AccomodationDTO> getAccomodationDTOS() {
        return accomodationDTOS;
    }

    public void setAccomodationDTOS(List<AccomodationDTO> accomodationDTOS) {
        this.accomodationDTOS = accomodationDTOS;
    }
}
