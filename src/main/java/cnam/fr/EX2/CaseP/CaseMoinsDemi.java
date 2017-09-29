package cnam.fr.EX2.CaseP;

public class CaseMoinsDemi extends Case {

	Case source;
	double dest;
	
	public CaseMoinsDemi(char x, int y, Case aSource, double aDest) {
		super(x, y);
		this.source = aSource;
		this.dest = aDest;

	}
	@Override
	public double getValue() {
		return source.getValue() - dest;
	}

}
