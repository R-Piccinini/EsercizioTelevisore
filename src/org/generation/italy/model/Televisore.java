package org.generation.italy.model;

public class Televisore {

	private String marca, modello;
	private Integer nrPollici;
	private boolean stato;
	private Integer volume;
	private boolean modalitàHotel;
	private String[] elencoCanali = { "Rai 1", "Rai 2", "Rai 3", "Rete 4", "Canale 5", "Italia 1", "La 7", "TV 8",
			"Nove", "D-Max" };
	private Integer canaleCorrente;

	public Televisore(String marca, String modello, Integer nrPollici) throws Exception {
		super();
		if (marca.isEmpty()) {
			throw new Exception("marca non valida");
		} else {
			this.marca = marca;
		}

		if (modello.isEmpty()) {
			throw new Exception("modello non valido");
		} else {
			this.modello = modello;
		}

		if (nrPollici <= 0 || nrPollici > 70) {
			throw new Exception("numero Pollici non validi");

		} else {
			this.nrPollici = nrPollici;
		}

		this.stato = false;
		this.volume = 0;
		this.modalitàHotel = false;

	}

	public Televisore(String marca, String modello, Integer nrPollici, boolean modalitàHotel) throws Exception {
		super();
		if (marca.isEmpty()) {
			throw new Exception("marca non valida");
		} else {
			this.marca = marca;
		}

		if (modello.isEmpty()) {
			throw new Exception("modello non valido");
		} else {
			this.modello = modello;
		}

		if (nrPollici <= 0 || nrPollici > 70) {
			throw new Exception("numero Pollici non validi");

		} else {
			this.nrPollici = nrPollici;
		}

		setModalitàHotel(modalitàHotel);
		this.stato = false;
		this.volume = 0;

	}

	public void accendi() {
		if (!stato) {
			stato = true;
			System.out.println("TV acceso");
			canaleCorrente = 1;
		} else {
			System.out.println("TV già acceso");
		}

	}

	public void spegni() {
		if (!stato) {
			System.out.println("TV già spento");
		} else {
			stato = false;
			System.out.println("TV spento");
		}

	}

	public void aumentaVolume() {
		if (stato) {
			if (modalitàHotel) {
				if (volume < 5) {
					volume++;
					System.out.println(volume);
				} else {
					System.out.println("Volume MAX");
				}
			} else {
				if (volume < 10) {
					volume++;
					System.out.println(volume);
				} else {
					System.out.println("Volume MAX");
				}
			}
		} else
			System.out.println("Il è TV Spento");
	}

	public void diminuisciVolume() {
		if (stato) {
			if (volume > 0) {
				volume--;
				System.out.println(volume);
			} else {
				System.out.println("Volume MIN");
			}
		} else
			System.out.println("Il è TV Spento");
	}

	public boolean cambiaCanale(int canale) {
		if (!stato) {
			System.out.println("Il è TV Spento");;
			return true;
		} else {
			if (!(canale == canaleCorrente)) {
				canaleCorrente = canale;
				boolean riuscito = true;
				return riuscito;
			} else {
				boolean riuscito = false;
				return riuscito;
			}

		}

	}

	public String mostraCanale(int canale) {
		if (stato) {
		String mostraCanale = "Stai guardando il canale " + elencoCanali[canale - 1];
		return mostraCanale;
		}else
			System.out.println("Il è TV Spento");
			return "sss";
	}

	public void visualizzaElencoCanali() {
		for (String i : elencoCanali) {
			System.out.print(" - " + i + " - ");
		}
	}

	// getter e setter
	public boolean isModalitàHotel() {
		return modalitàHotel;
	}

	public void setModalitàHotel(boolean modalitàHotel) throws Exception {
		if (modalitàHotel)
			this.modalitàHotel = modalitàHotel;
		else if (!(modalitàHotel))
			this.modalitàHotel = modalitàHotel;
		else
			throw new Exception("modalità non valida");

	}

	public String getMarca() {
		return marca;
	}

	public String getModello() {
		return modello;
	}

	public Integer getNrPollici() {
		return nrPollici;
	}

	public boolean isStato() {
		return stato;
	}

	public Integer getVolume() {
		return volume;
	}

	public String[] getElencoCanali() {
		return elencoCanali;
	}

	public Integer getCanaleCorrente() {
		return canaleCorrente;
	}

	@Override
	public String toString() {
		return "Televisore [Marca=" + marca + ", Modello=" + modello + ", Pollici=" + nrPollici + ", Stato=" + stato
				+ ", Volume=" + volume + ", Modalità Hotel=" + modalitàHotel + ", Canale corrente=" + canaleCorrente
				+ "]";
	}

}// fine class
