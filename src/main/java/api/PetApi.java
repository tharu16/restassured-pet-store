package api;

import io.restassured.response.Response;
import payload.Pet;

import static io.restassured.RestAssured.given;

public class PetApi extends BaseApi {

  public static Response addAPet(Pet payload) {

      return given()
              .log()
              .all()
              .header("content-type", "application/json")
              .body(payload)
             .when()
               .post(apiUrl);
  }

  public static Response getAPet(Long petId) {
      return given()
              .contentType("application/json")
              .get(apiUrl+"/"+petId);
  }

  public static Response deleteAPet(Long petId) {
      return given()
              .when()
              .delete(apiUrl+"/"+petId);
  }
}
