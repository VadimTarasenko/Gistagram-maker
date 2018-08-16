package mainPackage;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.Border;

import mainPackage.MainMenu.BackgroundPanel;

public class Workspace extends JFrame {
	
	JTable table;
	int height1=0, height2=0, height3=0, height4=0, height5=0, height6=0, height7=0, height8=0, height9=0, height10=0, height11=0, height12=0;
	JPanel rightPanel;
	
	Workspace() {
		super("Workspace");
		WindowOptions();
		// Make table
		DrawTable();
		this.add(table);
		// Make button
		JButton createBt = new JButton("Create");
		createBt.setLocation(30, 600);
		createBt.setSize(130, 50);
		createBt.setFont(new Font(Font.SANS_SERIF, Font.ROMAN_BASELINE, 16));
		createBt.setForeground(Color.WHITE);
		createBt.setBackground(new Color(145,221,255));
		createBt.setFocusPainted(false);
		createBt.setBorderPainted(true);
		createBt.addActionListener(new CreateEvent());
		this.add(createBt);
		JButton clearBt = new JButton("Back to menu");
		clearBt.setLocation(170, 600);
		clearBt.setSize(130, 50);
		clearBt.setFont(new Font(Font.SANS_SERIF, Font.ROMAN_BASELINE, 16));
		clearBt.setForeground(Color.WHITE);
		clearBt.setBackground(new Color(145,221,255));
		clearBt.setFocusPainted(false);
		clearBt.setBorderPainted(true);
		clearBt.addActionListener(new OpenMenuEvent());
		this.add(clearBt);
		
		// Make left panel
		JPanel leftPanel = new dataPanel();
		leftPanel.setSize(350,760);
		leftPanel.setLocation(0,0);
		this.add(leftPanel);
		// Make right panel
		rightPanel = new gistogramPanel();
		rightPanel.setSize(1020, 760);
		rightPanel.setLocation(330,0);
		this.add(rightPanel);
	}
	
	
	
	private JTable DrawTable() {
		String[] columnNames = {"Data"};
		
		String[][] data = {{""},{""},{""},{""},{""},{""},{""},{""},{""},{""},{""},{""}};
		
		table = new JTable(data, columnNames);
		table.setSize(140, 490);
		table.setRowHeight(41);
		table.setLocation(new Point(160,60));
		return table;
	}
	
	private void WindowOptions() {
		setExtendedState(MAXIMIZED_BOTH);
		this.setLayout(null);
		this.setLocationRelativeTo(null);
		this.setBackground(Color.BLACK);
	}
	
	private void CreateGistogram() {
		JPanel gist = new drawGistagram();
		gist.setSize(900,900);
		gist.setLocation(330, 0);
		this.add(gist);
		this.add(rightPanel);
	}
	
