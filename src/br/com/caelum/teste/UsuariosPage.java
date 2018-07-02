package br.com.caelum.teste;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UsuariosPage {

	private WebDriver driver;
	
	public UsuariosPage(WebDriver driver){
		this.driver = driver;
	}

public void visita(){
	driver.get("http://localhost:8080/usuarios");
}

public void limpa(){
	driver.get("http://localhost:8080/apenas-teste/limpa");
}

public NovoUsuarioPage novo(){
	driver.findElement(By.linkText("Novo Usuário")).click();
	return new NovoUsuarioPage(driver);
}

public boolean existeNaListagem(String nome, String email){
	return driver.getPageSource().contains(nome)&&
			driver.getPageSource().contains(email);
}

public void deletarUsuarioNaPosicao(int posicao){
	driver.findElements(By.tagName("button")).get(posicao -1).click();
	
	Alert alert = driver.switchTo().alert();
	alert.accept();
}

public AlteraUsuarioPage altera (int posicao){
	driver.findElements(By.linkText("editar")).get(posicao-1).click();
	return new AlteraUsuarioPage(driver);
}
}
