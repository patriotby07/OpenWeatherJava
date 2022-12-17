package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import pages.top_menu.*;
import utils.ProjectConstants;

import java.util.List;

public class TopMenuTest extends BaseTest {

    @Test
    public void testAPIMenuNavigatesToAPIPage() {
        final String expectedURL = "https://openweathermap.org/api";

        APIPage apiPage = openBaseURL()
                .clickAPIMenu();

        Assert.assertEquals(apiPage.getCurrentURL(), expectedURL);
    }

    @Test
    public void testMarketplaceMenuNavigatesToMarketplacePage() {
//        final String expectedURL = "https://home.openweathermap.org/marketplace";
//
//        openBaseURL();
//
//        MainPage mainPage = new MainPage(getDriver());
//
//        mainPage.clickMarketplaceMenu();
//
//        switchToAnotherWindow(getDriver());
//
//        Assert.assertEquals(getExternalPageURL(), expectedURL);
    }

    @Test
    public void testGuideMenuNavigatesToGuidePage() {
        final String basePageTitle = "Сurrent weather and forecast - OpenWeatherMap";
        final String expectedUrl = "https://openweathermap.org/guide";
        final String expectedTitle = "OpenWeatherMap API guide - OpenWeatherMap";

        GuidePage guidePage = openBaseURL().clickGuideMenu();

        Assert.assertNotEquals(basePageTitle, guidePage.getTitle());
        Assert.assertEquals(guidePage.getCurrentURL(), expectedUrl);
        Assert.assertEquals(guidePage.getTitle(), expectedTitle);
    }

    @Test
    public void testMapsMenuNavigatesToWeatherMapsPage() {
        final String mapsUrl = "https://openweathermap.org/weathermap";
        final String mapsTitle = "Interactive weather maps - OpenWeatherMap";
        final String baseUrl = getDriver().getCurrentUrl();

        WeatherMapsPage weatherMapsPage =
                openBaseURL()
                        .clickMapsMenu();

        String actualMapsUrl = weatherMapsPage.getCurrentURL().substring(0, 37);
        String actualMapsTitle = weatherMapsPage.getTitle();

        Assert.assertNotEquals(actualMapsUrl, baseUrl);
        Assert.assertEquals(actualMapsUrl, mapsUrl);
        Assert.assertEquals(actualMapsTitle, mapsTitle);
    }

    @Test
    public void testHowToStartMenuNavigatesToHowToStartPage() {
        final String basePageTitle = "Сurrent weather and forecast - OpenWeatherMap";
        final String expectedTitle = "How to start to work with Openweather API - OpenWeatherMap";
        final String expectedUrl = "https://openweathermap.org/appid";

        HowToStartPage howToStartPage = openBaseURL()
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

        MainPage mainPage = openBaseURL();
        Assert.assertTrue(mainPage.isPlaceholderDisplayed());

        String innerTextOfPlaceholder =mainPage.getInnerTextOfPlaceholder(attribute);

        Assert.assertEquals(innerTextOfPlaceholder, expectedInnerTextOfPlaceholder);
    }

    @Test
    public void testOurInitiativesMenuNavigatesToOurInitiativesPage() {
        final String expectedUrl = "https://openweathermap.org/our-initiatives";
        final String expectedTitle = "Our Initiatives - OpenWeatherMap";

        OurInitiativesPage ourInitiativesPage = openBaseURL().clickOurInitiativesMenu();

        Assert.assertEquals(ourInitiativesPage.getCurrentURL(), expectedUrl);
        Assert.assertEquals(ourInitiativesPage.getTitle(), expectedTitle);
    }

    @Test
    public void testSupportMenuHasLinks() {
        final List<String> expectedList = List.of("FAQ", "How to start", "Ask a question");

        List<String> actualList = openBaseURL()
                            .clickSupportMenu()
                            .getLinksText();

        Assert.assertEquals(actualList, expectedList);
    }

    @Test
    public void testSupportMenuIsClickable() {
        final String expectedIfVisible = "dropdown-menu dropdown-visible";
        final String expectedIfNotVisible = "dropdown-menu";

        MainPage mainPage = openBaseURL().clickSupportMenu();

        Assert.assertTrue(mainPage.isSupportDropdownContainerDisplayed());
        Assert.assertEquals(mainPage.getSupportMenuIsActiveValue(), expectedIfVisible);

        mainPage.clickSupportMenu();

        Assert.assertEquals(mainPage.getSupportMenuIsActiveValue(), expectedIfNotVisible);
    }


    @Test
    public void testPartnersMenuNavigatesToPartnersPage() {
        final String expectedCurrentURL = "https://openweathermap.org/examples";

        String currentURL =
                openBaseURL()
                        .clickPartnersMenu()
                        .getCurrentURL();

        Assert.assertEquals(currentURL, expectedCurrentURL);
    }

    @Test
    public void testPartnersPageTitle() {
        final String expectedTitle = "Partners and solutions - OpenWeatherMap";

        String title = openBaseURL()
                .clickPartnersMenu()
                .getTitle();

        Assert.assertEquals(title, expectedTitle);
    }


    @Test
    public void testGuideMenuNavigatesToGuidePage1() {
        final String expectedUrl = "https://openweathermap.org/guide";
        final String expectedTitle = "OpenWeatherMap API guide - OpenWeatherMap";

        GuidePage guidePage =
                openBaseURL()
                        .clickGuideMenu();
        Assert.assertEquals(guidePage.getCurrentURL(), expectedUrl);
        Assert.assertEquals(guidePage.getTitle(), expectedTitle);
    }

