package com.Dona.Grocery_Shopping_list.service;

import com.Dona.Grocery_Shopping_list.model.ShoppingProduct;
import com.Dona.Grocery_Shopping_list.repository.ShoppingProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ShoppingProductServiceImpl implements ShoppingProductService {
    @Autowired
    private ShoppingProductRepository shoppingProductRepository;

    @Override
    public List<ShoppingProduct> getAllProducts() {
        return shoppingProductRepository.findAll();
    }

    @Override
    public void saveProduct(ShoppingProduct shoppingProduct) {
        this.shoppingProductRepository.save(shoppingProduct);
    }

    @Override
    public ShoppingProduct getProductById(long id) {
        Optional<ShoppingProduct> optional = shoppingProductRepository.findById(id);
        ShoppingProduct shoppingProduct = null;

        if (optional.isPresent()) {
            shoppingProduct = optional.get();
        } else {
            throw new RuntimeException("Product not found for id :: " + id);
        }
        return shoppingProduct;
    }

    @Override
    public void deleteProduct(long id) {
        this.shoppingProductRepository.deleteById(id);
    }


}
