package features.Record;

public class RecordExample {
    public static void main(String[] args) {
        Person p1  = new Person("Ahmed",25);
        Person p2  = new Person("Laila", 15);

        System.out.println(p1);
        System.out.println(p2.name()+" is adult? "+ p2.isAdult());

        try {
            Person p3 = new Person("Alice", -10);
        }catch (IllegalArgumentException e){
            System.out.println("Error creating person: "+e.getMessage());
        }
    }
}
