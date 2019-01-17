package nibbles.analytica.json;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Transaction {

    @SerializedName("account_id")
    @Expose
    private String accountId;
    @SerializedName("account_owner")
    @Expose
    private Object accountOwner;
    @SerializedName("amount")
    @Expose
    private Float amount;
    @SerializedName("category")
    @Expose
    private List<String> category = null;
    @SerializedName("category_id")
    @Expose
    private String categoryId;
    @SerializedName("date")
    @Expose
    private String date;
    @SerializedName("iso_currency_code")
    @Expose
    private String isoCurrencyCode;
    @SerializedName("location")
    @Expose
    private Location location;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("payment_meta")
    @Expose
    private PaymentMeta paymentMeta;
    @SerializedName("pending")
    @Expose
    private Boolean pending;
    @SerializedName("pending_transaction_id")
    @Expose
    private Object pendingTransactionId;
    @SerializedName("transaction_id")
    @Expose
    private String transactionId;
    @SerializedName("transaction_type")
    @Expose
    private String transactionType;
    @SerializedName("unofficial_currency_code")
    @Expose
    private Object unofficialCurrencyCode;

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public Object getAccountOwner() {
        return accountOwner;
    }

    public void setAccountOwner(Object accountOwner) {
        this.accountOwner = accountOwner;
    }

    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

    public List<String> getCategory() {
        return category;
    }

    public void setCategory(List<String> category) {
        this.category = category;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getIsoCurrencyCode() {
        return isoCurrencyCode;
    }

    public void setIsoCurrencyCode(String isoCurrencyCode) {
        this.isoCurrencyCode = isoCurrencyCode;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PaymentMeta getPaymentMeta() {
        return paymentMeta;
    }

    public void setPaymentMeta(PaymentMeta paymentMeta) {
        this.paymentMeta = paymentMeta;
    }

    public Boolean getPending() {
        return pending;
    }

    public void setPending(Boolean pending) {
        this.pending = pending;
    }

    public Object getPendingTransactionId() {
        return pendingTransactionId;
    }

    public void setPendingTransactionId(Object pendingTransactionId) {
        this.pendingTransactionId = pendingTransactionId;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public Object getUnofficialCurrencyCode() {
        return unofficialCurrencyCode;
    }

    public void setUnofficialCurrencyCode(Object unofficialCurrencyCode) {
        this.unofficialCurrencyCode = unofficialCurrencyCode;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("accountId", accountId).append("accountOwner", accountOwner).append("amount", amount).append("category", category).append("categoryId", categoryId).append("date", date).append("isoCurrencyCode", isoCurrencyCode).append("location", location).append("name", name).append("paymentMeta", paymentMeta).append("pending", pending).append("pendingTransactionId", pendingTransactionId).append("transactionId", transactionId).append("transactionType", transactionType).append("unofficialCurrencyCode", unofficialCurrencyCode).toString();
    }

}