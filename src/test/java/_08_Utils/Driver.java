package _08_Utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class Driver {

  public static WebDriver driver;

  private static ThreadLocal<WebDriver> threadDriver = new ThreadLocal<>(); // WebDriver 1 WebbDriver 2
  public static ThreadLocal<String> threadBrowserName = new ThreadLocal<>(); // chrome , firefox ...


  public static WebDriver getDriver() {
    Locale.setDefault(new Locale("EN"));
    System.setProperty("user.language", "EN");
    Logger.getLogger("").setLevel(Level.SEVERE);
    System.setProperty(org.slf4j.impl.SimpleLogger.DEFAULT_LOG_LEVEL_KEY, "Error");
    System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
    if (threadBrowserName.get() == null) // if XML has not started for parallel so then set browser for default
//      threadBrowserName.set("chrome");
      threadBrowserName.set("edge");

    if (threadDriver.get() == null) {

      String browserName = threadBrowserName.get(); // get browser name
      switch (browserName) {
        case "chrome":
          WebDriverManager.chromedriver().setup();
          if(!runningFromIJ()) { // eger Inteligge de degilse yani Jenkinsde calistir bu parti ama
            //else ise normar inteligede calistir

            // 39. -41. line if for to make jenkins running background for chrome full size to adjust
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless", "--no-sandbox", "--disable-dev-shm-usage",
                "--disable-gpu", "--window-size=1400,2400");
            threadDriver.set(new ChromeDriver(options)); // bu thread e chrome istenmişşse ve yoksa bir tane ekleniyor
            // 40. line daki optionlara gore calistir diyorsun ve max olculerde calistir boylece hata vermesini englellioz
          } else {
            threadDriver.set(new ChromeDriver());
          }
          break;

        case "firefox":
          WebDriverManager.firefoxdriver().setup();
//          threadDriver.set(new FirefoxDriver());  // this thread driver call the firefox new object
//          break;

        case "safari":
          WebDriverManager.safaridriver().setup();
          threadDriver.set(new SafariDriver());
          break;

        case "edge":
          WebDriverManager.edgedriver().setup();
//          threadDriver.set(new EdgeDriver());
//          break;
          if(!runningFromIJ()) { // eger Inteligge de degilse yani Jenkinsde calistir bu parti ama
            //else ise normar inteligede calistir

            // 39. -41. line if for to make jenkins running background for chrome full size to adjust
            EdgeOptions options = new EdgeOptions();
            options.addArguments("--headless", "--no-sandbox", "--disable-dev-shm-usage",
                "--disable-gpu", "--window-size=1400,2400");
            threadDriver.set(new EdgeDriver(options)); // bu thread e chrome istenmişşse ve yoksa bir tane ekleniyor
            // 40. line daki optionlara gore calistir diyorsun ve max olculerde calistir boylece hata vermesini englellioz
          } else {
            threadDriver.set(new EdgeDriver());
          }
          break;
      }
    }
    return threadDriver.get();
  }

  public static void wait(int sec) {
    try {
      Thread.sleep(sec * 1000);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
  }
  public static void quitDriver() {
    if (threadDriver.get() != null) { // if there is a driver
      threadDriver.get().quit();

      WebDriver driver = threadDriver.get();
      driver=null;
      threadDriver.set(driver); // if driver comes again make it null
    }
  }
  public static boolean runningFromIJ(){

    String classpath=System.getProperty("java.class.path");
    return classpath.contains("idea_rt.jar");

  }

}
