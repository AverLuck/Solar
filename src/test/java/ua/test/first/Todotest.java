package ua.test.first;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.junit.Assert;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
/**
 * Created by Averluck on 06.03.2017.
 */
public class Todotest {
    @Test
    public void testCreateTask() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "D:/Solar/chromedriver.exe");
        Configuration.browser = "chrome";
        boolean isSelected = true;

        open("https://223.rts-tender.ru/supplier/auction/Trade/Search.aspx");
        $("#BaseMainContent_MainContent_txtNumber_txtText").setValue("5012");
        $("#BaseMainContent_MainContent_btnSearch").click();
        $("#BaseMainContent_MainContent_txtName_txtText").setValue("картофель");

        SelenideElement checkbox  =  $("#BaseMainContent_MainContent_cbxUseTradeName");
        checkbox.click();

        if(!checkbox.isSelected()){
            isSelected = false;
        }
        Assert.assertEquals(false,isSelected); //run

        $("#BaseMainContent_MainContent_upFilter > div > div.filter > div > div.column.left > div > fieldset:nth-child(6) > button").click();
        $("body > div:nth-child(2) > ul > li:nth-child(2) > label").click();

        $("#BaseMainContent_MainContent_ddlTradeLotState_ddlList_chzn > a").click();
        $(""    )
        SelenideElement checkbox1 = $("#BaseMainContent_MainContent_cbxUseLotName");
        checkbox.click();
        if(!checkbox1.isSelected()) {
            isSelected=true;
        }
        Assert.assertEquals( true,isSelected);

        Thread.sleep(1000);


    }
}
