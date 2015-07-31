import java.io.IOException;
import java.util.Scanner;

public class Run {

	public static DynamicHashTable dht = new DynamicHashTable();
	public static LinearHashTable lht = new LinearHashTable();
	public static Scanner in = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		SpellChecker.entryPoint ="system";
		testTable();
		System.out.println("We're going to work with the Dynamic Hash Table.");
		SpellChecker.hashTableType = "dynamic";
		SpellChecker.dht=dht;
		System.out.println("Next let's import a dictionary file.");
		SpellChecker.importDictionary("Dictionary1.txt");
		//System.out.println("Let's print the loaded dictionary...");
		//SpellChecker.printDictionary();
		System.out.println("Give me the address of a test document: ");
		String address  = in.nextLine();
		SpellChecker.readFile(address);
		System.out.println("I'll give you what I found out:");
		SpellChecker.compareFileToDictionary();
		SpellChecker.sendUnlistedToFile();
	}

	public static void testTable() {

		int testCount = 0;
		System.out.println("Enter how many words you want to test: ");
		testCount = Integer.parseInt(in.nextLine());
		System.out.println("Okay:");
		for (int i = 0; i < testCount; i++) {
			String w = in.nextLine();
			Hashable h = new Hashable(w);
			System.out.println("The hash value for this word is: "+ h.HashValue);
			System.out.println("The array index is: " + h.getArrayIndex(lht.hashArray.length));
			System.out.println("Inserting " + w + " into hash table...");
			lht.insert(w);
			System.out.println("New word, please: ");
		}
	}
}
