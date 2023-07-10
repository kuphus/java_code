import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class exercise_2 {

    public static void main(String[] args) {
        // declaration and instantiation of objects/variables

        WebDriver driver = new FirefoxDriver();


        String baseUrl = "http://demo.guru99.com/test/newtours/";
        String expectedTitle = "Welcome: Mercury Tours";
        String actualTitle = "";


        // launch Fire fox and direct it to the Base URL
        driver.get(baseUrl);


        // get the actual value of the title
        actualTitle = driver.getTitle();


        /*
         * compare the actual title of the page with the expected one and print
         * the result as "Passed" or "Failed"
         */
        if (actualTitle.contentEquals(expectedTitle)){
            System.out.println("Test Passed!");
        } else {
            System.out.println("Test Failed");
        }

        driver.findElement(By.cssSelector("p")).click();

        //close Fire fox
        //driver.close();


    }

}