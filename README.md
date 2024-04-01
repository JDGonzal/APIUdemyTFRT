# Curso de : Automation Tester Avanzado: REST Assured, Cucumber y Groovy
https://udemy.com/course/api-test-automation-los-dos-frameworks-esenciales-a-fondo/
# Section 1: Introducción
## Paso 1. Introducción
Introducción

## Paso 2. ¿Qué es una API?
Es una interfase, los usuarios son herramientas q requieren hacer pedidos.
es hecha para programas no para seres humanos.

## Paso 3. ¿Qué es un request?
Es un pedido hecho a un servidor, que estamos esperando como respuesta.

## Paso 4. ¿Qué es un Response?
Es la respuesta recibida del servidor.

## Paso 5. ¿Que es un Endpoint?
Es un sitio llamado URI (Universal Recoruce Identifier), algo parecido a a una URL.
Debemos verificar si el sitio existe, y recibimos un 200 (ok) o un error (400 a 509).
Dependiendo de lo pedido vamos a secciones o subsecciones.

## Paso 6. ¿Qué es API Testing y por qué es tan importante?
Rara vez cambia el API, es mas proclive para hacer pruebas mas estables.
![Piramide de Test](images/section01-step-06-PiramidTest.png)

## Paso 7. El viejo debate: Automation de UI vs. API ¿Cuál hacer y por qué?
Verificar que el botón funciona es con UI.
Si necesito que el usuario está bloqueado sería por API.

