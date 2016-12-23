package com.company.services.impl;

import com.company.domains.CurrentPrice;
import com.company.services.ExternalProductService;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by petenguy1 on 12/22/2016.
 */
@Service
public class ExternalProductServiceImpl implements ExternalProductService{


    private RestTemplate restTemplate;

    private String serviceUrl;
    private String fields;
    private String externalUrl = "https://api.target.com/products/v3/";
    private String key = "&id_type=TCIN&key=43cJWpLjH8Z8oR18KdrZDBKAgLLQKJjz" ;

    // TODO: Not best practice, should refactor.
    public ExternalProductServiceImpl() {
        restTemplate = new RestTemplate();
    }

    // TODO: Ideally we would create a DTO that represents the external api response.
    @Override
    public String findProductName(String productId) {
        // TODO: Create method for url construction and not hard code url.
        fields = "?fields=descriptions";
        serviceUrl =  externalUrl + productId + fields + key;

        String result = restTemplate.getForObject(serviceUrl, String.class);
        JSONObject jsonObject = new JSONObject(result);
        String productName = jsonObject.getJSONObject("product_composite_response").getJSONArray("items").getJSONObject(0).getString("general_description");
        return productName;
    }
}
