package org.wikipedia.webpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends AbstractPage {

    @FindBy(css = ".mw-wiki-logo")
    private WebElement searchResultsListHeader;

    public SearchPage(WebDriver driver) {
        super(driver);
    }
}
