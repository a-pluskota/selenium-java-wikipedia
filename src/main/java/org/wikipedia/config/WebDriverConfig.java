package org.wikipedia.config;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/**
 * This class provides WebDriver configuration.
 */
public class WebDriverConfig {

    private static final Logger logger = Logger.getLogger(WebDriverConfig.class);
    private static final String HEADLESS_MODE = System.getProperty("HEADLESS_MODE");

    /**
     * Uses the WebDriver implementation, which controls the Chrome browser,
     * to run tests on the local machine using Chrome.
     * In addition, if the HEADLESS_MODE system property is set to "on",
     * it uses the WebDriver interface option to manage headless browsing.
     *
     * @return ChromeDriver
     * @throws IllegalArgumentException
     */
    public static WebDriver getWebDriver() throws IllegalArgumentException {

        if (HEADLESS_MODE == null) {
            return getChromeDriver();

        } else if (HEADLESS_MODE.toLowerCase().equals("on")) {
            return getHeadlessChromeDriver();

        } else {
            throw new IllegalArgumentException("Parameter HEADLESS_MODE contains incorrect value.");
        }
    }

    private static WebDriver getChromeDriver() {

        WebDriverManager
                .chromedriver()
                .setup();

        logger.info("Starts running Chrome browser on the local machine.");

        return new ChromeDriver();

    }

    private static WebDriver getHeadlessChromeDriver() {

        getChromeDriver();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("--disable-gpu");

        logger.info("Starts running Chrome browser in headless mode on the local machine.");

        return new ChromeDriver(options);

    }
}
