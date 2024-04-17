package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import runner.RunCucumber;
import support.Utils;

import static support.Commands.*;

public class LoginPage extends RunCucumber {

    // elementos
    private String URL = "http://automationpratice.com.br/";
    private By botaoAcessarLogin = By.cssSelector(".right_list_fix > li > a > .fa-user");
    private By campoEmail = By.id("user");
    private By campoSenha = By.id("password");
    private By botaoFazerLogin = By.id("btnLogin");
    private By botaoAcessarCadastro = By.cssSelector(".right_list_fix > li > a > .fa-lock");

    // ações / funções / métodos
    public void acessarAplicao() {
        getDriver(System.getProperty("browser")).get(URL); // para executar no terminal usar -Dbrowser=chrome ou -Dbrowser=firefox na linha de comando.
    }

    public void acessarTelaLogin() {
        clickElement(botaoAcessarLogin);
    }

    public void preencheEmail(String email){
        fillFild(campoEmail, email);
    }

    public void preencherSenha(String senha){
        fillFild(campoSenha, senha);
    }

    public void clicarLogin(){
        clickElement(botaoFazerLogin);
    }

    public void verificaLoginSucesso(){
        validateMessage(By.id("swal2-title"), "Login realizado");
    }

    public void verificaCampoVazio(String message){
        validateMessage(By.className("invalid_input"), message);
    }

    public void acessarTelaCadastro(){
        clickElement(botaoAcessarCadastro);
    }

    public void verificaEmailInvalido(String message) {
        validateMessage(By.cssSelector("span.invalid_input"), message);
    }
}

