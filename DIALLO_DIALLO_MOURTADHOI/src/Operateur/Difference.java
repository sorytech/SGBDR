package Operateur;

import java.util.Iterator;

import BaseDeDonnee.FullInMemoryRelation;
import BaseDeDonnee.SchemaC;
import BaseDeDonnee.Tuple;

public class Difference extends StateLessRelationBinaire{
		
	public Difference(SchemaC schema, FullInMemoryRelation r1, FullInMemoryRelation r2){		
		super(r1.getName()+" - "+r2.getName(), schema, r1, r2);
	}

	@Override
	public Iterator<Tuple> iterator() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
