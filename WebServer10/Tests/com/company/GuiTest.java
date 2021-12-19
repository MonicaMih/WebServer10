package com.company;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class GuiTest {
    WebDriver driver = new ChromeDriver();
    @Test
    public void actionPerformed()
    {

        driver.manage().window().maximize();
        Assert.assertEquals(1,driver.equals(1));
    }



}
