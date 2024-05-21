package DTO;

import java.util.ArrayList;

public class PetDtoBuilder {

    private int id;
    private String name;
    private ArrayList<String> photoUrl;
    private ArrayList<PetDto.CategoryObject> tags;
    private String status;
    private PetDto.CategoryObject category;

    public PetDtoBuilder setId(int id) {
        this.id = id;
        return this;
    }

    public PetDtoBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public PetDtoBuilder setPhotoUrl(ArrayList<String> photoUrl) {
        this.photoUrl = photoUrl;
        return this;
    }

    public PetDtoBuilder setTags(ArrayList<PetDto.CategoryObject> tags) {
        this.tags = tags;
        return this;
    }

    public PetDtoBuilder setStatus(String status) {
        this.status = status;
        return this;
    }

    public PetDtoBuilder setCategory(PetDto.CategoryObject category) {
        this.category = category;
        return this;
    }

    public PetDto createPetDto() {
        return new PetDto(id, name, photoUrl, tags, status, category);
    }
}