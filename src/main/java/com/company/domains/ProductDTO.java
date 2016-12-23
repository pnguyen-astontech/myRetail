package com.company.domains;

/**
 * Created by petenguy1 on 12/23/2016.
 */
public class ProductDTO {

    String productId;
    String generalDescription;

    public ProductDTO() {}

    public ProductDTO(String productId, String generalDescription) {
        this.productId = productId;
        this.generalDescription = generalDescription;
    }

    public String getGeneralDescription() {
        return generalDescription;
    }

    public void setGeneralDescription(String generalDescription) {
        this.generalDescription = generalDescription;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    @Override
    public String toString() {
        return "ProductDTO{" +
                "productId='" + productId + '\'' +
                ", generalDescription='" + generalDescription + '\'' +
                '}';
    }
}
