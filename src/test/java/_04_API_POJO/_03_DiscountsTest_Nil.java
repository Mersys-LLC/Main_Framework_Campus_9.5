package _04_API_POJO;

import _04_API_POJO.Model.Discounts_Nil;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Cookies;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class _03_DiscountsTest_Nil {
    private RequestSpecification reqSpec;
    private HashMap<String, String> credentials = new HashMap<>();
    private Cookies cookies;
    private Discounts_Nil discount = new Discounts_Nil();
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

@Test(priority = 1)
    public void addDiscountTest() {
    HashMap<String,String> reqBody = new HashMap<>();
    reqBody.put("description", "hermone");
    reqBody.put("code", "granger");
    reqBody.put("active", "false");
    reqBody.put("priority", "1");

    discount.setId(given()
            .spec(reqSpec)
            .cookies(cookies)
            .body(reqBody)
            .when()
            .post("/school-service/api/discounts")
            .then()
            .log().body()
            .statusCode(201)
            .extract().jsonPath().getString("id"));
}

@Test(priority = 2)
    public void addDiscountNegativeTest() {
    HashMap<String,String> reqBody = new HashMap<>();
    reqBody.put("description", "hermone");
    reqBody.put("code", "granger");
    reqBody.put("active", "false");
    reqBody.put("priority", "1");

    given()
            .spec(reqSpec)
            .cookies(cookies)
            .body(reqBody)
            .when()
            .post("/school-service/api/discounts")
            .then()
            .log().body()
            .statusCode(400);

}

    @Test(priority = 3)
    public void updateDiscountTest() {

        HashMap<String, String> updatedData = new HashMap<>();
        updatedData.put("id", discount.getId());
        updatedData.put("description", "harrypotter");
        updatedData.put("code", "1");
        updatedData.put("active", "true");
        updatedData.put("priority", "1");


        given()
                .spec(reqSpec)
                .cookies(cookies)
                .body(updatedData)
                .when()
                .put("/school-service/api/discounts")
                .then()
                .log().body()
                .statusCode(200)
                .body("description", equalTo(updatedData.get("description")))
                .body("code", equalTo(updatedData.get("code")));
    }

    @Test(priority = 4)
    public void deleteDiscountTest() {
    given()
            .spec(reqSpec)
            .cookies(cookies)
            .when()
            .delete("/school-service/api/discounts/" + discount.getId())
            .then()
            .log().body()
            .statusCode(200);
}
    @Test(priority = 5)
    public void deleteDiscountNegativeTest() {
        given()
                .spec(reqSpec)
                .cookies(cookies)
                .when()
                .delete("/school-service/api/discounts/" + discount.getId())
                .then()
                .log().body()
                .statusCode(400);
    }
}
