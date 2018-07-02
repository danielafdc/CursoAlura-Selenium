import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TesteAutomatizado {

	public static void main(String[] args){
		
	//esse firefoxdriver é uma classe. Isso manda abrir o browser. Representa o driver do Firefox
	//O Webdriver é uma abstração que representa todos os browsers do selenium
		
		
	WebDriver driver = new FirefoxDriver();
	
	//get é um método. Uso para entrar no site
	driver.get("http:///www.google.com.br");
	
		WebElement campoDeTexto = driver.findElement(By.name("q"));
			campoDeTexto.sendKeys("Caelum");
	campoDeTexto.submit();
	}
}
