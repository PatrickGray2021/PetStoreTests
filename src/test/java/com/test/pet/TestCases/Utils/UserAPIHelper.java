package com.test.pet.TestCases.Utils;

import DTO.UserDTO;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.math3.random.RandomDataGenerator;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class UserAPIHelper extends BaseAPIHelper {

    private static final RandomDataGenerator randomDataGenerator = new RandomDataGenerator();

    public UserDTO getUserByName(String userName) {
        return GSON_BUILDER.fromJson(getRequest(String.format("/user/%s", userName)).body().prettyPrint(), UserDTO.class);
    }

    public void createNewUser(UserDTO user) {
        postRequest(user, "/user");
    }

    public void createNewUsers(List<UserDTO> users) {
        postRequest(users, "/user/createWithArray");
    }

    public void login(String userName, String password) {
        Assert.assertEquals(getRequest(String.format("/user/login?username=%s&password=%s", userName, password)).getStatusCode(), 200);
    }

    public void logout(){
        Assert.assertEquals(getRequest("user/logout").getStatusCode(),200);
    }

    public void generateRandomListOfUsersAndPost(int size) {
        createNewUsers(generateRandomUserList(size));
    }

    private List<UserDTO> generateRandomUserList(int size) {

        List<UserDTO> userDTOS = new ArrayList<>(size);

        for (int i = 0; i < size; i++) {
            userDTOS.add(generateRandomUser());
        }
        return userDTOS;
    }

    private static UserDTO generateRandomUser() {
        int id = randomDataGenerator.nextInt(0, 500);
        String firstName = RandomStringUtils.randomAlphabetic(10);
        String lastName = RandomStringUtils.randomAlphabetic(10);
        String username = RandomStringUtils.randomAlphabetic(10);
        String email = RandomStringUtils.randomAlphabetic(10);
        String address = RandomStringUtils.randomAlphabetic(10);
        String city = RandomStringUtils.randomAlphabetic(10);
        int age = randomDataGenerator.nextInt(0, 500);
        return new UserDTO(id, firstName, lastName, username, email, address, city, age);
    }

}
