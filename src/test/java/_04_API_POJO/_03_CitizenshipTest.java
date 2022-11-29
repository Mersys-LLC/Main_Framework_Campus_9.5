package _04_API_POJO;

import _04_API_POJO.Model.Citizenship;
import _08_Utils.ExcelUtility;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Cookies;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class _03_CitizenshipTest {

    private RequestSpecification reqSpec;
    private Citizenship user = new Citizenship();
    private HashMap<String, String> credentials;

    private Cookies cookies;


    @BeforeClass
    public void setup() {

        RestAssured.baseURI = "https://demo.mersys.io";

        reqSpec = given()
                .log().body()
                .contentType(ContentType.JSON);

        credentials = new HashMap<>();
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
                .body("scope", equalTo("openid"))
                .extract().detailedCookies();


    }

    @Test(priority = 1)
    public void addUserCitizenshipPositiveTest() {
        user.setName("TurkishCitizen");
        user.setShortName("TCZ");

        user.setId(given()
                .spec(reqSpec)
                .cookies(cookies)
                .body(user)
                .when()
                .post("/school-service/api/citizenships")
                .then()
                .log().body()
                .statusCode(201)
                .body("name", equalTo(user.getName()))
                .body("shortName", equalTo(user.getShortName()))
                .extract().jsonPath().getString("id"));
    }

    @Test(priority = 2)
    public void getCitizenShipTest() {
        given()
                .spec(reqSpec)
                .cookies(cookies)
                .when()
                .get("/school-service/api/citizenships/" + user.getId())
                .then()
                .statusCode(200);
    }
    @Test(priority = 3)
    public void addUserCitizenshipNegativeTest() {
        user.setName("TurkishCitizen");
        user.setShortName("TCZ");

        given()
                .spec(reqSpec)
                .cookies(cookies)
                .body(user)
                .when()
                .post("/school-service/api/citizenships")
                .then()
                .log().body()
                .statusCode(400);
    }
    @Test(priority = 4)
    public void editUserCitizenTest() {

        HashMap<String, String> updateReqBody = new HashMap<>();
        updateReqBody.put("id", user.getId());
        updateReqBody.put("name", "UsaCitizen");
        updateReqBody.put("shortName", "USC");

        given()
                .spec(reqSpec)
                .cookies(cookies)
                .body(updateReqBody)
                .when()
                .put("/school-service/api/citizenships")
                .then()
                .log().body()
                .statusCode(200)
                .body("name", equalTo(updateReqBody.get("name")))
                .body("shortName", equalTo(updateReqBody.get("shortName")));
    }
    @Test(priority = 5)
    public void deleteUserCitizenshipTest() {

        given()
                .spec(reqSpec)
                .cookies(cookies)
                .when()
                .delete("/school-service/api/citizenships/" + user.getId())
                .then()
                .log().body()
                .statusCode(200);
    }
    @Test(priority = 6)
    public void getCitizenShipNegativeTest() {
        given()
                .spec(reqSpec)
                .cookies(cookies)
                .when()
                .get("/school-service/api/citizenships/" + user.getId())
                .then()
                .statusCode(400);

    }
    @Test(priority = 7)
    public void deleteUserCitizenshipNegativeTest() {

        given()
                .spec(reqSpec)
                .cookies(cookies)
                .when()
                .delete("/school-service/api/citizenships/" + user.getId())
                .then()
                .log().body()
                .statusCode(400);
    }
}
