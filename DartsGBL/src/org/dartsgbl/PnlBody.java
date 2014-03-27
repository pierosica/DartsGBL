package org.dartsgbl;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;

import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.RenderingHints;

public class PnlBody extends JPanel {

	private static final long serialVersionUID = 6866172652472739639L;
	private static PnlPlayer[] pnlPlayerArray;
	private static JTextField[] txtNomeArray;
	private static String[] NomePlayerArray;
	private static JTextField[] txtPuntiArray;
	private static boolean[] mortoArray;

	// public static String labelNomeGiocatore;
	// private String[] testo;

	public static boolean isNumeroMorto(int riga) {
		return mortoArray[riga];
	}

	public static void setNumeroNonMorto(int riga) {
		mortoArray[riga] = false;
		int numeroGiocatori = PnlIntestazione.getNumeroGiogatori();
		for (int i = 0; i < numeroGiocatori; i++) {
			PnlPlayer otherpanel = pnlPlayerArray[i];
			PnlRow otherrow = otherpanel.rowArray[riga];
			LblNumero lblNumeroA = otherrow.lblNumeroA;
			lblNumeroA.setMorto(false);
			LblNumero lblNumeroB = otherrow.lblNumeroB;
			lblNumeroB.setMorto(false);
			LblNumero lblNumeroC = otherrow.lblNumeroC;
			lblNumeroC.setMorto(false);
		}
	}

	public static boolean controllaSeDaSettareNumeroMorto(int riga) {
		int numeroGiocatori = PnlIntestazione.getNumeroGiogatori();
		boolean morto = true;
		for (int i = 0; i < numeroGiocatori; i++) {
			PnlPlayer otherpanel = pnlPlayerArray[i];
			PnlRow otherrow = otherpanel.rowArray[riga];
			morto = morto & otherrow.isRowChiusa(i, riga);
		}
		return morto;
	}

	public static void setNumeroMorto(int riga) {
		mortoArray[riga] = true;
		int numeroGiocatori = PnlIntestazione.getNumeroGiogatori();
		for (int i = 0; i < numeroGiocatori; i++) {
			PnlPlayer otherpanel = pnlPlayerArray[i];
			PnlRow otherrow = otherpanel.rowArray[riga];
			LblNumero lblNumeroA = otherrow.lblNumeroA;
			lblNumeroA.setMorto(true);
			LblNumero lblNumeroB = otherrow.lblNumeroB;
			lblNumeroB.setMorto(true);
			LblNumero lblNumeroC = otherrow.lblNumeroC;
			lblNumeroC.setMorto(true);
		}
	}

	public static void incrementa(int pannello, int riga) {
		int numeroGiocatori = PnlIntestazione.getNumeroGiogatori();
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
				PnlPlayer otherpanel = pnlPlayerArray[i];
				PnlRow otherrow = otherpanel.rowArray[riga];
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
		int numeroGiocatori = PnlIntestazione.getNumeroGiogatori();
		int numeroRighe = PnlPlayer.NumeroRighe;
		for (int i = 0; i < numeroGiocatori; i++) {
			PnlPlayer otherpanel = pnlPlayerArray[i];
			JTextField mieiPunti = txtPuntiArray[i];
			int totale = Integer.parseInt(mieiPunti.getText().toString());
			int delta = 1;
			for (int j = 0; j < numeroRighe; j++) {
				PnlRow otherrow = otherpanel.rowArray[j];
				if (j == 20) {
					delta = 5;
				}
				if (!otherrow.lblNumeroC.isPreso()
						& !otherrow.lblNumeroB.isPreso()
						& !otherrow.lblNumeroA.isPreso()) {
					totale = totale + ((j + delta) * 3);
				}
				if (!otherrow.lblNumeroC.isPreso()
						& !otherrow.lblNumeroB.isPreso()
						& otherrow.lblNumeroA.isPreso()) {
					totale = totale + ((j + delta) * 2);
				}
				if (!otherrow.lblNumeroC.isPreso()
						& otherrow.lblNumeroB.isPreso()
						& otherrow.lblNumeroA.isPreso()) {
					totale = totale + ((j + delta) * 1);
				}
			}
			int risultato = totale;
			mieiPunti.setText("" + risultato);
		}
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_RENDERING,
				RenderingHints.VALUE_RENDER_QUALITY);
		int w = getWidth();
		int h = getHeight();
		// Color color1 = Color.WHITE;
		Color color1 = new Color(231, 231, 231);
		Color color2 = new Color(201, 201, 201);
		// Color color2 = color1.darker();

		GradientPaint gp = new GradientPaint(0, 0, color2, 0, h, color1);
		g2d.setPaint(gp);
		g2d.fillRect(0, 0, w, h);
	}

	public static String[] getNomeGiocatore(int numeroGiocatori) {
		NomePlayerArray = new String[numeroGiocatori];
		for (int i = 0; i < numeroGiocatori; i++) {
			JTextField txtPlayerName = txtNomeArray[i];
			NomePlayerArray[i] = txtPlayerName.getText();
			System.out
					.println("PnlBody - getNomeGiocatore - NomePlayerArray del giocatore "
							+ i + " è " + NomePlayerArray[i]);
		}
		return NomePlayerArray;
	}

	public PnlBody(int numeroGiocatori) {
		pnlPlayerArray = new PnlPlayer[numeroGiocatori];
		txtNomeArray = new JTextField[numeroGiocatori];
		txtPuntiArray = new JTextField[numeroGiocatori];
		// labelNomeGiocatore = "Nome Giocatore: ";
		mortoArray = new boolean[21];

		PnlPlayer pnlPlayer;
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
			Font font1 = new Font("SansSerif", Font.PLAIN, 40);

			txtPlayerName = new JTextField(i);
			txtNomeArray[i] = txtPlayerName;
			txtPlayerName.setText("nome " + i);
			// txtPlayerName.setText(labelNomeGiocatore + (i + 1));
			// String[] testo = getNomeGiocatore(i);
			// txtPlayerName.setText(testo + i);
			// System.out.println("Nome Giocatore "+ i + " " + testo);

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
			txtPlayerPunti.setFont(font1);
			add(txtPlayerPunti, gbc_txtNewLabel);

			pnlPlayer = new PnlPlayer(i);
			pnlPlayerArray[i] = pnlPlayer;
			GridBagConstraints gbc_pnlPlayerLab2 = new GridBagConstraints();
			gbc_pnlPlayerLab2.insets = new Insets(0, 5, 10, 5);
			gbc_pnlPlayerLab2.fill = GridBagConstraints.BOTH;
			gbc_pnlPlayerLab2.gridx = i;
			gbc_pnlPlayerLab2.gridy = 2;
			add(pnlPlayer, gbc_pnlPlayerLab2);
		}
		setOpaque(true);
		revalidate();
		repaint();
	}
}