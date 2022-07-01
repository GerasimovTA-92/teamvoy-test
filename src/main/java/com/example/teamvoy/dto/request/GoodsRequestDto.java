package com.example.teamvoy.dto.request;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class GoodsRequestDto {
    @NotNull
    private Long productId;
    @Min(0)
    private Long count;

    public GoodsRequestDto() {
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }
}
