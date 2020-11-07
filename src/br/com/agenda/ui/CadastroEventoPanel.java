package br.com.agenda.ui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import br.com.agenda.io.AgendaIO;
import br.com.agenda.utils.AgendaUtils;
import br.com.agenda.utils.PeriodicidadeEnum;
import br.com.agenda.utils.ValidaEvento;
import br.com.agenda.vo.Evento;

import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import java.awt.Color;

public class CadastroEventoPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField tfDescricaoEvento, tfEncaminharEmail;
	private JLabel lbMsgEncaminharEmail;
	private JFormattedTextField ftfDataEvento;
	private JCheckBox chckbxAlarme;
	private JRadioButton rdbtnUmaVez, rdbtnSemanal, rdbtnMensal;
	private JButton btnSalvar, btnLimpar;
	private final ButtonGroup bgPeriodicidadeEvento = new ButtonGroup();
	private ListaEventosPanel listaEventos;
	private JLabel lbMsgDataEvento;

	/**
	 * Create the panel.
	 */
	public CadastroEventoPanel(ListaEventosPanel listaEventos) {
		this.listaEventos = listaEventos;
		
		setToolTipText("");
		setLayout(null);
		
		JLabel lbDescricaoEvento = new JLabel("Descrição do Evento");
		lbDescricaoEvento.setFont(new Font("Dialog", Font.BOLD, 11));
		lbDescricaoEvento.setBounds(124, 22, 145, 15);
		add(lbDescricaoEvento);
		
		tfDescricaoEvento = new JTextField();
		tfDescricaoEvento.setBounds(124, 40, 445, 20);
		add(tfDescricaoEvento);
		tfDescricaoEvento.setColumns(10);
		
		JLabel lbDataEvento = new JLabel("Data do Evento");
		lbDataEvento.setFont(new Font("Dialog", Font.BOLD, 11));
		lbDataEvento.setBounds(124, 98, 126, 15);				
		add(lbDataEvento);
		
		try {
			ftfDataEvento = new JFormattedTextField(new MaskFormatter("##/##/####"));
			ftfDataEvento.setBounds(286, 95, 86, 20);
			add(ftfDataEvento);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		JLabel lbEncaminharEmail = new JLabel("Encaminhar E-mail");
		lbEncaminharEmail.setFont(new Font("Dialog", Font.BOLD, 11));
		lbEncaminharEmail.setBounds(124, 146, 126, 15);
		add(lbEncaminharEmail);
		
		tfEncaminharEmail = new JTextField();
		tfEncaminharEmail.setColumns(10);
		tfEncaminharEmail.setBounds(286, 143, 283, 20);
		add(tfEncaminharEmail);
		
		JLabel lblPeriodicidadeDoEvento = new JLabel("Periodicidade do Evento");
		lblPeriodicidadeDoEvento.setFont(new Font("Dialog", Font.BOLD, 11));
		lblPeriodicidadeDoEvento.setBounds(124, 194, 164, 15);
		add(lblPeriodicidadeDoEvento);
		
		rdbtnUmaVez = new JRadioButton("Uma Vez");
		rdbtnUmaVez.setSelected(true);
		bgPeriodicidadeEvento.add(rdbtnUmaVez);
		rdbtnUmaVez.setBounds(286, 189, 86, 23);
		add(rdbtnUmaVez);
		
		rdbtnSemanal = new JRadioButton("Semanal");
		bgPeriodicidadeEvento.add(rdbtnSemanal);
		rdbtnSemanal.setBounds(392, 189, 86, 23);
		add(rdbtnSemanal);
		
		rdbtnMensal = new JRadioButton("Mensal");
		bgPeriodicidadeEvento.add(rdbtnMensal);
		rdbtnMensal.setBounds(493, 189, 76, 23);
		add(rdbtnMensal);
		
		chckbxAlarme = new JCheckBox("Alarme");
		chckbxAlarme.setBounds(124, 271, 76, 23);
		add(chckbxAlarme);
		
		btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(322, 270, 117, 25);
		add(btnSalvar);

		btnLimpar = new JButton("Limpar");
		btnLimpar.setBounds(452, 270, 117, 25);
		add(btnLimpar);
		
		lbMsgEncaminharEmail = new JLabel("");
		lbMsgEncaminharEmail.setFont(new Font("Dialog", Font.BOLD, 10));
		lbMsgEncaminharEmail.setForeground(Color.RED);
		lbMsgEncaminharEmail.setBounds(286, 128, 283, 15);
		add(lbMsgEncaminharEmail);
		
		lbMsgDataEvento = new JLabel("");
		lbMsgDataEvento.setForeground(Color.RED);
		lbMsgDataEvento.setFont(new Font("Dialog", Font.BOLD, 10));
		lbMsgDataEvento.setBounds(286, 72, 283, 15);
		add(lbMsgDataEvento);
		
		btnSalvar.addActionListener(new ActionListener() {
			 @Override
			 public void actionPerformed(ActionEvent arg0) {	
			    chamaCadastroEvento();
			 }
		});

		btnLimpar.addActionListener(new ActionListener() {
			 @Override
			 public void actionPerformed(ActionEvent arg0) {
				 limparCampos();
			 }
		});
	}
	
	private void chamaCadastroEvento(){
		  AgendaIO io = new AgendaIO();
		  Evento evento = new Evento();
	
		  Object[] novaLinha = new Object[5];
	
		  evento.setDataEvento(AgendaUtils.getDateFromString(ftfDataEvento.getText()));
		  evento.setDescEvento(tfDescricaoEvento.getText());
		  evento.setAlarme(chckbxAlarme.isSelected() ? 1 : 0);
		  evento.setEmailEncaminhar(tfEncaminharEmail.getText());
	
		  novaLinha[0] = ftfDataEvento.getText();
		  novaLinha[1] = tfDescricaoEvento.getText();
		  novaLinha[4] = chckbxAlarme.isSelected() ? "LIGADO" : "DESLIGADO";
		  novaLinha[3] = tfEncaminharEmail.getText();
	
		  if(rdbtnUmaVez.isSelected()){
			   evento.setPeriodicidade(PeriodicidadeEnum.UNICO);
			   novaLinha[2] = PeriodicidadeEnum.UNICO;
		  }
		  else if(rdbtnSemanal.isSelected()){
			   evento.setPeriodicidade(PeriodicidadeEnum.SEMANAL);
			   novaLinha[2] = PeriodicidadeEnum.SEMANAL;
		  }
		  else {
			   evento.setPeriodicidade(PeriodicidadeEnum.MENSAL);
			   novaLinha[2] = PeriodicidadeEnum.MENSAL;
		  }
	
		  try {			  
			  String mensagemEmail = ValidaEvento.ValidaEmail(evento);
			  lbMsgEncaminharEmail.setText(mensagemEmail);
				 
			  String mensagemData = ValidaEvento.ValidaData(evento);
			  lbMsgDataEvento.setText(mensagemData);			 
			 
			  if (!mensagemEmail.isEmpty() || !mensagemData.isEmpty()) {
				  return;
			  }	
				 
			  io.gravarEvento(evento);
		  }catch(Exception ex){
			   JOptionPane.showMessageDialog(null, "ERRO", ex.getMessage(),
			   JOptionPane.ERROR_MESSAGE);
		  }

		  listaEventos.addNewRow(novaLinha);
		  limparCampos();
	}
	
	private void limparCampos(){
		tfDescricaoEvento.setText("");
		ftfDataEvento.setText("");		  
		chckbxAlarme.setSelected(false);
		tfEncaminharEmail.setText("");
		rdbtnUmaVez.setSelected(true);
		lbMsgEncaminharEmail.setText("");
		lbMsgDataEvento.setText("");
	}	
}
