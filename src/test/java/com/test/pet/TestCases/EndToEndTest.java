package com.test.pet.TestCases;

import DTO.OrderDTO;
import DTO.PetDto;
import Enums.ShippingStatus;
import Enums.Status;
import com.test.pet.TestCases.Utils.OrderAPIHelper;
import com.test.pet.TestCases.Utils.PetAPIHelper;
import com.test.pet.TestCases.Utils.UserAPIHelper;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class EndToEndTest extends FrameworkInitializer {

    private final UserAPIHelper USER = new UserAPIHelper();
    private final PetAPIHelper PET = new PetAPIHelper();
    private final OrderAPIHelper ORDER = new OrderAPIHelper();
    private PetDto petData;

    @BeforeClass
    public void setUp() {
        petData = PET.generateRandomPet();
        petData.setStatus(Status.AVAILABLE.toString());

        PET.addNewPet(petData);
    }

    @Test
    public void test() {
        USER.login("Patrick", "123456");

        PetDto requiredPet = PET.findPetByID(petData.getId());

        Assert.assertEquals(requiredPet.getStatus(), Status.AVAILABLE.toString());

        OrderDTO orderDTO = new OrderDTO(123, requiredPet.getId(), 1, ShippingStatus.PLACED, false);

        ORDER.placeOrder(orderDTO);

        requiredPet.setStatus(Status.PENDING.toString());

        PET.updateExisting(requiredPet);

        orderDTO.setCompleted(true);

        ORDER.placeOrder(orderDTO);

        requiredPet.setStatus(Status.SOLD.toString());

        PET.updateExisting(requiredPet);

        PetDto finalPetOrder = PET.findPetByID(requiredPet.getId());

        Assert.assertEquals(finalPetOrder.getName(), requiredPet.getName());
        Assert.assertEquals(finalPetOrder.getId(), requiredPet.getId());
        Assert.assertEquals(finalPetOrder.getStatus(), requiredPet.getStatus());

        List<PetDto> petList = PET.findByStatus(List.of(Status.SOLD));

        Assert.assertTrue(petList.stream().anyMatch(a -> a.getId() == finalPetOrder.getId()));

        USER.logout();
    }

}
