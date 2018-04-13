package Operateur;

import java.util.Iterator;
import java.util.NoSuchElementException;

import BaseDeDonnee.*;

public class Selection extends StateLessRelationUnaire {

	private final Predicat p ;
	
	public Selection(Relation r,SchemaC schema,Predicat p) {
		super("Selection(" + r.getName() + ")",schema, r);
		this.p=p;
	}

	@Override public Iterator<Tuple> iterator() {
		
		return new Iterator<Tuple>() {
			Iterator<Tuple> it = r.iterator();
			private Tuple next;
			private boolean hasNext=getNext();			
			@Override public boolean hasNext() {return hasNext;}			
			@Override public Tuple next() {				
				if(!hasNext()) throw new NoSuchElementException();
				Tuple temp = next;
				hasNext = getNext();
				return temp;
			}			
			private boolean getNext(){
				if(!it.hasNext()) return false;
				while(it.hasNext() && !p.eval(next = (Tuple) it.next()));
				return p.eval(next);
			}
		};
	}
	

}
