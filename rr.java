import java.util.*;
class Passenger{
    static String name;
    static int age;
    static String gender;
    static String berth_preference;
    static int bookingid=100;
    Passenger(String name,int age,String gender,String berth_preference)
    {
        this.name=name;
        this.age=age;
        this.gender=gender;
        this.berth_preference=berth_preference;
    }
}
class seat_availabilty{
static int totalberth=63;
static int upper=21;
static int middle=21;
static int lower=21;
static int rac=9;
static int waiting_list=0;
}

class book{
    Scanner scan = new Scanner(System.in);
    static HashMap<Integer,String> mylist = new HashMap<>();
    void check_seats()
    {
        System.out.println("Available tickets "+seat_availabilty.totalberth);
        if(seat_availabilty.totalberth<=0 && seat_availabilty.waiting_list<=10)
        {
            System.out.println("No Tickets Available");
        }
        else if(seat_availabilty.waiting_list>10)
    {
        System.out.println("No Tickets Available in waiting");

    }
    else{
        tbook();
    }
    
    }
    void tbook()
    {
        System.out.println("Enter Name:");
        String name= scan.nextLine();
        System.out.println("Enter Age:");
        int age= scan.nextInt();
        scan.nextLine();
        System.out.println("Enter Gender(M/F):");
        String gender= scan.nextLine().toUpperCase();
        System.out.println("Enter Berth Preference(lower/upper/middle):");
        String berth_preference= scan.nextLine().toLowerCase();

       if(berth_preference.equals("lower"))
       {
        seat_availabilty.lower--;
        seat_availabilty.totalberth--;

       }
       else if( berth_preference.equals("upper"))
       {
        seat_availabilty.upper--;
        seat_availabilty.totalberth--;

       } else if(berth_preference.equals("middle"))
       {
        seat_availabilty.middle--;
        seat_availabilty.totalberth--;

       }

        Passenger passenger = new Passenger(name, age, gender, berth_preference);
        System.out.println("Ticket Booked Sucesfully");
        String details=Passenger.name+" "+Passenger.age+" "+Passenger.gender+" "+berth_preference;
        mylist.put(passenger.bookingid,details);
        passenger.bookingid++;
    }
    
}

class cancel{
    Scanner scan = new Scanner(System.in);
    void cancel()
    {
        System.out.println("Enter Booking id");
        int bookid=scan.nextInt();
        if(book.mylist.containsKey(bookid))
        {
            book.mylist.remove(bookid);
        }
        else{
            System.out.println("Booking id not found");
        }

    }
}

class disp_tickets{
    Scanner scan = new Scanner(System.in);
    void display()
    {
        System.out.println("Enter Booking id");
        int bookid=scan.nextInt();
        if(book.mylist.containsKey(bookid))
        {
            String value= book.mylist.get(bookid);
            System.out.println("Booking id:"+ bookid);
            System.out.println("Details: "+ value);
}
        else{
            System.out.println("Booking id not found");
        } 
    
    }
}
class Available_Tickets{
    void available()
    {
        System.out.println("Total Berth Reamaing:"+seat_availabilty.totalberth);
        System.out.println("Lower Beth Remaining:"+seat_availabilty.lower);
        System.out.println("Middle Berth Remaining:"+seat_availabilty.middle);
        System.out.println("Upper Berth Remaining"+seat_availabilty.upper);
    }
}


public class rr {
    public static void main(String[] args)
    {
        book b1 = new book(); 
        cancel c1 = new cancel();
        disp_tickets d1 = new disp_tickets();
        Available_Tickets a1 = new Available_Tickets();
        Scanner scan = new Scanner(System.in);
        while(true)
        {

System.out.println("1.Book");
System.out.println("2.Cancel");
System.out.println("3.Print Booked Tickets");
System.out.println("4.Print Available Tickets");
System.out.println("5.Exit");
System.out.println("Enter a Choice:");
int choice = scan.nextInt();
scan.nextLine();
switch(choice)
{
    case 1:
    b1.check_seats();
    
    break;
    case 2:
    c1.cancel();
    break;
    case 3:
    d1.display();
    break;
    case 4:
    a1.available();
    break;
    case 5:
    System.out.println("Exiting........");
    return;
    default:

    System.out.println("Pls Enter Valid Choice");

}
        }
    }
}
