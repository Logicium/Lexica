import java.util.Vector;


public class DynamicHashTable {
	public int numEntries=0;
	public int defaultSize = 1000;
	public Vector<Hashable>[] hashArray;
	
	public DynamicHashTable(){	
		Vector[] preHashArray = new Vector[defaultSize];
		hashArray = preHashArray;
		for(int i = 0;i<hashArray.length;i++){
			hashArray[i] = new Vector<Hashable>();
		}
	}
	
	public DynamicHashTable(int n){
		Vector[] preHashArray = new Vector[n];
		hashArray = preHashArray;
		for(int i = 0;i<hashArray.length;i++){
			hashArray[i] = new Vector<Hashable>();
		}
	}
	
	public void insert(String S){
		//Inserts S into the hash table
		Hashable word = new Hashable(S);
//		if(!hashArray[word.getArrayIndex(hashArray.length)].isEmpty()){
//			System.out.println("Collision mitigated. Elements at index "+word.getArrayIndex(hashArray.length)
//					+" are:");
//			for(int z =0;z<hashArray[word.getArrayIndex(hashArray.length)].size();z++){
//				System.out.println(hashArray[word.getArrayIndex(hashArray.length)].get(z).data);
//			}
//		}
		hashArray[word.getArrayIndex(hashArray.length)].add(word);
		numEntries++;
	}

	public boolean Contains(String S){
		S = S.toLowerCase().trim();
		for(int i = 0;i<hashArray.length;i++){
			if(!hashArray[i].isEmpty()){
				for(int z =0; z< hashArray[i].size();z++){
					if(hashArray[i].get(z).data.matches(S)){
						return true;
					}
				}
			}
		}
		return false;
	}
	
	public int NumEntries(){
		return numEntries;
	}
}
