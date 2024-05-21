package com.test.pet.TestCases;

import DTO.OrderDTO;
import DTO.OrderDTOBuilder;
import Enums.ShippingStatus;
import com.test.pet.TestCases.Utils.OrderAPIHelper;
import org.testng.Assert;
import org.testng.annotations.Test;

public class StoreAPITests extends FrameworkInitializer {

    private final OrderAPIHelper API_HELPER = new OrderAPIHelper();

    @Test
    public void CreateFetchAndDeleteOrder() {

        OrderDTO orderBuilder = new OrderDTOBuilder()
                .setCompleted(false)
                .setId(123456789)
                .setPetId(1000)
                .setQuantity(1)
                .setStatus(ShippingStatus.PLACED)
                .createOrderDTO();

        API_HELPER.placeOrder(orderBuilder);

        OrderDTO orderInfo = API_HELPER.findPurchaseOrderById(orderBuilder.getId());

        Assert.assertEquals(orderInfo.getPetId(), orderBuilder.getPetId());

        API_HELPER.deleteOrder(orderInfo.getId());

        API_HELPER.verifyOrderNotFound(orderInfo.getId());
    }

}
