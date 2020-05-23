package lab2;

import java.util.Scanner;

public class Program {
    public static void main(String args[]) {
        Person testPerson = createPerson();
        System.out.printf("\nPerson:\n%s", testPerson);

        String json = Person.ToJson(testPerson);
        System.out.printf("\nToJson:\n%s\n", json);

        Person resultPerson = Person.FromJson(json);
        System.out.printf("\nFromJson:\n%s", resultPerson);

        boolean isEqual = testPerson.equals(resultPerson);
        System.out.printf("\nisEqual:\n%s\n", isEqual);
    }

    static private Person createPerson() {
        Scanner in = new Scanner(System.in);
        System.out.println("Name: ");
        String name = in.nextLine();
        System.out.println("Age: ");
        int age = in.nextInt();

        return new Person(name, age);
    }
}

