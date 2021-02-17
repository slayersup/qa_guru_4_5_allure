package guru.qa.evening5;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.parameter;
import static io.qameta.allure.Allure.step;

public class GitHubIssuesLambdaStepsTests {

    private static final String BASE_URL = "https://github.com/",
            REPOSITORY = "eroshenkoam/allure-example",
            ISSUES = "Issues",
            ISSUE_NAME = "Listeners NamedBy",
            ISSUE_NUMBER = "#68";

    @Test
    @Owner("vfedoseev")
    @Severity(SeverityLevel.CRITICAL)
    @Tags({@Tag("web"), @Tag("critical")})
    @Link(BASE_URL)

    @Feature(ISSUES)
    @Story("Search for issue")
    @DisplayName("Search for issue with name in the repository")
    public void searchIssueWithNameTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        parameter("Repository", REPOSITORY);
        parameter("Issue name", ISSUE_NAME);

        step("Open the main page", () -> {
            open(BASE_URL);
        });
        step("Search for repository " + REPOSITORY, () -> {
            $(".header-search-input").setValue(REPOSITORY).pressEnter();
        });
        step("Go into repository " + REPOSITORY, () -> {
            $(By.linkText(REPOSITORY)).click();
        });
        step("Open the " + ISSUES + " tab", () -> {
            $(withText(ISSUES)).click();
        });
        step("Filter Issues list with " + ISSUE_NAME, () -> {
            $("#js-issues-search").setValue(ISSUE_NAME).pressEnter();
        });
        step("Verify that issue with name " + ISSUE_NAME + " is visible", () -> {
            $(withText(ISSUE_NAME)).shouldBe(visible);
        });
    }

    @Test
    @Disabled
    @Link(BASE_URL)
    @Owner("vfedoseev")
    @Tags({@Tag("web"), @Tag("critical")})

    @Feature(ISSUES)
    @Story("Search for issue")
    @DisplayName("Search for issue with number in the repository") // method equals to previous one, just to test Allure with 2 tests
    public void searchIssueWithNumberTest() {
        parameter("Repository", REPOSITORY);
        parameter("Issue name", ISSUE_NAME);

        step("Open the main page", () -> {
            open(BASE_URL);
        });
        step("Search for repository " + REPOSITORY, () -> {
            $(".header-search-input").setValue(REPOSITORY).pressEnter();
        });
        step("Go into repository " + REPOSITORY, () -> {
            $(By.linkText(REPOSITORY)).click();
        });
        step("Open the " + ISSUES + " tab", () -> {
            $(withText(ISSUES)).click();
        });
        step("Filter Issues list with " + ISSUE_NAME, () -> {
            $("#js-issues-search").setValue(ISSUE_NAME).pressEnter();
        });
        step("Verify that issue with number " + ISSUE_NUMBER + " is visible", () -> {
            $(withText(ISSUE_NUMBER)).shouldBe(visible);
        });
    }
}
