package kutuphane;

import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;

public class yetkilimenu extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private final Action kitapekleme = new SwingAction();
	private final Action kayıtlarigorme = new SwingAction_1();
	private final Action cikisyapma = new SwingAction_2();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					yetkilimenu frame = new yetkilimenu();
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
	public yetkilimenu() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(girisGUI.class.getResource("/kutuphane/logo.png")));
		setTitle("BAIBU KUTUPHANE");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 128, 64));
		contentPane.setForeground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton kitapekle = new JButton("kitap al");
		kitapekle.setAction(kitapekleme);
		kitapekle.setBounds(244, 150, 500, 80);
		contentPane.add(kitapekle);
		
		JButton kayitlarigor = new JButton("kitap al");
		kayitlarigor.setAction(kayıtlarigorme);
		kayitlarigor.setBounds(244, 275, 500, 80);
		contentPane.add(kayitlarigor);
		
		JButton cikis = new JButton("kitap al");
		cikis.setAction(cikisyapma);
		cikis.setBounds(244, 400, 500, 80);
		contentPane.add(cikis);
	}

	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "KITAPLARI LISTELE / EKLE / DUZENLE / SIL");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			kitapyonet frame1 = new kitapyonet();
			frame1.getContentPane().setLayout(null);
			frame1.setVisible(true);
			dispose();
		}
	}
	private class SwingAction_1 extends AbstractAction {
		public SwingAction_1() {
			putValue(NAME, "KAYITLARI GOR");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			kayitlarigor frame1 = new kayitlarigor();
			frame1.getContentPane().setLayout(null);
			frame1.setVisible(true);
			dispose();
		}
	}
	private class SwingAction_2 extends AbstractAction {
		public SwingAction_2() {
			putValue(NAME, "ÇIKIŞ YAP");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			girisGUI frame1 = new girisGUI();
			frame1.getContentPane().setLayout(null);
			frame1.setVisible(true);
			dispose();
		}
	}
}
