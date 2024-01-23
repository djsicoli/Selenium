import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import org.dj.elements.Elements;
public class CalorieCalculatorAgeVariationTest {

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
    public void testAgeVariation() {
        int[] ages = new int[]{20, 40, 60}; // Age values to test
        for (int age : ages) {
            setInputsAndCalculate(age);
            String resultText = elements.getResultText().getText();
            assertTrue("Result should contain 'Calories/day'", resultText.contains("Calories/day"));
            System.out.println("Age: " + age + " - " + resultText);
            // Additional checks or actions based on the result can be added here
        }
    }

    private void setInputsAndCalculate(int age) {
        // Assuming other inputs are constant and predefined
        String height = "5"; // Example height in feet
        String weight = "70"; // Example weight in kg
        String activityLevel = "1.55"; // Example activity level

        elements.getAgeBox().clear();
        elements.getAgeBox().sendKeys(String.valueOf(age));
        elements.getHeightMeterBox().clear();
        elements.getHeightMeterBox().sendKeys(height);
        elements.getWeightKgBox().clear();
        elements.getWeightKgBox().sendKeys(weight);
        new Select(elements.getActivityLevelDropdown()).selectByValue(activityLevel);
        elements.getCalculateButton().click();
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}