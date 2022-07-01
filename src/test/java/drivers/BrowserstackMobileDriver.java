package drivers;

import com.codeborne.selenide.WebDriverProvider;
import config.Credentials;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class BrowserstackMobileDriver implements WebDriverProvider {

    @Override
    public WebDriver createDriver(Capabilities capabilities) {
        MutableCapabilities mutableCapabilities = new MutableCapabilities();
        mutableCapabilities.merge(capabilities);
        mutableCapabilities.setCapability("browserstack.appium_version", Credentials.config.appiumVersion());
        mutableCapabilities.setCapability("browserstack.user", Credentials.config.user());
        mutableCapabilities.setCapability("browserstack.key", Credentials.config.key());
        mutableCapabilities.setCapability("app", Credentials.config.app());
        mutableCapabilities.setCapability("device", "Samsung Galaxy A10");
        mutableCapabilities.setCapability("os_version", "9.0");
        mutableCapabilities.setCapability("project", "QA.GURU lesson MobileAutotests");
        mutableCapabilities.setCapability("build", "Autotests browserstack");
        mutableCapabilities.setCapability("name", "Test Wikipedia App");

        return new RemoteWebDriver(getBrowserstackUrl(), mutableCapabilities);
    }

    public static URL getBrowserstackUrl() {
        try {
            return new URL(Credentials.config.url());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}