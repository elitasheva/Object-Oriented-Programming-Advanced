package main.problem5.models;

import java.util.ArrayList;
import java.util.List;

public class User {

    private String name;
    private List<Category> categories;

    public User(String name, List<Category> categories) {
        this.name = name;
        this.categories = categories;
    }

    public User(String name) {
        this.name = name;
        this.categories = new ArrayList<Category>();
    }

    public String getName() {
        return this.name;
    }

    public Iterable<Category> getCategories() {
        return this.categories;
    }

    public void addCategory(Category category){
        this.categories.add(category);
    }
}
