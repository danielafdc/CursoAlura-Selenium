/*	O código anterior está difícil de ser entendido. Precisa fazer uma leitura dele... Então, o melhor é simplificar o código.
	Então, uma melhor estrutura será criada abaixo.*/
	

package br.com.caelum.teste;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;


public class UsuariosSystemTest2 {
	
	private ChromeDriver driver;
	private UsuariosPage usuarios;
	
	@Before
		public void inicializa(){
		System.setProperty("webdriver.chrome.driver","C:/Chromedriver/chromedriver.exe");
		this.driver = new ChromeDriver();
		this.usuarios = new UsuariosPage(driver);
		usuarios.limpa();
	}
	
	
	@Test
	public void deveAdicionarUmUsuario(){
		
	usuarios.visita();
	usuarios.novo().cadastra("Daniela Ferreira da Cunha","daniela@terra.com.br");
	usuarios.novo().cadastra("Rafael","rafael@terra.com.br");
	
	assertTrue(usuarios.existeNaListagem("Esse Ferreira da Cunha","daniela@terra.com.br"));
	assertTrue(usuarios.existeNaListagem("Rafael","rafael@terra.com.br"));
	
	//usuarios.deletarUsuarioNaPosicao(3);
	
	//assertFalse(usuarios.existeNaListagem("Rafael","rafael@terra.com.br"));
}
	
	
	@After
	public void fecharJanela(){
		driver.close();
	}
}

