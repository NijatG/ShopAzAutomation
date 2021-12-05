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
import testObjects.FromSellerToBasketObjects;
import static mainData.Data.*;

@Test
public class FromSellerToBasketTest {

    public  void fromSellerToBasket() {
        try {
            ExtentHtmlReporter reporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"./Reports/fromSellerToBasketReport.html");
            ExtentReports extent = new ExtentReports();
            extent.attachReporter(reporter);
            ExtentTest logger = extent.createTest("FromSellerToBasketTest");
            ////////////////////////////////////////////////////////////////////////////////
            System.setProperty("webdriver.chrome.driver", chromeUrl);
            WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get(sellerUrl);
            logger.log(Status.INFO,"Sayta daxil olundu");
            FromSellerToBasketObjects.mehsul_button(driver).click();//mehsul secilir
            logger.log(Status.INFO,"Məhsul seçildi");
            Thread.sleep(5000);
            FromSellerToBasketObjects.sebeteAt_button(driver).click();//sebete at buttonu kliklenir
            logger.log(Status.INFO,"Məhsul səbətə atıldı");
            Thread.sleep(5000);
            FromSellerToBasketObjects.sebet_button(driver).click();//sebet buttonu kliklenir
            logger.log(Status.INFO,"Səbətə daxil olundu");
            Thread.sleep(5000);

            if (FromSellerToBasketObjects.mehsulSayi_text(driver).getText().equals("Məhsullar (1)")){
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
            ExtentHtmlReporter reporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"./Reports/fromSellerToBasketReportTimeoutException.html");
            ExtentReports extent = new ExtentReports();
            extent.attachReporter(reporter);
            ExtentTest loggerException = extent.createTest("FromSellerToBasketTest");
            loggerException.log(Status.ERROR,"Time out xəta baş verdi"+" "+io.getMessage());
            extent.flush();

        }
        catch (NoSuchElementException e){
            ExtentHtmlReporter reporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"./Reports/fromSellerToBasketReportNoSuchElementException.html");
            ExtentReports extent = new ExtentReports();
            extent.attachReporter(reporter);
            ExtentTest loggerException = extent.createTest("FromSellerToBasketTest");
            loggerException.log(Status.ERROR,"Web element tapılmadı"+" "+e.getMessage());
            extent.flush();
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
