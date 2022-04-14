import java.awt.*;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;

public class PhoneBookList {


    public static void main(String[] args) {
        PhoneBookList pB = new PhoneBookList();
        pB.testPhonebook();
    }


    class Node {
        PhonebookData data;
        Node previous;
        Node next;

        public Node(PhonebookData data) {
            this.data = data;
        }
    }

    //Represent the head and tail of the doubly linked list
    Node head, tail = null;

    //addNode() will add a node to the list
    public void addNode(PhonebookData data) {
        //Create a new node
        Node newNode = new Node(data);

        //If list is empty
        if (head == null) {
            //Both head and tail will point to newNode
            head = tail = newNode;
            //head's previous will point to null
            head.previous = null;
            //tail's next will point to null, as it is the last node of the list
            tail.next = null;
        } else {
            //newNode will be added after tail such that tail's next will point to newNode
            tail.next = newNode;
            //newNode's previous will point to tail
            newNode.previous = tail;
            //newNode will become new tail
            tail = newNode;
            //As it is last node, tail's next will point to null
            tail.next = null;
        }
    }

    //display() will print out the nodes of the list
    public void display() {
        //Node current will point to head
        Node current = head;
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        System.out.println("Nodes of doubly linked list: ");
        while (current != null) {
            //Prints each node by incrementing the pointer.

            System.out.println(current.data + " ");
            current = current.next;
        }
    }

    public void testPhonebook() {
        PhoneBookList dList = new PhoneBookList();
        Scanner input = new Scanner(System.in);

//Add nodes to the list
        dList.addNode(new PhonebookData("John Smith", "908-239-2222"));
        dList.addNode(new PhonebookData("Janice Brown", "443-904-2332"));
        dList.addNode(new PhonebookData("Davis Davidson", "484-904-2222"));
        dList.addNode(new PhonebookData("Allison Sauerwald", "650-455-2222"));
        dList.addNode(new PhonebookData("Craig McHugh", "484-885-2222"));
        dList.addNode(new PhonebookData("David Johnson", "484-223-1234"));
        dList.addNode(new PhonebookData("Michael Brown", "908-239-2222"));
        dList.addNode(new PhonebookData("Michaela Flint", "443-904-2332"));
        dList.addNode(new PhonebookData("Stephanie Stevenson", "484-904-2222"));
        dList.addNode(new PhonebookData("Carmen Cerenzia", "650-455-2222"));
        dList.addNode(new PhonebookData("Richard Ruch", "484-885-2222"));
        dList.addNode(new PhonebookData("Sean Dogherty", "484-223-1234"));
        dList.addNode(new PhonebookData("Alane Maxwell", "908-239-2222"));
        dList.addNode(new PhonebookData("Steve Dobbs", "443-904-2332"));
        dList.addNode(new PhonebookData("Marc Huckleberry", "484-904-2222"));
        dList.addNode(new PhonebookData("Paul McCafferty", "650-455-2222"));
        dList.addNode(new PhonebookData("Thomas LeBlanc", "484-885-2222"));
        dList.addNode(new PhonebookData("Homer Simpson", "484-223-1234"));
        dList.addNode(new PhonebookData("Tyler Michaels", "908-239-2222"));
        dList.addNode(new PhonebookData("Dakota Brown", "443-904-2332"));
        dList.addNode(new PhonebookData("Jacob Johnson", "484-904-2222"));
        dList.addNode(new PhonebookData("Christina Stewart", "650-455-2222"));
        dList.addNode(new PhonebookData("Bethany Laurence", "484-885-2222"));
        dList.addNode(new PhonebookData("Shaun Dogherty", "484-223-1234"));


//Displays the nodes present in the list
        dList.display();

        System.out.println("Enter h to search head first, t to search from tail first, enter q to quit: ");
        String choice = input.nextLine();
        while (!choice.equals("q")) {
            if (choice.equals("t")) {
                System.out.println("tail first");
                System.out.println("Enter search item:");
                String searchItem = input.nextLine();
                SortedSet sortedSet = dList.searchTailFirst(searchItem);
                if (sortedSet != null) {
                    for (Object node : sortedSet) {
                        System.out.println(((PhonebookData) node).toString());
                    }
                }
            } else if (choice.equals("h")) {
                System.out.println("Head first");
                System.out.println("Enter search item: ");
                String searchItem = input.nextLine();
                SortedSet sortedSet = dList.searchHeadFirst(searchItem);
                if (sortedSet != null) {
                    for (Object node : sortedSet) {
                        System.out.println(((PhonebookData) node).toString());
                    }
                }
            }
            System.out.println("Enter h to search head first, t to search from tail first, enter q to quit: ");
            choice = input.nextLine();



        }
    }

    public SortedSet searchHeadFirst(String search) {
        SortedSet sortedSet = new TreeSet();
        Node current = head;
        if (head == null) {
            System.out.println("List is empty.");
        } else {
            while (current != null) {
                //Checks each node by incrementing the pointer.
                if (current.data.getName().toLowerCase().contains(search.toLowerCase().strip()) ||
                        current.data.getMobilePhone().toLowerCase().contains(search.toLowerCase().strip())) {
                    sortedSet.add((PhonebookData) current.data);
                }
                current = current.next;
            }
        }
        return sortedSet;
    }

    public SortedSet searchTailFirst(String search) {
        SortedSet sortedSet = new TreeSet();
        Node current = tail;
        if (tail == null) {
            System.out.println("List is empty.");
        } else {
            while (current != null) {
                //Checks each node by incrementing the pointer.
                if (current.data.getName().toLowerCase().contains(search.toLowerCase().strip()) ||
                        current.data.getMobilePhone().toLowerCase().contains(search.toLowerCase().strip())) {
                    sortedSet.add((PhonebookData) current.data);
                }
                current = current.previous;
            }
        }
        return sortedSet;
    }

    public class PhonebookData implements Comparable {

        String name;
        String mobilePhone;

        public PhonebookData(String name, String mobilePhone) {
            this.name = name;
            this.mobilePhone = mobilePhone;
        }


        public String getName() {
            return name;
        }

        public String getMobilePhone() {
            return mobilePhone;
        }

        public String toString() {
            return name + " " + mobilePhone;
        }

        public int compare(String str1, String str2) {
            int l1 = str1.length();
            int l2 = str2.length();
            int lmin = Math.min(l1, l2);
            for (int i = 0; i < lmin; i++) {
                int str1_ch = (int) str1.charAt(i);
                int str2_ch = (int) str2.charAt(i);
                if (str1_ch != str2_ch) {
                    return str1_ch - str2_ch;
                }
            }
            // Edge case for strings like
            // String 1="Geeks" and String 2="Geeksforgeeks"
            if (l1 != l2) {
                return l1 - l2;
            }
            // If none of the above conditions is true,
            // it implies both the strings are equal
            else {
                return 0;
            }
        }

        @Override
        public int compareTo(Object o) {
            PhonebookData pd = (PhonebookData) o;
            return compare(this.name, pd.name);
        }
    }
}