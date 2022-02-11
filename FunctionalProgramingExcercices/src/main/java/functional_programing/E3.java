package functional_programing;

import functional_programing.model.PriceModifier;
import functional_programing.model.Product;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * Ejercicios sacados de
 * https://aprendeconalf.es/docencia/python/ejercicios/programacion-funcional/
 */
public class E3 {

    private static Product laptop = Product.builder()
            .id(UUID.randomUUID())
            .name("Omen 15La")
            .category("Computer")
            .price(new BigDecimal(21999))
            .build();
    private static PriceModifier descuentoNavidad = PriceModifier.builder()
            .id(UUID.randomUUID())
            .description("Navidad 20% de descuento")
            .percentage(new BigDecimal("0.20"))
            .build();
    private static PriceModifier ivaMexico = PriceModifier.builder()
            .id(UUID.randomUUID())
            .description("IVA en Mexico")
            .percentage(new BigDecimal("0.16"))
            .build();

    private static List<Product> products = initData();

    public static void main(String[] args) {
//        applyDiscounts();
        applyEspecificDiscounts(descuentoNavidad);
//        System.out.println(getTotalPrice(laptop,ivaMexico,descuentoNavidad));
    }
    /**
     * Escribir una función que aplique un descuento a un precio
     * y otra que aplique el IVA a un precio.
     * Escribir una tercera función que reciba un diccionario
     * con los precios y porcentajes de una cesta de la compra,
     * y una de las funciones anteriores, y utilice la función
     * pasada para aplicar los descuentos o el IVA a los productos
     * de la cesta y devolver el precio final de la cesta.
     */
    public static Product applyDiscount(Product product, PriceModifier priceModifier){
        product.setPrice(
                product.getPrice().subtract(product.getPrice().multiply(priceModifier.getPercentage()))
        );
        System.out.println("Producto con descuento: "+product);
        return product;
    }
    public static Product applyIva(Product product, PriceModifier priceModifier){
        product.setPrice(
                product.getPrice().add(product.getPrice().multiply(priceModifier.getPercentage()))
        );
        System.out.println("Producto con iva: "+product);
        return product;
    }
    public static Product getTotalPrice(Product product, PriceModifier iva,PriceModifier discount){
        return applyDiscount(applyIva(product,iva),discount);
    }

    /**
     * Aplica el desucento de la casa (esta en duro)
     */
    public static void applyDiscounts(){
//        products.forEach(E3::applyHouseDiscount); -> USAR EL --MAP-- EN LUGAR DE FOREACH, recordar que el map de igual manera repasa todos los elementos de la lista y transforma la lista a lo que devuelva la Function dentro de map()
//        System.out.println(products.stream().collect(Collectors.groupingBy(Product::getCategory))); // estas dos lineas las logre reducir a una
        System.out.println(
          products.stream().map(E3::applyHouseDiscount).collect(Collectors.groupingBy(Product::getCategory)) // podria poner una vandera para obtener el descuento global en uso para cada producto
        );
//        System.out.println(products);
    }

    /**
     * A diferencia del metodo anterior en este se puede especificar
     * cual sera el descuento a aplicar
     */
    public static void applyEspecificDiscounts(PriceModifier descuento){
        System.out.println(
                products.stream().map( //El map se PUEDE REEMPLAZAR POR UN PEEK y se elimina el return product;
                        product -> {
                            product.getPrice().subtract(product.getPrice().multiply(descuento.getPercentage()));//[17599.20, 16.80, 36.00, 25.60, 24000.00, 62.40, 12.00, 48.00]
                            return product;//{Alimenticio=[Product(id=c6d8180c-c0c7-49e1-b1b9-8b729a7f87d6, name=Agua, category=Alimenticio, price=21), Product(id=12505070-c0b4-42ad-b880-b4d954ffca73, name=Huevo, category=Alimenticio, price=45), Product(id=b80e3848-99ad-429b-9316-be44d8e2254d, name=Cereal, category=Alimenticio, price=32)], Salud=[Product(id=35d8c184-86c0-4012-9f40-1a4411160bfc, name=Shampoo, category=Salud, price=78), Product(id=deacd21a-5587-4a4a-b3ae-e3586c75f458, name=Jabon, category=Salud, price=15), Product(id=27806c41-46c2-47d9-b18f-d6e5ab7be9df, name=Papel higienico, category=Salud, price=60)], Tecnologia=[Product(id=d956e78d-94a2-4514-82c6-b38af69ac0b1, name=Omen 15La, category=Tecnologia, price=21999), Product(id=352fbd9f-b856-401c-b529-cdf5614fbe24, name=iPhone, category=Tecnologia, price=30000)]}
                        }
                ).collect(Collectors.groupingBy(Product::getCategory))
        );
//        Este es como quedaria con el peek
        products.stream().peek(
                product -> product.getPrice().subtract(product.getPrice().multiply(descuento.getPercentage()))
        ).collect(Collectors.groupingBy(Product::getCategory));
        //{Alimenticio=[Product(id=c6d8180c-c0c7-49e1-b1b9-8b729a7f87d6, name=Agua, category=Alimenticio, price=21), Product(id=12505070-c0b4-42ad-b880-b4d954ffca73, name=Huevo, category=Alimenticio, price=45), Product(id=b80e3848-99ad-429b-9316-be44d8e2254d, name=Cereal, category=Alimenticio, price=32)], Salud=[Product(id=35d8c184-86c0-4012-9f40-1a4411160bfc, name=Shampoo, category=Salud, price=78), Product(id=deacd21a-5587-4a4a-b3ae-e3586c75f458, name=Jabon, category=Salud, price=15), Product(id=27806c41-46c2-47d9-b18f-d6e5ab7be9df, name=Papel higienico, category=Salud, price=60)], Tecnologia=[Product(id=d956e78d-94a2-4514-82c6-b38af69ac0b1, name=Omen 15La, category=Tecnologia, price=21999), Product(id=352fbd9f-b856-401c-b529-cdf5614fbe24, name=iPhone, category=Tecnologia, price=30000)]}


    }
    public static Product applyHouseDiscount(Product product){
        product.setPrice(
                product.getPrice().subtract(product.getPrice().multiply(new BigDecimal("0.05")))
        );
        return product;
    }

    /**
     * Metodo que aplica un descuento a todos los productos
     * Los ordena del mayor precio al menor
     * Y los agrupa por categorias
     * @return
     */
    private static void discountSortGroup(){
        System.out.println(
                products.stream().map(E3::applyHouseDiscount).sorted(Comparator.comparing(Product::getPrice).reversed()).collect(Collectors.groupingBy(Product::getCategory))
        );
    }


    private static List<Product> initData() {
        return  List.of(
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
    }
}
