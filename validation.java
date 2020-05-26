/**
 * Class that is used in the TruckScaleGUI program.
 * An arraylist of CustomerInformation is passed in and returns if the
 * user is in the list or not. Used to adding user, deleting user, and adding tickets.
 *
 * @author Robert Burton , Robert Hall , Colton Edwards
 * @version 4/22/2020 Final
 */

import java.util.*;
public class validation
{
    private ArrayList<CustomerInformation> dvrList;

    /**
     * Constructor for the class.
     * @param Takes in an ArrayList of CustomerInformation and keeps it for the method.
     */

    validation(ArrayList<CustomerInformation> list)
    {
        this.dvrList = list;
    }
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param fname : First Name of Driver
     * @param lName : Last Name of Driver
     * @param empID: Employee ID of Driver.
     * @return Returns -1 if the driver is not in the list, returns index in array if user is in the list.
     */
    public int checkList(String fName, String lName, String empID)
    {
        for(int i = 0; i < dvrList.size(); i++)
        {
            CustomerInformation dvrName = dvrList.get(i);
            String[] fullName = dvrName.toString().split("\\s+");
            String driverFirstName = fullName[0];
            String driverLastName = fullName[1];
            String selectedEmpID = dvrName.getEmpID();

            

            if(fName.equals(driverFirstName) == true && lName.equals(driverLastName) == true && empID.equals(selectedEmpID))
            {
                return i;
            }
        }

        return -1;
    }


}