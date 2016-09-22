package problem5;

import problem5.models.Category;
import problem5.models.User;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class CommandExecutor {
    private HashMap<String, Category> categoriesByName;
    private HashMap<String, User> usersByName;

    public CommandExecutor() {
        this.categoriesByName = new LinkedHashMap<String, Category>();
        this.usersByName = new LinkedHashMap<String, User>();
    }

    public void addUser(User user){
        if (this.usersByName.containsKey(user.getName())){
            throw new IllegalArgumentException();
        }
        this.usersByName.put(user.getName(), user);
    }

    public void removeUser(User user){
        if (!this.usersByName.containsKey(user.getName())){
            throw new IllegalArgumentException();
        }
        this.usersByName.remove(user.getName());
    }

    public void addCategory(Category category) {
        if (this.categoriesByName.containsKey(category.getName())) {
            throw new IllegalArgumentException();
        }
        this.categoriesByName.put(category.getName(), category);
    }

    public void removeCategory(Category category) {
        if (!this.categoriesByName.containsKey(category.getName())) {
            throw new IllegalArgumentException();
        }
        this.categoriesByName.remove(category.getName());
    }

    public void assignCategory(Category parent, Category child) {
        parent.addSubCategory(child);

    }

    public void assignCategory(String parentName, Category child){
        if (!this.categoriesByName.containsKey(parentName)){
            throw new IllegalArgumentException();
        }
        Category parent = this.categoriesByName.get(parentName);
        parent.addSubCategory(child);
    }

    public void assignUserToCategory(User user, Category category) {
        user.addCategory(category);
    }

    public void assignUserToCategory(String name, Category category) {
        if (!this.usersByName.containsKey(name)){
            throw new IllegalArgumentException();
        }
        User currentUser = this.usersByName.get(name);
        currentUser.addCategory(category);
    }
}
