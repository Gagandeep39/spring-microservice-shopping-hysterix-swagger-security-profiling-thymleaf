package com.gagan.shopping2productmicroservice.service.implementation;

import com.gagan.shopping2productmicroservice.model.Product;
import com.gagan.shopping2productmicroservice.repository.ProductDetailsRepository;
import com.gagan.shopping2productmicroservice.repository.ProductRepository;
import com.gagan.shopping2productmicroservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Gagandeep
 * @date 26-04-2020
 * @time 19:44
 */

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductDetailsRepository productDetailsRepository;

    @Override
    public List<Product> fetchAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product fetchById(Integer id) {
        return productRepository.findById(id).get();
    }

    @Override
    public List<Product> fetchByCategory(String category) {
        return productRepository.findProductsByCategory(category);
    }

    @Override
    public Product addProduct(Product product) {
        productDetailsRepository.save(product.getProductDetails());
        productRepository.save(product);
        return product;
    }

	@Override
	public Product updateStocks(Integer productId, Integer productQuantity) throws Exception {
        Product product = productRepository.findById(productId).get();
        if(product.getStock() < productQuantity) throw new Exception("Product Out of Stock");
        product.setStock(product.getStock() - productQuantity);
        productRepository.save(product);
		return product;
	}
}
