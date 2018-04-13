package Operateur;

import java.util.Iterator;

import BaseDeDonnee.Attribut;
import BaseDeDonnee.Relation;
import BaseDeDonnee.SchemaC;
import BaseDeDonnee.Tuple;

public class Identite extends StateLessRelationUnaire{

	public Identite(Relation r,SchemaC schema) {
		super("Identite("+r.getName()+")", schema ,r);
		
		
	}

	@Override public Iterator<Tuple> iterator(){
		return new Iterator<Tuple>() {
			
			private Iterator<Tuple> it = r.iterator();
			@Override public boolean hasNext() {return it.hasNext();}
			@Override public Tuple next(){
				Tuple t = it.next();
				Object[] temp = new Object[r.getSchema().degre()];
				Attribut at;
				for(int i = 0;i<temp.length;i++) {
					at=r.getSchema().getAttribute(i);
					temp[i]=t.getValeur(r.getSchema().getOrdreAttribut(at));
				}
				return new Tuple(temp);
			}
			
		};
		
	}

}
