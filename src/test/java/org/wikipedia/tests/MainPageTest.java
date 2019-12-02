package org.wikipedia.tests;

import org.junit.jupiter.api.Test;
import org.wikipedia.webpages.MainPage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.wikipedia.resources.Constants.MAIN_PAGE_URL;
import static org.wikipedia.resources.Constants.SEARCH_TEXT;

public class MainPageTest extends AbstractTest {

    private MainPage mainPage = new MainPage(driver);

    @Test
    public void urlDoNotChangeAfterOpeningMainPage() {

        assertEquals(MAIN_PAGE_URL,
                driver.getCurrentUrl(),
                "Url was changed after opening Main Page.");
    }

    @Test
    public void logoIsDisplayedOnMainPage() {

        assertTrue(
                mainPage
                        .getLogo()
                        .isDisplayed(),
                "Logo is not displayed on Main Page.");
    }

    @Test
    public void sidebarIsDisplayedOnMainPage() {

        assertTrue(
                mainPage
                        .getSidebar()
                        .isDisplayed(),
                "Sidebar is not displayed on Main Page.");
    }

    @Test
    public void searchBarIsDisplayedOnMainPage() {

        assertTrue(
                mainPage
                        .getSearchInput()
                        .isDisplayed(),
                "Search bar is not displayed on Main Page.");
    }

    @Test
    public void suggestionsAreShownAfterTypingTextInSearchBar() {

        mainPage.typeTextInSearchBar(SEARCH_TEXT);

        assertTrue(
                mainPage
                        .getContainingSearchSuggestion()
                        .isDisplayed(),
                "Suggestions are not displayed on Main Page.");
    }

    @Test
    public void urlRedirectedToSuggestionsHrefAfterClickingOnIt() {

        mainPage.typeTextInSearchBar(SEARCH_TEXT);

        String suggestionsHref = mainPage
                .getContainingSearchSuggestionLink()
                .getAttribute("href");

        mainPage
                .getContainingSearchSuggestionLink()
                .click();

        assertTrue(
                driver
                        .getCurrentUrl()
                        .contains(suggestionsHref),
                "Url was not redirected to suggestions href.");
    }


}
