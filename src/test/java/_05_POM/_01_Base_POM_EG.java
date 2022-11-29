package _05_POM;

import _08_Utils.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class _01_Base_POM_EG {
     WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(30));
    public void waitUntilLoading(){
        ExpectedConditions.numberOfElementsToBe(By.xpath("//fuse-progress-bar//mat-progress-bar"),0);

    }
     public void  sendKeysFunction(WebElement element , String value){
        waitUntilVisibleandClickable(element);
        element.sendKeys(value);
     }

    private void waitUntilVisibleandClickable(WebElement element) {
        wait.until(ExpectedConditions.visibilityOfAllElements(element));
        wait.until(ExpectedConditions.visibilityOf(element));
        wait.until(ExpectedConditions.elementToBeClickable(element));

    }
    public List<WebElement> waitUntilVisibleAllElement(List<WebElement>elementList){
       wait.until(ExpectedConditions.visibilityOfAllElements(elementList));
        return elementList;


    }
    public void clickFunction (WebElement element){
      waitUntilVisibleandClickable(element);
        element.click();
    }

    public void validationText(WebElement element, String text) {
        waitUntilVisibleandClickable(element);
       // Assert.assertTrue(element.isDisplayed());
       Assert.assertTrue(element.getText().toLowerCase().contains(text.toLowerCase()));

    }
    public void clearFunction (WebElement element){

        waitUntilVisibleandClickable(element);
        element.clear();
    }
    public void sleep(){
        try {
            Thread.sleep(5000);
    }catch(InterruptedException e) {
        throw new RuntimeException(e);
        }
    }


    public void waitUntilVisibleAllElement() {
    }
}
