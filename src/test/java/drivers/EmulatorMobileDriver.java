package drivers;

import com.codeborne.selenide.WebDriverProvider;
import config.Credentials;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.AutomationName;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import static org.apache.commons.io.FileUtils.copyInputStreamToFile;

public class EmulatorMobileDriver implements WebDriverProvider {

    @Override
    public WebDriver createDriver(Capabilities capabilities) {
        File app = getApp();

        UiAutomator2Options options = new UiAutomator2Options();
        options.merge(capabilities);
        options.setAutomationName(AutomationName.ANDROID_UIAUTOMATOR2);
        options.setPlatformName(Credentials.config.platformName());
        options.setDeviceName(Credentials.deviceTest());
//        options.setPlatformVersion("11.0");
        options.setLanguage("en");
        options.setLocale("en");
        options.setApp(app.getAbsolutePath());
//        Явное описание пакета и Активности
        options.setAppPackage(Credentials.config.appPackage());
        options.setAppActivity(Credentials.config.appActivity());
//
        return new AndroidDriver(getAppiumServerUrl(), options);
    }
    private File getApp() {
        String appPath = "src/test/resources/apk/app-alpha-universal-release.apk";
        String appUrl = "https://github.com/wikimedia/apps-android-wikipedia/" +
                "releases/download/latest/app-alpha-universal-release.apk?raw=true";
        File app = new File(appPath);
        if (!app.exists()) {
            String url = appUrl;
            try (InputStream in = new URL(url).openStream()) {
                copyInputStreamToFile(in, app);
            } catch (IOException e) {
                throw new AssertionError(" Failed download apk");
            }
        }
        return app;
    }

    public static URL getAppiumServerUrl() {
        try {
            return new URL("http://localhost:4723/wd/hub");
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}