package guru.qa.evening5;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

public class GitHubIssuesTests {

    private static final String REPOSITORY = "eroshenkoam/allure-example",
                                ISSUE_NAME = "Listeners NamedBy";

    @Test
    public void issueWithNameSearchTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        open("https://github.com/");

        $(".header-search-input").setValue(REPOSITORY).pressEnter();
        $(By.linkText(REPOSITORY)).click();
        $(withText("Issues")).click();
        $("#js-issues-search").setValue(ISSUE_NAME).pressEnter();

        $(withText(ISSUE_NAME)).shouldBe(visible);
    }
}
