
public class LinearHashTable {
	
	public static int longestChain=0;
	public static int numberOfCollisions=0;
	public int numEntries;
	public int defaultSize = 1000;
	public static Hashable[] hashArray;

	public LinearHashTable() {
		hashArray = new Hashable[defaultSize];
	}

	public LinearHashTable(int n) {
		hashArray = new Hashable[n];
	}

	public void insert(String word) {
		Hashable element = new Hashable(word);
		int location;
		int collisionCount=0;
		location = element.getArrayIndex(hashArray.length);
		while (hashArray[location] != null) {
			location = (location + 1) % hashArray.length;
			collisionCount++;
		}
		hashArray[location] = element;
		numEntries++;
		numberOfCollisions = numberOfCollisions + collisionCount;
		if(collisionCount>longestChain){
			longestChain = collisionCount;
		}
	}
	
	public static void printResults(){
		print("Number of collisions was: "+numberOfCollisions);
		print("And the longest chain was: "+longestChain);
	}
	
	public boolean Contains(String S) {
		S = S.toLowerCase().trim();
		for (int i = 0; i < hashArray.length; i++) {
			if (!(hashArray[i] == null)) {
				if (hashArray[i].data.matches(S)) {
					return true;
				}
			}
		}
		return false;
	}

	public int NumEntries() {
		return numEntries;
	}

	public static void print(String s) {
		if (SpellChecker.entryPoint.matches("GUI")) {
			String newLine = "\n";
			newLine = newLine.concat(s);
			s = newLine;
			GUI.algorithmOutput.append(s);
		} else if (SpellChecker.entryPoint.matches("system")) {
			System.out.println(s);
		}
	}

}
