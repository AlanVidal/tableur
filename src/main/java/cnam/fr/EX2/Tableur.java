package cnam.fr.EX2;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import cnam.fr.EX2.CaseP.Case;
import cnam.fr.EX2.CaseP.CaseMoins;
import cnam.fr.EX2.CaseP.CaseMoinsDemi;
import cnam.fr.EX2.CaseP.CaseMul;
import cnam.fr.EX2.CaseP.CaseMulDemi;
import cnam.fr.EX2.CaseP.CasePlus;
import cnam.fr.EX2.CaseP.CasePlusDemi;
import cnam.fr.EX2.CaseP.IdiotValue;

public class Tableur {
	private Map<Character, Integer> alphab = new HashMap<Character, Integer>();
	private Character alphabet[] = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J' };

	private Case tableau2D[][] = new Case[10][10];

	public Tableur() { // A modifier -> table ASCII
		for (int i = 0; i < 10; i++) {
			alphab.put(alphabet[i], i);
		}
	}

	public void setCaseX(char ax, int ay, double aValue) {
		int x = alphab.get(ax);
		tableau2D[x][ay] = new IdiotValue(ax, ay, aValue);
	}

	/**
	 * Factoriser les surcharges
	 * 
	 * @param ax
	 * @param ay
	 * @param aValue
	 * @param oax
	 * @param oay
	 * @param dax
	 * @param day
	 */
	public void setCaseX(char ax, int ay, String aValue, char oax, int oay, char dax, int day) {
		int x = alphab.get(ax);
		int ox = alphab.get(oax);
		int dx = alphab.get(dax);

		Case oCase = tableau2D[ox][oay];
		Case dCase = tableau2D[dx][day];

		switch (aValue) {
		case "SUM":
			tableau2D[x][ay] = new CasePlus(ax, ay, oCase, dCase);
			break;
		case "LESS":
			tableau2D[x][ay] = new CaseMoins(ax, ay, oCase, dCase);
			break;
		case "MUL":
			tableau2D[x][ay] = new CaseMul(ax, ay, oCase, dCase);
			break;
		default:
			break;
		}

	}

	/**
	 * 
	 * @param ax
	 * @param ay
	 * @param operator
	 * @param oax
	 * @param oay
	 * @param aValue
	 */
	public void setCaseX(char ax, int ay, String operator, char oax, int oay, double aValue) {
		int x = alphab.get(ax);
		int ox = alphab.get(oax);

		Case oCase = tableau2D[ox][oay];

		switch (operator) {
		case "SUM":
			tableau2D[x][ay] = new CasePlusDemi(ax, ay, oCase, aValue);
			break;
		case "LESS":
			tableau2D[x][ay] = new CaseMoinsDemi(ax, ay, oCase, aValue);
			break;
		case "MUL":
			tableau2D[x][ay] = new CaseMulDemi(ax, ay, oCase, aValue);
			break;
		default:
			break;
		}

	}

	public void afficher() {
		for (int i = 0; i < 9; i++) {
			for (int y = 0; y < 9; y++) {
				double x = 0;
				if (tableau2D[i][y] != null) {
					x = tableau2D[i][y].getValue();
					System.out.println((char) (tableau2D[i][y].getX()) + " " + tableau2D[i][y].getY() + " : " + x);
				}

			}
		}

	}
	public void regex(String intstruction) {

		Pattern pattern = Pattern.compile("([A-Z]+)\\(([A-Z])([0-9]);([0-9])\\)");
		Matcher items = pattern.matcher(intstruction);
		while (items.find()) {
			System.out.println(items.group(1));
			System.out.println(items.group(2));
			System.out.println(items.group(3));
			System.out.println(items.group(4));

		}
	}

}
