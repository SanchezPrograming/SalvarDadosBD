package pack;

/**
 *
 * @author gustavo.msanchez
 */
public class Pessoa {
    private String nome = null;
    private int idade = 0;
    private String endereco = null;
    
    public void setNome(String nome){
        this.nome = nome;
    }
    
    public void setIdade(int idade){
        this.idade = idade;
    }
    
    public void setEndereco(String endereco){
        this.endereco = endereco;
    }
    
    public String getNome() {
        return nome;
    }
    
    public int getIdade() {
        return idade;
    }
    
    public String getEndereco() {
        return endereco;
    }
}
