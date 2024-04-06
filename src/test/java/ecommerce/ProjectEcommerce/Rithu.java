package ecommerce.ProjectEcommerce;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Rithu {

  public static void main (String[] args) {

    WebDriver driver = new ChromeDriver();
    driver.get("https://www.google.com");

    String title = driver.getTitle();
    System.out.println(title);

    WebDriver d = new ChromeDriver();
    driver.get("https://www.google.com");

    String title1 = driver.getTitle();
    System.out.println(title1);


  }

}
