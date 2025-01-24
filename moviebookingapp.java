package LABEXAM;

public class moviebookingapp {
    public static final int TOTAL_SEATS = 20;
    public int availableSeats = TOTAL_SEATS;


    public synchronized void booking(String user, int seats) {

        if (seats <= availableSeats) {
            System.out.println(user + " is attempting to book " + seats + " seats.");
            try {
                Thread.sleep(100); 
                availableSeats -= seats; 

//                System.out.print(user + " booked seats" + seats1 + " seats.");
                System.out.println(user + " successfully booked " + seats + " seats.");
                System.out.println("Total booked seats: " + (TOTAL_SEATS - availableSeats));
                System.out.println("Remaining seats: " + availableSeats);
            } catch (InterruptedException e) {
                System.out.println("Booking interrupted for " + user);
            }
        } else {
        
            System.out.println(user + " cannot book " + seats + " seats. Not enough seats available.");
        }
    }

    public static void version2main(String[] args) {
        moviebookingapp app = new moviebookingapp();

    
        Thread userA = new Thread();
        		
        app.booking("User A", 10);
        Thread userB = new Thread();	
        app.booking("User B", 12);


        userA.start();
        userB.start();
    }
}
