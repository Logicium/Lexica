public class Hashable {

	
	public String data;
	public char[] charArray;
	public int[] alphaNumericArray;
	public int[] multiplicativeArray;
	public int HashValue;
	public int ArrayIndex; 
	
	public Hashable(String inputString){
		this.data = inputString;
		data = data.toLowerCase().trim();
		charArray = data.toCharArray();
		toAlphaNumeric();
		createMultiplicativeArray();
		computeHashValue();
	}
	
	public void computeHashValue() {
		for(int i =0;i<charArray.length;i++){
		HashValue += (alphaNumericArray[i]*multiplicativeArray[i]);
		}
		
	}

	public void createMultiplicativeArray() {
		multiplicativeArray = new int[charArray.length];
		int count = 3;
		if(charArray.length<=3){
			count = charArray.length-1;
		}
		for(int i = 0;i<multiplicativeArray.length;i++){
			multiplicativeArray[i] = (int) Math.pow(31, count);
			count--;
			if(count<0){count=3;}
		}
		
	}

	public int getArrayIndex(int arraySize){
		ArrayIndex = HashValue%arraySize; 
		return ArrayIndex;
	}
	
	public void toAlphaNumeric(){
		alphaNumericArray = new int[charArray.length]; 
		
		for(int i =0;i<charArray.length;i++){
			switch(charArray[i]){
			
			case 'a': alphaNumericArray[i] = 1;break;
			case 'b': alphaNumericArray[i] = 2;break;
			case 'c': alphaNumericArray[i] = 3;break;
			case 'd': alphaNumericArray[i] = 4;break;
			case 'e': alphaNumericArray[i] = 5;break;
			case 'f': alphaNumericArray[i] = 6;break;
			case 'g': alphaNumericArray[i] = 7;break;
			case 'h': alphaNumericArray[i] = 8;break;
			case 'i': alphaNumericArray[i] = 9;break;
			case 'j': alphaNumericArray[i] = 10;break;
			case 'k': alphaNumericArray[i] = 11;break;
			case 'l': alphaNumericArray[i] = 12;break;
			case 'm': alphaNumericArray[i] = 13;break;
			case 'n': alphaNumericArray[i] = 14;break;
			case 'o': alphaNumericArray[i] = 15;break;
			case 'p': alphaNumericArray[i] = 16;break;
			case 'q': alphaNumericArray[i] = 17;break;
			case 'r': alphaNumericArray[i] = 18;break;
			case 's': alphaNumericArray[i] = 19;break;
			case 't': alphaNumericArray[i] = 20;break;
			case 'u': alphaNumericArray[i] = 21;break;
			case 'v': alphaNumericArray[i] = 22;break;
			case 'w': alphaNumericArray[i] = 23;break;
			case 'x': alphaNumericArray[i] = 24;break;
			case 'y': alphaNumericArray[i] = 25;break;
			case 'z': alphaNumericArray[i] = 26;break;
			case '.': alphaNumericArray[i] = 27;break;
			case '-': alphaNumericArray[i] = 28;break;
			case '\'': alphaNumericArray[i] = 29;break;
			}
		}	
	}
}
