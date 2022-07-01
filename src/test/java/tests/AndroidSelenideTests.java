package tests;

import com.codeborne.selenide.Condition;
import io.appium.java_client.AppiumBy;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class AndroidSelenideTests extends TestBase {

    @Test
    @Owner("QA.GURU")
    @DisplayName("First start WiKi and reading some messages about function of it")
    void searchNewWikiTest() {
        step("Verify First Welcome Page", () -> {
            $(AppiumBy.id("org.wikipedia.alpha:id/primaryTextView"))
                    .shouldHave(Condition.text("The Free Encyclopedia …in over 300 languages"));
            $(AppiumBy.id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")).click();
        });
        step("Verify Second Welcome Page", () -> {
            $(AppiumBy.id("org.wikipedia.alpha:id/primaryTextView"))
                    .shouldHave(Condition.text("New ways to explore"));
            $(AppiumBy.id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")).click();
        });
        step("Verify Third Welcome Page", () -> {
            $(AppiumBy.id("org.wikipedia.alpha:id/primaryTextView"))
                    .shouldHave(Condition.text("Reading lists with sync"));
            $(AppiumBy.id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")).click();
        });
        step("Verify Fourth Welcome Page", () -> {
            $(AppiumBy.id("org.wikipedia.alpha:id/primaryTextView"))
                    .shouldHave(Condition.text("Send anonymous data"));
            $(AppiumBy.id("org.wikipedia.alpha:id/fragment_onboarding_done_button")).click();
        });
        step("Looking for Stan Lee", () -> {
            $(AppiumBy.accessibilityId("Search Wikipedia")).click();
            $(AppiumBy.id("org.wikipedia.alpha:id/search_src_text")).setValue("Stan Lee");
        });
        step("Verify content found", () ->
                $$(AppiumBy.id("org.wikipedia.alpha:id/page_list_item_title")).shouldHave(sizeGreaterThan(0)));
    }

    @Owner("QA.GURU")
    @Test
    @DisplayName("Trying to find information about some interesting persons...")
    void searchTest() {
        step("Looking for Chris Evans", () -> {
            step("Go ahead without welcome window", () ->
                    $(AppiumBy.id("org.wikipedia.alpha:id/fragment_onboarding_skip_button")).click());
            $(AppiumBy.accessibilityId("Search Wikipedia")).click();
            $(AppiumBy.id("org.wikipedia.alpha:id/search_src_text"))
                    .setValue("Chris Evans");
        });
        step("Verify that content found", () -> {
            $$(AppiumBy.className("android.widget.TextView"))
                    .shouldHave(sizeGreaterThan(0));
            $$(AppiumBy.className("android.widget.TextView"))
                    .findBy(text("Chris Evans")).click();});
        sleep(2000);

        step("Go back for new search", () -> {
            step("Go back", () -> back());
            step("Again Go back", () -> back());
            step(" AND Go back", () -> back());
            $(AppiumBy.accessibilityId("Search Wikipedia")).click();
        });
        step("Looking for Captain America", () -> {
            $(AppiumBy.id("org.wikipedia.alpha:id/search_src_text"))
                    .setValue("Captain America");
            $$(AppiumBy.className("android.widget.TextView"))
                    .shouldHave(sizeGreaterThan(0));
            $$(AppiumBy.className("android.widget.TextView"))
                    .findBy(text("Captain America")).click();});
        sleep(2000);
    }
}