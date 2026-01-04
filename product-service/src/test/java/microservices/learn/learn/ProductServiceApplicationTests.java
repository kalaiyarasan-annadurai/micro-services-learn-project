package microservices.learn.learn;

import java.math.BigDecimal;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.testcontainers.mongodb.MongoDBContainer;

import com.kalai.productservice.dto.ProductRequest;

import io.restassured.RestAssured;

@SpringBootTest(webEnvironment =  SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ProductServiceApplicationTests {
   @ServiceConnection
   static MongoDBContainer mongoDBContainer = new MongoDBContainer("Mongo:7.0.7");
   
   @LocalServerPort
   private Integer port;

   @BeforeEach
   void setUp() {
   RestAssured.baseURI = "http://localhost";
   RestAssured.port = port;
   }

   static {
    mongoDBContainer.start();
   }

   @Test
   void shouldCreateProduct() throws Exception{
     ProductRequest productRequest = getProductRequest();


     RestAssured.given()
     .contentType("application/json")
     .body(productRequest)
     .when()
     .post("/api/product")
     .then()
     .log().all()
     .statusCode(201)
     .body("id", Matchers.notNullValue())
                .body("name", Matchers.equalTo(productRequest.name()))
                .body("description", Matchers.equalTo(productRequest.description()))
                .body("price", Matchers.is(productRequest.price().intValueExact()));
    
     
   }

   private ProductRequest getProductRequest() {

    return new ProductRequest("Iphone 15","Latest Iphone model",BigDecimal.valueOf(1200));
   
   }


}
