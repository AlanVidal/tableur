package cnam.fr.EX2.CaseP;

public class IdiotValue extends Case {
	double value;
	
	public IdiotValue(char x, int y, double aValue) {
		super(x, y);
		this.value = aValue;
	}
	
	 @Override
	 public double getValue(){
		 return this.value;
	 }
	
}
