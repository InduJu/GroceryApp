package utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class ScreenshotCapture {

	public void captureFailureScreenShot(WebDriver driver, String name) throws IOException {
		  //Interface & method for Capture Screenshot 
		  TakesScreenshot scrShot =(TakesScreenshot)driver;   //declaration of "TakesScreenshot" interface
		  File screenShot = scrShot.getScreenshotAs(OutputType.FILE);//screenshot will store in temporary path
		  
		  
		  
//check the above created file exists in run time. One time only the file will create
//File =Java Class		 
		  
		  File f1=new File(System.getProperty("user.dir")+"\\OutputScreenshots");//Generating folder using Java
		  if (!f1.exists()){
			    f1.mkdirs();// mkdir(make directory)--> will create folder using java, no duplicate file would create as it is inside if loop.
			}
		  
		  
		  
//code for capturing current system date and time
		  
		  String timeStamp = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss").format(new Date());//date time capture using java
			 
		  
		  
//outfile format storage : 'name'--> dynamicaly coming		  
		  File finalDestination=new File(System.getProperty("user.dir")+ "\\OutputScreenshots\\" + name + "_" + timeStamp + ".png");
		  FileHandler.copy(screenShot, finalDestination);//copy screenshot from temp path to project folder
		  
	  }

}
