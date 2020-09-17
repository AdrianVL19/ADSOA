package gui;

import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

import notGui.Connect;
import notGui.Terminate;

public class Gui {
	private Frame frame;
	private EnterNum en;
	private Clear cl;
	private ClearEverything ce;
	private Submit sb;
	private Connect ct;
	private Terminate tnt;
	
	private List<JButton> button = new ArrayList<JButton>();
	
	public void createNshow()
	{
		frame = new JFrame("Calculadora");
		
		Font font1 = new Font("Arial", Font.PLAIN, 50);
		
		JTextField field = new JTextField();
		field.setBounds(10, 40, 470, 50);
		field.setFont(font1);
		
		JTextField field2 = new JTextField();
		field2.setBounds(10, 500, 470, 50);
		field2.setFont(font1);
		
		en = new EnterNum(field);
		cl = new Clear(field);
		ce = new ClearEverything(field);
		
		
		
		int x = 10;
		int y = 110;
		
		int count = 0;
		
		
		for (int i=0; i < 3; i++)
		{
			for (int j = 0; j < 3; j++) {
				int s = count + 1;
				String label = Integer.toString(s);
				button.add(new JButton(label));
				button.get(count).setBounds(x, y, 60, 50);
				x = x+75;
				
				button.get(count).addActionListener(en);
				
				
				frame.add(button.get(count));
				count++;
			}
			x = 10;
			y = y+80;
			
		}
		
		button.add(new JButton("0"));
		button.get(count).setBounds(x, y, 60, 50);
		button.get(count).addActionListener(en);
		
		JButton plus = new JButton("+");
		plus.setBounds(240, 110, 100, 50);
		plus.addActionListener(en);
		
		JButton minus = new JButton("-");
		minus.setBounds(240, 190, 100, 50);
		minus.addActionListener(en);
		
		JButton divide = new JButton("/");
		divide.setBounds(240, 270, 100, 50);
		divide.addActionListener(en);
		
		JButton mult = new JButton("*");
		mult.setBounds(240, 350, 100, 50);
		mult.addActionListener(en);
		
		JButton delete = new JButton("C");
		delete.setBounds(85, y, 60, 50);
		delete.addActionListener(cl);
		
		JButton clear = new JButton("CE");
		clear.setBounds(160, y, 60, 50);
		clear.addActionListener(ce);
		
		JButton submit = new JButton("Enviar");
		submit.setBounds(10, 430, 120, 50);
		
		JButton nuke = new JButton("Desconectar");
		nuke.setBounds(360, 190, 120, 50);
		
		
		JButton connect = new JButton("Conectar");
		ct = new Connect(frame,connect, submit, nuke,field2);
		connect.setBounds(160, 430, 120, 50);
		connect.addActionListener(ct);
		
		sb = new Submit(field, ct);
		submit.addActionListener(sb);
		
		JButton close= new JButton("Cerrar");
		close.setBounds(360, 110, 120, 50);
		close.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent e){  
		           System.exit(0);  
		}  
		});
		
		tnt = new Terminate(ct, nuke, connect);
		nuke.addActionListener(tnt);
		
		frame.add(button.get(count));
		frame.add(plus);
		frame.add(minus);
		frame.add(divide);
		frame.add(mult);
		frame.add(delete);
		frame.add(clear);
		frame.add(submit);
		frame.add(connect);
		frame.add(close);
		frame.add(nuke);
		
		frame.add(field);
		frame.add(field2);
		
		field2.setEnabled(false);
		submit.setEnabled(false);
		nuke.setEnabled(false);
		
		
		
		frame.setSize(510, 600);
		frame.setLayout(null);
		frame.setVisible(true);
		
		
		
		
	}
	
	
}
