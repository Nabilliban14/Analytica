package nibbles.analytica.json;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Item {

    @SerializedName("available_products")
    @Expose
    private List<String> availableProducts = null;
    @SerializedName("billed_products")
    @Expose
    private List<String> billedProducts = null;
    @SerializedName("error")
    @Expose
    private Object error;
    @SerializedName("institution_id")
    @Expose
    private String institutionId;
    @SerializedName("item_id")
    @Expose
    private String itemId;
    @SerializedName("webhook")
    @Expose
    private String webhook;

    public List<String> getAvailableProducts() {
        return availableProducts;
    }

    public void setAvailableProducts(List<String> availableProducts) {
        this.availableProducts = availableProducts;
    }

    public List<String> getBilledProducts() {
        return billedProducts;
    }

    public void setBilledProducts(List<String> billedProducts) {
        this.billedProducts = billedProducts;
    }

    public Object getError() {
        return error;
    }

    public void setError(Object error) {
        this.error = error;
    }

    public String getInstitutionId() {
        return institutionId;
    }

    public void setInstitutionId(String institutionId) {
        this.institutionId = institutionId;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getWebhook() {
        return webhook;
    }

    public void setWebhook(String webhook) {
        this.webhook = webhook;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("availableProducts", availableProducts).append("billedProducts", billedProducts).append("error", error).append("institutionId", institutionId).append("itemId", itemId).append("webhook", webhook).toString();
    }

}