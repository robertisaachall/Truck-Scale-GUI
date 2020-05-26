/**
 * GUI program for the truck scale. Includes all methods needed for program
 * compatibility with itself. Method explainations below.
 * Includes main() method.
 *
 * @author Robert Burton, Robert Hall , Colton Edwards
 * @version 4/22/2020 Final
 */
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import java.awt.geom.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;


public class TruckScaleGUI extends JFrame implements ActionListener {
  
  JFrame frame;
  JList drivers;
  JPanel panel;
  JScrollPane scrollDrivers;
  ArrayList<CustomerInformation> driversList;
  CustomerInformation currentViewedUser;
  boolean driverSelected;

  

  public void paint(final Graphics g) 
  {
    super.paintComponents(g);
     Graphics2D g2 = (Graphics2D) g;
     Line2D line = new Line2D.Float(1, 80, 1600, 80);
    g2.draw(line);

  }
  /**
     * Used whenever the information about the driver selected is updated.
     * Clears the previous driver, and updates the display with correct information
     * @param  None
     * @return None
     */
  public void displayUser()
  {

    
      String[] fullName = currentViewedUser.toString().split("\\s+");
      String driverFirstName = fullName[0];
      String driverLastName = fullName[1];

      JLabel firstName1 = new JLabel(driverFirstName);
      firstName1.setBounds(140,100,100,40);
      firstName1.setFont(new Font("Serif", Font.PLAIN, 20));

      String tickers = Double.toString(currentViewedUser.getTotalTickets());
      
      JLabel totalTicketLabel = new JLabel(tickers);
      totalTicketLabel.setBounds(520,180,100,40);
      totalTicketLabel.setFont(new Font("Serif", Font.PLAIN,20));

      JLabel lastName1 = new JLabel(driverLastName);
      lastName1.setBounds(140,140,100,40);
      lastName1.setFont(new Font("Serif", Font.PLAIN, 20));

      JLabel email1 = new JLabel(currentViewedUser.getCustomerEmail());
      email1.setBounds(140,180,200,40);
      email1.setFont(new Font("Serif", Font.PLAIN, 20));

      String userAge_1 = Integer.toString(currentViewedUser.getCustomerAge());
      JLabel ageUser1 = new JLabel(userAge_1);
      ageUser1.setBounds(140,260,100,40);
      ageUser1.setFont(new Font("Serif", Font.PLAIN, 20));

      JLabel empID1 = new JLabel(currentViewedUser.getEmpID());
      empID1.setBounds(140,220,100,40);
      empID1.setFont(new Font("Serif", Font.PLAIN, 20));

      JLabel phoneNo1 = new JLabel(currentViewedUser.getCustomerPhone());
      phoneNo1.setBounds(140,300,150,40);
      phoneNo1.setFont(new Font("Serif", Font.PLAIN, 20));


      

      panel.removeAll();
      panel.updateUI();
      
      panel.add(totalTicketLabel);
      panel.add(firstName1);
      panel.add(lastName1);
      panel.add(email1);
      panel.add(ageUser1);
      panel.add(empID1);
      panel.add(phoneNo1);

      panel.revalidate();
      frame.repaint();
  }
  /**
     * Not used in final program. Kept here to allow testing.
     * Originally used to test drivers list to ensure functionality.
     * Depreciated in final version.
     * @param  None
     * @return List of strings from a file into an ArrayList.
     */
  public ArrayList<String> readFromFile()
  {
    ArrayList<String> drivers = new ArrayList<String>();
    try (BufferedReader br = new BufferedReader(new FileReader("C:/Users/Robert's Laptop/Documents/School and programs/Classes/CPSC1010/Class Work/Final project/random_names.txt")))
        {
            String sCurrentLine;
            while ((sCurrentLine = br.readLine()) != null) {
             drivers.add(sCurrentLine);
            }

        } catch (final IOException e) {
            e.printStackTrace();
        } 
      String[] array = new String[drivers.size()];
      return drivers;
  }
  /**
     * Method used in the "Select User" screen, whenever a user is selected
     * this function grabs that selected user from the list and returns it.
     *
     * @param  Takes in a JList of drivers.
     * @return A driver which will be used as currentViewedUser
     */
  public CustomerInformation getValueInScrollPanel(JList list)
  {
    CustomerInformation current = (CustomerInformation) list.getSelectedValue();

    return current;
  }
  /**
     * Constructor for the TruckScaleGUI class.
     * This constructor brings up the display, adds all buttons,
     * adds labels for viewability and displays components at certain x , y areas.
     */
  public TruckScaleGUI()
  {
      //Creation of JFrame. This allows us to have a GUI.
    frame = new JFrame("Truck Scale GUI for Highway Departmental Use Only");// creating instance of JFrame
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Stop program when it is closed.
    
    
    //****All the code below until noted is adding buttons to the frame.******
    //New Driver Button.
    currentViewedUser = new CustomerInformation();
    final JButton newDriverButton = new JButton("New Driver");// creating instance of JButton
    newDriverButton.setBounds(5, 5, 150, 40);// x axis, y axis, width, height
    newDriverButton.setToolTipText("Used for inserting a new driver.");
    newDriverButton.addActionListener(this);

    //Remove Driver Button
    final JButton clearDriverListButton = new JButton("Remove driver.");
    clearDriverListButton.setBounds(165, 5, 200, 40);
    clearDriverListButton.setToolTipText("Clears the driver list. Proceed at caution this will delete.");
    clearDriverListButton.addActionListener(this);

    //Add Ticket Button
    final JButton addTicketButton = new JButton("Add Ticket");
    addTicketButton.setBounds(374, 5, 200, 40);
    addTicketButton.setToolTipText("Allows user to add a ticket for a driver.");
    addTicketButton.addActionListener(this);

    //Select User Button
    final JButton selectUserButton = new JButton("Select User");
    selectUserButton.setBounds(585, 5, 200, 40);
    selectUserButton.setToolTipText("Display user information in the chart below: ");
    selectUserButton.addActionListener(this);
    //*****No more buttons to add. ******
    
    
    //*****All code below until noted is adding labels to the frame.******
    JLabel firstName = new JLabel("First Name: ");
    firstName.setFont(new Font("Serif", Font.PLAIN, 20));
    firstName.setBounds(5,100,130,40);
    frame.add(firstName);

    JLabel totalTickets = new JLabel("Total Tickets Cost: ");
    totalTickets.setFont(new Font("Serif", Font.PLAIN,20));
    totalTickets.setBounds(300,180,200,40);
    frame.add(totalTickets);

    JLabel lastName = new JLabel("Last Name: ");
    lastName.setBounds(5,140,130,40);
    lastName.setFont(new Font("Serif", Font.PLAIN, 20));
    frame.add(lastName);

    
    JLabel welcomeLabel = new JLabel("For Transportation Dept. Use Only. Use buttons above for functionality.");
    welcomeLabel.setBounds(10,60,800,40);
    welcomeLabel.setFont(new Font("Serif", Font.PLAIN,20));
    frame.add(welcomeLabel);

    JLabel email = new JLabel("Email: ");
    email.setBounds(5,180,100,40);
    email.setFont(new Font("Serif", Font.PLAIN, 20));
    frame.add(email);

    JLabel empID = new JLabel("Employee ID: ");
    empID.setBounds(5,220,150,40);
    empID.setFont(new Font("Serif", Font.PLAIN, 20));
    frame.add(empID);

    JLabel ageUser = new JLabel("Age: ");
    ageUser.setBounds(5,260,150,40);
    ageUser.setFont(new Font("Serif", Font.PLAIN, 20));
    frame.add(ageUser);

    JLabel phoneNo = new JLabel("Phone #: ");
    phoneNo.setBounds(5,300,150,40);
    phoneNo.setFont(new Font("Serif", Font.PLAIN, 20));
    frame.add(phoneNo);
    //****No more labels to add after this******

    //Constructing driversList to make sure it is init.
    driversList = new ArrayList<CustomerInformation>();
    
    //Adding two drivers in for testing and functionality.
    CustomerInformation testDriver = new CustomerInformation("Robert Hall","423","test@test.co",21,"1468684","4233819146");
    CustomerInformation testDriver_2 = new CustomerInformation("John Doe","421 Wallaby","tester@gmail.com",45,"1827457","4233009120");
    driversList.add(testDriver_2);
    driversList.add(testDriver);
    
    //Setting up panel
    panel = new JPanel();
    panel.setLayout(null);
  
    //Repainting the frame, adding all buttons, setting window size, and making it visable.
    frame.repaint();
    frame.revalidate();
    frame.add(newDriverButton);
    frame.add(clearDriverListButton);
    frame.add(addTicketButton);
    frame.add(selectUserButton);
    frame.add(panel);
    frame.pack();
    frame.setSize(850, 400);
    frame.setVisible(true);// making the frame visible
    

  }

