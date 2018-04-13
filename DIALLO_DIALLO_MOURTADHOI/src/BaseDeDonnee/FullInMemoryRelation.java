package BaseDeDonnee;

import java.util.ArrayList;
import java.util.Iterator;

public class FullInMemoryRelation extends StateFull {
	private final ArrayList<Tuple> tuples;

	private SchemaC sc;
	public FullInMemoryRelation(String nom, SchemaC schema) {
		super(nom, schema);
		sc = schema;
		tuples = new ArrayList<>();
	}

	@Override public Iterator<Tuple> iterator() {
		// TODO Auto-generated method stub
		return new Iterator<Tuple>() {
			private int index = 0;
			@Override public boolean hasNext() {return index<tuples.size();}
			@Override public Tuple next() {return tuples.get(index++);}
		};
	}

	@Override public void add(Tuple t) {
		tuples.add(t);		
	}
	
	@Override public void remove(Tuple t) {
		if(tuples.contains(t)) {
			tuples.remove(t);
		}else {
			System.out.println("Ce tuple n'hexiste pas");
		}
		
	}

	/**
	 * @return the tuples
	 */
	public ArrayList<Tuple> getTuples() {
		return tuples;
	}
	
	/**
	 * retourne le schema
	 */
	public SchemaC getSchema(){
		return sc;
	}

	/*
	 * retourne le tuple qui se trouve à une position
	 */	
	public Tuple getTuple(int indice) {
		return tuples.get(indice);
	}
	
	public boolean ifAttibuteIsNumeric(Attribut a){
		TypeAttribut<?> t = a.getTypeAttribut();
		return((t instanceof Entier) || (t instanceof TypeDouble));
	}
	
	public int somme(Attribut a) {
		int sum=0;
		int index=sc.getOrdreAttribut(a);
		Tuple t;
		int valeur;
		if (ifAttibuteIsNumeric(a)) {
			for(int i=0;i<tuples.size();i++) {
				t=tuples.get(i);
				valeur=(int) t.getValeur(index);
				sum=sum+valeur;
			}
		}else {
			System.out.println("L'attribut doit être un numérique");
		}
		
		return sum;
	}
	public int max(Attribut a) {
		int max=Integer.MIN_VALUE;
		int index=sc.getOrdreAttribut(a);
		Tuple t;
		int valeur;
		if (ifAttibuteIsNumeric(a)) {
			for(int i=0; i<tuples.size(); i++){
				t=tuples.get(i);
				valeur=(int) t.getValeur(index);
		        if(valeur > max){
		            max = valeur;
		        }
		    }
		}else {
			System.out.println("L'attribut doit être un numérique");
		}		
		return max;		
	}
	
	public int min(Attribut a) {
		int min = Integer.MAX_VALUE;
		int index=sc.getOrdreAttribut(a);
		Tuple t;
		int valeur;
		if (ifAttibuteIsNumeric(a)) {
			for(int i=0; i<tuples.size(); i++){
				t=tuples.get(i);
				valeur=(int) t.getValeur(index);
		        if(valeur < min){
		            min = valeur;
		        }
		    }
		}else {
			System.out.println("L'attribut doit être un numérique");
		}
		return min;
	}
	
	public double average(Attribut a){
		double nb = this.getTuples().size();		
		return somme(a)/nb;
	}
}
