class Person {
    private static int personCounter = 0;
    private int personID;

    public Person() {
        this.personID = ++personCounter;
    }

    public static int getPersonCounter() {
        return personCounter;
    }
    public int getPersonID() {
        return this.personID;
    }
}

class Fireman extends Person {
    private static int firemanCounter = 0;
    private int firemanID;

    public Fireman() {
        super();
        this.firemanID = ++firemanCounter;
    }

    public static int getFiremanCounter() {
        return firemanCounter;
    }
    public int getFiremanID() {
        return this.firemanID;
    }
}

class Policeman extends Person {
    private static int policemanCounter = 0;
    private int policemanID;

    public Policeman() {
        super();
        this.policemanID = ++policemanCounter;
    }

    public static int getPolicemanCounter() {
        return policemanCounter;
    }
    public int getPolicemanID() {
        return this.policemanID;
    }
}
