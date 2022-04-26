package com.Dona.Grocery_Shopping_list.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Data
public class ShoppingProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull(message = "Product Name cannot be null")
    @Size(min = 2, max = 30, message = "Product Name size must be between 2 and 30")
    private String productName;

    @NotNull(message = "{Dona.contraints.whoAdd.NotNull.message}")
    @Size(min = 2, max = 30, message = "{Dona.contraints.whoAdd.Size.message}")
    private String whoAdd;

    @NotNull(message = "{Dona.contraints.total.NotNull.message}")
    private String total;
}