    @Test
    public void testTopMenuLinkAmount() {
        final int expectedLinkAmouunt = 12;

        int actualTopMenuLinkAmount =
                openBaseURL()
                        .topMenuLinkAmount();

        Assert.assertEquals(actualTopMenuLinkAmount, expectedLinkAmouunt);
    }

    @Test
    public  void testCompanyLogoNavigatesToBaseURL() {
        final String expectedURL = "https://openweathermap.org/";
        final String expectedTitle = "Сurrent weather and forecast - OpenWeatherMap";

        MainPage mainPage = openBaseURL().clickLogo();

        Assert.assertEquals(mainPage.getCurrentURL(), expectedURL);
        Assert.assertEquals(mainPage.getTitle(), expectedTitle);
    }

    @Test
    public void testFAQSupportSubmenuNavigatesToFAQPage() {
        final String expectedUrl = "https://openweathermap.org/faq";

        String actualUrl = openBaseURL()
                .clickSupportMenu()
                .clickFAQSupportSubmenu()
                .getCurrentURL();

        Assert.assertEquals(actualUrl, expectedUrl);
    }

    @Test
    public void testDashboardMenuNavigatesToDashboardPage() {
        final String expectedURL = "https://openweathermap.org/weather-dashboard";

        String weatherDashboardURL = openBaseURL()
                .clickDashboardMenu()
                .getCurrentURL();

        Assert.assertEquals(weatherDashboardURL, expectedURL);
    }

    @Test
    public void testPricingMenuNavigatesToPricePage() {
        final String basePageTitle = "Сurrent weather and forecast - OpenWeatherMap";
        final String expectedPriceURL = "https://openweathermap.org/price";
        final String expectedPricingTitle = "Pricing - OpenWeatherMap";

        PricePage pricePage = openBaseURL().clickPricingMenu();

        Assert.assertNotEquals(basePageTitle, pricePage.getTitle());
        Assert.assertEquals(pricePage.getCurrentURL(), expectedPriceURL);
        Assert.assertEquals(pricePage.getTitle(),expectedPricingTitle);
    }

    @Test
    public void testEachTopMenuNavigatesToCorrespondingPage() {
        final List<String> expectedURLs = List.of(
                "https://openweathermap.org/guide", "https://openweathermap.org/api",
                "https://openweathermap.org/weather-dashboard", "https://home.openweathermap.org/marketplace",
                "https://openweathermap.org/price",
                "https://openweathermap.org/weathermap?basemap=map&cities=true&layer=temperature&lat=30&lon=-20&zoom=5",
                "https://openweathermap.org/our-initiatives", "https://openweathermap.org/examples",
                "https://openweather.co.uk/blog/category/weather", "https://openweather.co.uk/",
                "https://home.openweathermap.org/users/sign_in");

        List<String> actualURLs = openBaseURL().getAllMenusLinks();

        Assert.assertEquals(actualURLs, expectedURLs);
    }

    @Test
    public void testHamburgerMenuIsAvailableAndHasOptions_TopMenu() {
        final int expectedNumberOfOptionsHamburgerMenu = 12;
        final List<String> expectedHamburgerMenuList = List.of(
                "Guide", "API", "Dashboard", "Marketplace", "Pricing",
                "Maps", "Our Initiatives", "Partners", "Blog", "For Business", "Ask a question", "Sign in");

        MainPage mainPage = openBaseURL()
                .setWindowWithHamburgerMenu(ProjectConstants.WIDTH_HAMBURGER_MENU,ProjectConstants.HEIGHT_HAMBURGER_MENU)
                .clickHamburgerMenuIcon();

        Assert.assertTrue(mainPage.isHamburgerIconDisplayed());
        Assert.assertTrue(mainPage.getNumberOfOptionsHamburgerMenu() > 0);
        Assert.assertEquals(mainPage.getNumberOfOptionsHamburgerMenu(), expectedNumberOfOptionsHamburgerMenu);
        Assert.assertEquals(mainPage.getHamburgerMenuList(), expectedHamburgerMenuList);
    }

    @Test
    public void testHamburgerMenuHasLogo() {
        final String expectedUrl = "https://openweathermap.org/";

        MainPage mainPage = openBaseURL()
                .setWindowWithHamburgerMenu(ProjectConstants.WIDTH_HAMBURGER_MENU,ProjectConstants.HEIGHT_HAMBURGER_MENU)
                .clickLogo();

        Assert.assertTrue(mainPage.isLogoIconDisplayed());

        Assert.assertEquals(mainPage.getCurrentURL(),expectedUrl);
    }

    @Test
    public void testNavigationBarSearchField_NavigatesToFindPage() {
        final String findPageURL = "https://openweathermap.org/find?q=Barcelona";
        final String cityName = "Barcelona";

        String oldURL = openBaseURL().getCurrentURL();

        String actualURL = new MainPage(getDriver())
                .clickSearchFieldTopMenu()
                .inputSearchCriteriaAndEnter(cityName)
                .getCurrentURL();

        Assert.assertNotEquals(oldURL, actualURL);
        Assert.assertEquals(actualURL, findPageURL);
    }

    @Test
    public void testSignInMenuNavigatesToSignInPage() {
        final String expectedWelcomeMessage = "Sign In To Your Account";

        String actualWelcomeMessage = openBaseURL()
                .clickSignInMenu()
                .getWelcomeMessage();

        Assert.assertEquals(actualWelcomeMessage, expectedWelcomeMessage);
    }


}
