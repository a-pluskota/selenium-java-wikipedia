package org.wikipedia.tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.wikipedia.config.WebDriverConfig;

import static org.wikipedia.resources.Constants.MAIN_PAGE_URL;

public abstract class AbstractTest {

    protected WebDriver driver;

    public AbstractTest() {

        this.driver = WebDriverConfig.getWebDriver();

    }

    @BeforeEach
    public void setUp() {

        driver.get(MAIN_PAGE_URL);

    }

    @AfterEach
    public void setDown() {

        driver.quit();

    }
}
