package DTO;

import Enums.ShippingStatus;

public class OrderDTO {

    private int id;
    private int petId;
    private int quantity;
    private ShippingStatus status;
    private boolean completed;

    public OrderDTO(int id, int petId, int quantity, ShippingStatus status, boolean completed) {
        this.id = id;
        this.petId = petId;
        this.quantity = quantity;
        this.status = status;
        this.completed = completed;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPetId() {
        return petId;
    }

    public void setPetId(int petId) {
        this.petId = petId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public ShippingStatus getStatus() {
        return status;
    }

    public void setStatus(ShippingStatus status) {
        this.status = status;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}