package utility;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

public class Screenshots {

		 public static String TakeScreenShot(WebDriver driver , String refNumber)  {

		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy hh-mm-ss");
		String timeStamp = sdf.format(d);

		   try {
		String path = "./ScreenShots";
		String nameFileName = refNumber+ "_"+timeStamp + ".png";
		String filePathName = path + "/" + nameFileName;

		//to create new folder
		new File(path).mkdirs();

		TakesScreenshot  scrShot = (TakesScreenshot)driver;
		File srcFile = scrShot.getScreenshotAs(OutputType.FILE);

		File destFile  = new File(filePathName);
		Files.copy(srcFile.toPath(), destFile.toPath());

		return filePathName;


		}catch (IOException e) {
		e.printStackTrace();
		return null;
		}


		}
	
		
	
	
}
