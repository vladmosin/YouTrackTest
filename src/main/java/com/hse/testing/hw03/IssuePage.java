package com.hse.testing.hw03;

import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

public class IssuePage extends Page {

    private static final String issueIdAnchor = "issueIdAnchor";

    public IssuePage(Page from) {
        super(from);
    }

    public List<Issue> getIssues() {
        toIssues();

        List<String> labels = elementsByClass(issueIdAnchor).stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
        return labels.stream()
                .map(label -> {
                    Issue issue = getIssueByLabel(label);
                    elementsById("id_l.I.tb.backToSearch").get(0).click();
                    return issue;
                })
                .collect(Collectors.toList());
    }

    private Issue getIssueByLabel(String label) {
        toIssues();

        for (WebElement element : elementsByClass(issueIdAnchor)) {
            if (element.getText().equals(label)) {
                element.click();
                return new Issue(this);
            }
        }
        return null;
    }
}