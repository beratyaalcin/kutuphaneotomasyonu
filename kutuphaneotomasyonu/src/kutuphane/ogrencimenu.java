package kutuphane;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

//import View.Restaurant;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.Action;
import javax.swing.JTextField;

public class ogrencimenu extends girisGUI {

	private static final long serialVersionUID = 1L;
	private JPanel menu;
	private final Action cikisyapma = new cikis();
	private final Action sifredegistirme = new SwingAction();
	private final Action kitapAlma = new SwingAction_1();
	private JTextField nocekme;
	private final Action kitapTeslimEt = new SwingAction_2();
	private JTextField isimcekme;
	String imagePath = "arkaPlan.jpg";
	private final Action kutuphanemize = new SwingAction_3();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ogrencimenu frame = new ogrencimenu(kullanicino, isim);
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
	public ogrencimenu(String kullanicino, String isim) {
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(ogrencimenu.class.getResource("/kutuphane/logo.png")));
		setTitle("BAIBU KUTUPHANE");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 600);
		menu = new JPanel();
		menu.setBackground(new Color(0, 128, 128));
		menu.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(menu);
		menu.setLayout(null);
		
		JLabel anabaslik = new JLabel("Prof. Dr. Fuat Sezgin Kütüphanesi");
		anabaslik.setForeground(new Color(255, 128, 64));
		anabaslik.setFont(new Font("Impact", Font.BOLD | Font.ITALIC, 35));
		anabaslik.setBounds(210, 20, 500, 40);
		menu.add(anabaslik);
		
		JLabel logo = new JLabel(new ImageIcon(getClass().getResource("logo.png")));
		logo.setBounds(0, 0, 204, 200);
		menu.add(logo);
		
		/*String sql="SELECT * FROM ogrenci WHERE ogrno='"+kullanicino+"'";
		try {
			ResultSet myRs1=bagla.bul(sql);
			String ogrisim = myRs1.getString("ogrno");
			System.out.println(ogrisim);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		JLabel hosgeldin = new JLabel("Hoş Geldin, " + isim);
		hosgeldin.setForeground(new Color(255, 128, 64));
		hosgeldin.setFont(new Font("Impact", Font.ITALIC, 25));
		hosgeldin.setBounds(210, 70, 300, 30);
		menu.add(hosgeldin);
		
		JLabel hosgeldin2 = new JLabel("lütfen yapacağınız işlemi seçiniz:");
		hosgeldin2.setForeground(new Color(255, 128, 64));
		hosgeldin2.setFont(new Font("Impact", Font.ITALIC, 25));
		hosgeldin2.setBounds(210, 100, 400, 20);
		menu.add(hosgeldin2);
		
		JButton kitapal = new JButton("kitap al");
		kitapal.setAction(kitapAlma);
		kitapal.setBounds(230, 130, 440, 50);
		kitapal.setIcon(new ImageIcon(ogrencimenu.class.getResource("kitapal.jpg")));
		menu.add(kitapal);
		
		JButton kitapteslimet = new JButton("Kitap Teslim Et");
		kitapteslimet.setAction(kitapTeslimEt);
		kitapteslimet.setBounds(230, 200, 440, 50);
		kitapteslimet.setIcon(new ImageIcon(ogrencimenu.class.getResource("kitapteslim.jpg")));
		menu.add(kitapteslimet);
		
		JButton gecmis = new JButton("Kutuphane Hakkında");
		gecmis.setAction(kutuphanemize);
		gecmis.setBounds(230, 270, 440, 50);
		gecmis.setIcon(new ImageIcon(ogrencimenu.class.getResource("kutuphanemiz1.jpg")));
		menu.add(gecmis);
		
		JButton sifredegistir = new JButton("Şifre Değiştir");
		sifredegistir.setAction(sifredegistirme);
		sifredegistir.setBounds(230, 340, 440, 50);
		sifredegistir.setIcon(new ImageIcon(ogrencimenu.class.getResource("sifredegistirme.jpg")));
		menu.add(sifredegistir);
		
		JButton cikis = new JButton("ÇIKIŞ YAP");
		cikis.setAction(cikisyapma);
		cikis.setBounds(230, 410, 440, 50);
		cikis.setIcon(new ImageIcon(ogrencimenu.class.getResource("cikis.jpg")));
		menu.add(cikis);
		
		nocekme = new JTextField();
		nocekme.setBounds(2000, 380, 96, 20);
		menu.add(nocekme);
		nocekme.setColumns(10);
		nocekme.setText(kullanicino);
		
		isimcekme = new JTextField();
		isimcekme.setBounds(2000, 380, 96, 20);
		menu.add(isimcekme);
		isimcekme.setColumns(10);
		isimcekme.setText(isim);
		
		JLabel nokontrol = new JLabel("New label");
		nokontrol.setBounds(4000, 65, 200, 14);
		nokontrol.setText(kullanicino);
		menu.add(nokontrol);
		
		JLabel arkaPlan = new JLabel(new ImageIcon(getClass().getResource("arkaPlan.jpg")));
		arkaPlan.setBounds(0, 0, 1000, 600);
		menu.add(arkaPlan);
	}
	private class cikis extends AbstractAction {
		public cikis() {
			putValue(NAME, "CIKIS YAP");
			putValue(SHORT_DESCRIPTION, "Giriş Menüsüne Dönmek için tıkla!");
		}
		public void actionPerformed(ActionEvent e) {
			girisGUI frame1 = new girisGUI();
			frame1.getContentPane().setLayout(null);
			frame1.setVisible(true);
			dispose();
		}
	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SIFRE DEGISTIR");
			putValue(SHORT_DESCRIPTION, "SIFRENI DEGISTIRMEK ICIN TIKLA.");
		}
		public void actionPerformed(ActionEvent e) {
			sifredegistir frame1 = new sifredegistir();
			frame1.getContentPane().setLayout(null);
			frame1.setVisible(true);
			dispose();
		}
	}
	public class SwingAction_1 extends AbstractAction {
		public SwingAction_1() {
			putValue(NAME, "KITAP AL");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			String isim = isimcekme.getText();
			String kullanicino = nocekme.getText();
			//kitapal frame2 = new kitapal();
			kitapal frame2 = new kitapal(kullanicino, isim);
			frame2.setVisible(true);
			dispose();
			
		}
	}
	private class SwingAction_2 extends AbstractAction {
		public SwingAction_2() {
			putValue(NAME, "KITAP TESLIM ET");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			String isim = isimcekme.getText();
			String kullanicino = nocekme.getText();
			kitabiteslimet frame1 = new kitabiteslimet(kullanicino, isim);
			frame1.setVisible(true); 
			dispose();
		}
	}
	private class SwingAction_3 extends AbstractAction {
		public SwingAction_3() {
			putValue(NAME, "SwingAction_3");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			String isim = isimcekme.getText();
			String kullanicino = nocekme.getText();
			kutuphanemiz frame1 = new kutuphanemiz(kullanicino, isim);
			frame1.setVisible(true); 
			dispose();
		}
	}
}
