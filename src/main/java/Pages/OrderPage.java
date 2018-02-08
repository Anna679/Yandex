package Pages;

import Steps.BaseSteps;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class OrderPage {
    @FindBy(xpath= "//LABEL[@class='radio-button__radio radio-button__radio_side_right radio-button__radio_checked_yes radio-button__radio_focused_yes radio-button__radio_hovered_yes']/self::LABEL")
    WebElement Vid;

    public OrderPage(WebDriver driver){
       this.driver=driver;
    }

    WebDriver driver;


//проверка количества товара на странице
    public void checkCountGoods (){
        System.out.println("start checkCountGoods");

        //Wait<WebDriver> wait = new WebDriverWait(driver, 5, 1000);
        //wait.until( ExpectedConditions.visibilityOf(driver.findElement( By.xpath("//div[@class='n-snippet-card2__title']"))));

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        List<WebElement> arr = driver.findElements( By.xpath( "//div[@class='n-snippet-card2__title']" ) );

        if(arr!=null)
        {
            System.out.println("Нашли 12 наушников");
        }

        assertEquals( 12,  arr.size() );
    }
//Запоминаем первый товар в списке
public String  memorizeNameFirstGoods(){

    String A  =  BaseSteps.getDriver().findElement( By.xpath( "(//div[@class='n-snippet-card2__title'])[1]" ) ).getText();

    return A;
}
//функция ищет в поисковой строке по переданному значению
public String foundMemorizeNameFirstGoods (String B){

    BaseSteps.getDriver().findElement( By.xpath( "//INPUT[@id='header-search']" ) ).sendKeys( B );

    BaseSteps.getDriver().findElement( By.xpath( "(//BUTTON[@role='button'])[1]" ) ).click();

    String  C= BaseSteps.getDriver().findElement(By.xpath("//DIV[@class='n-product-title__text-container']")).getText();

    return C;
}
//сравниваем найденное значение с запомненным
public void checkMemorizeGoods (String A, String B){

        Assert.assertTrue(A.equals(B));
}
    public void pressVid (){

        System.out.println("press vid starts");

        String xp = "//input[@name='viewtype']";

       // Wait<WebDriver> wait = new WebDriverWait(driver, 5, 1000);

        //wait.until( ExpectedConditions.elementToBeClickable(By.xpath(xp)));

        //System.out.println("after wait");

        WebElement toFind = driver.findElement(By.xpath(xp));

        if(toFind!=null) {
            toFind.click();
            System.out.println("toFind.click();");
        }
    }


}
