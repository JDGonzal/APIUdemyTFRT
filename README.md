# Curso de : Automation Tester Avanzado: REST Assured, Cucumber y Groovy
https://udemy.com/course/api-test-automation-los-dos-frameworks-esenciales-a-fondo/
# Section 1: Introducción
## Paso 1
Introducción

## Paso 2
### ¿Qué es una API?
Es una interfase, los usuarios son herramientas q requieren hacer pedidos.
es hecha para programas no para seres humanos.

## Paso 3
### ¿Qué es un request?
Es un pedido hecho a un servidor, que estamos esperando como respuesta.

## Paso 4
### ¿Qué es un Response?
Es la respuesta recibida del servidor.

## Paso 5
### ¿Que es un Endpoint?
Es un sitio llamado URI (Universal Recoruce Identifier), algo parecido a auna URL.
Debemos verificar si el sitio existe, y rcibimos un 200 (ok) o un error (400 a 509).
Dependiendo de lo pedido vamos a secciones o subsecciones.

## Paso 6
### ¿Qué es API Testing y por qué es tan importante?
Rara vez cambia el API, es mas proclive para hacer pruebas mas estables.
![Piramide de Test](images/section01-step-06-PiramidTest.png)

## Paso 7
### El viejo debate: Automation de UI vs. API ¿Cuál hacer y por qué?
Verificar que el botón funciona es con UI.
Si necesito que el usuario está bloqueado sería por API.

# Section 2: Presentando las herramientas que vamos a usar y su configuración.
## Paso 8
### Presentación del VSCode y creación de directorios y proyecto
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
2. Seleccionamos en la parte superior al centro, la opcipon de `Gradle`.
3. Buscamos la ruta donde lo vamos a crear (En mi caso tengo una carpeta de 
"E:\Development\tutorials\java\cucumber\".
4. Tengo una carpeta allí como el nombre del proyecto "APIUdemi".
5. Seleccionamos el `DSL` que es `Groovy`.
6. El nombre del proyecto será `APIUdemy`.
7. Sacamos de la carpeta "app" el directorio "src" yel archivo
 **build.gradle** a la raíz del proyecto
8. La carpeta "app" se puede eliminar. 
9. Dentro de "src/test" verificamos que estén las carpetas:
* "java"
* "resources"
