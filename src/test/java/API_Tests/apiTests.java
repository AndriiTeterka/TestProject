package API_Tests;

import API_Pages.PostUser;
import API_Pages.Specifications;
import API_Pages.UsersPojo;
import io.qameta.allure.Description;
import io.restassured.http.ContentType;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;

public class apiTests {

    private final static String gorestURL = "https://gorest.co.in/public/v2/users";
    private final static String reqresURL = "https://reqres.in/api/users";

    @Description("Get users")
    @Test
    public void getTest() {
        given().contentType(ContentType.JSON).spec(Specifications.requestSpecification())
                .get(reqresURL)
                .then()
                .assertThat().statusCode(200)
                .body("data.id", hasItems(3))
                .body("data[0].first_name", equalTo("George"));
    }

    @Description("Post users")
    @Test
    public void postTest() {
        PostUser user = new PostUser();
        user.setName("Jake");
        user.setJob("Job1");

        PostUser createdUser = given().contentType(ContentType.JSON)
                .body(user)
                .when()
                .post(reqresURL)
                .then().statusCode(201)
                .log().all()
                .extract().as(PostUser.class);
        Assert.assertEquals(user.getName(), createdUser.getName());
        System.out.println(createdUser.getCreatedAt());
    }

    @Description("Get users 2")
    @Test
    public void getNewTest() {
        UsersPojo[] users = given().contentType(ContentType.JSON)
                .get(gorestURL)
                .then()
                .statusCode(200)
                .log().all()
                .extract().response().as(UsersPojo[].class);

        Assert.assertTrue(Arrays.stream(users).anyMatch(x -> x.getName().equals("Nirbhay Achari")));
    }
}