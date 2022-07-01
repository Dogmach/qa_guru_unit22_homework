package config;

import org.aeonbits.owner.ConfigFactory;

public class Credentials {

    public static CredentialsConfig config = ConfigFactory.create( CredentialsConfig.class);

    public static boolean isBrowserStack() {
        return System.getProperty("device").equals("browserstack");
    }
    public static String deviceTest() {
        if(System.getProperty("device").equals("real")){
            return config.deviceNameReal();
        }
        return config.deviceName();
    }
}