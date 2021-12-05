package testCases;

import static  mainData.Data.*;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import testObjects.FromCampaignsToBasketObjects;
import testObjects.FromResultToBasketObjects;

@Test
public class FromResultToBasketTest {

    public  void fromResultToBasket() {
        try {
            ExtentHtmlReporter reporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"./Reports/fromResultToBasketReport.html");
            ExtentReports extent = new ExtentReports();
            extent.attachReporter(reporter);
            ExtentTest logger = extent.createTest("FromResultToBasketTest");
            /////////////////////////////////////////////////////////////////////////////////
            System.setProperty("webdriver.chrome.driver", chromeUrl);
            WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get(websiteUrl);//sayta daxil olunur
            logger.log(Status.INFO,"Sayta daxil olundu");
            FromResultToBasketObjects.axtar_textbox(driver).sendKeys("Android");//axtar textboxuna acar soz daxil edilir
            logger.log(Status.INFO,"Axtar-a açar söz daxil edildi");
            FromResultToBasketObjects.axtar_textbox(driver).sendKeys(Keys.ENTER);//enter kliklenir
            logger.log(Status.INFO,"Açar söz axtarıldı");
            Thread.sleep(5000);
            FromResultToBasketObjects.mehsul_button(driver).click();//mehsul secilir
            logger.log(Status.INFO,"Məhsul seçildi");
            Thread.sleep(5000);
            FromResultToBasketObjects.sebeteAt_button(driver).click();//sebete at buttonu kliklenir
            logger.log(Status.INFO,"Məhsul səbətə atıldı");
            Thread.sleep(5000);
            FromCampaignsToBasketObjects.sebet_button(driver).click();//sebet buttonu kliklenir
            logger.log(Status.INFO,"Səbətə daxil olundu");
            Thread.sleep(5000);

            if (FromResultToBasketObjects.mehsulSayi_text(driver).getText().equals("Məhsullar (1)")){
                logger.log(Status.PASS,"Məhsul müvəffəqiyyətlə əlavə edildi");
                System.out.println("Successful add");
            }
            else {
                logger.log(Status.FAIL, "Məhsul əlavə edilmədi");
                System.out.println("Unsuccessful add");
            }

            driver.quit();
            extent.flush();
        }
        catch (TimeoutException io){
            ExtentHtmlReporter reporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"./Reports/fromResultToBasketReportTimeoutException.html");
            ExtentReports extent = new ExtentReports();
            extent.attachReporter(reporter);
            ExtentTest loggerException = extent.createTest("FromResultToBasketTest");
            loggerException.log(Status.ERROR,"Time out xəta baş verdi"+" "+io.getMessage());
            extent.flush();

        }
        catch (NoSuchElementException e){
            ExtentHtmlReporter reporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"./Reports/fromResultToBasketReportNoSuchElementException.html");
            ExtentReports extent = new ExtentReports();
            extent.attachReporter(reporter);
            ExtentTest loggerException = extent.createTest("FromResultToBasketTest");
            loggerException.log(Status.ERROR,"Web element tapılmadı"+" "+e.getMessage());
            extent.flush();
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
