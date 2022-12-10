import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

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
}
