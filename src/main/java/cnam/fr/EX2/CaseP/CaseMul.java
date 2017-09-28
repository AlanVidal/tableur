package cnam.fr.EX2.CaseP;

public class CaseMul extends Case {

	Case source;
	Case dest;

	int selfValue;

	public CaseMul(char x, int y, Case aSource, Case aDest) {
		super(x, y);
		this.source = aSource;
		this.dest = aDest;

	}
	@Override
	public double getValue() {
		return source.getValue() * dest.getValue();
	}

}
