package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.border.TitledBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ConsultaPesquisaUI extends JInternalFrame {
	private JTable table_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsultaPesquisaUI frame = new ConsultaPesquisaUI();
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
	public ConsultaPesquisaUI() {
		setBounds(100, 100, 450, 300);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Consulta Pesquisa", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		getContentPane().add(panel, BorderLayout.CENTER);
		
		
		
		table_1 = new JTable();
		JButton listarbtn = new JButton("Listar");
		listarbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model = (DefaultTableModel) table_1.getModel();
				model.addRow(new Object[]{"Column 1", "Column 2", "Column 3"});
			}
		});
		table_1.setBackground(new Color(255, 255, 255));
		table_1.setColumnSelectionAllowed(true);
		table_1.setFillsViewportHeight(true);
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Instituto", "Data", "Local", "Idade M\u00E9dia", "Tippo de Pesquisa", "Formato da Pesquisa"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, Float.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table_1.getColumnModel().getColumn(4).setPreferredWidth(101);
		table_1.getColumnModel().getColumn(5).setPreferredWidth(116);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addComponent(listarbtn)
						.addComponent(table_1, GroupLayout.DEFAULT_SIZE, 412, Short.MAX_VALUE))
					.addGap(0))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(listarbtn)
					.addGap(8)
					.addComponent(table_1, GroupLayout.PREFERRED_SIZE, 206, Short.MAX_VALUE)
					.addGap(21))
		);
		panel.setLayout(gl_panel);
		
		
	}

}
