package com.Dona.Grocery_Shopping_list.controller;


import com.Dona.Grocery_Shopping_list.exception.productAlreadyExistsException;
import com.Dona.Grocery_Shopping_list.model.ShoppingProduct;
import com.Dona.Grocery_Shopping_list.service.ShoppingProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class ShoppingProductController {
    @Autowired
    private ShoppingProductService shoppingProductService;

    @GetMapping("/")
    public String viewHomePage(Model model) {
        // display list of product
        model.addAttribute("listProducts", shoppingProductService.getAllProducts());
        return "index";
    }

    @GetMapping("/showNewProductForm")
    public String showNewProductForm(Model model) {
        // create model attribute to bind form data
        ShoppingProduct shoppingProduct = new ShoppingProduct();
        model.addAttribute("shoppingProduct", shoppingProduct);
        return "new_product";
    }

    @PostMapping("/saveProduct")
    public String saveProduct(@Valid @ModelAttribute("shoppingProduct") ShoppingProduct shoppingProduct) {//@Valid
        // save product to database
        shoppingProductService.saveProduct(shoppingProduct);
        return "redirect:/";
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {
        // get product from the service
        ShoppingProduct shoppingProduct = shoppingProductService.getProductById(id);

        // set product as a model attribute to pre-populate the form
        model.addAttribute("shoppingProduct", shoppingProduct);
        return "update_product";
    }

    @PostMapping("/updateProduct")
    public String updateProduct(@Valid @ModelAttribute("shoppingProduct") ShoppingProduct newShoppingProduct) {
        // update product to database
        shoppingProductService.updateProduct(newShoppingProduct);
        return "redirect:/";
    }

    @GetMapping("/deleteShoppingProduct/{id}")
    public String deleteShoppingProduct(@PathVariable(value = "id") long id) {
        // call delete product method
        this.shoppingProductService.deleteProduct(id);
        return "redirect:/";
    }

    @ExceptionHandler(productAlreadyExistsException.class)
    public ResponseEntity<String> handleProductAlreadyExists(productAlreadyExistsException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.CONFLICT);
    }

}
