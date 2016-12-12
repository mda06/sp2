package com.school.project.gui.view.settings;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SpringLayout;

import com.school.project.gui.view.BaseView;
import com.school.project.util.FontUtil;

public class LayoutSettingsView extends BaseView{
	private static final long serialVersionUID = 1L;
	private JLabel lblFontReallySmall, lblFontSmall, lblFontBig;
	private JButton btnFontReallySmall, btnFontSmall, btnFontBig;
	
	public LayoutSettingsView() {
		super("layoutSettings");
		initLayout();
	}
	
	private void initLayout() {
		lblFontReallySmall  = new JLabel ("Really Small Font");
		lblFontSmall = new JLabel("Small Font");
		lblFontBig = new JLabel("Big Font");
		btnFontReallySmall  = new JButton ("Really Small Font");
		btnFontSmall = new JButton("Change small font");
		btnFontBig = new JButton("Change big font");
		
		FontUtil.getInstance().bindReallySmallFont(btnFontReallySmall);
		FontUtil.getInstance().bindReallySmallFont(lblFontReallySmall);
		FontUtil.getInstance().bindSmallFont(btnFontSmall);
		FontUtil.getInstance().bindBigFont(btnFontBig);
		FontUtil.getInstance().bindBigFont(lblFontBig);
		FontUtil.getInstance().bindSmallFont(lblFontSmall);
		
		SpringLayout sp = new SpringLayout();
		setLayout(sp);
		add(lblFontSmall);
		add(lblFontBig);
		add(btnFontSmall);
		add(btnFontBig);
		add(btnFontReallySmall);
		add(lblFontReallySmall);
		
		sp.putConstraint(SpringLayout.WEST, lblFontReallySmall, 15, SpringLayout.WEST, this);
		sp.putConstraint(SpringLayout.NORTH, lblFontReallySmall, 15, SpringLayout.NORTH, this);
		sp.putConstraint(SpringLayout.SOUTH, lblFontReallySmall, 50, SpringLayout.NORTH, lblFontReallySmall);
		sp.putConstraint(SpringLayout.WEST, lblFontSmall, 0, SpringLayout.WEST, lblFontReallySmall);
		sp.putConstraint(SpringLayout.NORTH, lblFontSmall, 10, SpringLayout.SOUTH, lblFontReallySmall);
		sp.putConstraint(SpringLayout.EAST, lblFontSmall, 250, SpringLayout.WEST, lblFontSmall);
		sp.putConstraint(SpringLayout.SOUTH, lblFontSmall, 50, SpringLayout.NORTH, lblFontSmall);
		sp.putConstraint(SpringLayout.EAST, lblFontBig, 0, SpringLayout.EAST, lblFontSmall);
		sp.putConstraint(SpringLayout.WEST, lblFontBig, 0, SpringLayout.WEST, lblFontSmall);
		sp.putConstraint(SpringLayout.NORTH, lblFontBig, 10, SpringLayout.SOUTH, lblFontSmall);
		sp.putConstraint(SpringLayout.SOUTH, lblFontBig, 50, SpringLayout.NORTH, lblFontBig);
		sp.putConstraint(SpringLayout.NORTH, btnFontSmall, 0, SpringLayout.NORTH, lblFontSmall);
		sp.putConstraint(SpringLayout.WEST, btnFontSmall, 10, SpringLayout.EAST, lblFontSmall);
		sp.putConstraint(SpringLayout.EAST, btnFontSmall, 350, SpringLayout.WEST, btnFontSmall);
		sp.putConstraint(SpringLayout.SOUTH, btnFontSmall, 50, SpringLayout.NORTH, btnFontSmall);
		sp.putConstraint(SpringLayout.EAST, btnFontBig, 0, SpringLayout.EAST, btnFontSmall);
		sp.putConstraint(SpringLayout.WEST, btnFontBig, 0, SpringLayout.WEST, btnFontSmall);
		sp.putConstraint(SpringLayout.NORTH, btnFontBig, 0, SpringLayout.NORTH, lblFontBig);
		sp.putConstraint(SpringLayout.SOUTH, btnFontBig, 50, SpringLayout.NORTH, btnFontBig);
		sp.putConstraint(SpringLayout.WEST, btnFontReallySmall, 0, SpringLayout.WEST, btnFontSmall);
		sp.putConstraint(SpringLayout.EAST, btnFontReallySmall, 0, SpringLayout.EAST, btnFontSmall);
		sp.putConstraint(SpringLayout.SOUTH, btnFontReallySmall, 50, SpringLayout.NORTH, btnFontReallySmall);
		sp.putConstraint(SpringLayout.NORTH, btnFontReallySmall, 0, SpringLayout.NORTH, lblFontReallySmall);
	}

	public JLabel getLblFontSmall() {
		return lblFontSmall;
	}

	public JLabel getLblFontBig() {
		return lblFontBig;
	}

	public JButton getBtnFontSmall() {
		return btnFontSmall;
	}

	public JButton getBtnFontBig() {
		return btnFontBig;
	}

	public JLabel getLblFontReallySmall() {
		return lblFontReallySmall;
	}

	public JButton getBtnFontReallySmall() {
		return btnFontReallySmall;
	}

}
