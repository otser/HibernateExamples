package net.viralpatel.hibernate.mtm.xml;

public enum Categorie {
	A('A'), 
	B('B'), 
	C('C'), 
	D('D'), 
	E('E'), 
	F('F'),
	G('G');
	
	
	public char asChar() {
        return asChar;
    }

    private final char asChar;

    private Categorie(char asChar) {
        this.asChar = asChar;
    }
}
