package ua.test.first;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

/**
 * Created by Averluck on 13.03.2017.
 */
public class PageElementsSearch extends Page{

    final static Logger logger = Logger.getLogger(PageElementsSearch.class);

    private SelenideElement Search = $("#BaseMainContent_MainContent_btnSearch"); //кнопка поиска записи

    //*статус начала подачи и конца получает равные значения(потом изменить на разные)
    public String searchPublicationDate(String publicationDate){        //дата публиации

        $("#BaseMainContent_MainContent_txtPublicationDate_txtDateFrom").setValue(publicationDate); //установка начала подачи извещения
        $("#BaseMainContent_MainContent_txtPublicationDate_txtDateTo").setValue(publicationDate);//установка конца подачи извещения

        Search.click();
        String finishdate = $(By.xpath("//*[contains(@title, '" + publicationDate + "')]")).waitUntil(visible,5000).getText();//метод взял у Феди,не нашёл сам как вытащить
        return finishdate;
    }

    public String searchNameOfLot(String name) {        //имя лота
        $("#BaseMainContent_MainContent_txtName_txtText").setValue(name);
        Search.click();
        String finishnameoflot = $(By.partialLinkText(name)).waitUntil(visible,10000).getText();
        return finishnameoflot;
    }
    //#BaseMainContent_MainContent_txtNumber_txtText


    public String searchNumberOfLot(String number) {    //номер лота
        $("#BaseMainContent_MainContent_txtNumber_txtText").setValue(number);
        Search.click();
        String finishnumber = $("a[href='/supplier/auction/Trade/View.aspx?Id=" + number + "']").shouldBe(visible).getText();
        return finishnumber;
    }

    public String searchStatus(String status){        //статус лота

        $("#BaseMainContent_MainContent_ddlTradeLotState_ddlList_chzn").click();
        $("#BaseMainContent_MainContent_ddlTradeLotState_ddlList_chzn > div > ul").shouldBe(visible);
        $$("#BaseMainContent_MainContent_ddlTradeLotState_ddlList_chzn > div > ul > li").shouldHaveSize(25);
        ElementsCollection statusCollection = $$("#BaseMainContent_MainContent_ddlTradeLotState_ddlList_chzn > div > ul > li");

        for (SelenideElement st: statusCollection           //st-статус
                ) {
            if (st.getText().equals(status)){
                st.click();
                st.shouldHave(attribute("class","active-result result-selected"));
            }
        }
        Search.click();
        String finishStatus = $(By.xpath("//*[contains(@title, '" + status + "') and text() = '" + status + "']")).getText();
        return finishStatus;
    }

    public String searchRegion(String regionName) {           //статус региона лота

        $("#BaseMainContent_MainContent_ddlRegion_ddlList_chzn").click();
        $("#BaseMainContent_MainContent_ddlRegion_ddlList_chzn > div > ul").shouldBe(visible);
        $$("#BaseMainContent_MainContent_ddlRegion_ddlList_chzn > div > ul > li").shouldHaveSize(86);
        ElementsCollection regionCollection = $$("#BaseMainContent_MainContent_ddlRegion_ddlList_chzn > div > ul > li");

        for (SelenideElement str : regionCollection) {           //str-статус региона
            if (str.getText().equals(regionName)) {
                str.click();
                str.shouldHave(attribute("class", "active-result result-selected"));
            }
        }
        Search.click();
        String finishRegion = $(By.xpath("//*[contains(@title, '" + regionName + "') and text() = '" + regionName + "']")).getText(); //проверка корректности выбора региона
        return finishRegion;
    }

    public String searchSubject(String subject) {
        logger.info("Method started");
        $("#BaseMainContent_MainContent_txtLotName_txtText").setValue(subject);
        logger.info("Value is set");
        Search.click();
        logger.info("SearchButton clicked");
        String finishContract = $(By.xpath("//*[contains(@title, '" + subject + "') and text() = '" + subject + "']")).waitUntil(visible, 5000).getText();

        return finishContract;
    }

    public boolean checkBoxWorkTest(){          //потом прописать данный метод для всех чекбоксов страницы.расширить логику

        SelenideElement tradeName = $("#BaseMainContent_MainContent_cbxUseTradeName");
        SelenideElement lotName = $("#BaseMainContent_MainContent_cbxUseLotName");

        tradeName.click();
        tradeName.click();
        lotName.click();
        lotName.click();

        if (tradeName.isSelected() && lotName.isSelected()){
            return true;
        } else {
            return false;
        }
    }


}
