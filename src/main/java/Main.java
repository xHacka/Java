import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        // Create students Table
        System.out.println("Creating Table...");
        ProductUtils.createTable();

        // Dummy Data
        List<Product> data = ProductUtils.sampleData();

        // Insert Into The Database
        // IDK Why It Keeps Rounding...........
        System.out.println("\nInserting Data...");
        data.forEach(ProductUtils::insert);

        // Get Students
        System.out.println("\nGetting All Product Data...");
        List<Product> products = ProductUtils.getAll();
        products.forEach(System.out::println);

        // Get By Name
        System.out.println("\nGetting 'Car Apparatus' By Name");
        List<Product> carApparatus = ProductUtils.getProductBy("name", "Car Apparatus");
        carApparatus.forEach(System.out::println);

        // Get By Quantity
        System.out.println("\nGetting 'Car Apparatus' By Quantity");
        List<Product> carApparatusQuantities = ProductUtils.getProductBy("quantity", "43");
        carApparatusQuantities.forEach(System.out::println);

        // Update product Name
        System.out.println("\nUpdating Name...");
        ProductUtils.updateProductField(1, "name", "Camping Kit");

        // Get { Product: Total Quantity }
        System.out.println("\nGetting Product: Total Quantity...");
        Map<String, Integer> productQuantities = ProductUtils.getQuantities("products");
        productQuantities.forEach(
                (name, quantity) -> System.out.printf("Product: %s, Quantity: %d\n", name, quantity)
        );

        // Delete product
        System.out.println("\nDeleting Product...");
        ProductUtils.deleteProduct(7);

        // Delete All Products
        System.out.println("\nDeleting All Products...");
        ProductUtils.deleteAll();

        // Deleting Table
        System.out.println("\nDeleting Table...");
        ProductUtils.deleteTable("products");
        System.out.println();
    }
}
