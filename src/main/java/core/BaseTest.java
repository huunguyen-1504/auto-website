package core;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {
    private WebDriver driver;

    @Parameters({"browserName"})
    @BeforeClass
    public void before(String browserName) throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setPlatform(Platform.WINDOWS);
        if (browserName.equals("Chrome")){
            desiredCapabilities.setBrowserName(BrowserType.CHROME);
            driver = new RemoteWebDriver(new URL("http://localhost:5566/wd/hub"),desiredCapabilities);
        }
        if (browserName.equals("Firefox")){
            desiredCapabilities.setBrowserName(BrowserType.FIREFOX);
            driver = new RemoteWebDriver(new URL("http://localhost:5567/wd/hub"),desiredCapabilities);
        }
        setDriver(driver);
        getDriver().manage().window().maximize();
    }


    @AfterClass
    public void after() {
        getDriver().quit();
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }
}
