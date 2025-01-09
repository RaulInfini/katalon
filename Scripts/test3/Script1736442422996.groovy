import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.testobject.ConditionType as ConditionType
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

// Abre el navegador y navega a Wikipedia
WebUI.openBrowser('')
WebUI.navigateToUrl('https://es.m.wikipedia.org/wiki/Wikipedia:Portada')

// Crear un objeto dinámico para el botón de búsqueda basado en su clase inicial
TestObject searchButton = new TestObject('dynamicSearchButton')
searchButton.addProperty("class", ConditionType.EQUALS, "mw-ui-button main-top-mobileSearchButton skin-minerva-search-trigger")

// Realizar clic en el botón de búsqueda para habilitar el campo
WebUI.waitForElementClickable(searchButton, 10)
WebUI.click(searchButton)
WebUI.delay(2)

// Crear un objeto dinámico para el campo de búsqueda basado en la clase visible después del clic
TestObject searchInput = new TestObject('dynamicSearchInput')
searchInput.addProperty("class", ConditionType.EQUALS, "search mf-icon-search")

// Esperar a que el campo de texto esté visible y sea interactuable
WebUI.waitForElementVisible(searchInput, 10)

// Realizar el setText para introducir el término de búsqueda
WebUI.setText(searchInput, "america")
WebUI.delay(2)

// Hacer clic en "American Horror Story"
TestObject americanHorrorStory = findTestObject('Object Repository/Page_Wikipedia, la enciclopedia libre/h3_American Horror Story')
WebUI.waitForElementClickable(americanHorrorStory, 10)
WebUI.click(americanHorrorStory)
WebUI.delay(2)

// Navegar a las siguientes páginas
WebUI.click(findTestObject('Object Repository/Page_American Horror Story - Wikipedia, la _c358be/a_Ryan Murphy'))
WebUI.delay(2)

WebUI.click(findTestObject('Object Repository/Page_Ryan Murphy - Wikipedia, la encicloped_f1a413/a_Pose'))
WebUI.delay(2)

WebUI.click(findTestObject('Object Repository/Page_Pose (serie de televisin) - Wikipedia,_161d5d/a_LGBTIQ'))
WebUI.delay(2)

WebUI.click(findTestObject('Object Repository/Page_LGBT - Wikipedia, la enciclopedia libre/a_idioma ingls'))
WebUI.delay(2)

// Cerrar el navegador
WebUI.closeBrowser()