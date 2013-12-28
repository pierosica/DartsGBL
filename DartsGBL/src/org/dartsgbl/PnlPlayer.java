package org.dartsgbl;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class PnlPlayer extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2648011732529825438L;
	public static int NumeroRighe = 21;
	private PnlRow riga;
	public int IDpannello;
	public PnlRow[] rowArray = new PnlRow[NumeroRighe];

	/**
	 * Create the panel.
	 */
	public PnlPlayer(int id) {
		this.IDpannello = id;
		setName("id");
		setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		setBackground(new Color(255, 0, 0));
		setOpaque(true);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0 };
		gridBagLayout.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 1.0, 1.0, 1.0, 1.0, 1.0, 1.0,
				1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0,
				1.0, 1.0, 1.0 };
		setLayout(gridBagLayout);

		for (int i = 0; i < NumeroRighe; i++) {
			riga = new PnlRow(this.IDpannello, i);
			rowArray[i] = riga;
			GridBagConstraints gbc_riga = new GridBagConstraints();
			gbc_riga.fill = GridBagConstraints.BOTH;
			gbc_riga.insets = new Insets(2, 2, 2, 2);
			gbc_riga.gridx = 0;
			gbc_riga.gridy = i;
			add(riga, gbc_riga);
		}
	}
}
