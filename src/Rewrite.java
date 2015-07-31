import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import a2z.A2ZFileReader;
import a2z.A2ZFileWriter;

public class Rewrite {

	public static void getAntonyms (String fileName) throws IOException {
		
		A2ZFileReader fr = new A2ZFileReader(fileName);
		String text = fr.getContent();
		String[] tokens = text.split("(?<!')\\b(?!')");
		StringBuffer newtext = new StringBuffer();
		String type = "anto";
		for (int i = 0; i < tokens.length; i++) {
			String replace = Replacer.replace(tokens[i],type);
			newtext.append(replace);
		}
		
		// Write the output file
		A2ZFileWriter fw = new A2ZFileWriter("antonyms.txt");
		String output = newtext.toString();
		fw.writeContent(output);
		Launch("antonyms.txt");
	}
	
	public static void getHyponyms (String fileName) throws IOException {
		
		A2ZFileReader fr = new A2ZFileReader(fileName);
		String text = fr.getContent();
		String[] tokens = text.split("(?<!')\\b(?!')");
		StringBuffer newtext = new StringBuffer();
		String type = "hypo";
		for (int i = 0; i < tokens.length; i++) {
			String replace = Replacer.replace(tokens[i], type);
			newtext.append(replace);
		}
		
		// Write the output file
		A2ZFileWriter fw = new A2ZFileWriter("hyponyms.txt");
		String output = newtext.toString();
		fw.writeContent(output);
		Launch("hyponyms.txt");
	}
	
	public static void getHypernyms (String fileName) throws IOException {
		
		A2ZFileReader fr = new A2ZFileReader(fileName);
		String text = fr.getContent();
		String[] tokens = text.split("(?<!')\\b(?!')");
		StringBuffer newtext = new StringBuffer();
		String type = "hyper";
		for (int i = 0; i < tokens.length; i++) {
			String replace = Replacer.replace(tokens[i], type);
			newtext.append(replace);
		}
		
		// Write the output file
		A2ZFileWriter fw = new A2ZFileWriter("hypernyms.txt");
		String output = newtext.toString();
		fw.writeContent(output);
		Launch("hypernyms.txt");
	}
	public static void getGloss (String fileName) throws IOException {
		
		A2ZFileReader fr = new A2ZFileReader(fileName);
		String text = fr.getContent();
		String[] tokens = text.split("(?<!')\\b(?!')");
		StringBuffer newtext = new StringBuffer();
		String type = "gloss";
		for (int i = 0; i < tokens.length; i++) {
			String replace = Replacer.replace(tokens[i], type);
			newtext.append(replace);
		}
		
		// Write the output file
		A2ZFileWriter fw = new A2ZFileWriter("gloss.txt");
		String output = newtext.toString();
		fw.writeContent(output);
		Launch("gloss.txt");
	}
	public static void getNominalizations (String fileName) throws IOException {
		
		A2ZFileReader fr = new A2ZFileReader(fileName);
		String text = fr.getContent();
		String[] tokens = text.split("(?<!')\\b(?!')");
		StringBuffer newtext = new StringBuffer();
		String type = "nom";
		for (int i = 0; i < tokens.length; i++) {
			String replace = Replacer.replace(tokens[i], type);
			newtext.append(replace);
		}
		
		// Write the output file
		A2ZFileWriter fw = new A2ZFileWriter("nominalizations.txt");
		String output = newtext.toString();
		fw.writeContent(output);
		Launch("nominalizations.txt");
	}
	
	public static void getSynonyms (String fileName) throws IOException {
		
		A2ZFileReader fr = new A2ZFileReader(fileName);
		String text = fr.getContent();
		String[] tokens = text.split("(?<!')\\b(?!')");
		StringBuffer newtext = new StringBuffer();
		String type = "syno";
		for (int i = 0; i < tokens.length; i++) {
			String replace = Replacer.replace(tokens[i],type);
			newtext.append(replace);
		}
		
		// Write the output file
		A2ZFileWriter fw = new A2ZFileWriter("synonyms.txt");
		String output = newtext.toString();
		fw.writeContent(output);
		Launch("synonyms.txt");
	}
	
	public static void Launch(String file) throws IOException {
		Desktop.getDesktop().open(new File(file));
	}
	
}
