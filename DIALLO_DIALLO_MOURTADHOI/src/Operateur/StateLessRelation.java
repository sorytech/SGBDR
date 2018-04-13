package Operateur;
import BaseDeDonnee.RelationC;
import BaseDeDonnee.SchemaC;

public abstract class StateLessRelation extends RelationC{
	
	protected StateLessRelation(String nom, SchemaC schema){		
		super(nom, schema);
	}
	
}
