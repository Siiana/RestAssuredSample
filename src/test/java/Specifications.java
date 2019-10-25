import io.restassured.RestAssured;
import io.restassured.RestAssured.*;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.BeforeClass;


import static org.hamcrest.Matchers.hasKey;
import static org.hamcrest.Matchers.lessThan;

public class Specifications {
   @BeforeClass
    public static void before(){
        RestAssured.baseURI = "https://reqres.in/";
    }

    RequestSpecification requestSpecGet = new RequestSpecBuilder()
            .setContentType(ContentType.JSON) // same as .header("Content-Type", "application/json")
            .setBasePath("/api/users/{id}")
            .build();

    RequestSpecification requestSpecGetList = new RequestSpecBuilder()
            .setContentType(ContentType.JSON) // same as .header("Content-Type", "application/json")
            .setBasePath("/api/users/")
            .build();

    ResponseSpecification responseSpecGet = new ResponseSpecBuilder()
            .expectResponseTime(lessThan(5000L))
            .expectBody("$", hasKey("data"))
            .build();

    /*ResponseSpecification responseSpecGetList = new ResponseSpecBuilder()
            .expectResponseTime(lessThan(5000L))
            .expectBody("$", hasKey("data"))
            .build();*/

    RequestSpecification requestSpecPost = new RequestSpecBuilder()
            .setContentType(ContentType.JSON) // same as .header("Content-Type", "application/json")
            .setBasePath("/api/users")
            .build();

    ResponseSpecification responseSpecPost = new ResponseSpecBuilder()
            .expectResponseTime(lessThan(5000L))
            .expectBody("$", hasKey("name"))
            .expectBody("$", hasKey("job"))
            .build();


    RequestSpecification requestSpecPut = new RequestSpecBuilder()
            .setContentType(ContentType.JSON) // same as .header("Content-Type", "application/json")
            .setBasePath("/api/users")
            .build();

    ResponseSpecification responseSpecPut = new ResponseSpecBuilder()
            .expectResponseTime(lessThan(5000L))
            .expectBody("$", hasKey("name"))
            .expectBody("$", hasKey("job"))
            .build();

    RequestSpecification requestSpecDelete = new RequestSpecBuilder()
            .setContentType(ContentType.JSON) // same as .header("Content-Type", "application/json")
            .setBasePath("/api/users")
            .build();




}
