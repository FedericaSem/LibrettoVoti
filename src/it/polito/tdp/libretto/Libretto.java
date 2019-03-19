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
	 * ricerca un {@link Voto} relativo al corso di cui è specificato il nome
	 * @param nomeEsame nome del corso da ricercare
	 * @return il {@link Voto} corrispondente, oppure {@code null} se non esistente 
	 */
	public Voto cercaEsame(String nomeEsame) {
		Voto voto=new Voto(0, nomeEsame, null);
		int pos=this.voti.indexOf(voto);
		if(pos==-1) 
			return null;
		else
			return this.voti.get(pos);
		
	}
	
	/**
	 * dato un {@link Voto}, determina se esiste già un voto 
	 *con uguale corso ed uguale punteggio
	 * @param v
	 * @return{@code true}, se ha trovato un corso e punteggio uguali
	 * 		  {@code false}, se non ha trovato il corso, oppure l'ha trovato con
	 * voto diverso 
	 */
	public boolean esisteGiaVoto(Voto v) {
		int pos=this.voti.indexOf(v);
		if(pos==-1)
			return false;
		else 
			return (v.getPunti()==this.voti.get(pos).getPunti());
		
	}
	
	/**
	 * mi dice s eil voto {@link Voto} p in conflitto con uno dei voti esistenti
	 * se il voto non esiste non c'è conflitto
	 * se e siste ed ha punteggio diverso c'è conflitto
	 * @param v
	 * @return {@code true} se il voto esiste ed ha un punteggio diverso
	 * 		   {@code false} se il voto non esiste, oppure esiste ma ha
	 * 			lo stesso punteggio
	 */
	public boolean votoConflitto(Voto v) {
		int pos=this.voti.indexOf(v);
		if(pos==-1)
			return false;
		else 
			return (v.getPunti()!=this.voti.get(pos).getPunti());
		
	}
		
	
	
}
