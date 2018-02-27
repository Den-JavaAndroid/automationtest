package base;

import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.given;

/**
 * Created by denx7 on 27.02.2018.
 */
public class BaseApiMethods {

    public static String searchByInnOgrn(String innOrOgrn) {
        String responceBody = given().
                queryParam("innOgrn", innOrOgrn).
                when().get().then().
//                log().body().
        statusCode(200).
                        extract().response().asString();
        return responceBody;
    }

}
