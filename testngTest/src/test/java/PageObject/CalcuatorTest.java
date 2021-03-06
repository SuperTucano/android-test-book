package PageObject;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import java.net.MalformedURLException;
import java.net.URL;

public class CalcuatorTest {

    private AndroidDriver driver;
    private CalcuatorPage calPage;

    @BeforeClass
    public void startApp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", "Android Emulator");
        capabilities.setCapability("automationName", "Appium");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", "7.0");
        capabilities.setCapability("appPackage", "com.android.calculator2");
        capabilities.setCapability("appActivity", ".Calculator");

        this.driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),
                capabilities);
        this.calPage = new CalcuatorPage(this.driver);
    }

    // 关闭APP
    @AfterClass
    public void closeApp(){
        driver.quit();
    }

    // 清空结果
    @AfterMethod
    public void clearResult(){
        this.calPage.clr();
    }

    @Test
    public void testAdd(){
        this.calPage.number_1();
        this.calPage.add();
        this.calPage.number_1();
        this.calPage.eq();
        String result = this.calPage.result();
        assertEquals(result, "2");
    }

    @Test
    public void testSub(){
        this.calPage.number_5();
        this.calPage.sub();
        this.calPage.number_3();
        this.calPage.eq();
        String result = this.calPage.result();
        assertEquals(result, "2");
    }

    @Test
    public void testMul(){
        this.calPage.number_5();
        this.calPage.mul();
        this.calPage.number_3();
        this.calPage.eq();
        String result = this.calPage.result();
        assertEquals(result, "15");
    }

    @Test
    public void testDiv(){
        this.calPage.number_6();
        this.calPage.div();
        this.calPage.number_3();
        this.calPage.eq();
        String result = this.calPage.result();
        assertEquals(result, "2");
    }
}
