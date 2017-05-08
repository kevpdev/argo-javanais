

public class Main {

	public static void main(String[] args) {
		
		String voy = "[aeiouyAEIOUY*]";
		String cons = "[bcdfghjklmnpqrstvwxzBCDFGHJKLMNPQRSTVWXZ*]";		
		String str = "bonjour, chante, moyen, exemple, au";
		String [] strArray = str.split(", ");
		
		for (int i = 0; i < strArray.length; i++) {
			System.out.println(transformation(strArray[i], voy, cons));
		}		
	}
	
	public static String transformation(String str, String voy, String cons){
		int cptInsert = 0; // pour avoir le nombre de "av" inséré.
		StringBuilder mot= new StringBuilder(str);
		String[] strArray = mot.toString().split("");
		
		for (int i = 0; i < strArray.length; i++) {
			
			if(i == 0){ //vérification pour la premiere lettre

				if(strArray[i].matches(voy)){
				  mot.insert(i, "av");
				  cptInsert += 2;
				}
				if(strArray[i].matches(cons) && strArray[i+1].matches(voy)){
					mot.insert(i+1, "av");
					 cptInsert += 2;
				}				
			}
			else{ //vérification avec une consonne suivi d'une voyelle
				
				if(i+1 < strArray.length){ // je vérifie si je dépasse la taille maximale du tableau

					if(strArray[i].matches(cons) && strArray[i+1].matches(voy)){
						mot.insert(i+cptInsert+1, "av");
						 cptInsert += 2;
					}
				}
			}					
		}	
		
		return mot.toString();
	}

}