# Section 2: Presentando las herramientas que vamos a usar y su configuración.
## Paso 8. Presentación del VSCode y creación de directorios y proyecto
>[!NOTE]  
>**Requerimientos**
>* [Visual Studio Code](https://code.visualstudio.com/download) 
>* Dentro del VSC las siguiente extensiones:
>
>   * Java Extension Pack, Microsoft
>   * Debugger for Java, Microsoft
>   * code-groovy, Marlon Franca
>   * Cucumber, Cucumber 
>   * Cucumber (Huerking), Alexander Krechik
>   * Gradle for Java, Microsoft
>   * Gradle Laguage Support, Naco Siren

1. Abriendo el VSC totalmente en blanco, a la izquierda al medio
 aparece un botón llamado `Create Java Project`, allí le damos
  click.
2. Seleccionamos en la parte superior al centro, la opción de `Gradle`.
3. Buscamos la ruta donde lo vamos a crear (En mi caso tengo una carpeta 
de "E:\Development\tutorials\java\cucumber\".
4. Crear una carpeta allí como el nombre del proyecto "APIUdemy".
5. Seleccionamos el `DSL` que es `Groovy`.
6. El nombre del proyecto será `APIUdemy`.
7. Sacamos de la carpeta "app" el directorio "src" y el archivo
 **build.gradle** a la raíz del proyecto.
8. La carpeta "app" se puede eliminar. 
9. Dentro de "src/test" verificamos que estén las carpetas:
* "java"
* "resources"
## Paso 9. Agregando las dependencias clave: Cucumber y Rest Assured.
1. Modificamos el **build.gradle**
```gradle
plugins {
    id 'java'
}

group 'TheFreeRangeTester'
version '1.0.SNAPSHOT'

sourceCompatibility = 1.11

repositories {
    // Use Maven Central for resolving dependencies.
    mavenCentral()
}

dependencies {

}
```
2. Añadimos estas dependencias:
* [REST Assured](https://mvnrepository.com/artifact/io.rest-assured/rest-assured).
* [Cucumber JVM: Java](https://mvnrepository.com/artifact/io.cucumber/cucumber-java).
3. Borramos la carpeta "main", dentro de "scr"
4. Borramos en el archivo **settings.gradle**, la linea de
`include('app')`.
5. Borramos la carpeta "apiudemy" dentro de "src/test/java".
<a name="Tip-Clean-Workspace"></a>

>[!TIP]  
> Muchas veces añadir dependencias requiere que se ejecute la limpieza
> del ambiente de dos maneras:
> * Presionar las teclas [Ctrl][Shift][P], y seleccionar
> `Java: Clean Java Language Server Workspace`, o
> * En el Menú inferior izquierdo, seleccionar `JAVA PROJECT`, 
>luego los puntos suspensivos y ahí está `Clean Workspace`.

## Paso 10. Rest Assured: El estandarte para API testing en Java.
>[!TIP]  
> Ante un mensaje de que si se hace build, le activé el botón de "Always"
>(Siempre) y el creó un archivo en ".vscode" llamado **settings.json**
> con estas líneas:
>```json
>{
>  "java.configuration.updateBuildConfiguration": "automatic"
>}
>```

## Paso 11. Cucumber: Haciendo fácil de entender lo complejo de las APIs.
> [!IMPORTANT]  
> Las versiones de "Cucumber JVM: Java" y "Cucumber JVM: JUnit 4",
> **TIENEN** que ser iguales.
1. Agrego otra dependencia de [Cucumber JVM: JUnit 4](https://mvnrepository.com/artifact/io.cucumber/cucumber-junit) 
ene el archivo **build.gradle**.
2. Se requiere para los `ExtentReports` añadir en **build.gradle** otra
dependencia [ExtentReports Cucumber7 Adapter](https://mvnrepository.com/artifact/tech.grasshopper/extentreports-cucumber7-adapter).
3. Para el manejo de `json` agregamos otra dependencia en **build.gradle**
[JSON In Java](https://mvnrepository.com/artifact/org.json/json)

>[!TIP]  
> [Pasos para Limpiar ambiente luego de añadir dependencias](#Tip-Clean-Workspace).

4. Verificar que se tengan estas rutas o de ser necesario crearlas:
* "src/test/java"
* "src/test/resources/features"
5. Crear el archivo **APITest.feature** dentro de 
"src/test/resources/features", con el siguiente texto:
```feature
Feature: Request example for Udemy

Scenario: Test GET to endpoint.
  Given I send a GET request to the endpoint
  Then I get a list of then users
```

## Paso 12. Clase Runner: Lo necesario para ejecutar nuestros scenarios de Cucumber.
1. Agrego mas dependencias [Groovy All](https://mvnrepository.com/artifact/org.codehaus.groovy/groovy-all).
2. Otra dependencia para los repoerrtes [JUnit-bom 5 (Bill of Materials)](https://mvnrepository.com/artifact/org.junit/junit-bom).
3. Otra dependencia mas [JUnit Jupiter (Aggregator)](https://mvnrepository.com/artifact/org.junit.jupiter/junit-jupiter).
4. Crear dos carpetas mas:
* "src/test/java/runner".
* "src/test/java/steps".
5. Creamos el archivo **Runner.java** en "src/test/java/runner", con lo 
básico:
```java
package runner;

public class Runner {
  
}
```
>[!IMPORTANT]  
> Las clase **Runner.java**, es la encargada de ejecutar los escenarios o
> los archivos ***.feature**, el la q se encargada de unir las definiciones 
>de los **steps** con los **feature**.

6. Colocamos un `@RunWith` en **Runner.java**, con la herramienta con que
se va a realizar la ejecuciones `(Cucumber.class)` (ojo que no lleva 
punto y coma `;`), por ende se debe importar: 
`import io.cucumber.junit.Cucumber;` e `import org.junit.runner.RunWith;`.
7. Ponemos las `@CucumberOptions` y anexamos una lista de valores:
```java
@CucumberOptions(features = "src/test/resources/features",
    glue = "steps")
```
Así me debe aparecer la clase **Runner.java** con un triángulo o círculo
en la columna izquierda del código (En la imagen es la línea 12):  
![Runner.java](images/section02-step_12-Runner_java.png)

## Paso 13. Step Definitions en Cucumber: Cómo implementar la lógica.
1. Crear un archivo **APISteps.java** en "src/test/java/steps".
2. Verificamos los pasos y se corrigen de ser necesario en 
**APITest.feature**:
```feature
Feature: Request example for Udemy

Scenario: Test GET to endpoint.
  Given I send a GET request to the endpoint
  Then I get a list with 10 users
```
3. Tomamos del **APITest.feature**, los pasos: `Given` y `Then`, para copiarlos en  **APISteps.java** y les hacemos unos ajustes:
```java
package steps;

public class APISteps {

  @Given ("I send a GET request to the endpoint")
  @Then ("I get a list with 10 users")
  
}
```
4. Colocamos métodos debajo de cada recien `@Given` y `@Then`, mas
las importaciones faltantes:
```java
package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class APISteps {

  @Given ("I send a GET request to the endpoint")
  public void sendGETRequest(){

  }
  @Then ("I get a list with 10 users")
  public void validateListOfUsers(){
    
  }
  
}
```
5. Mejoramos la importación con este: `import io.cucumber.java.en.*;`, 
Los anteriores los podemos borrar o comentar.
6. Los pasos q copiamos de **APITest.feature**, los mejoramos en 
**APISteps.java**, con el _caret_(`^`) y el _signo pesos_(`$`). 
7. el paso del `@Then`, le cambiamos el valor _fijo_ de `10`, por una
expresión regular, y por ende el método debe requerir un argumento:
```java
  @Then("^I get a list with (\\d+) users$")
  public void validateListOfUsers(int expectedUserSize){
    
  }
```
>[!CAUTION]  
> Debo corregir el **build.gradle** en la zona de `dependencies`:
>```gradle
>dependencies {
>    // https://mvnrepository.com/artifact/io.rest-assured/rest-assured
>    testImplementation group: 'io.rest-assured', name: 'rest-assured', version: '5.4.0'
>    // Se requiere una versión "Hermana" de junit igual q la version de cucumber
>    // https://mvnrepository.com/artifact/io.cucumber/cucumber-java
>    implementation group: 'io.cucumber', name: 'cucumber-java', version: '7.16.1'
>    // https://mvnrepository.com/artifact/io.cucumber/cucumber-junit
>    testImplementation group: 'io.cucumber', name: 'cucumber-junit', version: '7.16.1'
>    // https://mvnrepository.com/artifact/tech.grasshopper/extentreports-cucumber7-adapter
>    implementation group: 'tech.grasshopper', name: 'extentreports-cucumber7-adapter', version: '1.14.0'
>    // https://mvnrepository.com/artifact/org.json/json
>    implementation group: 'org.json', name: 'json', version: '20240303'
>    // https://mvnrepository.com/artifact/org.codehaus.groovy/groovy-all
>
>    // https://mvnrepository.com/artifact/org.junit/junit-bom
>    testImplementation (platform('org.junit:junit-bom:5.10.2'))
>    // https://mvnrepository.com/artifact/org.junit.jupiter/junit-jupiter
>    testImplementation ('org.junit.jupiter:junit-jupiter')
>}
>```
> 
> [Pasos para Limpiar ambiente luego de añadir dependencias](#Tip-Clean-Workspace).

8. Desde el **Runner.java**, presionamos el triángulo o círculo en la
zona izquierda del código y esperamos el resultado, algo similar a esto:  
![TEST RESULTS-13](images/section02-step_13-TestResults.png)

# Section 3: Tipos de request y respuestas.
## Paso 14. Rest Assured: El GET request y sus componentes.

>![NOTE]  
> Aprendiendo la sintaxis de `RestAssured`, importando 
>`import static io.restassured.RestAssured.given;` y usándolo. La 
>Sintaxis es muy similar a la de Cucumber usando el lenguaje 
>[_Gherkin_](https://profile.es/blog/que-es-gherkin/). 
> 
><a name="Thunder-Client-Install"></a>
>En el Ejercicio se recominda instalar la extensión para VSC, llamada
>`Thunder Client` de `thunderclient.com`.
> 1. Luego de instalada, click en el ícono a la izquierda 
>![ThunderIcon](images/section03-step_14-ThunderIcon.png).
>2. Presionar el botón "New Request".
>3. Por defecto el tipo  es `GET`, dejarlo así.
>4. Colocar esto en la URI: `https://api.github.com/users/jdgonzal/repos`.
>5. Presionar el botón `Send`.
>6. Revisar el resultado obtenido.

## Paso 15. Rest Assured: El POST request y sus componentes.

## Paso 16. Rest Assured: El PUT request y sus componentes.

## Paso 17. Rest Assured: El DELETE request y sus componentes.

## Paso 18. Rest Assured: La response y sus componentes.
>[!NOTE]  
> Ejemplo de un JSON q mas adelante podremos estar utilizando:
>```json
>[
>  {
>    "empleado": {
>      "nombre": "Juan",
>      "appelido": "Lopez",
>      "web": "misitio.com"
>    }
>  },
>  {
>    "empleado": {
>      "nombre": "Carlos",
>      "appelido": "Gardel",
>      "web": "miotrositio.com"
>    }
>  }
>]
>```

## Paso 19. Requests REST y SOAP: ¿Cómo se hacen?
>[!TIP]  
> Este es un ejemplo de un request del tipo `SOAP`, usando 
>`RestAssured`:
>```java
>  public void SOAPRequest(){
>    String xmlEnvelope = "<soap12: Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" "
>    "xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">"
>    "<soap12:Body>" +
>    "<Define xmlns=\"http://services.aonaware.com/webservices/\">" +
>    "<word></word>" +
>    "</Define>" +
>    "</soap12:Body>" + 
>    "</soap12:Envelope>";
>
>      given()
>      .header("SOAPAction", "Define")
>      .baseUri("https://api.blogEjemplo.com")
>      .when()
>      .body(xmlEnvelope)
>      .post("/endpoint");
>    }
>```

## Paso 20. Autenticación Básica en Rest Assured: ¿Cómo se hace?
>[!NOTE]  
>Ejemplo de autenticación básica:
>```java
>public void basicAuth (String userName, String password) {
>  given()
>  .auth().basic(userName, password)
>  .when()
>  .get("AUTH_ENDPOΙΝΤ")
>  .then()
>  .assertThat().statusCode(200);
>}
>```

## Paso 21. Autenticación via formulario en Rest Assured: ¿Cómo se hace?
>[!NOTE]  
>Ejemplo de autenticación por formulario:
>```java
>public void formAuth (String userName, String password) {
>  given()
>  .auth().form(userName, password)
>  .when()
>  .get("SERVICE")
>  .then()
>  .assertThat().statusCode(200);
>}
>```

## Paso 22. Autenticación OAuth en Rest Assured: ¿Cómo obtener el Token para autenticar?
>[!NOTE]  
>Obtenemos el permiso de otro servicio q nos va a autenticar para 
>alcanzar la solicitud del request.
>1. Obtener el código del servicio original, para conseguir el 
>`token`.
>2. Obtener el `token`, intercambiando el código q conseguimos.
>3. Acceder al recurso protegido, con nuestro `token`.
>
>Ejemplo de código:
>```java
>public static String clientId = "";
>public static String redirectUri = "";
>public static String scope = "";
>public static String userName = "";
>public static String password = "";
>public static String grantType = "";
>
>public static String encode(String str1, String str2){
>  return new String (Base64getEncoder().encode((str1 + ":" + str2).getBytes()));
>}
>
>// 1. Obtener el código del servicio original, para conseguir el `token`.
>public static Response getCode(){
>  String authorization = encode(userName, password);
>
> return given()
>    .header("authorization", "Basic" + authorization)
>    .contentType(ContenType.URLENC)
>    .formParam("response_type", "code")
>    .queryParam("client_id", clientId)
>    .queryParam("redicrect_uri", redicrectUri)
>    .queryParam("scope", scope)
>    .post("/oauth/authorize")
>    .then()
>    .statusCode(200)
>    .extract()
>    .response();
>}
>
>// 2. Obtener el `token`, intercambiando el código q conseguimos.
>public static String parseForOAuthCode(Response response){
>  return response.jsonPath().getStringh("code")
>}
>
>// 3. Acceder al recurso protegido, con nuestro `token`.
>public static Response getToken(String authCode){
>  String authorization = encode(userNAme, password);
>
>  return given()
>    .header("authorization", "Basic" + authorization)
>    .contentType(ContenType.URLENC)
>    .formParam("response_type", authCode)
>//    .queryParam("client_id", clientId)
>    .queryParam("redicrect_uri", redicrectUri)
>    .queryParam("grant_type", grantType)
>    .post("/oauth/token")
>    .then()
>    .statusCode(200)
>    .extract()
>    .response();
>}
>
>public static String parseForToken(Response loginResponse){
>  return loginResponse.jsonPath().getString("access_token");
>}
>
>```

## Paso 23. Autenticación OAuth: Usando el Token y ahondando en lo que hicimos.
>[!NOTE]  
> Creamos otra función o método mas:
>```java
>// Otra variable mas arriba
>public static String accessToken = "";
>
>public void getFinalService(){
>  given().auth()
>  .oauth2(accessToken)
>  .when()
>  .get("/service")
>  .then()
>  .statusCode(200);
>}
>```
> Una explicación mas detallada:
>* **Response Type**: Es el código de autorización esperado.  
>* **Grant Type**: La manera en q la app esta obteneindo el `token`.
>* **Redirect Uri**: la nueva ruta q nos van a direccionar. Pero acá 
> mas q la ruta es el conseguir el dato a trabajar.
>* El Token se puede pasar como un _Header_, como el siguiente ejemplo:
>```java
>public void getFinalService(){
>  given().auth()
>  .header("Authorization", "Bearer " + accessToken)
>  .when()
>  .get("/service")
>  .then()
>  .statusCode(200);
>}
>```

## Paso 24. Thunder Client: La extensión definitiva para explorar APIs en VSCode.
>[!NOTE]  
> Opciones para entender la extensión:
>* [Thunder Client - Postman dentro de Visual Studio Code](https://www.youtube.com/watch?v=HZx5X3s_Jl4).
>* [Que Es, Como Funciona Thunder Client](https://www.youtube.com/watch?v=Ad14nNSENz4).
>
>[Pasos para la instalación de Thunder Client](#Thunder-Client-Install)

# Section 4: Step Definitions y Rest Assured.

## Paso 25. Definiendo los steps creados.
1. Cambió del texto en **APITest.feature** de 
`Then I get a list with 10 users` a `Then I get a 200 status code`
2. debo cambiar ese mismo texto en **APISteps.java**, dejando algo así:
`@Then("^I get a (\\d+) status code$")`.
3. Definimos una variable `request` de tipo `RequestSpecification`,
por ende importamos `import io.restassured.specification.RequestSpecification;`.
4. Importamos de manera especial lo de `RestAssured`, empezando con el 
`given`, así: `import static io.restassured.RestAssured.given;`.
4. La variable `request`, le cargamos el valor del `given` e importamos
lo faltante `import io.restassured.http.ContentType`:
```java
  @Given("^I send a GET request to the endpoint$")
  public void sendGETRequest() {
    request = given()
              .baseUri("https://api.github.com")
              .contentType(ContentType.JSON);
  }
```
5. Añadimos la variable `response` de tipo `Response` e importamos
`import io.restassured.response.Response;`.
```java
  @Then("^I get a (\\d+) status code$")
  public void validateListOfUsers(int expectedStatusCode) {
    response = request.when()
              .get("/users/jdgonzal/repos");  // Acá va el endpoint
   
    json = response.then().statusCode(expectedStatusCode);
  }
```
6. Definimos la variable `json` de tipo `ValidatableResponse`, e
importamos `import io.restassured.response.ValidatableResponse;`.
7. Ajustamos el **Runer.java** en la parte de `@CucumberOptions`, así:
```java
@CucumberOptions(features = "src/test/resources/features",
    glue = "steps",
    // plugin ={"pretty",
    //   "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
    //   "timeline:test-output-thread/"},
    tags = "@API"
)
```
8. Podemos correr desde **Runner.java** y vemos el resultado, sin errores.
9. Provoquemos un error cambiando en **APITest.feature** el `200` por el 
`400` y volvemos a correr desde **Runner.java**.
