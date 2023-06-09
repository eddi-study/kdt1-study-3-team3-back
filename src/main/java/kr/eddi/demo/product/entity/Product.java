package kr.eddi.demo.product.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import kr.eddi.demo.account.entity.Account;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
@ToString
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String productName;
    private Integer productPrice;
    private String productInfo;

    @JsonIgnore
    @JsonManagedReference
    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
    private List<ProductImages> productImagesList = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "account_id")
    @Setter
    private Account account;

    public Product(String productName, Integer productPrice, String productInfo) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.productInfo = productInfo;
    }

    public void setProductImages(ProductImages productImg) {
        productImg.setProduct(this);
        productImagesList.add(productImg);
    }
}
