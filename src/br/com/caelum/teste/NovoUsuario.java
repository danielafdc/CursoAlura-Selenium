package br.com.caelum.teste;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class NovoUsuario {

	WebDriver driver = new FirefoxDriver();
	
	@Before
	public void abrirPagina(){
	driver.get("http://localhost:8080/usuarios");
	
	}
@After
public void fecharJanela(){
	driver.close();
}
@Test
 public void garantirBotaoNovoUsuario(){
	
	WebElement botaonovousuario = driver.findElement(By.linkText("Novo Usuário"));
	botaonovousuario.click();
}

}

