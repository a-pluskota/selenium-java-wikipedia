package org.wikipedia.webpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import java.util.List;

public class SearchPage extends AbstractPage {

    public static final By SEARCH_RESULT_HEADER = By.cssSelector(".mw-search-result-heading > a");
    public static final By SEARCH_RESULT_ABSTRACT = By.cssSelector(".searchresult");
    public static final By SEARCH_RESULT_DATA = By.cssSelector(".mw-search-result-data");

    @FindBy(css = "#firstHeading")
    private WebElement searchResultsListHeader;

    @FindBys(@FindBy(xpath = "//ul[@class='mw-search-results']//li"))
    private List<WebElement> searchResultsList;

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getSearchResultsListHeader() {
        return searchResultsListHeader;
    }

    public List<WebElement> getSearchResultsList() {
        return searchResultsList;
    }

    public WebElement getSearchResultsListWebElementOfIndex(
            By locator,
            int index
    ) {

        return searchResultsList
                .get(index)
                .findElement(locator);
    }

    public boolean validateEverySearchResultsElementContains(
            By locator
    ) {

        for (int i = 1; i < searchResultsList.size(); i++) {

            boolean isEverySearchResultsElementContainingLocator = getSearchResultsListWebElementOfIndex(
                    locator,
                    i)
                    .isDisplayed();

            if(!isEverySearchResultsElementContainingLocator) {

                return false;
            }
        }

        return true;
    }
}
