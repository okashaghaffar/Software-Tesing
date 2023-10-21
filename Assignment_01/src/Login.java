import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Login {

    public  static void LaunchChrome(String chromepath){
        try{
            System.setProperty("webdriver.chrome.driver", chromepath);
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--remote-allow-origins=*");
            WebDriver driver = new ChromeDriver(chromeOptions);
            Parameterized.driver=driver;
            driver.manage().window().maximize();
        } catch (Exception e) {
            System.out.println(e);
        }

    }
    public static void NavigatetoURL (String URL){
        try{
            Parameterized.driver.get(URL);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public static void enterText(String text_Box, String element_Id){
        WebElement userNameTextBox = Parameterized.driver.findElement(By.id(element_Id));
        userNameTextBox.sendKeys(text_Box);
    }
    public static void clickButton(String login_id) throws InterruptedException {
        WebElement logInButton = Parameterized.driver.findElement(By.id(login_id));
        logInButton.click();

    }
    public  static  void Sleep() throws InterruptedException {
        Thread.sleep(3000);

    }

}
