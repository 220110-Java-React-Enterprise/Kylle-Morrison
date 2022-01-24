package Utils;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionManager {
    private static Connection connection;

    private ConnectionManager() { // We don't want anyone to create a connection object
    }

    public static Connection getConnection() throws SQLException, IOException {
        if(connection == null) {
            connection = connect();
        }
        return connection;
    }

    private static Connection connect() throws IOException, SQLException {

        Properties props = new Properties();
        FileReader fr = new FileReader("src/main/resources/jdbc.properties");
        props.load(fr);

        String connectionString = "jdbc:mariadb://" +
                props.getProperty("hostname") + ":" +
                props.getProperty("port") + "/" +
                props.getProperty("dbname") + "?user=" +
                props.getProperty("username") + "&password=" +
                props.getProperty("password");

        connection = DriverManager.getConnection(connectionString);

        return connection;
    }
}
