package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {
    @FindBy(xpath = "//DIV[@class='home-arrow__tabs']")
    WebElement mainMenu;


    public Wait<WebDriver> wait;

    public void selectMainMenu(String menuItem) {

        mainMenu.findElement(By.xpath(".//A[@class='home-link home-link_blue_yes home-tabs__link home-tabs__search'][text()='"+menuItem+"']")).click();
    }
    WebDriver driver;
    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, 5, 1000);
        this.driver=driver;
    }



}
