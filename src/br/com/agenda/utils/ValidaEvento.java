package br.com.agenda.utils;

import java.util.Date;

import br.com.agenda.vo.Evento;

public class ValidaEvento {

	private static final String EMAIL_PATTERN = 
		    "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
		    + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	
	public static String ValidaEmail(Evento evento) {
		String mensagem = "";
		if (!evento.getEmailEncaminhar().isEmpty() && !evento.getEmailEncaminhar().matches(EMAIL_PATTERN)){
			mensagem = "E-mail incorreto";
		}
		
		return mensagem;
	}
	
	@SuppressWarnings("deprecation")
	public static String ValidaData(Evento evento) {
		String mensagem = "";
		Date hoje = new Date();
		
		if (evento.getDataEvento().toString().isEmpty()) {
			mensagem = "Campo obrigatório";
		}
		
		if (!evento.getDataEvento().toString().isEmpty() && evento.getDataEvento().compareTo(hoje) < 0) {
			mensagem = "Data deve ser maior que hoje";
		}
		
		if (!evento.getDataEvento().toString().isEmpty() && evento.getDataEvento().getYear() > 3000) {
			mensagem = "O ano deve ser menor que 3000";
		}
		
		return mensagem;
	}
}
