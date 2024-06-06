package org.generation.italy;

import java.util.InputMismatchException;
import java.util.Scanner;

import org.generation.italy.model.Televisore;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String scelta;
		Televisore t1 = null;
		do {
			System.out.println("\n");
			System.out.println("(1-Crea televisore),(2-Accendi),(3-Spegni),(4-Aumenta Volume),(5-Diminuisci Volume),"
					+ "(6-Cambia Canale),(7-Mostra Canale),(8-Visualizza Elenco Canali),(9-Esci)");
			System.out.println();
			try {
				System.out.println(t1.toString());
			} catch (Exception e) {
				System.out.println("TV non inserito");
			}
			scelta = sc.nextLine();
			scelta=controlloTv(t1, scelta);
			switch (scelta) {
			case ("1"):
				// Crea televisore
				System.out.println();
				System.out.println("Vuoi inserire la modalità Hotel? (digitare si per inserirla)");
				String scelta2 = sc.nextLine().toLowerCase();
				if (scelta2.equals("si")) {
					System.out.println("Inserisci marca: ");
					String marca = sc.nextLine();
					System.out.println("Inserisci modello: ");
					String modello = sc.nextLine();
					int nrPollici=0;
					do {
					System.out.println("Inserisci numero pollici: "); 
					try {
						nrPollici = sc.nextInt();
						sc.nextLine();
					}catch (InputMismatchException e) {
						System.out.println("input non valido"+e.getMessage());						
					}
					}while(nrPollici==0);									
					System.out.println("Seleziona modalità hotel (vero/falso)");
					boolean modalitàHotel;
					String scelta3 = sc.nextLine();
					while (!(scelta3.equals("vero") || scelta3.equals("falso"))) { // da rivedere
						System.out.println("inserire vero o falso");
						scelta3 = sc.nextLine();
					}
					if (scelta3.equals("vero")) {
						modalitàHotel = true;
					} else {
						modalitàHotel = false;
					}
					try {
						t1 = new Televisore(marca, modello, nrPollici, modalitàHotel);
					} catch (Exception e) {
						System.out.println("Si è verificato un errore: " + e.getMessage());
						break;
					}
				} else {
					System.out.println("Inserisci marca: ");
					String marca = sc.nextLine();
					System.out.println("Inserisci modello: ");
					String modello = sc.nextLine();
					int nrPollici=0;
					do {
					System.out.println("Inserisci numero pollici: "); 
					try {
						nrPollici = sc.nextInt();
						sc.nextLine();
					}catch (InputMismatchException e) {
						System.out.println("input non valido"+e.getMessage());						
					}
					}while(nrPollici==0);	
					try {
						t1 = new Televisore(marca, modello, nrPollici);
					} catch (Exception e) {
						System.out.println("Si è verificato un errore: " + e.getMessage());
						break;
					}
				}
				break;
			case ("2"):// accendi
				System.out.println();
				t1.accendi();
				break;
			case ("3"):// spegni
				System.out.println();
				t1.spegni();
				break;
			case ("4"):// aumenta volume
				System.out.println();
				t1.aumentaVolume();
				break;
			case ("5"):// diminuisci volume
				System.out.println();
				t1.diminuisciVolume();
				break;
			case ("6"):// seleziona canale
				System.out.println();
				System.out.println("seleziona canale: ");
				int canale = sc.nextInt();
				sc.nextLine();
				while(canale<1||canale>10) {
					System.out.println("Canale inesistente - Reinserire");
					canale = sc.nextInt();
					sc.nextLine();
				}
				boolean riuscito = t1.cambiaCanale(canale);
				if (!riuscito)
					System.out.println("Canale già selezionato");
				break;
			case ("7"):// mostra canale
				try {
					System.out.println();
					int canalecorrente = t1.getCanaleCorrente();
					String mostracanale=t1.mostraCanale(canalecorrente);
					System.out.println(mostracanale);
				}catch (Exception e) {
					System.out.println("Nessun canale selezionato");
				}
				
				break;
			case ("8"):// visualizza elenco canali
				t1.visualizzaElencoCanali();
				break;
			case ("9"):// esci
				break;
			default:
				System.out
						.println("(1-Crea televisore),(2-Accendi),(3-Spegni),(4-Aumenta Volume),(5-Diminuisci Volume),"
								+ "(6-Cambia Canale),(7-Mostra Canale),(8-Visualizza Elenco Canali),(9-Esci)");
				scelta = sc.nextLine();
			}

		} while (!(scelta.equals("9")));
		System.out.println();
		System.out.println("Arrivederci");

	}
	static String controlloTv(Televisore televisore,String selezione) {
		if (selezione.equals("1")) {
			return selezione;
		}			
		else {
			if (televisore == null) {
				System.out.println("TV non inserito - Avvio inserimento");
				selezione="1";
				return selezione;			
			}else
				return selezione;			
		}
		
	}
}


