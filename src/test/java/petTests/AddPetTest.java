package petTests;

import api.PetApi;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import payload.Category;
import payload.Pet;

import java.util.concurrent.TimeUnit;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.core.Is.is;
import static org.testng.Assert.assertEquals;

public class AddPetTest extends BaseTest {

    private static Response createPetResponse;

    @BeforeTest
    public static void setUp(){
        Category cat = new Category.Builder()
                           .setId(100)
                           .setName("dog")
                           .build();

        Pet pet = new Pet.Builder()
                       .setId(0)
                        .setCategory(cat)
                       .setName("Jim")
                        .setStatus("pending")
                        .build();

        createPetResponse = PetApi.addAPet(pet);
    }

    public static Long getPetId() throws Exception{
        Long petId = createPetResponse.then().extract().path("id");
        return petId;
    }

    @Test(testName = "Check response code")
    public void testResponseCode() throws  Exception {
        logger.info("Verify status code for create pet response");
        test.assignCategory("Create New pet endpoint - POST CALL");
        createPetResponse.then().assertThat().statusCode(200);
    }

    @Test(testName = "Check response time")
    public void testResponseTime() throws Exception {
        logger.info("Verify response time for create pet response");
        test.assignCategory("Create New pet endpoint - POST CALL");
        createPetResponse.then().time(lessThan(3L), TimeUnit.SECONDS);
    }

    @Test(testName = "Check response size")
    public void testResponseSize() throws Exception {
        logger.info("Verify size of the response for create pet response");
        test.assignCategory("Create New pet endpoint - POST CALL");
        createPetResponse.then().body("size()", is(6));
    }

    @Test(testName = "Check response data")
    public void testResponseData() throws Exception {
        logger.info("Verify response data for create pet response");
        test.assignCategory("Create New pet endpoint - POST CALL");
        JsonPath jp = createPetResponse.jsonPath();

        String[] respData = {
                jp.get("name"),
                jp.get("category.name"),
                jp.get("status")
        };

        String[] expRespData = {"Jim", "dog", "pending"};
        assertEquals(respData, expRespData);
    }

    @Test(testName = "Check response schema")
    public void testResponseSchema() throws Exception {
        logger.info("verify json schema model");
        test.assignCategory("Create New pet endpoint - POST CALL");
        createPetResponse.then().assertThat().body(matchesJsonSchemaInClasspath("schema/addPetSchema.json"));
    }
}
