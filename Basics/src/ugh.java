import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.sql.Driver;


public class ugh {
    public class parameterized {

        public static String printStatement = " Hello 2";
        public static String driver = "webdriver.chrome.driver";
        public static String path = "src\\chromedriver.exe";
        public static String argument = "--remote-allow-origins=*";
        public static String URL = "https://www.saucedemo.com/";
        public static String expectedTitle = "Swag Labs";
        public static String usernameId = "user-name";

        public static String userName = "standard_user";
        public static String passwordId = "password";

        public static String pasow;
    }

    public static void main(String[] args) throws Exception {
        System.out.print(parameterized.printStatement);
        try{
            System.setProperty("webdriver.chrome.driver","src\\chromedriver.exe");
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--remote-allow-origins=*");
            WebDriver driver = new ChromeDriver(chromeOptions);
            driver.manage().window().maximize();
            driver.get("https://www.saucedemo.com/");
            String actualTitle = driver.getTitle();
            String expectedTitle = "Swag Labs";
            if (actualTitle.equals(expectedTitle)) {
                System.out.println(
                        "Title Verification Passed:\n" +
                                "Expected Title: " + expectedTitle + "\n" +
                                "Actual Title: " + actualTitle);
            } else {
                System.out.println(
                        "Title Verification Failed:\n" +
                                "Expected Title: " + expectedTitle + "\n" +
                                "Actual Title: " + actualTitle);
            }
            String userName = "standard_user";
            WebElement userNameTextBox = driver.findElement(By.id("user-name"));
            userNameTextBox.sendKeys(userName);

            String password = "secret_sauce";
            WebElement passwordTextBox = driver.findElement(By.id("password"));
            passwordTextBox.sendKeys(password);

            WebElement logInButton = driver.findElement(By.id("login-button"));
            logInButton.click();
            Thread.sleep(3000);
            String expectedResult = "Products";
            WebElement title = driver.findElement(By.xpath("//span[@class='title']"));
            String actualResult = title.getText();
            if(actualResult.equals(expectedResult)){
                System.out.println(
                        "Title Verification Passed:\n" +
                                "Expected Title: " + expectedResult + "\n" +
                                "Actual Title: " + actualResult);
            } else {
                System.out.println(
                        "Title Verification Failed:\n" +
                                "Expected Title: " + expectedResult + "\n" +
                                "Actual Title: " + actualResult);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}