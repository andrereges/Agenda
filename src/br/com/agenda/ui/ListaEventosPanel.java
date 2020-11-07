package br.com.agenda.ui;

import java.awt.BorderLayout;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import br.com.agenda.io.AgendaIO;

public class ListaEventosPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTable table;

	/**
	 * Create the panel.
	 */
	public ListaEventosPanel() {
		  setLayout(new BorderLayout(0, 0));
	
		  table = new JTable(getDataColumns(), getNameColumns());
		  JScrollPane scroll = new JScrollPane(table);
		  add(scroll, BorderLayout.CENTER);
	}
	
	private Vector<String> getNameColumns(){
		  Vector<String> nameColumns = new Vector<String>();
		  nameColumns.add("Data");
		  nameColumns.add("Descrição");
		  nameColumns.add("Periodicidade");
		  nameColumns.add("E-mail");
		  nameColumns.add("Alarme");

		  return nameColumns;
	}

	public void addNewRow(Object[] valores){
		((DefaultTableModel)table.getModel()).addRow(valores);
	}
	
	private Vector<Vector<Object>> getDataColumns(){
		  AgendaIO io = new AgendaIO();
		  Vector<Vector<Object>> dataColumns = null;
	
		  try {
		   dataColumns = io.getEventos();
		  }catch(Exception ex){
		   JOptionPane.showMessageDialog(null, "ERRO", ex.getMessage(),
		   JOptionPane.ERROR_MESSAGE);
		  }
	
		  return dataColumns;
	}
}
