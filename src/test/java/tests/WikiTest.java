package tests;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;
import io.appium.java_client.AppiumBy;

import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;

public class WikiTest extends TestBase {

    @Test
    void onboardingTest() {
        step("Verify First Page Getting Started", () -> {
            $(AppiumBy.id("org.wikipedia.alpha:id/primaryTextView"))
                    .shouldHave(Condition.text("The Free Encyclopedia …in over 300 languages"));
            $(AppiumBy.id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")).click();
        });
        step("Verify Second Page Getting Started", () -> {
            $(AppiumBy.id("org.wikipedia.alpha:id/primaryTextView"))
                    .shouldHave(Condition.text("New ways to explore"));
            $(AppiumBy.id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")).click();
        });
        step("Verify Third Page Getting Started", () -> {
            $(AppiumBy.id("org.wikipedia.alpha:id/primaryTextView"))
                    .shouldHave(Condition.text("Reading lists with sync"));
            $(AppiumBy.id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")).click();
        });
        step("Verify Fourth Page Getting Started", () -> {
            $(AppiumBy.id("org.wikipedia.alpha:id/primaryTextView"))
                    .shouldHave(Condition.text("Send anonymous data"));
            $(AppiumBy.id("org.wikipedia.alpha:id/fragment_onboarding_done_button")).click();
        });
        step("Verify Open Home screen", () ->
                $(AppiumBy.id("org.wikipedia.alpha:id/main_toolbar_wordmark"))
                        .shouldBe(Condition.visible));
    }
}