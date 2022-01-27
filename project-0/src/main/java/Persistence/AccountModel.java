package Persistence;

public class AccountModel {
    private Integer accountID;
    private String accountName;
    private Long accountBalance;

    public AccountModel() {}

    public AccountModel(Integer accountID, String accountName, Long accountBalance) {
        this.accountID = accountID;
        this.accountName = accountName;
        this.accountBalance = accountBalance;
    }

    public Integer getAccountID() {
        return accountID;
    }

    public void setAccountID(Integer accountID) {
        this.accountID = accountID;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public Long getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(Long accountBalance) {
        this.accountBalance = accountBalance;
    }
}
