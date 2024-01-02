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
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;


//bu sayfayi sadece admin girebilsin.
//admin burada kitap ekleyip silebilsin.
public class kitapyonet extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	
	DefaultTableModel modelim = new DefaultTableModel();
	
	Object[] kolonlar = {"KITAP ID", "KITAP ISMI", "KITAP YAZARI", "SAYFA SAYISI", "MEVCUTLUK"};
	Object[] satirlar = new Object[5];
	private JButton Listele;
	private final Action Listeleme = new SwingAction();
	private JTextField kitapismi;
	private JTextField kitapyazari;
	private JTextField kitapsf;
	private JLabel lblKtapIsm;
	private JLabel lblYazarIsm;
	private JLabel lblSayfaSays;
	private JLabel lblNewLabel;
	private final Action kitapEkleme = new SwingAction_1();
	private final Action kitapDuzenleme = new SwingAction_2();
	private final Action kitapSilme = new SwingAction_3();
	private final Action geriDonme = new SwingAction_4();
	private JTextField kitapid;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					kitapyonet frame = new kitapyonet();
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
	public kitapyonet() {
		setTitle("BAIBU KUTUPHANE");
		setIconImage(Toolkit.getDefaultToolkit().getImage(girisGUI.class.getResource("/kutuphane/logo.png")));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 128, 64));
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
				kitapid.setText((String)modelim.getValueAt(table.getSelectedRow(), 0));
				kitapismi.setText((String)modelim.getValueAt(table.getSelectedRow(), 1));
				kitapyazari.setText((String)modelim.getValueAt(table.getSelectedRow(), 2));
				kitapsf.setText((String)modelim.getValueAt(table.getSelectedRow(), 3));
			}
		});
		modelim.setColumnIdentifiers(kolonlar);
		table.setBounds(50, 50, 300, 300);
		scrollPane.setViewportView(table);
		
		Listele = new JButton("LISTELE");
		Listele.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Listele.setAction(Listeleme);
		Listele.setBounds(750, 100, 180, 40);
		contentPane.add(Listele);
		
		kitapismi = new JTextField();
		kitapismi.setBounds(830, 200, 100, 20);
		contentPane.add(kitapismi);
		kitapismi.setColumns(10);

		kitapyazari = new JTextField();
		kitapyazari.setBounds(830, 225, 100, 20);
		contentPane.add(kitapyazari);
		kitapyazari.setColumns(10);
		
		kitapsf = new JTextField();
		kitapsf.setBounds(830, 250, 100, 20);
		contentPane.add(kitapsf);
		kitapsf.setColumns(10);
		
		lblKtapIsm = new JLabel("KITAP ISMI:");
		lblKtapIsm.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblKtapIsm.setBounds(720, 200, 100, 20);
		contentPane.add(lblKtapIsm);
		
		lblYazarIsm = new JLabel("YAZAR ISMI:");
		lblYazarIsm.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblYazarIsm.setBounds(720, 225, 100, 20);
		contentPane.add(lblYazarIsm);
		
		lblSayfaSays = new JLabel("SAYFA SAYISI:");
		lblSayfaSays.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSayfaSays.setBounds(720, 250, 100, 20);
		contentPane.add(lblSayfaSays);
		
		lblNewLabel = new JLabel("KITAP EKLE / DÜZENLE");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(740, 175, 250, 20);
		contentPane.add(lblNewLabel);
		
		JButton btnKtapEkle = new JButton("KITAP EKLE");
		btnKtapEkle.setAction(kitapEkleme);
		btnKtapEkle.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnKtapEkle.setBounds(750, 280, 180, 40);
		contentPane.add(btnKtapEkle);
		
		JButton btnDuzenle = new JButton("DUZENLE");
		btnDuzenle.setAction(kitapDuzenleme);
		btnDuzenle.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnDuzenle.setBounds(750, 330, 180, 40);
		contentPane.add(btnDuzenle);
		
		JButton btnKitapSil = new JButton("KITAP SIL");
		btnKitapSil.setAction(kitapSilme);
		btnKitapSil.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnKitapSil.setBounds(750, 380, 180, 40);
		contentPane.add(btnKitapSil);
		
		JButton geriDon = new JButton("GERI DON");
		geriDon.setAction(geriDonme);
		geriDon.setFont(new Font("Tahoma", Font.PLAIN, 20));
		geriDon.setBounds(750, 501, 180, 40);
		contentPane.add(geriDon);
		
		kitapid = new JTextField();
		kitapid.setBounds(4000, 449, 96, 20);
		contentPane.add(kitapid);
		kitapid.setColumns(10);
		//contentPane.add(table);
		

	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "LISTELE");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			ResultSet myRs = baglakitap.yap();
			modelim.setRowCount(0);
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
			putValue(NAME, "KITAP EKLE");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			ResultSet myRs = baglakitap.yap();
			
			String isim, yazar, sf, sqlgonderici;
			isim = kitapismi.getText();
			yazar = kitapyazari.getText();
			sf = kitapsf.getText();
			
			sqlgonderici = "INSERT INTO kitaplar (kitapismi, kitapyazari, kitapsf) VALUES (" +
						   "'" + isim + "'," + "'" + yazar + "'," + "'" + sf + "')";
			//System.out.println(sqlgonderici);
			
			try {
				baglakitap.ekle(sqlgonderici);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	private class SwingAction_2 extends AbstractAction {
		public SwingAction_2() {
			putValue(NAME, "KITAP DUZENLE");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			//UPDATE kitaplar Set 
			
			String id, isim, yazar, sf, sqlgonderici;
			id = kitapid.getText();
			isim = kitapismi.getText();
			yazar = kitapyazari.getText();
			sf = kitapsf.getText();
			
			sqlgonderici = "UPDATE kitaplar SET kitapismi='"+isim+"'," +  
						   " kitapyazari='"+yazar+ "'," + " kitapsf='" + sf + "' " + 
						   "WHERE kitapid='" +id+"'";
			
			try {
				baglakitap.update(sqlgonderici);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	private class SwingAction_3 extends AbstractAction {
		public SwingAction_3() {
			putValue(NAME, "KITAP SIL");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			
			String id, sqlgonderici;
			
			id = kitapid.getText();
			sqlgonderici = "DELETE FROM kitaplar WHERE kitapid='" +id+"'";
			
			try {
				baglakitap.sil(sqlgonderici);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
	}
	private class SwingAction_4 extends AbstractAction {
		public SwingAction_4() {
			putValue(NAME, "GERI DON");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			yetkilimenu frame1 = new yetkilimenu();
			frame1.setVisible(true); 
			dispose();
		}
	}
}
