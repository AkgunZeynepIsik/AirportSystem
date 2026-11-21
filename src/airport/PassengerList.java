package airport;


public class PassengerList {

    private static class Node { //
        Passenger data;
        Node next;

        Node(Passenger data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    public PassengerList() {   // default constructor
        head = null;
        tail = null;
        size = 0;
    }

    public void addPassenger(Passenger p) {
        Node newNode = new Node(p);
        if (head == null) {
            head = newNode;
            tail = newNode;

        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;

    }


    public boolean removePassenger(int id) {
        if (head == null) {
            return false;
        }
        if (head.data.getPassengerID() == id) {
            head = head.next;
            if (head == null) {
                tail = null;
            }

            size--;
            return true;
        }

        Node prev = head;
        while (prev.next != null && prev.next.data.getPassengerID() != id) {
            prev = prev.next;
        }

        if (prev.next == null) {
            return false; // it can not be found
        }
        if (prev.next == tail) {
            tail = prev;
        }
        prev.next = prev.next.next;
        size--;
        return true;
    }

    public Passenger findPassenger(int id) {
        Node current = head;
        while (current != null) {
            if (current.data.getPassengerID() == id) {
                return current.data;
            }
            current = current.next;
        }
        return null;

    }

    public int size() {
        return size;
    }

    public void printlist() {
        if (head == null) {
            System.out.println("NO PASSENGERS");
            return;
        }
        Node current = head;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }

    //SORTING
    //First Class=1,Business Class=2,Economy Class=3
    private int classRank(String ticketClass) {
        if (ticketClass.equalsIgnoreCase("First")) {
            return 1;
        } else if (ticketClass.equalsIgnoreCase("Business")) {
            return 2;
        } else {
            return 3;
        }

    }


    public void sortByTicketClass() {
        Node sorted = null;
        Node current = head;

        while (current != null) {
            Node next = current.next;

        if (sorted == null || classRank(current.data.getticketClass()) < classRank(sorted.data.getticketClass())) {
            current.next = sorted;
            sorted = current;


        } else {
            Node s = sorted;
            while (s.next != null && classRank(current.data.getticketClass()) >= classRank(s.next.data.getticketClass())) {
                s = s.next;
            }
                current.next = s.next;
                s.next = current;


            }


            current = next;


        }
        head = sorted;

        tail = head;
        while (tail != null && tail.next != null) {
            tail = tail.next;
        }

    }


}






