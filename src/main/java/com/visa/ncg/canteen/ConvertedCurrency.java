package com.visa.ncg.canteen;


public class ConvertedCurrency {

    private String currency;

    private int converted;

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public int getConverted() {
        return converted;
    }

    public void setConverted(double converted) {
        this.converted = (int) converted;
    }

}
