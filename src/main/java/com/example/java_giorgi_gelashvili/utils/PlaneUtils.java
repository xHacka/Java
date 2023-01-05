package com.example.java_giorgi_gelashvili.utils;

import com.example.java_giorgi_gelashvili.Plane;
import com.github.javafaker.Faker;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PlaneUtils {
    private static final String DEFAULT_TABLE = "flights";

    public static void createTable(String query) {
        DBUtils.execute(query);
        System.out.println("Table Created Successfully");
    }

    public static void createTable() {
        String query = String.format("""
                CREATE TABLE IF NOT EXISTS %s (
                    id INT NOT NULL AUTO_INCREMENT,
                    source VARCHAR(64) NOT NULL,
                    destination VARCHAR(64) NOT NULL,
                    date DATE NOT NULL,
                    seats INT NOT NULL,
                    seatsOccupied INT,
                    price DECIMAL(7, 2) NOT NULL,
                    PRIMARY KEY (id),
                    UNIQUE KEY (id)
                )""", DEFAULT_TABLE);
        createTable(query);
        System.out.printf("Table %s Created Successfully\n", DEFAULT_TABLE);
    }

    public static void insert(String table, Plane plane) {
        Integer occupiedSeats = plane.getSeatsOccupied() != 0 ? plane.getSeatsOccupied() : 0;
        String query = String.format("""
                        INSERT INTO %s (source, destination, date, seats, seatsOccupied, price)
                        VALUES ("%s", "%s", "%s", "%s", "%s", "%s");
                        """,
                table, plane.getSource(), plane.getDestination(), plane.getDate(), plane.getSeats(), occupiedSeats, plane.getPrice());
        DBUtils.execute(query);
        System.out.println("Record Successfully Inserted");
    }

    public static void insert(Plane plane) {
        insert(DEFAULT_TABLE, plane);
    }

    public static Plane getPlane(String table, long id) {
        String query = String.format("""
                SELECT * FROM %s
                WHERE id=%d
                """, table, id);
        ResultSet resultSet = DBUtils.executeQuery(query);
        Plane plane = null;
        try {
            if (resultSet.next()) {
                plane = newPlaneFromSQL(resultSet);
            }
        } catch (SQLException e) {
            System.out.printf("Plane By Id %d Not Found!\n", id);
        }

        return plane;
    }

    public static Plane getPlane(long id) {
        return getPlane(DEFAULT_TABLE, id);
    }

    public static List<Plane> getPlaneBy(String table, String field, String value) {
        String query = String.format("""
                SELECT * FROM %s
                WHERE %s="%s"
                """, table, field, value);

        List<Plane> products = new ArrayList<>();
        try {
            ResultSet resultSet = DBUtils.executeQuery(query);
            while (resultSet.next()) {
                products.add(newPlaneFromSQL(resultSet));
            }
        } catch (SQLException e) {
            System.out.printf("Plane By Field: %s Value: %s Not Found!\n", field, value);
        }

        return products;
    }

    public static List<Plane> getPlaneBy(String field, String value) {
        return getPlaneBy(DEFAULT_TABLE, field, value);
    }

    public static List<Plane> getAll(String table) {
        String query = String.format("SELECT * FROM %s", table);
        List<Plane> products = new ArrayList<>();

        try {
            ResultSet resultSet = DBUtils.executeQuery(query);
            while (resultSet.next()) {
                products.add(newPlaneFromSQL(resultSet));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return products;
    }

    public static List<Plane> getAll() {
        return getAll(DEFAULT_TABLE);
    }

    public static void updatePlane(String table, long id, String source, String destination, Date date, Integer seats, Integer seatsOccupied, Double price) {
        String query = String.format("""
                UPDATE %s
                SET source="%s"
                SET destination="%s"
                SET date="%s"
                SET seats=%s
                SET seatsOccupied=%s
                SET price=%s
                WHERE id=%d
                """, table, source, destination, date, seats, seatsOccupied, price, id);


        DBUtils.execute(query);
        Plane plane = getPlane(id);

        if (plane != null) {
            System.out.printf("Old: %s,\nNew: %s", plane, new Plane(id, source, destination, date, seats, seatsOccupied, price));
        } else {
            System.out.println("Failed To Update Plane By ID: " + id);
        }
    }

    public static void updatePlane(long id, String source, String destination, Date date, Integer seats, Integer seatsOccupied, Double price) {
        updatePlane(DEFAULT_TABLE, id, source, destination, date, seats, seatsOccupied, price);
    }

    public static void updatePlaneField(String table, long id, String field, String value) {
        String query = String.format("""
                        UPDATE %s
                        SET %s="%s"
                        WHERE id=%d
                        """,
                table, field, value, id
        );

        Plane plane = getPlane(id);
        DBUtils.execute(query);

        if (plane != null) {
            System.out.printf(
                    "ID: %d Successfully Updated. [ %s -> %s ]\n",
                    id, plane.getField(field), value
            );
        }
    }

    public static void updatePlaneField(long id, String field, String value) {
        updatePlaneField(DEFAULT_TABLE, id, field, value);
    }

    public static void deletePlane(String table, long id) {
        String query = String.format("""
                DELETE FROM %s
                WHERE id=%d
                """, table, id);

        Plane plane = getPlane(id);
        DBUtils.execute(query);

        System.out.printf("%s Deleted\n", plane);
    }

    public static void deletePlane(long id) {
        deletePlane(DEFAULT_TABLE, id);
    }

    public static void deleteAll(String table) {
        String query = String.format("DELETE FROM %s", table);
        DBUtils.execute(query);
        DBUtils.resetIndex(table);
        System.out.println("All Planes Deleted!");
    }

    public static void deleteAll() {
        deleteAll(DEFAULT_TABLE);
    }

    public static void deleteTable(String table) {
        String query = String.format("DROP TABLe IF EXISTS %s", table);
        DBUtils.execute(query);
    }

    public static List<Plane> populateDatabase(int n, boolean insertIntoDB) {
        Faker faker = new Faker();
        int seats, seatsOccupied;
        List<Plane> planes = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            seats = faker.number().numberBetween(1, 100);
            seatsOccupied = faker.number().numberBetween(1, 100);
            if (seatsOccupied > seats) { // Don't Be Scared. Its Just Bits F@ckery Which Swaps Values Of 2 Variable.
                seats = seats ^ seatsOccupied ^ (seatsOccupied = seats);
            }
            Plane plane = new Plane(
                    faker.address().country(),
                    faker.address().country(),
                    new Date(faker.date().birthday().getTime()),
                    seats,
                    seatsOccupied,
                    faker.number().randomDouble(2, 1, (int) 1E+4)
            );
            planes.add(plane);
            if (insertIntoDB) {
                insert(plane);
            }
        }

        return planes;
    }

    public static List<Plane> populateDatabase(int n) {
        return populateDatabase(n, true);
    }

    public static List<Plane> dummyData(int n) {
        return populateDatabase(n, false);
    }

    public static Plane newPlaneFromSQL(ResultSet resultSet) {
        Plane plane = null;
        try {
            plane = new Plane(
                    resultSet.getLong("id"),
                    resultSet.getString("source"),
                    resultSet.getString("destination"),
                    resultSet.getDate("date"),
                    resultSet.getInt("seats"),
                    resultSet.getInt("seatsOccupied"),
                    resultSet.getDouble("price")
            );
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Failed To Parse SQL ResultSet!");
        }

        return plane;
    }

    public static void main(String[] args) {
//        deleteAll();
        createTable();
        List<Plane> dummyData = populateDatabase(20);
    }
}
