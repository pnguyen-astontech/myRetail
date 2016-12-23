package com.company.services.impl;

import com.company.domains.CurrentPrice;
import com.company.domains.ProductDTO;
import com.company.services.ExternalProductService;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by petenguy1 on 12/22/2016.
 */
@Service
public class ExternalProductServiceImpl implements ExternalProductService{

    private RestTemplate restTemplate;

    @Value("${external.api.fields}")
    private String fields;

    @Value("${external.api.resource}")
    private String externalResource;

    @Value("${external.api.key}")
    private String key;

    // TODO: Not best practice, should refactor.
    public ExternalProductServiceImpl() {
        restTemplate = new RestTemplate();
    }

    // TODO: Ideally we would create a DTO that represents the external api response.
    @Override
    public ProductDTO findProductName(String productId) {

        String result = restTemplate.getForObject(buildServiceUrl(productId), String.class);
        return convertResponseToDTO(new JSONObject(result));
    }

    // TODO:  This converter method needs to be expanded to the full structure of the external API data structure
    public ProductDTO convertResponseToDTO(JSONObject response) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setGeneralDescription(response.getJSONObject("product_composite_response").getJSONArray("items").getJSONObject(0).getString("general_description"));
        return productDTO;
    }

    public String buildServiceUrl(String productId) {
        return externalResource + productId + fields + key;
    }
}
