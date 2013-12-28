package org.dartsgbl;

import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JButton;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PnlCompositeRowLab2 extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5976457241163890455L;
	public LblNumeroLab2 lblNumeroA;
	public LblNumeroLab2 lblNumeroB;
	public LblNumeroLab2 lblNumeroC;
	private boolean rowChiusa;
	private boolean rowMorta;

	public boolean isRowChiusa(int idpannello, int idriga) {
		return rowChiusa;
	}

	private void setRowChiusa(int idpannello, int idriga, boolean rowchiusa) {
		rowChiusa = rowchiusa;
	}

	/**
	 * Create the panel.
	 */
	public PnlCompositeRowLab2(final int idpannello, final int idriga) {
		Insets internalPadding = new Insets(2, 2, 2, 2);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 45, 30, 30, 30, 20 };
		gridBagLayout.rowHeights = new int[] { 3, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 1.0, 1.0, 1.0, 0.0,
				Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 1.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		lblNumeroA = new LblNumeroLab2();
		GridBagConstraints gbc_lblNewLabel1 = new GridBagConstraints();
		gbc_lblNewLabel1.fill = GridBagConstraints.BOTH;
		gbc_lblNewLabel1.insets = new Insets(2, 2, 2, 5);
		gbc_lblNewLabel1.gridx = 1;
		gbc_lblNewLabel1.gridy = 0;
		add(lblNumeroA, gbc_lblNewLabel1);

		lblNumeroB = new LblNumeroLab2();
		lblNumeroB.setOpaque(true);
		GridBagConstraints gbc_lblNewLabel2 = new GridBagConstraints();
		gbc_lblNewLabel2.fill = GridBagConstraints.BOTH;
		gbc_lblNewLabel2.insets = new Insets(2, 2, 2, 5);
		gbc_lblNewLabel2.gridx = 2;
		gbc_lblNewLabel2.gridy = 0;
		add(lblNumeroB, gbc_lblNewLabel2);

		lblNumeroC = new LblNumeroLab2();
		lblNumeroC.setOpaque(true);
		GridBagConstraints gbc_lblNewLabel3 = new GridBagConstraints();
		gbc_lblNewLabel3.fill = GridBagConstraints.BOTH;
		gbc_lblNewLabel3.insets = new Insets(2, 2, 2, 5);
		gbc_lblNewLabel3.gridx = 3;
		gbc_lblNewLabel3.gridy = 0;
		add(lblNumeroC, gbc_lblNewLabel3);

		String btnLabel = (idriga + 1 + "");
		if (idriga == 20) {
			btnLabel = "Bull";
		}
		JButton btnPreso = new JButton(btnLabel);
		btnPreso.setMargin(new Insets(0, 0, 0, 0));
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton.insets = new Insets(2, 2, 2, 5);
		gbc_btnNewButton.gridx = 0;
		gbc_btnNewButton.gridy = 0;
		btnPreso.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (PnlBodyLab2.isNumeroMorto(idriga) || isRowChiusa(idpannello, idriga)) {
					PnlBodyLab2.incrementa(idpannello, idriga);
				} else {
					if (!lblNumeroA.isPreso()) {
						lblNumeroA.setPreso(true);
						setRowChiusa(idpannello, idriga, false);
					} else {
						if (!lblNumeroB.isPreso()) {
							lblNumeroB.setPreso(true);
							setRowChiusa(idpannello, idriga, false);
						} else {
							if (!lblNumeroC.isPreso()) {
								lblNumeroC.setPreso(true);
								setRowChiusa(idpannello, idriga, true);
								rowMorta = PnlBodyLab2.controllaSeDaSettareNumeroMorto(idriga);
								if (rowMorta) {
									PnlBodyLab2.setNumeroMorto(idriga);
								}
							}
						}
					}
				}
			}
		});
		add(btnPreso, gbc_btnNewButton);

		JButton btnTogli = new JButton("");
		btnTogli.setMaximumSize(new Dimension(10, 10));
		btnTogli.setMinimumSize(new Dimension(10, 10));
		btnTogli.setPreferredSize(new Dimension(10, 10));
		GridBagConstraints gbc_btnTogli = new GridBagConstraints();
		gbc_btnTogli.fill = GridBagConstraints.NONE;
		gbc_btnTogli.insets = internalPadding;
		gbc_btnTogli.gridx = 5;
		gbc_btnTogli.gridy = 0;
		btnTogli.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(PnlBodyLab2.isNumeroMorto(idriga)) {
					System.out.println("isNumeroMorto: " + PnlBodyLab2.isNumeroMorto(idriga));
					PnlBodyLab2.setNumeroNonMorto(idriga);
					setRowChiusa(idpannello, idriga, false);
					System.out.println("isNumeroMorto: " + PnlBodyLab2.isNumeroMorto(idriga));
				}
				
				if (isRowChiusa(idpannello, idriga)){
					System.out.println("isRowChiusa: " + isRowChiusa(idpannello, idriga));
					setRowChiusa(idpannello, idriga, false);
					System.out.println("isRowChiusa: " + isRowChiusa(idpannello, idriga));
				}

				if (lblNumeroC.isPreso() & lblNumeroB.isPreso()
						& lblNumeroA.isPreso()) {
					lblNumeroC.setPreso(false);
					setRowChiusa(idpannello, idriga, false);
				} else {
					if (lblNumeroB.isPreso() & lblNumeroA.isPreso()) {
						lblNumeroB.setPreso(false);
						setRowChiusa(idpannello, idriga, false);
					} else {
						if (lblNumeroA.isPreso()) {
							lblNumeroA.setPreso(false);
							setRowChiusa(idpannello, idriga, false);
						}
					}
				}
			}
		});
		add(btnTogli, gbc_btnTogli);
	}
}