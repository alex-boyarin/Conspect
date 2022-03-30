package selenium;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumExample {
    public static void main(String[] args) {
//        System.setProperty("webdriver.chrome.driver", "C:\\webDriver\\chromedriver.exe");
//
//        WebDriver webDriver = new ChromeDriver();
//        webDriver.manage().window().maximize();
//        webDriver.get("https://www.onliner.by");
//        webDriver.getCurrentUrl();

//        System.setProperty("webdriver.chrome.driver", "C:\\webDriver\\chromedriver.exe");
//        WebDriverManager.chromedriver().setup();
//        WebDriver driver = new ChromeDriver();
//        driver.get("http://www.google.com");
        System.setProperty("webdriver.chrome.driver", "C:\\webDriver\\chromedriver.exe");
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.onliner.by");

    }
}
