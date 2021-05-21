package ensyu;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ex02 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		//raku+にアクセス
		System.setProperty("webdriver.chrome.driver", "./exe/chromedriver");
		WebDriver driver = new ChromeDriver(); 
		driver.get("https://rakuplus.jp/"); 
		Thread.sleep(5000); 
		
		//ログイン
		WebElement id = driver.findElement(By.id("user_login"));
		id.sendKeys("ID");
		WebElement pw = driver.findElement(By.id("user_pass"));
		pw.sendKeys("PW");
		id.submit();
		//pw.submit();
		Thread.sleep(5000);
		
		//スクリーンショット
		File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			Files.copy(file.toPath(), new File("保存先" + file.getName()).toPath());
		}catch(IOException e) {
			e.printStackTrace();
			}
		Thread.sleep(5000);

		driver.quit(); // ブラウザを閉じる。
	}
}
