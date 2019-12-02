package org.wikipedia.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import org.wikipedia.webpages.MainPage;
import org.wikipedia.webpages.SearchPage;

import static org.junit.jupiter.api.Assertions.*;
import static org.wikipedia.resources.Constants.*;
import static org.wikipedia.webpages.SearchPage.*;

public class SearchPageTest extends AbstractTest {

    private SearchPage searchPage;

    @BeforeEach
    public void setUpSearchPage() {

        this.searchPage = new MainPage(driver)
                .searchForPhrase(SEARCH_TEXT);
    }

    @Test
    public void searchResultsListHeaderIsDisplayedWithCorrectTitle() {

        assertTrue(
                searchPage
                        .getSearchResultsListHeader()
                        .isDisplayed(),
                "Search results list header is not displayed.");

        assertEquals(
                SEARCH_RESULTS_HEADER_TEXT,
                searchPage
                        .getSearchResultsListHeader()
                        .getText(),
                String.format("Search results list header do not have title %s.", SEARCH_RESULTS_HEADER_TEXT));
    }

    @Test
    public void searchResultsListIsDisplayed() {

        assertFalse(
                searchPage
                        .getSearchResultsList()
                        .isEmpty(),
                "Search results list is not displayed.");
    }

    @Test
    public void everySearchResultsListElementContainsHeader() {

        assertTrue(
                searchPage
                        .validateEverySearchResultsElementContains(SEARCH_RESULT_HEADER),
                "Not every search results list element contains header.");
    }

    @Test
    public void everySearchResultsListElementContainsAbstract() {

        assertTrue(
                searchPage
                        .validateEverySearchResultsElementContains(SEARCH_RESULT_ABSTRACT),
                "Not every search results list element contains abstract.");
    }

    @Test
    public void everySearchResultsListElementContainsSearchResultData() {

        assertTrue(
                searchPage
                        .validateEverySearchResultsElementContains(SEARCH_RESULT_DATA),
                "Not every search results list element contains search result data.");
    }

    @Test
    public void urlRedirectedToSearchResultsListElementHeaderHrefAfterClickingOnIt() {

        WebElement searchResultsListElementHeaderHref = searchPage
                .getSearchResultsListWebElementOfIndex(
                        SEARCH_RESULT_HEADER,
                        1);

        String headerHref = searchResultsListElementHeaderHref
                .getAttribute("href");

        searchResultsListElementHeaderHref.click();

        assertTrue(
                driver
                        .getCurrentUrl()
                        .contains(headerHref),
                "Url was not redirected to search results list element header href.");
    }

}
