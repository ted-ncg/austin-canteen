package com.visa.ncg.canteen;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class CurrencyService {

    int convertToGBP (int amount) {

        RestTemplate api = new RestTemplate();

        String currencyConvertURl = "http://jitterted-currency-conversion.herokuapp.com/convert?from={from}&to={to}&amount={amount}";
        Map<String, String> params = new HashMap<>();
        params.put("from", "USD");
        params.put("to", "GBP");
        params.put("amount", Integer.toString(amount));
        ConvertedCurrency currency = new ConvertedCurrency();
        try {
            currency = api.getForObject(currencyConvertURl, ConvertedCurrency.class, params);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return (int) currency.getConverted();
    }

}