	class OpenMenuEvent implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			MainMenu menu = new MainMenu();
			menu.setVisible(true);
			dispose();
		}
	}
	
	class CreateEvent implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if(!isDataComplete()) {
				showMessage("False data! " + "All cells must be filled!");
			} else {
					/*1 month */height1 = Integer.parseInt(table.getModel().getValueAt(0, 0).toString());
					/*2 month */height2 = Integer.parseInt(table.getModel().getValueAt(1, 0).toString());
					/*3 month */height3 = Integer.parseInt(table.getModel().getValueAt(2, 0).toString());
					/*4 month */height4 = Integer.parseInt(table.getModel().getValueAt(3, 0).toString());
					/*5 month */height5 = Integer.parseInt(table.getModel().getValueAt(4, 0).toString());
					/*6 month */height6 = Integer.parseInt(table.getModel().getValueAt(5, 0).toString());
					/*7 month */height7 = Integer.parseInt(table.getModel().getValueAt(6, 0).toString());
					/*8 month */height8 = Integer.parseInt(table.getModel().getValueAt(7, 0).toString());
					/*9 month */height9 = Integer.parseInt(table.getModel().getValueAt(8, 0).toString());
				   /*10 month */height10 = Integer.parseInt(table.getModel().getValueAt(9, 0).toString());
			       /*11 month */height11 = Integer.parseInt(table.getModel().getValueAt(10, 0).toString());
			   	   /*12 month */height12 = Integer.parseInt(table.getModel().getValueAt(11, 0).toString());
			   	   CreateGistogram();
			   	   repaint();
			}
		}
	}
	
	private boolean isDataComplete() {
		for(int i = 0; i < 12; i++) {
			if(table.getModel().getValueAt(i, 0).toString() == "") {
				System.out.println(i + " - stop");
				return false;
			}
		}
		return true;
	}
	
	private void showMessage(String message) {
		JOptionPane.showMessageDialog(null, message, "Error!!!", JOptionPane.INFORMATION_MESSAGE);
	}
	
	class dataPanel extends JPanel{
		@Override
	    public void paintComponent(Graphics g){
	    	g.setColor(Color.WHITE);
	    	g.fillRect(15, 15, 300, 700);
	    	g.setFont(new Font("TimesPoman", Font.BOLD, 22));
	    	g.setColor(new Color(0,0,0,160));
	    	g.drawString("Enter rain data:", 80, 45);
	    	g.setColor(new Color(0,0,0,70));
	    	g.drawRect(15, 15, 300, 700);
	    	g.drawLine(20, 59, 299, 59);
	    	g.drawLine(20, 550, 299, 550);
	    	
	    	int difference = 41;
	    	g.fillRect(20, 60, 140, 40);
	    	g.fillRect(20, 60 + difference * 1, 140, 40);
	    	g.fillRect(20, 60 + difference * 2, 140, 40);
	    	g.fillRect(20, 60 + difference * 3, 140, 40);
	    	g.fillRect(20, 60 + difference * 4, 140, 40);
	    	g.fillRect(20, 60 + difference * 5, 140, 40);
	    	g.fillRect(20, 60 + difference * 6, 140, 40);
	    	g.fillRect(20, 60 + difference * 7, 140, 40);
	    	g.fillRect(20, 60 + difference * 8, 140, 40);
	    	g.fillRect(20, 60 + difference * 9, 140, 40);
	    	g.fillRect(20, 60 + difference * 10, 140, 40);
	    	g.fillRect(20, 60 + difference * 11, 140, 40);
	    	
	    	g.setColor(Color.WHITE);
	    	g.setFont(new Font("TimesRoman", Font.ITALIC, 18));
	    	g.drawString("January", 35, 85);
	    	g.drawString("February", 35, 85+difference*1);
	    	g.drawString("March", 35, 85+difference*2);
	    	g.drawString("April", 35, 85+difference*3);
	    	g.drawString("May", 35, 85+difference*4);
	    	g.drawString("June", 35, 85+difference*5);
	    	g.drawString("July", 35, 85+difference*6);
	    	g.drawString("August", 35, 85+difference*7);
	    	g.drawString("September", 35, 85+difference*8);
	    	g.drawString("October", 35, 85+difference*9);
	    	g.drawString("November", 35, 85+difference*10);
	    	g.drawString("December", 35, 85+difference*11);
	    }
	}
	
	class gistogramPanel extends JPanel {
		@Override
		public void paintComponent(Graphics g) {
			g.setColor(Color.WHITE);
			g.fillRect(0, 15, 1015, 700);
			g.setColor(new Color(0,0,0,70));
			g.drawRect(0, 15, 1015, 700);
			
			// graphic
			int difX=65, difY=-30;
			g.setColor(Color.BLACK);
			g.drawLine(270-difX, 60-difY, 270-difX, 600-difY);
			g.drawLine(250-difX, 580-difY, 900-difX, 580-difY);
			g.setColor(new Color(0,0,0,150));
			float[] dashPattern = {2.0f, 10.0f};
			Graphics2D g2D = ((Graphics2D)g);
			g2D.setStroke(new BasicStroke(1.0f, BasicStroke.CAP_SQUARE, BasicStroke.JOIN_MITER, 10.0f, dashPattern, 0));
			g.drawLine(270-difX, 280-difY, 900-difX, 280-difY);
			g.drawLine(270-difX, 220-difY, 900-difX, 220-difY);
			g.drawLine(270-difX, 160-difY, 900-difX, 160-difY);
			g.drawLine(270-difX, 460-difY, 900-difX, 460-difY);
			g.drawLine(270-difX, 400-difY, 900-difX, 400-difY);
			g.drawLine(270-difX, 520-difY, 900-difX, 520-difY);
			g2D.setStroke(new BasicStroke(1.5f, BasicStroke.CAP_SQUARE, BasicStroke.JOIN_MITER, 10.0f, dashPattern, 0));			
			g.drawLine(270-difX, 100-difY, 900-difX, 100-difY);
			g.drawLine(270-difX, 340-difY, 900-difX, 340-difY);
			g.setColor(Color.BLUE);
			g.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 16));
			g.drawString("300", 237-difX, 106-difY);
			g.drawString("150", 237-difX, 346-difY);
			
			// points
			g.setColor(Color.BLACK);
			g.fillRect(268-difX, 578-difY, 5,5);
			g.fillRect(268-difX, 98-difY, 5,5);
			g.fillRect(268-difX, 338-difY, 5,5);
			
			// triangles
			g.fillPolygon(new int [] {270-difX, 267-difX, 274-difX}, new int [] {57-difY, 70-difY, 70-difY}, 3);
			g.fillPolygon(new int [] {900-difX, 890-difX, 890-difX}, new int [] {580-difY, 576-difY, 585-difY}, 3);
			
			// months
			difX=50;
			g.setColor(Color.BLUE);
			g.drawString("Jan", 225, 628); g.drawString("Feb", 225+difX*1, 628); g.drawString("Mar", 225+difX*2, 628); g.drawString("Apr", 225+difX*3, 628);
			g.drawString("May", 225+difX*4, 628); g.drawString("Jun", 225+difX*5, 628); g.drawString("Jul", 225+difX*6, 628); g.drawString("Aug", 225+difX*7, 628);
			g.drawString("Sep", 225+difX*8, 628); g.drawString("Oct", 225+difX*9, 628); g.drawString("Nov", 225+difX*10, 628); g.drawString("Dec", 225+difX*11, 628);
			
		}
	}
	
	class drawGistagram extends JPanel {
		@Override
		public void paintComponent(Graphics g) {
			int difX=-170, difY=0;
			float K = 1.6f;
            // 1 month
			g.setColor(Color.BLUE);
			g.drawString(Integer.toString(height1), 58-difX, 606-(int)(height1*K));
			g.setColor(new Color(255,150,0));
    		g.fillRect(45-difX, 610-(int)(height1*K), 45, (int)(height1*K)); // fillRect(X, Y, weight, heigth);
    		// 2 month
    		g.setColor(Color.BLUE);
    		g.drawString(Integer.toString(height2), 58-difX+50*1, 606-(int)(height2*K));
    		g.setColor(new Color(255,150,0));
    		g.fillRect(95-difX, 610-(int)(height2*K), 45, (int)(height2*K)); // differense X = 54 .. low position Y = 423
    		// 3 month
    		g.setColor(Color.BLUE);
    		g.drawString(Integer.toString(height3), 58-difX+50*2, 606-(int)(height3*K));
    		g.setColor(new Color(255,150,0));
    		g.fillRect(145-difX, 610-(int)(height3*K), 45, (int)(height3*K));
    		// 4 month
    		g.setColor(Color.BLUE);
    		g.drawString(Integer.toString(height4), 58-difX+50*3, 606-(int)(height4*K));
    		g.setColor(new Color(255,150,0));
    		g.fillRect(195-difX, 610-(int)(height4*K), 45, (int)(height4*K));
    		// 5 month
    		g.setColor(Color.BLUE);
    		g.drawString(Integer.toString(height5), 58-difX+50*4, 606-(int)(height5*K));
    		g.setColor(new Color(255,150,0));
    		g.fillRect(245-difX, 610-(int)(height5*K), 45, (int)(height5*K));
    		// 6 month
    		g.setColor(Color.BLUE);
    		g.drawString(Integer.toString(height6), 58-difX+50*5, 606-(int)(height6*K));
    		g.setColor(new Color(255,150,0));
    		g.fillRect(295-difX, 610-(int)(height6*K), 45, (int)(height6*K));
    		// 7 month
    		g.setColor(Color.BLUE);
    		g.drawString(Integer.toString(height7), 58-difX+50*6, 606-(int)(height7*K));
    		g.setColor(new Color(255,150,0));
    		g.fillRect(345-difX, 610-(int)(height7*K), 45, (int)(height7*K));
    		// 8 month
    		g.setColor(Color.BLUE);
    		g.drawString(Integer.toString(height8), 58-difX+50*7, 606-(int)(height8*K));
    		g.setColor(new Color(255,150,0));
    		g.fillRect(395-difX, 610-(int)(height8*K), 45, (int)(height8*K));
    		// 9 month
    		g.setColor(Color.BLUE);
    		g.drawString(Integer.toString(height9), 58-difX+50*8, 606-(int)(height9*K));
    		g.setColor(new Color(255,150,0));
    		g.fillRect(445-difX, 610-(int)(height9*K), 45, (int)(height9*K));
    		// 10 month
    		g.setColor(Color.BLUE);
    		g.drawString(Integer.toString(height10), 58-difX+50*9, 606-(int)(height10*K));
    		g.setColor(new Color(255,150,0));
    		g.fillRect(495-difX, 610-(int)(height10*K), 45, (int)(height10*K));
    		// 11 month
    		g.setColor(Color.BLUE);
    		g.drawString(Integer.toString(height11), 58-difX+50*10, 606-(int)(height11*K));
    		g.setColor(new Color(255,150,0));
    		g.fillRect(545-difX, 610-(int)(height11*K), 45, (int)(height11*K));
    		// 12 month
    		g.setColor(Color.BLUE);
    		g.drawString(Integer.toString(height12), 58-difX+50*11, 606-(int)(height12*K));
    		g.setColor(new Color(255,150,0));
    		g.fillRect(595-difX, 610-(int)(height12*K), 45, (int)(height12*K));
		}
	}
}
