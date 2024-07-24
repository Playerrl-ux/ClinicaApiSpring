Para que o projeto funcione corretamente você deve ter um banco de dados mysql no seu computador. Vá até application.properties e faça as seguintes alterações:

spring.datasource.url=jdbc:mysql://localhost:3306/(nome do seu banco de dados)
spring.datasource.username=(seu usuário)
spring.datasource.password=(sua senha)

Note que a aplicação roda com o banco de dados local.
