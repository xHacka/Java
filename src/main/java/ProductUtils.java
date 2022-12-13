import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ProductUtils {

    public static void createTable(String query) {
        JDBCUtil.execute(query);
        System.out.println("Table Created Successfully");
    }

    public static void createTable() {
        String query = """
                CREATE TABLE IF NOT EXISTS products (
                    id INT NOT NULL AUTO_INCREMENT,
                    name VARCHAR(64) NOT NULL,
                    price DECIMAL(7, 2) NOT NULL,
                    quantity INT NOT NULL,
                    PRIMARY KEY (id),
                    UNIQUE KEY (id)
                )
                """;
        createTable(query);
        System.out.println("Table products Created Successfully");
    }

    public static void insert(String table, Product product) {
        String query = String.format("""
                        INSERT IGNORE INTO %s (name, price, quantity)
                        VALUES ("%s", "%f", "%d");
                        """,
                table, product.getName(), product.getPrice(), product.getQuantity());
        JDBCUtil.execute(query);
        System.out.println("Record Successfully Inserted");
    }

    public static void insert(Product product) {
        insert("products", product);
    }

    public static Product getProduct(String table, long id) {
        String query = String.format("""
                SELECT * FROM %s
                WHERE id=%d
                """, table, id);
        ResultSet resultSet = JDBCUtil.executeQuery(query);
        Product product = null;
        try {
            if (resultSet.next()) {
                product = new Product(
                        resultSet.getLong("id"),
                        resultSet.getString("name"),
                        resultSet.getFloat("price"),
                        resultSet.getInt("quantity")
                );
            }

        } catch (SQLException e) {
            System.out.printf("Product By Id %d Not Found!\n", id);
        }

        return product;
    }

    public static Product getProduct(long id) {
        return getProduct("products", id);
    }

    public static List<Product> getProductBy(String table, String field, String value) {
        String query = String.format("""
                SELECT * FROM %s
                WHERE %s="%s"
                """, table, field, value);

        List<Product> products = new ArrayList<>();
        try {
            ResultSet resultSet = JDBCUtil.executeQuery(query);
            while (resultSet.next()) {
                products.add(new Product(
                        resultSet.getLong("id"),
                        resultSet.getString("name"),
                        resultSet.getFloat("price"),
                        resultSet.getInt("quantity")
                ));
            }
        } catch (SQLException e) {
            System.out.printf("Product By Field: %s Value: %s Not Found!\n", field, value);
        }

        return products;
    }

    public static List<Product> getProductBy(String field, String value) {
        return getProductBy("products", field, value);
    }

    public static List<Product> getAll(String table) {
        String query = String.format("SELECT * FROM %s", table);
        List<Product> products = new ArrayList<>();

        try {
            ResultSet resultSet = JDBCUtil.executeQuery(query);
            while (resultSet.next()) {
                products.add(new Product(
                        resultSet.getLong("id"),
                        resultSet.getString("name"),
                        resultSet.getFloat("price"),
                        resultSet.getInt("quantity")
                ));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return products;
    }

    public static List<Product> getAll() {
        return getAll("products");
    }

    public static void updateProduct(String table, long id, String name, Double price, int quantity) {
        String query = String.format("""
                UPDATE %s
                SET name="%s"
                SET price=%f
                SET quantity=%d
                WHERE id = %d
                """, table, name, price, quantity, id);

        JDBCUtil.execute(query);
        Product product = getProduct(id);

        if (product != null) {
            System.out.printf(
                    "ID: %d Successfully Updated. [ %s -> %s, %f -> %f, %d -> %d ]\n",
                    id,
                    product.getName(), name,
                    product.getPrice(), price,
                    product.getQuantity(), quantity
            );
        }
    }

    public static void updateProduct(long id, String name, Double price, int quantity) {
        updateProduct("products", id, name, price, quantity);
    }

    public static void updateProductField(String table, long id, String field, String value) {
        String query = String.format("""
                        UPDATE %s
                        SET %s="%s"
                        WHERE id = %d
                        """,
                table, field, value, id
        );

        Product product = getProduct(id);
        JDBCUtil.execute(query);

        if (product != null) {
            System.out.printf(
                    "ID: %d Successfully Updated. [ %s -> %s ]\n",
                    id, product.getField(field), value
            );
        }
    }

    public static void updateProductField(long id, String field, String value) {
        updateProductField("products", id, field, value);
    }

    public static void deleteProduct(String table, long id) {
        String query = String.format("""
                DELETE FROM %s
                WHERE id = %d
                """, table, id);

        Product product = getProduct(id);
        JDBCUtil.execute(query);

        System.out.printf("%s Deleted\n", product);
    }

    public static void deleteProduct(long id) {
        deleteProduct("products", id);
    }

    public static void deleteAll(String table) {
        String query = String.format("DELETE FROM %s", table);
        JDBCUtil.execute(query);
        JDBCUtil.resetIndex(table);
        System.out.println("All Products Deleted!");
    }

    public static void deleteAll() {
        deleteAll("products");
    }

    public static void deleteTable(String table) {
        String query = String.format("DROP TABLe IF EXISTS %s", table);
        JDBCUtil.execute(query);
    }

    public static Map<String, Integer> getQuantities(String table) {
        List<Product> allRows = getAll(table);
//        Map<String, Integer> result;
//        allRows.forEach(row -> {
//            String key = row.getName();
//            result.put(key, result.getOrDefault(key, 0) + row.getQuantity());
//        });
        return allRows.stream()
                .collect(
                        Collectors.groupingBy(
                                Product::getName,
                                Collectors.reducing(0, Product::getQuantity, Integer::sum)
                        ));
    }

    public static List<Product> sampleData() {
        List<List<String>> data = new ArrayList<>(
                List.of( // https://cobbl.io
                        List.of("Furniture Rig", "69.95", "41"),
                        List.of("Baby Widget", "151.95", "90"),
                        List.of("Book Attachment", "90", "81"),
                        List.of("Hair Care Equipment", "34.95", "27"),
                        List.of("Toy Tool", "105.95", "73"),
                        List.of("Phone Implement", "53.95", "31"),
                        List.of("Cat Component", "114.99", "92"),
                        List.of("Jewelry Doodad", "181.95", "96"),
                        List.of("Skin Care Widget", "103", "72"),
                        List.of("Car Apparatus", "53", "43"),
                        List.of("Car Apparatus", "63", "43"),
                        List.of("Car Apparatus", "73", "43"),
                        List.of("Car Apparatus", "53", "43")
                )
        );

        List<Product> products = new ArrayList<>();
        data.forEach(product -> products.add(
                new Product(
                        product.get(0),
                        Double.parseDouble(product.get(1)),
                        Integer.parseInt(product.get(2))
                )));

        return products;
    }
}
