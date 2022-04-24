package com.Dona.Grocery_Shopping_list.dto;

import com.Dona.Grocery_Shopping_list.model.ShoppingProduct;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class ShoppingProductDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String productName;

    private String whoAdd;

    private String total;

    public static ShoppingProductDTO of(ShoppingProduct shoppingProduct) {
        return new ShoppingProductDTO(shoppingProduct.getProductName(), shoppingProduct.getWhoAdd(), shoppingProduct.getTotal());
    }
}
