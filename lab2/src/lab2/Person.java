package lab2;

import com.google.gson.*;

import java.util.Objects;

class Person {
    private static int counter = 0;

    private int id;
    private String name;
    private int age;

    public Person() {
        this.counter++;
        this.id = this.counter;
    }
    public Person(String name, int age) {
        this.counter++;
        this.id = this.counter;
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return this.id;
    }
    public void setName(String input) {
        this.name = input;
    }
    public String getName() {
        return this.name;
    }
    public void setAge(int input) {
        this.age = input;
    }
    public int getAge() {
        return this.age;
    }

    @Override
    final public boolean equals(Object object){
        if(object instanceof Person) {
            Person person = (Person) object;
            return Objects.equals(this.id, person.id);
        }
        else
            return false;
    }

    @Override
    final public int hashCode() {
        int hash = 37;
        hash = hash * 17 + this.id;
        return hash;
    }

    static public String ToJson(Person src) {
        Gson gson = new Gson();
        return gson.toJson(src);
    }
    static public Person FromJson(String src) {
        Gson gson = new Gson();
        return gson.fromJson(src, Person.class);
    }

    @Override
    public String toString() {
        return String.format("Id: %s\nName: %s\nAge: %s\n", this.id, this.name, this.age);
    }
}
