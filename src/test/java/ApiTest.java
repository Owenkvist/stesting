import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static java.net.HttpURLConnection.HTTP_OK;

public class ApiTest {
    private static final String URL_KEY = "https://www.reqres.in/";


    @Test
    public void test(){
        RestAssured.baseURI = URL_KEY;

        given()
                .when()
                .get(EndpointUrl.SINGLE_USER.addPath(String.format("first_name = “Janet")))
                .then()
                .statusCode(HTTP_OK)
                ;
    }

}

