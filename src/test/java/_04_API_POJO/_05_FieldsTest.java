package _04_API_POJO;

import _04_API_POJO.Model.Fields;
import _08_Utils.ExcelUtility;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Cookies;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class _05_FieldsTest {

    private RequestSpecification reqSpec;

    private Fields elements = new Fields();

    private HashMap<String,String> credentials;

    private Cookies cookies;

    @BeforeClass
    public void setup(){

        RestAssured.baseURI = "https://demo.mersys.io/";

        reqSpec = given()
                .log().body()
                .contentType(ContentType.JSON);

        credentials = new HashMap<>();
        credentials.put("username","richfield.edu");
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
    public void addFieldsTest(){

        elements.setId(given()
                .spec(reqSpec)
                .cookies(cookies)
                .body(elements)
                .when()
                .post("/school-service/api/entity-field")
                .then()
                .log().body()
                .statusCode(201)
                .body("name", equalTo(elements.getName()))
                .body("code", equalTo(elements.getCode()))
                .body("type", equalTo(elements.getType()))
                .body("schoolId", equalTo(elements.getSchoolId()))
                .extract().jsonPath().getString("id"));

    }

    @Test(priority = 2)
    public void addFieldsTestNegative(){

        elements.getName();
        elements.getCode();
        elements.getType();

        given()
                .spec(reqSpec)
                .cookies(cookies)
                .body(elements)
                .when()
                .post("/school-service/api/entity-field")
                .then()
                .log().body()
                .statusCode(400);

    }

    @Test(priority = 3)
    public void editFieldsTest(){

        HashMap<String,String> updateReqBody = new HashMap<>();
        updateReqBody.put("id", elements.getId());
        updateReqBody.put("name", "Fieldnew");
        updateReqBody.put("code","new1234");
        updateReqBody.put("type", "STRING");
        updateReqBody.put("schoolId", elements.getSchoolId());


        given()
                .spec(reqSpec)
                .cookies(cookies)
                .body(updateReqBody)
                .when()
                .put("/school-service/api/entity-field")
                .then()
                .log().body()
                .statusCode(200)
                .body("name", equalTo(updateReqBody.get("name")));

    }

    @Test(priority = 4)
    public void deleteFieldsTest(){
        given()
                .spec(reqSpec)
                .cookies(cookies)
                .when()
                .delete("/school-service/api/entity-field/" + elements.getId())
                .then()
                .log().body()
                .statusCode(204);
    }
    @Test(priority = 5)
    public void deleteFieldsTestNegative(){
        given()
                .spec(reqSpec)
                .cookies(cookies)
                .when()
                .delete("/school-service/api/entity-field/" + elements.getId())
                .then()
                .log().body()
                .statusCode(400);
    }
}
