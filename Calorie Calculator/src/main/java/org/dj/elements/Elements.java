package org.dj.elements;

import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Elements {

    @FindBy(id = "cage")
    @Getter
    private WebElement ageBox;

    @FindBy(id = "csex1") // Assuming 'Male' is selected
    @Getter
    private WebElement genderMaleRadio;

    @FindBy(id = "csex2") // Assuming 'Female' is selected
    @Getter
    private WebElement genderFemaleRadio;

    @FindBy(id = "cheightmeter") // For height in meters
    @Getter
    private WebElement heightMeterBox;

    @FindBy(id = "cheightfeet") // For height in feet
    @Getter
    private WebElement heightFeetBox;

    @FindBy(id = "cheightinch") // For height in inches
    @Getter
    private WebElement heightInchBox;

    @FindBy(id = "ckg") // For weight in kilograms
    @Getter
    private WebElement weightKgBox;

    @FindBy(id = "cpound") // For weight in pounds
    @Getter
    private WebElement weightLbBox;

    @FindBy(id = "cactivity")
    @Getter
    private WebElement activityLevelDropdown;

    @FindBy(css = "input[type='submit'][name='x'][value='Calculate']") // 'Calculate' button
    @Getter
    private WebElement calculateButton;

    @FindBy(className = "verybigtext") // Result text
    @Getter
    private WebElement resultText;

    @FindBy(xpath = "//a[contains(text(),'Metric Units')]")
    @Getter
    private WebElement metricUnitsLink;

    @FindBy(xpath = "//a[contains(text(),'US Units')]")
    @Getter
    private WebElement usUnitsLink;
}
