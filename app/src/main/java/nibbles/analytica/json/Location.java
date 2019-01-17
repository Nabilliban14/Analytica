package nibbles.analytica.json;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Location {

    @SerializedName("address")
    @Expose
    private Object address;
    @SerializedName("city")
    @Expose
    private Object city;
    @SerializedName("lat")
    @Expose
    private Object lat;
    @SerializedName("lon")
    @Expose
    private Object lon;
    @SerializedName("state")
    @Expose
    private Object state;
    @SerializedName("store_number")
    @Expose
    private Object storeNumber;
    @SerializedName("zip")
    @Expose
    private Object zip;

    public Object getAddress() {
        return address;
    }

    public void setAddress(Object address) {
        this.address = address;
    }

    public Object getCity() {
        return city;
    }

    public void setCity(Object city) {
        this.city = city;
    }

    public Object getLat() {
        return lat;
    }

    public void setLat(Object lat) {
        this.lat = lat;
    }

    public Object getLon() {
        return lon;
    }

    public void setLon(Object lon) {
        this.lon = lon;
    }

    public Object getState() {
        return state;
    }

    public void setState(Object state) {
        this.state = state;
    }

    public Object getStoreNumber() {
        return storeNumber;
    }

    public void setStoreNumber(Object storeNumber) {
        this.storeNumber = storeNumber;
    }

    public Object getZip() {
        return zip;
    }

    public void setZip(Object zip) {
        this.zip = zip;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("address", address).append("city", city).append("lat", lat).append("lon", lon).append("state", state).append("storeNumber", storeNumber).append("zip", zip).toString();
    }

}