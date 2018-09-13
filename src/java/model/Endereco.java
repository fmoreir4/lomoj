package model;

import java.io.Serializable;
//import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;

//@Embeddable
@Entity
public class Endereco implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private String cep;
    private String logradouro;
    private String bairro;
    private String cidade;
    private String uf;

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    //Validação
    public String validar() {
        String erros = "";
        if (cep.equals("")) {
            erros += "CEP em branco. \n";
        }
        if (logradouro.equals("")) {
            erros += "Logradouro em branco. \n";
        }
        if (bairro.equals("")) {
            erros += "Bairro em branco. \n";
        }
        if (cidade.equals("")) {
            erros += "Cidade em branco. \n";
        }
        if (uf.equals("")) {
            erros += "Estado em branco. \n";
        }

        return erros;
    }

}
