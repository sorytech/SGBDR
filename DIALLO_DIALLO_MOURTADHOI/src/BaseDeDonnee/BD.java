package BaseDeDonnee;

import java.util.ArrayList;

public class BD {
	
	private ArrayList<Relation> relations;
	
	
	
	public BD(ArrayList<Relation> relation  ) {		
		relations = relation;	
	}
	
	public void addRelation(Relation R) {	
		relations.add(R);
	}
	
	public void supRelation(Relation R) {
		if(!relations.contains(R)){
			System.out.println("Cette relation n'hexiste pas dans la base de données");
		}else{
			relations.remove(R);
		}	
	}
	
	public int nbDeRelation() {
        return relations.size();
    }
	
	public boolean ifBDEmpty() {
        return relations.isEmpty();
    }
	
}
