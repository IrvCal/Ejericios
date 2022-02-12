package functional_programing;

import functional_programing.model.HasDiscount;
import functional_programing.model.Product;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.function.Predicate;

/**
 Escribir una función que reciba otra función booleana y una lista,
 y devuelva otra lista con los elementos de la lista que devuelvan
 True al aplicarles la función booleana.
 // esto es can el filter, se ocupa un predicate
 */
public class E5 {

    private static List<Product> products = new ArrayList<>();
    public static void main(String[] args) {
        initData();

        Predicate<Product> discountNotNull = product -> product.getHasDiscount() != null;
        Predicate<Product> hasDiscount = product -> product.getHasDiscount().equals(HasDiscount.YES);

        products.stream()
                .filter(discountNotNull)
                .filter(hasDiscount)
                .forEach(System.out::println);

    }
    private static void initData() {
        products = List.of(
                Product.builder()
                        .id(UUID.randomUUID())
                        .name("Omen 15La")
                        .category("Tecnologia")
                        .price(new BigDecimal(21999))
                        .hasDiscount(HasDiscount.YES)
                        .build(),
                Product.builder()
                        .id(UUID.randomUUID())
                        .name("Agua")
                        .category("Alimenticio")
                        .price(new BigDecimal(21))
                        .build(),
                Product.builder()
                        .id(UUID.randomUUID())
                        .name("Huevo")
                        .category("Alimenticio")
                        .price(new BigDecimal(45))
                        .hasDiscount(HasDiscount.NO)
                        .build(),
                Product.builder()
                        .id(UUID.randomUUID())
                        .name("Cereal")
                        .category("Alimenticio")
                        .price(new BigDecimal(32))
                        .hasDiscount(HasDiscount.NO)
                        .build(),
                Product.builder()
                        .id(UUID.randomUUID())
                        .name("iPhone")
                        .category("Tecnologia")
                        .price(new BigDecimal(30000))
                        .build(),
                Product.builder()
                        .id(UUID.randomUUID())
                        .name("Shampoo")
                        .category("Salud")
                        .price(new BigDecimal(78))
                        .hasDiscount(HasDiscount.NO)
                        .build(),
                Product.builder()
                        .id(UUID.randomUUID())
                        .name("Jabon")
                        .category("Salud")
                        .price(new BigDecimal(15))
                        .hasDiscount(HasDiscount.YES)
                        .build(),
                Product.builder()
                        .id(UUID.randomUUID())
                        .name("Papel higienico")
                        .category("Salud")
                        .price(new BigDecimal(60))
                        .hasDiscount(HasDiscount.NO)
                        .build()
        );

    }

}
