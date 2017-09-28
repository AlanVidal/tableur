package cnam.fr.EX2;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		Tableur tab = new Tableur();
		tab.setCaseX('A', 0, 1.2);
		tab.setCaseX('A', 1, 2.1);
		tab.setCaseX('A', 2, "SUM", 'A', 1, 'A', 0);
		tab.setCaseX('A', 3, "LESS", 'A', 1, 'A', 2);
		tab.setCaseX('A', 4, "LESS", 'A', 1, 2); 
		tab.setCaseX('A', 5, "MUL", 'A', 4, 0);
		tab.setCaseX('B', 1, "LESS", 'A', 5, 'A',1); 		
		tab.setCaseX('B', 6, "SUM", 'B', 1, 'A',1); 

		tab.afficher();
		System.out.println("");
		
		tab.regex();


	}
}
