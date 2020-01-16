package core.config;


import com.sun.tools.javac.Main;
import io.vavr.control.Try;
import lombok.Data;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

@Data
public class Config {

    private String url;
    private String windowSize;
    private int waitTime;
    private String testStatusPath;

    private static final Config INSTANCE = new Config();


    private Config() {


        InputStream input = Config.class.getClassLoader().getResourceAsStream("config.properties");

        Properties appProps = new Properties();


        Try.run(() -> appProps.load(input)).onFailure(Throwable::printStackTrace);

        url = appProps.getProperty("url");
        windowSize = appProps.getProperty("windowSize");
        waitTime = Integer.parseInt(appProps.getProperty("implicitlyWait"));
        testStatusPath = appProps.getProperty("testStatusPath");

    }

    public static Config getInstance() {
        return INSTANCE;
    }



}
