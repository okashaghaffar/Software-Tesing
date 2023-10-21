import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CartVerification {
//    public  static  void ProductVerification(String actual_tile,String titlepath,sting price,string pricepa){
    public  static  void ProductVerification(String actual_title,String titlepath,String actual_price){
        WebElement cart_path = Parameterized.driver.findElement(By.xpath("//a[@class='shopping_cart_link']"));
        cart_path.click();

        WebElement title = Parameterized.driver.findElement(By.xpath(titlepath));
        String expected_title=title.getText();
        if (actual_title.equals(expected_title)) {
            System.out.println(
                    "Title Verification Passed For title:\n" +
                            "Expected Title: " + expected_title + "\n" +
                            "Actual Title: " + actual_title);
        } else {
            System.out.println(
                    "Title Verification Failed for title:\n" +
                            "Expected Title: " + expected_title + "\n" +
                            "Actual Title: " + actual_title);
        }


        System.out.println(actual_title);
        System.out.println("This is actual price coming from indexing"+actual_price);

    }

}
