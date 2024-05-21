package com.test.pet.TestCases;

import DTO.UserDTO;
import com.test.pet.TestCases.Utils.UserAPIHelper;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UserAPITests extends FrameworkInitializer {

    private final UserAPIHelper API_HELPER = new UserAPIHelper();
    
    @Test
    public void createNewUserTest() {
        API_HELPER.login("string","string");

        UserDTO user = new UserDTO(123,"Dom","Domic","west","DW@Email.com","1357","0777222343",123);

        API_HELPER.createNewUser(user);

        UserDTO getUser = API_HELPER.getUserByName(user.getUsername());

        Assert.assertEquals(getUser.getUsername(),user.getUsername());
    }

    @Test
    public void createLargeListOfUsers(){
      API_HELPER.generateRandomListOfUsersAndPost(100);
    }
}
