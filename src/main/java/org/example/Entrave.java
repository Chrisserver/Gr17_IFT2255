package org.example;

public class Entrave {
    private String idRequest;
    private String streetId;
    private String shortName;
    private String streetImpactType;

    public Entrave(String idRequest, String streetId, String shortName, String streetImpactType) {
        this.idRequest = idRequest;
        this.streetId = streetId;
        this.shortName = shortName;
        this.streetImpactType = streetImpactType;
    }

    public String getIdRequest() {
        return this.idRequest;
    }

    public void setIdRequest(String idRequest) {
        this.idRequest = idRequest;
    }

    public String getStreetId() {
        return this.streetId;
    }

    public void setStreetId(String streetId) {
        this.streetId = streetId;
    }

    public String getShortName() {
        return this.shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getStreetImpactType() {
        return this.streetImpactType;
    }

    public void setStreetImpactType(String streetImpactType) {
        this.streetImpactType = streetImpactType;
    }

    public String toString() {
        return "Entrave{idRequest='" + this.idRequest + "', streetId='" + this.streetId + "', shortName='" + this.shortName + "', streetImpactType='" + this.streetImpactType + "'}";
    }
}
