package com.ayush.ecom.service;

import com.ayush.ecom.model.Product;
import com.ayush.ecom.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepo productRepo;
    public List<Product> getProducts() {
        return productRepo.findAll();
    }

    public Product getProductById(int id) {
        return productRepo.findById(id).orElse(null);
    }

    public Product addProduct(Product product, MultipartFile imageFile) throws IOException {
        product.setImageName(imageFile.getOriginalFilename());
        product.setImageType(imageFile.getContentType());
        product.setImageData(imageFile.getBytes());
        return productRepo.save(product);
    }

    public void updateProduct(int id, Product product, MultipartFile imageFile) throws IOException {
        Product existingProduct = productRepo.findById(id).orElse(null);
        if(existingProduct != null){
            existingProduct= product;

            if(imageFile!= null){
                existingProduct.setImageName(imageFile.getOriginalFilename());
                existingProduct.setImageType(imageFile.getContentType());
                existingProduct.setImageData(imageFile.getBytes());
            }

            productRepo.save(existingProduct);
        }
    }

    public void deleteProduct(int id) {
        productRepo.deleteById(id);
    }
}
