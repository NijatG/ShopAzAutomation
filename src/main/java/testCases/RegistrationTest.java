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
import testObjects.RegistrationObjects;
import java.util.Random;
import static mainData.Data.*;

@Test
public class RegistrationTest {
    Random rnd = new Random();
    public int randomNumber = rnd. nextInt(9999999);

    public  void registration()  {
        try {
            ExtentHtmlReporter reporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"./Reports/registrationReport.html");
            ExtentReports extent = new ExtentReports();
            extent.attachReporter(reporter);
            ExtentTest logger = extent.createTest("RegistrationTest");
            ////////////////////////////////////////////////////////////////
            System.setProperty("webdriver.chrome.driver", chromeUrl);
            WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get(websiteUrl);//sayta daxil olunur
            logger.log(Status.INFO,"Sayta daxil olundu");
            RegistrationObjects.daxilOlmaq_button(driver).click();//daxil olmaq kliklenir
            logger.log(Status.INFO,"Login səhifəsinə daxil olundu");
            RegistrationObjects.qeydiyyat_button(driver).click();// qeydiyyat buttonu kliklenir
            logger.log(Status.INFO,"Qeydiyyat səhifəsinə daxil olundu");
            RegistrationObjects.ad_textbox(driver).sendKeys("RegTest");// ad daxil edilir
            logger.log(Status.INFO,"Ad daxil edildi");
            RegistrationObjects.soyad_textbox(driver).sendKeys("RegTestov");//soyad daxil edilir
            logger.log(Status.INFO,"Soyad daxil edildi");
            RegistrationObjects.telefonNomresi_textbox(driver).sendKeys("99494" + randomNumber);//nomre daxil edilir
            logger.log(Status.INFO,"Mobil nömrə daxil edildi");
            RegistrationObjects.elektronPoct_textbox(driver).sendKeys(randomEmail + "@gmail.com");// elektron poct daxil edilir
            logger.log(Status.INFO,"Elektron poçt daxil edildi");
            RegistrationObjects.aliciMuqavilesiSertleri_checkbox(driver).click();//alici muqavilesi sertleri checkboxu secilir
            logger.log(Status.INFO,"Alıcı müqaviləsi şərtləri seçildi");
            RegistrationObjects.davamEt_button(driver).click();// davam et buttonu kliklenir
            logger.log(Status.INFO,"Şifrəyə keçid üçün davam et buttonu klikləndi");
            Thread.sleep(5000);
            RegistrationObjects.sifreniz_textbox(driver).sendKeys("Test123");//sifre daxil edilir
            logger.log(Status.INFO,"Şifrə daxil edildi");
            RegistrationObjects.sifrenizinTekrari_textbox(driver).sendKeys("Test123");//tekrar sifre daxil edilir
            logger.log(Status.INFO,"Təkrar şifrə daxil edildi");
            RegistrationObjects.qeydiyyatFinal_button(driver).click();
            logger.log(Status.INFO,"Qeydiyyat tamamlandı");
            Thread.sleep(7000);

            if(RegistrationObjects.userName_text(driver).getText().equals("Regtest")){
                logger.log(Status.PASS,"User müvəffəqiyyətlə qeydiyyatdan keçdi və login oldu");
                System.out.println("Successful registration");
            }
            else {
                logger.log(Status.FAIL, "User qeydiyyatdan keçə bilmədi");
                System.out.println("Unsuccessful registration");
            }

            driver.quit();
            extent.flush();
        }
        catch (TimeoutException io){
            ExtentHtmlReporter reporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"./Reports/registrationReportTimeoutException.html");
            ExtentReports extent = new ExtentReports();
            extent.attachReporter(reporter);
            ExtentTest loggerException = extent.createTest("RegistrationTest");
            loggerException.log(Status.ERROR,"Time out xəta baş verdi"+" "+io.getMessage());
            extent.flush();

        }
        catch (NoSuchElementException e){
            ExtentHtmlReporter reporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"./Reports/registrationReportNoSuchElementException.html");
            ExtentReports extent = new ExtentReports();
            extent.attachReporter(reporter);
            ExtentTest loggerException = extent.createTest("RegistrationTest");
            loggerException.log(Status.ERROR,"Web element tapılmadı"+" "+e.getMessage());
            extent.flush();
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
