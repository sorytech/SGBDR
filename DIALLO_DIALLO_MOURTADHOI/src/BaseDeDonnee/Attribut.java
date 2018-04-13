package BaseDeDonnee;

public class Attribut {
	private final String nameAttribut;
	private final TypeAttribut<?> typeAttribut;
	private Boolean ifPrimaryKey = false;
	
	public Attribut(String nom,TypeAttribut<?> type,ProprietesAttribut prop){		
		nameAttribut=nom;
		typeAttribut=type;
		if(prop==ProprietesAttribut.primaire) {
			ifPrimaryKey=true;
		}
	}
	
	/**
	 * @return the nameAttribut
	 */
	public Boolean getifPrimaryKey() {
		return ifPrimaryKey;
	}

	/**
	 * @return the nameAttribut
	 */
	public String getNameAttribut() {
		return nameAttribut;
	}

	/**
	 * @return the typeAttribut
	 */
	public TypeAttribut<?> getTypeAttribut() {
		return typeAttribut;
	}
	
	
	public boolean equals(Object a){
		if(a==null) return false;
		if(a==this) return true;
		if(!(a instanceof Attribut)) return false;
		Attribut aa = (Attribut)a;	
		return (this.nameAttribut.equals(aa.getNameAttribut())  && this.typeAttribut.equals(aa.getTypeAttribut()));
	}
	
}
