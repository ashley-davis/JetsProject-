<h1>Jet Project</h2>
Jet Project is my Week Three project in the Skill Distillery coding bootcamp.

<h2>Usage</h2>
This project allows the user to see information about a fleet of jets, such as Model name, speed, range, and price.
The user can select the fastest and longest range jet from a preloaded list.
The user can execute commands to Fly, Load Cargo, and Fight from the main menu.
Jet Project also has the ability for the user to add and remove their own custom jet.

<h2>Development</h2>
in a "ListOfJets" variable which is a field of the "AirField" class,
it allows the display of a menu with 9 options given by the assignment document.
data is read from a text file named "inputjets.txt"
for the import of the data of the 5 jets, we created a static method in the "JetsApplication" class which contains the main method,
this is the "GetJetsFromFile" method which returns a list of jets that were assigned later to the "ListOfJets" field of the "AirField" object.




We have created an abstract class "Jet", a class "JetImpl" which inherits from the class "Jet",

two interfaces "CargoCarrier" and "CombatReady" each with its own method ("LoadCargo" for the "CargoCarrier" interface and "Fight" for the "CombatReady" interface),
and 5 other classes which represent 5 different types of jets, which inherit from the "Jet" class and which each implements one of the two interfaces depending on the jet type.
the "Jet" abstract class has 4 fields (model, range, speed, price), it contains a default constructor, a custom constructor with 4 parameters (model, range, speed and price), setters, getters,
a "toString" method to display the details of an jet, and a "Fly" method to display the details of a jet and calculate and display the amount of time the jet can fly until it runs out of fuel (by divinding the range by the speed).
classes that inherit from this class will also inherit its methods.
Any class that implements an interface will implement its specific method with a custom method body for each one.
the first menu option allows the display of all jet details through the "toString" method of the "Jet" class.
the second menu option allows the call of the "Fly" method of the "Jet" class for all the jets and which displays their details and their flight times.
the third option allows to display the fastest jet by browsing the list of jets and obtaining the maximum value of the jet speeds.
the fourth option allows to display the jet with the longest tange by browsing the list of jets and obtaining the maximum value of jet ranges.
the fifth option calls the "LoadCargo" method for class objects that implement the "CargoCarrier" interface.
we must therefore consult the interfaces implemented by the class for each jet object. the consultation is made by the "getClass().getInterfaces()" method which returns a list of interfaces.
we go through this list, if the "CargoCarrier" interface is part then we are sure that the object has the "LoadCargo" method, we therefore call this method after a "CargoCarrier" cast (like this (CargoCarrier)jetObject).
the sixth option calls the "Fight" method for class objects that implement the "CombatReady" interface.
we do the same for the "CombatReady" interface and we call on the "Fight" method after a "CombatReady" Cast (like this (CombatReady)jetObject).
the seventh option allows the user to insert a new Jet object at the jets list after selecting the type choice and entering data.
according to the user's choice, we create an object and add it to the "ListOfJets" list of the "AirField" object with a Cast according to the chosen type.
the eighth option allows the user to remove a jet from the jets list after being selected according to its number. removal is done using the "Remove()" method (ArrayList method).
the ninth option allows the user to break the loop, and quit the program.


