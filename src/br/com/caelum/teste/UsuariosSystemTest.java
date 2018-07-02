package br.com.caelum.teste;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;

public class UsuariosSystemTest {
	
	
	WebDriver driver = new FirefoxDriver();
	@Before
	
	public void abrirPagina(){
		driver.get("http://localhost:8080/usuarios/new");
	}
	
	@After
	public void fecharJanela(){
		driver.close();
	}
@Test
	public void deveAdicionarUmUsuario(){
		
		WebElement camponome = driver.findElement(By.name("usuario.nome"));
		camponome.sendKeys("Adriano Xavier");
		
		WebElement campoemail = driver.findElement(By.name("usuario.email"));
		campoemail.sendKeys("axavier@empresa.com.br");
		
		WebElement botaoSalvar = driver.findElement(By.id("btnSalvar"));
		botaoSalvar.click();
		
		//agora preciso garantir que o meu usuário apareça na listagem
		//e que meu teste me retorne que deu tudo certo
		//para isso eu uso o Junit. É um framework de teste que avisará se o teste passou
		//http://www.devmedia.com.br/testes-de-unidade-com-junit/4637
		
		boolean achounome = driver.getPageSource().contains("Adriano Xavier");
		boolean achouemail = driver.getPageSource().contains("axavier@empresa.com.br"); //devolve um booleano//devolve um booleano
	
		
		assertTrue(achounome);
		assertTrue(achouemail);
}
	
	@Test
	public void usuarioEmBranco(){
		WebElement campoemail = driver.findElement(By.name("usuario.email"));
		campoemail.sendKeys ("nomeemail@email.com.br");
		WebElement botaoSalvar = driver.findElement(By.id("btnSalvar"));
		botaoSalvar.click();
		
		boolean nomevazio = driver.getPageSource().contains("Nome obrigatorio");
		assertTrue(nomevazio);
				
	}
	
	@Test
	public void usuarioeEmailEmBranco(){
		WebElement botaoSalvar = driver.findElement(By.id("btnSalvar"));
		botaoSalvar.click();
		
		boolean nomevazio = driver.getPageSource().contains("Nome obrigatorio");
		boolean emailvazio = driver.getPageSource().contains("E-mail obrigatorio");
		
		assertTrue(nomevazio);
		assertTrue(emailvazio);
	}

}

