# -REST-API-Sring-Boot-starting
Anotações e informações referentes ao exemplo disponível em https://www.youtube.com/watch?v=aRLoSDOlU3w de como criar uma REST API com Spring Boot.

## Alguns conceitos/libs/frameworks usados

### Lambok
É uma biblioteca java utilizada para "omitir" a configuração de getters, setters, to_string, hash_code, equals, construtor em uma classe. É necessário usar apenas a marcação @Data que a biblioteca define-os. Existem outras marcações que podem ser vistas em [projectlombok](https://projectlombok.org/features/all).

### Hibernate
Framework utilizado para persistência de dados que usa o conceito de mapeamento objeto-relacional (ORM), faz a "ponte" entre o modelo orientado a objetos e o modelo relacional utilizado pela maioria dos gerenciadores de banco de dados. Mais detalhes em [Hibernate](https://docs.jboss.org/hibernate/annotations/3.5/reference/en/html/entity.html#entity-overview).
    
### JPA
Java Persistente API (JPA) é um especificação que padroniza como os fremewokrs ORM devem ser implementados. Ela simplifica a forma que se acessa os dados através de notações. Mais detalhes em [Oracle](https://www.oracle.com/technical-resources/articles/javase/persistenceapi.html).
### sts4

Spring Tool Suite 4 é uma IDE que facilita o uso de Spring de modo geral. O Spring Tool também pode ser utilizado em outras IDE, por exemplo Eclipse, Visual Studio Code e Theia. Mais detalhes em [Spring.io](https://spring.io/tools).
### thymeleaf
Auxilia no desenvolvimento Web usando HTML5 e fornecendo integração com Spring Framework. "O principal objetivo é trazer modelos naturais elegantes para o seu fluxo de trabalho de desenvolvimento HTML que pode ser exibido corretamente em navegadores e também funcionar como protótipos estáticos" ([thymeleaf](https://www.thymeleaf.org)). 

### Vaadin
"É uma plataforma de desenvolvimento de aplicativos web para Java. Ele ajuda você a criar aplicativos da Web confiáveis ​​com excelente UX (User Experience) mais rápido do que antes" ([vaadin](https://vaadin.com)).
## Criando o projeto e configurando as dependências

Para criar o projeto foi utilizado o software Spring Tool Suite 4 (STS4), Para criar o projeto é necessário seguir essas etapas:

1. File -> new -> Spring Starter Project
1. Definir um nome e uma descrição para o projeto. Por padrão o Maven já vai estar selecionado como 'type'
1. Selecionar as dependências iniciais:
    * Spring Boot DevTools
    * Spring Data JPA
    * MySQL Driver
    * Spring Security
    * Thymeleaf
    * Spring Web
    * Lombok
    * Vaadin
1. Aguardar o download/instalação

Caso queira adicionar alguma outra dependência após criar o projeto, pode clicar com o botão direito em cima do projeto e ir em Spring -> Add Starters.

Outra opção é usar o https://start.spring.io para gerar o projeto "esqueleto" inicial.

As dependências instaladas podem ser vistas no arquivo [pom.xml](/pom.xml). Esse arquivo contém os detalhes de configurações necessárias para construir o projeto Maven. Por exemplo, para inserir as depências para uso de Bootstrap, CSS e JQuery, é possível adicionar o seguinte trecho no arquivo pom.xml

```xml
<dependency>
	<groupId>org.webjars</groupId>
	<artifactId>jquery</artifactId>
	<version>3.4.1</version>
</dependency>
<dependency>
	<groupId>org.webjars</groupId>
	<artifactId>bootstrap</artifactId>
	<version>4.3.1</version>
</dependency>
<dependency>
	<groupId>org.webjars</groupId>
	<artifactId>webjars-locator-core</artifactId>
</dependency>
```

Com as depências adicionadas, por se tratar de dependência de página HTML, é necessário inserir os scripts no arquivo HTML desejado.

```html
<link rel="stylesheet" type="text/css" href="/webjars/bootstrap/css/bootstrap.min.css" />
<script type="text/javascript" src="/webjars/jquery/jquery.min.js"></script>
<script type="text/javascript" src="/webjars/bootstrap/js/bootstrap.min.js"></script>
```
## Classes usadas no projeto

[CustomUserDetails](/src/main/java/com/example/demo/CustomUserDetails.java) - Implementa UserDetails. Contém as informações do usuário que pode ser usada pelo Spring Security.

[CustomUserDetailsService](/src/main/java/com/example/demo/CustomUserDetailsService.java) - Implementa UserDetailsService. Serve para acesso ao banco de dados, como um DAO. Procura usuários pelo email.

[PasswordEncoder](/src/main/java/com/example/demo/PasswordEncoder.java) - Apenas para gerar uma senha usando BCryptPasswordEncoder para teste.

[SpringJavaApiApplication](/src/main/java/com/example/demo/SpringjavaApiApplication.java) - Classe que é executada pelo projeto (main).

[WebSecurityConfig](/src/main/java/com/example/demo/WebSecurityConfig.java) - Implementa WebSecurityConfigurerAdapter. Responsável por controlar a autenticação do usuário, permitindo login e logout.

[UserController](/src/main/java/com/example/demo/controller/UserController.java) - Possui as rotas que podem ser acessadas pelo programa.

[User](/src/main/java/com/example/demo/model/User.java) - Contém os dados do usuário que serão usados para criar a tabela no banco de dados.

[UserRepository](/src/main/java/com/example/demo/repository/UserRepository.java) - Um componente/repositório que vai interagir com o banco de dados para acessar a tabela User.

[UserRepositoryTest](/src/test/java/com/example/demo/UserRepositoryTest.java) - Testa se o Repository está funcionando, injeta (testa) informação no banco de dados. 

## Marcações usadas no exemplo

importados de javax.persistence:

* @Entity -> Especifica que a classe é uma entidade

* @Id -> Usado para informar que o atributo será a chave primária da entidade em questão

* @GeneratedValue  ->
    Estratégia que pode ser usada para geração do Id, no exemplo foi usado o IDENTITY que serve para auto incrementar o id

* @Column  ->
Não precisa marcação, a entity mapeia todos os atributos, a não ser que queria por alguma restrição na coluna, por exemplo, nullable, unique, length

importado de lombok:
* @Data  ->
Gera getters e setters para todos os campos, um método toString útil e implementações hashCode e equals e um método construtor

importados de org.springframework.context.annotation:
* @Configuration  ->
Indica que uma classe declara um ou mais métodos @Bean e pode ser processado pelo contêiner Spring

* @Bean  ->
"Indica que um método produz um bean a ser gerenciado pelo contêiner Spring. Serve para exportar uma classe para o Spring, para que ele consiga carregar essa classe e fazer injeção de dependência dela em outras classes"

importado de org.springframework.security.config.annotation.web.configuration:
* @EnableWebSecurity  ->
Anotação necessária em um @Configuration para ter a configuração Spring Security definida em qualquer WebSecurityConfigurer

importado de org.springframework.beans.factory.annotation:
* @Autowired  ->
"Marca um construtor, campo, método setter ou método de configuração para ser conectado automaticamente pelos recursos de injeção de dependência do Spring" 

importado de java.lang:
* @Override  ->
"Indica que uma declaração de método destina-se a substituir uma declaração de método em um supertipo"

importado de org.springframework.boot.autoconfigure:
* @SpringBootApplication  ->
"Indica uma classe de configuração que declara um ou mais métodos @Bean e também aciona a configuração automática e a varredura de componentes"

importado de org.springframework.stereotype:
* @Repository ->	
indicar que é um componente/repositório que vai interagir com o banco de dados(DAO) Data Access Object

* @Controller ->
Indica que a classe vai ser um "controlador da web", vai ter as rotas que um cliente web pode acessar.

importado de org.springframework.data.jpa.repository:
* @Query ->
Configura uma query que vai ser usada para acessar o banco de dados(select,update ...)

importade org.springframework.web.bind.annotation:
* @GetMapping ->
Informa que o atributo/método vai suportar um método de requisição HTTP do tipo GET.

* @PostMapping ->
Informa que o atributo/método vai suportar um método de requisição HTTP do tipo POST.

Importado de org.springframework.boot.test.autoconfigure.orm.jpa
* @DataJpaTest -> 
Definir que será usado somente componentes do JPA para testes.

Importado de org.springframework.boot.test.autoconfigure.jdbc
* @AutoConfigureTestDatabase
Usado para definir que a classe usará o banco de dados para teste ao invés de auto configuração.

Importado de org.springframework.test.annotation
* @Rollback
Indica se uma transação gerenciada por teste deve ser revertida após a conclusão do método de teste.

Importado de org.junit.jupiter.api.
* @Test
  Usado para informar que é um método de teste.

## Conexão com o banco de dados

Para criar a conexão com o banco de dados é necessário configurar o arquivo [application.properties](src/main/resources/application.properties) conforme baixo

```java
spring.datasource.url=jdbc:mysql://localhost:3306/user
spring.datasource.username=renan
spring.jpa.hibernate.ddl-auto=create
spring.jpa.properties.hibernate.format_sql=true
```

Após rodar a aplicação pela primeira vez, recomenda-se alterar o ddl-auto para none, pois a tabela já estará criada no banco.

```java
spring.jpa.hibernate.ddl-auto=none
```

Para execução desse projeto, é necessário ter um banco de dados configurado com um schema chamado user.

## Gerar um arquivo jar

É possível gerar um arquivo jar usando o Spring Boot Tools indo em Projeto -> Run As -> Maven Build -> Goals = clean package ou pelo terminal, caso tenha o maven instalado, basta ir na raiz do projeto e usar um dos comandos abaixo.

```shell
mvn clean package
```

O arquivo .jar do projeto é gerado dentro da pasta [target](/target/).

ou
```shell
mvn install
```

Para o package funcionar é necessário ter a seguinte linha de comando nas properties do [pom.xml](main/src/../../pom.xml)

```java
<packaging>jar</packaging>
```

Para conseguir executar o arquivo .jar pelo terminal deve-se usar:

```shell
java -jar arquivo.jar
```

Para executar localmente, é necessário ter instalado no sevidor:

* Java 11 ou superior;
* Maven 3.5 ou maior;
* Configuração das variáveis de ambientes e
* Apache Tomcat 9.

Para verificar as versões instaladas, assim como fazer a instalação caso necessário, pode-se usar o guia disponível em: [https://docs.cronapp.io](https://docs.cronapp.io/pages/viewpage.action?pageId=145490718#:~:text=Versão%20do%20Maven&text=Caso%20exiba%20uma%20versão%20diferente%20ou%20a%20mensagem%20"%27mvn%27configurar%20as%20variáveis%20de%20ambiente) ou configurar através de um [contêiner Docker](https://docs.cronapp.io/display/CRON2/Executar+projeto+localmente+via+Docker).

## Referências:

https://www.codejava.net/frameworks/spring-boot/user-registration-and-login-tutorial

https://www.youtube.com/watch?v=aRLoSDOlU3w

[https://docs.cronapp.io](https://docs.cronapp.io/pages/viewpage.action?pageId=145490718#:~:text=Versão%20do%20Maven&text=Caso%20exiba%20uma%20versão%20diferente%20ou%20a%20mensagem%20"%27mvn%27configurar%20as%20variáveis%20de%20ambiente)

https://www.devmedia.com.br/guia/hibernate/38312#:~:text=Hibernate%20é%20o%20framework%20para,a%20criação%20da%20especificação%20JPA

https://docs.jboss.org/hibernate/annotations/3.5/reference/en/html/entity.html

https://projectlombok.org

https://www.oracle.com/java/technologies/persistence-jsp.html

https://spring.io/tools

https://www.thymeleaf.org

https://vaadin.com

https://docs.cronapp.io/display/CRON2/Executar+projeto+localmente+via+Docker