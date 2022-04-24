package com.Dona.Grocery_Shopping_list.service;

import com.Dona.Grocery_Shopping_list.model.ShoppingProduct;

import java.util.List;

public interface ShoppingProductService {
    List<ShoppingProduct> getAllProducts();

    void saveProduct(ShoppingProduct shoppingProduct);

    void updateProduct(ShoppingProduct shoppingProduct);

    ShoppingProduct getProductById(long id);

    void deleteProduct(long id);
}