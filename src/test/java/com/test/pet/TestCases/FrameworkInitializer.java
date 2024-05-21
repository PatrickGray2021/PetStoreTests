package com.test.pet.TestCases;

import io.restassured.RestAssured;
import io.restassured.config.RestAssuredConfig;
import io.restassured.config.SSLConfig;
import io.restassured.parsing.Parser;
import org.testng.annotations.BeforeSuite;

public class FrameworkInitializer {

    @BeforeSuite
    public void frameworkSetUp() {
        RestAssured.config = RestAssuredConfig.config().sslConfig(SSLConfig.sslConfig().relaxedHTTPSValidation());
        RestAssured.baseURI = "https://petstore.swagger.io/v2/";
        RestAssured.defaultParser = Parser.JSON;
    }
}
