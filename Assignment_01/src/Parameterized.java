import org.openqa.selenium.WebDriver;
import java.util.Random;
import java.util.List;

public class Parameterized {

    public static String chromepath = "src\\driver\\chromedriver.exe";

    public static WebDriver driver;
    public static String url = "https://www.saucedemo.com/";
    public static String expectedTitle = "Swag Labs";
    public static String userName = "standard_user";
    public static String userId = "user-name";
    public static String password = "secret_sauce";
    public static String passwordId = "password";
    public static  String loginbutton="login-button";

    public static void main(String[] args) throws InterruptedException {
        Login.LaunchChrome(chromepath);
        Login.NavigatetoURL(url);
        Login.enterText(userName,userId);
        Login.enterText(password,passwordId);
        Login.clickButton(loginbutton);
        Login.Sleep();
//[a,b,c,d,e,f]-->lst[random.randint(0,5)]-->
        List<String> actual_title=ProductListing.ProductListingVerification("//div[@class='inventory_item_name ']",
                "//div[@class='inventory_item_desc']",
                "//div[@class='inventory_item_price']"
                );
      CartVerification.ProductVerification(actual_title.get(0),
              "//div[@class='inventory_item_name']",actual_title.get(1));
      Login.clickButton("checkout");
        Login.enterText("Okasha","first-name");
        Login.enterText("Ghaffar","last-name");
        Login.enterText("75270","postal-code");
        Login.Sleep();

        Login.clickButton("continue");
        Login.Sleep();

        Login.clickButton("finish");
        Login.Sleep();
        

    }

}
