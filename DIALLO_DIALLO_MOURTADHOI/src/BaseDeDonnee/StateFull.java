package BaseDeDonnee;

public abstract class StateFull extends RelationC{

	protected StateFull(String nom, SchemaC schema) {super(nom, schema);}

	public abstract void add(Tuple t);
	
	public abstract void remove(Tuple t);
	
		
}
