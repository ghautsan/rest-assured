package starter.user;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.equalTo;

public class SingleGet {
    protected static String url = "https://jsonplaceholder.typicode.com/";
    @Step("I set GET api endpoints")
    public String setApiEndpoints() {
        return url + "posts/1";
    }

    @Step("I send GET HTTP request")
    public void sendGetHttpRequest() {
        SerenityRest.given().get(setApiEndpoints());
    }

    @Step("I receive valid data for detail post")
    public void validateDataDetailPost() {
        restAssuredThat(response -> response.body("userId", equalTo(1)));
        restAssuredThat(response -> response.body("id", equalTo(1)));
    }
}
