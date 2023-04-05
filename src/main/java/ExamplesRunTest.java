import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import java.util.concurrent.TimeUnit;

public class ExamplesRunTest {


    public static void main (String [] args){
        WebDriver driver = new ChromeDriver();
        driver.get("https://parabank.parasoft.com/parabank/index.htm");

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        System.out.println(driver.getTitle());

        driver.findElement(By.name("password")).sendKeys("Mayowa123");
        driver.findElement(By.name("username")).sendKeys("Ade");
        driver.findElement(By.className("button")).click();
        System.out.println(driver.getTitle());



        driver.findElement(By.cssSelector("#headerPanel > ul.button > li.home > a")).click();

       driver.findElement(By.cssSelector("#leftPanel > ul > li:nth-child(1) > a")).click();

    }
}
