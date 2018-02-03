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

import static org.junit.Assert.assertEquals;

public class OrderPage {

    public OrderPage(WebDriver driver){
       this.driver=driver;
    }

    WebDriver driver;
//    public String getFirstGoods() {
//        return FirstGoods;
//    }
//
//    public void setFirstGoods(String firstGoods) {
//        FirstGoods = firstGoods;
//    }
//
//    String FirstGoods;


//проверка количества товара на странице
    public void checkCountGoods (){
        Wait<WebDriver> wait = new WebDriverWait(driver, 5, 1000);
        wait.until( ExpectedConditions.visibilityOf(driver.findElement( By.xpath("//div[@class='n-snippet-card2__title']"))));
        assertEquals( 12,  BaseSteps.getDriver().findElements( By.xpath( "//div[@class='n-snippet-card2__title']" ) ).size() );
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

    String  C= BaseSteps.getDriver().findElement(By.xpath("(//div[@class='n-snippet-card2__title'])[1]")).getText();

    return C;
}
//сравниваем найденное значение с запомненным
public void checkMemorizeGoods (String A, String B){

        Assert.assertTrue(A.equals(B));
}


}
