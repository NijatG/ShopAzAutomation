package testObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SellerRegistrationObjects {

    private static WebElement element=null;

    public  static WebElement magazaQeydiyyati_button(WebDriver driver){
        element = driver.findElement(By.xpath("/html/body/app-root/app-views/app-app/app-header-main/header/div/div[1]/div/div/div[2]/ul/li/a"));
        return element;
    }
    public  static WebElement ad_textbox(WebDriver driver){
        element = driver.findElement(By.name("firstName"));
        return element;
    }
    public  static WebElement soyad_textbox(WebDriver driver){
        element = driver.findElement(By.name("lastName"));
        return element;
    }
    public  static WebElement telefonNomresi_textbox(WebDriver driver){
        element = driver.findElement(By.name("phone"));
        return element;
    }
    public  static WebElement elektronPoct_textbox(WebDriver driver){
        element = driver.findElement(By.name("email"));
        return element;
    }
    public  static WebElement magazaAdi_textbox(WebDriver driver){
        element = driver.findElement(By.name("shopName"));
        return element;
    }
    public  static WebElement magazaSayti_textbox(WebDriver driver){
        element = driver.findElement(By.name("shopSite"));
        return element;
    }
    public  static WebElement davamEt_button(WebDriver driver){
        element = driver.findElement(By.xpath("//*[@id=\"shop-register\"]/div/div[2]/form/button"));
        return element;
    }
    public  static WebElement success_text(WebDriver driver){
        element = driver.findElement(By.xpath("/html/body/app-root/app-views/app-user/app-shop-register-success/main/div/div/div/h4"));
        return element;
    }

}


