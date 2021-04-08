package it.polito.tdp.domino.model;

import java.util.LinkedList;
import java.util.List;

public class Domino {
	public void sequenza() {
		List<Integer> parziale= new LinkedList<>();
		List<String> controllo= new LinkedList<>();
		this.creaSequenza(parziale, 0, controllo);
		
	}
	
	private void creaSequenza(List<Integer> parziale, int livello, List<String> controllo) {
		if(parziale.size()==26) {
			System.out.println(parziale);
			
		}
		else {
			
			for(int i=1; i<=6; i++) {
				int n=0;
				for(int j=1; j<livello; j++) {
					   if(parziale.get(j).equals(i))
						 n++;
					
				}
				if(parziale.size()==0) {
					List<Integer> nuovaParziale= new LinkedList<>(parziale);
					nuovaParziale.add(i);
					creaSequenza(nuovaParziale, livello+1, controllo);
				}
					
				
				if(n<5 && parziale.size()>0) {

					if(parziale.size()%2==0 && parziale.get(livello-1)==i) {
					   List<String> nuovoControllo= new LinkedList<>(controllo);
					   nuovoControllo.add(""+parziale.get(livello-1)+parziale.get(livello-2));
					   nuovoControllo.add(""+parziale.get(livello-2)+parziale.get(livello-1));
					   
					   List<Integer> nuovaParziale= new LinkedList<>(parziale);
					   nuovaParziale.add(i);
					   creaSequenza(nuovaParziale, livello+1, nuovoControllo);
					   
					 }
					if( parziale.size()%2!=0 && parziale.get(livello-1)!=i && !controllo.contains(""+parziale.get(livello-1)+i)) {
					   List<Integer> nuovaParziale= new LinkedList<>(parziale);
					   nuovaParziale.add(i);
					   creaSequenza(nuovaParziale, livello+1, controllo);
					
					}
					
				}
				
				
			}
			
			
		}
		
	}

}
