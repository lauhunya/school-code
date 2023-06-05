package java_final;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;
import javax.swing.JOptionPane;

public class java_final {
	public static void main(String[] args) {
		final_project project = new final_project();

		int selection;

		project.read_flight();
		project.read_reservation();

		selection = project.Menu();
		while (selection != 4) {
			if (selection == 1)
				project.add_flight();
			else if (selection == 2)
				project.add_reservation();
			else if (selection == 3)
				project.report();
			selection = project.Menu();
		}
		System.exit(0);

	}
}

class final_project {
	int readFlightCount = -1;
	int readReservationCount = -1;
	int[] flightNum = new int[100];
	String[] flightCityOrigin = new String[100];
	String[] flightCityDest = new String[100];
	String[] flightDate = new String[100];
	String[] flightTime = new String[100];
	int[] flightSeat = new int[100];

	int[] resCode = new int[100];
	int[] flightNum2 = new int[100];
	String[] lastName = new String[100];
	String[] firstName = new String[100];
	String[] seatType = new String[100];
	Double[] seatCost = new Double[100];

	public void read_flight() {
		String newLine;
		try {
			BufferedReader flight_file = new BufferedReader(new FileReader("flightj.dat"));
			while ((newLine = flight_file.readLine()) != null) {
				StringTokenizer delimiter = new StringTokenizer(newLine, "#");
				readFlightCount = readFlightCount + 1;
				flightNum[readFlightCount] = Integer.parseInt(delimiter.nextToken());
				flightCityOrigin[readFlightCount] = delimiter.nextToken();
				flightCityDest[readFlightCount] = delimiter.nextToken();
				flightDate[readFlightCount] = delimiter.nextToken();
				flightTime[readFlightCount] = delimiter.nextToken();
				flightSeat[readFlightCount] = Integer.parseInt(delimiter.nextToken());

			}
			flight_file.close();
		} catch (IOException error) {
			System.out.println("Error on file read" + error);

		}
	}

	public void read_reservation() {
		String newLine;
		try {
			BufferedReader reservation_file = new BufferedReader(new FileReader("reservationj.dat"));
			while ((newLine = reservation_file.readLine()) != null) {
				StringTokenizer delimiter = new StringTokenizer(newLine, "#");
				readReservationCount = readReservationCount + 1;
				resCode[readReservationCount] = Integer.parseInt(delimiter.nextToken());
				flightNum2[readReservationCount] = Integer.parseInt(delimiter.nextToken());
				lastName[readReservationCount] = delimiter.nextToken();
				firstName[readReservationCount] = delimiter.nextToken();
				seatType[readReservationCount] = delimiter.nextToken();
				seatCost[readReservationCount] = Double.parseDouble(delimiter.nextToken());

			}
			reservation_file.close();
		} catch (IOException error) {
			System.out.println("Error on file read" + error);
		}
	}

	public void add_flight() {
		String value;
		int flightNumber;

		readFlightCount++;

		String flightNum1 = "What is the flight number?";
		value = JOptionPane.showInputDialog(null, flightNum1, "", JOptionPane.QUESTION_MESSAGE);
		flightNumber = Integer.parseInt(value);
		flightNum[readFlightCount] = flightNumber;

		String userFlightOrigin = "Where is your flight departing from?";
		value = JOptionPane.showInputDialog(null, userFlightOrigin, "", JOptionPane.QUESTION_MESSAGE);
		flightCityOrigin[readFlightCount] = value;

		String userFlightDes = "Where is your flight's destination?";
		value = JOptionPane.showInputDialog(null, userFlightDes, "", JOptionPane.QUESTION_MESSAGE);
		flightCityDest[readFlightCount] = value;

		String userFlightDate = "What is the date of your flight?";
		value = JOptionPane.showInputDialog(null, userFlightDate, "", JOptionPane.QUESTION_MESSAGE);
		flightDate[readFlightCount] = value;

		String userFlightTime = "What is the time of your flight?";
		value = JOptionPane.showInputDialog(null, userFlightTime, "", JOptionPane.QUESTION_MESSAGE);
		flightTime[readFlightCount] = value;

		String userSeatNum = "What seat number are you in?";
		value = JOptionPane.showInputDialog(null, userSeatNum, "", JOptionPane.QUESTION_MESSAGE);
		int seatNum = Integer.parseInt(value);
		flightSeat[readFlightCount] = seatNum;

	}

