package API_Tests;

import API_Pages.Specifications;
import API_Pages.UserData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.*;

public class apiTest {

    private final static String URL = "https://reqres.in/api/users?page=2";

    @Test
    public void testUsers() {
        Specifications.specInstall(Specifications.requestSpecification(), Specifications.responseSpecification());
        List<UserData> users = given().when()
                .get(URL)
                .then().log().all()
                .extract().body().jsonPath()
                .getList("data", UserData.class);

        users.stream().filter(x -> x.getId().equals(10)).forEach(b -> {
            Assert.assertEquals(b.getFirst_name(), "Byron");
            Assert.assertEquals(b.getLast_name(), "Fields");
        });
    }
}