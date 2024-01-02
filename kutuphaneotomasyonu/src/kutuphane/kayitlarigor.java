package kutuphane;

import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.Action;

public class kayitlarigor extends JFrame {

	DefaultTableModel modelim = new DefaultTableModel();
	
	Object[] kolonlar = {"ISLEM ID", "ISLEM YAPAN KISI", "KITAP", "ISLEM"};
	Object[] satirlar = new Object[4];
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JButton Listele;
	private final Action listeleme = new SwingAction();
	private JButton btnGerDon;
	private final Action geriDon = new SwingAction_1();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					kayitlarigor frame = new kayitlarigor();
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
	public kayitlarigor() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(girisGUI.class.getResource("/kutuphane/logo.png")));
		setTitle("BAIBU KUTUPHANE");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 128, 64));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(29, 17, 930, 480);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setBounds(50, 50, 500, 500);
		modelim.setColumnIdentifiers(kolonlar);
		table.setBounds(50, 50, 300, 300);
		scrollPane.setViewportView(table);
		
		Listele = new JButton("LISTELE");
		Listele.setAction(listeleme);
		Listele.setBounds(419, 520, 150, 30);
		contentPane.add(Listele);
		
		btnGerDon = new JButton("GERI DON");
		btnGerDon.setAction(geriDon);
		btnGerDon.setBounds(41, 520, 150, 30);
		contentPane.add(btnGerDon);
	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "LISTELE");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			ResultSet myRs = baglalog.yap();
			modelim.setRowCount(0);
			try {
				while(myRs.next()) {
					satirlar[0] = myRs.getString("id");
					satirlar[1] = myRs.getString("ogrismi");
					satirlar[2] = myRs.getString("kitap");
					satirlar[3] = myRs.getString("islem");
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
