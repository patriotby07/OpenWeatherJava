import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import runner.BaseTest;

import java.util.concurrent.TimeUnit;

public class NataliaRamanenkaTest extends BaseTest {
    @Test
    public void testH2TagText_WhenSearchingCityCountry() throws InterruptedException {
        String url = "https://openweathermap.org/";
        String cityName = "Paris";
        String expectedResult = "Paris, FR";

        getDriver().get(url);
        Thread.sleep(7000);

        WebElement searchCityField = getDriver().findElement(
                By.xpath("//div[@id = 'weather-widget']//input[@placeholder = 'Search city']")
        );
        searchCityField.click();
        searchCityField.sendKeys(cityName);

        WebElement searchButton = getDriver().findElement(
                By.xpath("//div[@id = 'weather-widget']//button[@type = 'submit']")
        );
        searchButton.click();
        Thread.sleep(2000);

        WebElement parisFRChoiceInDropdownMenu = getDriver().findElement(
                By.xpath("//ul[@class = 'search-dropdown-menu']/li/span[text() = 'Paris, FR ']")
        );
        parisFRChoiceInDropdownMenu.click();

        WebElement h2CityCountryHeader = getDriver().findElement(
                By.xpath("//div[@id = 'weather-widget']//h2")
        );
        Thread.sleep(2000);
        String actualResult = h2CityCountryHeader.getText();

        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void testGuideLinkAndTitle() throws InterruptedException {
        String url = "https://openweathermap.org/";
        String expectedResult1 = "https://openweathermap.org/guide";
        String expectedResult2 = "OpenWeatherMap API guide - OpenWeatherMap";

        getDriver().get(url);
        Thread.sleep(7000);
        WebElement searchGuide =  getDriver().findElement(
                By.xpath("//div[@id = 'desktop-menu']/ul/li/a[@href = '/guide']"));
        searchGuide.click();
        Thread.sleep(2000);
        String actualResult1 =  getDriver().getCurrentUrl();
        String actualResult2 =  getDriver().getTitle();

        Assert.assertEquals(actualResult1, expectedResult1);
        Assert.assertEquals(actualResult2, expectedResult2);
    }
    @Test
    public void testUnitsOfMeasurementIsFaringates() throws InterruptedException {
        String url = "https://openweathermap.org/";
        String measure = "F";
        boolean expectedResult = true;

        getDriver().get(url);
        Thread.sleep(7000);
        WebElement searchImperialF = getDriver().findElement(By.xpath("//div[text() = 'Imperial: °F, mph']"));
        searchImperialF.click();
        Thread.sleep(2000);
        WebElement searchF = getDriver().findElement(By.xpath("//span[@class = 'heading']"));
        boolean actualResult = searchF.getText().contains(measure);

        Assert.assertEquals(actualResult, expectedResult);

    }

}
