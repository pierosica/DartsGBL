package org.darts;

import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class IntestazionePanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private final static ButtonGroup buttonGroup = new ButtonGroup();
	private int selectedVal = 2;
	private JPanel contentPane;
	private Border borderIntestazione = new EtchedBorder(EtchedBorder.LOWERED,
			null, null);

	/**
	 * Create the panel.
	 */
	public IntestazionePanel() {
		// pnlIntestazione.setBounds(0, 0, 500, 40);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 200, 200, 0 };
		gbl_contentPane.rowHeights = new int[] { 67, 200, 0 };
		gbl_contentPane.columnWeights = new double[] { 1.0, 0.0,
				Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { 1.0, 0.0, Double.MIN_VALUE };
		contentPane.setLayout(gbl_contentPane);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 150, 0, 0, 0, 0, 160, 0 };
		gridBagLayout.rowHeights = new int[] { 43, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		JLabel label = new JLabel("Numero Giocatori");
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.insets = new Insets(0, 0, 0, 5);
		gbc_label.gridx = 0;
		gbc_label.gridy = 0;
		add(label, gbc_label);

		JRadioButton radioButton = new JRadioButton("2");
		radioButton.setSelected(true);
		GridBagConstraints gbc_radioButton = new GridBagConstraints();
		gbc_radioButton.insets = new Insets(0, 0, 0, 5);
		gbc_radioButton.gridx = 1;
		gbc_radioButton.gridy = 0;
		add(radioButton, gbc_radioButton);

		JRadioButton radioButton_1 = new JRadioButton("3");
		GridBagConstraints gbc_radioButton_1 = new GridBagConstraints();
		gbc_radioButton_1.insets = new Insets(0, 0, 0, 5);
		gbc_radioButton_1.gridx = 2;
		gbc_radioButton_1.gridy = 0;
		add(radioButton_1, gbc_radioButton_1);

		JRadioButton radioButton_2 = new JRadioButton("4");
		GridBagConstraints gbc_radioButton_2 = new GridBagConstraints();
		gbc_radioButton_2.insets = new Insets(0, 0, 0, 5);
		gbc_radioButton_2.gridx = 3;
		gbc_radioButton_2.gridy = 0;
		add(radioButton_2, gbc_radioButton_2);

		JButton button = new JButton("Nuova Partita");
		GridBagConstraints gbc_button = new GridBagConstraints();
		gbc_button.insets = new Insets(0, 0, 0, 5);
		gbc_button.gridx = 4;
		gbc_button.gridy = 0;
		add(button, gbc_button);

		JButton button_1 = new JButton("Calcola Chiusura");
		GridBagConstraints gbc_button_1 = new GridBagConstraints();
		gbc_button_1.gridx = 5;
		gbc_button_1.gridy = 0;
		add(button_1, gbc_button_1);
	}

	public int getSelectedVal() {
		return selectedVal;
	}

	public int getSelectedButtonVal(ButtonGroup buttonGroup) {
		for (Enumeration<AbstractButton> buttons = buttonGroup.getElements(); buttons
				.hasMoreElements();) {
			AbstractButton button = buttons.nextElement();

			if (button.isSelected()) {
				return (Integer.parseInt(button.getText()));
			}
		}
		return 0;
	}
}