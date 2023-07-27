package interfaz;
import logica.Logica;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.ActionEvent;

public class Moneda extends JFrame {

	private JPanel contentPane;
	private JTextField input;
	/**
	 * Create the frame.
	 */
	public Moneda() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 345, 361);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		JPanel panel = new JPanel();
		panel.setBounds(10, 10, 311, 304);
		contentPane.add(panel);
		panel.setLayout(null);
		
		Logica obj = new Logica(false);
		JComboBox comboBox = new JComboBox(obj.mostrarOpciones());
		
		
		comboBox.setBounds(76, 47, 149, 25);
		panel.add(comboBox);
		
		JLabel lblNewLabel = new JLabel("Convertir");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(76, 20, 149, 17);
		panel.add(lblNewLabel);
		
		JLabel lblA = new JLabel("a");
		lblA.setHorizontalAlignment(SwingConstants.CENTER);
		lblA.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblA.setBounds(76, 82, 149, 17);
		panel.add(lblA);
		
		JComboBox comboBox_1 = new JComboBox(obj.mostrarOpciones());
		comboBox_1.setBounds(76, 109, 149, 25);
		panel.add(comboBox_1);
		
		
		
		
		input = new JTextField();
		input.setHorizontalAlignment(SwingConstants.CENTER);
		input.setFont(new Font("Tahoma", Font.PLAIN, 14));
		input.setText("0");
		input.setBounds(76, 184, 149, 25);
		panel.add(input);
		input.setColumns(10);
		
		JLabel lblobjeraturaActual = new JLabel("Moneda actual");
		lblobjeraturaActual.setHorizontalAlignment(SwingConstants.CENTER);
		lblobjeraturaActual.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblobjeraturaActual.setBounds(76, 157, 149, 17);
		panel.add(lblobjeraturaActual);
		
		JLabel lblobjeraturaConvertida = new JLabel("Moneda convertida");
		lblobjeraturaConvertida.setHorizontalAlignment(SwingConstants.CENTER);
		lblobjeraturaConvertida.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblobjeraturaConvertida.setBounds(67, 229, 176, 17);
		panel.add(lblobjeraturaConvertida);
		
		JLabel output = new JLabel("0");
		output.setHorizontalAlignment(SwingConstants.CENTER);
		output.setFont(new Font("Tahoma", Font.PLAIN, 14));
		output.setBounds(76, 256, 149, 17);
		panel.add(output);
		
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				output.setText(obj.resultado(comboBox.getSelectedIndex()+1,comboBox_1.getSelectedIndex()+1, input.getText()));
			}
		});
		comboBox_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				output.setText(obj.resultado(comboBox.getSelectedIndex()+1,comboBox_1.getSelectedIndex()+1, input.getText()));
			}
		});
		input.addKeyListener(new KeyListener() {
			public void keyTyped(KeyEvent e) {
				output.setText(obj.resultado(comboBox.getSelectedIndex()+1,comboBox_1.getSelectedIndex()+1, input.getText()));
            }

			@Override
			public void keyPressed(KeyEvent e) {
				output.setText(obj.resultado(comboBox.getSelectedIndex()+1,comboBox_1.getSelectedIndex()+1, input.getText()));
				
			}

			@Override
			public void keyReleased(KeyEvent e) {
				output.setText(obj.resultado(comboBox.getSelectedIndex()+1,comboBox_1.getSelectedIndex()+1, input.getText()));
				
			}
		});
		
		//setVisible(true);
		addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                Interfaz interfaz = new Interfaz();
                interfaz.setVisible(true);
            }
        });
		setVisible(true);
        
	}
}
