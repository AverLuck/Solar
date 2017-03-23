package ua.test.first;

import com.codeborne.selenide.Configuration;
import org.junit.Assert;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.open;
/**
 * Created by Averluck on 06.03.2017.
 */
import org.apache.log4j.Logger;
import org.junit.Before;

public class Tests {

    final static Logger logger = Logger.getLogger(PageElementsSearch.class);

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "D:/Solar/chromedriver.exe");
        Configuration.browser = "chrome";
        open("https://223.rts-tender.ru/supplier/auction/Trade/Search.aspx");

    }

    @Test
    public void searchPublicationDate() {

        String date = "25.02.2017";
        PageElementsSearch tp = new PageElementsSearch();

        String tmp = tp.searchPublicationDate(date).substring(0, 10);
        Assert.assertEquals(tmp, date);

    }

    @Test
    public void searchSubject(){
        String subject = "Поставка раскладушек с матрасом";
        PageElementsSearch sp = new PageElementsSearch();
        Assert.assertEquals(sp.searchSubject(subject), subject);

    }

    @Test
    public void searchRegion(){
        logger.info("<-----------searchRegion start----------->");
        String name= "Московская обл.";
        PageElementsSearch tp = new PageElementsSearch();
        Assert.assertEquals(tp.searchRegion(name), name);

    }

    @Test
    public void searchStatus(){
        String status = "Прием заявок";
        PageElementsSearch tp = new PageElementsSearch();
        Assert.assertEquals(tp.searchStatus(status), status);

   }

    @Test
    public void searchNameOfLot() {
        String name = "Поставка раскладушек с матрасом";
        PageElementsSearch tp = new PageElementsSearch();
        Assert.assertEquals(tp.searchNameOfLot(name),name);

    }

    @Test
    public void searchNumberOfLot() {
        String number = "52310";
        PageElementsSearch tp = new PageElementsSearch();
        Assert.assertEquals(tp.searchNumberOfLot(number), number);
    }

    @Test
    public void checkBoxTest() {
        PageElementsSearch sp = new PageElementsSearch();
        Assert.assertEquals(sp.checkBoxWorkTest(), true);
    }
}