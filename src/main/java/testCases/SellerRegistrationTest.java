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
import testObjects.SellerRegistrationObjects;
import java.util.Random;
import static mainData.Data.*;

@Test
public class SellerRegistrationTest {

    Random rnd = new Random();
    public int randomNumber = rnd. nextInt(9999999);

    public  void sellerRegistration() {
        try {
            ExtentHtmlReporter reporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"./Reports/sellerRegistrationReport.html");
            ExtentReports extent = new ExtentReports();
            extent.attachReporter(reporter);
            ExtentTest logger = extent.createTest("SellerRegistrationTest");
            ////////////////////////////////////////////////////////////////////////
            System.setProperty("webdriver.chrome.driver", chromeUrl);
            WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get(websiteUrl);//saytda daxil olunur
            logger.log(Status.INFO,"Sayta daxil olundu");
            SellerRegistrationObjects.magazaQeydiyyati_button(driver).click();//magaza qeydiyyati kliklenir
            logger.log(Status.INFO,"Mağaza qeydiyyatına daxil olundu");
            SellerRegistrationObjects.ad_textbox(driver).sendKeys("SelRegTest");//ad daxil edilir
            logger.log(Status.INFO,"Ad daxil edildi");
            SellerRegistrationObjects.soyad_textbox(driver).sendKeys("SelRegTestov");//soyad daxil edilir
            logger.log(Status.INFO,"Soyad daxil edildi");
            SellerRegistrationObjects.telefonNomresi_textbox(driver).sendKeys("99494" + randomNumber);//nomre daxil edilir
            logger.log(Status.INFO,"Mobil nömrə daxil edildi");
            SellerRegistrationObjects.elektronPoct_textbox(driver).sendKeys(randomEmail + "@gmail.com");//elektron poct daxil edilir
            logger.log(Status.INFO,"Elektron poçt daxil edildi");
            SellerRegistrationObjects.magazaAdi_textbox(driver).sendKeys("Test");//magaza adi daxil edilir
            logger.log(Status.INFO,"Mağaza adı daxil edildi");
            SellerRegistrationObjects.magazaSayti_textbox(driver).sendKeys("Test.com");//magaza sayti daxil edilir
            logger.log(Status.INFO,"Mağaza saytı daxil edildi");
            SellerRegistrationObjects.davamEt_button(driver).click();//davam et buttonu kliklenir
            logger.log(Status.INFO,"Mağaza qeydiyyatı tamamlandı");
            Thread.sleep(7000);

            if (SellerRegistrationObjects.success_text(driver).getText().equals("Təşəkkür edirik.")){
                logger.log(Status.PASS,"Mağaza müvəffəqiyyətlə qeydiyyatdan keçdi");
                System.out.println("Successful seller registration");
            }
            else {
                logger.log(Status.FAIL, "Mağaza qeydiyyatdan keçə bilmədi");
                System.out.println("Unsuccessful seller registration");
            }

            driver.quit();
            extent.flush();
        }
        catch (TimeoutException io){
            ExtentHtmlReporter reporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"./Reports/sellerRegistrationReportTimeoutException.html");
            ExtentReports extent = new ExtentReports();
            extent.attachReporter(reporter);
            ExtentTest loggerException = extent.createTest("SellerRegistrationTest");
            loggerException.log(Status.ERROR,"Time out xəta baş verdi"+" "+io.getMessage());
            extent.flush();

        }
        catch (NoSuchElementException e){
            ExtentHtmlReporter reporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"./Reports/sellerRegistrationReportNoSuchElementException.html");
            ExtentReports extent = new ExtentReports();
            extent.attachReporter(reporter);
            ExtentTest loggerException = extent.createTest("SellerRegistrationTest");
            loggerException.log(Status.ERROR,"Web element tapılmadı"+" "+e.getMessage());
            extent.flush();
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }



    }
}
