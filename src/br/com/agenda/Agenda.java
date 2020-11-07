package br.com.agenda;

import br.com.agenda.ui.AgendaFrame;

public class Agenda {

	 public static void main(String[] args) {
		 new Agenda().iniciarTela();	
	 }
	
	 private void iniciarTela(){
		  AgendaFrame frame = new AgendaFrame();
		  frame.setVisible(true);
	 }
}