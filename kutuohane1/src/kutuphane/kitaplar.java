package kutuphane;

import java.util.ArrayList;

public class kitaplar {
	public ArrayList<String> kitapismi;
	public ArrayList<String> kitapyazari;
	public ArrayList<Integer> kitapsayfa;
	
	public kitaplar() {
		kitapismi = new ArrayList<String>();
		kitapismi.add("");
		kitapismi.add("");
		kitapismi.add("");
		kitapismi.add("");
		kitapismi.add("");
		kitapismi.add("");
		kitapismi.add("");
		kitapismi.add("");
		kitapismi.add("");
		kitapismi.add("");
		
		kitapyazari = new ArrayList<String>();
		kitapyazari.add("");
		kitapyazari.add("");
		kitapyazari.add("");
		kitapyazari.add("");
		kitapyazari.add("");
		kitapyazari.add("");
		kitapyazari.add("");
		kitapyazari.add("");
		kitapyazari.add("");
		kitapyazari.add("");
		
		kitapsayfa = new ArrayList<Integer>();
		kitapsayfa.add(0);
		kitapsayfa.add(0);
		kitapsayfa.add(0);
		kitapsayfa.add(0);
		kitapsayfa.add(0);
		kitapsayfa.add(0);
		kitapsayfa.add(0);
		kitapsayfa.add(0);
		kitapsayfa.add(0);
		kitapsayfa.add(0);
		

		import javax.swing.JFrame;
		import javax.swing.JTextField;
		import javax.swing.JOptionPane;

		public class VeritabaniBaglantisi extends JFrame {
		    JTextField kullaniciAdiText;

		    public VeritabaniBaglantisi() {
		        // Diğer bileşenler ve ayarlamalar burada olacak

		        kullaniciAdiText = new JTextField(20);

		        // Kullanıcı giriş yap butonu tıklanınca çalışacak kod
		        // Örneğin bir JButton kullanıyorsanız ve bu butonun listener'ı burada ise
		        // Bu listener içerisinde kullanıcı adı kontrolü yapabilirsiniz
		        // Örneğin:
		        girisYapButon.addActionListener(e -> {
		            String kullaniciAdi = kullaniciAdiText.getText().trim();
		            
		            // MySQL veritabanına bağlanma işlemi
		            try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/veritabani_adı", "kullanıcı_adı", "şifre")) {
		                String query = "SELECT * FROM ogrenci WHERE ogrisim = ?";
		                PreparedStatement statement = conn.prepareStatement(query);
		                statement.setString(1, kullaniciAdi);
		                ResultSet resultSet = statement.executeQuery();

		                if (resultSet.next()) {
		                    // Kullanıcı adı veritabanında bulundu
		                    // İşlemlerinizi burada gerçekleştirebilirsiniz
		                    JOptionPane.showMessageDialog(null, "Kullanıcı adı bulundu!");
		                } else {
		                    // Kullanıcı adı veritabanında bulunamadı
		                    JOptionPane.showMessageDialog(null, "Kullanıcı adı bulunamadı!");
		                }
		            } catch (SQLException ex) {
		                ex.printStackTrace();
		            }
		        });
		    }

		    // Diğer metodlar ve bileşenler burada olacak
		}

		
	}

	
	

	

}