package org.dartsgbl;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.RenderingHints;

public class PnlPlayer extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2648011732529825438L;
	public static int NumeroRighe = 21;
	private PnlRow riga;
	public int IDpannello;
	public PnlRow[] rowArray = new PnlRow[NumeroRighe];

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        int w = getWidth();
        int h = getHeight();
        Color color1 = Color.WHITE;
//        Color color2 = color1.darker();
//        Color color1 = new Color(231,231,231);
        Color color2 = new Color(201,201,201);
        GradientPaint gp = new GradientPaint(0, 0, color1, 0, h, color2);
        g2d.setPaint(gp);
        g2d.fillRect(0, 0, w, h);
    }

	/**
	 * Create the panel.
	 */
	public PnlPlayer(int id) {
		this.IDpannello = id;
		setName("id");
		//setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
//		setBackground(new Color(255, 0, 0));
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
			int delta=1;
			if (i==20){
				delta=5;
			}
			riga = new PnlRow(this.IDpannello, i);
			rowArray[i] = riga;
			GridBagConstraints gbc_riga = new GridBagConstraints();
			gbc_riga.fill = GridBagConstraints.BOTH;
//			gbc_riga.insets = new Insets(0, 0, 0, 0);
			gbc_riga.insets = new Insets(delta, 2, 3, 2);
			gbc_riga.gridx = 0;
			gbc_riga.gridy = i;
			add(riga, gbc_riga);
		}
	}
}
