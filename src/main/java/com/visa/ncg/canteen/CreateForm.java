package com.visa.ncg.canteen;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

public class CreateForm {

    @Size(min=2, max=63)
    private String accountName;
    @Min(1)
    @Max(100)
    private BigDecimal initialDeposit;
    @Min(0)
    @Max(10)
    private BigDecimal overdraftLimit;

    public void CreateForm () {

        this.initialDeposit = new BigDecimal(0);
        this.overdraftLimit = new BigDecimal(0);

    }

    public void CreateForm (String accountName, BigDecimal initialDepost, BigDecimal overdraftLimit) {

        this.accountName = accountName;
        this.initialDeposit = initialDeposit;
        this.overdraftLimit = overdraftLimit;

    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public BigDecimal getInitialDeposit() {
        return initialDeposit;
    }

    public void setInitialDeposit(BigDecimal initialDeposit) {
        this.initialDeposit = initialDeposit;
    }

    public BigDecimal getOverdraftLimit() {
        return overdraftLimit;
    }

    public void setOverdraftLimit(BigDecimal overdraftLimit) {
        this.overdraftLimit = overdraftLimit;
    }
}
