package com.marketplace.product.controller;

import com.marketplace.product.dto.AccountsContactInfoDto;
import com.marketplace.product.dto.ProductDto;
import com.marketplace.product.entity.Products;
import com.marketplace.product.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/products")
@Tag(
        name = "CRUD REST APIs for Products in TGM",
        description = "CRUD REST APIs in Products to CREATE, UPDATE, FETCH AND DELETE product details"
)
public class ProductController {

    @Autowired
    private ProductService productService;

    @Value("${build.version}")
    private String buildVersion;

    @Autowired
    private Environment environment;

    @Autowired
    private AccountsContactInfoDto accountsContactInfoDto;

    @GetMapping(path = "/list")
    @Operation(
            summary = "Fetch product Details REST API",
            description = "REST API to fetch all product details"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "HTTP Status OK"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "HTTP Status Internal Server Error"
            )
    }
    )
    public ResponseEntity<List<ProductDto>> getAllProducts() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(productService.getAllProducts());
    }

    @PostMapping(path = "/add")
    @Operation(
            summary = "Create product REST API",
            description = "REST API to create product inside TGM"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "201",
                    description = "HTTP Status CREATED"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "HTTP Status Internal Server Error"
                    /*content = @Content(
                            schema = @Schema(implementation = ErrorResponseDto.class)
                    )*/
            )
    }
    )
    public ResponseEntity<Products> addProducts(@Valid @RequestBody ProductDto productDto) {
        Products product = productService.addProducts(productDto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(product);
    }

    @DeleteMapping(path = "/remove")
    public ResponseEntity<String> removeProducts(@RequestParam Long productId) {
        productService.removeProducts(productId);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body("Product deleted with id : " + productId);
    }

    @GetMapping(path = "/app-version")
    public String getBuildVersion() {
        return buildVersion;
    }

    @GetMapping(path = "/java-version")
    public String getJavaVersion() {
        return environment.getProperty("java.version");
    }

    @GetMapping(path = "/account-info")
    public AccountsContactInfoDto getAccountInfo() {
        return accountsContactInfoDto;
    }
}
