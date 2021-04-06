package selenium;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeOptions;

public class SeleniumTest {

    @Test
    public void firstTest() {

        System.setProperty("selenide.headless", "true");
        System.setProperty("Configuration.headless", "true");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-extensions"); // disabling extensions
        options.addArguments("--disable-dev-shm-usage"); // overcome limited resource problems
        options.addArguments("--no-sandbox"); // Bypass OS security model

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