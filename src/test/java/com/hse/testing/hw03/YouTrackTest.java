package com.hse.testing.hw03;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class YouTrackTest {
    private ChromeDriver driver;
    private NewIssuePage newIssuePage;
    private IssuePage issuePage;

    private void createIssuesAndTest(List<String> summaries, List<String> descriptions, boolean shouldCreateIssue) {
        for (int i = 0; i < descriptions.size(); i++) {
            newIssuePage.createIssue(summaries.get(i), descriptions.get(i));
        }

        List<Issue> issues = issuePage.getIssues();
        for (int i = 0; i < descriptions.size(); i++) {
            assertEquals(containsIssue(summaries.get(i), descriptions.get(i), issues), shouldCreateIssue);
        }
    }

    private static boolean containsIssue(String summary, String description, List<Issue> issues) {
        Issue checkingIssue = new Issue(summary, description);
        for (Issue issue : issues) {
            if (issue.equals(checkingIssue)) {
                return true;
            }
        }

        return false;
    }

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
        driver = new ChromeDriver();
        LoginPage loginPage = new LoginPage(driver, "http://localhost:8080");
        loginPage.login("root", "1234");
        newIssuePage = new NewIssuePage(loginPage);
        issuePage = new IssuePage(loginPage);
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void simpleIssue() {
        List<String> summaries = Collections.singletonList("sdfsdf");
        List<String> descriptions = Collections.singletonList("skdgnsg");

        createIssuesAndTest(summaries, descriptions, true);
    }

    @Test
    public void emptyDescriptionIssue() throws InterruptedException {
        List<String> summaries = Collections.singletonList("sdfsdf");
        List<String> descriptions = Collections.singletonList("");

        createIssuesAndTest(summaries, descriptions, true);
    }

    @Test
    public void specificSymbolIssue() {
        List<String> summaries = Collections.singletonList("*@$%*^*@&^%@(71047187$*@(");
        List<String> descriptions = Collections.singletonList(" @#R)@# @ R(#R ");

        createIssuesAndTest(summaries, descriptions, true);
    }

    @Test
    public void multilineDescriptionIssue() {
        List<String> summaries = Collections.singletonList("sdgjosi");
        List<String> descriptions = Collections.singletonList("jfios\n" +"sdlf");

        createIssuesAndTest(summaries, descriptions, true);
    }

    @Test
    public void longDescriptionIssue() {
        List<String> summaries = Collections.singletonList("sdgjosi");
        List<String> descriptions = Collections.singletonList("[skpgosfgaskgdsklgasdklg[skpgosfgaskgdsklgasdklg[skpgosfgaskgdsklgasdklg[skpgosfgaskgdsklgasdklg[skpgosfgaskgdsklgasdklg[skpgosfgaskgdsklgasdklg[skpgosfgaskgdsklgasdklg[skpgosfgaskgdsklgasdklg[skpgosfgaskgdsklgasdklg[skpgosfgaskgdsklgasdklg[skpgosfgaskgdsklgasdklg[skpgosfgaskgdsklgasdklg[skpgosfgaskgdsklgasdklg[skpgosfgaskgdsklgasdklg[skpgosfgaskgdsklgasdklg[skpgosfgaskgdsklgasdklg[skpgosfgaskgdsklgasdklg[skpgosfgaskgdsklgasdklg[skpgosfgaskgdsklgasdklg[skpgosfgaskgdsklgasdklg[skpgosfgaskgdsklgasdklg[skpgosfgaskgdsklgasdklg[skpgosfgaskgdsklgasdklg[skpgosfgaskgdsklgasdklg[skpgosfgaskgdsklgasdklg[skpgosfgaskgdsklgasdklg[skpgosfgaskgdsklgasdklg[skpgosfgaskgdsklgasdklg[skpgosfgaskgdsklgasdklg[skpgosfgaskgdsklgasdklg[skpgosfgaskgdsklgasdklg[skpgosfgaskgdsklgasdklg[skpgosfgaskgdsklgasdklg[skpgosfgaskgdsklgasdklg[skpgosfgaskgdsklgasdklg[skpgosfgaskgdsklgasdklg[skpgosfgaskgdsklgasdklg[skpgosfgaskgdsklgasdklg[skpgosfgaskgdsklgasdklg[skpgosfgaskgdsklgasdklg[skpgosfgaskgdsklgasdklg[skpgosfgaskgdsklgasdklg[skpgosfgaskgdsklgasdklg[skpgosfgaskgdsklgasdklg[skpgosfgaskgdsklgasdklg[skpgosfgaskgdsklgasdklg[skpgosfgaskgdsklgasdklg[skpgosfgaskgdsklgasdklg[skpgosfgaskgdsklgasdklg[skpgosfgaskgdsklgasdklg[skpgosfgaskgdsklgasdklg[skpgosfgaskgdsklgasdklg[skpgosfgaskgdsklgasdklg[skpgosfgaskgdsklgasdklg[skpgosfgaskgdsklgasdklg[skpgosfgaskgdsklgasdklg[skpgosfgaskgdsklgasdklg[skpgosfgaskgdsklgasdklg[skpgosfgaskgdsklgasdklg[skpgosfgaskgdsklgasdklg[skpgosfgaskgdsklgasdklg[skpgosfgaskgdsklgasdklg[skpgosfgaskgdsklgasdklg[skpgosfgaskgdsklgasdklg[skpgosfgaskgdsklgasdklg[skpgosfgaskgdsklgasdklg[skpgosfgaskgdsklgasdklg[skpgosfgaskgdsklgasdklg[skpgosfgaskgdsklgasdklg[skpgosfgaskgdsklgasdklg[skpgosfgaskgdsklgasdklg[skpgosfgaskgdsklgasdklg[skpgosfgaskgdsklgasdklg[skpgosfgaskgdsklgasdklg[skpgosfgaskgdsklgasdklg[skpgosfgaskgdsklgasdklg[skpgosfgaskgdsklgasdklg[skpgosfgaskgdsklgasdklg[skpgosfgaskgdsklgasdklg[skpgosfgaskgdsklgasdklg[skpgosfgaskgdsklgasdklg[skpgosfgaskgdsklgasdklg[skpgosfgaskgdsklgasdklg[skpgosfgaskgdsklgasdklg[skpgosfgaskgdsklgasdklg[skpgosfgaskgdsklgasdklg[skpgosfgaskgdsklgasdklg");

        createIssuesAndTest(summaries, descriptions, true);
    }

    @Test
    public void longSummaryIssue() {
        List<String> summaries = Collections.singletonList("sdgjosdjgijsogijsgaksldgjsakgdjladskjglksdgjsadklgasdsisdgjosdjgijsogijsgaksldgjsakgdjladskjglksdgjsadklgasdsisdgjosdjgijsogijsgaksldgjsakgdjladskjglksdgjsadklgasdsisdgjosdjgijsogijsgaksldgjsakgdjladskjglksdgjsadklgasdsisdgjosdjgijsogijsgaksldgjsakgdjladskjglksdgjsadklgasdsisdgjosdjgijsogijsgaksldgjsakgdjladskjglksdgjsadklgasdsisdgjosdjgijsogijsgaksldgjsakgdjladskjglksdgjsadklgasdsisdgjosdjgijsogijsgaksldgjsakgdjladskjglksdgjsadklgasdsisdgjosdjgijsogijsgaksldgjsakgdjladskjglksdgjsadklgasdsisdgjosdjgijsogijsgaksldgjsakgdjladskjglksdgjsadklgasdsisdgjosdjgijsogijsgaksldgjsakgdjladskjglksdgjsadklgasdsisdgjosdjgijsogijsgaksldgjsakgdjladskjglksdgjsadklgasdsisdgjosdjgijsogijsgaksldgjsakgdjladskjglksdgjsadklgasdsisdgjosdjgijsogijsgaksldgjsakgdjladskjglksdgjsadklgasdsisdgjosdjgijsogijsgaksldgjsakgdjladskjglksdgjsadklgasdsisdgjosdjgijsogijsgaksldgjsakgdjladskjglksdgjsadklgasdsisdgjosdjgijsogijsgaksldgjsakgdjladskjglksdgjsadklgasdsisdgjosdjgijsogijsgaksldgjsakgdjladskjglksdgjsadklgasdsisdgjosdjgijsogijsgaksldgjsakgdjladskjglksdgjsadklgasdsisdgjosdjgijsogijsgaksldgjsakgdjladskjglksdgjsadklgasdsisdgjosdjgijsogijsgaksldgjsakgdjladskjglksdgjsadklgasdsisdgjosdjgijsogijsgaksldgjsakgdjladskjglksdgjsadklgasdsisdgjosdjgijsogijsgaksldgjsakgdjladskjglksdgjsadklgasdsisdgjosdjgijsogijsgaksldgjsakgdjladskjglksdgjsadklgasdsisdgjosdjgijsogijsgaksldgjsakgdjladskjglksdgjsadklgasdsisdgjosdjgijsogijsgaksldgjsakgdjladskjglksdgjsadklgasdsisdgjosdjgijsogijsgaksldgjsakgdjladskjglksdgjsadklgasdsisdgjosdjgijsogijsgaksldgjsakgdjladskjglksdgjsadklgasdsisdgjosdjgijsogijsgaksldgjsakgdjladskjglksdgjsadklgasdsisdgjosdjgijsogijsgaksldgjsakgdjladskjglksdgjsadklgasdsisdgjosdjgijsogijsgaksldgjsakgdjladskjglksdgjsadklgasdsisdgjosdjgijsogijsgaksldgjsakgdjladskjglksdgjsadklgasdsisdgjosdjgijsogijsgaksldgjsakgdjladskjglksdgjsadklgasdsisdgjosdjgijsogijsgaksldgjsakgdjladskjglksdgjsadklgasdsisdgjosdjgijsogijsgaksldgjsakgdjladskjglksdgjsadklgasdsi");
        List<String> descriptions = Collections.singletonList("jfios");

        createIssuesAndTest(summaries, descriptions, true);
    }

    @Test
    public void twoSimpleIssues() {
        List<String> summaries = Arrays.asList("sdfsdf", "wfkkefwf");
        List<String> descriptions = Arrays.asList("jowefjiowef", "lijgqioew");

        createIssuesAndTest(summaries, descriptions, true);
    }

    @Test
    public void russianDescriptionIssue() {
        List<String> summaries = Collections.singletonList("sdfsdf");
        List<String> descriptions = Collections.singletonList("лыоывпарылврпцруцу");

        createIssuesAndTest(summaries, descriptions, true);
    }

    @Test
    public void russianSummaryIssue() {
        List<String> summaries = Collections.singletonList("ышщващгцуп");
        List<String> descriptions = Collections.singletonList("jdfigweuweqf");

        createIssuesAndTest(summaries, descriptions, true);
    }

    @Test
    public void unprintableSummaryIssue() {
        List<String> summaries = Collections.singletonList("¶");
        List<String> descriptions = Collections.singletonList("jdfigweuweqf");

        createIssuesAndTest(summaries, descriptions, true);
    }

    @Test
    public void unprintableDescriptionIssue() {
        List<String> descriptions = Collections.singletonList("¶");
        List<String> summaries = Collections.singletonList("jdfigweuweqf");

        createIssuesAndTest(summaries, descriptions, true);
    }

    @Test
    public void emptySummaryIssue() {
        List<String> descriptions = Collections.singletonList("slkdlgks");
        List<String> summaries = Collections.singletonList("");

        createIssuesAndTest(summaries, descriptions, false);
    }
}