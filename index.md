
<html>
<body>
  <h1>Truck Scale GUI program</h1>
<p>Located on the side of highways, truck scale stations are important in keeping track of truck traffic on highways. This program is a basic GUI to simulate what a program would look like at a truck scale station. The program allows users to: Add a driver, remove a driver, add a ticket to an already registered driver, and view and select a driver. Created as a final project for a Java programming class.
  <br><br>
Concepts used: <br>
  
  <ul>
    <li>Classes</li>
    <li>Object-Oriented Programming</li>
    <li>Java Swing Framework</li>
  </ul>
  
  <h2>Program Overview</h2>
  <h3>Adding a user</h3>
    <p>
      The starting menu of our program gives us a variety of information and options to choose from. Since no users have been selected, information regarding a driver is not displayed. When a user is selected the information on the main menu is updated.
  <br>
    <img src="Main Menu.png">  
  <br>
    Users can either be added by the "New Driver" button. Upon clicking on the New Driver button, a menu will popup to allow the user to enter information regarding this new driver. 
    <img src="New Driver Menu.png">
  <br>
  Information will need to be inputted by the user into the dialog boxes. Behind the scenes there is input validation that checks the input whenever the "OK" button is pressed. Just like the adage goes: Garbage in, garbade out. This validation is put forth to prevent the user from entering trash data that will not work correctly in our context. Not only can we add a new driver, we can also remove a driver. 
  <h3>Removing a driver</h3>
 
  Pictured below is similar to the addition menu, except instead specific information regarding the user will need to be entered to find the exact driver the user is looking to remove.
  <br>
    <img src="Remove Driver.png">
  <br>
  This information is then used to scan through the stored list of users to check and see if the user is in the list. If it is not it will return an error message. A linear search is used to iterate though the driver list, while using the get methods to check to see if there is a user.
  <br>
  <h3>Adding a ticket to a driver</h3>
  
  Just like in a normal truck weight station, needing to add a ticket to that driver is important. In the menu pictured below, same information has to be entered as if we were removing a user. However, for this menu it requires information about the driver's vehicle including: Truck Type, Weight, Size, and number of axels. 
    <img src="New Ticket for Driver.png">
    <br>
    Just like the other form entry menus, input validation is used here to make sure garbage data is not entered. If the information is valid, a ticket price is added to the driver.
    <br>
   <h3>Selecting a driver</h3>
   
   One of the most important features of the program: Selecting a user for viewing. Upon clicking the "Select User" button, the menu with avaliable users will be shown, allowing user to select a driver.
    <img src="Select Driver.png">
    <br>
     Now that we have the menu pulled up we can select either user to view their information.
    <br>
    <img src="Selected Driver.png">
    <br>
      As we can see upon driver selection, information on the main menu is updated with the respective driver. The user can then look at other drivers, or use the other functionality the program provides. Whenever a new user is selected, old information is wiped and new information is drawn inplace.
      <br>
    <h3>Conclusion and thoughts</h3>
     Overall this project was very fun to work on. Using all the previous concepts learned and accumulating them to make a GUI program is a great learning task. The project is free to download and modify. I hope someone will use this as a reference for basic Java Swing GUI programs. Want to thank me or discuss this? Contact information below:
     <br>
     Email: robertisaachallrih@gmail.com
     <br>
     LinkedIn: https://www.linkedin.com/in/robertisaachall/
     <br>
     Github: https://github.com/robertisaachall
     <br>
  
</p>

</body>
</html> 