  /**
     * This function gives the buttons functionality. All buttons have certain
     * values attached which allows us to distinguish and code certain buttons based
     * on if they are selected. Includes all button functionality.
     *
     * @param  An ActionEvent. Whenever a button is pressed this method is called.
     * @return None
     */
public void actionPerformed(final ActionEvent e) 
{ 
        final String s = e.getActionCommand(); 
        if (s.equals("New Driver"))
        { 
        
            final JTextField fName = new JTextField(5);
            final JTextField lName = new JTextField(5);
            final JTextField empID = new JTextField(5);
           // final JTextField truckTypeField = new JTextField(5);
            final JTextField email = new JTextField(5);
            final JTextField age = new JTextField(5);
            final JTextField phone = new JTextField(10);

            Object[] store = 
            {
              "First name:", fName,
              "Last Name:", lName,
              "Employee ID", empID,
              "Email:", email,
              "Age:", age,
              "Phone:", phone,

            };

            try
            {
              final int name = JOptionPane.showConfirmDialog(null, store,"Enter information for new driver.",JOptionPane.OK_CANCEL_OPTION);
              if(name == JOptionPane.OK_OPTION)
              {
                validation checker = new validation(driversList);
                int validationCheckPoint = checker.checkList(fName.getText(), lName.getText(),empID.getText());
                    
              if(validationCheckPoint == 1)
              {
                  JFrame errorFrame = new JFrame("test");
                  JDialog userError = new JDialog(errorFrame,"Error name already stored in database!");
                  JLabel errorMessage = new JLabel("  Error name already in base, make sure to re-enter info.");
                  errorMessage.setFont(new Font("Serif", Font.PLAIN, 20));
                  userError.setSize(475,200);
                  userError.setLocationRelativeTo(null);
                  userError.add(errorMessage);
                  userError.setVisible(true);

                
              }
            else
             {
                String firstName = fName.getText();
                String lastName = lName.getText();
                String full_name = (firstName + " " + lastName);
                String employeeID = empID.getText();
                String emailUser = email.getText();
                String ageUser = age.getText();
                String phoneUser = phone.getText();

                int intAge = Integer.parseInt(ageUser);     

                CustomerInformation user = new CustomerInformation(full_name,"test",emailUser,intAge,employeeID,phoneUser);



                this.driversList.add(user);

               

              }
            } }catch(Exception exception1)
              {
                JFrame errorFrame = new JFrame("Invalid Information Entered");
                JDialog userError = new JDialog(errorFrame,"Invalid Information Entered.");
                JLabel errorMessage = new JLabel(" Information for driver you have entered is invalid. Please try again.");
                errorMessage.setFont(new Font("Serif", Font.PLAIN, 20));
                userError.setSize(575,150);
                userError.setLocationRelativeTo(null);
                userError.add(errorMessage);
                userError.setVisible(true);
              }
            
            
         
        } 
        else if(s.equals("Remove driver."))  
        {
          final JTextField fName = new JTextField(5);
          final JTextField lName = new JTextField(5);
          final JTextField empID = new JTextField(5);
          

          Object[] store = 
          {
            "First name:", fName,
            "Last Name:", lName,
            "Employee ID", empID,
          };
          final int name = JOptionPane.showConfirmDialog(null, store,"Enter information to remove driver!",JOptionPane.OK_CANCEL_OPTION);
          if(name == JOptionPane.OK_OPTION)
          {
            validation checker = new validation(driversList);
           
           int validationCheckPoint = checker.checkList(fName.getText(), lName.getText(),empID.getText());
            
           if(validationCheckPoint != -1)
            {
              driversList.remove(validationCheckPoint);
              JFrame errorFrame = new JFrame("Driver Found");
              JDialog userError = new JDialog(errorFrame,"Removing Driver");
              JLabel errorMessage = new JLabel(" Removing driver from list!");
              errorMessage.setFont(new Font("Serif", Font.PLAIN, 20));
              userError.setSize(250,150);
              userError.setLocationRelativeTo(null);
              userError.add(errorMessage);
              userError.setVisible(true);
              

            }
            else
            {
              JFrame errorFrame = new JFrame("Driver Not Found");
              JDialog userError = new JDialog(errorFrame,"Driver with that information not found.");
              JLabel errorMessage = new JLabel("  Driver with that information not found.");
              errorMessage.setFont(new Font("Serif", Font.PLAIN, 20));
              userError.setSize(350,150);
              userError.setLocationRelativeTo(null);
              userError.add(errorMessage);
              userError.setVisible(true);
            }
          }
        }
        else if (s.equals("Select User"))
        {
            JFrame driverSelection = new JFrame("List of drivers. Viewable.");
            JDialog selectionScreen = new JDialog(driverSelection,"Select a driver.");
            CustomerInformation[] listNames = new CustomerInformation[driversList.size()];
            listNames = driversList.toArray(listNames);
            


            JList updated_list = new JList(listNames);
            JScrollPane newDriverist = new JScrollPane(updated_list);
            
            selectionScreen.setSize(200,400);
            selectionScreen.add(newDriverist);

            final JButton selectUserButton = new JButton("Select");
            selectUserButton.setToolTipText("Allows you to select a user for viewing.");
            selectionScreen.add(selectUserButton,BorderLayout.SOUTH);

            

            
            selectUserButton.addActionListener(new ActionListener() {
              @Override
              public void actionPerformed(ActionEvent e) 
              {
                JOptionPane.showConfirmDialog(frame,
                    "You Selected : " + updated_list.getSelectedValue(), "Display",
                    JOptionPane.PLAIN_MESSAGE);
                  CustomerInformation selected = (CustomerInformation) updated_list.getSelectedValue();
                  currentViewedUser = getValueInScrollPanel(updated_list);
                  displayUser();

              }
            });
           
            
            selectionScreen.setVisible(true);
            
        }
        else if(s.equals("Add Ticket"))
        {
          final JTextField fName = new JTextField(5);
          final JTextField lName = new JTextField(5);
          final JTextField empID = new JTextField(5);
          String[] truckType = {"Class A", "Class B","Class C"};
          final JTextField ticketPriceEntry = new JTextField(20);
          final JTextField truckWeightEntry = new JTextField(20);
          final JTextField truckSizeEntry = new JTextField(20);
          final JTextField axelNumberEntry = new JTextField(20);

          Object[] store = 
          {
            "First name:", fName,
            "Last Name:", lName,
            "Employee ID", empID,
            "Truck Type: ", truckType,
            ticketPriceEntry,
            "Truck Weight: ", truckWeightEntry,
            "Truck Size: ", truckSizeEntry,
            "Axel Number: ", axelNumberEntry,
          };

          try
          {
              final int name = JOptionPane.showConfirmDialog(null, store, "Enter information for a ticket for driver.",
              JOptionPane.OK_CANCEL_OPTION);
            if(name == JOptionPane.OK_OPTION)
            {
              validation checker = new validation(driversList);
            
            int validationCheckPoint = checker.checkList(fName.getText(), lName.getText(),empID.getText());
              
            if(validationCheckPoint != -1)
              {
                  if(ticketPriceEntry.getText().equals("Class A") || ticketPriceEntry.getText().equals("Class B") || ticketPriceEntry.getText().equals("Class C"))
                  {
                      Double weight = Double.parseDouble(truckWeightEntry.getText());
                      Double size = Double.parseDouble(truckSizeEntry.getText());
                      int axels = Integer.parseInt(axelNumberEntry.getText());
                      int classWeight = 0;
                      if(ticketPriceEntry.getText().equals("Class A"))
                      {
                          classWeight = 80;
                      }
                      else if(ticketPriceEntry.getText().equals("Class B"))
                      {
                          classWeight = 120;
                      }
                      else if(ticketPriceEntry.getText().equals("Class C"))
                      {
                          classWeight = 180;
                      }
                      else
                      {
                          classWeight = 80;
                      }
                      
                      TruckScale scale = new TruckScale(weight,size,axels,classWeight);
                      double cost = scale.ToPrice();
                      
                      currentViewedUser.addTicket(cost);
                      displayUser();
                  }
                  else
                  {
                    JFrame errorFrame = new JFrame("Invalid Information Entered");
                    JDialog userError = new JDialog(errorFrame,"Invalid Information Entered.");
                    JLabel errorMessage = new JLabel(" Truck Class information not entered Correctly, try again.");
                    errorMessage.setFont(new Font("Serif", Font.PLAIN, 20));
                    userError.setSize(500,150);
                    userError.setLocationRelativeTo(null);
                    userError.add(errorMessage);
                    userError.setVisible(true);
                  }
              

              }
              else
              {
                JFrame errorFrame = new JFrame("Driver Not Found");
                JDialog userError = new JDialog(errorFrame,"Driver with that information not found.");
                JLabel errorMessage = new JLabel("  Driver with that information not found.");
                errorMessage.setFont(new Font("Serif", Font.PLAIN, 20));
                userError.setSize(350,150);
                userError.setLocationRelativeTo(null);
                userError.add(errorMessage);
                userError.setVisible(true);
            }
         } } catch(Exception exception2)
              {
                JFrame errorFrame = new JFrame("Invalid Information Entered");
                JDialog userError = new JDialog(errorFrame,"Invalid Information Entered.");
                JLabel errorMessage = new JLabel(" Information for driver you have entered is invalid. Please try again.");
                errorMessage.setFont(new Font("Serif", Font.PLAIN, 20));
                userError.setSize(575,150);
                userError.setLocationRelativeTo(null);
                userError.add(errorMessage);
                userError.setVisible(true);
              }
        }
      }
     
    
  //Main method. Calls the creation of a new TruckScaleGUI which pulls up the GUI.
  public static void main(final String[] args)
  {
        final TruckScaleGUI test = new TruckScaleGUI();
  }  
}  