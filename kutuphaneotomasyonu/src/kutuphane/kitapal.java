package kutuphane;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.Action;
import javax.swing.ImageIcon;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Color;

public class kitapal extends girisGUI{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	
	DefaultTableModel modelim = new DefaultTableModel();
	
	Object[] kolonlar = {"KITAP ID", "KITAP ISMI", "KITAP YAZARI", "SAYFA SAYISI", "MEVCUTLUK"};
	Object[] satirlar = new Object[5];
	private JButton Listele;
	private final Action Listeleme = new SwingAction();
	private JTextField kitapid;
	private JButton oduncAl;
	private final Action oduncAlma = new SwingAction_1();
	private JLabel txt1;
	private JTextField nocekme;
	private JTextField kitapisimmm;
	private final Action geriDonme = new SwingAction_2();
	private JTextField isimcekme;
	private JLabel txt3;
	private JLabel text4;
	private JLabel txt3_1;
	private JLabel txt3_2;
	private JLabel feedback1;
	private JLabel feedback2;
	private JLabel arkaPlan;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					kitapal frame = new kitapal(kullanicino, isim);
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
	public kitapal(String kullanicino, String isim) {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();

		scrollPane.setBounds(50, 30, 600, 500);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		modelim.setColumnIdentifiers(kolonlar);
		table.setBounds(50, 50, 300, 300);
		scrollPane.setViewportView(table);
		
		Listele = new JButton("KITAPLARI LISTELE");
		Listele.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Listele.setAction(Listeleme);
		Listele.setBounds(740, 100, 160, 40);
		Listele.setIcon(new ImageIcon(ogrencimenu.class.getResource("listele1.jpg")));
		contentPane.add(Listele);
		//lblNewLabel.setText(kullanicino);
		
		kitapid = new JTextField();
		kitapid.setFont(new Font("Segoe UI Semibold", Font.BOLD | Font.ITALIC, 23));
		kitapid.setBounds(760, 160, 100, 40);
		contentPane.add(kitapid);
		kitapid.setColumns(10);
		
		oduncAl = new JButton("ODUNC AL");
		oduncAl.setAction(oduncAlma);
		oduncAl.setFont(new Font("Tahoma", Font.PLAIN, 20));
		oduncAl.setBounds(740, 210, 160, 40);
		oduncAl.setIcon(new ImageIcon(ogrencimenu.class.getResource("oduncal.jpg")));
		contentPane.add(oduncAl);
		
		txt1 = new JLabel("Ödünç Almak İstediğin");
		txt1.setForeground(new Color(128, 0, 0));
		txt1.setBackground(new Color(255, 128, 64));
		txt1.setHorizontalAlignment(SwingConstants.CENTER);
		txt1.setFont(new Font("Sitka Text", Font.BOLD | Font.ITALIC, 18));
		txt1.setBounds(650, 365, 350, 30);
		contentPane.add(txt1);
		
		nocekme = new JTextField();
		nocekme.setBounds(500, 114, 96, 20);
		contentPane.add(nocekme);
		nocekme.setColumns(10);
		
		kitapisimmm = new JTextField();
		kitapisimmm.setBounds(20000, 148, 96, 20);
		contentPane.add(kitapisimmm);
		kitapisimmm.setColumns(10);
		
		JButton geriDon = new JButton("GERI DON");
		geriDon.setAction(geriDonme);
		geriDon.setFont(new Font("Tahoma", Font.PLAIN, 20));
		geriDon.setBounds(740, 490, 160, 40);
		geriDon.setIcon(new ImageIcon(ogrencimenu.class.getResource("geridon.jpg")));
		contentPane.add(geriDon);
		
		isimcekme = new JTextField();
		isimcekme.setColumns(10);
		isimcekme.setBounds(500, 114, 96, 20);
		isimcekme.setText(isim);
		contentPane.add(isimcekme);
		
		txt3 = new JLabel("Kitabı Yandaki");
		txt3.setForeground(new Color(128, 0, 0));
		txt3.setHorizontalAlignment(SwingConstants.CENTER);
		txt3.setFont(new Font("Sitka Text", Font.BOLD | Font.ITALIC, 18));
		txt3.setBounds(650, 380, 350, 30);
		contentPane.add(txt3);
		
		text4 = new JLabel("Listeden Seç");
		text4.setForeground(new Color(128, 0, 0));
		text4.setHorizontalAlignment(SwingConstants.CENTER);
		text4.setFont(new Font("Sitka Text", Font.BOLD | Font.ITALIC, 18));
		text4.setBounds(650, 400, 350, 25);
		contentPane.add(text4);
		
		txt3_1 = new JLabel("ya da");
		txt3_1.setForeground(new Color(128, 0, 0));
		txt3_1.setHorizontalAlignment(SwingConstants.CENTER);
		txt3_1.setFont(new Font("Sitka Text", Font.BOLD | Font.ITALIC, 18));
		txt3_1.setBounds(650, 415, 350, 30);
		contentPane.add(txt3_1);
		
		txt3_2 = new JLabel("ID'sini gir!");
		txt3_2.setForeground(new Color(128, 0, 0));
		txt3_2.setHorizontalAlignment(SwingConstants.CENTER);
		txt3_2.setFont(new Font("Sitka Text", Font.BOLD | Font.ITALIC, 18));
		txt3_2.setBounds(650, 435, 350, 30);
		contentPane.add(txt3_2);
		
		feedback1 = new JLabel("");
		feedback1.setForeground(new Color(255, 128, 64));
		feedback1.setHorizontalAlignment(SwingConstants.CENTER);
		feedback1.setFont(new Font("Sitka Text", Font.BOLD | Font.ITALIC, 18));
		feedback1.setBounds(650, 253, 350, 30);
		contentPane.add(feedback1);
		
		feedback2 = new JLabel("");
		feedback2.setForeground(new Color(255, 128, 64));
		feedback2.setHorizontalAlignment(SwingConstants.CENTER);
		feedback2.setFont(new Font("Sitka Text", Font.BOLD | Font.ITALIC, 18));
		feedback2.setBounds(650, 284, 350, 30);
		contentPane.add(feedback2);
		
		JLabel arkaPlan = new JLabel(new ImageIcon(getClass().getResource("arkaPlan.jpg")));
		arkaPlan.setBounds(0, 0, 1000, 600);
		contentPane.add(arkaPlan);
		
		nocekme = new JTextField();;
		nocekme.setText(kullanicino);
		
		//contentPane.add(table);
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				kitapid.setText((String)modelim.getValueAt(table.getSelectedRow(), 0));
				kitapisimmm.setText((String)modelim.getValueAt(table.getSelectedRow(), 1));
			}
		});
		

	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "KITAPLARI LISTELE");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			feedback1.setText("");
			feedback2.setText("");
			ResultSet myRs = baglakitap.yap();
			modelim.setRowCount(0);
			//modelim.addRow(satirlar);	
			try {
				while(myRs.next()) {
					satirlar[0] = myRs.getString("kitapid");
					satirlar[1] = myRs.getString("kitapismi");
					satirlar[2] = myRs.getString("kitapyazari");
					satirlar[3] = myRs.getString("kitapsf");
					if(myRs.getString("alindimi").equals("0")) {
						satirlar[4] = "Alinabilir";
					}else {
						satirlar[4] = "Mevcut değil";
					}
					modelim.addRow(satirlar);
					
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			table.setModel(modelim);	
		}
	}
	private class SwingAction_1 extends AbstractAction {
		public SwingAction_1() {
			putValue(NAME, "ODUNC AL");
			putValue(SHORT_DESCRIPTION, "Some short description");
			
		}
		public void actionPerformed(ActionEvent e) {
			feedback1.setText("");
			feedback2.setText("");
			
			String kitapid1 = kitapid.getText();
			String kitapismi = kitapisimmm.getText();
			String kullanicino = nocekme.getText();
			
			String basari1 = "adli kitap basariyla alindi!";
			String hata1 = "Bu kitap alinmis!";
			String hata1_1 = "Lutfen baska bir kitap seciniz!";
			String hata2 = "Once aldigin kitabı teslim et!";
			
			String sql="SELECT * FROM ogrenci WHERE ogrno='"+kullanicino+"'";
			String sql2 = "SELECT * FROM kitaplar WHERE kitapid='"+ kitapid1 +"'";
			
			String yok = "YOK";


			try {
				ResultSet myRs1 = bagla.bul(sql);
				ResultSet myRs2 = baglakitap.bul(sql2);

				while(myRs1.next() && myRs2.next()) {
					if(myRs2.getString("alindimi").equals("0")){
						if ((kullanicino.equals(myRs1.getString("ogrno")) && (yok.equals(myRs1.getString("aldigikitap"))))) {
							
							String alankisi = myRs1.getString("ogrisim");
							
							String sqlupdate = "UPDATE ogrenci SET aldigikitap = '" + kitapismi + "' WHERE ogrno = '"+kullanicino+"'";
							bagla.update(sqlupdate);

							feedback1.setText(kitapismi);
							feedback2.setText(basari1);
							String sqlupdate1 = "UPDATE kitaplar SET alindimi = '" + 1 + "' WHERE kitapismi = '"+kitapismi+"'";
							baglakitap.update(sqlupdate1);
							logla.aldi(alankisi, kitapismi);
							
						}else {
							feedback1.setText(hata2);
						}
					}else {
						feedback1.setText(hata1);
						feedback2.setText(hata1_1);
					}

				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
	}

	private class SwingAction_2 extends AbstractAction {
		public SwingAction_2() {
			putValue(NAME, "GERI DON");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			String kullanicino = nocekme.getText();
			String isim = isimcekme.getText();
			ogrencimenu frame1 = new ogrencimenu(kullanicino, isim);
			frame1.setVisible(true); 
			dispose();
		}
	}
}
