package petTests;

import api.PetApi;
import io.restassured.response.Response;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class GetPetTest extends BaseTest{

    private static Response getPetResponse;

    @BeforeTest
    public static void setUp() throws Exception {

        Long petId = AddPetTest.getPetId();
        getPetResponse = PetApi.getAPet(petId);
    }

    @Test(testName = "Check response code")
    public void testResponseCode() throws Exception {

        logger.info("Verify response code for get pet endpoint");
        test.assignCategory("Get Pet endpoint - GET CALL");
        getPetResponse.then().assertThat().statusCode(404);
    }
}
