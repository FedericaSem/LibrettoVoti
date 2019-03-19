package it.polito.tdp.libretto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Libretto {
	
	private List <Voto> voti;
	
	public Libretto() {
		this.voti= new ArrayList<Voto>();
		}

	public void add(int voto, String corso, LocalDate data) {
		
	}
	
	/**
	 * aggiunge un nuovo voto al libretto
	 * 
	 * @param v {@link Voto} da aggiungere
	 */
	public void add(Voto v) {
		voti.add(v);
	}
	
	/**
	 * seleziona il sottoinsieme di voti che hanno il punteggio specificato
	 * @param punti punteggio da ricercare
	 * @return lista di {@link Voto} aventi quel punteggio (eventalmente vuota)
	 */
	public List<Voto> cercaVoti(int punti){
		List<Voto> result=new ArrayList<Voto>();
		
		for(Voto v: this.voti) {
			if(v.getPunti()==punti) {
				result.add(v);
			}
		}
		return result;

	}
	
	/**
	 * ricerca un {@link Voto} relativo al corso di cui � specificato il nome
	 * @param nomeEsame nome del corso da ricercare
	 * @return il {@link Voto} corrispondente, oppure {@code null} se non esistente 
	 */
	public Voto cercaEsame(String nomeEsame) {
		for(Voto v:this.voti) {
			if(v.getCorso().equals(nomeEsame)) { //posso usare == solo per gli int che sono oggetti semplici o null
				return v;
			}
		}
			return null;
		
	}
	
}
