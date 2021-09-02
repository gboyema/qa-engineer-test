package game.webpages.audio;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class Drum {
    private WebDriver driver;

    @FindBy(how = How.XPATH, using = "//section[@class='controls-main']/h1")
    WebElement drum_text;

    @FindBy(how = How.XPATH, using = "//section[@class='controls-main']/button")
    WebElement drum_button;

    @FindBy(how = How.XPATH, using = "//section[@class='controls-main']/input")
    WebElement drum_bpm;

    public Drum (WebDriver driver) {
        this.driver = driver;

        PageFactory.initElements(driver, this);
    }

    public void drumPartVisible() {
        System.out.println(drum_text.getText());
        Assert.assertEquals(drum_text.getText(), "Drum Machine");
    }

    public void stopDrum() {
        drum_button.click();
    }

    public void startDrum() {
        drum_button.click();
    }

    public void increaseBPM() throws Exception {
        Actions action = new Actions(driver);
        action.clickAndHold(drum_bpm);
        action.click(drum_bpm).build().perform();
        Thread.sleep(1000);
        for (int i = 0; i < 20; i++)
        {
            action.sendKeys(Keys.ARROW_RIGHT).build().perform();
            Thread.sleep(200);
        }
    }

    public void reduceBPM() throws Exception {
        Actions action = new Actions(driver);
        action.clickAndHold(drum_bpm);
        action.click(drum_bpm).build().perform();
        Thread.sleep(1000);
        for (int i = 0; i < 20; i++)
        {
            action.sendKeys(Keys.ARROW_LEFT).build().perform();
            Thread.sleep(200);
        }
    }
}

