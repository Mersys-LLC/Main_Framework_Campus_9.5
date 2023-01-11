package _04_API_POJO;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

import _04_API_POJO.Model.Nationalities;
import _08_Utils.ExcelUtility;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Cookies;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import java.util.ArrayList;
import java.util.HashMap;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class _02_NationalitiesTest {
  private RequestSpecification reqSpec;
  private Nationalities nation = new Nationalities();
  private HashMap<String, String> credentials = new HashMap<>();
  private Cookies cookies;
  String nationName;

  @BeforeClass
  public void setup() {


    RestAssured.baseURI = "https://demo.mersys.io";

    reqSpec = given()
        .log().body()
        .contentType(ContentType.JSON);

    ArrayList<ArrayList<String>> data =
        ExcelUtility.getListData("src/test/java/_02_ApachePOI/Resources/LoginData.xlsx",
            "Login", 2);
    for (ArrayList<String> row : data) {
      String username = row.get(0);
      String password = row.get(1);

    credentials.put("username", username);
    credentials.put("password", password);
    credentials.put("rememberMe", "true");
    }
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

  @Test
  public void addNationTest() {

    nationName=getRandomName(); // set ediyorum

    nation.setName(nationName);
    nation.setTranslateName("tr","aa");

    nation.setId(given()
//    Response response = given()
        .spec(reqSpec)
        .cookies(cookies)
        .body(nation)
        .when()
        .post("/school-service/api/nationality")
        .then()
//        .extract().response();

//    nation.getTranslateName().get(0)response.jsonPath().getInt(translateName[0].lang)

//        .log().body()
        .statusCode(201)
        .body("name", equalTo(nation.getName()))
        .body("translateName[0].lang", equalTo(nation.getTranslateName().get(0).getLang()))
        .body("translateName[0].data", equalTo(nation.getTranslateName().get(0).getData()))
        .extract().jsonPath().getString("id"));


//    nation.getTranslateName().get(0).setId(
//        .extract().jsonPath().getString("translateName[0].id"));


  }
  @Test(dependsOnMethods = "addNationTest")
  public void addNationTestNegative(){

    nation.setName(nationName);
    nation.setTranslateName("tr","aa");


    given()
        .spec(reqSpec)
        .cookies(cookies)
        .body(nation)

        .when()
        .post("/school-service/api/nationality")

        .then()
        .log().body()
        .statusCode(400)
        .body("message",equalTo("Please, provide valid data to create 'Nationality'"));
  }

  @Test(dependsOnMethods = "addNationTest")
  public void updateNation(){

    nationName=getRandomName();

    nation.setName(nationName);
    nation.setId(nation.getId());
    nation.setTranslateName("tr","aa");

    given()
        .spec(reqSpec)
        .cookies(cookies)
        .body(nation)

        .when()
        .put("/school-service/api/nationality")

        .then()
        .log().body()
        .statusCode(200)
        .body("name",equalTo(nationName));
  }

  @Test(dependsOnMethods = "updateNation")
  public void deleteNationById(){

    given()
        .cookies(cookies)
        .pathParam("nation_id", nation.getId())

        .when()
        .delete("/school-service/api/nationality/{nation_id}") //comes from pathParam

        .then()
        .log().body()
        .statusCode(200);
  }

  @Test(dependsOnMethods = "deleteNationById")
  public void deleteNationByIdNegative(){
    given()
        .cookies(cookies)
        .pathParam("nation_id", nation.getId())
        .log().uri()

        .when()
        .delete("/school-service/api/nationality/{nation_id}")

        .then()
        .log().body()
        .statusCode(400)
        .body("message",equalTo("Nationality not  found"));;
  }

  public String getRandomName() {
    return RandomStringUtils.randomAlphabetic(8).toLowerCase();
  }

}
