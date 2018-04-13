package Operateur;

import java.util.Iterator;
import BaseDeDonnee.*;

public class Union extends StateLessRelationBinaire{

	public Union(SchemaC schema,Relation r1,Relation r2) {
		
		super(r1.getName() + " UNION "+r2.getName(), schema,r1,r2);		
	}

	@Override
	public Iterator<Tuple> iterator() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
