/* 
 * This Replacer class has some static methods that take in an input word
 * and find a replacement from wordnet.  It also retains (mostly) capitalization
 * 
 * The replacement algorithm is arbitrary and just a demonstration of what is possible.
 * 
 */

import java.io.IOException;
import java.util.HashMap;

import a2z.A2ZFileReader;
import rita.wordnet.RiWordnet;

public class Replacer {

	// Wordnet reference
	static RiWordnet wordnet;
	// We may want to not replace some words and so store them in a HashMap
	static HashMap skip;

	public static String replace(String word, String replacementType) throws IOException {
		// The first time this method is called we initialize the objects
		if (wordnet == null) {
			// Would pass in a PApplet normally, but we don't need to here
			wordnet = new RiWordnet(null);
			skip = new HashMap();
			// Read in words from a text file to skip
			A2ZFileReader fr = new A2ZFileReader("skip.txt");
			String[] skipWords = fr.getContent().split("\\n");
			for (int i = 0; i < skipWords.length; i++) {
				skip.put(skipWords[i], skipWords[i]);
			}
		}

		String search = word.toLowerCase();
		// If it's not a word, not in wordnet or a word we should skip then just pass it back
		if (!search.matches("\\w+")|| !wordnet.exists(search) || skip.containsKey(search)) {
			return word;
		// Otherwise, go forward and find a replacement!
		} else {
			String replacement = pickReplacement(search,replacementType);
			// Retain any case
			replacement = retainCase(replacement,word);
			return replacement;
		}
	}

	// This is completely arbitrary, just showing how to find something
	// in wordnet to replace.  
	private static String pickReplacement(String word, String replacementType) {
		String pos = wordnet.getBestPos(word);
		if (pos != null) {
			
			if (replacementType.matches("anto")) {
				String[] antonyms = wordnet.getAllAntonyms(word, pos);
				if (antonyms != null) {
					String replacement = antonyms[(int) Math.random()* antonyms.length];
					print(word + " --> " + replacement+ "  (antonym " + pos + ")");
					return replacement;
				}
			}

			else if (replacementType.matches("hypo")) {
				String[] hyponyms = wordnet.getAllHyponyms(word, pos);
				if (hyponyms != null) {
					String replacement = hyponyms[(int) Math.random()* hyponyms.length];
					print(word + " --> " + replacement+ "  (hyponym " + pos + ")");
					return replacement;
				}
			}
			else if (replacementType.matches("hyper")) {
				String[] hypernyms = wordnet.getAllHypernyms(word, pos);
				if (hypernyms != null) {
					String replacement = hypernyms[(int) Math.random()* hypernyms.length];
					print(word + " --> " + replacement+ "  (hypernym " + pos + ")");
					return replacement;
				}
			} 
			
			else if (replacementType.matches("syno")) {
				String[] synonyms = wordnet.getAllSynonyms(word, pos);
				if (synonyms != null) {
					String replacement = synonyms[(int) Math.random()* synonyms.length];
					print(word + " --> " + replacement+ "  (synonym " + pos + ")");
					return replacement;
				}
			}
			else if (replacementType.matches("gloss")) {
				String[] glosses = wordnet.getAllGlosses(word, pos);
				if (glosses != null) {
					String replacement = (glosses[(int) Math.random()* glosses.length]);
					print(word + " --> " + replacement+ "  (gloss " + pos + ")");
					return ("\n"+word+" --> "+replacement+ "  (gloss " + pos + ")");
				}
			}
			else if (replacementType.matches("nom")) {
				String[] nominializations = wordnet.getAllNominalizations(word, pos);
				if (nominializations != null) {
					String replacement = nominializations[(int) Math.random()* nominializations.length];
					print(word + " --> " + replacement+ "  (nominalization " + pos + ")");
					return replacement;
				}
			} 
			
		}
		return word;
	}
	
	private static String retainCase(String replacement, String word) {
		// If last character is upper case then all upper case
		if (Character.isUpperCase(word.charAt(word.length()-1))) {
			return replacement.toUpperCase();
		} else if (Character.isUpperCase(word.charAt(0))) {
			char fc = replacement.charAt(0);
			return Character.toUpperCase(fc)+replacement.substring(1);
		}
		return replacement;
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
