package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.APIPage;
import pages.GuidePage;
import pages.HowToStartPage;
import pages.MainPage;
import pages.OurInitiativesPage;

import java.util.List;

public class TopMenuTest extends BaseTest {

    @Test
    public void testAPIMenuNavigatesToAPIPage() {
        final String expectedURL = "https://openweathermap.org/api";

        openBaseURL();

        MainPage mainPage = new MainPage(getDriver());

        mainPage.clickAPIMenu();

        APIPage apiPage = new APIPage(getDriver());

        Assert.assertEquals(apiPage.getCurrentURL(), expectedURL);
    }

    @Test
    public void testMarketplaceMenuNavigatesToMarketplacePage() {
        final String expectedURL = "https://home.openweathermap.org/marketplace";

        openBaseURL();

        MainPage mainPage = new MainPage(getDriver());

        mainPage.clickMarketplaceMenu();

        switchToAnotherWindow(getDriver());

        Assert.assertEquals(getCurrentURL(), expectedURL);
    }

    @Test
    public void testLinkAndTitle_WhenGoingToGuideMenu() {
        final String expectedUrl = "https://openweathermap.org/guide";
        final String expectedTitle = "OpenWeatherMap API guide - OpenWeatherMap";

        GuidePage guidePage = openBaseURL_ReturnMainPage().clickGuideMenu();

        Assert.assertEquals(guidePage.getCurrentURL(), expectedUrl);
        Assert.assertEquals(guidePage.getTitle(), expectedTitle);
    }

    @Test
    public void testMapsMenuNavigatesToWeatherMapsPage_IriSamo () {
        final String mapsUrl = "https://openweathermap.org/weathermap";
        final String mapsTitle = "Interactive weather maps - OpenWeatherMap";

        openBaseURL();

        MainPage mainPage = new MainPage(getDriver());

        mainPage.clickMapsMenu();

        Assert.assertEquals(getCurrentURL().substring(0, 37), mapsUrl);

        Assert.assertEquals(getTitle(), mapsTitle);
    }

    @Test
    public void testHowToStartMenuNavigatesToHowToStartPage() {
        final String basePageTitle = "Сurrent weather and forecast - OpenWeatherMap";
        final String expectedTitle = "How to start to work with Openweather API - OpenWeatherMap";
        final String expectedUrl = "https://openweathermap.org/appid";

        HowToStartPage howToStartPage = openBaseURL_ReturnMainPage()
                .clickSupportMenu()
                .clickHowToStartSupportSubmenu();

        Assert.assertNotEquals(basePageTitle, howToStartPage.getTitle());
        Assert.assertEquals(howToStartPage.getCurrentURL(), expectedUrl);
        Assert.assertEquals(howToStartPage.getTitle(), expectedTitle);
    }

    @Test
    public void testPlaceholderIsAvailable_TopMenu() {
        final String expectedInnerTextOfPlaceholder = "Weather in your city";
        final String attribute = "placeholder";

        Assert.assertTrue(openBaseURL_ReturnMainPage().isPlaceholderDisplayed());

        String innerTextOfPlaceholder =
                openBaseURL_ReturnMainPage().
                        getInnerTextOfPlaceholder(attribute);

        Assert.assertEquals(innerTextOfPlaceholder, expectedInnerTextOfPlaceholder);
    }

    @Test
    public void testOurInitiativesMenuNavigatesToOurInitiativesPage() {
        final String expectedUrl = "https://openweathermap.org/our-initiatives";
        final String expectedTitle = "Our Initiatives - OpenWeatherMap";

        openBaseURL_ReturnMainPage();

        OurInitiativesPage ourInitiativesPage = openBaseURL_ReturnMainPage().clickOurInitiativesMenu();

        Assert.assertEquals(ourInitiativesPage.getCurrentURL(), expectedUrl);
        Assert.assertEquals(ourInitiativesPage.getTitle(), expectedTitle);
    }

    @Test
    public void testSupportMenuHasLinks() {
        final List<String> expectedList = List.of("FAQ", "How to start", "Ask a question");
        Assert.assertEquals(openBaseURL_ReturnMainPage().clickOnSupportMenu().getLinksList(), expectedList);
    }
    
    @Test    
    public void testSupportMenuIsClickable() {
        final String attribute = "class";
        final String expectedIfVisible = "dropdown-menu dropdown-visible";
        final String expectedIfNotVisible = "dropdown-menu";

        openBaseURL();

        MainPage mainPage = new MainPage(getDriver());

        mainPage.clickSupportMenu();

        Assert.assertEquals(mainPage.getSupportMenuIsActiveValue(attribute), expectedIfVisible);

        mainPage.clickSupportMenu();
    }


    public void testGuideMenuNavigatesToGuidePage() {
        final String expectedUrl = "https://openweathermap.org/guide";
        final String expectedTitle = "OpenWeatherMap API guide - OpenWeatherMap";


        GuidePage guidePage =
                openBaseURL_ReturnMainPage()
                        .clickGuideMenu();
        Assert.assertEquals(guidePage.getCurrentURL(), expectedUrl);
        Assert.assertEquals(guidePage.getTitle(), expectedTitle);
    }

    @Test
    public void testCountTopMenuButtons() {
        int expectedButton = 12;

        int actualCountTopMenuButtons =
                openBaseURL_ReturnMainPage()
                        .countTopMenuButtons();

        Assert.assertEquals(actualCountTopMenuButtons, expectedButton);
    }
}