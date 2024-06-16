package db;

import utils.PropertiesLoader;

public class DatabaseConnection {
    private String host;
    private String user;
    private String password;

    public DatabaseConnection(){
        host= PropertiesLoader.getInstance().getProperties().getProperty("database_host");
        user= PropertiesLoader.getInstance().getProperties().getProperty("database_user_name");
        password= PropertiesLoader.getInstance().getProperties().getProperty("database_password");
    }

    public String getHost() {
        return host;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }
}
