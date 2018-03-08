package com.twobomb.app;

import com.sun.deploy.Environment;
import org.apache.commons.exec.environment.EnvironmentUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.HasInputDevices;
import org.openqa.selenium.interactions.internal.Coordinates;

import java.io.*;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws IOException {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\twobomb\\Documents\\chromedriver.exe");
        WebDriver wd = new ChromeDriver();

        FileOutputStream fos = new FileOutputStream(new File(System.getProperty("user.home") + "\\Desktop\\OUT.txt"));
        OutputStreamWriter osw = new OutputStreamWriter(fos);

        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        long tm = System.currentTimeMillis();
        for(int i = 1; i <= 570; i++){
            wd.get("https://manytorrents.pro/load/games/54-"+i);//570
            List<WebElement> els = wd.findElements(By.cssSelector("#pc-game>tbody>tr>td>div.eTitle>a"));
            for(WebElement el:els)
                osw.write(el.getText() + "\r\n");
        }
        tm = (System.currentTimeMillis() - tm)/1000;
        System.out.println("Прошло " + tm + " секунд!");
        osw.close();
        fos.close();
    }
}
