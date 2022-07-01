package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import config.Credentials;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import java.util.concurrent.ExecutionException;

import static com.codeborne.selenide.Selenide.open;
import static helpers.Attach.getSessionId;
import static com.codeborne.selenide.logevents.SelenideLogger.addListener;
import static drivers.DeviceDriver.getDeviceDriver;
import static io.qameta.allure.Allure.step;

public class TestBase {
    private static final String device = System.getProperty("device");
    @BeforeAll
    public static void setup() {
        Configuration.browser = getDeviceDriver(device);
        Configuration.browserSize = null;
    }
    @BeforeEach
    public void startDriver() {
        addListener("AllureSelenide", new AllureSelenide());
        open();
    }
    @AfterEach
    public void afterEach() throws ExecutionException {
        String sessionId = getSessionId();
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        step("Close driver", Selenide::closeWebDriver);

        if (Credentials.isBrowserStack()) {
            Attach.video(sessionId);
        }
    }
}