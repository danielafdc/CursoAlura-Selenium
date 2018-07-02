import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TesteAutomatizadocomchrome {

	public static void main(String[] args){
		
	System.setProperty("webdriver.chrome.driver","C:/Chromedriver/chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
	
	driver.get("http:///www.bing.com.br");
	
		WebElement campoDeTexto = driver.findElement(By.name("q"));
			campoDeTexto.sendKeys("Caelum");
	campoDeTexto.submit();
	}
}
