package br.com.caelum.teste;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LanceSytemTestComCriadorFora {
	private LeiloesPage leiloes;
	private ChromeDriver driver;
	
	@Before
    public void criaCenario() {
		System.setProperty("webdriver.chrome.driver","C:/Chromedriver/chromedriver.exe");
			driver = new ChromeDriver();
			leiloes = new LeiloesPage(driver);
			
			driver.get("http://localhost:8080/apenas-teste/limpa");
       
			new CriadorDeCenarios(driver)
            .umUsuario("Paulo Henrique", "paulo@henrique.com")
            .umUsuario("José Eduardo", "jose@eduardo.com")
            .umLeilao("Paulo Henrique", "Geladeira", 100, false);
}
	@Test
	public void deveFazerUmLance(){
			DetalhesDoLeilaoPage lances = leiloes.detalhes(1);
		
	lances.lance("José Eduardo",150);
	
	assertTrue(lances.existeLance("José Eduardo", 150));
	}
	
}


