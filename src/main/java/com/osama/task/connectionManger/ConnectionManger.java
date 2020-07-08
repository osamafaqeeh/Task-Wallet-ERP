package com.osama.task.connectionManger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.logging.Logger;

/**
 * Class of dao level to work with connection.
 *
 * @author Osama Alfaqeeh
 * @see Connection
 */
public class ConnectionManger implements AutoCloseable {

    private static final String RESOURCE_BUNDLE_FILE_NAME = "database";
    private static final String URL_PROPERTY_KEY = "db.url";
    private static final String USER_PROPERTY_KEY = "db.user";
    private static final String PASSWORD_PROPERTY_KEY = "db.password";

    private static final String USER_PROPERTY = "user";
    private static final String PASSWORD_PROPERTY = "password";

    private static final Logger LOGGER = Logger.getLogger(ConnectionManger.class.getName());
    private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle(RESOURCE_BUNDLE_FILE_NAME);

    private Connection connection;

    /**
     * Instantiates a new ConnectionManager.
     */
    public ConnectionManger() {
        creatConnection();
    }

    /**
     * Create connection to chosen database using properties.
     */
    private void creatConnection(){
        String connectionUrlValue = RESOURCE_BUNDLE.getString(URL_PROPERTY_KEY);
        String userValue = RESOURCE_BUNDLE.getString(USER_PROPERTY_KEY);
        String passwordValue = RESOURCE_BUNDLE.getString(PASSWORD_PROPERTY_KEY);

        Properties properties = new Properties();
        properties.put(USER_PROPERTY, userValue);
        properties.put(PASSWORD_PROPERTY, passwordValue);
        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            LOGGER.info("Driver was registered successful.");
        }
        catch (SQLException exception) {
            LOGGER.warning("SQL exception was detected during driver registration. " + exception.getMessage());

        }
        try {
            Connection connection = DriverManager.getConnection(connectionUrlValue, properties);
            LOGGER.info("Connection was created successful.");
            this.connection = connection;

        }
        catch (SQLException exception) {
            LOGGER.warning("Connection hasn't been created, SQL exception was detected during connection creating "+exception.getMessage());
        }
    }

    /**
     * Gets connection.
     *
     * @return the connection.
     */
    public Connection getConnection() {
        return connection;
    }

    /**
     * Implementation of AutoCloseable interface to work with try().
     */
    @Override
    public void close()  {
        try {
            this.connection.close();
        }
        catch (Exception exception){
            LOGGER.warning("Connection hasn't been closed "+exception.getMessage());
        }
    }
}
