package com.test.pet.TestCases.Utils;

import DTO.OrderDTO;
import org.testng.Assert;

public class OrderAPIHelper extends BaseAPIHelper {

    public void placeOrder(OrderDTO order) {
        postRequest(order, "/store/order");
    }

    public OrderDTO findPurchaseOrderById(Number id) {
        return GSON_BUILDER.fromJson(getRequest(String.format("/store/order/%s", id)).body().prettyPrint(), OrderDTO.class);
    }

    public void deleteOrder(Number id) {
        deleteRequest(String.format("/store/order/%s", id));
    }

    public void verifyOrderNotFound(Number id) {
        Assert.assertEquals(getRequest(String.format("/store/order/%s", id)).body().jsonPath().get("message"), "Order not found");
    }
}