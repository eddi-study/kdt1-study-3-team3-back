package kr.eddi.demo.product.repository;

import kr.eddi.demo.account.entity.Account;
import kr.eddi.demo.product.entity.Product;
import kr.eddi.demo.product.entity.ProductImages;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface ProductImagesRepository extends JpaRepository<ProductImages, Long> {
    @Query("select pi from ProductImages pi join fetch pi.product p where p.id = :productId")
    List<ProductImages> findImagePathByProductId(Long productId);

    List<ProductImages> findByProductId(Long id);
    @Transactional
    void deleteAllByProductId(Long productId);
}
