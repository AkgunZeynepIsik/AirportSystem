package airport;

public class Passenger {
    private int passengerID;
    private String passengerName;
    private int flightNumber;
    private String ticketClass;
    private char boardingGroup;   // 'A' is for business class and priority boarding. 'B' is for economy class

    public Passenger(int id, String passengerName, int flightNumber,String ticketClass, char boardingGroup) {
        this.passengerID =passengerID;
        this.passengerName = passengerName;
        this.flightNumber = flightNumber;
        this.ticketClass = ticketClass;
        this.boardingGroup = boardingGroup;

    }

    //We need to define "the getter methods" because we can only access the variables (which defined private) via the getter methods.

    public int getPassengerID() {
        return passengerID;
    }
    public String getPassengerName() {
        return passengerName;
    }
    public int getflightNumber() {
        return flightNumber;
    }
    public String getticketClass() {
        return ticketClass;
    }
    public char getboardingGroup() {
        return boardingGroup;
    }


    //We "toString" for printing the passenger details in a readable format.
    @Override
    public String toString() {
        return "Passenger ID:"+passengerID+"\n"+
        "Passenger Name:"+passengerName+"\n"+
        "Flight Number:"+flightNumber+"\n" +
        "Ticket Class(Business or Economy)"+ticketClass+"\n"+
        "Boarding Group(A or B):"+boardingGroup;








    }





}
