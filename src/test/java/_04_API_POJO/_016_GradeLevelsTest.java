package _04_API_POJO;

import _04_API_POJO.Model.GradeLevels;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Cookies;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class _016_GradeLevelsTest {


    private RequestSpecification reqSpec;
    private Cookies cookies;
    private HashMap<String, String> credential = new HashMap<>();
    private GradeLevels gradeLevelsElements = new GradeLevels();


    @BeforeClass
    public void setup() {

        RestAssured.baseURI = "https://demo.mersys.io/";

        reqSpec = given()
                .log().body()
                .contentType(ContentType.JSON);

        credential.put("username", "richfield.edu");
        credential.put("password", "Richfield2020!");
        credential.put("rememberMe", "true");


        cookies = given()
                .spec(reqSpec)
                .body(credential)
                .when()
                .post("/auth/login")
                .then()
                .log().body()
                .statusCode(200)
                .body("scope", equalTo("openid"))
                .extract().detailedCookies();
    }


    @Test(priority = 1)
    public void addGradeLevels(){

        gradeLevelsElements.setId(given()
                .spec(reqSpec)
                .cookies(cookies)
                .body(gradeLevelsElements)
                .when()
                .post("/school-service/api/grade-levels")
                .then()
                .log().body()
                .statusCode(201)
                .body("name", equalTo(gradeLevelsElements.getName()))
                .body("shortName", equalTo(gradeLevelsElements.getShortName()))
//                .body("order", equalTo(gradeLevels.getOrder()))
                .extract().jsonPath().getString("id"));

    }


    @Test(priority = 2)
    public void addGradeLevelsNegative(){

        gradeLevelsElements.getName();
        gradeLevelsElements.getShortName();
        gradeLevelsElements.getOrder();

        given()
                .spec(reqSpec)
                .cookies(cookies)
                .body(gradeLevelsElements)
                .when()
                .post("/school-service/api/grade-levels")
                .then()
                .log().body()
                .statusCode(400);
//                .body("name", equalTo(gradeLevels.getName()))
//                .body("shortName", equalTo(gradeLevels.getShortName()));
//                .body("order", equalTo(gradeLevels.getOrder()))


    }


    @Test(priority = 3)
    public void editGradeLevels(){

        HashMap<String,String> updateGradeLevels = new HashMap<>();
        updateGradeLevels.put("id", gradeLevelsElements.getId());
        updateGradeLevels.put("newName", gradeLevelsElements.getNewName());
        updateGradeLevels.put("shortName", gradeLevelsElements.getShortName());
        updateGradeLevels.put("order", gradeLevelsElements.getOrder());


        given()
                .spec(reqSpec)
                .cookies(cookies)
                .body(gradeLevelsElements)
                .when()
                .put("school-service/api/grade-levels")
                .then()
                .log().body()
                .statusCode(200);
//                .body("newName", equalTo(updateGradeLevels.get("newName")));

    }


    @Test(priority = 4)
    public void deleteGradeLevels(){

        given()
                .spec(reqSpec)
                .cookies(cookies)
                .when()
                .delete("school-service/api/grade-levels/" + gradeLevelsElements.getId())
                .then()
                .log().body()
                .statusCode(200);

    }


    @Test(priority = 5)
    public void deleteGradeLevelsNegative(){

        given()
                .spec(reqSpec)
                .cookies(cookies)
                .when()
                .delete("school-service/api/grade-levels/" + gradeLevelsElements.getId())
                .then()
                .log().body()
                .statusCode(400);


    }















}
