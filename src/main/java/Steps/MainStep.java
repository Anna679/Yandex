package Steps;

import Pages.MainPage;
import ru.yandex.qatools.allure.annotations.Step;

public class MainStep {

    @Step("Выбран пункт меню {0}")
    public void stepSelectMaimMenu(String menuItem) {
        new MainPage(BaseSteps.getDriver()).selectMainMenu(menuItem);
    }
}