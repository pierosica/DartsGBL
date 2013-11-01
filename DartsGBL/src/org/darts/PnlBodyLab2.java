package org.darts;

import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class PnlBodyLab2 extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6866172652472739639L;

	/**
	 * Create the panel.
	 */
	public PnlBodyLab2(int numeroGiocatori) {
		setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 200, 200, 200, 200, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0 };
		gridBagLayout.columnWeights = new double[] { 1.0, 1.0, 1.0, 1.0,
				Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 1.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		PnlPlayerLab2 pnlPlayer;
		for (int i = 0; i < numeroGiocatori; i++) {
			System.out.println(numeroGiocatori);
			pnlPlayer = new PnlPlayerLab2(i);
			GridBagConstraints gbc_pnlPlayerLab2 = new GridBagConstraints();
			gbc_pnlPlayerLab2.insets = new Insets(0, 5, 0, 5);
			gbc_pnlPlayerLab2.fill = GridBagConstraints.BOTH;
			gbc_pnlPlayerLab2.gridx = i;
			gbc_pnlPlayerLab2.gridy = 0;
			add(pnlPlayer, gbc_pnlPlayerLab2);
		}
	}
}
