package basicRESTAssured;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.json.Json;

import static io.restassured.RestAssured.given;

public class RESTAssuredBasics {
    // default value of RestAssured.baseURI is http://locahost
    String baseURI = RestAssured.baseURI = "http://hrm.syntaxtechs.net/syntaxapi/api";
    String token = "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE2NjQ5Njk2NDAsImlzcyI6ImxvY2FsaG9zdCIsImV4cCI" +
            "6MTY2NTAxMjg0MCwidXNlcklkIjoiNDUyMSJ9.Vzfrh9nA9k8nPtSEfV1FtFmEl0ppLs4fpxmtJfs_2vI\"";
    @Test
    public void createAnEmployee(){

    // prepare request
    // RequestSpecification is the interface coming from RESTAssured
        RequestSpecification request = given().header("Content-Type", "application/json").
                header("Authorization", token).
                body(JsonObject.createEmployeePayload());
               /* body("{\n" +
                        "    \"emp_firstname\": \"azeddine\",\n" +
                        "    \"emp_lastname\": \"sterling\",\n" +
                        "    \"emp_middle_name\": \"MS\",\n" +
                        "    \"emp_gender\": \"M\",\n" +
                        "    \"emp_birthday\": \"2022-10-03\",\n" +
                        "    \"emp_status\": \"hired\",\n" +
                        "    \"emp_job_title\": \"QA\"\n" +
                "}");*/
        // interface Response is the interface coming from RESTAssured
        // we get the response from request object after posting the endpoint
        Response response = request.when().post(baseURI + "/createEmployee.php");

        // print out the response in console
        response.prettyPrint();

        // assert that the message "Employee created" appears
        String expectedMessage = "Employee Created";
        String actualMessage = response.jsonPath().getString("Message");
        Assert.assertEquals(expectedMessage, actualMessage);

        // make sure the status code of the response is 201
        response.then().assertThat().statusCode(201);
    }

    @Test
    public void jsonTest(){
        System.out.println("Json object: "+JsonObject.createEmployeePayload());
    }
}
