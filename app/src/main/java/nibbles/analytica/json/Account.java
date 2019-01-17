package nibbles.analytica.json;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Account {

    @SerializedName("account_id")
    @Expose
    private String accountId;
    @SerializedName("balances")
    @Expose
    private Balances balances;
    @SerializedName("mask")
    @Expose
    private String mask;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("official_name")
    @Expose
    private String officialName;
    @SerializedName("subtype")
    @Expose
    private String subtype;
    @SerializedName("type")
    @Expose
    private String type;

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public Balances getBalances() {
        return balances;
    }

    public void setBalances(Balances balances) {
        this.balances = balances;
    }

    public String getMask() {
        return mask;
    }

    public void setMask(String mask) {
        this.mask = mask;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOfficialName() {
        return officialName;
    }

    public void setOfficialName(String officialName) {
        this.officialName = officialName;
    }

    public String getSubtype() {
        return subtype;
    }

    public void setSubtype(String subtype) {
        this.subtype = subtype;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("accountId", accountId).append("balances", balances).append("mask", mask).append("name", name).append("officialName", officialName).append("subtype", subtype).append("type", type).toString();
    }

}