package Steps;

import Pages.OrderPage;
import ru.yandex.qatools.allure.annotations.Step;

public class OrderStep {

    String FirstGoods;
    String FoundFirstGoods;

    @Step("Проверка количества товара на странице-12")
    public void stepcheckCountGoods (){
        new OrderPage(BaseSteps.getDriver()).checkCountGoods();
        }
    @Step("Запоминание первого товара на странице")
    public void stepmemorizeNameFirstGoods (){
        FirstGoods= new OrderPage(BaseSteps.getDriver()).memorizeNameFirstGoods();
    }
    @Step ("Поиск запомненого товара ")
    public void stepfoundMemorizeNameFirstGoods (){
        FoundFirstGoods=new OrderPage(BaseSteps.getDriver()).foundMemorizeNameFirstGoods(FirstGoods);
    }
    @Step("Сравнение найденного товара с запомненным")
    public void stepcheckMemorizeGoods (){
        new OrderPage(BaseSteps.getDriver()).checkMemorizeGoods(FirstGoods,FoundFirstGoods);
    }
}
