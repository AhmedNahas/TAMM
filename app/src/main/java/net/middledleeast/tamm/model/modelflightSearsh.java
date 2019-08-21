package net.middledleeast.tamm.model;

public class modelflightSearsh {

    private String country , cuntryCode , cityCode ;



    public modelflightSearsh(String country, String cuntryCode, String cityCode) {
        this.country = country;
        this.cuntryCode = cuntryCode;
        this.cityCode = cityCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCuntryCode() {
        return cuntryCode;
    }

    public void setCuntryCode(String cuntryCode) {
        this.cuntryCode = cuntryCode;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }
}
