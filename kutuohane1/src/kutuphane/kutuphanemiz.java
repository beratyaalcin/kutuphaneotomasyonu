package kutuphane;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;

public class kutuphanemiz extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private final Action action = new SwingAction();
	private JTextField nocekme;
	private JTextField isimcekme;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					kutuphanemiz frame = new kutuphanemiz(kullanicino, isim);
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
	public kutuphanemiz(String kullanicino, String isim) {
		setTitle("BAIBU KUTUPHANE");
		setIconImage(Toolkit.getDefaultToolkit().getImage(girisGUI.class.getResource("/kutuphane/logo.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		

		
		JLabel TXT1 = new JLabel("1992 yılında kurulan Bolu Abant İzzet Baysal ");
		TXT1.setHorizontalAlignment(SwingConstants.CENTER);
		TXT1.setForeground(new Color(255, 128, 64));
		TXT1.setFont(new Font("Times New Roman", Font.PLAIN, 27));
		TXT1.setBounds(194, 120, 600, 40);
		contentPane.add(TXT1);
		
		JLabel TXT1_1 = new JLabel(" Üniversitesinin eğitim-öğretim ve araştırma faaliyetlerini desteklemek amacıyla ");
		TXT1_1.setHorizontalAlignment(SwingConstants.CENTER);
		TXT1_1.setForeground(new Color(255, 128, 64));
		TXT1_1.setFont(new Font("Times New Roman", Font.PLAIN, 27));
		TXT1_1.setBounds(-6, 160, 1000, 40);
		contentPane.add(TXT1_1);
		
		JLabel TXT1_2 = new JLabel("oluşturulan Merkez Kütüphane ilk olarak kampüs içerisindeki ");
		TXT1_2.setHorizontalAlignment(SwingConstants.CENTER);
		TXT1_2.setForeground(new Color(255, 128, 64));
		TXT1_2.setFont(new Font("Times New Roman", Font.PLAIN, 27));
		TXT1_2.setBounds(-6, 200, 1000, 40);
		contentPane.add(TXT1_2);
		
		JLabel TXT1_3 = new JLabel("İktisadi ve İdari Bilimler Fakültesi binasında hizmet vermeye ");
		TXT1_3.setHorizontalAlignment(SwingConstants.CENTER);
		TXT1_3.setForeground(new Color(255, 128, 64));
		TXT1_3.setFont(new Font("Times New Roman", Font.PLAIN, 27));
		TXT1_3.setBounds(-6, 240, 1000, 40);
		contentPane.add(TXT1_3);
		
		JLabel TXT1_4 = new JLabel("başlamıştır. 1996– 2002 yılları arasında Kültür Merkezindeki iki ");
		TXT1_4.setHorizontalAlignment(SwingConstants.CENTER);
		TXT1_4.setForeground(new Color(255, 128, 64));
		TXT1_4.setFont(new Font("Times New Roman", Font.PLAIN, 27));
		TXT1_4.setBounds(-6, 280, 1000, 40);
		contentPane.add(TXT1_4);
		
		JLabel TXT1_5 = new JLabel("salonda çalışmalarını sürdürmüştür. 2002 yılı Mayıs ayında ");
		TXT1_5.setHorizontalAlignment(SwingConstants.CENTER);
		TXT1_5.setForeground(new Color(255, 128, 64));
		TXT1_5.setFont(new Font("Times New Roman", Font.PLAIN, 27));
		TXT1_5.setBounds(-6, 320, 1000, 40);
		contentPane.add(TXT1_5);
		
		JLabel TXT1_6 = new JLabel(" Bilgi İşlem Daire Başkanlığının ortak kullanıma tahsis edilen 3 katlı, toplam 2.664 m²");
		TXT1_6.setHorizontalAlignment(SwingConstants.CENTER);
		TXT1_6.setForeground(new Color(255, 128, 64));
		TXT1_6.setFont(new Font("Times New Roman", Font.PLAIN, 27));
		TXT1_6.setBounds(-6, 360, 1000, 40);
		contentPane.add(TXT1_6);
		
		JLabel TXT1_6_1 = new JLabel("kullanım alanına sahip kendi hizmet binasına taşınmış ve 2019 Kasım ayına ");
		TXT1_6_1.setHorizontalAlignment(SwingConstants.CENTER);
		TXT1_6_1.setForeground(new Color(255, 128, 64));
		TXT1_6_1.setFont(new Font("Times New Roman", Font.PLAIN, 27));
		TXT1_6_1.setBounds(-6, 400, 1000, 40);
		contentPane.add(TXT1_6_1);
		
		JLabel TXT1_6_2 = new JLabel("kadar hizmetlerini bu binada sürdürmüştür. ");
		TXT1_6_2.setHorizontalAlignment(SwingConstants.CENTER);
		TXT1_6_2.setForeground(new Color(255, 128, 64));
		TXT1_6_2.setFont(new Font("Times New Roman", Font.PLAIN, 27));
		TXT1_6_2.setBounds(-6, 440, 1000, 40);
		contentPane.add(TXT1_6_2);

		JButton geriDon = new JButton("TIKLA");
		geriDon.setAction(action);
		//geriDon.setAction(action_1);
		geriDon.setFont(new Font("Tahoma", Font.PLAIN, 20));
		geriDon.setBounds(414, 480, 160, 40);
		geriDon.setIcon(new ImageIcon(ogrencimenu.class.getResource("geridon.jpg")));
		contentPane.add(geriDon);
		
		JLabel arkaPlan = new JLabel(new ImageIcon(getClass().getResource("arkaPlan.jpg")));
		arkaPlan.setBounds(0, 0, 1000, 600);
		contentPane.add(arkaPlan);
		
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
	}

	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
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
