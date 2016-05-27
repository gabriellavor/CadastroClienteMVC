package br.com.cadastroclientemvc.clientes;

/**
 *
 * @author Gabriel Lavor
 */
public class Clientes {     
    private int codigo = 0;
    private String nome = null;
    private String email = null;
    private String sexo = null;
    private String soube_nos = null;
    private String receber_notificacao = "0";
    
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getSexo() {
        return sexo;
    }

    public String getSoube_nos() {
        return soube_nos;
    }

    public String getReceber_notificacao() {
        return receber_notificacao;
    }
       
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public void setSoube_nos(String soube_nos) {
        this.soube_nos = soube_nos;
    }

    public void setReceber_notificacao(String receber_notificacao) {
        this.receber_notificacao = receber_notificacao;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
}
