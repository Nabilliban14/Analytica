package nibbles.analytica.json;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class Balances {

    @SerializedName("available")
    @Expose
    private Float available;
    @SerializedName("current")
    @Expose
    private Float current;
    @SerializedName("iso_currency_code")
    @Expose
    private String isoCurrencyCode;
    @SerializedName("limit")
    @Expose
    private Object limit;
    @SerializedName("unofficial_currency_code")
    @Expose
    private Object unofficialCurrencyCode;

    public Float getAvailable() {
        return available;
    }

    public void setAvailable(Float available) {
        this.available = available;
    }

    public Float getCurrent() {
        return current;
    }

    public void setCurrent(Float current) {
        this.current = current;
    }

    public String getIsoCurrencyCode() {
        return isoCurrencyCode;
    }

    public void setIsoCurrencyCode(String isoCurrencyCode) {
        this.isoCurrencyCode = isoCurrencyCode;
    }

    public Object getLimit() {
        return limit;
    }

    public void setLimit(Object limit) {
        this.limit = limit;
    }

    public Object getUnofficialCurrencyCode() {
        return unofficialCurrencyCode;
    }

    public void setUnofficialCurrencyCode(Object unofficialCurrencyCode) {
        this.unofficialCurrencyCode = unofficialCurrencyCode;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("available", available).append("current", current).append("isoCurrencyCode", isoCurrencyCode).append("limit", limit).append("unofficialCurrencyCode", unofficialCurrencyCode).toString();
    }

}