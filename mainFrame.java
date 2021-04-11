import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JRadioButton;

public class mainFrame extends JFrame {

	private JPanel contentPane;
	private JLabel lblTitle;
	private JButton btnStart;
	private JButton btnNext;
	private JRadioButton rdbtnChoice1;
	private JRadioButton rdbtnChoice2;
	private JRadioButton rdbtnChoice3;
	private JRadioButton rdbtnChoice4;
	private JRadioButton rdbtnChoice5;
	private JLabel lblQuestion1;
	private JLabel lblQuestion2;
	private JLabel lblQuestion3;
	private JLabel lblQuestion4;
	private JLabel lblQuestion5;
	private JLabel lblQuestion6;
	private JLabel lblQuestion7;
	private JLabel lblQuestion8;
	private JLabel lblQuestion9;
	private JLabel lblQuestion10;
	private JLabel lblQuestion11;
	private JLabel lblQuestion12;
	private JLabel lblQuestion13;
	private JButton btnNext2;
	private JButton btnNext3;
	private JButton btnNext4;
	private JButton btnNext5;
	private JButton btnNext6;
	private JButton btnNext7;
	private JButton btnNext8;
	private JButton btnNext9;
	private JButton btnNext10;
	private JButton btnNext11;
	private JButton btnNext12;
	private JButton btnNext13;
	private JButton btnSubmit;
	private JLabel lblThankYouFor;
	private JLabel lblTells;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mainFrame frame = new mainFrame();
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
	public mainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 852, 480);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(135, 206, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblTitle = new JLabel("Election Machine");
		lblTitle.setForeground(new Color(0, 0, 0));
		lblTitle.setFont(new Font("SansSerif", Font.ITALIC, 38));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setBounds(205, 30, 426, 120);
		contentPane.add(lblTitle);
		
		btnStart = new JButton("Start");
		btnStart.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblTitle.setVisible(false);
				btnStart.setVisible(false);
				btnNext.setVisible(true);
				rdbtnChoice1.setVisible(true);
				rdbtnChoice2.setVisible(true);
				rdbtnChoice3.setVisible(true);
				rdbtnChoice4.setVisible(true);
				rdbtnChoice5.setVisible(true);
				lblQuestion1.setVisible(true);
			}
		});
		btnStart.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		btnStart.setFont(new Font("SansSerif", Font.PLAIN, 19));
		btnStart.setBounds(365, 260, 106, 60);
		contentPane.add(btnStart);
		
		btnNext = new JButton("Next");
		btnNext.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblQuestion2.setVisible(true);
				lblQuestion1.setVisible(false);
				btnNext2.setVisible(true);
				btnNext.setVisible(false);
			}
		});
		btnNext.setVisible(false);
		btnNext.setFont(new Font("SansSerif", Font.PLAIN, 19));
		btnNext.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		btnNext.setBounds(365, 331, 106, 60);
		contentPane.add(btnNext);
		
		rdbtnChoice1 = new JRadioButton("Strongly agree");
		rdbtnChoice1.setVisible(false);
		rdbtnChoice1.setHorizontalAlignment(SwingConstants.LEFT);
		rdbtnChoice1.setFont(new Font("SansSerif", Font.PLAIN, 19));
		rdbtnChoice1.setBackground(new Color(135, 206, 250));
		rdbtnChoice1.setBounds(205, 130, 426, 23);
		contentPane.add(rdbtnChoice1);
		
		rdbtnChoice2 = new JRadioButton("Agree");
		rdbtnChoice2.setVisible(false);
		rdbtnChoice2.setHorizontalAlignment(SwingConstants.LEFT);
		rdbtnChoice2.setFont(new Font("SansSerif", Font.PLAIN, 19));
		rdbtnChoice2.setBackground(new Color(135, 206, 250));
		rdbtnChoice2.setBounds(205, 160, 426, 23);
		contentPane.add(rdbtnChoice2);
		
		rdbtnChoice3 = new JRadioButton("Neither agree nor disagree");
		rdbtnChoice3.setVisible(false);
		rdbtnChoice3.setHorizontalAlignment(SwingConstants.LEFT);
		rdbtnChoice3.setFont(new Font("SansSerif", Font.PLAIN, 19));
		rdbtnChoice3.setBackground(new Color(135, 206, 250));
		rdbtnChoice3.setBounds(205, 190, 426, 23);
		contentPane.add(rdbtnChoice3);
		
		rdbtnChoice4 = new JRadioButton("Disagree");
		rdbtnChoice4.setVisible(false);
		rdbtnChoice4.setHorizontalAlignment(SwingConstants.LEFT);
		rdbtnChoice4.setFont(new Font("SansSerif", Font.PLAIN, 19));
		rdbtnChoice4.setBackground(new Color(135, 206, 250));
		rdbtnChoice4.setBounds(205, 220, 426, 23);
		contentPane.add(rdbtnChoice4);
		
		rdbtnChoice5 = new JRadioButton("Strongly disagree");
		rdbtnChoice5.setVisible(false);
		rdbtnChoice5.setHorizontalAlignment(SwingConstants.LEFT);
		rdbtnChoice5.setFont(new Font("SansSerif", Font.PLAIN, 19));
		rdbtnChoice5.setBackground(new Color(135, 206, 250));
		rdbtnChoice5.setBounds(205, 250, 426, 23);
		contentPane.add(rdbtnChoice5);
		
		lblQuestion1 = new JLabel("Question 1: The EU must ban the sale of new petrol- and diesel-only cars by 2030.");
		lblQuestion1.setVisible(false);
		lblQuestion1.setFont(new Font("SansSerif", Font.BOLD, 15));
		lblQuestion1.setHorizontalAlignment(SwingConstants.CENTER);
		lblQuestion1.setBounds(10, 44, 816, 47);
		contentPane.add(lblQuestion1);
		
		lblQuestion2 = new JLabel("Question 2: Russia is a threat to European security.");
		lblQuestion2.setVisible(false);
		lblQuestion2.setFont(new Font("SansSerif", Font.BOLD, 15));
		lblQuestion2.setHorizontalAlignment(SwingConstants.CENTER);
		lblQuestion2.setBounds(10, 44, 816, 47);
		contentPane.add(lblQuestion2);
		
		lblQuestion3 = new JLabel("Question 3: The best way to combat illegal immigration into the EU is to open up more opportunities for legal immigration.");
		lblQuestion3.setVisible(false);
		lblQuestion3.setFont(new Font("SansSerif", Font.BOLD, 13));
		lblQuestion3.setHorizontalAlignment(SwingConstants.CENTER);
		lblQuestion3.setBounds(10, 44, 816, 47);
		contentPane.add(lblQuestion3);
		
		lblQuestion4 = new JLabel("Question 4: EU membership costs Finns too much.");
		lblQuestion4.setVisible(false);
		lblQuestion4.setFont(new Font("SansSerif", Font.BOLD, 15));
		lblQuestion4.setHorizontalAlignment(SwingConstants.CENTER);
		lblQuestion4.setBounds(10, 44, 816, 47);
		contentPane.add(lblQuestion4);
		
		lblQuestion5 = new JLabel("Question 5: Sanctions against Russia need to be eased.");
		lblQuestion5.setVisible(false);
		lblQuestion5.setFont(new Font("SansSerif", Font.BOLD, 15));
		lblQuestion5.setHorizontalAlignment(SwingConstants.CENTER);
		lblQuestion5.setBounds(10, 44, 816, 47);
		contentPane.add(lblQuestion5);
		
		lblQuestion6 = new JLabel("Question 6: The EU budget must provide money for every EU citizen over the age of 18 to receive a free Interrail ticket.");
		lblQuestion6.setVisible(false);
		lblQuestion6.setFont(new Font("SansSerif", Font.BOLD, 13));
		lblQuestion6.setHorizontalAlignment(SwingConstants.CENTER);
		lblQuestion6.setBounds(10, 44, 816, 47);
		contentPane.add(lblQuestion6);
		
		lblQuestion7 = new JLabel("Question 7: Agricultural subsidies must be geared to reducing livestock farming in the EU.");
		lblQuestion7.setVisible(false);
		lblQuestion7.setFont(new Font("SansSerif", Font.BOLD, 15));
		lblQuestion7.setHorizontalAlignment(SwingConstants.CENTER);
		lblQuestion7.setBounds(10, 44, 816, 47);
		contentPane.add(lblQuestion7);
		
		lblQuestion8 = new JLabel("Question 8: The use and cultivation of medicinal cannabis must be allowed in the EU.");
		lblQuestion8.setVisible(false);
		lblQuestion8.setFont(new Font("SansSerif", Font.BOLD, 15));
		lblQuestion8.setHorizontalAlignment(SwingConstants.CENTER);
		lblQuestion8.setBounds(10, 44, 816, 47);
		contentPane.add(lblQuestion8);
		
		lblQuestion9 = new JLabel("Question 9: The use of genetically modified products in agriculture must be banned in the EU.");
		lblQuestion9.setVisible(false);
		lblQuestion9.setFont(new Font("SansSerif", Font.BOLD, 15));
		lblQuestion9.setHorizontalAlignment(SwingConstants.CENTER);
		lblQuestion9.setBounds(10, 44, 816, 47);
		contentPane.add(lblQuestion9);
		
		lblQuestion10 = new JLabel("Question 10: The separation from the EU is a good thing for the British.");
		lblQuestion10.setVisible(false);
		lblQuestion10.setFont(new Font("SansSerif", Font.BOLD, 15));
		lblQuestion10.setHorizontalAlignment(SwingConstants.CENTER);
		lblQuestion10.setBounds(10, 44, 816, 47);
		contentPane.add(lblQuestion10);
		
		lblQuestion11 = new JLabel("Question 11: Christian values ​​provide a good basis for a common European policy.");
		lblQuestion11.setVisible(false);
		lblQuestion11.setFont(new Font("SansSerif", Font.BOLD, 15));
		lblQuestion11.setHorizontalAlignment(SwingConstants.CENTER);
		lblQuestion11.setBounds(10, 44, 816, 47);
		contentPane.add(lblQuestion11);
		
		lblQuestion12 = new JLabel("Question 12: Europe now needs tough measures to defend order and ordinary people.");
		lblQuestion12.setVisible(false);
		lblQuestion12.setFont(new Font("SansSerif", Font.BOLD, 15));
		lblQuestion12.setHorizontalAlignment(SwingConstants.CENTER);
		lblQuestion12.setBounds(10, 44, 816, 47);
		contentPane.add(lblQuestion12);
		
		lblQuestion13 = new JLabel("Question 13: Above all, it is the duty of the MEP to advance the interests of his or her country in the Union.");
		lblQuestion13.setVisible(false);
		lblQuestion13.setFont(new Font("SansSerif", Font.BOLD, 15));
		lblQuestion13.setHorizontalAlignment(SwingConstants.CENTER);
		lblQuestion13.setBounds(10, 44, 816, 47);
		contentPane.add(lblQuestion13);
		
		btnNext2 = new JButton("Next");
		btnNext2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblQuestion3.setVisible(true);
				btnNext3.setVisible(true);
				lblQuestion2.setVisible(false);
				btnNext2.setVisible(false);
			}
		});
		btnNext2.setVisible(false);
		btnNext2.setFont(new Font("SansSerif", Font.PLAIN, 19));
		btnNext2.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		btnNext2.setBounds(365, 331, 106, 60);
		contentPane.add(btnNext2);
		
		btnNext3 = new JButton("Next");
		btnNext3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblQuestion4.setVisible(true);
				btnNext4.setVisible(true);
				lblQuestion3.setVisible(false);
				btnNext3.setVisible(false);
			}
		});
		btnNext3.setVisible(false);
		btnNext3.setFont(new Font("SansSerif", Font.PLAIN, 19));
		btnNext3.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		btnNext3.setBounds(365, 331, 106, 60);
		contentPane.add(btnNext3);
		
		btnNext4 = new JButton("Next");
		btnNext4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblQuestion5.setVisible(true);
				btnNext5.setVisible(true);
				lblQuestion4.setVisible(false);
				btnNext4.setVisible(false);
			}
		});
		btnNext4.setVisible(false);
		btnNext4.setFont(new Font("SansSerif", Font.PLAIN, 19));
		btnNext4.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		btnNext4.setBounds(365, 331, 106, 60);
		contentPane.add(btnNext4);
		
		btnNext5 = new JButton("Next");
		btnNext5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblQuestion6.setVisible(true);
				btnNext6.setVisible(true);
				lblQuestion5.setVisible(false);
				btnNext5.setVisible(false);
			}
		});
		btnNext5.setVisible(false);
		btnNext5.setFont(new Font("SansSerif", Font.PLAIN, 19));
		btnNext5.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		btnNext5.setBounds(365, 331, 106, 60);
		contentPane.add(btnNext5);
		
		btnNext6 = new JButton("Next");
		btnNext6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblQuestion7.setVisible(true);
				btnNext7.setVisible(true);
				lblQuestion6.setVisible(false);
				btnNext6.setVisible(false);
			}
		});
		btnNext6.setVisible(false);
		btnNext6.setFont(new Font("SansSerif", Font.PLAIN, 19));
		btnNext6.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		btnNext6.setBounds(365, 331, 106, 60);
		contentPane.add(btnNext6);
		
		btnNext7 = new JButton("Next");
		btnNext7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblQuestion8.setVisible(true);
				btnNext8.setVisible(true);
				lblQuestion7.setVisible(false);
				btnNext7.setVisible(false);
			}
		});
		btnNext7.setVisible(false);
		btnNext7.setFont(new Font("SansSerif", Font.PLAIN, 19));
		btnNext7.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		btnNext7.setBounds(365, 331, 106, 60);
		contentPane.add(btnNext7);
		
		btnNext8 = new JButton("Next");
		btnNext8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblQuestion9.setVisible(true);
				btnNext9.setVisible(true);
				lblQuestion8.setVisible(false);
				btnNext8.setVisible(false);
			}
		});
		btnNext8.setVisible(false);
		btnNext8.setFont(new Font("SansSerif", Font.PLAIN, 19));
		btnNext8.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		btnNext8.setBounds(365, 331, 106, 60);
		contentPane.add(btnNext8);
		
		btnNext9 = new JButton("Next");
		btnNext9.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblQuestion10.setVisible(true);
				btnNext10.setVisible(true);
				lblQuestion9.setVisible(false);
				btnNext9.setVisible(false);
			}
		});
		btnNext9.setVisible(false);
		btnNext9.setFont(new Font("SansSerif", Font.PLAIN, 19));
		btnNext9.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		btnNext9.setBounds(365, 331, 106, 60);
		contentPane.add(btnNext9);
		
		btnNext10 = new JButton("Next");
		btnNext10.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblQuestion11.setVisible(true);
				btnNext11.setVisible(true);
				lblQuestion10.setVisible(false);
				btnNext10.setVisible(false);
			}
		});
		btnNext10.setVisible(false);
		btnNext10.setFont(new Font("SansSerif", Font.PLAIN, 19));
		btnNext10.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		btnNext10.setBounds(365, 331, 106, 60);
		contentPane.add(btnNext10);
		
		btnNext11 = new JButton("Next");
		btnNext11.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblQuestion12.setVisible(true);
				btnNext12.setVisible(true);
				lblQuestion11.setVisible(false);
				btnNext11.setVisible(false);
			}
		});
		btnNext11.setVisible(false);
		btnNext11.setFont(new Font("SansSerif", Font.PLAIN, 19));
		btnNext11.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		btnNext11.setBounds(365, 331, 106, 60);
		contentPane.add(btnNext11);
		
		btnNext12 = new JButton("Next");
		btnNext12.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblQuestion13.setVisible(true);
				btnNext13.setVisible(true);
				lblQuestion12.setVisible(false);
				btnNext12.setVisible(false);
			}
		});
		btnNext12.setVisible(false);
		btnNext12.setFont(new Font("SansSerif", Font.PLAIN, 19));
		btnNext12.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		btnNext12.setBounds(365, 331, 106, 60);
		contentPane.add(btnNext12);
		
		btnNext13 = new JButton("Next");
		btnNext13.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblThankYouFor.setVisible(true);
				btnSubmit.setVisible(true);
				lblQuestion13.setVisible(false);
				rdbtnChoice1.setVisible(false);
				rdbtnChoice2.setVisible(false);
				rdbtnChoice3.setVisible(false);
				rdbtnChoice4.setVisible(false);
				rdbtnChoice5.setVisible(false);
				btnNext13.setVisible(false);
			}
		});
		btnNext13.setVisible(false);
		btnNext13.setFont(new Font("SansSerif", Font.PLAIN, 19));
		btnNext13.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		btnNext13.setBounds(365, 331, 106, 60);
		contentPane.add(btnNext13);
		
		btnSubmit = new JButton("Submit answers");
		btnSubmit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnSubmit.setVisible(false);
				lblThankYouFor.setVisible(false);
				lblTells.setVisible(true);
			}
		});
		btnSubmit.setVisible(false);
		btnSubmit.setFont(new Font("SansSerif", Font.PLAIN, 19));
		btnSubmit.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		btnSubmit.setBounds(336, 260, 164, 60);
		contentPane.add(btnSubmit);
		
		lblThankYouFor = new JLabel("Thank you for answering");
		lblThankYouFor.setVisible(false);
		lblThankYouFor.setHorizontalAlignment(SwingConstants.CENTER);
		lblThankYouFor.setForeground(Color.BLACK);
		lblThankYouFor.setFont(new Font("SansSerif", Font.ITALIC, 38));
		lblThankYouFor.setBounds(205, 30, 426, 120);
		contentPane.add(lblThankYouFor);
		
		lblTells = new JLabel("Election Machine tells you, who you should vote for:");
		lblTells.setVisible(false);
		lblTells.setFont(new Font("SansSerif", Font.BOLD, 19));
		lblTells.setHorizontalAlignment(SwingConstants.CENTER);
		lblTells.setBounds(10, 44, 816, 47);
		contentPane.add(lblTells);
	}
}
