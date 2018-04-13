package Operateur;

import java.util.Iterator;

import BaseDeDonnee.Attribut;
import BaseDeDonnee.Relation;
import BaseDeDonnee.SchemaC;
import BaseDeDonnee.Tuple;

public class Projection extends StateLessRelationUnaire{

	private final int[] indexes;
	

	public Projection(Relation r,SchemaC schema){
		super("Projection("+r.getName()+")"+schema.toString(), schema ,r);
		Attribut at;
		indexes=new int[schema.degre()];
		for(int i=0;i<indexes.length;i++){
			at = schema.getAttribute(i);
			indexes[i]=r.getSchema().getOrdreAttribut(at);
			
		}
	}
	
	@Override public Iterator<Tuple> iterator(){
		return new Iterator<Tuple>() {
			
			private Iterator<Tuple> it = r.iterator();
			@Override public boolean hasNext() {return it.hasNext();}
			@Override public Tuple next(){
				Tuple t = it.next();
				Object[] temp = new Object[indexes.length];
				for(int i = 0;i<indexes.length;i++) temp[i]=t.getValeur(indexes[i]);
				return new Tuple(temp);
			}
			
		};
		
	}

}