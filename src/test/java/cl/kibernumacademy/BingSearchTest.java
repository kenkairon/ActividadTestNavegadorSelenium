// Paquete donde se encuentra esta clase
package cl.kibernumacademy;

// Importa todas las anotaciones necesarias de JUnit 5 (como @Test, @BeforeEach, etc.)
import org.junit.jupiter.api.*;

// Importa clases de Selenium WebDriver necesarias para controlar el navegador y elementos web
import org.openqa.selenium.*;

// Importa la clase específica para controlar el navegador Google Chrome
import org.openqa.selenium.chrome.ChromeDriver;

// Importa WebDriverManager, que se encarga de descargar y configurar automáticamente el driver de Chrome
import io.github.bonigarcia.wdm.WebDriverManager;

// Importa todos los métodos de aserción de JUnit 5 (como assertTrue, assertEquals, etc.)
import static org.junit.jupiter.api.Assertions.*;

// Clase de prueba llamada GoogleSearchTest
public class BingSearchTest {

    // Declara el controlador del navegador (WebDriver)
    private WebDriver driver;

    // Método que se ejecuta antes de cada prueba (gracias a @BeforeEach)
    @BeforeEach
    void setup() {
        // Configura automáticamente el driver de Chrome usando WebDriverManager
        WebDriverManager.chromedriver().setup();

        // Inicializa el navegador Chrome
        driver = new ChromeDriver();
    }

    // Aquí podrías agregar métodos de prueba con @Test más adelante
    @Test
    void testBingSearch() {
        // Abre la página de Bing
        driver.get("https://www.bing.com");

        // Busca el campo de texto donde se escriben las búsquedas (tiene el atributo
        // name="q")
        WebElement searchBox = driver.findElement(By.name("q"));

        // Escribe el texto de búsqueda en el campo
        searchBox.sendKeys("OpenAI");

        // Envía el formulario (presiona Enter)
        searchBox.submit();

        // Obtiene el título actual de la página después de la búsqueda
        String pageTitle = driver.getTitle();

        // Verifica que el título de la página contenga "OpenAI"
        assertTrue(pageTitle.contains("OpenAI"));
    }

    // Este método se ejecuta automáticamente después de cada prueba
    @AfterEach
    public void tearDown() {
        // Verifica que el driver no sea null (es decir, que el navegador fue iniciado
        // correctamente)
        if (driver != null) {
            // Cierra todas las ventanas del navegador y finaliza la sesión de WebDriver
            driver.quit();
        }
    }

}
