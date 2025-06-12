package com.marketplace.product.service;

import com.marketplace.product.dto.AllInfoDto;
import com.marketplace.product.dto.OrderDto;
import com.marketplace.product.dto.ProductDto;
import com.marketplace.product.entity.Products;
import com.marketplace.product.repository.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderFeignClient orderFeignClient;

    public List<ProductDto> getAllProducts() {
        List<Products> productsList = productRepository.findAll();
        List<ProductDto> productDtoList = new ArrayList<>();
        for (int i = 0; i < productsList.size(); i++) {
            ProductDto productDto = new ProductDto();
            productDto.setProductId(productsList.get(i).getProductId());
            productDto.setName(productsList.get(i).getName());
            productDto.setPrice(productsList.get(i).getPrice());
            productDto.setQuantity(productsList.get(i).getQuantity());
            productDtoList.add(productDto);
        }
        return productDtoList;
    }

    public Products addProducts(ProductDto productDto) {
        Products product = new Products();
        product.setProductId(productDto.getProductId());
        product.setName(productDto.getName());
        product.setPrice(productDto.getPrice());
        product.setQuantity(productDto.getQuantity());
        return productRepository.save(product);
    }

    public void removeProducts(Long productId) {
        productRepository.deleteById(productId);
    }

    public List<AllInfoDto> getAllInfo() {
        List<Products> productsList = productRepository.findAll();
        List<AllInfoDto> allInfoDtoList = new ArrayList<>();
        List<OrderDto> body = orderFeignClient.getAllOrders().getBody();
        for (int i = 0; i < productsList.size(); i++) {
            AllInfoDto allInfoDto = new AllInfoDto();
            allInfoDto.setProductId(productsList.get(i).getProductId());
            allInfoDto.setName(productsList.get(i).getName());
            allInfoDto.setPrice(productsList.get(i).getPrice());
            allInfoDto.setQuantity(productsList.get(i).getQuantity());
            allInfoDto.setOrderStatus(body.get(i).getOrderStatus());
            allInfoDto.setOrderDate(body.get(i).getOrderDate());
            allInfoDtoList.add(allInfoDto);
        }
        return allInfoDtoList;
    }
}
