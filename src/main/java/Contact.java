public class Contact {
    String name;



    int id;
     int age;
     String country;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Contact(String name, int id, int age, String country) {
        this.name = name;
        this.id = id;
        this.age = age;
        this.country = country;
    }
}
