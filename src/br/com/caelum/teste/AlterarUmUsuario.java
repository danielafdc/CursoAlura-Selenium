package br.com.caelum.teste;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlterarUmUsuario {

	private ChromeDriver driver;
	private UsuariosPage usuarios;
	
	@Before
		public void inicializa(){
		System.setProperty("webdriver.chrome.driver","C:/Chromedriver/chromedriver.exe");
		this.driver = new ChromeDriver();
		this.usuarios = new UsuariosPage(driver);
		usuarios.limpa();
		}

	@After
	public void fecharJanela(){
		driver.close();
	}
@Test
public void deveAlterarUmUsuario(){
	
usuarios.visita();
usuarios.novo().cadastra("Ronaldo Luiz de Albuquerque","ronaldo2009@terra.com.br");
usuarios.altera(1).para("Ronaldo Luis de Albuquerque", "ronaldo@uol.com.br");

   assertFalse(usuarios.existeNaListagem("Ronaldo Luiz de Albuquerque", "ronaldo2009@terra.com.br"));
   assertTrue(usuarios.existeNaListagem("Ronaldo Luis de Albuquerque", "ronaldo@uol.com.br"));
}
}