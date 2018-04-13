package Operateur;

import java.util.Iterator;

import BaseDeDonnee.Relation;
import BaseDeDonnee.SchemaC;
import BaseDeDonnee.Tuple;

public class Jointure extends StateLessRelationBinaire{
	
	protected Jointure(String nom, SchemaC schema, Relation r1, Relation r2) {
		super(nom, schema, r1, r2);
	}

	@Override
	public Iterator<Tuple> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	

}
