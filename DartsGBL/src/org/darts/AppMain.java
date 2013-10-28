package org.darts;

import java.awt.EventQueue;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class AppMain extends JFrame {

	private static final long serialVersionUID = -8463634102591878668L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AppMain frame = new AppMain();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AppMain() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		/**
		 * se ho 2 monitor
		 * questo mi permette di trovare le dimensioni di quello di default
		 */		
//		GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
//		int larghezzaMonitor = gd.getDisplayMode().getWidth();
//		int altezzaMonitor = gd.getDisplayMode().getHeight();
		/**
		 * posizione centrata del Frame
		 * se ho due monitor viene visualizzato a cavallo dei 2 monitor
		 */
//		 Dimension screen = getToolkit().getScreenSize();
//		 int larghezzaMonitor = screen.width;
//		 int altezzaMonitor = screen.height;
		int larghezzaFrame = 800;
		int altezzaFrame = 600;
//		int posX=(larghezzaMonitor - larghezzaFrame )/2;
//		int posY=(altezzaMonitor - altezzaFrame)/2;
//		setBounds(posX, posY, larghezzaFrame, altezzaFrame);
		setBounds(0, 0, larghezzaFrame, altezzaFrame);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{200, 200, 0};
		gbl_contentPane.rowHeights = new int[]{67, 200, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		IntestazionePanel intestazionePanel = new IntestazionePanel();
		GridBagConstraints gbc_intestazionePanel = new GridBagConstraints();
		gbc_intestazionePanel.insets = new Insets(0, 0, 5, 5);
		gbc_intestazionePanel.fill = GridBagConstraints.BOTH;
		gbc_intestazionePanel.anchor=GridBagConstraints.CENTER;
		gbc_intestazionePanel.gridwidth=2;
		gbc_intestazionePanel.gridx = 0;
		gbc_intestazionePanel.gridy = 0;
		contentPane.add(intestazionePanel, gbc_intestazionePanel);
	}
}
