package mainPackage;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class MainMenu extends JFrame {
	
	public MainMenu() {
		super("Rain info app");
		WindowOptions();
		Container window = this.getContentPane();
		window.setLayout(null);
		window.add(MakeMainLabel());
		window.add(MakeButton("Start work", -30, (new StartEvent())));
		window.add(MakeButton("Options", 50, null));
		window.add(MakeButton("Exit", 130, (new ExitEvent())));
	}
	
	private JLabel MakeMainLabel() {
		JLabel appName = new JLabel("Gistagram maker");
		appName.setSize(new Dimension(380, 65));
		appName.setLocation(new Point((this.getWidth() - appName.getWidth()) / 2, (this.getHeight() - appName.getHeight()) / 2 - 150));
		appName.setFont(new Font(Font.SERIF, Font.BOLD, 50));
		appName.setBackground(Color.yellow);
		return appName;
	}
	
	private JButton MakeButton(String name, int position, ActionListener clickAction) {
		JButton Button = new JButton(name);
		Button.setSize(new Dimension(260, 65));
		Button.setBackground(new Color(100,100,100));
		Button.setForeground(Color.WHITE);
		Button.setBorderPainted(false);
		Button.setLocation(new Point((this.getWidth() - Button.getWidth()) / 2, (this.getHeight() - Button.getHeight()) / 2 + position));
		Button.setFocusPainted(false);
		Button.setFont(MakeButtonFont());
		if(clickAction != null) Button.addActionListener(clickAction);
		return Button;
	}
	
	private Font MakeButtonFont() {
		Font font = new Font(Font.SERIF, Font.BOLD, 30);
		return font;
	}
	
	private void WindowOptions() {
		this.setSize(800, 500);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setContentPane(new BackgroundPanel());
	}
	
	class BackgroundPanel extends JPanel{
	    public void paintComponent(Graphics g){
	        g.setColor(Color.WHITE);
	        g.fillRect(0, 0, 800, 500);
	        g.setColor(Color.YELLOW);
	        g.fillRect(740, 0, 2, 500);
	        g.setColor(Color.ORANGE);
	        g.fillRect(0, 20, 800, 2);
	        g.setColor(Color.YELLOW);
	        g.fillRect(730, 0, 2, 500);
	        g.setColor(Color.ORANGE);
	        g.fillRect(0, 30, 800, 2);
	    	
	    	/*Image im = null;
	        try {
	            im = ImageIO.read(new File("E:\\CoordinateSystem.jpg"));
	        } catch (IOException e) {}
	        g.drawImage(im, 0, 0, null); */
	    }
	}
	
	class ExitEvent implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
	}
	
	class StartEvent implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			Workspace wk = new Workspace();
			wk.setVisible(true);
			setExtendedState(MAXIMIZED_BOTH);
			dispose();
		}
	}
}
