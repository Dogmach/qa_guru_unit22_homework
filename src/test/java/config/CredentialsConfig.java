package config;
import org.aeonbits.owner.Config;

@Config.Sources({"classpath:config/credentials.properties"})
public interface CredentialsConfig extends Config {
    // для запуска тестов через BrowserStack
    String user();

    String key();

    String app();

    String url();

    String appPackage();

    String appiumVersion();

    String platformName();

    String appActivity();

    // имя эмулятора
    String deviceName();

    // реальное мобильное устройство
    String deviceNameReal();
}