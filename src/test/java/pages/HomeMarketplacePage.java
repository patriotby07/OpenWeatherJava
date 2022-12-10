package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomeMarketplacePage extends HomeFooterMenuPage {

    @FindBy(className = "button-round")
    private List<WebElement> allButtons;

    @FindBy(xpath = "//ul[@id='desktop-menu']//a[@href='/history_bulks/new']")
    private WebElement historyBulkMenu;

    @FindBy(xpath = "//div[@class='button-container']//a[@href='http://openweathermap.org/api/history-data-state']")
    private WebElement dataByStateDocumentationButton;

    @FindBy(xpath = "//div[@id=\"app\"]/div[2]/div/div[2]/div[2]/div/h5/a")
    private WebElement weatherDataByStateMenu;

    public HomeMarketplacePage(WebDriver driver) {
        super(driver);
    }

    public HomeMarketplacePage switchToMarketplaceWindow() {
        switchToAnotherWindow();

        return this;
    }

    public List<WebElement> getAllButtons() {

        return allButtons;
    }

    public boolean areAllButtonsVisibleAndClickable() {

        return allElementsVisibleAndClickable(allButtons);
    }

    public HomeHistoryBulksNewPage clickHistoryBulkMenu() {
        click(historyBulkMenu);

        return new HomeHistoryBulksNewPage(getDriver());
    }

    public HomeZipCodeDataNewPage clickWeatherDataByStateMenu() {
        click20(weatherDataByStateMenu);

        return new HomeZipCodeDataNewPage(getDriver());
    }
}
