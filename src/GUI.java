import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class GUI {

	static JTextArea algorithmOutput = new JTextArea();
	JScrollPane scroll = new JScrollPane(algorithmOutput,
			JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
			JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	
	JTextField loadDocumentInputBar = new JTextField();
	JTextField hashTableSizeInputBar = new JTextField();
	JTextField loadDictionaryInputBar = new JTextField();
	
	JLabel outputLabel = new JLabel("Algorithm Output:");
	JLabel htSizeLabel = new JLabel("Hash Table Size:");
	JLabel dicFileLabel = new JLabel("Dictionary Path:");
	JLabel docFileLabel = new JLabel("Document Path:");
	
	JButton createLinearHashTableButton = new JButton("Linear");
	JButton createDynamicHashTableButton = new JButton("Dynamic");
	JButton importDictionaryButton = new JButton("Load Dictionary");
	JButton loadDocumentButton = new JButton("Load Document");
	JButton spellCheckButton = new JButton("Spellcheck");
	JButton synonymsButton = new JButton("Synonyms");
	JButton antonymsButton = new JButton("Antonyms");
	JButton hyponymsButton = new JButton("Hyponyms");
	JButton hypernymsButton = new JButton("Hypernyms");
	JButton nominalButton = new JButton("Nominalize");
	JButton glossButton = new JButton("Define");
	
	
	public static void main(String[] args) {
		GUI frame = new GUI();
	}

	public GUI() {
		JFrame f = new JFrame();
		f.setTitle(" LEXICON ");
		f.setLayout(null);
		f.setSize(800, 600);
		f.setLocationRelativeTo(null);
		f.setResizable(false);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);		
		Dimension labelSize = new Dimension(200,50);
		Dimension inputBarSize = new Dimension(165,30);
		Dimension buttonSize = new Dimension(165, 50);
		Dimension bigButtonSize = new Dimension(115,50);
		
		scroll.setLocation(50, 50);
		algorithmOutput.setSize(500,350);
		algorithmOutput.setEditable(false);
		scroll.setSize(600, 350);
		
		/***********LABELS***********************/
		
		outputLabel.setSize(labelSize);
		outputLabel.setLocation(50, 10);
		htSizeLabel.setSize(labelSize);
		htSizeLabel.setLocation(50,400);
		dicFileLabel.setSize(labelSize);
		dicFileLabel.setLocation(260,400);
		docFileLabel.setSize(labelSize);
		docFileLabel.setLocation(475,400);
		
		/****************INPUT BARS**************/
		
		hashTableSizeInputBar.setSize(inputBarSize);
		hashTableSizeInputBar.setLocation(50, 450);
		
		loadDictionaryInputBar.setSize(inputBarSize);
		loadDictionaryInputBar.setLocation(260, 450);
		
		loadDocumentInputBar.setSize(inputBarSize);
		loadDocumentInputBar.setLocation(475, 450);
		
		/*************BUTTONS****************/
		
		createLinearHashTableButton.setSize(75,50);
		createLinearHashTableButton.setLocation(140,500);
		
		createDynamicHashTableButton.setSize(83,50);
		createDynamicHashTableButton.setLocation(50, 500);
		
		importDictionaryButton.setSize(buttonSize);
		importDictionaryButton.setLocation(260, 500);
		
		loadDocumentButton.setSize(buttonSize);
		loadDocumentButton.setLocation(475, 500);
		
		/******BIG BUTTONS********************/
		
		spellCheckButton.setSize(bigButtonSize);
		spellCheckButton.setLocation(665, 50);
		spellCheckButton.setFont(new Font("Arial", Font.BOLD, 13));
		
		synonymsButton.setSize(bigButtonSize);
		synonymsButton.setLocation(665,125);
		synonymsButton.setFont(new Font("Arial", Font.BOLD, 13));
		
		antonymsButton.setSize(bigButtonSize);
		antonymsButton.setLocation(665,200);
		antonymsButton.setFont(new Font("Arial", Font.BOLD, 13));
		
		hyponymsButton.setSize(bigButtonSize);
		hyponymsButton.setLocation(665,275);
		hyponymsButton.setFont(new Font("Arial", Font.BOLD, 13));
		
		hypernymsButton.setSize(bigButtonSize);
		hypernymsButton.setLocation(665,350);
		hypernymsButton.setFont(new Font("Arial", Font.BOLD, 13));
		
		nominalButton.setSize(bigButtonSize);
		nominalButton.setLocation(665,425);
		nominalButton.setFont(new Font("Arial", Font.BOLD, 13));
		
		glossButton.setSize(bigButtonSize);
		glossButton.setLocation(665,500);
		glossButton.setFont(new Font("Arial", Font.BOLD, 13));
		
		
		f.add(outputLabel);
		f.add(htSizeLabel);
		f.add(dicFileLabel);
		f.add(docFileLabel);
		
		f.add(scroll);
		
		f.add(htSizeLabel);
		f.add(dicFileLabel);
		f.add(dicFileLabel);
		
		f.add(hashTableSizeInputBar);
		f.add(loadDictionaryInputBar);
		f.add(loadDocumentInputBar);
		
		f.add(loadDocumentButton);
		f.add(createDynamicHashTableButton);
		f.add(createLinearHashTableButton);
		f.add(importDictionaryButton);
		f.add(spellCheckButton);
		f.add(synonymsButton);
		f.add(antonymsButton);
		f.add(hyponymsButton);
		f.add(hypernymsButton);
		f.add(nominalButton);
		f.add(glossButton);
		
		algorithmOutput.append("Welcome to LEXICON!\n\n");
		algorithmOutput.append("Give me a file and I will output the desired changes!\n");
		
		SpellChecker.entryPoint = "GUI";
		
		createDynamicHashTableButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				if (evt.getButton() == MouseEvent.BUTTON1) {
					try{
					int size =  Integer.parseInt(hashTableSizeInputBar.getText());
					SpellChecker.hashTableType ="dynamic";
					DynamicHashTable ht = new DynamicHashTable(size);
					SpellChecker.dht = ht;
					algorithmOutput.append("\nCreated a new Dynamic hash table of specified size: "+ht.hashArray.length);
					GUI.algorithmOutput.append(CommandMe());
					}
					catch(Exception e){
						SpellChecker.hashTableType ="dynamic";
						DynamicHashTable ht = new DynamicHashTable();
						SpellChecker.dht =ht;
						algorithmOutput.append("\nCreated a new Dynamic hash table of default size: "+ht.hashArray.length);
						GUI.algorithmOutput.append(CommandMe());
						}
				}
			}
		});
		createLinearHashTableButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				if (evt.getButton() == MouseEvent.BUTTON1) {
					try{
					int size =  Integer.parseInt(hashTableSizeInputBar.getText());
					SpellChecker.hashTableType ="linear";
					LinearHashTable lht = new LinearHashTable(size);
					SpellChecker.lht = lht;
					algorithmOutput.append("\nCreated a new Linear Hash Table of specified size: "+lht.hashArray.length);
					GUI.algorithmOutput.append(CommandMe());
					}
					catch(Exception e){ 
						SpellChecker.hashTableType ="linear";
						LinearHashTable lht = new LinearHashTable();
						SpellChecker.lht = lht;
						algorithmOutput.append("\nCreated a new Linear hash table of default size: "+lht.hashArray.length);
						GUI.algorithmOutput.append(CommandMe());
					}
				}
			}
		});
		
		spellCheckButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				if (evt.getButton() == MouseEvent.BUTTON1) {	
					try {
						SpellChecker.compareFileToDictionary();
						SpellChecker.sendUnlistedToFile();
						GUI.algorithmOutput.append(CommandMe());
					} catch (IOException e) {
						// TODO Auto-generated catch block
					}
				}
			}
		});
		
		importDictionaryButton.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent evt) {
				if (evt.getButton() == MouseEvent.BUTTON1) {
					try {
						String fileName = (loadDictionaryInputBar.getText());
						SpellChecker.importDictionary(fileName);
						GUI.algorithmOutput.append(CommandMe());
					} catch (FileNotFoundException e) {
						try {
							SpellChecker.importDictionary(defaultDictionary);
						} catch (FileNotFoundException e1) {
							e1.printStackTrace();
						}
						GUI.algorithmOutput.append(CommandMe());
					}
				}
			}
		});
		
		loadDocumentButton.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent evt) {
				if (evt.getButton() == MouseEvent.BUTTON1) {
					try {
						String fileName = (loadDocumentInputBar.getText());
						SpellChecker.readFile(fileName);
						GUI.algorithmOutput.append(CommandMe());
					} catch (FileNotFoundException e) {
						try {
							SpellChecker.readFile(defaultDocument);
						} catch (FileNotFoundException e1) {
							e1.printStackTrace();
						}
						GUI.algorithmOutput.append(CommandMe());
					}
				}
			}
		});
		
		synonymsButton.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent evt) {
				if (evt.getButton() == MouseEvent.BUTTON1) {
					try {
						String fileName = (loadDocumentInputBar.getText());
						Rewrite.getSynonyms(fileName);
						GUI.algorithmOutput.append(CommandMe());
					} catch (IOException e) {
						try {
							Rewrite.getSynonyms(defaultDocument);
							GUI.algorithmOutput.append(CommandMe());
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				}
			}
		});
		
		antonymsButton.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent evt) {
				if (evt.getButton() == MouseEvent.BUTTON1) {
					
					try {
						String fileName = (loadDocumentInputBar.getText());
						Rewrite.getAntonyms(fileName);
						GUI.algorithmOutput.append(CommandMe());
					} catch (IOException e) {
						try {
							Rewrite.getAntonyms(defaultDocument);
							GUI.algorithmOutput.append(CommandMe());
						} catch (IOException e1) {
							e1.printStackTrace();
						}
						
					}
				}
			}
		});
		
		hyponymsButton.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent evt) {
				if (evt.getButton() == MouseEvent.BUTTON1) {
					
					try {
						String fileName = (loadDocumentInputBar.getText());
						Rewrite.getHyponyms(fileName);
						GUI.algorithmOutput.append(CommandMe());
					} catch (IOException e) {
						try {
							Rewrite.getHyponyms(defaultDocument);
							GUI.algorithmOutput.append(CommandMe());
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
					}
				}
			}
		});
		hypernymsButton.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent evt) {
				if (evt.getButton() == MouseEvent.BUTTON1) {
					
					try {
						String fileName = (loadDocumentInputBar.getText());
						Rewrite.getHypernyms(fileName);
						GUI.algorithmOutput.append(CommandMe());
					} catch (IOException e) {
						try {
							Rewrite.getHypernyms(defaultDocument);
							GUI.algorithmOutput.append(CommandMe());
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				}
			}
		});
		nominalButton.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent evt) {
				if (evt.getButton() == MouseEvent.BUTTON1) {
					
					try {
						String fileName = (loadDocumentInputBar.getText());
						Rewrite.getNominalizations(fileName);
						GUI.algorithmOutput.append(CommandMe());
					} catch (IOException e) {
						try {
							Rewrite.getNominalizations(defaultDocument);
							GUI.algorithmOutput.append(CommandMe());
						} catch (IOException e1) {
							e1.printStackTrace();
						}		
					}
				}
			}
		});
		glossButton.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent evt) {
				if (evt.getButton() == MouseEvent.BUTTON1) {
					try {
						String fileName = (loadDocumentInputBar.getText());
						Rewrite.getGloss(fileName);
						GUI.algorithmOutput.append(CommandMe());
					} catch (IOException e) {
						try {
							Rewrite.getGloss(defaultDocument);
							GUI.algorithmOutput.append(CommandMe());
						} catch (IOException e1) {
							e1.printStackTrace();
						}
						
					}
				}
			}
		});	
	}
	
	public static String defaultDictionary = "Dictionary1.txt";
	public static String defaultDocument = "Cockel Shells.txt";
	public static String CommandMe() {
		String CommandMe[] = { "\nWhat can I do for you:\n",
				"\nGo ahead and choose a command:\n",
				"\nWhat antics are next:\n", "\nWhat's your next command:\n",
				"\nWhat shall I do now:\n", "\nWhat's next:\n",
				"\nI'm eager to please: ", "\nYour wish is my command:\n",
				"\nTell me what to do: ", "\nI'm waiting for your next move:\n",
				"\nWhat needs to happen now:\n", "\nWhat now:\n",
				"\nPlease enter a command:\n","\nWhat now:\n" };
		String word = (CommandMe[new Random().nextInt(CommandMe.length)]);
		return word;
	}
	
	
}
