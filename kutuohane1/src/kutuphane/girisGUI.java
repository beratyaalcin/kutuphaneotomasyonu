package kutuphane;

import java.awt.EventQueue;
import javax.swing.ImageIcon;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import java.awt.Toolkit;
import javax.swing.SwingConstants;

public class girisGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel girisEkran;
	private JTextField kullaniciAdiAl;
	private JPasswordField sifreAl;
	private final Action action = new girisYap();
	private final Action action_1 = new cikis();
	private JTextField ykullaniciAdiAl;
	private JPasswordField ysifreAl;
	private final Action action_2 = new SwingAction();
	private JLabel feedback3;
	private JLabel feedback2;
	private JLabel lblNewLabel;

	/**
	 * Create the frame.
	 */
	public girisGUI() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(girisGUI.class.getResource("/kutuphane/logo.png")));
		setTitle("BAIBU KUTUPHANE");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 450);
		
		girisEkran = new JPanel();
		girisEkran.setBackground(new Color(0, 128, 128));
		girisEkran.setBorder(new EmptyBorder(5, 5, 5, 5));
		

		setContentPane(girisEkran);
		girisEkran.setLayout(null);

		JLabel ikon = new JLabel(new ImageIcon(getClass().getResource("header.png")));
		ikon.setBackground(new Color(255, 128, 64));
		ikon.setBounds(19, 22, 450, 100);
		girisEkran.add(ikon);
	
		lblNewLabel = new JLabel("Kütüphane Sistemine Hoş Geldiniz!");
		lblNewLabel.setForeground(new Color(255, 255, 128));
		lblNewLabel.setFont(new Font("Yu Gothic UI", Font.BOLD, 16));
		lblNewLabel.setBounds(105, 133, 278, 33);
		girisEkran.add(lblNewLabel);
		
		JTabbedPane panel1 = new JTabbedPane(JTabbedPane.TOP);
		panel1.setBounds(19, 175, 450, 179);
		girisEkran.add(panel1);
	
		JPanel ogrenciGirisi = new JPanel();
		ogrenciGirisi.setBackground(new Color(0, 128, 128));
		panel1.addTab("Öğrenci Girişi", null, ogrenciGirisi, null);
		ogrenciGirisi.setLayout(null);
	
		JLabel lblNewLabel_1 = new JLabel("KULLANICI ADI:");
		lblNewLabel_1.setFont(new Font("Yu Gothic UI", Font.BOLD, 18));
		lblNewLabel_1.setBounds(10, 20, 150, 20);
		ogrenciGirisi.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("ŞİFRE:");
		lblNewLabel_1_1.setFont(new Font("Yu Gothic UI", Font.BOLD, 18));
		lblNewLabel_1_1.setBounds(10, 50, 150, 22);
		ogrenciGirisi.add(lblNewLabel_1_1);
		
		kullaniciAdiAl = new JTextField(9);
		kullaniciAdiAl.setFont(new Font("Yu Gothic UI Light", Font.BOLD | Font.ITALIC, 18));
		kullaniciAdiAl.setBounds(170, 20, 100, 25);
		ogrenciGirisi.add(kullaniciAdiAl);
		kullaniciAdiAl.setColumns(10);
		
		sifreAl = new JPasswordField();
		sifreAl.setFont(new Font("Yu Gothic UI Light", Font.BOLD | Font.ITALIC, 18));
		sifreAl.setBounds(170, 50, 100, 25);
		ogrenciGirisi.add(sifreAl);
		
		JButton ogirisYap = new JButton("Giris Yap");
		ogirisYap.setBackground(new Color(0, 255, 0));
		ogirisYap.setForeground(new Color(0, 0, 0));
		ogirisYap.setAction(action);
		ogirisYap.setBounds(23, 85, 174, 30);
		ogrenciGirisi.add(ogirisYap);
	
		JButton cikis = new JButton("CIKIS");
		cikis.setAction(action_1);
		cikis.setBackground(new Color(255, 0, 0));
		cikis.setForeground(new Color(0, 0, 0));
		cikis.setBounds(240, 85, 174, 30);
		ogrenciGirisi.add(cikis);
		
		JPanel yetkiliGirisi = new JPanel();
		yetkiliGirisi.setLayout(null);
		yetkiliGirisi.setBackground(new Color(255, 128, 64));
		panel1.addTab("Yetkili Girişi", null, yetkiliGirisi, null);
		
		JLabel lblNewLabel_1_2 = new JLabel("KULLANICI ADI:");
		lblNewLabel_1_2.setFont(new Font("Yu Gothic UI", Font.BOLD, 18));
		lblNewLabel_1_2.setBounds(10, 20, 150, 20);
		yetkiliGirisi.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("ŞİFRE:");
		lblNewLabel_1_1_1.setFont(new Font("Yu Gothic UI", Font.BOLD, 18));
		lblNewLabel_1_1_1.setBounds(10, 50, 150, 22);
		yetkiliGirisi.add(lblNewLabel_1_1_1);
		
		ykullaniciAdiAl = new JTextField(10);
		ykullaniciAdiAl.setFont(new Font("Yu Gothic UI Light", Font.BOLD | Font.ITALIC, 18));
		ykullaniciAdiAl.setBounds(170, 20, 100, 25);
		yetkiliGirisi.add(ykullaniciAdiAl);
		
		ysifreAl = new JPasswordField();
		ysifreAl.setFont(new Font("Yu Gothic UI Light", Font.BOLD | Font.ITALIC, 18));
		ysifreAl.setBounds(170, 50, 100, 25);
		yetkiliGirisi.add(ysifreAl);
		
		JButton ogirisYap_1 = new JButton("Giris Yap");
		ogirisYap_1.setAction(action_2);
		ogirisYap_1.setForeground(Color.BLACK);
		ogirisYap_1.setBackground(Color.GREEN);
		ogirisYap_1.setBounds(135, 89, 174, 30);
		yetkiliGirisi.add(ogirisYap_1);
		
		feedback2 = new JLabel("");
		feedback2.setHorizontalAlignment(SwingConstants.CENTER);
		feedback2.setForeground(new Color(128, 255, 0));
		feedback2.setBounds(72, 120, 300, 20);
		yetkiliGirisi.add(feedback2);
		
		feedback3 = new JLabel("s");
		feedback3.setHorizontalAlignment(SwingConstants.CENTER);
		feedback3.setForeground(new Color(128, 255, 0));
		feedback3.setBounds(72, 160, 300, 20);
		ogrenciGirisi.add(feedback3);
		
		JLabel arkaPlan = new JLabel(new ImageIcon(getClass().getResource("arkaPlan1.png")));
		arkaPlan.setBounds(0, 0, 500, 450);
		girisEkran.add(arkaPlan);
	}
	public class girisYap extends AbstractAction {
		public girisYap() {
			putValue(NAME, "GIRIS YAP");
			putValue(SHORT_DESCRIPTION, "Giris yapmak icin tikla.");
			
		}
		public void actionPerformed(ActionEvent e) {
			feedback3.setText("");
			lblNewLabel.setText("Kütüphane Sistemine Hoş Geldiniz!");
			String sifre = String.valueOf(sifreAl.getPassword());
			String kullanicino = kullaniciAdiAl.getText();
			String sql="SELECT * FROM ogrenci WHERE ogrno='"+kullanicino+"'";
			try {
				ResultSet myRs1=bagla.bul(sql);
				while(myRs1.next()) {
					if (kullanicino.equals(myRs1.getString("ogrno"))&& sifre.equals(myRs1.getString("ogrsifre"))) {
						feedback3.setText("Giris Basarili!");
						String isim = myRs1.getString("ogrisim");
						ogrencimenu frame1 = new ogrencimenu(kullanicino, isim);
						frame1.setVisible(true); 
						dispose();
					}else {
						feedback3.setText("YANLIS KULLANICI ADI YA DA SIFRE. TEKRAR DENEYIN.");
						lblNewLabel.setText("YANLIS KULLANICI ADI YA DA SIFRE. TEKRAR DENEYIN.");
						System.out.println("TEKRAR DENE.");
					}
				}
				
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
	}
	
	private class cikis extends AbstractAction {
		public cikis() {
			putValue(NAME, "CIKIS");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			dispose();
		}
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					girisGUI frame = new girisGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {

			putValue(NAME, "GİRİŞ YAP");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			
			feedback2.setText("");
			
			String ykullaniciAdi = "admin";
			String ysifre = "admin";
			
			String ykullaniciadial = ykullaniciAdiAl.getText();
			String ysifreal = String.valueOf(ysifreAl.getPassword());
			if (ykullaniciadial.equals(ykullaniciAdi) && ysifreal.equals(ysifre)){
				System.out.println("Yetkili Giriş başarılı");
				yetkilimenu frame1 = new yetkilimenu();
				frame1.setVisible(true); 
				dispose();
			}else {
				feedback2.setText("HATALI GIRIS.");
			}
			
		}
	}
}
