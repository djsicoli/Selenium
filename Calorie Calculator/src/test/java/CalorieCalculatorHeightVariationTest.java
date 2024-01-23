import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import org.dj.elements.Elements;

public class CalorieCalculatorHeightVariationTest {

    private WebDriver driver;
    private Elements elements;

    @Before
    public void setUp() {
        String basePath = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", basePath + "/src/main/resources/chromedriver.exe");

        driver = new ChromeDriver();
        driver.get("https://www.calculator.net/calorie-calculator.html");

        elements = new Elements();
        PageFactory.initElements(driver, elements);

        // Switch to US Units
        elements.getUsUnitsLink().click();
    }

    @Test
    public void testHeightVariation() {
        setBaselineInputs(); // Set age, gender, weight, activity level etc.

        // Test with height 5'6"
        setHeight("5", "6");
        elements.getCalculateButton().click();
        String resultForFiveSix = elements.getResultText().getText();
        System.out.println("Result for 5'6\": " + resultForFiveSix);

        // Test with height 6'0"
        setHeight("6", "0");
        elements.getCalculateButton().click();
        String resultForSixZero = elements.getResultText().getText();
        System.out.println("Result for 6'0\": " + resultForSixZero);

        // Test with height 6'4"
        setHeight("6", "4");
        elements.getCalculateButton().click();
        String resultForSixFour = elements.getResultText().getText();
        System.out.println("Result for 6'4\": " + resultForSixFour);

        // Optionally, compare the results here
    }

    private void setBaselineInputs() {
        // Set fixed values for age, gender, weight, activity level, etc.
        elements.getAgeBox().clear();
        elements.getAgeBox().sendKeys("30"); // Example age
        elements.getWeightLbBox().clear();
        elements.getWeightLbBox().sendKeys("70"); // Example weight in kg
        new Select(elements.getActivityLevelDropdown()).selectByValue("1.55"); // Example activity level
        // Set gender and other baseline inputs as needed
    }

    private void setHeight(String feet, String inches) {
        elements.getHeightFeetBox().clear();
        elements.getHeightFeetBox().sendKeys(feet);
        elements.getHeightInchBox().clear();
        elements.getHeightInchBox().sendKeys(inches);
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}