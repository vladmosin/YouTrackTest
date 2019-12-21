package com.hse.testing.hw03;

public class NewIssuePage extends Page {
    public NewIssuePage(Page from) {
        super(from);
    }

    public void createIssue(String summaryText, String descriptionText) {
        String editSummaryClass = "edit-summary";
        String editDescriptionClass = "edit-description";
        String submitButtonClass = "submit-btn";
        String createIssueButtonClass = "yt-header__create-btn";

        toHome();

        elementsByClass(createIssueButtonClass).get(0).click();
        elementsByClass(editSummaryClass).get(0).sendKeys("");
        elementsByClass(editSummaryClass).get(0).sendKeys(summaryText);
        elementsByClass(editDescriptionClass).get(0).sendKeys(descriptionText);
        elementsByClass(submitButtonClass).get(0).click();
    }
}