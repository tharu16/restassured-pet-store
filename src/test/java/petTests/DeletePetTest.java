package petTests;

import api.PetApi;
import io.restassured.response.Response;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import petTests.AddPetTest.*;

public class DeletePetTest extends BaseTest {

    private static Response deletePetResponse;

    @BeforeTest
    public static void setUp() throws Exception {

        Long petId = AddPetTest.getPetId();
        deletePetResponse = PetApi.deleteAPet(petId);
    }

    @Test(testName = "Check response code")
    public void testRepsonseCode() throws Exception {

        logger.info("Verify response code for Delete pet endpoint");
        test.assignCategory("Delete Pet endpoint - DELETE CALL");
        deletePetResponse.then().assertThat().statusCode(200);
    }
}
