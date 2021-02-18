package guru.qa.evening5;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class GitHubIssuesMethodsStepTests {

    public BaseSteps steps = new BaseSteps();

    private static final String REPOSITORY = "eroshenkoam/allure-example",
            ISSUES = "Issues",
            ISSUE_NAME = "Listeners NamedBy",
            ISSUE_NUMBER = "#68";

    @Test
    public void searchIssueWithNameTest(){
        SelenideLogger.addListener("allure", new AllureSelenide());

        steps.openMainPage();

        steps.searchForRepository(REPOSITORY);
        steps.goToRepositoryFromSearch(REPOSITORY);
        steps.goToDefinedTab(ISSUES);
        steps.filterOutIssuesWithName(ISSUE_NAME);

        steps.shouldSeeIssueWithName(ISSUE_NAME);
    }

    @Test
    @Disabled
    public void createIssueWithNameTest(){ // method equals to previous one, just to test Allure with 2 tests
        steps.openMainPage();

        steps.searchForRepository(REPOSITORY);
        steps.goToRepositoryFromSearch(REPOSITORY);
        steps.goToDefinedTab(ISSUES);
        steps.filterOutIssuesWithName(ISSUE_NAME);

        steps.shouldSeeIssueWithNumber(ISSUE_NUMBER);
    }
}
