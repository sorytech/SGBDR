package test;

import java.util.ArrayList;

import BaseDeDonnee.Attribut;
import BaseDeDonnee.BD;
import BaseDeDonnee.Entier;
import BaseDeDonnee.FullInMemoryRelation;
import BaseDeDonnee.Predicat;
import BaseDeDonnee.ProprietesAttribut;
import BaseDeDonnee.Relation;
import BaseDeDonnee.SchemaC;
import BaseDeDonnee.Tuple;
import BaseDeDonnee.TypeString;
import Operateur.Projection;
import Operateur.Selection;

public class Test {
	public static void main(String[] args) {
		
		SchemaC sc = new SchemaC(
				new Attribut("NOM", new TypeString(), ProprietesAttribut.primaire),
				new Attribut("PRENOM", new TypeString(), ProprietesAttribut.Standard),
				new Attribut("AGE", new Entier(), ProprietesAttribut.Standard));
		FullInMemoryRelation relation = new FullInMemoryRelation("PERSONNE 1", sc);
		relation.add(new Tuple("DIALLO","MAMADOU",21));
		relation.add(new Tuple("DIALLO","SORY",19));
		relation.add(new Tuple("MOURTHADHOI","SULTAN",20));
		relation.add(new Tuple("ZIANI","NOUREDINE",18));
		relation.add(new Tuple("ZLATAN","IBRAHIMOVIC",36));
			
		System.out.println(relation.getName());
		for(Tuple t: relation){			
			for(Object o : t){
				System.out.print(o+" ");
			}
			System.out.println();
		}
		
		SchemaC sc1 = new SchemaC(
				new Attribut("AGE", new Entier(), ProprietesAttribut.Standard),
				new Attribut("NOM", new TypeString(), ProprietesAttribut.primaire)
				);
		Relation rel=new Projection(relation,sc1);
		System.out.println(rel.getName());
		for(Tuple t: rel){			
			for(Object o : t){
				System.out.print(o+" ");
			}
			System.out.println();
		}
		Predicat p =new Predicat() {
			
			@Override
			public boolean eval(Tuple t) {
				return (((String)t.getValeur(0)).equals("DIALLO"));
			}
		};
		FullInMemoryRelation relation2 = new FullInMemoryRelation("PERSONNE 2", sc);
		relation2.add(new Tuple("TOURE","SALIOU",21));
		relation2.add(new Tuple("BODIANG","ASSANE",19));
		relation2.add(new Tuple("AISSAT","NABIL",20));
		relation2.add(new Tuple("SOUMAH","ABDOUL",19));
		relation2.add(new Tuple("BEA","HADY",19));
		
		System.out.println(relation2.getName());
		for(Tuple t: relation2){			
			for(Object o : t){
				System.out.print(o+" ");
			}
			System.out.println();
		}
		Attribut a=sc.getAttribute(0);
		SchemaC sc2=new SchemaC(a);
		Relation rel2=new Selection(relation, sc2, p);
		System.out.println(rel2.getName());
		for(Tuple t: rel2){			
			for(Object o : t){
				System.out.print(o+" ");
			}
			System.out.println();
		}
		
		int i = relation.somme(sc.getAttribute(2));
		System.out.println("la somme des "+sc.getAttribute(2).getNameAttribut()+" est : "+i);
		
		i = relation.max(sc.getAttribute(2));
		System.out.println("le max des "+sc.getAttribute(2).getNameAttribut()+" est : "+i);
		
		i = relation.min(sc.getAttribute(2));
		System.out.println("le min des "+sc.getAttribute(2).getNameAttribut()+" est : "+i);
		
		Double mean = relation.average(sc.getAttribute(2));
		System.out.println("le min des "+sc.getAttribute(2).getNameAttribut()+" est : "+mean);
		
		ArrayList<Relation> listeDeraltions=new ArrayList<>();
		listeDeraltions.add(relation);
		listeDeraltions.add(relation2);
		listeDeraltions.add(rel2);
		BD bd=new BD(listeDeraltions);
		System.out.println("Dans notre BD, on a "+bd.nbDeRelation()+" relation(s)");
		
		
	}

}
