package _04_API_POJO;

import _04_API_POJO.Model.Cities;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Cookies;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class _05_CitiesTest {
    private RequestSpecification reqSpec;
    private HashMap<String, String> credentials = new HashMap<>();
    private Cookies cookies;
    private Cities cities = new Cities();
    @BeforeClass
    public void setup()  {

        RestAssured.baseURI = "https://demo.mersys.io";

        reqSpec = given()
                .log().body()
                .contentType(ContentType.JSON);

        credentials.put("username", "richfield.edu");
        credentials.put("password", "Richfield2020!");
        credentials.put("rememberMe", "true");

        cookies = given()
                .spec(reqSpec)
                .body(credentials)
                .when()
                .post("/auth/login")
                .then()
                .log().body()
                .statusCode(200)
                .extract().detailedCookies();
    }
    @Test
    public void addCitiesTest() {
        HashMap<String,String> reqBody = new HashMap<>();
        reqBody.put("name", "NilDeneme");
        reqBody.put("shortName", "null");
        reqBody.put("code", "1");
        reqBody.put("hasState", "false");

        cities.setId(given()
                .spec(reqSpec)
                .cookies(cookies)
                .body(reqBody)
                .when()
                .post("/school-service/api/countries")
                .then()
                .log().body()
                .statusCode(201)
                .extract().jsonPath().getString("id"));
    }

    @Test(dependsOnMethods = "addCitiesTest")
    public void addCitiesNegativeTest() {
        HashMap<String,String> reqBody = new HashMap<>();
        reqBody.put("name", "NilDeneme");
        reqBody.put("shortName", "null");
        reqBody.put("translateName", "[]");
        reqBody.put("code", "1");
        reqBody.put("hasState", "false");

        given()
                .spec(reqSpec)
                .cookies(cookies)
                .body(reqBody)
                .when()
                .post("/school-service/api/countries")
                .then()
                .log().body()
                .statusCode(400);
    }
    @Test(dependsOnMethods = "addCitiesNegativeTest")
    public void getCitiesTest() {
        given()
                .spec(reqSpec)
                .cookies(cookies)
                .when()
                .get( "/school-service/api/countries/" + cities.getId())
                .then()
                .statusCode(200);
    }

    @Test(dependsOnMethods = "getCitiesTest")
    public void updateCitiesTest() {

        HashMap<String, String> updatedData = new HashMap<>();
        updatedData.put("id", cities.getId());
        updatedData.put("name", "NilNilK17");


        given()
                .spec(reqSpec)
                .cookies(cookies)
                .body(updatedData)
                .when()
                .put("/school-service/api/countries/")
                .then()
                .log().body()
                .statusCode(200)
                .body("name", equalTo(updatedData.get("name")));
    }
    @Test(dependsOnMethods = "updateCitiesTest")
    public void deleteCitiesTest() {
        given()
                .spec(reqSpec)
                .cookies(cookies)
                .when()
                .delete("/school-service/api/countries/" + cities.getId())
                .then()
                .log().body()
                .statusCode(200);
    }
    /*
    @Test(dependsOnMethods = "deleteCitiesTest")
    public void deleteCitiesNegativeTest() {
        given()
                .spec(reqSpec)
                .cookies(cookies)
                .when()
                .delete("/school-service/api/countries/" + cities.getId())
                .then()
                .log().body()
                .statusCode(400);
    }

     */

}
