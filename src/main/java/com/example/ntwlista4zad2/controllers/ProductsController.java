package com.example.ntwlista4zad2.controllers;

import com.example.ntwlista4zad2.classes.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.ntwlista4zad2.repos.ProductRepository;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ProductsController {

    final ProductRepository productRepository;


    public ProductsController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    @GetMapping(value="/products", consumes = {"*/*"})
    public List<Product> getClients(@RequestParam(required = false) String category,
                                    @RequestParam(required = false) String producer,
                                    @RequestParam(required = false) String sort,
                                    @RequestParam(required = false) String name,
                                    @RequestParam(required = false) String promocja)  {

        List<Product> filteredProducts = productRepository.findAll();
       // System.out.println(filteredProducts);

        if (!category.isEmpty()) {
            System.out.println(1);
            filteredProducts = filteredProducts.stream()
                    .filter(product -> product.getCategory().equals(category))
                    .collect(Collectors.toList());
        }

        if (!producer.isEmpty()) {
            System.out.println(2);
            filteredProducts = filteredProducts.stream()
                    .filter(product -> product.getProducer().equals(producer))
                    .collect(Collectors.toList());
        }

        if (!sort.isEmpty()) {
            System.out.println(3);
            if (sort.equals("price-lowest")) {
                filteredProducts.sort(Comparator.comparingDouble(Product::getPrice));
            } else if (sort.equals("price-highest")) {
                filteredProducts.sort(Comparator.comparingDouble(Product::getPrice).reversed());
            }
        }
        if(!name.isEmpty()){
            filteredProducts = filteredProducts.stream()
                    .filter(product -> product.getName().toLowerCase().contains(name.toLowerCase()))
                    .collect(Collectors.toList());
        }
        if (!promocja.isEmpty()) {
            System.out.println(666);
            if (promocja.equals("promocje")) {
                System.out.println("promocje");
                filteredProducts = filteredProducts.stream()
                        .filter(product -> product.isPromocja()==true)
                        .collect(Collectors.toList());
            } else if (promocja.equals("bez-promocji")) {
                System.out.println("bez");
                filteredProducts = filteredProducts.stream()
                        .filter(product -> product.isPromocja()==false)
                        .collect(Collectors.toList());
            }
        }

        return filteredProducts;
    }


}
