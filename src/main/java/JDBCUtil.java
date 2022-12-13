import java.sql.*;

public class JDBCUtil {

    private static final String DB_URL = "jdbc:mysql://remotemysql.com:3306/seHc2Pcy82";
    private static final String DB_USER = "seHc2Pcy82";
    private static final String DB_PASSWORD = "XZKC1IELsM";
    private static final Connection connection;
    private static Statement statement;

    static {
        try {
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static Statement getStatement() {
        if (statement == null) {
            try {
                statement = connection.createStatement();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return statement;
    }

    public static void execute(String query) {
        try {
            JDBCUtil.getStatement().execute(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void executeUpdate(String query) {
        try {
            JDBCUtil.getStatement().executeUpdate(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static ResultSet executeQuery(String query) {
        try {
            return JDBCUtil.getStatement().executeQuery(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void resetIndex(String table) {
        String query = String.format("ALTER TABLE %s AUTO_INCREMENT = 1", table);
        JDBCUtil.execute(query);
    }
}
