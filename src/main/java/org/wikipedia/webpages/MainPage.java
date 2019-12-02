package org.wikipedia.webpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends AbstractPage {

    @FindBy(css = ".mw-wiki-logo")
    private WebElement logo;

    @FindBy(css = "'#searchInput'")
    private WebElement searchInput;

    @FindBy(css = "body > div.suggestions > a")
    private WebElement containingSearchSuggestionLink;

    @FindBy(css = "body > div.suggestions > a > div")
    private WebElement containingSearchSuggestion;

    @FindBy(css = "#mw-panel")
    private WebElement sidebar;


    public MainPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getLogo() {

        return logo;
    }

    public WebElement getSearchInput() {
        return searchInput;
    }

    public WebElement getContainingSearchSuggestionLink() {
        return containingSearchSuggestionLink;
    }

    public WebElement getContainingSearchSuggestion() {
        return containingSearchSuggestion;
    }

    public WebElement getSidebar() {
        return sidebar;
    }
}
