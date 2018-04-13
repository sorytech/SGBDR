package BaseDeDonnee;

import java.util.ArrayList;

/**
 * @invariant degre()>0
 * @author mourthas
 *
 */
public class SchemaC implements Schema {
	
	private final Attribut[] attributs;
    private ArrayList<Attribut> cle;
    
	/**
	 * @require attribut.length>0
	 * @param listeAttribut
	 */
	public SchemaC(Attribut... listeAttribut) {
		this.attributs = listeAttribut;	
		cle = new ArrayList<Attribut>();
		/* pour chaque attribut, s'il est clé primaire on le 
			rajoute dans la liste cle */
		for(int i=0; i<listeAttribut.length;i++) {			
			/* on verifie si l'attribut est une clé primaire*/			
			if(listeAttribut[i].getifPrimaryKey()) {
				cle.add(listeAttribut[i]);
			}			
		}
	}
	/**
	 * @return le nombre d'attributs
	 */
	public int degre(){return attributs.length;}
	/**
	 * @return l'attibut dont le numéro est donné en paramètre
	 */
	public Attribut getAttribute(int numAttribute) {return attributs[numAttribute];}	
	/**
	 * @return the cle
	 */
	public ArrayList<Attribut> getCle() {
		return cle;
	}
	
	/**
	 * @return the attributs
	 */
	public Attribut[] getAttributs() {
		return attributs;
	}
	/**
	 * return le(s) nom(s) de(s) (l')attribut(s)
	 */
	public String toString() {
			String name="";	
		for(int i=0;i<attributs.length;i++) {
			if(i == attributs.length-1) name = name+attributs[i].getNameAttribut();
			else name = name+attributs[i].getNameAttribut()+",";		
		}
		if(attributs.length==1) return "L'attribut de la relation est : "+name;
		else return "Les attributs de la relation sont ("+name+")";
	}
	/**
	 * 
	 * @return le nom de(s) cle(s)
	 */
	public String KeysName() {
		String KeyName="";
		for(int i=0;i<cle.size();i++) {
			if(i == cle.size()-1) KeyName = KeyName+cle.get(i).getNameAttribut();
			else KeyName = KeyName+cle.get(i).getNameAttribut()+",";
		}
		if(cle.size()==1) return "La cle de la relation est : "+KeyName;
		else return "Les cles de la relation sont : ("+KeyName+")";		
	}
	
	/**
	 * 
	 
	public int getOrdreCle(Attribut key) {
		int indiceCle = -1;
		for(int i=0;i<cle.size();i++) {
			if(cle.get(i)==key) indiceCle=i;
		}
		return indiceCle ;
	}*/
	
	/**
	 * 
	 * @return le nom de outes les cles dans une liste de String
	 */
	public ArrayList<String> getKeysName(){
		ArrayList<String> listName=new ArrayList<>();
		for(int i=0;i<cle.size();i++) {
			listName.add(cle.get(i).getNameAttribut());
		}
		return listName;
	}
	
	
	public int getOrdreAttribut(Attribut a) {
        for(int i=0;i<attributs.length;i++) {
            if(attributs[i].equals(a)) {
                return i;
            }
        }
        return -1;
    }
	
	public void ajoutSchema(Schema sc) {
		ArrayList<Attribut> a=new ArrayList<>();
		for(int i=0;i<this.degre();i++) {
			a.add(this.getAttribute(i));
		}
		for(int i=0;i<sc.degre();i++) {
			a.add(sc.getAttribute(i));
		}
		
	}
	
	
	
}
