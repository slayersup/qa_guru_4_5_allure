package guru.qa.evening5;

import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class BaseSteps {

    private static final String BASE_URL = "https://github.com/";

    @Step("Open the main page")
    public void openMainPage() {
        open(BASE_URL);
    }

    @Step("Search for repository {repositoryName}")
    public void searchForRepository(final String repositoryName) {
        $(".header-search-input").setValue(repositoryName).pressEnter();
    }

    @Step("Go into repository {repositoryName}")
    public void goToRepositoryFromSearch(final String repositoryName) {
        $(By.linkText(repositoryName)).click();
    }

    @Step("Open the {tabName} tab")
    public void goToDefinedTab(final String tabName) {
        $(withText(tabName)).click();
    }

    @Step("Filter Issues list with {issueName}")
    public void filterOutIssuesWithName(final String issueName) {
        $("#js-issues-search").setValue(issueName).pressEnter();
    }

    @Step("Verify that issue with name {issueName} is visible")
    public void shouldSeeIssueWithName(final String issueName) {
        $(withText(issueName)).shouldBe(visible);
    }

    @Step("Create issue with name {issueNumber}") // method equals to previous one, just to test Allure with 2 tests
    public void shouldSeeIssueWithNumber(final String issueNumber) {
        $(withText(issueNumber)).shouldBe(visible);
    }
}
