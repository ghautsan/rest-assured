package starter.user;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.simple.JSONObject;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.equalTo;

public class Put {
    protected String url = "https://jsonplaceholder.typicode.com/";

    @Step("I set PUT api endpoints")
    public String setPutApiEndpoints() {
        return url + "posts/1";
    }

    @Step("I send PUT HTTP request")
    public void sendPutHttpRequest() {
        JSONObject requestBody = new JSONObject();
        requestBody.put("id", "1");
        requestBody.put("title", "testing");

        SerenityRest.given().header("Content-Type", "application/json").body(requestBody.toJSONString()).put(setPutApiEndpoints());
    }

    @Step("I receive valid data for updated user")
    public void validateUpdateUser() {
        restAssuredThat(response -> response.body("id", equalTo(1)));
        restAssuredThat(response -> response.body("title", equalTo("testing")));
    }
}
