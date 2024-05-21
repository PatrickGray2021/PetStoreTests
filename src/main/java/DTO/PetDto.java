package DTO;

import java.util.ArrayList;

public class PetDto {

    private int id;
    private String name;
    private ArrayList<String> photoUrl;
    private ArrayList<CategoryObject> tags;
    private String status;
    private CategoryObject category;

    public PetDto(int id, String name, ArrayList<String> photoUrl, ArrayList<CategoryObject> tags, String status, CategoryObject category) {
        this.id = id;
        this.name = name;
        this.photoUrl = photoUrl;
        this.tags = tags;
        this.status = status;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<String> getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(ArrayList<String> photoUrl) {
        this.photoUrl = photoUrl;
    }

    public ArrayList<CategoryObject> getTags() {
        return tags;
    }

    public void setTags(ArrayList<CategoryObject> tags) {
        this.tags = tags;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public CategoryObject getCategory() {
        return category;
    }

    public void setCategory(CategoryObject category) {
        this.category = category;
    }

    public static class CategoryObject {
        private long id;
        private String name;

        public CategoryObject(long id, String name) {
            this.id = id;
            this.name = name;
        }

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
