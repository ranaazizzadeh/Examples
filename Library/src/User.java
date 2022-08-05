public class User {
    private long id;
    private String name;
    private String lastname;

    public User(long id, String name, String lastname) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
    }

    public User(String name, String lastname) {
        this.name = name;
        this.lastname = lastname;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                '}';
    }
}
