package nibbles.analytica.json;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class PaymentMeta {

    @SerializedName("by_order_of")
    @Expose
    private Object byOrderOf;
    @SerializedName("payee")
    @Expose
    private Object payee;
    @SerializedName("payer")
    @Expose
    private Object payer;
    @SerializedName("payment_method")
    @Expose
    private Object paymentMethod;
    @SerializedName("payment_processor")
    @Expose
    private Object paymentProcessor;
    @SerializedName("ppd_id")
    @Expose
    private Object ppdId;
    @SerializedName("reason")
    @Expose
    private Object reason;
    @SerializedName("reference_number")
    @Expose
    private Object referenceNumber;

    public Object getByOrderOf() {
        return byOrderOf;
    }

    public void setByOrderOf(Object byOrderOf) {
        this.byOrderOf = byOrderOf;
    }

    public Object getPayee() {
        return payee;
    }

    public void setPayee(Object payee) {
        this.payee = payee;
    }

    public Object getPayer() {
        return payer;
    }

    public void setPayer(Object payer) {
        this.payer = payer;
    }

    public Object getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(Object paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public Object getPaymentProcessor() {
        return paymentProcessor;
    }

    public void setPaymentProcessor(Object paymentProcessor) {
        this.paymentProcessor = paymentProcessor;
    }

    public Object getPpdId() {
        return ppdId;
    }

    public void setPpdId(Object ppdId) {
        this.ppdId = ppdId;
    }

    public Object getReason() {
        return reason;
    }

    public void setReason(Object reason) {
        this.reason = reason;
    }

    public Object getReferenceNumber() {
        return referenceNumber;
    }

    public void setReferenceNumber(Object referenceNumber) {
        this.referenceNumber = referenceNumber;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("byOrderOf", byOrderOf).append("payee", payee).append("payer", payer).append("paymentMethod", paymentMethod).append("paymentProcessor", paymentProcessor).append("ppdId", ppdId).append("reason", reason).append("referenceNumber", referenceNumber).toString();
    }

}