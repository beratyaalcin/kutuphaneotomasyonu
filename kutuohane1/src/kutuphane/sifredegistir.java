package kutuphane;

import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.Action;
import java.awt.Color;
import javax.swing.JLabel;

public class sifredegistir extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField kullaniciNo;
	private JTextField eskiSifre;
	private JTextField yeniSifre;
	private final Action action = new SwingAction();
	private final Action action_1 = new SwingAction_1();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					sifredegistir frame = new sifredegistir();
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
	public sifredegistir() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(girisGUI.class.getResource("/kutuphane/logo.png")));
		setTitle("BAIBU KUTUPHANE");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		kullaniciNo = new JTextField();
		kullaniciNo.setBounds(171, 64, 96, 20);
		contentPane.add(kullaniciNo);
		kullaniciNo.setColumns(10);
		
		eskiSifre = new JTextField();
		eskiSifre.setBounds(171, 95, 96, 20);
		contentPane.add(eskiSifre);
		eskiSifre.setColumns(10);
		
		yeniSifre = new JTextField();
		yeniSifre.setBounds(171, 128, 96, 20);
		contentPane.add(yeniSifre);
		yeniSifre.setColumns(10);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setAction(action);
		btnNewButton.setBounds(139, 164, 159, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("KULLANICI ADI:");
		lblNewLabel.setBounds(41, 67, 96, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("ESKİ ŞİFRE:");
		lblNewLabel_1.setBounds(41, 98, 96, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("YENİ ŞİFRE:");
		lblNewLabel_2.setBounds(41, 131, 96, 14);
		contentPane.add(lblNewLabel_2);
		
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.setAction(action_1);
		btnNewButton_1.setBounds(157, 211, 123, 23);
		contentPane.add(btnNewButton_1);
	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "ŞIFREYI DEGISTIR");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			String kullanicino = kullaniciNo.getText();
			String eskisifre = eskiSifre.getText();
			String yenisifre = yeniSifre.getText();
			String sql="SELECT * FROM ogrenci WHERE ogrno='"+kullanicino+"'";
			
			try {
				ResultSet myRs1=bagla.bul(sql);
				while(myRs1.next()) {
					if (kullanicino.equals(myRs1.getString("ogrno"))&& eskisifre.equals(myRs1.getString("ogrsifre"))) {
						System.out.println("Giriş başarılı");
						String sorgu = "UPDATE ogrenci SET ogrsifre = '"+yenisifre+"' WHERE ogrno = '"+kullanicino+"'";
						bagla.update(sorgu);
						myRs1.close();
					}else {
						System.out.println("Hatalı.");
					}
				myRs1.close();
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}
	private class SwingAction_1 extends AbstractAction {
		public SwingAction_1() {
			putValue(NAME, "Girişe Dön");
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
