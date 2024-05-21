package com.test.pet.TestCases;

import DTO.PetDto;
import DTO.PetDtoBuilder;
import Enums.Categories;
import Enums.Status;
import com.test.pet.TestCases.Utils.PetAPIHelper;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class PetAPITests extends FrameworkInitializer {

    private final PetAPIHelper API_HELPER = new PetAPIHelper();

    @Test
    public void CreateNewPetInfo() {

        PetDto petInfo = API_HELPER.generateRandomPet();

        API_HELPER.addNewPet(petInfo);

        PetDto petDto = API_HELPER.findPetByID(petInfo.getId());

        Assert.assertEquals(petDto.getName(), petInfo.getName());
    }

    @Test
    public void CreateNewPetInfoAndFindByStatus() {

        PetDto petInfoAvailable = API_HELPER.generateRandomPet();
        petInfoAvailable.setStatus(Status.AVAILABLE.toString());

        API_HELPER.addNewPet(petInfoAvailable);

        List<PetDto> statusList = API_HELPER.findByStatus(List.of(Status.AVAILABLE));

        Assert.assertTrue(statusList.stream().anyMatch(petDto -> petDto.getId() == petInfoAvailable.getId() && petDto.getName().equals(petInfoAvailable.getName())));

        PetDto petInfoPending = API_HELPER.generateRandomPet();
        petInfoPending.setStatus(Status.PENDING.toString());

        API_HELPER.addNewPet(petInfoPending);

        List<PetDto> secondStatusList = API_HELPER.findByStatus(List.of(Status.AVAILABLE, Status.PENDING));

        Assert.assertTrue(secondStatusList.stream().anyMatch(petDto -> petDto.getId() == petInfoAvailable.getId() && petDto.getName().equals(petInfoAvailable.getName())));
        Assert.assertTrue(secondStatusList.stream().anyMatch(petDto -> petDto.getId() == petInfoPending.getId() && petDto.getName().equals(petInfoPending.getName())));
    }

    @Test
    public void CreateNewPetInfoAndDelete() {

        PetDto petInfo = API_HELPER.generateRandomPet();

        API_HELPER.addNewPet(petInfo);

        PetDto petDto = API_HELPER.findPetByID(petInfo.getId());

        API_HELPER.deletePet(petDto.getId());

        API_HELPER.verifyPetNotFound(petDto.getId());
    }

    @Test
    public void CreateNewPetInfoAndPartlyUpdate() {

        PetDto petInfo = API_HELPER.generateRandomPet();
        petInfo.setStatus(Status.AVAILABLE.toString());

        API_HELPER.addNewPet(petInfo);

        PetDto petDtoBeforeUpdate = API_HELPER.findPetByID(petInfo.getId());

        API_HELPER.updatePetInfo("UpdateTest", Status.SOLD.toString(), petInfo.getId());

        PetDto petDtoAfterUpdate = API_HELPER.findPetByID(petInfo.getId());

        Assert.assertNotEquals(petDtoAfterUpdate.getName(), petDtoBeforeUpdate.getName());
        Assert.assertEquals(Status.SOLD.toString(), petDtoAfterUpdate.getStatus());
    }

    @Test
    public void CreateNewPetInfoAndUpdate() {

        PetDto.CategoryObject categories = new PetDto.CategoryObject(10000, Categories.FISH.toString());
        PetDto petInfo = new PetDtoBuilder().setId(10000).setName("Jimmy").setPhotoUrl(new ArrayList<>(List.of("String"))).setTags(new ArrayList<>(List.of(categories))).setStatus(Status.SOLD.toString()).setCategory(categories).createPetDto();

        API_HELPER.addNewPet(petInfo);

        PetDto petDtoBeforeUpdate = API_HELPER.findPetByID(petInfo.getId());

        petDtoBeforeUpdate.setStatus(Status.PENDING.toString());
        petDtoBeforeUpdate.setName("bob");
        categories.setName(Categories.DOG.toString());
        petDtoBeforeUpdate.setCategory(categories);
        petDtoBeforeUpdate.setTags(new ArrayList<>(List.of(categories)));

        API_HELPER.updateExisting(petDtoBeforeUpdate);

        PetDto petDtoAfterUpdate = API_HELPER.findPetByID(petInfo.getId());

        Assert.assertEquals(petDtoAfterUpdate.getName(), "bob");
        Assert.assertEquals(petDtoAfterUpdate.getCategory().getName(), Categories.DOG.toString());
    }
}