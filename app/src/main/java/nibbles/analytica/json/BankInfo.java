package nibbles.analytica.json;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class BankInfo {

    @SerializedName("accounts")
    @Expose
    private List<Account> accounts = null;
    @SerializedName("item")
    @Expose
    private Item item;
    @SerializedName("request_id")
    @Expose
    private String requestId;
    @SerializedName("total_transactions")
    @Expose
    private Integer totalTransactions;
    @SerializedName("transactions")
    @Expose
    private List<Transaction> transactions = null;

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public Integer getTotalTransactions() {
        return totalTransactions;
    }

    public void setTotalTransactions(Integer totalTransactions) {
        this.totalTransactions = totalTransactions;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("accounts", accounts).append("item", item).append("requestId", requestId).append("totalTransactions", totalTransactions).append("transactions", transactions).toString();
    }

}