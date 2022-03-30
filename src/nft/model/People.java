package nft.model;

public class People {
    private final String personID;
    private final String name;
    private final Integer age;

    public People(String personID, String name, Integer age) {
        this.personID = personID;
        this.name = name;
        this.age = age;
    }

    public String getPersonID() {
        return personID;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }
}
