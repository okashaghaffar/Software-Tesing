import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;

public class method{
    public static String chromepath = "src\\driver\\chromedriver.exe";

    public static WebDriver driver;
    public static String url = "https://www.saucedemo.com/";
    public static String expectedTitle = "Swag Labs";
    public static String userName = "standard_user";
    public static String userId = "user-name";
    public static String password = "secret_sauce";
    public static String passwordId = "password";

//    public static String login_id = "login-button";

    public static void LaunchChrome(){
        try{
            System.setProperty("webdriver.chrome.driver", chromepath);
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--remote-allow-origins=*");
            driver = new ChromeDriver(chromeOptions);
            driver.manage().window().maximize();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public static void NavigatetoURL (String URL){
        try{
            driver.get(URL);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public static void Matching(String expectedResult){
        String actualTitle = driver.getTitle();
        if (actualTitle.equals(expectedResult)) {
            System.out.println(
                    "Title Verification Passed:\n" +
                            "Expected Title: " + expectedResult + "\n" +
                            "Actual Title: " + actualTitle);
        } else {
            System.out.println(
                    "Title Verification Failed:\n" +
                            "Expected Title: " + expectedResult + "\n" +
                            "Actual Title: " + actualTitle);
        }
    }
    public static void Matching2() {
        List<WebElement> titles = driver.findElements(By.xpath("//div[@class='inventory_item_desc']"));

        for (WebElement i : titles) {
            String actualResult = i.getText();
            System.out.println(actualResult);
        }
        System.out.println(titles.size());
    }
    public static void enterText(String text_Box, String element_Id){
        WebElement userNameTextBox = driver.findElement(By.id(element_Id));
        userNameTextBox.sendKeys(text_Box);
    }
    public static void clickButton(String login_id) throws InterruptedException {
        WebElement logInButton = driver.findElement(By.id(login_id));
        logInButton.click();
        Thread.sleep(3000);
    }
    public static void viewCart() throws InterruptedException {
        WebElement logInButton = driver.findElement(By.xpath("//a[@class='shopping_cart_link']"));
        logInButton.click();
    }
    public static void cartVerifictaion(){
        List<WebElement> titles = driver.findElements(By.xpath("//div[@class='cart_item']"));
        
//        String actualTitle = titles.getText();


        System.out.println(titles.size());
    }



    public static void main(String[] args) throws Exception {
        System.out.print("Hello this is lab1");
        try{
            LaunchChrome();
            NavigatetoURL(url);
            Matching(expectedTitle);
            enterText("standard_user","user-name");
            enterText("secret_sauce","password");
            clickButton("login-button");
            Matching2();
            clickButton("add-to-cart-sauce-labs-backpack");
            clickButton("add-to-cart-sauce-labs-bike-light");
            viewCart();
            cartVerifictaion();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}


