package functional_programing;

import functional_programing.model.PriceModifier;
import functional_programing.model.Product;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

/**
 * Ejercicios similares al E3
 * pero con BiFunction y
 * behavior parametrization
 *
 * Escribir una función que reciba otra función y una lista,
 * y devuelva otra lista con el resultado de aplicar la
 * función dada a cada uno de los elementos de la lista.
 * //este es lo de la linea 46
 */
public class E4 {

    private static List<Product> products = new ArrayList<>();
    private static List<PriceModifier> modifiers = new ArrayList<>();
    public static void main(String[] args) {
        initData();
//        Como este tipo de objetos acepta dos objetos diferentes de entrada podemos especificar uno personalizado de salida se puede realizar
//        lo que se hacia en la clase E3, no se si mas eficiente pero si de otro pov
        BiFunction<Product,PriceModifier,Product> applyDiscount = (product, priceModifier) -> {
            product.setPrice(
                    product.getPrice().subtract(product.getPrice().multiply(priceModifier.getPercentage())));
            return product;
        };

        BiFunction<List<Product>, PriceModifier,List<Product>> applyDiscountToProducts = (products1, priceModifier) ->{
            products1.forEach(product -> product.setPrice(product.getPrice().subtract(product.getPrice().multiply(priceModifier.getPercentage()))));
            return products1;
        };

        System.out.println(applyDiscount.apply(products.get(0),modifiers.get(0)));
        System.out.println(applyDiscountToProducts.apply(products,modifiers.get(modifiers.size()-1)));

        /**
         * Esta manera es ina forma de ahorrarse el objeto applyDiscountToProducts, se hace un metodo en lugar de almacenar un obj
         */
        behaviorParametrization(products,modifiers.get(modifiers.size()-1),(products1, priceModifier) -> {
            products1.forEach(product -> product.setPrice(product.getPrice().subtract(product.getPrice().multiply(priceModifier.getPercentage()))));
            return products1;
        });
    }

    public static List<Product> behaviorParametrization(List<Product> products,
                                                        PriceModifier priceModifier,
                                                        BiFunction<List<Product>, PriceModifier,List<Product>> biFunction){
       return biFunction.apply(products,priceModifier);
    }

    private static void initData() {
        products = List.of(
                Product.builder()
                        .id(UUID.randomUUID())
                        .name("Omen 15La")
                        .category("Tecnologia")
                        .price(new BigDecimal(21999))
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
                        .build(),
                Product.builder()
                        .id(UUID.randomUUID())
                        .name("Cereal")
                        .category("Alimenticio")
                        .price(new BigDecimal(32))
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
                        .build(),
                Product.builder()
                        .id(UUID.randomUUID())
                        .name("Jabon")
                        .category("Salud")
                        .price(new BigDecimal(15))
                        .build(),
                Product.builder()
                        .id(UUID.randomUUID())
                        .name("Papel higienico")
                        .category("Salud")
                        .price(new BigDecimal(60))
                        .build()
        );
        modifiers = List.of(
                PriceModifier.builder()
                        .id(UUID.randomUUID())
                        .description("Descuento 1")
                        .percentage(new BigDecimal("0.10"))
                        .build(),
                PriceModifier.builder()
                        .id(UUID.randomUUID())
                        .description("Descuento 1")
                        .percentage(new BigDecimal("0.15"))
                        .build(),
                PriceModifier.builder()
                        .id(UUID.randomUUID())
                        .description("Descuento 1")
                        .percentage(new BigDecimal("0.20"))
                        .build(),
                PriceModifier.builder()
                        .id(UUID.randomUUID())
                        .description("Descuento 1")
                        .percentage(new BigDecimal("0.25"))
                        .build(),
                PriceModifier.builder()
                        .id(UUID.randomUUID())
                        .description("Descuento 1")
                        .percentage(new BigDecimal("0.30"))
                        .build()
        );

    }
}
