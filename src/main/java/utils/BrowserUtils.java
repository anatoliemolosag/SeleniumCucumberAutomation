package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.io.IOException;
import java.util.Set;

public class BrowserUtils {

    public static void selectBy(WebElement element, String value, String methodName) {
        Select select = new Select(element);

        switch (methodName) {
            case "text":
                select.selectByVisibleText(value);
                break;
            case "value":
                select.selectByValue(value);
                break;
            case "index":
                select.selectByIndex(Integer.parseInt(value));
                break;
            default:
                System.out.println("Method name is not available. Use text, value or index for the method name");
        }
    }

    public static String getText(WebElement element) {
        return element.getText().trim();
    }

    public static String getTitleWithJS(WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        return js.executeScript("return document.title").toString();
    }

    public static void clickWithJS(WebDriver driver, WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click()", element);
    }

    public static void scrollWithJS(WebDriver driver, WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true)", element);
    }

    public static void ScrollWithXAndYCord(WebDriver driver, WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Point location = element.getLocation();
        int xCord = location.getX();
        int yCord = location.getY();
        js.executeScript("window.scrollTo(" + xCord + "," + yCord + ")");
    }

    //in real work this will help you a lot once you test different tabs or windows.
    public static void switchByTitle(WebDriver driver, String title) {
        Set<String> allPages = driver.getWindowHandles();
        for (String id : allPages) {//internet-->new Window
            driver.switchTo().window(id);
            if (driver.getTitle().contains(title)) {
                break;
            }
        }
    }

    public static void switchByID(WebDriver driver, String mainID) {
        Set<String> allPagesID = driver.getWindowHandles();
        for (String id : allPagesID) {
            System.out.println(id);
            if (!id.equals(mainID)) {
                driver.switchTo().window(id);
            }
        }
    }

    public static void getScreenshot(WebDriver driver, String packageName) {

        File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String location = System.getProperty("/src/java/screenshot/") + packageName + "/";

        try {
            FileUtils.copyFile(file, new File(location + System.currentTimeMillis()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        //System.currentTimeMillis will make the data unique all the time.
    }
}
