package browser_Language;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.SQLException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Language {
    public static WebDriver driver;

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        System.setProperty("webdriver.chrome.driver", "C:\\webDriver\\chromedriver.exe");
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--lang=ru");//en-GB
        WebDriver driver = new ChromeDriver(chromeOptions);
        //driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://spotify.com");
//        new WebDriverWait(driver, Duration.ofSeconds(10, 500)).withMessage("Can't find телевизоры")
//                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@value='samsung']"))).click();
        // driver.findElement(By.xpath("//input[@value='samsung']")).click();
        //driver.close();


//         driver = new ChromeDriver();
//        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//        driver.manage().window().maximize();
//
//        driver.get("http://market.yandex.ru/");
//
//        driver.findElement(By.xpath("//a[text()='Бытовая техника']")).click();
//        driver.findElement(By.xpath("//a[text()='Стиральные машины']")).click();
//
//        selectCheckBox("ATLANT");
//        selectCheckBox("Bosch");
//        selectCheckBox("Candy");
//
//        deselectCheckBox("Bosch");

//        System.out.println();
//
//        System.out.println(driver.findElement(By.xpath("//label[text()='Самовывоз']/span/input")).isSelected());
//        driver.findElement(By.xpath("//label[text()='Самовывоз']/span")).click();
//        System.out.println(driver.findElement(By.xpath("//label[text()='Самовывоз']/span/input")).isSelected());
//        driver.findElement(By.xpath("//label[text()='С доставкой']/span")).click();
//        driver.quit();
    }
//
//    public static void selectCheckBox(String name) {
//        String rbXpath = "//label[text()='%s']/preceding-sibling::span";
//        if (!driver.findElement(By.xpath(String.format(rbXpath, name) + "/input")).isSelected())
//            driver.findElement(By.xpath(String.format(rbXpath, name))).click();
//    }
//
//    public static void deselectCheckBox(String name) {
//        String rbXpath = "//label[text()='%s']/preceding-sibling::span";
//        if (driver.findElement(By.xpath(String.format(rbXpath, name) + "/input")).isSelected())
//            driver.findElement(By.xpath(String.format(rbXpath, name))).click();
//    }

}
