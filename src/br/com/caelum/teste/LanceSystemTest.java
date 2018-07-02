package br.com.caelum.teste;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;

public class LanceSystemTest {
	private ChromeDriver driver;
	private LeiloesPage leiloes;

	@Before
	public void inicializa(){
		System.setProperty("webdriver.chrome.driver","C:/Chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		leiloes = new LeiloesPage(driver);
		
		driver.get("http://localhost:8080/apenas-teste/limpa");
		
		UsuariosPage usuarios = new UsuariosPage(driver);
		usuarios.visita();
		usuarios.novo().cadastra("Paulo Henrique", "paulo@henrique.com");
		usuarios.novo().cadastra("José Eduardo", "jose@eduardo.com");
		
		LeiloesPage leiloes = new LeiloesPage(driver);
		leiloes.visita();
		leiloes.novo().preenche("Geladeira", 100, "Paulo Henrique", false);
			}
	@Test
	public void deveFazerUmLance(){
		DetalhesDoLeilaoPage lances = leiloes.detalhes(1);
		
	lances.lance("José Eduardo",150);
	
	assertTrue(lances.existeLance("José Eduardo", 150));
	}
}
