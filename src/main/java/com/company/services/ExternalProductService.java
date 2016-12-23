package com.company.services;

import com.company.domains.ProductDTO;

/**
 * Created by petenguy1 on 12/22/2016.
 */
public interface ExternalProductService {

    public ProductDTO findProductName(String productId);

}
