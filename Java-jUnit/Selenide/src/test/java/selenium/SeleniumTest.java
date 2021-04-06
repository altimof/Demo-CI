package selenium;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

import org.junit.Test;
import org.openqa.selenium.By;

public class SeleniumTest {

    @Test
    public void firstTest() {

        System.setProperty("selenide.headless", "true");
        System.setProperty("Configuration.headless", "true");

        open("http://explorecalifornia.org/contact.htm");
        $("#name").should(appear);
        $("#comments").should(appear);

        $("#name").setValue("oleksiit");
        $("#state").selectOptionContainingText("California");
        $("#backpack").click();
        $(By.name("newsletter")).selectRadio("yes");

        $("#name").shouldHave(value("oleksiit"));
        assert($("#state").getSelectedText()).equals("California");
        $("#backpack").shouldBe(selected);
        $(By.name("newsletter")).shouldHave(value("yes"));
    }
}