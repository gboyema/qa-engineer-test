package game;

import game.configuration.ConfigFileReader;
import game.configuration.TestData;
import game.webpages.Modal;
import game.webpages.Top;
import game.webpages.audio.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.lang.reflect.Array;
import java.util.List;

public class Index {
    public WebDriver driver;
    public ConfigFileReader configFileReader;
    private Object List;

    @BeforeMethod
    public void setup_process() {
        configFileReader = new ConfigFileReader();
        //String userProfile = "C:\\Users\\soyoolag\\AppData\\Local\\Google\\Chrome\\User Data\\Profile 2";
        ChromeOptions options = new ChromeOptions();
        //options.addArguments("user-data-dir=" + userProfile);
        File file = new File(System.getProperty("user.dir") + "/src/main/resources/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        System.out.println("Setup Done");
    }

    @Test(dataProvider = "audio_notes", priority = 0)
    public void run_test(TestData data) throws Exception {
        driver.get(configFileReader.getappURL());

        Modal modal = new Modal(driver);
        modal.pageIsOpened();
        Thread.sleep(1300);
        modal.closeModal();
        Thread.sleep(2000);

        Drum drum = new Drum(driver);
        drum.drumPartVisible();
        Thread.sleep(1300);
        drum.stopDrum();
        Thread.sleep(900);
        drum.increaseBPM();

        Kick kick = new Kick(driver);
        Thread.sleep(1100);
        kick.scrollToSection();
        Thread.sleep(1000);
        kick.clickNotes(data);
        Thread.sleep(1100);
        kick.increaseRate();
        Thread.sleep(1000);
        kick.increaseDetune();
        Thread.sleep(1000);

        Snare snare = new Snare(driver);
        Thread.sleep(1100);
        snare.scrollToSection();
        Thread.sleep(1000);
        snare.clickNotes(data);
        Thread.sleep(1100);
        snare.increaseRate();
        Thread.sleep(1000);
        snare.increaseDetune();
        Thread.sleep(1000);

        Closed_hihat closedHihat = new Closed_hihat(driver);
        Thread.sleep(1100);
        closedHihat.scrollToSection();
        Thread.sleep(1000);
        closedHihat.clickNotes(data);
        Thread.sleep(1100);
        closedHihat.increaseRate();
        Thread.sleep(1000);
        closedHihat.increaseDetune();
        Thread.sleep(1000);

        BigCymbal bigCymbal = new BigCymbal(driver);
        Thread.sleep(1100);
        bigCymbal.scrollToSection();
        Thread.sleep(1000);
        bigCymbal.clickNotes(data);
        Thread.sleep(1100);
        bigCymbal.increaseRate();
        Thread.sleep(1000);
        bigCymbal.increaseDetune();
        Thread.sleep(1000);

        drum.startDrum();
    }

    @Test(priority = 1)
    public void second_test() throws InterruptedException {
        driver.get(configFileReader.getappURL());
        Thread.sleep(3000);

        Modal modal = new Modal(driver);
        modal.pageIsOpened();
        Thread.sleep(1300);
        modal.closeModal();
        Thread.sleep(2000);

        Top top = new Top(driver);
        top.showStatus();
        Thread.sleep(2000);
        top.pickBar();
        Thread.sleep(7000);
    }



    @DataProvider(name = "audio_notes")
    public Object[][] allTests_data() {
        return new Object[][]{
                {new TestData(0,2,4,6,8,10)}
        };
    }

    @AfterMethod
    public void done() {
        driver.quit();
        System.out.println("Success");
    }
}
