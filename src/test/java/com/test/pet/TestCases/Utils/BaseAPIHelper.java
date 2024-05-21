package com.test.pet.TestCases.Utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public abstract class BaseAPIHelper {

    protected static final Gson GSON_BUILDER = new GsonBuilder().create();

    protected Response getRequest(String endpoint) {
        return given().contentType(ContentType.JSON).when().get(endpoint);
    }

    protected void postRequest(Object body, String endpoint) {
        given().contentType(ContentType.JSON).body(GSON_BUILDER.toJson(body)).post(endpoint).then().statusCode(200);
    }

    protected void deleteRequest(String endpoint) {
        given().contentType(ContentType.JSON).delete(endpoint).then().statusCode(200);
    }

    protected void putRequest(Object body, String endpoint){
        given().contentType(ContentType.JSON).body(GSON_BUILDER.toJson(body)).put(endpoint).then().statusCode(200);
    }
}
