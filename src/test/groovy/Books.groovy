import io.restassured.response.Response
import org.testng.Assert
import org.testng.annotations.Test
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClassPath

import static io.restassured.RestAssured.*

import org.slf4j.Logger
import org.slf4j.LoggerFactory

class Books extends Base {

  def Logger logger = LoggerFactory.getLogger(getClass())

  @Test(groups='first')
  void getBookList() {
    Response response = get('/books')
    logger.info response.path('success').toString()
    ArrayList<String> allBooks = response.path('data.title')
    logger.info allBooks.size().toString()
    Assert.assertTrue(allBooks.size() >= 1, 'No books returned')
  }

  @Test(groups='first')
  void booksShemaIsValid() {
    get('/books').then().assertThat()
    .body(matchesJsonSchemaInClassPath('booksSchema.json'))
  }

  @Test
  void createAndDeleteBook() {
    File bookFile = new File(getClass().getResource('/book.json').toUri())
    Response createResponse = given().body(bookFile).when().post('/books')
    String responseID = createResponse.jsonPath().getString('post.book_id')

    Assert.assertEquals(createResponse.getStatusCode(), 201)

    Response deleteResponse = given().body(
      '{\n' +
      '\t\"book_id\": '+ responseID +'\n'+
      '}').when().delete('/books')

    Assert.assertEquals(deleteResponse.getStatusCode(), 200)
    Assert.assertEquals(deleteResponse.jsonPath().getString('message'),
    'Book successfully deleted')
  }

  @Test
  void deleteNonExistentBook_FailMessage() {
    String nonExistentBookId = '456123'

    Response deleteResponse = given().body(
      '{\n' +
      '\t\"book_id\": '+ nonExistentBookId +'\n'+
      '}').when().delete('/books')

    Assert.assertEquals(deleteResponse.getStatusCode(), 500)
    Assert.assertEquals(deleteResponse.jsonPath().getString('error'),
    'Unable to find book id: ' + nonExistentBookId)
  }

}
