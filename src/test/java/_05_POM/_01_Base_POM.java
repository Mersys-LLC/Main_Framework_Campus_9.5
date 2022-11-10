package _05_POM;

import _08_Utils.Driver;
import java.time.Duration;
import java.util.List;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class _01_Base_POM {

  WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(30));

  public void waitUntilLoading(){
    wait.until(
        ExpectedConditions.numberOfElementsToBe(By.xpath("//fuse-progress-bar//mat-progress-bar"),0));
  }

  public void waitUntilLoading2() {
    wait.until(ExpectedConditions.textToBe(
        By.cssSelector("div[fxlayoutalign='center center'][class='control-full']"), "Search"));
  }
  public void sendKeysFunction(WebElement element, String value) {
    waitUntilVisibleAndClickable(element);
    element.sendKeys(value);
  }
  public void waitUntilVisibleAndClickable(WebElement element) {
    wait.until(ExpectedConditions.visibilityOfAllElements(element));
    wait.until(ExpectedConditions.visibilityOf(element));
    wait.until(ExpectedConditions.elementToBeClickable(element));
  }
  public List<WebElement> waitUntilVisibleAllElement(List<WebElement> elementList) {
    wait.until(ExpectedConditions.visibilityOfAllElements(elementList));
    return elementList;
  }
  public void scrollToElement(WebElement element) {
    JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
   //js.executeScript("window.scrollBy(0,1000)");
    js.executeScript("arguments[0].scroll(0,3000);", element);
    js.executeScript("arguments[0].scrollIntoView();", element);
//  js.executeScript("arguments[0].click();", element);
  }
  public void clickFunction(WebElement element) {
    waitUntilVisibleAndClickable(element);
    element.click();
  }
  public void selectFunction(WebElement element, String text) {
    waitUntilVisibleAndClickable(element);
    Select select = new Select(element);
    select.selectByValue(text);
  }
  public void validationText(WebElement element, String text) {
    waitUntilVisibleAndClickable(element);
    Assert.assertTrue(element.isDisplayed());
    Assert.assertTrue(element.getText().toLowerCase().contains(text.toLowerCase()));
  }

  public void randomDataName(WebElement element, String getRandomName){
    element.clear();
    getRandomName = RandomStringUtils.randomAlphabetic(4);
    element.sendKeys(getRandomName);
  }
  public void randomDataNumber(WebElement element,String getRandomNumber) {
    element.clear();
    getRandomNumber = RandomStringUtils.randomNumeric(3);
    element.sendKeys(getRandomNumber);
  }
  public void clearFunction(WebElement element) {
    element.clear();
  }
  public void sleep(){
    try {
      Thread.sleep(5000);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
  }
}
