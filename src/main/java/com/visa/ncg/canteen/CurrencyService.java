package com.visa.ncg.canteen;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class CurrencyService {

    double convertToGbp(int amount) {
        String uri = "http://jitterted-currency-conversion.herokuapp.com/convert?from=USD&to=GBP&amount={amount}";

        RestTemplate restTemplate = new RestTemplate();

        Map<String, Integer> params = new HashMap<>();
        params.put("amount", amount);
        CurrencyConversion conversion = restTemplate
                .getForObject(uri, CurrencyConversion.class, params);
        return conversion.getConverted();
    }
}
