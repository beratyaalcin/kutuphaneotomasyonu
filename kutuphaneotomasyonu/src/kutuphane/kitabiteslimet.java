package kutuphane;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.Color;

public class kitabiteslimet extends girisGUI {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private final Action action = new SwingAction();
	private JTextField nocekme;
	private JTextField isimcekme;
	private final Action action_1 = new SwingAction_1();
	private JLabel feedback1;
	private JLabel feedback2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					kitabiteslimet frame = new kitabiteslimet(kullanicino, isim);
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
	public kitabiteslimet(String kullanicino, String isim) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel kitap = new JLabel("");
		kitap.setHorizontalAlignment(SwingConstants.CENTER);
		kitap.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD | Font.ITALIC, 25));
		kitap.setBounds(324, 153, 340, 30);
		contentPane.add(kitap);
		
		JButton btnNewButton = new JButton("TIKLA");
		btnNewButton.setAction(action);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(404, 235, 180, 40);
		btnNewButton.setIcon(new ImageIcon(ogrencimenu.class.getResource("teslimet.jpg")));
		contentPane.add(btnNewButton);
		
		JLabel feedback = new JLabel("");
		feedback.setHorizontalAlignment(SwingConstants.CENTER);
		feedback.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD | Font.ITALIC, 25));
		feedback.setBounds(324, 286, 340, 30);
		contentPane.add(feedback);
		
		nocekme = new JTextField();
		nocekme.setBounds(4000, 37, 96, 20);
		contentPane.add(nocekme);
		nocekme.setColumns(10);
		nocekme.setText(kullanicino);
		
		isimcekme = new JTextField();
		isimcekme.setBounds(4000, 67, 96, 20);
		contentPane.add(isimcekme);
		isimcekme.setColumns(10);
		isimcekme.setText(isim);
		
		feedback1 = new JLabel();
		feedback1.setForeground(new Color(255, 128, 64));
		feedback1.setBackground(new Color(255, 128, 64));
		feedback1.setHorizontalAlignment(SwingConstants.CENTER);
		feedback1.setFont(new Font("Sitka Text", Font.BOLD | Font.ITALIC, 20));
		feedback1.setBounds(294, 300, 400, 25);
		contentPane.add(feedback1);
		
		feedback2 = new JLabel();
		feedback2.setForeground(new Color(255, 128, 64));
		feedback2.setBackground(new Color(255, 128, 64));
		feedback2.setHorizontalAlignment(SwingConstants.CENTER);
		feedback2.setFont(new Font("Sitka Text", Font.BOLD | Font.ITALIC, 20));
		feedback2.setBounds(294, 340, 400, 25);
		contentPane.add(feedback2);
		
		JButton geriDon = new JButton("TIKLA");
		geriDon.setAction(action_1);
		geriDon.setFont(new Font("Tahoma", Font.PLAIN, 20));
		geriDon.setBounds(414, 425, 160, 40);
		geriDon.setIcon(new ImageIcon(ogrencimenu.class.getResource("geridon.jpg")));
		contentPane.add(geriDon);
		
		JLabel arkaPlan = new JLabel(new ImageIcon(getClass().getResource("arkaPlan.jpg")));
		arkaPlan.setBounds(0, 0, 1000, 600);
		contentPane.add(arkaPlan);
		
	}

	private class SwingAction extends AbstractAction {
		public SwingAction() {

			
			putValue(NAME, "TIKLA");
			putValue(SHORT_DESCRIPTION, "Some short description");
			
		}
		public void actionPerformed(ActionEvent e) {
			String kullanicino = nocekme.getText();
			String isim = isimcekme.getText();
			String sql="SELECT * FROM ogrenci WHERE ogrno='"+kullanicino+"'";
			
			feedback1.setText("");
			feedback2.setText("");
			
			
			String yok = "YOK";
			
			//putValue(NAME, "KITAP ALINMAMIS");
			
			try {
				ResultSet myRs1 = bagla.bul(sql);
				while(myRs1.next()) {
					String kitapismi = myRs1.getString("aldigikitap");
					if(kitapismi.equals(yok)) {
						feedback1.setText("TESLIM EDECEK KITAP BULUNAMADI!");
					}else {
						String sqlupdate = "UPDATE ogrenci SET aldigikitap = '" + yok + "' WHERE ogrno = '"+kullanicino+"'";
						bagla.update(sqlupdate);
						String sql2 = "SELECT * FROM kitaplar WHERE kitapismi='"+ kitapismi +"'";
						ResultSet myRs2 = baglakitap.bul(sql2);
						feedback1.setText(kitapismi);
						feedback2.setText("ADLI KITAP TESLIM EDILDI!");
						
						
						while(myRs2.next()) {
							String sqlupdate1 = "UPDATE kitaplar SET alindimi = '" + 0 + "' WHERE kitapismi = '"+kitapismi+"'";
							baglakitap.update(sqlupdate1);
							logla.verdi(isim, kitapismi);
						}

					}
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
					
		}
	}
	private class SwingAction_1 extends AbstractAction {
		public SwingAction_1() {
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
