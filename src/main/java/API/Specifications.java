package API;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Specifications {

    public static RequestSpecification requestSpecification() {
        return new RequestSpecBuilder().setContentType(ContentType.JSON)
                .build();
    }

    public static ResponseSpecification responseSpecification() {
        return new ResponseSpecBuilder().expectStatusCode(200)
                .build();
    }

    public static void specInstall(RequestSpecification requestSpecification, ResponseSpecification responseSpecification) {
        RestAssured.requestSpecification = requestSpecification;
        RestAssured.responseSpecification = responseSpecification;
    }
}