import java.util.Collections;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.IOException;
import java.io.File;

public class secretSanta {

	public static void main(String[] args) throws IOException {
		Scanner kb = new Scanner(System.in);
		int choice = 0;
		while (choice != 2) {
			int totalRecords = recordChecker(args[0]);
			ArrayList<Integer> numbers = numberGenerator(totalRecords);
			ArrayList<String> nameList = nameGenerator(args[0]);
			listPrinter(numbers, nameList, totalRecords);
			do {
				System.out.println("\n1) Reroll");
				System.out.println("2) Quit");
				System.out.print("Choice: ");
				choice = Integer.parseInt(kb.nextLine());
				System.out.println();
			} while(choice < 1 || choice > 2);
		}

	}

	public static ArrayList<Integer> numberGenerator(final int listSize) {
		ArrayList<Integer> tempList = new ArrayList<Integer>();
		for(int i = 0; i < listSize; i++) {
			tempList.add(i);
		}
    tempList.trimToSize();
		Collections.shuffle(tempList);

		return tempList;
	}

	public static ArrayList<String> nameGenerator(final String nameList) throws IOException {
		Scanner fileReader = new Scanner(new File(nameList));
		ArrayList<String> tempList = new ArrayList<String>();

		while(fileReader.hasNext()) {
			tempList.add(fileReader.nextLine());
		}

		fileReader.close();
       tempList.trimToSize();

		return tempList;
	}

	public static void listPrinter(ArrayList<Integer> numberList, ArrayList<String> nameList, final int listSize) {
		System.out.println("==============================================\n"
								+ "\tSecret Santa Pair List Results\n"
								+ "==============================================");

		for(int i = 0; i < listSize; i++) {
			int randNum = (int) numberList.get(i);
			String nameStart = nameList.get(i);
			String nameChosen = nameList.get(randNum);

			System.out.println("\t\t  " + nameStart + " : " + nameChosen);
		}
		System.out.print("==============================================");
	}

	public static int recordChecker(String fileName) throws IOException {
		Scanner fileReader = new Scanner(new File(fileName));
		int counter = 0;
		while(fileReader.hasNext()) {
			fileReader.nextLine();
			counter++;
		}
		fileReader.close();

		return counter;
	}
}
