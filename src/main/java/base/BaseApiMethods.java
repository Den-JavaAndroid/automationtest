package base;


import io.restassured.module.jsv.JsonSchemaValidator;

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
                body(JsonSchemaValidator.matchesJsonSchemaInClasspath("search_response.json")).
                extract().response().asString();
        return responceBody;
    }

}
