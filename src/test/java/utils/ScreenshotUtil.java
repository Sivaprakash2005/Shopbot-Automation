package utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;

public class ScreenshotUtil {

    public static String captureScreenshot(WebDriver driver, String testName) {

        File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        String path=System.getProperty("user.dir")+"/screenshots/"+testName+"_"+timestamp+".png";
        File dest = new File(path);
        try {
            FileUtils.copyFile(src, dest);
            System.out.println("Screenshot Saved: " + path);
        } catch(IOException e) {
            e.printStackTrace();
        }
        return path;
    }
}