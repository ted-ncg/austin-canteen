package com.visa.ncg.canteen;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Service
public class CurrencyService {

    public int convertToGbp(BigDecimal amount) {

        RestTemplate restTemplate = new RestTemplate();
        String numberFactsUrl = "http://jitterted-currency-conversion.herokuapp.com/convert?from={from}&to={to}&amount={amount}";

        Map<String, String> params = new HashMap<>();
        params.put("from", "USD");
        params.put("to", "GBP");
        params.put("amount", amount.toString());

        ConvertedCurrency convertedCurrency = restTemplate
                .getForObject(numberFactsUrl, ConvertedCurrency.class, params);

        return convertedCurrency.getConverted();
    }

}
