package game.webpages.audio;

import game.configuration.TestData;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Kick {
    private WebDriver driver;

    @FindBy(how = How.XPATH, using = "//section[@class='track-one']/h3")
    WebElement text;

    @FindAll(@FindBy(how = How.XPATH, using = "//section[@class='track-one']/section/button"))
    List<WebElement> notes;

    @FindAll(@FindBy(how = How.XPATH, using = "//section[@class='track-one']/section/input"))
    List<WebElement> rate_detune;

    public Kick(WebDriver driver) {
        this.driver = driver;

        PageFactory.initElements(driver,this);
    }

    public void scrollToSection() {
        Actions actions = new Actions(driver);
        actions.moveToElement(text);
        actions.perform();
    }

    public void clickNotes(TestData data) {
        for (int i = 0; i < 5; i++) {
            notes.get(data.get(i)).click();
        }
    }

    public void increaseRate() throws Exception {
        Actions action = new Actions(driver);
        action.clickAndHold(rate_detune.get(0));
        action.click(rate_detune.get(0)).build().perform();
        Thread.sleep(1000);
        for (int i = 0; i < 4; i++)
        {
            action.sendKeys(Keys.ARROW_RIGHT).build().perform();
            Thread.sleep(200);
        }
    }

    public void increaseDetune() throws Exception {
        Actions action = new Actions(driver);
        action.clickAndHold(rate_detune.get(1));
        action.click(rate_detune.get(1)).build().perform();
        Thread.sleep(1000);
        for (int i = 0; i < 10; i++)
        {
            action.sendKeys(Keys.ARROW_RIGHT).build().perform();
            Thread.sleep(200);
        }
    }
}
