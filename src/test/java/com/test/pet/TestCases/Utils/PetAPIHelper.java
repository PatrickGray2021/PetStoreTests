package com.test.pet.TestCases.Utils;

import DTO.PetDto;
import DTO.PetDtoBuilder;
import Enums.Categories;
import Enums.PetNames;
import Enums.Status;
import com.google.gson.reflect.TypeToken;
import io.restassured.http.ContentType;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

import static io.restassured.RestAssured.given;

public class PetAPIHelper extends BaseAPIHelper {

    public PetDto findPetByID(Number id) {
        return GSON_BUILDER.fromJson(getRequest(String.format("/pet/%s", id)).body().prettyPrint(), PetDto.class);
    }

    public void addNewPet(PetDto newPet) {
        postRequest(newPet, "/pet");
    }

    public List<PetDto> findByStatus(List<Status> statusValues) {
        String url = "/pet/findByStatus?status=" + statusValues.stream().map(Status::toString).collect(Collectors.joining(","));

        return GSON_BUILDER.fromJson(getRequest(url).body().prettyPrint(), new TypeToken<List<PetDto>>() {
        }.getType());
    }

    public void deletePet(Number id) {
        deleteRequest(String.format("/pet/%s", id));
    }

    public void verifyPetNotFound(Number id) {
        Assert.assertEquals(getRequest(String.format("/pet/%s", id)).body().jsonPath().get("message"), "Pet not found");
    }

    public void updatePetInfo(String name, String status, Number id){
        given().contentType(ContentType.URLENC).formParam("name",name).formParam("status",status).post(String.format("/pet/%s",id)).then().statusCode(200);

    }

    public void updateExisting(PetDto pet){
        putRequest(pet,"/pet");
    }

    public PetDto generateRandomPet() {
        int randomInt = ThreadLocalRandom.current().nextInt(1, 1000);
        PetDto.CategoryObject categoryObject = new PetDto.CategoryObject(randomInt, randomEnum(Categories.class).toString());

        return new PetDtoBuilder().setId(randomInt).setName(randomEnum(PetNames.class).getName()).setPhotoUrl(new ArrayList<>(List.of("string"))).setTags(new ArrayList<>(List.of(categoryObject))).setStatus(randomEnum(Status.class).toString()).setCategory(categoryObject).createPetDto();
    }

    private static <T extends Enum<?>> T randomEnum(Class<T> enumClass) {
        int x = ThreadLocalRandom.current().nextInt(enumClass.getEnumConstants().length);
        return enumClass.getEnumConstants()[x];
    }
}
