package selenium.Selenium_Test;

import java.io.File;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class seleniumTest 
{
    public static void main( String[] args )
    {
        
    	//없어도 되네? 꼭 경로설정이 필요한가?
        /*
        File file = new File(".");
        File rootPath = file.getAbsoluteFile(); //현재 프로젝트 경로

    	System.setProperty("webdriver.chrome.driver", rootPath + "/chromedriver.exe"); 
    	*/   	
    	
        ChromeOptions options = new ChromeOptions();
        
        // headless 안됨!!!
        /*
        options.addArguments("--headless");
        options.addArguments("--window-size=1920x1080");    
        options.addArguments("--disable-gpu");
        options.addArguments("--disable-extensions");
	    */
        
        //Driver SetUp
        WebDriver driver = new ChromeDriver(options);        
        String base_url = "https://youtube.com/results?search_query=김범수+진심";

        try {
            //get page (= 브라우저에서 url을 주소창에 넣은 후 request 한 것과 같다)
            driver.get(base_url);
            List<WebElement> elms = driver.findElements(By.tagName("ytd-video-renderer"));
            
            for(WebElement elm:elms) {
            	System.out.println(elm.findElement(By.tagName("h3")).getText() + " / " + elm.findElement(By.tagName("img")).getAttribute("src"));
            }
        
        } catch (Exception e) {
            
            e.printStackTrace();
        
        } finally {
 
            driver.close();
        }
    } 
}
