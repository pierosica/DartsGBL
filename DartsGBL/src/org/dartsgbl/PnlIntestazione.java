package org.dartsgbl;

import java.awt.GridBagLayout;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.Color;
import java.awt.RenderingHints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.border.EtchedBorder;

public class PnlIntestazione extends JPanel {

	private static final long serialVersionUID = -3659421407056991803L;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private static int selectedVal = 2;
	public static int numGiocatoriOld = 2;
	private static int nG;
//	private static int nGOld;
	private static final JRadioButton rdb2 = new JRadioButton("2");
	private static final JRadioButton rdb3 = new JRadioButton("3");
	private static final JRadioButton rdb4 = new JRadioButton("4");
//	private static AbstractButton changeButton;
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_RENDERING,
				RenderingHints.VALUE_RENDER_QUALITY);
		int w = getWidth();
		int h = getHeight();
		// Color color1 = Color.WHITE;
		// Color color2 = color1.darker();
		Color color1 = new Color(231, 231, 231);
		Color color2 = new Color(201, 201, 201);
		GradientPaint gp = new GradientPaint(0, 0, color1, 0, h, color2);
		g2d.setPaint(gp);
		g2d.fillRect(0, 0, w, h);
	}

	/**
	 * Create the panel.
	 */
	public PnlIntestazione() {
		setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		setOpaque(false);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 50, 0 };
		gridBagLayout.columnWeights = new double[] { 1.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 1.0 };
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

//		ItemListener itemListener = new ItemListener() {
//			@Override
//			public void itemStateChanged(ItemEvent itemEvent) {
//				if (itemEvent.getStateChange() == ItemEvent.DESELECTED) {
//					changeButton = (AbstractButton) itemEvent
//							.getSource();
//					numGiocatoriOld = Integer.parseInt(changeButton.getText());
////					System.out.println("numGiocatoriOld: " + numGiocatoriOld);
////					jOptionPanelConferma();
//				}
//			}
//		};

		ActionListener actionPerformed = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				AbstractButton aButton = (AbstractButton) e.getSource();
//				System.out.println(aButton.isSelected());
				selectedVal = Integer.parseInt(aButton.getText());
//				System.out.println("selectedVal: " + selectedVal);
				jOptionPanelConferma();
			}
		};

		rdb2.setSelected(true);
		rdb2.setOpaque(false);
		buttonGroup.add(rdb2);
//		rdb2.addItemListener(itemListener);
		rdb2.addActionListener(actionPerformed);
		GridBagConstraints gbc_rdb2 = new GridBagConstraints();
		gbc_rdb2.insets = new Insets(0, 0, 0, 5);
		gbc_rdb2.fill = GridBagConstraints.HORIZONTAL;
		gbc_rdb2.gridx = 2;
		gbc_rdb2.gridy = 0;
		add(rdb2, gbc_rdb2);

		rdb3.setOpaque(false);
		buttonGroup.add(rdb3);
//		rdb3.addItemListener(itemListener);
		rdb3.addActionListener(actionPerformed);
		GridBagConstraints gbc_rdb3 = new GridBagConstraints();
		gbc_rdb3.insets = new Insets(0, 0, 0, 5);
		gbc_rdb3.fill = GridBagConstraints.HORIZONTAL;
		gbc_rdb3.gridx = 3;
		gbc_rdb3.gridy = 0;
		add(rdb3, gbc_rdb3);

		rdb4.setOpaque(false);
		buttonGroup.add(rdb4);
//		rdb4.addItemListener(itemListener);
		rdb4.addActionListener(actionPerformed);
		GridBagConstraints gbc_rdb4 = new GridBagConstraints();
		gbc_rdb4.insets = new Insets(0, 0, 0, 5);
		gbc_rdb4.fill = GridBagConstraints.HORIZONTAL;
		gbc_rdb4.gridx = 4;
		gbc_rdb4.gridy = 0;
		add(rdb4, gbc_rdb4);

//		JButton btnNuovaPartita = new JButton("Nuova Partita");
//		GridBagConstraints gbc_btnNuovaPartita = new GridBagConstraints();
//		gbc_btnNuovaPartita.insets = new Insets(0, 0, 0, 5);
//		gbc_btnNuovaPartita.gridx = 5;
//		gbc_btnNuovaPartita.gridy = 0;
//		btnNuovaPartita.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				jOptionPanelConferma();
//			}
//		});
//		add(btnNuovaPartita, gbc_btnNuovaPartita);

		JButton btnCalcolaChiusura = new JButton("Calcola Chiusura");
		GridBagConstraints gbc_btnCalcolaChiusura = new GridBagConstraints();
		gbc_btnCalcolaChiusura.insets = new Insets(5, 5, 5, 5);
		gbc_btnCalcolaChiusura.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnCalcolaChiusura.gridx = 6;
		gbc_btnCalcolaChiusura.gridy = 0;
		btnCalcolaChiusura.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				PnlBody.calcolaChiusura();
			}
		});
		add(btnCalcolaChiusura, gbc_btnCalcolaChiusura);
	}

	public void jOptionPanelConferma() {
		Object[] options = { "Conferma", "Annulla" };
		int n = JOptionPane.showOptionDialog(this,
				"Sei davvero sicuro di voler iniziare una nuova partita?",
				"A T T E N Z I O N E ! ! !", JOptionPane.DEFAULT_OPTION,
				JOptionPane.DEFAULT_OPTION, null, options, options[1]);
		if (n == 0) {
			DartsGBL.reBuildIt(selectedVal);
			DartsGBL.buildIt(selectedVal);
		} else if (n == 1) {
			// usata se clikko Annulla
		} else {
			// usata se chiudo la jdialogpane con la "X"
		}
	}

	public static int getNumeroGiogatori() {
		if (rdb2.isSelected()) {
			nG = 2;
		}
		if (rdb3.isSelected()) {
			nG = 3;
		}
		if (rdb4.isSelected()) {
			nG = 4;
		}
		return nG;
	}
}
