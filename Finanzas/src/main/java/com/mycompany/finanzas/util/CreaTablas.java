package com.mycompany.finanzas.util;

import javax.persistence.Persistence;

public class CreaTablas {

	public static void main(String[] args) {
		Persistence.createEntityManagerFactory("FinanzasPU");

	}

}
