package lab12;

public class BlueRayCollection {
    private Node head = null;

    public BlueRayCollection(){}

    public void add(String title, String director, int yearOfRelease, double cost) {
        Node current = head;
        Node temp = new Node(new BlueRayDisk(title, director, yearOfRelease, cost));
        if(current == null) {
            head = temp;
            return;
        }
        while(current.next != null){
            current = current.next;
        }
        current.next = temp;
    }

    public void show_all() {
        Node current = head;
        if(current != null) {
            System.out.println(current.data.toString());
            while(current.next != null){
                System.out.println(current.next.data.toString());
                current = current.next;
            }
        }
    }
}