package com.ecom.productcatalog.config;

import com.ecom.productcatalog.Repository.CategoryRepository;
import com.ecom.productcatalog.Repository.ProductRepository;
import com.ecom.productcatalog.model.Category;
import com.ecom.productcatalog.model.Product;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class Dataseeder implements CommandLineRunner {

    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;

    public Dataseeder(CategoryRepository categoryRepository, ProductRepository productRepository) {
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // Clear all existing data
        productRepository.deleteAll();
        categoryRepository.deleteAll();

        // Create categories
        Category electronics = new Category();
        electronics.setName("Electronics");

        Category clothing = new Category();
        clothing.setName("Clothing");

        Category home = new Category();
        home.setName("Home and Kitchen");

        Category beauty = new Category();
        beauty.setName("Beauty & Personal Care");

        Category sports = new Category();
        sports.setName("Sports & Outdoors");

        Category toys = new Category();
        toys.setName("Toys & Games");

        Category books = new Category();
        books.setName("Books");

        Category automotive = new Category();
        automotive.setName("Automotive");

        Category gardening = new Category();
        gardening.setName("Gardening");

        Category furniture = new Category();
        furniture.setName("Furniture");

        Category pets = new Category();
        pets.setName("Pets");

        Category baby = new Category();
        baby.setName("Baby");

        categoryRepository.saveAll(Arrays.asList(
                electronics,
                clothing,
                home,
                beauty,
                sports,
                toys,
                books,
                automotive,
                gardening,
                furniture,
                pets,
                baby
        ));

        // Create products
        Product smartphone = createProduct("Smartphone", "Latest model smartphone with amazing features", "https://placehold.co/600x400", 699.99, electronics);
        Product laptop = createProduct("Windows Laptop", "Intel i7, 256GB SSD, sleek design", "https://placehold.co/600x400", 999.99, electronics);
        Product tablet = createProduct("Touchscreen Tablet", "10-inch HD Touchscreen with stylus", "https://placehold.co/600x400", 499.99, electronics);
        Product headphones = createProduct("Noise Cancelling Headphones", "Wireless, over-ear headphones for clear sound", "https://placehold.co/600x400", 199.99, electronics);

        Product jacket = createProduct("Winter Jacket", "Warm and stylish for the winter season", "https://placehold.co/600x400", 89.99, clothing);
        Product tShirt = createProduct("Casual T-Shirt", "Premium cotton, fits all occasions", "https://placehold.co/600x400", 19.99, clothing);
        Product jeans = createProduct("Blue Jeans", "Comfortable and durable with a modern fit", "https://placehold.co/600x400", 49.99, clothing);

        Product blender = createProduct("Bosch Blender", "3 blades, 4 jars, versatile and efficient", "https://placehold.co/600x400", 159.99, home);
        Product toaster = createProduct("Stainless Steel Toaster", "Dual slice, modern design with easy cleanup", "https://placehold.co/600x400", 49.99, home);
        Product microwave = createProduct("Microwave Oven", "900W with grill and defrost functionality", "https://placehold.co/600x400", 199.99, home);

        Product lipstick = createProduct("Red Lipstick", "Long-lasting, rich red color for all occasions", "https://placehold.co/600x400", 29.99, beauty);
        Product foundation = createProduct("Liquid Foundation", "Matte finish, 12-hour stay formula", "https://placehold.co/600x400", 39.99, beauty);
        Product skincareCream = createProduct("Anti-Aging Skincare Cream", "Reduces fine lines, packed with Vitamin E", "https://placehold.co/600x400", 49.99, beauty);

        Product football = createProduct("Premium Football", "Official size and weight for professionals", "https://placehold.co/600x400", 49.99, sports);
        Product yogaMat = createProduct("Yoga Mat", "Non-slip, durable, great for at-home or gym use", "https://placehold.co/600x400", 39.99, sports);

        Product doll = createProduct("Teddy Bear Doll", "Soft and cuddly toy for children", "https://placehold.co/600x400", 24.99, toys);
        Product puzzle = createProduct("Jigsaw Puzzle", "500 piece fun and challenging family activity", "https://placehold.co/600x400", 14.99, toys);

        Product novel = createProduct("The Great Gatsby", "Classic novel by F. Scott Fitzgerald", "https://placehold.co/600x400", 14.99, books);
        Product sciFiBook = createProduct("Dune - Science Fiction Novel", "Epic sci-fi masterpiece by Frank Herbert", "https://placehold.co/600x400", 19.99, books);

        Product carWashKit = createProduct("Car Wash Kit", "Complete car cleaning with tools", "https://placehold.co/600x400", 39.99, automotive);

        Product gardenToolSet = createProduct("Garden Tool Set", "Includes shovel, rake, and gloves", "https://placehold.co/600x400", 49.99, gardening);

        Product sofa = createProduct("Modern Sofa", "Stylish modern sofa perfect for any living room", "https://placehold.co/600x400", 499.99, furniture);

        Product petBed = createProduct("Cozy Pet Bed", "Soft and warm for your furry friend", "https://placehold.co/600x400", 29.99, pets);

        Product babyStroller = createProduct("Baby Stroller", "Foldable, lightweight, and durable", "https://placehold.co/600x400", 299.99, baby);

        productRepository.saveAll(Arrays.asList(
                smartphone,
                laptop,
                tablet,
                headphones,
                jacket,
                tShirt,
                jeans,
                blender,
                toaster,
                microwave,
                lipstick,
                foundation,
                skincareCream,
                football,
                yogaMat,
                doll,
                puzzle,
                novel,
                sciFiBook,
                carWashKit,
                gardenToolSet,
                sofa,
                petBed,
                babyStroller
        ));
    }

    private Product createProduct(String name, String description, String imageUrl, double price, Category category) {
        Product product = new Product();
        product.setName(name);
        product.setDescription(description);
        product.setImageUrl(imageUrl);
        product.setPrice(price);
        product.setCategory(category);
        return product;
    }
}
