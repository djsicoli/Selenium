import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import org.dj.elements.Elements;

public class CalorieCalculatorTest {

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
    }

    @Test
    public void testCalorieCalculation() {
        // Input age
        elements.getAgeBox().clear();
        elements.getAgeBox().sendKeys("30");

        // Select gender
        WebElement genderMaleRadio = elements.getGenderMaleRadio();
        if (!genderMaleRadio.isSelected()) {
            genderMaleRadio.click();
        }

        // Input height
        elements.getHeightMeterBox().clear();
        elements.getHeightMeterBox().sendKeys("10");

        // Input weight
        elements.getWeightKgBox().clear();
        elements.getWeightKgBox().sendKeys("70");

        // Select activity level
        new Select(elements.getActivityLevelDropdown()).selectByValue("1.55");

        // Click Calculate
        elements.getCalculateButton().click();

        // Validate the result
        String resultText = elements.getResultText().getText();
        assertTrue("Calorie result should be displayed", resultText.contains("Calories/day"));
        System.out.println("Calorie Result: " + resultText);
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}