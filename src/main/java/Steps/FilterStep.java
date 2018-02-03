package Steps;

import Pages.FilterPage;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.HashMap;

import static junit.framework.TestCase.assertTrue;

public class FilterStep {
    @Step ("Выбрана марка Телевизора LG")
    public void stepSelestTvLG () {
        new FilterPage(BaseSteps.getDriver()).selectLGtv();
    }
    @Step ("Выбрана марка Телевизора Samsung")
    public void stepSelestTvSmsung () {
        new FilterPage(BaseSteps.getDriver()).selectSamsungTV();
    }
    @Step ("Выбрана марка Наушников Beats")
    public void stepSelestBeats () {
        new FilterPage(BaseSteps.getDriver()).selectBeats();
    }
    @Step ("Поле {0} заполняется значенем {1}")
    public void stepFillOne(String field, String value) {
        new FilterPage( BaseSteps.getDriver()).SETsum( field, value );
    }
    @Step("Заполняются поля: ")
    public void stepFillSome(HashMap<String, String> fields) {
        fields.forEach(this::stepFillOne);
    }
    @Step("поле {0} заполнено значением {1}")
    public void stepCheckFillOne(String field, String value){
        String actual = new FilterPage( BaseSteps.getDriver()).getSETsum(field);
        assertTrue(String.format("Значение поля [%s] равно [%s]. Ожидалось - [%s]", field, actual, value),
                actual.equals(value));
    }
    @Step("поля заполнены верно")
    public void stepCheckFillSome(HashMap<String, String> fields){
        fields.forEach((k, v)-> stepCheckFillOne(k,v));
    }
    @Step ("Выполнено нажатие на -Показать подходящие")
    public void stepPressGoButton () {
        new FilterPage(BaseSteps.getDriver()).pressGoButton();
    }
}
