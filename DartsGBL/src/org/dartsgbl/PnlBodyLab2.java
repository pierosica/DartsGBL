package org.dartsgbl;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class PnlBodyLab2 extends JPanel {

	private static final long serialVersionUID = 6866172652472739639L;
	private static PnlPlayerLab2[] pnlPlayerArray;
	private static JTextField[] txtNomeArray;
	private static JTextField[] txtPuntiArray;
	private static boolean[] mortoArray;

	public static boolean isNumeroMorto(int riga) {
		return mortoArray[riga];
	}

	public static void setNumeroNonMorto(int riga) {
		mortoArray[riga] = false;
		int numeroGiocatori = PnlIntestazioneLab2.getSelectedVal();
		for (int i = 0; i < numeroGiocatori; i++) {
			PnlPlayerLab2 otherpanel = pnlPlayerArray[i];
			PnlCompositeRowLab2 otherrow = otherpanel.rowArray[riga];
			LblNumeroLab2 lblNumeroA = otherrow.lblNumeroA;
			lblNumeroA.setMorto(false);
			LblNumeroLab2 lblNumeroB = otherrow.lblNumeroB;
			lblNumeroB.setMorto(false);
			LblNumeroLab2 lblNumeroC = otherrow.lblNumeroC;
			lblNumeroC.setMorto(false);
		}
	}

	public static boolean controllaSeDaSettareNumeroMorto(int riga) {
		int numeroGiocatori = PnlIntestazioneLab2.getSelectedVal();
		boolean morto = true;
		for (int i = 0; i < numeroGiocatori; i++) {
			PnlPlayerLab2 otherpanel = pnlPlayerArray[i];
			PnlCompositeRowLab2 otherrow = otherpanel.rowArray[riga];
			morto = morto & otherrow.isRowChiusa(i, riga);
		}
		return morto;
	}

	public static void setNumeroMorto(int riga) {
		mortoArray[riga] = true;
		int numeroGiocatori = PnlIntestazioneLab2.getSelectedVal();
		for (int i = 0; i < numeroGiocatori; i++) {
			PnlPlayerLab2 otherpanel = pnlPlayerArray[i];
			PnlCompositeRowLab2 otherrow = otherpanel.rowArray[riga];
			LblNumeroLab2 lblNumeroA = otherrow.lblNumeroA;
			lblNumeroA.setMorto(true);
			LblNumeroLab2 lblNumeroB = otherrow.lblNumeroB;
			lblNumeroB.setMorto(true);
			LblNumeroLab2 lblNumeroC = otherrow.lblNumeroC;
			lblNumeroC.setMorto(true);
		}
	}

	public static void incrementa(int pannello, int riga) {
		int numeroGiocatori = PnlIntestazioneLab2.getSelectedVal();
		int delta = 1;
		if (riga == 20) {
			delta = 5;
		}
		if (isNumeroMorto(riga)) {
			JTextField mieiPunti = txtPuntiArray[pannello];
			int totale = Integer.parseInt(mieiPunti.getText().toString())
					+ riga + delta;
			mieiPunti.setText("" + totale);
		} else {
			for (int i = 0; i < numeroGiocatori; i++) {
				PnlPlayerLab2 otherpanel = pnlPlayerArray[i];
				PnlCompositeRowLab2 otherrow = otherpanel.rowArray[riga];
				if (i != pannello) {
					if (!otherrow.isRowChiusa(pannello, riga)) {
						JTextField otherPunti = txtPuntiArray[i];
						int totale = Integer.parseInt(otherPunti.getText()
								.toString()) + riga + delta;
						otherPunti.setText("" + totale);
					}
				}
			}
		}
	}

	public static void calcolaChiusura() {
		int numeroGiocatori = PnlIntestazioneLab2.getSelectedVal();
		int numeroRighe = PnlPlayerLab2.NumeroRighe;
		for (int i = 0; i < numeroGiocatori; i++) {
			PnlPlayerLab2 otherpanel = pnlPlayerArray[i];
			JTextField mieiPunti = txtPuntiArray[i];
			int totale = Integer.parseInt(mieiPunti.getText().toString());
			int delta = 1;
			System.out
					.println("calcolaChiusura - for (int i = 0; i < numeroGiocatori; i++) - totale: "
							+ totale);

			for (int j = 0; j < numeroRighe; j++) {
				PnlCompositeRowLab2 otherrow = otherpanel.rowArray[j];
				if (j == 20) {
					delta = 5;
				}
				System.out.println("giocatore: " + i);
				System.out.println("riga: " + j);
				System.out.println("delta: " + delta);

				if (!otherrow.lblNumeroC.isPreso()
						& !otherrow.lblNumeroB.isPreso()
						& !otherrow.lblNumeroA.isPreso()) {
					totale = totale + ((j + delta) * 3);
					System.out.println("tutti apert - riga: " + j + " vale: " + ((j + delta) * 3));
				}
				if (!otherrow.lblNumeroC.isPreso()
						& !otherrow.lblNumeroB.isPreso()
						& otherrow.lblNumeroA.isPreso()) {
					totale = totale + ((j + delta) * 2);
					System.out.println("due aperti - riga: " + j + " vale: "
							+ ((j + delta) * 2));
				}
				if (!otherrow.lblNumeroC.isPreso()
						& otherrow.lblNumeroB.isPreso()
						& otherrow.lblNumeroA.isPreso()) {
					totale = totale + ((j + delta) * 1);
					System.out.println("uno aperto - riga: " + j + " vale: "
							+ ((j + delta) * 1));
				}
			}
			System.out.println("totale: " + totale );
			int risultato = totale;
			mieiPunti.setText("" + risultato);
		}
	}

	public PnlBodyLab2(int numeroGiocatori) {
		pnlPlayerArray = new PnlPlayerLab2[numeroGiocatori];
		txtNomeArray = new JTextField[numeroGiocatori];
		txtPuntiArray = new JTextField[numeroGiocatori];
		mortoArray = new boolean[21];
		PnlPlayerLab2 pnlPlayer;
		JTextField txtPlayerName;
		JTextField txtPlayerPunti;
		setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));

		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 200, 200, 200, 200, 0 };
		// gridBagLayout.columnWidths = new int[] { 0 };
		gridBagLayout.rowHeights = new int[] { 30, 45, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 1.0, 1.0, 1.0, 1.0,
				Double.MIN_VALUE };
		// gridBagLayout.columnWeights = new double[] { 1.0, 1.0, 1.0, 1.0 };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		for (int i = 0; i < numeroGiocatori; i++) {
			txtPlayerName = new JTextField(i);
			txtPlayerName.setText("Nome Giocatore: " + i);
			txtNomeArray[i] = txtPlayerName;
			GridBagConstraints gbc_txtPlayerName = new GridBagConstraints();
			gbc_txtPlayerName.insets = new Insets(0, 5, 0, 5);
			gbc_txtPlayerName.fill = GridBagConstraints.BOTH;
			gbc_txtPlayerName.gridx = i;
			gbc_txtPlayerName.gridy = 0;
			add(txtPlayerName, gbc_txtPlayerName);

			txtPlayerPunti = new JTextField(i);
			txtPlayerPunti.setText("0");
			txtPuntiArray[i] = txtPlayerPunti;
			GridBagConstraints gbc_txtNewLabel = new GridBagConstraints();
			gbc_txtNewLabel.insets = new Insets(0, 5, 0, 5);
			gbc_txtNewLabel.fill = GridBagConstraints.BOTH;
			gbc_txtNewLabel.gridx = i;
			gbc_txtNewLabel.gridy = 1;
			add(txtPlayerPunti, gbc_txtNewLabel);

			pnlPlayer = new PnlPlayerLab2(i);
			pnlPlayerArray[i] = pnlPlayer;
			GridBagConstraints gbc_pnlPlayerLab2 = new GridBagConstraints();
			gbc_pnlPlayerLab2.insets = new Insets(5, 5, 5, 5);
			gbc_pnlPlayerLab2.fill = GridBagConstraints.BOTH;
			gbc_pnlPlayerLab2.gridx = i;
			gbc_pnlPlayerLab2.gridy = 2;
			add(pnlPlayer, gbc_pnlPlayerLab2);
		}

		setBackground(new Color(0, 0, 255));
		setOpaque(true);
		revalidate();
		repaint();
	}
}
