package pack;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class TestarPessoa {

    public static void main(String[] args) {
        boolean repetir = true;

        while (repetir) {
            Pessoa pessoa = new Pessoa();

            String nome = JOptionPane.showInputDialog("Informe o nome da pessoa:");
            pessoa.setNome(nome);

            String idadeStr = JOptionPane.showInputDialog("Informe a idade da pessoa:");
            int idade = Integer.parseInt(idadeStr);
            pessoa.setIdade(idade);

            String endereco = JOptionPane.showInputDialog("Informe o endereço da pessoa:");
            pessoa.setEndereco(endereco);

            salvarDadosNoBanco(pessoa);

            JOptionPane.showMessageDialog(null, "Informações da Pessoa salvas no banco de dados.");

            int resposta = JOptionPane.showConfirmDialog(null, "Deseja repetir o processo?", "Repetir", JOptionPane.YES_NO_OPTION);
            repetir = (resposta == JOptionPane.YES_OPTION);

        }

    }
    
    private static void salvarDadosNoBanco(Pessoa pessoa) {
        String url = "jdbc:mysql://localhost:3306/salvarbd";
        String usuario = "root";
        String senha = "2127";
        
        String sql = "INSERT INTO tabela_pessoa (nome, idade, endereco) VALUES (?, ?, ?)";
        
        try (Connection conn = DriverManager.getConnection(url, usuario, senha);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, pessoa.getNome());
            stmt.setInt(2, pessoa.getIdade());
            stmt.setString(3, pessoa.getEndereco());
            
            stmt.executeUpdate();
            
            System.out.println("Dados salvos no banco de dados com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao Tentar Salvar" + e.getMessage());
        }
    }
}