	public void add_reservation() {
		String value;

		readReservationCount++;

		String userFlightCode = "What is the flight code?";
		value = JOptionPane.showInputDialog(null, userFlightCode, "", JOptionPane.QUESTION_MESSAGE);
		int flightcode1 = Integer.parseInt(value);
		resCode[readReservationCount] = flightcode1;

		String userFlightNum = "What is the flight number?";
		value = JOptionPane.showInputDialog(null, userFlightNum, "", JOptionPane.QUESTION_MESSAGE);
		int flightnum1 = Integer.parseInt(value);
		flightNum2[readReservationCount] = flightnum1;

		String userLastName = "What is your last name?";
		value = JOptionPane.showInputDialog(null, userLastName, "", JOptionPane.QUESTION_MESSAGE);
		lastName[readReservationCount] = value;

		String userFirstName = "What is your first name?";
		value = JOptionPane.showInputDialog(null, userFirstName, "", JOptionPane.QUESTION_MESSAGE);
		firstName[readReservationCount] = value;

		String userSeatType = "What is your seat type?";
		value = JOptionPane.showInputDialog(null, userSeatType, "", JOptionPane.QUESTION_MESSAGE);
		seatType[readReservationCount] = value;

		String userSeatCost = "What is the cost of the seat?";
		value = JOptionPane.showInputDialog(null, userSeatCost, "", JOptionPane.QUESTION_MESSAGE);
		Double seatCostNum = Double.parseDouble(value);
		seatCost[readReservationCount] = seatCostNum;

	}

