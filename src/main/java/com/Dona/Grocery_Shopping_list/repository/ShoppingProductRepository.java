package com.Dona.Grocery_Shopping_list.repository;

import com.Dona.Grocery_Shopping_list.model.ShoppingProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShoppingProductRepository extends JpaRepository<ShoppingProduct, Long> {
}

