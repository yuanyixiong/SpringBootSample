package online.qsx.model;

public class User {
    private Long id;
    private String name;
    private Integer age;
    private Character sex;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Character getSex() {
        return sex;
    }

    public void setSex(Character sex) {
        this.sex = sex;
    }

    public User(Long id, String name, Integer age, Character sex) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public User(String name, Integer age, Character sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public User(Long id) {
        this.id = id;
    }

    public User() {
    }
}
