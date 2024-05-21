package DTO;

import Enums.ShippingStatus;

public class OrderDTOBuilder {

    private int id;
    private int petId;
    private int quantity;
    private ShippingStatus status;
    private boolean completed;

    public OrderDTOBuilder setId(int id) {
        this.id = id;
        return this;
    }

    public OrderDTOBuilder setPetId(int petId) {
        this.petId = petId;
        return this;
    }

    public OrderDTOBuilder setQuantity(int quantity) {
        this.quantity = quantity;
        return this;
    }

    public OrderDTOBuilder setStatus(ShippingStatus status) {
        this.status = status;
        return this;
    }

    public OrderDTOBuilder setCompleted(boolean completed) {
        this.completed = completed;
        return this;
    }

    public OrderDTO createOrderDTO() {
        return new OrderDTO(id, petId, quantity, status, completed);
    }

    public int getId() {
        return id;
    }

    public int getPetId() {
        return petId;
    }

    public int getQuantity() {
        return quantity;
    }

    public ShippingStatus getStatus() {
        return status;
    }

    public boolean isCompleted() {
        return completed;
    }
}