package com.hse.testing.hw03;

import java.util.Objects;

public class Issue {
    private final String summary;
    private final String description;

    public Issue(Page from) {
        String issueSummaryId = "id_l.I.ic.icr.it.issSum";
        String descriptionId = "id_l.I.ic.icr.d.description";

        summary = getText(from, issueSummaryId);
        description = getText(from, descriptionId);
    }

    public Issue(String summary, String description) {
        this.summary = summary;
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Issue)) return false;
        Issue issue = (Issue) o;
        return description.equals(issue.description) && summary.equals(issue.summary);
    }

    @Override
    public int hashCode() {
        return Objects.hash(summary, description);
    }

    @Override
    public String toString() {
        return  "summary='" + summary + "'" +
                ", description='" + description + "'";
    }

    private static String getText(Page page, String elementId) {
        return page.elementsById(elementId).get(0).getText();
    }
}
