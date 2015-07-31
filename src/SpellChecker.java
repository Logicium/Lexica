import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;
import java.util.Vector;

public class SpellChecker {

	public static DynamicHashTable dht;
	public static LinearHashTable lht;
	public static String[] documentWords;
	public static String hashTableType = "";

	public static void importDictionary(String fileName)
			throws FileNotFoundException {
		File F = new File(fileName);
		Scanner dictionaryScanner = new Scanner(F);
		while (dictionaryScanner.hasNextLine()) {
			if (hashTableType.matches("dynamic")) {
				dht.insert(dictionaryScanner.nextLine());
			} else {
				if(lht.hashArray.length == lht.numEntries){
					print("Hash table is FULL. Aborting remaining import. Use a Dynamic hash table next time!");
					break;
				}
				else{
				lht.insert(dictionaryScanner.nextLine());
				}
			}
		}
		print("Dictionary file \"" + F.getName() + "\" imported.");
		if (hashTableType.matches("linear")){
			lht.printResults();
		}
	}

	public static void readFile(String fileName) throws FileNotFoundException {
		// Reads the text file fileName into a single string of words
		fileName = fileName.replace("\\", "/");
		File F = new File(fileName);
		Scanner fileScanner = new Scanner(F);
		String result;
		result = "";
		while (fileScanner.hasNextLine()) {
			result = result.concat(fileScanner.nextLine());
		}
		result = result.replace(",", " ");
		result = result.replace(".", " ");
		result = result.replace("\n", " ");
		documentWords = result.split(" ");
		for (int i = 0; i < documentWords.length; i++) {
			documentWords[i] = documentWords[i].trim();
			documentWords[i] = documentWords[i].toLowerCase();
		}
		print("Test document \"" + F.getName() + "\" successfully imported.");
	}

	public static void sendUnlistedToFile() throws IOException {

		print("Sending unlisted words to file...");
		String title = "spellcheck.txt";
		PrintWriter P = new PrintWriter(title);
		P.println("[UNLISTED WORDS:]");
		for (int i = 0; i < unlistedWords.size(); i++) {
			P.println(unlistedWords.get(i));
		}
		P.close();
		print("Launching file!");
		Launch(title);
	}

	public static Vector<String> unlistedWords = new Vector<String>();

	public static void compareFileToDictionary() {

		int missingCount = 0;
		for (int i = 0; i < documentWords.length; i++) {
			if (hashTableType.matches("linear")) {
				if (lht.Contains(documentWords[i])) {
				} else {
					if (documentWords[i].matches(" ")
							|| documentWords[i].matches("")) {
					} else {
						unlistedWords.add(documentWords[i]);
						missingCount++;
					}
				}
			} else {
				if (dht.Contains(documentWords[i])) {
				} else {
					if (documentWords[i].matches(" ")
							|| documentWords[i].matches("")) {
					} else {
						unlistedWords.add(documentWords[i]);
						missingCount++;
					}
				}
			}

		}
		print("Number of words from file missing in dictionary: "
				+ missingCount + "/" + documentWords.length);
	}

	public static void Launch(String file) throws IOException {
		Desktop.getDesktop().open(new File(file));
	}

	public static void printDictionary() {
		print("Printing Dictionary:");
		String fiveWords = "";
		int count = 0;
		for (int i = 0; i < dht.hashArray.length; i++) {
			if (!dht.hashArray[i].isEmpty()) {
				for (int z = 0; z < dht.hashArray[i].size(); z++) {
					if (count % 4 == 0) {
						System.out.print(dht.hashArray[i].get(z).data + "\n");
					} else {
						System.out.print(dht.hashArray[i].get(z).data + "\t");
					}
					count++;
				}
			}
		}

	}

	public static String entryPoint = "";

	public static void print(String s) {
		if (entryPoint.matches("GUI")) {
			String newLine = "\n";
			newLine = newLine.concat(s);
			s = newLine;
			GUI.algorithmOutput.append(s);
		} else if (entryPoint.matches("system")) {
			System.out.println(s);
		}
	}

}
