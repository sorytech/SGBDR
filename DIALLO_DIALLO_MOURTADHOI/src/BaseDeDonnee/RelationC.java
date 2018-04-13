package BaseDeDonnee;

public abstract class RelationC implements Relation {

		private final String nomR;
		private final SchemaC Schema;
		
		protected RelationC(String nom, SchemaC schema) {
			Schema = schema;
			nomR=nom;
		}
		
		public String getName(){
			return nomR;
		}

		public SchemaC getSchema() {
			return Schema;
		}	
		
		
		
}
