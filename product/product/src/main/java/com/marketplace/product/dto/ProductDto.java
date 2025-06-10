package com.marketplace.product.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
@Schema(
        name = "Product Request",
        description = "Schema to hold product information"
)
public class ProductDto {
    @Schema(
            description = "Id of the product", example = "1"
    )
    private Long productId;
    @Schema(
            description = "Name of the product", example = "Football"
    )
    private String name;
    @NotNull(message = "Price cannot be null")
    @Positive(message = "Price must be greater than zero")
    @Schema(
            description = "Price of the product", example = "1200"
    )
    private Integer price;
    @NotNull(message = "Quantity cannot be null")
    @Positive(message = "Quantity must be greater than zero")
    @Schema(
            description = "Quantity of the product", example = "10"
    )
    private Integer quantity;

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
