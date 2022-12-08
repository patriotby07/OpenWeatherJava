package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import java.util.List;

public abstract class HomeTopMenuPage extends FooterMenuPage {

    @FindBy(xpath = "//li[@class='user-li']/a" )
    private WebElement signInMenuTopMenu;

    @FindBy(xpath = "//ul[@id='myTab']/li")
    private List<WebElement> navTabLinks;

    public HomeTopMenuPage(WebDriver driver) {super(driver);}

    public HomeSignInPage clickSignInMenu() {
        click(signInMenuTopMenu);

        return new HomeSignInPage(getDriver());
    }

    public HomeSignInPage signOut() {
        click(getDriver().findElement(By.id("user-dropdown")));
        click(getDriver().findElement(By.xpath("//a[@href='/users/sign_out']")));
        Reporter.log(getDriver().findElement(By.xpath("//h3")).getText(), true);

        return new HomeSignInPage(getDriver());
    }

    public HomePage signIn() {
        clickSignInMenu()
                .clickClearInputRegularUserEmail()
                .clickClearInputRegularUserPassword()
                .clickSubmitButton();

        return new HomePage(getDriver());
    }

    public int getNavTabLinksAmount() {

        return getListSize(navTabLinks);
    }
}
