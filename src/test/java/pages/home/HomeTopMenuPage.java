package pages.home;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;
import pages.base_abstract.FooterMenuPage;

import java.util.ArrayList;
import java.util.List;

public abstract class HomeTopMenuPage extends FooterMenuPage {

    @FindBy(xpath = "//li[@class='user-li']/a" )
    private WebElement signInTopMenu;

    @FindBy(xpath = "//ul[@id='myTab']/li")
    private List<WebElement> navTabLinks;

    public HomeTopMenuPage(WebDriver driver) {super(driver);}

    public int getNavTabLinksAmount() {

        return getListSize(navTabLinks);
    }

    public HomeSignInPage clickSignInMenu() {
        click(signInTopMenu);

        return new HomeSignInPage(getDriver());
    }

    public List<String> clickNavTabLinks() {
        List<String> urlList = new ArrayList<>();
        urlList.add(getCurrentURL());

        for (int i = 1; i < navTabLinks.size(); i++) {
            click(navTabLinks.get(i));
            urlList.add(getCurrentURL());

            if(i == 6) {
                goBack();
            }
        }

        return urlList;
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
}
