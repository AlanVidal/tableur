package cnam.fr.EX2.CaseP;

public class CasePlus extends Case {

	Case source;
	Case dest;

	int selfValue;

	public CasePlus(char x, int y, Case aSource, Case aDest) {
		super(x, y);
		this.source = aSource;
		this.dest = aDest;

	}
	@Override
	public double getValue() {
		return source.getValue() + dest.getValue();
	}

}
