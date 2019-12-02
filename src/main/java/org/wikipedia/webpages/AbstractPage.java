package org.wikipedia.webpages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;

public abstract class AbstractPage {

    protected WebDriver driver;
    private FluentWait wait;


    public AbstractPage(
            WebDriver driver
    ) {
        this.driver = driver;

        PageFactory.initElements(driver, this);

        this.wait = new FluentWait<WebDriver>((WebDriver) driver)
                .pollingEvery(Duration.ofMillis(500))
                .withTimeout(Duration.ofSeconds(5))
                .ignoring(WebDriverException.class)
                .ignoring(NoSuchElementException.class);

        PageFactory.initElements(driver, this);

    }

    protected FluentWait getWait() {
        return wait;
    }
}
