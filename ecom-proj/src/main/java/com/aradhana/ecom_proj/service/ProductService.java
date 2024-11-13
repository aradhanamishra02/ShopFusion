package com.aradhana.ecom_proj.service;

import com.aradhana.ecom_proj.model.Product;
import com.aradhana.ecom_proj.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    ProductRepo repo;
    public List<Product> getAllProduct() {
        return repo.findAll();
    }

    public Product getProductById(int id) {
        return repo.findById(id).orElse(null);
    }

    public Product addProduct(Product product, MultipartFile imageFile) throws IOException {
        product.setImagename(imageFile.getOriginalFilename());
        product.setImagetype(imageFile.getContentType());
        product.setImagedate(imageFile.getBytes());
        return repo.save(product);
    }

    public Product updateProduct(int id, Product product, MultipartFile imageFile) throws IOException {
        product.setImagedate(imageFile.getBytes());
        product.setImagename(imageFile.getOriginalFilename());
        product.setImagetype(imageFile.getContentType());
        return repo.save(product);
    }
    public void deleteProduct(int id) {
        repo.deleteById(id);
    }

    public List<Product> searchProduct(String keyword) {

        return repo.searchProducts(keyword);
    }
}
