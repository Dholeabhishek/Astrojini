package utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;


public class Screenshot {
	
	 public static String getScreenshot(WebDriver driver ,String testName) throws IOException {
	        TakesScreenshot screenshot = (TakesScreenshot) driver;
	        File source = screenshot.getScreenshotAs(OutputType.FILE);
	        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());

	        String filename = testName + "_" + timestamp + ".png";
	        
	        // Use cross-platform path
	        String screenshotDir = Paths.get(System.getProperty("user.dir"), "target", "screenshots").toString();
	        File dir = new File(screenshotDir);
	        if (!dir.exists()) {
	            dir.mkdirs();
	        }
	        
	        File destination = new File(screenshotDir, filename);
			FileUtils.copyFile(source, destination);
			return destination.getAbsolutePath();
	    }
}
