package elize;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

public class AppTest {

    @BeforeClass
    public static void setup() {
        Configuration.browser = "chrome";
        Configuration.startMaximized = true;
        open("http:/ya.ru");
    }
    @Test
    public void getUrl() {
        $(By.name("text")).setValue("быстроденьги").pressEnter();
        $(withText("» — срочные займы")).click();
        String s = Selenide.switchTo().window(1).getTitle();
        if (s.contains("«Быстроденьги» — Займы денег наличными, онлайн микрозаймы"))
        {
            System.out.println("Открылась нужная вкладка : "+ s);
        } else {
            System.out.println("Ошибка в тесте, открылась не та вкладка : " + s);
        }
    }

}