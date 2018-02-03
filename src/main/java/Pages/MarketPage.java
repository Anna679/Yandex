package Pages;


import Steps.BaseSteps;
import cucumber.api.java.cs.A;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;

public class MarketPage {

    public Wait<WebDriver>wait;

    @FindBy(xpath = "//UL[@class='topmenu__list']")
    WebElement subMenu;
    @FindBy(xpath = "//UL[@class='topmenu__list']//A[@class='link topmenu__link'][text()='Электроника']")
    WebElement Category;
    @FindBy(xpath = "//*[contains(text(),'Перейти ко всем фильтрам')]")
    public
    WebElement AllFilter;


    public MarketPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        Wait<WebDriver> wait = new WebDriverWait(driver, 20, 3000);
        wait.until(ExpectedConditions.visibilityOf(AllFilter));

    }

//public void selectGategory (String name) {
//
//        Category.findElement(By.xpath("//*[contains(text(),'"+name+"')]"));
//}

    public WebElement selectSubMenu(String menuItem) {

        WebElement element =
                subMenu.findElement(By.xpath(".//A[@class='link topmenu__link'][text()='"+menuItem+"']"));

        wait.until(ExpectedConditions.elementToBeClickable(element));

        Actions actions = new Actions(BaseSteps.getDriver());
        actions.moveToElement(element).build().perform();
        return element;
    }

    public String getXpathFromName(String name) throws Exception {

        if (name.equals("Наушники"))
            return "//*[contains(text(),'"+name+"')]";

        if (name.equals("Телевизоры"))
            return "//*[contains(text(),'"+name+"')]";

        throw new Exception("Элемент "+name+" не найден");
    }
   public WebElement selectElementByName(WebElement startElement ,String name) throws Exception {

        String xpath=getXpathFromName(name);

       WebElement element =
               startElement.findElement(By.xpath(xpath));

       wait.until(ExpectedConditions.elementToBeClickable(element));

       return element;
    }


}