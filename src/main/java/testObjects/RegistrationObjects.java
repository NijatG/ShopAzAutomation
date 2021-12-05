package testObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegistrationObjects {

    private static WebElement element=null;

    public  static WebElement daxilOlmaq_button(WebDriver driver){
        element = driver.findElement(By.xpath("/html/body/app-root/app-views/app-footer/footer/div/div[1]/ul[3]/li[2]/a"));
        return element;
    }
    public  static WebElement qeydiyyat_button(WebDriver driver){
        element = driver.findElement(By.xpath("/html/body/app-root/app-views/app-user/app-login/main/div/div/div[1]/h4/a"));
        return element;
    }
    public  static WebElement ad_textbox(WebDriver driver){
        element = driver.findElement(By.id("firstName"));
        return element;
    }
    public  static WebElement soyad_textbox(WebDriver driver){
        element = driver.findElement(By.id("lastName"));
        return element;
    }
    public  static WebElement telefonNomresi_textbox(WebDriver driver){
        element = driver.findElement(By.id("phone"));
        return element;
    }
    public  static WebElement elektronPoct_textbox(WebDriver driver){
        element = driver.findElement(By.id("email"));
        return element;
    }
    public  static WebElement davamEt_button(WebDriver driver){
        element = driver.findElement(By.xpath("/html/body/app-root/app-views/app-user/app-register/main/div/div/div[2]/form/button"));
        return element;
    }
    public  static WebElement aliciMuqavilesiSertleri_checkbox(WebDriver driver){
        element = driver.findElement(By.xpath("/html/body/app-root/app-views/app-user/app-register/main/div/div/div[2]/form/div/div[5]/label/span[1]"));
        return element;
    }
    public  static WebElement sifreniz_textbox(WebDriver driver){
        element = driver.findElement(By.id("password"));
        return element;
    }
    public  static WebElement sifrenizinTekrari_textbox(WebDriver driver){
        element = driver.findElement(By.id("confirmPassword"));
        return element;
    }
    public static WebElement qeydiyyatFinal_button(WebDriver driver){
        element = driver.findElement(By.xpath("/html/body/app-root/app-views/app-user/app-register/main/div/div/div[2]/form/div/div[3]/button[2]"));
        return  element;
    }
    public  static WebElement userName_text(WebDriver driver){
        element = driver.findElement(By.xpath("/html/body/app-root/app-views/app-app/app-header-main/header/div/div[2]/div/div/div[2]/div/div[1]/span[2]"));
        return  element;

    }

}
