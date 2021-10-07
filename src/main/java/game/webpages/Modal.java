package game.webpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class Modal {
    private WebDriver driver;

    @FindBy(how = How.XPATH, using = "//div[@class='loading']/following-sibling::button")
    WebElement close_modal;

    @FindBy(how = How.XPATH, using = "//div[@class='loading']/following-sibling::h1")
    WebElement welcome_message_title;

    @FindBy(how = How.XPATH, using = "//div[@class='loading']/following-sibling::div")
    WebElement welcome_message_subtitle;

    public Modal (WebDriver driver) {
        this.driver = driver;

        PageFactory.initElements(driver, this);
    }

    public void pageIsOpened() {
        Assert.assertEquals(welcome_message_title.getText(), "Hello!");
        Assert.assertEquals(welcome_message_subtitle.getText(), "Welcome to the Evo Slot!");


    }

    public void closeModal() {
        close_modal.click();
    }

}
