package problem2;

public class Person {

    private Long Id;
    private String Username;

    public Person(Long id, String username) {
        Id = id;
        Username = username;
    }

    public Long getId() {
        return this.Id;
    }

    public String getUsername() {
        return this.Username;
    }
}
