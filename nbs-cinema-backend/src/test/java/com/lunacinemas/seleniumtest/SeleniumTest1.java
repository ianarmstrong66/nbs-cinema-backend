package com.lunacinemas.seleniumtest;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Keys;

import static org.junit.Assert.assertTrue;

public class SeleniumTest1 {
    private ChromeDriver driver;

    @Before
    public void setUp() {
        System.setProperty(
                "webdriver.chrome.driver", "./src/test/Resources/chromedriver.exe"
        );
        driver = new ChromeDriver();
    }

    @Test
    public void bookingTest() {
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;

            driver.manage().window().maximize();
            driver.get("http://35.176.119.160:3000/");
            WebElement page_text = driver.findElementByPartialLinkText("Upcoming Films");
            assertTrue(page_text.isDisplayed());
            WebElement elem = driver.findElement(By.id("UpcomingFilms_Link"));
            assertTrue(elem.isDisplayed());
            elem.click();
            Thread.sleep(2000);
            WebElement bar = driver.findElement(By.id("searchBar"));
            assertTrue(bar.isDisplayed());
            bar.sendKeys("gemini");
            Thread.sleep(3000);
            driver.findElement(By.id("searchBar")).sendKeys(Keys.RETURN);
            Thread.sleep(3000);
            js.executeScript("window.scrollBy(0,200)");
            driver.findElement(By.cssSelector("#root > div > div.container > div > div:nth-child(2) > div > div.card-footer > small > a:nth-child(2) > button")).click();
            Thread.sleep(5000);
            js.executeScript("window.scrollBy(0,200)");
            driver.findElement(By.cssSelector("#Book_btn")).click();
            Thread.sleep(3000);
            driver.findElement(By.id("Nav_Logo")).click();
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void bookingTest2() {
//        try {
        driver.manage().window().maximize();
        driver.get("http://35.176.119.160:3000/");
//            Thread.sleep(1000);
        String page_text = driver.findElementByTagName("body").getText();
        assertTrue(page_text.contains("Upcoming Films"));
        driver.findElement(By.id("CurrentFilms_Link")).click();
//            Thread.sleep(2000);
        driver.findElement(By.id("searchBar")).sendKeys("spider");
//            Thread.sleep(3000);
        driver.findElement(By.id("searchBar")).sendKeys(Keys.RETURN);
//            Thread.sleep(3000);
        driver.findElement(By.id("MoreInfo_btn")).click();
//            Thread.sleep(5000);
        driver.findElement(By.id("Book_btn")).click();
//            Thread.sleep(3000);


        driver.findElement(By.id("Nav_Logo")).click();
//            Thread.sleep(2000);

//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }

    @Test
    public void screenSelectionTest() {
//        try {
        driver.manage().window().maximize();
        driver.get("http://35.176.119.160:3000/");
//            Thread.sleep(1000);
        String page_text = driver.findElementByTagName("body").getText();
        assertTrue(page_text.contains("Upcoming Films"));
        driver.findElement(By.id("Screens_Link")).click();
//            Thread.sleep(3000);
        driver.findElement(By.id("StdScreen_btn")).click();
//            Thread.sleep(3000);
        driver.findElement(By.id("DeluxeScn2_btn")).click();
//            Thread.sleep(3000);
        driver.findElement(By.id("Nav_Logo")).click();
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }

    @Test
    public void openingTimesTest() {
//        try{
        driver.manage().window().maximize();
        driver.get("http://35.176.119.160:3000/");
//            Thread.sleep(1000);
        String page_text = driver.findElementByTagName("body").getText();
        assertTrue(page_text.contains("Upcoming Films"));
        driver.findElement(By.id("OpeningTimes_Link")).click();
//            Thread.sleep(3000);
        driver.findElement(By.id("Nav_Logo")).click();
//            Thread.sleep(2000);

//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }

    @Test
    public void about_ContactTest() {
//        try{

        driver.manage().window().maximize();
        driver.get("http://35.176.119.160:3000/");
//            Thread.sleep(1000);
        String page_text = driver.findElementByTagName("body").getText();
        assertTrue(page_text.contains("Upcoming Films"));
        driver.findElement(By.id("About_Link")).click();
//            Thread.sleep(3000);
        driver.findElement(By.id("ContactSub_btn")).click();
//            Thread.sleep(3000);
        driver.findElement(By.id("emailButton")).click();
//            Thread.sleep(3000);
        driver.findElement(By.id("Forename")).sendKeys("Dale");
//            Thread.sleep(500);
        driver.findElement(By.id("Surname")).sendKeys("Thompson-Cox");
//            Thread.sleep(500);
        driver.findElement(By.id("EmailAdd")).sendKeys("dale.cox1991@hotmail.co.uk");
//            Thread.sleep(500);
        driver.findElement(By.id("Subject")).sendKeys("Booking Issue");
//            Thread.sleep(500);
        driver.findElement(By.id("Message")).sendKeys("Hello, I am having trouble booking a film, please may you help?");
//            Thread.sleep(500);
        driver.findElement(By.id("SubmitMsg_btn")).click();
//            Thread.sleep(3000);
        driver.findElement(By.id("Nav_Logo")).click();
//            Thread.sleep(2000);

//    } catch (InterruptedException e) {
//        e.printStackTrace();
//    }
    }

    @Test
    public void about_ContactErrorTest() {
//        try{

        driver.manage().window().maximize();
        driver.get("http://35.176.119.160:3000/");
//            Thread.sleep(1000);
        String page_text = driver.findElementByTagName("body").getText();
        assertTrue(page_text.contains("Upcoming Films"));
        driver.findElement(By.id("About_Link")).click();
//            Thread.sleep(3000);
        driver.findElement(By.id("ContactSub_btn")).click();
//            Thread.sleep(3000);
        driver.findElement(By.id("emailButton")).click();
//            Thread.sleep(3000);
        driver.findElement(By.id("Forename")).sendKeys("Dale");
//            Thread.sleep(500);
        driver.findElement(By.id("Surname")).sendKeys("Thompson-Cox");
//            Thread.sleep(500);
        driver.findElement(By.id("Subject")).sendKeys("Booking Issue");
//            Thread.sleep(500);
        driver.findElement(By.id("Message")).sendKeys("Hello, I am having trouble booking a film, please may you help?");
//            Thread.sleep(500);
        driver.findElement(By.id("SubmitMsg_btn")).click();
//            Thread.sleep(5000);
        driver.findElement(By.id("EmailAdd")).sendKeys("dale.cox1991@hotmail.co.uk");
//            Thread.sleep(500);
        driver.findElement(By.id("SubmitMsg_btn")).click();
//            Thread.sleep(5000);
        driver.findElement(By.id("Nav_Logo")).click();
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }

    @Test
    public void classificationsTest() {
//        try{

        driver.manage().window().maximize();
        driver.get("http://35.176.119.160:3000/");
//            Thread.sleep(1000);
        String page_text = driver.findElementByTagName("body").getText();
        assertTrue(page_text.contains("Upcoming Films"));
        driver.findElement(By.id("Classifications_Link")).click();
//            Thread.sleep(3000);
        driver.findElement(By.id("U_Info")).click();
//            Thread.sleep(5000);
        driver.findElement(By.id("12/12A_Info")).click();
//            Thread.sleep(5000);
        driver.findElement(By.id("15_Info")).click();
//            Thread.sleep(5000);
        driver.findElement(By.id("18_Info")).click();
//            Thread.sleep(5000);
        driver.findElement(By.id("Ratings_Info")).click();
//            Thread.sleep(3000);
        driver.findElement(By.id("BBFC_Link")).click();
//            Thread.sleep(3000);
        driver.get("http://localhost:3000/Classifications");
//            Thread.sleep(3000);
        driver.findElement(By.id("Nav_Logo")).click();
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }

    @Test
    public void gettingHereTest() {
//        try{
        driver.manage().window().maximize();
        driver.get("http://35.176.119.160:3000/");
//            Thread.sleep(1000);
        String page_text = driver.findElementByTagName("body").getText();
        assertTrue(page_text.contains("Upcoming Films"));
        driver.findElement(By.id("GettingHere_Link")).click();
//            Thread.sleep(3000);
        driver.findElement(By.id("Nav_Logo")).click();
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }

    @Test
    public void placesToGoTest() {
//        try{
        driver.manage().window().maximize();
        driver.get("http://35.176.119.160:3000/");
//            Thread.sleep(1000);
        String page_text = driver.findElementByTagName("body").getText();
        assertTrue(page_text.contains("Upcoming Films"));
        driver.findElement(By.id("Places_Link")).click();
//            Thread.sleep(3000);
        driver.findElement(By.id("FB_Link")).click();
//            Thread.sleep(3000);
        driver.get("http://localhost:3000/PlacesToGo");
//            Thread.sleep(3000);
        driver.findElement(By.id("HW_Link")).click();
//            Thread.sleep(3000);
        driver.get("http://localhost:3000/PlacesToGo");
//            Thread.sleep(3000);
        driver.findElement(By.id("Chiq_Link")).click();
//            Thread.sleep(3000);
        driver.get("http://localhost:3000/PlacesToGo");
//            Thread.sleep(3000);
        driver.findElement(By.id("PH_Link")).click();
//            Thread.sleep(3000);
        driver.get("http://localhost:3000/PlacesToGo");
//            Thread.sleep(3000);
        driver.findElement(By.id("Nan_Link")).click();
//            Thread.sleep(3000);
        driver.get("http://localhost:3000/PlacesToGo");
//            Thread.sleep(3000);
        driver.findElement(By.id("Frat_Link")).click();
//            Thread.sleep(3000);
        driver.get("http://localhost:3000/PlacesToGo");
//            Thread.sleep(3000);
        driver.findElement(By.id("Nav_Logo")).click();
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }

    @Test
    public void reviewTest() {
//        try {
        driver.manage().window().maximize();
        driver.get("http://35.176.119.160:3000/");
//            Thread.sleep(1000);
        driver.findElement(By.id("CurrentFilms_Link")).click();
//            Thread.sleep(2000);
        driver.findElement(By.id("searchBar")).sendKeys("spider");
//            Thread.sleep(3000);
        driver.findElement(By.id("searchBar")).sendKeys(Keys.RETURN);
//            Thread.sleep(3000);
        driver.findElement(By.id("MoreInfo_btn")).click();
//            Thread.sleep(5000);
        driver.executeScript("window.scrollBy(0,1000)");
//            Thread.sleep(2000);
        driver.findElement(By.id("Reviews_btn")).click();
//            Thread.sleep(3000);
        driver.findElement(By.id("username")).sendKeys("Andy");
//            Thread.sleep(1000);
        driver.findElement(By.id("rating")).sendKeys("5");
//            Thread.sleep(1000);
        driver.findElement(By.id("review")).sendKeys("Astonishing Film");
//            Thread.sleep(3000);
        driver.findElement(By.id("Submit_btn")).click();
//            Thread.sleep(3000);
        driver.executeScript("window.scrollBy(0,2500)");
//            Thread.sleep(2000);
        String page_text = driver.findElementByTagName("body").getText();
        assertTrue(page_text.contains("Good Film, really enjoyed it."));
        driver.findElement(By.id("Nav_Logo")).click();
//            Thread.sleep(2000);

//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }

    @After
    public void tearDown() {
        driver.close();
    }
}
