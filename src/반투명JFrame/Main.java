package 반투명JFrame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class Main extends JFrame {
	private Point initialClick;

	

	public Main() {
		JLabel titleLabel = new JLabel("반투명 JFrame");
		JPanel titlePanel = new JPanel();
		MouseAdapter mouseAdapter = new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				initialClick = e.getPoint();
				getComponentAt(initialClick); // Record initial click position
			}

			@Override
			public void mouseDragged(MouseEvent e) {
				// Get the current location of the frame
				int thisX = getLocation().x;
				int thisY = getLocation().y;

				// Calculate the new location
				int xMoved = e.getX() - initialClick.x;
				int yMoved = e.getY() - initialClick.y;

				int X = thisX + xMoved;
				int Y = thisY + yMoved;

				// Set the frame's new location
				setLocation(X, Y);
			}
		};
		titlePanel.addMouseListener(mouseAdapter);
		titlePanel.addMouseMotionListener(mouseAdapter);

		JPanel northPanel = new JPanel();
		northPanel.setLayout(new BorderLayout());
		titlePanel.setBackground(new Color(0, 255, 255, 128));
		titlePanel.add(titleLabel);
		northPanel.add(titlePanel, BorderLayout.CENTER);

		JButton closeButton = new JButton("X");
		closeButton.setBackground(new Color(255, 255, 255, 128));
		closeButton.setFocusable(false);
		closeButton.setBorder(new LineBorder(Color.RED, 0));
		closeButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(EXIT_ON_CLOSE);
			}
		});
		northPanel.add(closeButton, BorderLayout.EAST);

		JPanel centerPanel = new JPanel();
		centerPanel.setBackground(new Color(0, 0, 0, 128));
		northPanel.setBackground(new Color(0, 0, 255, 64));

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400, 400);
		setLayout(new BorderLayout());
		setLocationRelativeTo(null);
		setUndecorated(true);
		setBackground(new Color(0, 0, 0, 0));

		add(centerPanel, BorderLayout.CENTER);
		add(northPanel, BorderLayout.NORTH);

		setVisible(true);
	}

	public static void main(String[] args) {
		new Main();
	}
}
