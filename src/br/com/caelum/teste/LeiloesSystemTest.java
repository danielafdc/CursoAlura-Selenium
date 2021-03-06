package br.com.caelum.teste;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class LeiloesSystemTest {

	private WebDriver driver;
	private LeiloesPage leiloes;
	

	
	@Before
	public void inicializa(){
		
		System.setProperty("webdriver.chrome.driver","C:/Chromedriver/chromedriver.exe");
		this.driver = new ChromeDriver();
		leiloes = new LeiloesPage(driver);
		
		UsuariosPage usuarios = new UsuariosPage(driver);
		usuarios.visita();
		usuarios.novo().cadastra("Paulo Henrique", "paulo@henrique.com");
	}
	
	@Test
	public void deveCadastrarUmLeilao(){
		
		leiloes.visita();
		NovoLeilaoPage novoLeilao = leiloes.novo();
		novoLeilao.preenche("Geladeira", 123, "Paulo Henrique", true);
		
	assertTrue(leiloes.existe("Geladeira", 123, "Paulo Henrique", true));
		
	}
	

}