	public void report() {
		int selection;
		int i;
		int j;
		String value;
		String words = "Acme Airlines" + "\n" + "1.  All flight Info" + "\n" + "2.  All Reservation Info" + "\n"
				+ "3.  Value of reservations of a specific type" + "\n" + "4.  All Reservations on a specific flight"
				+ " \n" + "5.  All flights from a specific city" + " \n" + "6.  Specific reservation information"
				+ " \n" + "7.  Summary of all flights" + "\n" + "8.  Exit Report Menu" + "\n"
				+ "    Please make your selection ";
		value = JOptionPane.showInputDialog(null, words, "Input Data", JOptionPane.QUESTION_MESSAGE);
		selection = Integer.parseInt(value);

		while (selection != 8) {

			if (selection == 1) {
				System.out.println("\n" + "All Flight Information:\n");

				for (i = 0; i <= readFlightCount; i++) {
					System.out.println(flightNum[i] + " " + flightCityOrigin[i] + " " + flightCityDest[i] + " "
							+ flightDate[i] + " " + flightTime[i] + " " + flightSeat[i] + "\n");
				}
			} // end of report 1

			else if (selection == 2) {
				System.out.println("\n" + "All Reservation Information:\n");

				for (i = 0; i <= readReservationCount; i++) {
					System.out.println(resCode[i] + " " + flightNum2[i] + " " + lastName[i] + " " + firstName[i] + " "
							+ seatType[i] + " " + seatCost[i] + "\n");
				}
			} // end of report 2

			else if (selection == 3) {

				value = "Enter the seat type you are searching for (Business, Coach, First): ";
				value = JOptionPane.showInputDialog(null, value, "", JOptionPane.QUESTION_MESSAGE);

				System.out.println("The reservations with " + value + " class are: \n");
				for (i = 0; i <= readReservationCount; ++i) {
					if (seatType[i].equalsIgnoreCase(value)) {
						System.out.println(resCode[i] + " " + flightNum2[i] + " " + lastName[i] + " " + firstName[i]
								+ " " + seatType[i] + " " + seatCost[i] + "\n");
					}

				}
			} // end of report 3
			else if (selection == 4) {
				value = "Enter your flight number: ";
				value = JOptionPane.showInputDialog(null, value, "", JOptionPane.QUESTION_MESSAGE);
				int flightNum4 = Integer.parseInt(value);
				
				System.out.println("The reservations with the flight number " + flightNum4 + " are: \n");
				for (i = 0; i <= readFlightCount; ++i) {
					if (flightNum[i]==flightNum4) {
						System.out.println(flightNum[i] + " " + flightCityOrigin[i] + " " + flightCityDest[i] + " "
								+ flightDate[i] + " " + flightTime[i] + " " + flightSeat[i] + "\n");
					}

				}
			} // end of report 4
			else if (selection == 5) {
				int flightCityOrginCount=0;
				value = "Enter the departing city you are searching for: ";
				value = JOptionPane.showInputDialog(null, value, "", JOptionPane.QUESTION_MESSAGE);

				System.out.println("The reservations with the departing city " + value + " are: \n");
				for (i = 0; i <= readFlightCount; ++i) {
					if (flightCityOrigin[i].equalsIgnoreCase(value)) {
						System.out.println(flightNum[i] + " " + flightCityOrigin[i] + " " + flightCityDest[i] + " "
								+ flightDate[i] + " " + flightTime[i] + " " + flightSeat[i] + "\n");
						flightCityOrginCount++;
					}
				}
				
				System.out.println("The number of reservations from " + value + " is " + 
				flightCityOrginCount);
			} // end of report 5
			else if (selection == 6) {
				value = "Enter your reservation code: ";
				value = JOptionPane.showInputDialog(null, value, "", JOptionPane.QUESTION_MESSAGE);
				int resCodeNum = Integer.parseInt(value);
				
				System.out.println("The reservations with the reservation code " + resCodeNum + " are: \n");
				for (i = 0; i <= readReservationCount; ++i) {
					if (resCode[i]==resCodeNum) {
						System.out.println(resCode[i] + " " + flightNum2[i] + " " + lastName[i] + " " + firstName[i]
								+ " " + seatType[i] + " " + seatCost[i] + "\n");
					}

				}
				
				for (j = 0; j <= readFlightCount; ++j) {
					if (flightNum2[i]==flightNum[j]) {
						System.out.println(flightNum[j] + " " + flightCityOrigin[j] + " " + flightCityDest[j] + " "
								+ flightDate[j] + " " + flightTime[j] + " " + flightSeat[j] + "\n");
					}

				}
			} // end of report 6
			else if (selection == 7) {
				for (i = 0; i <= readFlightCount; i++) {
					System.out.println(flightNum[i] + " " + flightCityOrigin[i] + " " + flightCityDest[i] + " "
							+ flightDate[i] + " " + flightTime[i] + " " + flightSeat[i] + "\n");
					
					for (j = 0; j <= readReservationCount;j++) {
						if (flightNum[i]==flightNum2[j]) {
							System.out.println(resCode[j] + " " + flightNum2[j] + " " + lastName[j] + " " + firstName[j]
									+ " " + seatType[j] + " " + seatCost[j] + "\n");
						}

					}
				}
			} // end of report 7
			value = JOptionPane.showInputDialog(null, words, "Input Data", JOptionPane.QUESTION_MESSAGE);
			selection = Integer.parseInt(value);
		} // end of while loop
	}// end of report

	public int Menu() {
		int selection;
		String words, data;
		words = "Acme Airline " + "\n" + "\n" + "1. Add Flight" + "\n" + "2. Add Reservation" + "\n"
				+ "3. Report Section" + "\n" + "4. Exit the system" + "\n" + "\n" + "Please Make your selection>";
		data = JOptionPane.showInputDialog(null, words, "Acme Airline ", JOptionPane.QUESTION_MESSAGE);
		selection = Integer.parseInt(data);
		return selection;
	}

}
