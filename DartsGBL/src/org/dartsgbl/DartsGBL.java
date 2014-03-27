package org.dartsgbl;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class DartsGBL extends JFrame {

	private static final long serialVersionUID = 5375213009082631974L;
	private static JPanel contentPane;
	private static PnlBody pnlBody;
	private static PnlIntestazione pnlIntestazione; 

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DartsGBL frame = new DartsGBL();
					frame.setLocationRelativeTo(null);
					frame.pack();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public static void buildIt(int numeroGiocatori) {
//		int str=PnlIntestazione.getNumeroGiocatoriOld();
//		System.out.println(str);
//		System.out.println("DartsGBL BuildIt numGiocatoriOld - I giocatori della partita prima erano:  " + PnlIntestazione.numGiocatoriOld);
		pnlBody = new PnlBody(numeroGiocatori);
		GridBagConstraints gbc_pnlBody = new GridBagConstraints();
		gbc_pnlBody.insets = new Insets(0, 0, 0, 0);
		gbc_pnlBody.fill = GridBagConstraints.BOTH;
		gbc_pnlBody.gridx = 0;
		gbc_pnlBody.gridy = 1;
		contentPane.add(pnlBody, gbc_pnlBody);
		contentPane.revalidate();
		contentPane.repaint();
	}

	public static void reBuildIt(int numeroGiocatoriOld) {
//		PnlBody.getNomeGiocatore(numeroGiocatoriOld);
		contentPane.remove(pnlBody);
		contentPane.repaint();
	}

	/**
	 * Create the frame.
	 */
	public DartsGBL() {
		setTitle("GuiLab2");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setMinimumSize(new Dimension(800, 600));
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{800, 0};
		gbl_contentPane.rowHeights = new int[]{50, 0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);

		pnlIntestazione = new PnlIntestazione();
		GridBagConstraints gbc_pnlIntestazioneLab2 = new GridBagConstraints();
		gbc_pnlIntestazioneLab2.insets = new Insets(0, 0, 0, 0);
		gbc_pnlIntestazioneLab2.fill = GridBagConstraints.BOTH;
		gbc_pnlIntestazioneLab2.gridx = 0;
		gbc_pnlIntestazioneLab2.gridy = 0;
		gbc_pnlIntestazioneLab2.weightx = 0;
		gbc_pnlIntestazioneLab2.weighty = 0;
		contentPane.add(pnlIntestazione, gbc_pnlIntestazioneLab2);

//		int numeroGiocatori = PnlIntestazione.getSelectedVal();
		int numeroGiocatori = PnlIntestazione.getNumeroGiogatori();
		buildIt(numeroGiocatori);
	}
}