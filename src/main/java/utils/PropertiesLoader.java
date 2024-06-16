package utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesLoader {
    private static final String PROPERTIES_FILE_NAME="application.properties";
    private static PropertiesLoader propertiesLoader;
    private Properties configuration;
    public static PropertiesLoader getInstance() {
       if(propertiesLoader!=null){
           return propertiesLoader;
       }
       propertiesLoader=new PropertiesLoader();
       return propertiesLoader;
    }
    public Properties getProperties(){
        return this.configuration;
    }
    private PropertiesLoader(){
        try {
            configuration = new Properties();
            InputStream inputStream = PropertiesLoader.class
                .getClassLoader()
                .getResourceAsStream(PROPERTIES_FILE_NAME);
            configuration.load(inputStream);
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
