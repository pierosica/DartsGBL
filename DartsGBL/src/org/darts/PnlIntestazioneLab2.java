package org.darts;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Color;
import javax.swing.JRadioButton;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.border.EtchedBorder;

public class PnlIntestazioneLab2 extends JPanel {

	private static final long serialVersionUID = -3659421407056991803L;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private static int selectedVal = 2;

	/**
	 * Create the panel.
	 */
	public PnlIntestazioneLab2() {
		setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		//setBackground(new Color(0, 255, 0));
		setOpaque(false);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 50, 0 };
		gridBagLayout.columnWeights = new double[] { 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0 };
		gridBagLayout.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		JLabel lblNewLabel = new JLabel("Numero Giocatori");
		lblNewLabel.setBackground(new Color(255, 0, 0));
		lblNewLabel.setOpaque(false);
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 0;
		add(lblNewLabel, gbc_lblNewLabel);

		JRadioButton rdb2 = new JRadioButton("2");
		rdb2.setSelected(true);
		buttonGroup.add(rdb2);
		GridBagConstraints gbc_rdb2 = new GridBagConstraints();
		gbc_rdb2.insets = new Insets(0, 0, 0, 5);
		gbc_rdb2.fill = GridBagConstraints.HORIZONTAL;
		gbc_rdb2.gridx = 2;
		gbc_rdb2.gridy = 0;
		add(rdb2, gbc_rdb2);

		JRadioButton rdb3 = new JRadioButton("3");
		buttonGroup.add(rdb3);
		GridBagConstraints gbc_rdb3 = new GridBagConstraints();
		gbc_rdb3.insets = new Insets(0, 0, 0, 5);
		gbc_rdb3.fill = GridBagConstraints.HORIZONTAL;
		gbc_rdb3.gridx = 3;
		gbc_rdb3.gridy = 0;
		add(rdb3, gbc_rdb3);

		JRadioButton rdb4 = new JRadioButton("4");
		buttonGroup.add(rdb4);
		GridBagConstraints gbc_rdb4 = new GridBagConstraints();
		gbc_rdb4.insets = new Insets(0, 0, 0, 5);
		gbc_rdb4.fill = GridBagConstraints.HORIZONTAL;
		gbc_rdb4.gridx = 4;
		gbc_rdb4.gridy = 0;
		add(rdb4, gbc_rdb4);

		JButton btnNuovaPartita = new JButton("Nuova Partita");
		GridBagConstraints gbc_btnNuovaPartita = new GridBagConstraints();
		gbc_btnNuovaPartita.insets = new Insets(0, 0, 0, 5);
		gbc_btnNuovaPartita.gridx = 5;
		gbc_btnNuovaPartita.gridy = 0;
		btnNuovaPartita.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// selectedVal = getSelectedButtonVal(buttonGroup);
				// conferma.setVisible(true);
				jOptionPanelConferma();
				// DartMain.buildIt(selectedVal);
			}
		});
		add(btnNuovaPartita, gbc_btnNuovaPartita);

		JButton btnCalcolaChiusura = new JButton("Calcola Chiusura");
		GridBagConstraints gbc_btnCalcolaChiusura = new GridBagConstraints();
		gbc_btnCalcolaChiusura.insets = new Insets(5, 5, 5, 5);
		gbc_btnCalcolaChiusura.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnCalcolaChiusura.gridx = 6;
		gbc_btnCalcolaChiusura.gridy = 0;
		add(btnCalcolaChiusura, gbc_btnCalcolaChiusura);
	}

	public void jOptionPanelConferma() {
		Object[] options = { "Conferma", "Annulla" };
		int n = JOptionPane.showOptionDialog(this, "Sei davvero sicuro di voler iniziare una nuova partita?", "A T T E N Z I O N E ! ! !",
				JOptionPane.DEFAULT_OPTION, JOptionPane.DEFAULT_OPTION,
				null, options, options[1]);
		if (n == 0) {
			selectedVal = getSelectedButtonVal(buttonGroup);
			GuiLab2.buildIt(selectedVal);
		} else if (n == 1) {
			// usata se clikko Annulla
		} else {
			// usata se chiudo la jdialogpane con la "X"
		}
	}

	public static int getSelectedVal() {
		return selectedVal;
	}

	public int getSelectedButtonVal(ButtonGroup buttonGroup) {
		for (Enumeration<AbstractButton> buttons = buttonGroup.getElements(); buttons.hasMoreElements();) {
			AbstractButton button = buttons.nextElement();
			if (button.isSelected()) {
				return (Integer.parseInt(button.getText()));
			}
		}
		return 0;
	}
}
