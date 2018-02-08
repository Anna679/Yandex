package Steps;

import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TestSteps {

MainStep mainStep=new MainStep();
MarketStep marketStep=new MarketStep();
FilterStep filterStep=new FilterStep();
OrderStep orderStep=new OrderStep();

@When("^выбран пункт меню \"(.*)\"$")
    public void stepSelectMaimMenu(String menuItem) {
mainStep.stepSelectMaimMenu(menuItem);
}

@When("^выбрано подменю \"(.*)\"$")
    public void stepSelectSubMenu (String menuItem){
marketStep.stepSelectSubMenu(menuItem);
}

@Then("^выбрана категория товара \"(.*)\"$")
    public void stepSelectCategory (String name){
 marketStep.stepSelectCategory(name);
}
@Then("^Выполнено нажатие на кнопку -Перейти ко всем фильтрам")
    public void stepSelectAllFilters () {
 marketStep.stepSelectAllFilters();
}
@When("^Выбрана марка телевизора LG")
    public void stepSelestTvLG (){
 filterStep.stepSelestTvLG();
}
@When("^Выбрана марка телевизора Samsung")
    public void stepSelestTvSmsung (){
 filterStep.stepSelestTvSmsung();
}
@When("^Выбрана марка Наушниов Beats")
    public void stepSelestBeats (){
 filterStep.stepSelestBeats();
}
@Then("^заполняются поля:$")
    public void stepZapolnenie(DataTable fields){
    fields.asMap(String.class,String.class).forEach(
            (field,value) -> filterStep.stepFillOne(field,value));
}
@When("^проверены поля, что заполненны правильными значениями:$")
    public void stepCheckZapolnenie(DataTable fields){
    fields.asMap(String.class,String.class).forEach(
            (field,value) -> filterStep.stepCheckFillOne(field,value));

}
@Then("^Выполнено нажатие на кнопку-Показать подходящие")
    public void stepPressGoButton () {

    filterStep.stepPressGoButton();
    }
   @When("^Выполнено нажатие на кнопку выбора вида отображения товара на странице")
   public void stepSelectVid () {
    orderStep.steppressVid();
   }
@When("^Выполнена проверка количества товара на странице")
    public void stepcheckCountGoods (){
    orderStep.stepcheckCountGoods();
}
@Then("^Выполно запоминание первого товара на странице")
    public void stepmemorizeNameFirstGoods (){
    orderStep.stepmemorizeNameFirstGoods();
}
@When("^Выполнен поиск запомненного товара")
    public void tepfoundMemorizeNameFirstGoods (){
    orderStep.stepfoundMemorizeNameFirstGoods();
}
@Then("^Выполнено сравнение найденного товара с найденным")
    public void stepcheckMemorizeGoods (){
    orderStep.stepcheckMemorizeGoods();
}
}
