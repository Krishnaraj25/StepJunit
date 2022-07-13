package org.steptask;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JunitTask {
	static WebDriver driver;
	static long  Start;
	static String Text;
	static String Text1;
	static File F;
	@BeforeClass
	public static void browserlaunch() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\ASUS\\eclipse-workspace\\StepJunit\\Driver\\chromedriver.exe");
		 driver=new ChromeDriver();
		 driver.navigate().to("http://www.flipkart.com");
	}
	@AfterClass
	public static void browserQuit() throws Throwable {
		Thread.sleep(5000);
		driver.quit();
	}
	@Before
	public void startingTime() {
		Start=System.currentTimeMillis();
	}
	@After
	public void endTime() {
		long end=System.currentTimeMillis();
		System.out.println("Time Taken:"+(end-Start));
	}
	@Test
	public void flip1() {
		WebElement X=driver.findElement(By.xpath("//button[text()='✕']"));
		X.click();
	}
	@Test
	public void flip2() {
		WebElement Search=driver.findElement(By.xpath("//input[@type='text']"));
		Search.sendKeys("Redmi Mobiles",Keys.ENTER);
	}
	@Test
	public void flip3() throws Throwable  {
		Thread.sleep(1000);
		WebElement Mob1=driver.findElement(By.xpath("(//div[@class='_4rR01T'])[1]"));
		Text=Mob1.getText();
		System.out.println(Text);
	}
	@Test
	public void flip4() throws Throwable {
		Thread.sleep(1000);
		WebElement Mob1=driver.findElement(By.xpath("(//div[@class='_4rR01T'])[1]"));
		Mob1.click();
		Thread.sleep(1000);
		WebElement Mob2=driver.findElement(By.xpath("(//div[@class='_4rR01T'])[2]"));
		Mob2.click();
		Thread.sleep(1000);
		WebElement Mob3=driver.findElement(By.xpath("(//div[@class='_4rR01T'])[3]"));
		Mob3.click();
	}
	@Test
	public void flip5() throws Throwable {
		Set<String> WH=driver.getWindowHandles();
		List<String> WH1=new ArrayList<String>(WH);
		for(String Y:WH1) {
		driver.switchTo().window(Y);
		driver.switchTo().window(WH1.get(3));
		}
		WebElement Mob=driver.findElement(By.xpath("//span[@class='B_NuCI']"));
		Text1=Mob.getText();
		System.out.println(Text1);
		F=new File("C:\\Users\\ASUS\\eclipse-workspace\\StepJunit\\src\\test\\resources\\Mobile.xlsx");
		Workbook WB=new XSSFWorkbook();
		Sheet S=WB.createSheet("Mobile");
		for(int i=0;i<1;i++) {
		Row R=S.createRow(i);
		for(int j=0;j<2;j++) {
		Cell C=R.createCell(j);
		if(j==0) {
			C.setCellValue(Text);}
		if(j==1) {
			C.setCellValue(Text1);}
		}}
		FileOutputStream F2=new FileOutputStream(F);
		WB.write(F2);
	}
	@Test
	public void flip6() throws Throwable {
		TakesScreenshot TK=(TakesScreenshot)driver;
		File F1=TK.getScreenshotAs(OutputType.FILE);
		File L= new File("C:\\Users\\ASUS\\eclipse-workspace\\StepJunit\\src\\test\\resources\\MobileSS");
		FileUtils.copyFile(F1,L);
	}
	@Test
	public void flip7() {
		if(Text.equals(Text1)) {
			System.out.println("Pass");
		}else {
			System.out.println("Fail");
		}
	}
}