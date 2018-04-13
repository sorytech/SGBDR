package BaseDeDonnee;

import java.util.ArrayList;
import java.util.Iterator;

public class Tuple implements Iterable<Object>{

		private Object[] valeurTuple;		
		private ArrayList<Integer> ordreValeur;
		
		public Tuple(Object... valeur) {			
			valeurTuple=valeur;
			ordreValeur=new ArrayList<>();			
			for(int i=0;i<valeur.length;i++) {
				ordreValeur.add(i);
			}			
		}		

		@Override
		public Iterator<Object> iterator() {
			// TODO Auto-generated method stub
			return new Iterator<Object>() {
				private int index = 0;
				@Override public boolean hasNext() {return index<valeurTuple.length ;}
				@Override public Object next() {return valeurTuple[index++];}
			};
		}

	
		/**
		 * @return the ordreValeur
		 */
		public ArrayList<Integer> getOrdreValeur() {
			return ordreValeur;
		}

		/*public int getOrdreValeur(Object Valeur) {
			int indice = -1;
			for(int i=0;i<valeurTuple.length;i++) {
				if(valeurTuple[i]==Valeur) {
					indice=i;
				}
			}
			return indice;
			
		}*/
		
		/**
		 *  @return l'objet qui se trouve à un ordre donné
		 */
		public Object getValeur(int ordre) {
			int i= ordreValeur.get(ordre);
			return valeurTuple[i];			
		}

		/**
		 * @return the valeurTuple
		 */
		public Object[] getValeurTuple() {
			return valeurTuple;
		}
		
		/**
		 * @return la longueur du tuple
		 */
		public int nbValeur() {
			return valeurTuple.length;
		}
		
		/**
		 * @param Tuple t qu'il faut ajouter 
		 * @return le tuple courant auquel on rajoute un tuple t
		 */
		public Tuple ajoutTuple(Tuple t) {
			Object[] contenuTuple=new Object[this.nbValeur()+t.nbValeur()];
			for(int i=0;i<this.nbValeur();i++){
				contenuTuple[i]=this.getValeur(i);
			}
			for(int i=0;i<t.nbValeur();i++){
				contenuTuple[i+this.nbValeur()]=t.getValeur(i);
			} 
			Tuple t1=new Tuple(contenuTuple);
			return t1;
		}
		
		/**
		 * @param tuple a
		 * @return l'equivalence entre le tuple courant et celui donné en parametre
		 */
		public boolean equals(Tuple a){			
			if(a==null) return false;
			if(a==this) return true;
			if(!(a instanceof Tuple)) return false;	
			for(int i=0;i< this.valeurTuple.length;i++) {
				if(!(this.valeurTuple[i].equals(a.getValeur(i)))) return false;
			}
			return true;			
		}
		
		public boolean joinTuple(Tuple t, int onT1, int onT2) {
			if (t.valeurTuple[onT1].equals(this.getValeur(onT2))) {
				int i=0;
				for(Object obj: t.getValeurTuple()) {
					if(i!=onT2) {
						
					}
				}
				return true;
			}
			else return false;
		}
			
		
}
