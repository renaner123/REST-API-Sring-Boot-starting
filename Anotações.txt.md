
### Comandos STS4 e dicas

- Ctrl + Shift + f - identar no sts4

- Gerar Jar: Projeto -> Run As -> Maven Build -> Goals = clean package

### Marcações do Spring

@Entity -> entidade, vai gerar/ter tabela no banco de dados dessa classe



### Anotações gerais

https://start.spring.io

jpa -> projeto que ajuda a implementar reposítórios para trabalhar com objeto relacional
h2 -> banco de dados simples para testar

Prefência em importar javax.persistence.*

Anotações lombok:
@Data gera os getters,setter, equals, hashcode e toString

application.properties -> spring.jpa.show-sql=true -> mostrar comandos sql

JPA só remove entidade monitorada(que foi inserida ou recuperada do banco de dados)

Projeto JPA + Maven na mão. Adicionando no pom e META-INF
mexer com banco sem spring boot, somente jpa
https://github.com/devsuperior/aulao006

Xampp para usar Mysql, PHP