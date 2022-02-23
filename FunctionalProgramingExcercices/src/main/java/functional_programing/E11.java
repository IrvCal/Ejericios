package functional_programing;

import functional_programing.model.Product;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Funcion que dado un precio arroja los productos
 */
public class E11 {
    static List<Product> products = List.of(
            Product.builder()
                    .name("producto1")
                    .price(new BigDecimal(400))
                    .build(),
            Product.builder()
                    .name("producto2")
                    .price(new BigDecimal(230))
                    .build(),
            Product.builder()
                    .name("producto3")
                    .price(new BigDecimal(890))
                    .build(),
            Product.builder()
                    .name("producto4")
                    .price(new BigDecimal(70))
                    .build(),
            Product.builder()
                    .name("producto5")
                    .price(new BigDecimal(498))
                    .build(),
            Product.builder()
                    .name("producto6")
                    .price(new BigDecimal(300))
                    .build(),
            Product.builder()
                    .name("producto7")
                    .price(new BigDecimal(400))
                    .build()
    );

    public static void main(String[] args) {
        int price = 400;
        products.sort(Comparator.comparing(Product::getPrice));
        System.out.println(
        products.stream().filter(product -> product.getPrice().intValue()<price).collect(Collectors.toList())
);
    }
}
