package game.webpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Top {
    private WebDriver driver;

    @FindAll(@FindBy(how = How.XPATH, using = "//div[@id='result']/div"))
    List<WebElement> top_bars;

    @FindBy(how = How.XPATH, using = "//section/h3[@id='status']")
    WebElement status;

    public Top(WebDriver driver) {
        this.driver = driver;

        PageFactory.initElements(driver, this);
    }

    public void pickBar() {
        top_bars.get(1).click();
    }

    public void showStatus() {
        System.out.println("Status: "+status.getText());
    }
}
