import java.util.ArrayList;

/*@Creator: Joseph Edwards
*@date:20/1/3
*@Version Alpha
*@ID: tyv379
*@side note:there are still a few bugs i am aware of and am working on.
*/


public class CustomerInformation {
    /**
    * These are the variables for the class
    */
    private String customerName;
    private long customerNumber;
    private String customerAddress;
    private String customerEmail;
    private int customerAge;
    private double totalTickets;
    private String empID;
    private String phoneNumber;
    private ArrayList<TruckScale> previousTickets;
    
    /**
     * this constructor sets the values of customer names to the temporary values. 
     * 
     * 
     * @param newName
     * @param newAddress
     * @param newEmail
     * @param newNumber
     * @param newAge
         */
    public CustomerInformation(String newName, String newAddress, String newEmail, int newAge, String empID, String phonenumber){
    
     customerName = newName;
     customerAddress = newAddress;
     customerEmail = newEmail;
     customerAge = newAge;
     totalTickets = 0.0;
     phoneNumber = phonenumber;
     this.empID = empID;
     previousTickets = new ArrayList<TruckScale>();
     
 }
    public CustomerInformation() { }

 public void addTruck(TruckScale truck)
 {
     previousTickets.add(truck);
 }
 public TruckScale[] getAllTickets()
 {
     TruckScale[] tickets = new TruckScale[previousTickets.size()];
     return previousTickets.toArray(tickets);
 }
 public String getEmpID()
 { return empID;
 }
 public String toString()
 {
     return customerName;
 }
 public void addTicket(double ticket)
 {
    totalTickets = totalTickets + ticket;
 }
 public double getTotalTickets()
 { return totalTickets; }
 
 // this getter returns the customerName.
 public String getCustomerName()
 
 {
     return customerName;
     
 }

// this setter makes the customer name equal to the name set by the user
 public void setCustomerName(String newName)
 {
     customerName = newName;  
 }
 
// This getter returns the customer's address
 public String getCustomerAddress()
 {
     return customerAddress;
 }
 // This setter sets the customer's address to the address specified by the customer
 public void setCustomerAddress(String newAddress)
 {
     customerAddress = newAddress;
 }
 // This getter retrieves the customer email from the system
 public String getCustomerEmail()
 {
     return customerEmail;
 }
 // This setter changes the customer email to the email written by the user
 public void setCustomerEmail(String newEmail)
 {
     customerEmail = newEmail;
 }
 // This getter is made getting the customer number
 public float getCustomerNumber()
 {
     return customerNumber;
 }
 // This setter is made for setting the customer number to the specified number
 public void setCustomerNumber(long newNumber)
 {
     customerNumber = (int) newNumber;

 }
 public int getCustomerAge(){
     return customerAge;
 }
 public void setCustomerAge(int newAge){
     customerAge = newAge;
 }
 public String getCustomerPhone() { return phoneNumber; }
}
