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
		String model = null;
		double range = 0, speed = 0, price = 0;
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
				System.out.println("\nFlight Time: ");
				for (int i = 0; i < program.airField.getListOfJets().size(); i++) { // loop
					program.airField.getListOfJets().get(i).fly(); // call a fly method for each jet
				}
				;
				break;
			case '3': // if choice equals '3'
				int rank = 0; // initialize the rank of the fastest jet to 0
				double fastest = program.airField.getListOfJets().get(rank).getSpeed(); // initialize the high speed
																						// value to
				// the first speed value
				for (int i = 1; i < program.airField.getListOfJets().size(); i++) // loop
					if (fastest < program.airField.getListOfJets().get(i).getSpeed()) {
						fastest = program.airField.getListOfJets().get(i).getSpeed(); // update the fastest value with a
																						// highest
						// value if exists
						rank = i; // update the rank value if exists
					}
				System.out.println("\nFastest Jet:\n" + program.airField.getListOfJets().get(rank).toString());
				break;
			case '4': // if choice equals '4'
				int rankRange = 0; // initialize the rank of the longest jet to 0
				double longest = program.airField.getListOfJets().get(rankRange).getRange(); // initialize the high
																								// range value
				// to the first range value
				for (int i = 1; i < program.airField.getListOfJets().size(); i++) // loop
					if (longest < program.airField.getListOfJets().get(i).getRange()) {
						longest = program.airField.getListOfJets().get(i).getRange(); // update the longest value with a
																						// highest
						// value if exists
						rankRange = i; // update the rank value if exists
					}
				System.out.println("\nLongest Range:\n" + program.airField.getListOfJets().get(rankRange).toString());
				break;
			case '5': // if choice equals '5'

				for (Jet jet : program.airField.getListOfJets()) {

					try {
						((CargoCarrier) jet).loadCargo();
					} catch (ClassCastException e) {
						continue;
					}
				}
//					}

				break;
			case '6': // if choice equals '6'
				for (Jet jet : program.airField.getListOfJets()) {

					try {
						((FighterJet) jet).fight();
					} catch (ClassCastException e) {
						continue;
					}
				}
				break;
			case '7': // if choice equals '7'
				// Jet newJet = new JetImpl();
				System.out.println("\nChoose a type for the jet:");
				System.out.println("1. Airliner Jet.");
				System.out.println("2. Cargo Jet.");
				System.out.println("3. Fighter Jet.");
				System.out.println("4. Bomber Jet.");
				System.out.println("5. Interceptor Jet.");
				System.out.println("6. Cancel.");
				System.out.println("Choice :");

				choice = scanner.nextLine().charAt(0); // set the "choice" value to the 1st character of the text typed
														// by the user
				if (choice == '1' || choice == '2' || choice == '3' || choice == '4' || choice == '5') {
					System.out.println("\nType the model of the jet:");
					model = scanner.nextLine();
					// newJet.setModel(model);
					System.out.println("\nType the range of the jet:");
					range = scanner.nextDouble();
					// newJet.setRange(range);
					System.out.println("\nType the speed of the jet:");
					speed = scanner.nextDouble();
					// newJet.setSpeed(speed);
					System.out.println("\nType the price of the jet:");
					price = scanner.nextDouble();
					// newJet.setPrice(price);
				}
				switch (choice) {
				case '1': // choice equals '1'
					Jet newAirjet = new AirlinerJet(model, range, speed, price);
					program.airField.getListOfJets().add((AirlinerJet) newAirjet);
					break;
				case '2': // if choice equals '2'
					Jet newCargojet = new CargoJet(model, range, speed, price);
					program.airField.getListOfJets().add((CargoJet) newCargojet);
					break;
				case '3': // if choice equals '3'
					Jet newFightjet = new FighterJet(model, range, speed, price);
					program.airField.getListOfJets().add((FighterJet) newFightjet);
					break;
				case '4': // if choice equals '4'
					Jet newBombjet = new BomberJet(model, range, speed, price);
					program.airField.getListOfJets().add((BomberJet) newBombjet);
					break;
				case '5': // if choice equals '5'
					Jet newInterjet = new InterceptorJet(model, range, speed, price);
					program.airField.getListOfJets().add((InterceptorJet) newInterjet);
					break;
				default: // if the choice value is not in the set {1, 2, 3, 4, 5}
					break;
				}
				break;
			case '8': // if choice equals '8'
				System.out.println("\nChoose a jet you want to remove by number:");
				for (int i = 0; i < program.airField.getListOfJets().size(); i++) { // loop
					System.out
							.println(String.valueOf(i + 1) + ". " + program.airField.getListOfJets().get(i).toString());
				}
				System.out.println(String.valueOf(program.airField.getListOfJets().size() + 1) + ". Cancel.");
				System.out.println("Choice :");
				choice = scanner.nextLine().charAt(0); // set the "choice" value to the 1st character of the text typed
														// by the user
				if (Character.getNumericValue(choice) > 0
						&& Character.getNumericValue(choice) <= program.airField.getListOfJets().size()) {
					program.airField.getListOfJets().remove(Character.getNumericValue(choice) - 1);
				}
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

}