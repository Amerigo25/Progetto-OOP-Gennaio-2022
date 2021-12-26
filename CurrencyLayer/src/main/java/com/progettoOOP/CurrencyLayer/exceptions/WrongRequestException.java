package com.progettoOOP.CurrencyLayer.exceptions;

public class WrongRequestException extends Exception {
	/** Eccezione personalizzata che viene lanciata se l'utente inserisce un codice per la valuta non presente 
	 * tra quelle ammesse dall'API o se inserisce una data inesistente o nel formato sbagliato
	 * @author Amerigo Aloisi
	 * @author Kristian Likaj
	 * */

		private static final long serialVersionUID = 1L;

		public WrongRequestException(String message) {
			super(message);
		}
	}

