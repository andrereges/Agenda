package br.com.agenda.utils;

import java.util.Calendar;
import java.util.Date;

public class AgendaUtils {

	 public static Date getDateFromString(String dataStr){
		  Calendar data = Calendar.getInstance();
		  data.set(Calendar.YEAR, Integer.parseInt(dataStr.substring(6, 10)));
		  data.set(Calendar.MONTH, Integer.parseInt(dataStr.substring(3, 5)));
		  data.set(Calendar.DAY_OF_MONTH, Integer.parseInt(dataStr.substring(0, 2)));
		
		  return data.getTime();
	 }
	 
	 public static String formatStringDateBR(String dataStr){
		 
		 switch (dataStr.length()) {
			case 2:
				dataStr += "/"; 
				break;
			case 5:
				dataStr += "/"; 
				break;
			default:
				break;
		}
		 
		if (dataStr.length() > 10) {
			return dataStr.substring(0, 10);
		}

		return dataStr;
	 }
}