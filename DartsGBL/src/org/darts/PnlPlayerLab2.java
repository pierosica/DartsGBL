package org.darts;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.LayoutManager;
import java.awt.Component;
import javax.swing.border.EmptyBorder;

public class PnlPlayerLab2 extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2648011732529825438L;

	/**
	 * Create the panel.
	 */
	public PnlPlayerLab2(int id) {
		setMinimumSize(new Dimension(220, 400));
		setMaximumSize(new Dimension(220, 400));
		setPreferredSize(new Dimension(220, 400));
		setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		setBackground(new Color(244, 0, 0));
		setOpaque(true);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0};
		gridBagLayout.rowHeights = new int[]{0};
		gridBagLayout.columnWeights = new double[]{Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{Double.MIN_VALUE};
		setLayout(gridBagLayout);
	}

	/**
	 * @wbp.factory
	 * @wbp.factory.parameter.source layout gbl_contentPane
	 * @wbp.factory.parameter.source comp panelLab2
	 * @wbp.factory.parameter.source constraints gbc_panelLab2
	 */
	public static JPanel createJPanel(LayoutManager layout, Component comp, Object constraints) {
		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setLayout(layout);
		panel.add(comp, constraints);
		return panel;
	}
}
