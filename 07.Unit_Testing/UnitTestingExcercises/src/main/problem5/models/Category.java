package main.problem5.models;

import java.util.ArrayList;
import java.util.List;

public class Category {

    private String name;
    private List<User> users;
    private List<Category> subCategories;

    public Category(String name, List<User> users, List<Category> subCategories) {
        this.name = name;
        this.users = users;
        this.subCategories = subCategories;
    }

    public Category(String name, List<User> users) {
        this.name = name;
        this.users = users;
        this.subCategories = new ArrayList<Category>();
    }

    public String getName() {
        return this.name;
    }

    public Iterable<User> getUsers() {
        return this.users;
    }

    public Iterable<Category> getSubCategories() {
        return this.subCategories;
    }

    public void addSubCategory(Category category){
        this.subCategories.add(category);
    }
}
