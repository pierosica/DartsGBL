package org.darts;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class GuiLab2 extends JFrame {

	private static final long serialVersionUID = 5375213009082631974L;
	private static JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiLab2 frame = new GuiLab2();
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
		//System.out.println(numeroGiocatori);
		
		PnlBodyLab2 pnlBodyLab2 = new PnlBodyLab2(numeroGiocatori);
		contentPane.remove(pnlBodyLab2);
//		contentPane.revalidate();
//		contentPane.repaint();
		GridBagConstraints gbc_pnlBodyLab2 = new GridBagConstraints();
		gbc_pnlBodyLab2.insets = new Insets(0, 5, 5, 5);
		gbc_pnlBodyLab2.fill = GridBagConstraints.BOTH;
		gbc_pnlBodyLab2.gridx = 0;
		gbc_pnlBodyLab2.gridy = 1;
		contentPane.add(pnlBodyLab2, gbc_pnlBodyLab2);
	}

	/**
	 * Create the frame.
	 */
	public GuiLab2() {
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
		PnlIntestazioneLab2 pnlIntestazioneLab2 = new PnlIntestazioneLab2();
		GridBagConstraints gbc_pnlIntestazioneLab2 = new GridBagConstraints();
		// gbc_pnlIntestazioneLab2.gridwidth = 2;
		gbc_pnlIntestazioneLab2.insets = new Insets(5, 5, 5, 5);
		gbc_pnlIntestazioneLab2.fill = GridBagConstraints.BOTH;
		gbc_pnlIntestazioneLab2.gridx = 0;
		gbc_pnlIntestazioneLab2.gridy = 0;
		gbc_pnlIntestazioneLab2.weightx = 0;
		gbc_pnlIntestazioneLab2.weighty = 0;
		contentPane.add(pnlIntestazioneLab2, gbc_pnlIntestazioneLab2);

		int numeroGiocatori = PnlIntestazioneLab2.getSelectedVal();
		buildIt(numeroGiocatori);
	}
}
