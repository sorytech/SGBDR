package Operateur;

import java.util.Iterator;

import BaseDeDonnee.FullInMemoryRelation;
import BaseDeDonnee.SchemaC;
import BaseDeDonnee.Tuple;

public class Produit extends StateLessRelationBinaire{
	
	public Produit(FullInMemoryRelation r1,SchemaC schema1, FullInMemoryRelation r2,SchemaC schema2){		
		super(r1.getName() + " PRODUIT "+r2.getName(),schema1, r1, r2);
		schema1.ajoutSchema(schema2);			
	}

	@Override
	public Iterator<Tuple> iterator() {
		// TODO Auto-generated method stub
		return null;
	}						

	

}
