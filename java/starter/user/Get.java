package starter.user;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class Get {
    protected static String url = "https://jsonplaceholder.typicode.com/";
    @Step("I set GET api endpoints")
    public String setApiEndpoints() {
        return url + "posts";
    }

    @Step("I send GET HTTP request")
    public void sendGetHttpRequest() {
        SerenityRest.given().get(setApiEndpoints());
    }

    @Step("I receive valid HTTP response code 200")
    public void validateHttpResponseCode200() {
        restAssuredThat(response -> response.statusCode(200));
    }
}
