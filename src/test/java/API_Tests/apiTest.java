package API_Tests;

import API_Pages.PostUser;
import API_Pages.UsersPojo;
import io.qameta.allure.Description;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.*;
import java.util.stream.IntStream;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;

public class apiTest {

    private final static String gorestURL = "https://gorest.co.in/public/v2/users";
    private final static String reqresURL = "https://reqres.in/api/users";

    @Description("Get users")
    @Test
    public void getTest() {
        given().contentType(ContentType.JSON)
                .get(reqresURL)
                .then()
                .assertThat().statusCode(200)
                .body("data.id", hasItems(8))
                .body("data[0].first_name", equalTo("Michael"));
    }

    @Description("Post users")
    @Test
    public void postTest() {
        PostUser user = new PostUser();
        user.setName("Jake");
        user.setJob("JobJob");

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

        Assert.assertTrue(Arrays.stream(users).anyMatch(x -> x.getName().equals("Bakula Talwar")));
        //Arrays.stream(users).findFirst().or()
    }

    @Description("Post users 2")
    @Test
    public void postNewTest() {
        UsersPojo userData = new UsersPojo(33, "NewName", "adsad@email.com", "female", "active");
        Response response = given().body(userData)
                .post(gorestURL)
                .then()
                .statusCode(200)
                .log().all()
                .extract().response();

        /*UsersPojo[] users = response.getBody().as(UsersPojo[].class);
        Assert.assertTrue(Arrays.stream(users).anyMatch(x -> x.getName().contains("Vidhur")));*/
    }

    @Test
    public void palindromeTest() {
        String str = "racecar33";
        boolean isPalindrome = IntStream.range(0, str.length() / 2)
                .noneMatch(i -> str.charAt(i) != str.charAt(str.length() - i - 1));
        System.out.println(isPalindrome); // Output: true
    }
}