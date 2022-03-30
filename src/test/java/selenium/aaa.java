package selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import java.time.Duration;

public class aaa {
    static WebDriver driver;

    @Test
    public void ddd(){
        System.setProperty("webdriver.chrome.driver", "C:\\webDriver\\chromedriver.exe");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5,1000));
        driver.get("https://www.spotify.com/by-ru/");
    }
}
