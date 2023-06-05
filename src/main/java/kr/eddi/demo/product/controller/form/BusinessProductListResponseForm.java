package kr.eddi.demo.product.controller.form;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@RequiredArgsConstructor
@ToString
public class BusinessProductListResponseForm {
    final String productName;
    final Integer productPrice;
    final String productInfo;
    final String imageResourcePath;

}
