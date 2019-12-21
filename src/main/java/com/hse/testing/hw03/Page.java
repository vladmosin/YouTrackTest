package com.hse.testing.hw03;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class Page {
    private static final int TIMEOUT = 2;
    private final WebDriver driver;
    private final WebDriverWait wait;

    public Page(WebDriver driver, String url) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, TIMEOUT);
        driver.get(url);
    }

    public Page(Page from) {
        this.driver = from.driver;
        this.wait = from.wait;
    }

    public List<WebElement> elementsByClass(String className) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(className)));
        return driver.findElements(By.className(className));
    }

    public List<WebElement> elementsById(String id) {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id(id)));
        return driver.findElements(By.id(id));
    }

    public void toHome() {
        String homeButtonClass = "ring-menu__logo";
        elementsByClass(homeButtonClass).get(0).click();
    }

    public void toIssues() {
        String issuesPageClass = "ring-menu__item__i";
        toHome();
        elementsByClass(issuesPageClass).get(0).click();
    }
}
