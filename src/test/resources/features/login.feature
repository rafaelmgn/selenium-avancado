# language: pt

  @login
  Funcionalidade: Login
    Eu como usuário do sistema
    Quero fazer login
    Para fazer uma compra no site

    Contexto: Acessar tela de Login
      Dado que estou na tela de login

    @login-suscesso
    Cenário: Login com sucesso
      #Quando preencho login "teste@teste.com" e senha "123456"
      E clico em Login
      Então vejo mensagem de login com sucesso

    @validar-campos-login
    Esquema do Cenario: Validar <scenario>
      Quando preencho login "<user>" e senha "<password>"
      E clico em Login
      Então vejo a mensagem "<message>" na tela

      Exemplos:
      | scenario          | user             | password  | message          |
      | Email inválido    | testeteste       | 123456    | E-mail inválido. |
      | Senha Inválida    | teste@teste.com  | 123       | Senha inválida.  |
      | Campo Email Vazio |                  | 123456    | E-mail inválido. |
      | Campo Senha Vazio | teste@teste.com  |           | Senha inválida.  |

