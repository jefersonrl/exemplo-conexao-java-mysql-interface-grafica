package view;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import model.Alunos;
import controller.AlunosJdbcDAO;
import controller.JdbUtil;;

public class AlunosExec extends JFrame{
	
		JLabel lblNome = new JLabel("Nome: ");
		JLabel lblEndereco = new JLabel("Endereço: ");
		JLabel lblBairro = new JLabel("Bairro: ");
	
		JTextField txtNome = new JTextField();
		JTextField txtEnd = new JTextField();
		JTextField txtBairro = new JTextField();
		
		JButton btnCadastrar = new JButton("Cadastrar");
		
		Alunos alunos = new Alunos();
		
		public AlunosExec(){
			super("Tela");
			
			Container paine = this.getContentPane();
			paine.setLayout(null);
			
			lblNome.setBounds(20, 20, 100, 20);
			paine.add(lblNome);
			
			txtNome.setBounds(140, 20, 200, 20);
			paine.add(txtNome);
			
			lblEndereco.setBounds(20, 60, 100, 20);
			paine.add(lblEndereco);
			
			txtEnd.setBounds(140, 60, 200, 20);
			paine.add(txtEnd);
			
			lblBairro.setBounds(20, 90, 100, 20);
			paine.add(lblBairro);
			
			txtBairro.setBounds(140, 90, 200, 20);
			paine.add(txtBairro);
			
			btnCadastrar.setBounds(140, 120, 200, 20);
			paine.add(btnCadastrar);
			btnCadastrar.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					try {
						
						alunos.setNome(txtNome.getText());
						alunos.setEndereco(txtEnd.getText());
						alunos.setBairro(txtBairro.getText());
						
						Connection connection = JdbUtil.getConnection();
						AlunosJdbcDAO alunosJdbcDao = new AlunosJdbcDAO(connection);
						
						alunosJdbcDao.salvar(alunos);
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				}
			});
			
			
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.setSize(400, 400);
			this.setVisible(true);
			this.setResizable(false);
		}
		
		public static void main(String args[]) {
			AlunosExec ex = new AlunosExec();
		}
		
		
		
		
		
		
		
		
		
		

}
