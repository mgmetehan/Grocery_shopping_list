package com.Dona.Grocery_Shopping_list.controller;


import com.Dona.Grocery_Shopping_list.model.ShoppingProduct;
import com.Dona.Grocery_Shopping_list.service.ShoppingProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ShoppingProductController {
    @Autowired
    private ShoppingProductService shoppingProductService;

    @GetMapping("/")
    public ResponseEntity<String> viewHomePage(Model model) {
        // display list of product
        model.addAttribute("listProducts", shoppingProductService.getAllProducts());
        return new ResponseEntity<>("index", HttpStatus.OK);
    }

    @GetMapping("/showNewProductForm")
    public ResponseEntity<String> showNewProductForm(Model model) {
        // create model attribute to bind form data
        ShoppingProduct shoppingProduct = new ShoppingProduct();
        model.addAttribute("shoppingProduct", shoppingProduct);
        return new ResponseEntity<>("new_product", HttpStatus.OK);
    }

    @PostMapping("/saveProduct")
    public ResponseEntity<String> saveProduct(@ModelAttribute("shoppingProduct") ShoppingProduct shoppingProduct) {
        // save product to database
        shoppingProductService.saveProduct(shoppingProduct);
        return new ResponseEntity<>("redirect:/", HttpStatus.OK);
    }

    @GetMapping("/showFormForUpdate/{id}")
    public ResponseEntity<String> showFormForUpdate(@PathVariable(value = "id") long id, Model model) {
        // get product from the service
        ShoppingProduct shoppingProduct = shoppingProductService.getProductById(id);

        // set product as a model attribute to pre-populate the form
        model.addAttribute("shoppingProduct", shoppingProduct);
        return new ResponseEntity<>("update_product", HttpStatus.OK);
    }

    @GetMapping("/deleteShoppingProduct/{id}")
    public ResponseEntity<String> deleteShoppingProduct(@PathVariable(value = "id") long id) {
        // call delete product method
        this.shoppingProductService.deleteProduct(id);
        return new ResponseEntity<>("redirect:/", HttpStatus.OK);
    }

}
