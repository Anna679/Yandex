package Steps;


import Pages.MarketPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

public class MarketStep {
    @FindBy(xpath = "//UL[@class='topmenu__list']//A[@class='link topmenu__link'][text()='Электроника']")
    WebElement Category;

    @Step ("Выбран пункт меню {0}")
    public void stepSelectSubMenu(String menuItem) {
        new MarketPage(BaseSteps.getDriver()).selectSubMenu(menuItem);
    }
    @Step("Выбрана категория{0}")
    public void stepSelectCategory () {
        try {
            new  MarketPage(BaseSteps.getDriver()).selectElementByName(Category,"name");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Step ("Нажать на кнопку -Перейти ко всем фильтрам")

    public void stepSelectAllFilters () {
        new MarketPage(BaseSteps.getDriver()).AllFilter.click();
    }

}
