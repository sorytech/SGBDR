package BaseDeDonnee;

import java.util.ArrayList;

public interface Schema {

	public int degre();
	
	/**
	 * @require numAttribute>=0 & numAttribute<degre()
	 * @param numAttribute
	 * @return
	 */
	public Attribut getAttribute(int numAttribute);
	
	public ArrayList<Attribut> getCle();
	
	public Attribut[] getAttributs();
	
	public String toString();
	
	public String KeysName();
	
	public ArrayList<String> getKeysName();
	
	public int getOrdreAttribut(Attribut a) ;
}
