import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import java.net.MalformedURLException;
import java.net.URI;
import java.time.Duration;
import org.testng.annotations.Test;

public class FirstAppiumTest {

    @Test
    public void testFirstAppiumTest() throws MalformedURLException {

        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setAutomationName("UiAutomator2");
        options.setDeviceName("emulator-5554");
        options.setApp("C:\\Users\\hv983\\Downloads\\ApiDemos-debug.apk");
        options.setUiautomator2ServerInstallTimeout(Duration.ofSeconds(60));

        AndroidDriver driver = null;
        try {
            driver = new AndroidDriver(
                    URI.create("http://127.0.0.1:4723").toURL(),
                    options
            );
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

            // Tap "Views" on the home screen
            driver.findElement(AppiumBy.accessibilityId("Views")).click();
            System.out.println("Tapped on Views");

            // Confirm the next screen loaded
            boolean found = driver.findElement(AppiumBy.accessibilityId("Buttons")).isDisplayed();
            System.out.println("Buttons item visible: " + found);

            Thread.sleep(2000); // just so you can see the screen; remove later
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (driver != null) {
                driver.quit();
            }
        }
    }
}