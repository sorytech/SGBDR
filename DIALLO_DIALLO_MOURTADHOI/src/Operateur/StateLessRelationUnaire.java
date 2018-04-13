package Operateur;

import BaseDeDonnee.Relation;
import BaseDeDonnee.SchemaC;

public abstract class StateLessRelationUnaire extends StateLessRelation{

	public final Relation r ;
    protected StateLessRelationUnaire(String nom, SchemaC schema,Relation r) {
        super(nom, schema);
        this.r=r;
    }

}

