package lab12;

public class BlueRayCollection {
    private Node head = new Node(null);

    public BlueRayCollection(){}

    public void add(String title, String director, int yearOfRelease, double cost) {
        Node current = head;
        if(current.data == null) {
            current.data = new BlueRayDisk(title, director, yearOfRelease, cost);
            return;
        }
        while(current.next != null){
            current = current.next;
        }
        current.next = new Node(new BlueRayDisk(title, director, yearOfRelease, cost));
    }

    public void show_all() {
        Node current = head;
        if(current.data != null) {
            System.out.println(current.data.toString());
        }
        while(current.next != null){
            System.out.println(current.next.data.toString());
            current = current.next;
        }
    }
}