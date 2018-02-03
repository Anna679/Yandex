package Pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FilterPage {

    @FindBy(xpath = "//*[contains(text(),'LG')]")
    WebElement LG;
    @FindBy(xpath = "//*[contains(text(),'Samsung')]")
    WebElement Samsung;
    @FindBy(xpath = "//*[contains(text(),'Beats')]")
    WebElement Beats;
    @FindBy(name = "glf-pricefrom-var")
    WebElement Summa;
    @FindBy (xpath ="//*[contains(text(),'Показать подходящие')]" )
    WebElement GoButton;


    public FilterPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        (new WebDriverWait(driver, 20)).until(ExpectedConditions.elementToBeClickable(GoButton));
    }

    public void selectLGtv() {
        LG.click();

    }

    public void selectSamsungTV() {
        Samsung.click();
    }

    public void selectBeats() {
        Beats.click();
    }
    protected void SETsum(WebElement element, String value) {
        element.clear();
        element.sendKeys(value);
    }

    public void SETsum(String fielName, String value) {
        switch (fielName) {
            case "Сумма от":
                SETsum(Summa, value);
                break;
                default:
                    throw new AssertionError("Поле '" + fielName + "' отсутствует на странице");
        }

    }
public String getSETsum(String fielName){
    switch (fielName) {
        case "Сумма от":
            return Summa.getAttribute("value");
    }
        throw new AssertionError("Поле не существует!");
    }


public void pressGoButton (){
        GoButton.click();
}


}
