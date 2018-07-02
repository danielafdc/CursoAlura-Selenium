package br.com.caelum.teste;

import org.openqa.selenium.WebDriver;

public class URLDaAplicacao {

	private WebDriver driver;
	
	public void visita() {
		  driver.get(new URLDaAplicacao().getUrlBase() + "/usuarios");
		  // antigo: driver.get("http://localhost:8080/usuarios");
		}
}
