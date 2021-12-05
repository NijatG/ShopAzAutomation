package testCases;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import testObjects.LoginObjects;
import static mainData.Data.*;

@Test
public class LoginTest {
    public  void login() {
        try {
            ExtentHtmlReporter reporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"./Reports/loginReport.html");
            ExtentReports extent = new ExtentReports();
            extent.attachReporter(reporter);
            ExtentTest logger = extent.createTest("LoginTest");
            ////////////////////////////////////////////////////////////////
            System.setProperty("webdriver.chrome.driver", chromeUrl);
            WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get(websiteUrl);//sayta daxil olunur
            logger.log(Status.INFO,"Sayta daxil olunur");
            LoginObjects.daxilOlmaq_button(driver).click();//daxil olmaq  kliklenir
            logger.log(Status.INFO,"Login səhifəsinə keçid edilir");
            LoginObjects.emailOrPhone_textbox(driver).sendKeys(emailOrPhone);// email yaxud nomre daxil edilir
            logger.log(Status.INFO,"Email yaxud telefon nömrəsi daxil edilir");
            LoginObjects.sifre_textbox(driver).sendKeys(password);// sifre daxil edilir
            logger.log(Status.INFO,"Şifrə daxil edilir");
            LoginObjects.daxilOl_button(driver).click();// daxil ol buttonu kliklenir
            logger.log(Status.INFO,"Log in edilir");
            Thread.sleep(7000);

            if(LoginObjects.userName_text(driver).getText().equals("Test")){
                logger.log(Status.PASS,"User müvəffəqiyyətlə daxil oldu");
                System.out.println("Successful login");
            }
            else {
                logger.log(Status.FAIL, "User daxil ola bilmədi");
                System.out.println("Unsuccessful login");
            }

            driver.quit();
            extent.flush();
        }

        catch (TimeoutException io){
            ExtentHtmlReporter reporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"./Reports/loginReportTimeoutException.html");
            ExtentReports extent = new ExtentReports();
            extent.attachReporter(reporter);
            ExtentTest loggerException = extent.createTest("LoginTest");
            loggerException.log(Status.ERROR,"Time out xəta baş verdi"+" "+io.getMessage());
            extent.flush();

        }
        catch (NoSuchElementException e){
            ExtentHtmlReporter reporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"./Reports/loginReportNoSuchElementException.html");
            ExtentReports extent = new ExtentReports();
            extent.attachReporter(reporter);
            ExtentTest loggerException = extent.createTest("LoginTest");
            loggerException.log(Status.ERROR,"Web element tapılmadı"+" "+e.getMessage());
            extent.flush();
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

}
