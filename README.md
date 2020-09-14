<h1>Jet Project</h2>
Jet Project is my Week Three project in the Skill Distillery coding bootcamp.

<h2>Usage</h2>
This project allows the user to see information about a fleet of jets, such as Model name, speed, range, and price.

![Screen Shot 2020-09-14 at 04 55 34](https://user-images.githubusercontent.com/49802469/93077784-923f7f80-f646-11ea-94db-b20d797c260d.png)

The user can select the fastest and longest range jet from a preloaded list.

The user can execute commands to Fly, Load Cargo, and Fight from the main menu.

Jet Project also has the ability for the user to add and remove their own custom jet.

<h2>Development</h2>
The project pulls in a "ListOfJets" variable which is a field of the "AirField" class, then displays a menu with 9 options required by the assignment.
This data is read from a text file, "inputjets.txt"
For the import of the data of the 5 jets, I created a static method in the "JetsApplication" class which contains the main method,
the "GetJetsFromFile" method. This returns a list of jets that were assigned later to the "ListOfJets" field of the "AirField" object.

https://github.com/ashley-davis/JetsProject-/issues/3#issue-700993550
![Screen Shot 2020-09-14 at 04 57 49](https://user-images.githubusercontent.com/49802469/93077981-e9ddeb00-f646-11ea-8836-b20e5eb4aeff.png)

I created an abstract class "Jet", a class "JetImpl", which inherits from the class "Jet".
There are two interfaces "CargoCarrier" and "CombatReady" each with its own method ("LoadCargo" for the "CargoCarrier" interface and "Fight" for the "CombatReady" interface), and 5 other classes which represent 5 different types of jets. These inherit from the "Jet" class, and each implements one of the two interfaces depending on the jet type.

The "Jet" abstract class has 4 fields (model, range, speed, price). It contains a default constructor, a custom constructor with 4 parameters (model, range, speed and price), setters, getters, a "toString" method to display the details of an jet, and a "Fly" method. The Fly() method displays the details of a jet, calculates, and displays the amount of time the jet can fly until it runs out of fuel (by dividing the range by the speed). 
Classes that inherit from this class will also inherit its methods.
Any class that implements an interface will implement its specific method with a custom method body for each one.

![Screen Shot 2020-09-14 at 04 51 59](https://user-images.githubusercontent.com/49802469/93077531-2826da80-f646-11ea-91fb-7ca5f8a09fe6.png)

The first menu option allows the display of all jet details through the "toString" method of the "Jet" class.
The second menu option allows the call of the "Fly" method of the "Jet" class for all the jets and which displays their details and their flight times.
The third option displays the fastest jet by browsing the list of jets and obtaining the maximum value of the jet speeds.
The fourth option displays the jet with the longest tange by browsing the list of jets and obtaining the maximum value of jet ranges.
The fifth option calls the "LoadCargo" method for class objects that implement the "CargoCarrier" interface.
This consults the interfaces implemented by the class for each jet object. The "getClass().getInterfaces()" method returns a list of interfaces.
If the "CargoCarrier" interface is present, then the object has the "LoadCargo" method. This method is called with "CargoCarrier" cast: ((CargoCarrier)jetObject).
The sixth option calls the "Fight" method for class objects that implement the "CombatReady" interface.
For the "CombatReady" interface, the "Fight" method is called with a "CombatReady" Cast: ((CombatReady)jetObject).
The seventh option allows the user to insert a new custom Jet object at the jets list after selecting the type choice and entering data.
According to the user's choice, an object is created and added to the "ListOfJets" list of the "AirField" object with a Cast according to the chosen type.
The eighth option allows the user to remove a jet from the jets list by selecting the assigned number. Removal is done using the "Remove()" method (ArrayList method).
The ninth option breaks the loop, and quits the program.

<h2>Built With</h2>
Eclipse IDE

<h2>Author</h2>
Ashley Davis

<h2>Acknowledgements</h2>
Head First Java by Bert and Kathy Bates,
GeekforGeek.com, and many Java dev blogs,
StackOverflow.com

<h2>Special Thanks</h2>
Gray Morrow,
Gabriel Davis,
Cowboy and Garbanzo Davis,
Classmates of the Skill Distillery 27 Cohort
