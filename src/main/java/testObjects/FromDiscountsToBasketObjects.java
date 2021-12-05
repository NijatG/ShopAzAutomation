package testObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FromDiscountsToBasketObjects {

    private static WebElement element = null;

    public static WebElement discounts_button(WebDriver driver) {
        element = driver.findElement(By.xpath("//*[@id=\"discount-nav-link\"]"));
        return element;

    }
    public static WebElement mehsul_button(WebDriver driver) {
        element = driver.findElement(By.xpath("/html/body/app-root/app-views/app-app/app-discount/main/div/div[3]/div[2]/div[1]/div[1]/product-card/a/div[2]/h4"));
        return element;

    }
    public static WebElement sebeteAt_button(WebDriver driver) {
        element = driver.findElement(By.xpath("/html/body/app-root/app-views/app-app/app-product/app-product-detail/main/div/div[1]/div[2]/div[2]/div[6]/div/button[2]"));
        return element;

    }
    public  static WebElement sebet_button(WebDriver driver){
        element = driver.findElement(By.xpath("/html/body/app-root/app-views/app-app/app-header-main/header/div/div[2]/div/div/div[2]/a[2]/span[2]"));
        return element;
    }
    public  static WebElement mehsulSayi_text(WebDriver driver){
        element = driver.findElement(By.xpath("/html/body/app-root/app-views/app-app/app-cart/main/div/div/div/div[2]/div/div[1]/div/div[1]/span[1]"));
        return element;
    }

}