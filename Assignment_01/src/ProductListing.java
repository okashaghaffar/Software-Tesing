import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.Random;
import java.util.ArrayList;
import java.util.List;

public class ProductListing {
   ;

    public static List<String> ProductListingVerification(String title_id,
                                                  String desc_id,
                                                  String price_id

                                                 ){
        List <String> list = new ArrayList<>();
        System.out.println("Entered Product");
        List<WebElement> titles = Parameterized.driver.findElements(By.xpath(title_id));
        System.out.println(titles.size());
        Random rand = new Random();
        int randomIndex = rand.nextInt(titles.size());
        String actual_title=titles.get(randomIndex).getText();
        System.out.println("Entered title");

        List<WebElement> descs = Parameterized.driver.findElements(By.xpath(desc_id));
        String actual_desc=descs.get(randomIndex).getText();
        System.out.println("Entered desc");

        List<WebElement> price = Parameterized.driver.findElements(By.xpath(price_id));
        String actual_price=price.get(randomIndex).getText();
        System.out.println("Entered price");
        List <String> buttonids = new ArrayList<>();
        buttonids.add("add-to-cart-sauce-labs-backpack");
        buttonids.add("add-to-cart-sauce-labs-bike-light");
        buttonids.add("add-to-cart-sauce-labs-bolt-t-shirt");
        buttonids.add("add-to-cart-sauce-labs-fleece-jacket");
        buttonids.add("add-to-cart-sauce-labs-onesie");
        buttonids.add("add-to-cart-test.allthethings()-t-shirt-(red)");

        WebElement button = Parameterized.driver.findElement(By.id(buttonids.get(randomIndex)));
        button.click();
        System.out.println("Entered clicked");

        list.add(actual_title);
        list.add(actual_desc);
        list.add(actual_price);

        return list;


    }


}
