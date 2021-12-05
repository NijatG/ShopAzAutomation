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
import testObjects.FromCampaignsToBasketObjects;
import static mainData.Data.*;


@Test
public class FromCampaignsToBasketTest {

    public  void fromCampaignToBasket() {
        try {
            ExtentHtmlReporter reporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"./Reports/fromCampaignToBasketReport.html");
            ExtentReports extent = new ExtentReports();
            extent.attachReporter(reporter);
            ExtentTest logger = extent.createTest("FromCampaignToBasketTest");
            ////////////////////////////////////////////////////////////////////////
            System.setProperty("webdriver.chrome.driver",chromeUrl);
            WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get(websiteUrl);//sayta daxil olunur
            logger.log(Status.INFO,"Sayta daxil olundu");
            FromCampaignsToBasketObjects.kampaniyalar_button(driver).click();//kampanyalar kliklenir
            logger.log(Status.INFO,"Kampanyalara daxil olundu");
            Thread.sleep(5000);
            FromCampaignsToBasketObjects.hamisiniGor_button(driver).click();//hamisini gor kliklenir
            logger.log(Status.INFO,"Bütün məhsullara keçid edildi");
            Thread.sleep(5000);
            FromCampaignsToBasketObjects.mehsul_button(driver).click();//mehsul secilir
            logger.log(Status.INFO,"Məhsul seçildi");
            Thread.sleep(5000);
            FromCampaignsToBasketObjects.sebeteAt_button(driver).click();//sebete at buttonu kliklenir
            logger.log(Status.INFO,"Məhsul səbətə atıldı");
            Thread.sleep(5000);
            FromCampaignsToBasketObjects.sebet_button(driver).click();//sebet buttonu kliklenir
            logger.log(Status.INFO,"Səbətə daxil olundu");
            Thread.sleep(5000);

            if (FromCampaignsToBasketObjects.mehsulSayi_text(driver).getText().equals("Məhsullar (1)")){
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
            ExtentHtmlReporter reporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"./Reports/fromCampaignToBasketReportTimeoutException.html");
            ExtentReports extent = new ExtentReports();
            extent.attachReporter(reporter);
            ExtentTest loggerException = extent.createTest("FromCampaignToBasketTest");
            loggerException.log(Status.ERROR,"Time out xəta baş verdi"+" "+io.getMessage());
            extent.flush();

        }
        catch (NoSuchElementException e){
            ExtentHtmlReporter reporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"./Reports/fromCampaignToBasketReportNoSuchElementException.html");
            ExtentReports extent = new ExtentReports();
            extent.attachReporter(reporter);
            ExtentTest loggerException = extent.createTest("FromCampaignToBasketTest");
            loggerException.log(Status.ERROR,"Web element tapılmadı"+" "+e.getMessage());
            extent.flush();
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
