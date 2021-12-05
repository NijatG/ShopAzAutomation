package testObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginObjects {

    private static WebElement element=null;

    public  static WebElement daxilOlmaq_button(WebDriver driver){
        element = driver.findElement(By.xpath("/html/body/app-root/app-views/app-footer/footer/div/div[1]/ul[3]/li[2]/a"));
        return element;
    }
    public  static WebElement emailOrPhone_textbox(WebDriver driver){
        element = driver.findElement(By.id("emailorPhone"));
        return  element;
    }
    public  static WebElement sifre_textbox(WebDriver driver){
        element = driver.findElement(By.id("password"));
        return  element;
    }
    public  static WebElement daxilOl_button(WebDriver driver){
        element = driver.findElement(By.xpath("/html/body/app-root/app-views/app-user/app-login/main/div/div/div[2]/app-loginform/form/button"));
        return  element;

    }
    public  static WebElement userName_text(WebDriver driver){
        element = driver.findElement(By.xpath("/html/body/app-root/app-views/app-app/app-header-main/header/div/div[2]/div/div/div[2]/div/div[1]/span[2]"));
        return  element;

    }




}
