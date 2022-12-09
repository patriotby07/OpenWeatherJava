package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import java.util.List;

public class HomeSignInPage extends FooterMenuPage {

    @FindBy(id = "user_email")
    private WebElement userEmail;

    @FindBy(id = "user_password")
    private WebElement userPassword;

    @FindBy(name = "commit")
    private WebElement submitButton;

    @FindBy(xpath = "//div[@class = 'panel-body']")
    WebElement signOutMessage;

    @FindBy(xpath = "//h3")
    private WebElement h3Header;

    @FindBy(xpath = "//h2")
    private List<WebElement> h2Title;

    @FindBy(className = "btn_like")
    private List<WebElement> orangeButtons;

    @FindBy(xpath = "//ul[@class='nav nav-tabs pull-left']//a")
    private List<WebElement> navTabs;

    public HomeSignInPage(WebDriver driver) {
        super(driver);
    }

    public String getWelcomeMassage() {

        return getText(h3Header);
    }

    public HomeSignInPage clickClearInputRegularUserEmail() {
        click(userEmail);
        userEmail.clear();
        String email = "jka59433@xcoxc.com";
        input(email, userEmail);

        return this;
    }

    public HomeSignInPage clickClearInputRegularUserPassword() {
        click(userPassword);
        userPassword.clear();
        String password = "Tester12#";
        input(password, userPassword);

        return this;
    }

    public void clickSubmitButton() {
        click(submitButton);
    }

    public String getMessage() {

        return getText(signOutMessage);
    }

    public HomePage signInRegularUser() {
        clickClearInputRegularUserEmail();
        clickClearInputRegularUserPassword();
        clickSubmitButton();
        Reporter.log("DO NOT FORGET SIGN OUT", true);

        return new HomePage(getDriver());
    }

    public int getH2Titles() {

        return getListSize(h2Title);
    }

    public List<String> listH2TitlesSighInPage() {

        return getTexts(h2Title);
    }

    public int orangeButtonsSignIn() {
        allElementsVisibleAndClickable(orangeButtons);

        return getListSize(orangeButtons);
    }

    public int navTabs() {
        allElementsVisibleAndClickable(navTabs);

        return getListSize(navTabs);
    }

    public List<String> listNavTabElements() {

        return getTexts(navTabs);
    }
}
