package com.skilldistillery.jet;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JetsApplication {
	private AirField airField;

	public JetsApplication() {
		airField = new AirField(GetJetsFromFile("inputjets.txt"));
	}

	public static void main(String[] args) {

		Scanner scanner; // scanner for input
		JetsApplication program = new JetsApplication();
//		String model = null;
//		double range = 0, speed = 0, price = 0;
		char choice;
		program.printGreeting();

		do { // loop
			program.printMenu();
			scanner = new Scanner(System.in); // initialize the scanner

			System.out.print("Make a selection: ");
			choice = scanner.nextLine().charAt(0);

			switch (choice) {
			case '1': // if choice equals '1'
				program.printJets();
				break;
			case '2': // if choice equals '2'
				program.printFlightTime();
				break;
			case '3': // if choice equals '3'
				program.fastestJet();
				break;
			case '4': // if choice equals '4'
				program.longestRange();
				break;
			case '5': // if choice equals '5'
				program.allCargoJets();
				break;
			case '6': // if choice equals '6'
				program.dogFight();
				break;
			case '7': // if choice equals '7'
				// Jet newJet = new JetImpl();
				program.addJet();
				break;
			case '8': // if choice equals '8'
				program.removeJet();
				break;
			case '9': // if choice equals '9'
				System.out.println("\nYou chose to quit the program");
				break;
			default: // if choice value is not in the set {1, 2, 3, 4, 5, 6, 7, 8}
				System.out.println("\nThat's not a valid choice. Enter a number between 1- 9: ");
				break;
			}
		} while (choice != '9'); // loop until the user types '9'
		scanner.close();
	}

	public ArrayList<Jet> GetJetsFromFile(String fileName) {
		ArrayList<Jet> list = new ArrayList<Jet>();
		File file = new File(fileName);
		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader(file));
			String line;
			while ((line = br.readLine()) != null) {
				String[] infos = line.split("\\,|\t");
				switch (infos[0]) {
				case "AirlinerJet":
					list.add(new AirlinerJet(infos[1], Double.valueOf(infos[2]), Double.valueOf(infos[3]),
							Double.valueOf(infos[4])));
					break;
				case "CargoJet":
					list.add(new CargoJet(infos[1], Double.valueOf(infos[2]), Double.valueOf(infos[3]),
							Double.valueOf(infos[4])));
					break;
				case "FighterJet":
					list.add(new FighterJet(infos[1], Double.valueOf(infos[2]), Double.valueOf(infos[3]),
							Double.valueOf(infos[4])));
					break;
				case "BomberJet":
					list.add(new BomberJet(infos[1], Double.valueOf(infos[2]), Double.valueOf(infos[3]),
							Double.valueOf(infos[4])));
					break;
				case "InterceptorJet":
					list.add(new InterceptorJet(infos[1], Double.valueOf(infos[2]), Double.valueOf(infos[3]),
							Double.valueOf(infos[4])));
					break;
				default:
					list.add(new AirlinerJet(infos[1], Double.valueOf(infos[2]), Double.valueOf(infos[3]),
							Double.valueOf(infos[4])));
					break;
				}
			}
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return list;
	}

	private void printGreeting() {
		System.out.println("Welcome to Jets: Week Three Project by Ashley Davis. ");
	}

	private void printMenu() {
		System.out.println();
		System.out.println("================ MENU ==================");
		System.out.println("|                                      |");
		System.out.println("|   1. List fleet                      |");
		System.out.println("|   2. Fly all jets                    |");
		System.out.println("|   3. View fastest jet                |");
		System.out.println("|   4. View jet with longest range     |");
		System.out.println("|   5. Load all cargo jets             |");
		System.out.println("|   6. Dogfight!                       |");
		System.out.println("|   7. Add a jet to fleet              |");
		System.out.println("|   8. Remove a jet from fleet         |");
		System.out.println("|   9. Quit                            |");
		System.out.println("|                                      |");
		System.out.println("|                                      |");
		System.out.println("========================================");
		System.out.println();
	}

	public void printJets() {
		System.out.println("\nFleet List: ");
		for (int i = 0; i < airField.getListOfJets().size(); i++) { // loop
			System.out.println(airField.getListOfJets().get(i).toString()); // display all jets info
		}
	}

	private void printFlightTime() {
		System.out.println("\nFlight Time: ");
		for (int i = 0; i < airField.getListOfJets().size(); i++) { // loop
			airField.getListOfJets().get(i).fly(); // call a fly method for each jet
		}
	}

	private void fastestJet() {
		int rank = 0; // initialize the rank of the fastest jet to 0
		double fastest = airField.getListOfJets().get(rank).getSpeed(); // initialize the high speed
		for (int i = 1; i < airField.getListOfJets().size(); i++) // loop
			if (fastest < airField.getListOfJets().get(i).getSpeed()) {
				fastest = airField.getListOfJets().get(i).getSpeed(); // update the fastest value with a
				// value if exists
				rank = i; // update the rank value if exists
			}
		System.out.println("\nFastest Jet:\n" + airField.getListOfJets().get(rank).toString());
	}

	private void longestRange() {
		int rankRange = 0; // initialize the rank of the longest jet to 0
		double longest = airField.getListOfJets().get(rankRange).getRange(); // initialize the high
																				// range value
		// to the first range value
		for (int i = 1; i < airField.getListOfJets().size(); i++) // loop
			if (longest < airField.getListOfJets().get(i).getRange()) {
				longest = airField.getListOfJets().get(i).getRange(); // update the longest value with a highest value
			}
		System.out.println("\nLongest Range:\n" + airField.getListOfJets().get(rankRange).toString());
	}

	private void allCargoJets() {
		for (Jet jet : airField.getListOfJets()) {
			try {
				((CargoCarrier) jet).loadCargo();
			} catch (ClassCastException e) {
				continue;
			}
		}
	}

	private void dogFight() {
		for (Jet jet : airField.getListOfJets()) {
			try {
				((FighterJet) jet).fight();
			} catch (ClassCastException e) {
				continue;
			}
		}
		System.out.println("Pew!.........................");
		System.out.println("............Pew!.............");
		System.out.println(".....................Pew!....");
	}

	private void addJet() {
		String model = null;
		double range = 0, speed = 0, price = 0;
		char choice;

		System.out.println("\nChoose a type for the jet:");
		System.out.println("1. Airliner Jet.");
		System.out.println("2. Cargo Jet.");
		System.out.println("3. Fighter Jet.");
		System.out.println("4. Bomber Jet.");
		System.out.println("5. Interceptor Jet.");
		System.out.println("6. Cancel.");
		System.out.println("Choice :");

		Scanner scanner = new Scanner(System.in); // initialize the scanner;
		choice = scanner.nextLine().charAt(0); // set the "choice" value to the 1st character of the text typed
												// by the user
		if (choice == '1' || choice == '2' || choice == '3' || choice == '4' || choice == '5') {
			System.out.println("\nEnter jet model:");
			model = scanner.nextLine();
			// newJet.setModel(model);
			System.out.println("\nEnter jet range:");
			range = scanner.nextDouble();
			// newJet.setRange(range);
			System.out.println("\nEnter jet speed:");
			speed = scanner.nextDouble();
			// newJet.setSpeed(speed);
			System.out.println("\nEnter jet price:");
			price = scanner.nextDouble();
			// newJet.setPrice(price);
		}
		switch (choice) {
		case '1': // choice equals '1'
			Jet newAirjet = new AirlinerJet(model, range, speed, price);
			airField.getListOfJets().add((AirlinerJet) newAirjet);
			break;
		case '2': // if choice equals '2'
			Jet newCargojet = new CargoJet(model, range, speed, price);
			airField.getListOfJets().add((CargoJet) newCargojet);
			break;
		case '3': // if choice equals '3'
			Jet newFightjet = new FighterJet(model, range, speed, price);
			airField.getListOfJets().add((FighterJet) newFightjet);
			break;
		case '4': // if choice equals '4'
			Jet newBombjet = new BomberJet(model, range, speed, price);
			airField.getListOfJets().add((BomberJet) newBombjet);
			break;
		case '5': // if choice equals '5'
			Jet newInterjet = new InterceptorJet(model, range, speed, price);
			airField.getListOfJets().add((InterceptorJet) newInterjet);
			break;
		default: // if the choice value is not in the set {1, 2, 3, 4, 5}
			break;
		}
		scanner.close();
	}

	private void removeJet() {
		char choice;
		Scanner scanner = new Scanner(System.in); // initialize the scanner;
		choice = scanner.nextLine().charAt(0); // set the "choice" value to the 1st character of the text typed

		System.out.println("\nChoose a jet you want to remove by number:");
		for (int i = 0; i < airField.getListOfJets().size(); i++) { // loop
			System.out.println(String.valueOf(i + 1) + ". " + airField.getListOfJets().get(i).toString());
		}
		System.out.println(String.valueOf(airField.getListOfJets().size() + 1) + ". Cancel.");
		System.out.println("Choice :");
		choice = scanner.nextLine().charAt(0); // set the "choice" value to the 1st character of the text typed
												// by the user
		if (Character.getNumericValue(choice) > 0
				&& Character.getNumericValue(choice) <= airField.getListOfJets().size()) {
			airField.getListOfJets().remove(Character.getNumericValue(choice) - 1);
		}
		scanner.close();
	}
}
