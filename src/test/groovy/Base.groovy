import io.restassured.RestAssured
import io.restassured.builder.RequestSpecBuilder
import io.restassured.http.ContentType
import io.restassured.specification.RequestSpecification
import org.testng.annotations.BeforeClass
import org.slf4j.Logger
import org.slf4j.LoggerFactory

class Base {

  @BeforeClass
  public static void setupRestAssured() {
    def Logger logger = LoggerFactory.getLogger(getClass())
    logger.info 'Log to check'
    RestAssured.baseURI = 'http://qa-library-dev.herokuapp.com'
    RestAssured.basePath = '/api'
    logger.info  RestAssured.baseURI.toString()
    logger.info  RestAssured.basePath.toString()
    RequestSpecification requestSpecification = new RequestSpecBuilder().
      addHeader('Content-Type', ContentType.JSON.toString()).
      addHeader('Accept', ContentType.JSON.toString()).build()
    logger.info requestSpecification.toString()
    RestAssured.requestSpecification = requestSpecification
  }

}
