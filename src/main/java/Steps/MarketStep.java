package Steps;


import Pages.MarketPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.allure.annotations.Step;

public class MarketStep {
    @FindBy(xpath = "//UL[@class='topmenu__list']//A[@class='link topmenu__link'][text()='Электроника']")
    WebElement Category;

    @Step ("Выбран пункт меню {0}")
    public void stepSelectSubMenu(String menuItem) {

        WebElement a=BaseSteps.getDriver().findElement(By.xpath("//div[@class='n-region-notification__actions-cell']"));


        Wait<WebDriver> wait = new WebDriverWait(BaseSteps.getDriver(), 20, 3000);
        wait.until(ExpectedConditions.visibilityOf(a));
        wait.until(ExpectedConditions.elementToBeClickable(a));
        a.click();

        new MarketPage(BaseSteps.getDriver()).selectSubMenu(menuItem);
    }
    @Step("Выбрана категория{0}")
    public void stepSelectCategory (String name) {

        try {
            new  MarketPage(BaseSteps.getDriver()).selectElementByName(Category,name).click();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    @Step ("Нажать на кнопку -Перейти ко всем фильтрам")

    public void stepSelectAllFilters () {
        new MarketPage(BaseSteps.getDriver()).AllFilter.click();
    }

}
