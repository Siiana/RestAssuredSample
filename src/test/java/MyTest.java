import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.hasItem;


public class MyTest extends Specifications {

    @Test
    public void restGet() {
        given()
                .spec(requestSpecGet)
                .pathParam("id", 11)
                .when()
                .get()
                .then()
                .statusCode(200)
                .and()
                .body("data.first_name", equalTo("George"))
                .and()
                .body("data.last_name", equalTo("Edwards"));
    }

    @Test
    public void restGet2() {
        given()
                .spec(requestSpecGet)
                .pathParam("id", 3)
                .when()
                .get()
                .then()
                .spec(responseSpecGet)
                .and()
                .body("data.first_name", equalTo("Emma"))
                .and()
                .body("data.last_name", equalTo("Wong"));
    }

    @Test
    public void restGetList() {
        given()
                .spec(requestSpecGetList)
                .param("page", 2)
                .when()
                .get()
                .then()
                .body("data.last_name", hasItem("Ferguson"));
    }

    @Test
    public void restPost() {
        User user = new User();
        user.setJob("automation");
        user.setName("Tanya");

        given()
                .spec(requestSpecPost)
                .body(user)
                .post()
                .then()
                .spec(responseSpecPost)
                .and()
                .body("name", equalTo(user.getName()))
                .and()
                .body("job", equalTo(user.getJob()));
    }

    @Test
    public void restPost2() {
        User user = new User();
        user.setJob("automation");
        user.setName("Tanya");
        given()
                .spec(requestSpecPost)
                .body(user)
                .post()
                .then()
                .statusCode(201)
                .spec(responseSpecPost)
                .and()
                .body("name", equalTo(user.getName()))
                .and()
                .body("job", equalTo(user.getJob()));
    }

    @Test
    public void restPut() {
        User user = new User();
        user.setJob("automationQA");
        user.setName("TanyaK");
        given()
                .spec(requestSpecPut)
                .body(user)
                .put()
                .then()
                .spec(responseSpecPut)
                .and()
                .body("name", equalTo(user.getName()))
                .and()
                .body("job", equalTo(user.getJob()));
    }

    @Test
    public void restPut2() {
        User user = new User();
        user.setJob("automationQA");
        user.setName("TanyaK");
        given()
                .spec(requestSpecPut)
                .body(user)
                .put()
                .then()
                .statusCode(200)
                .spec(responseSpecPut)
                .and()
                .body("name", equalTo(user.getName()))
                .and()
                .body("job", equalTo(user.getJob()));
    }

    @Test
    public void restDelete() {

        given()
                .spec(requestSpecDelete)
                .delete()
                .then()
                .statusCode(204);

    }




}



