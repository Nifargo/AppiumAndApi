package helpers;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;


public class BaseTest {

    static {
        final AppiumDriverLocalService server;

        Properties prop = new Properties();
        FileInputStream fis;
        try {
            fis = new FileInputStream(System.getProperty("user.dir") + "/src/main/java/data/properties/DataProperties");
            prop.load(fis);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String ipAddress = prop.getProperty("ipAddress");
        String port = prop.getProperty("port");

        server = new AppiumServiceBuilder()
                .withAppiumJS(new File("//usr//local//lib//node_modules//appium//build//lib//main.js"))
                .withIPAddress(ipAddress)
                .usingPort(Integer.parseInt(port))
                .withLogFile(new File("appium.log"))
                .withTimeout(Duration.ofSeconds(30))
                .withArgument(() -> "--relaxed-security")
                .withArgument(() -> "--allow-insecure=chromedriver_autodownload")
                .build();
        server.start();
    }
}