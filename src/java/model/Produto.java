package model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Produto implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String nome;
    private String descricao;
    private float valor = 0;
    private int quant = 0;
    private String Foto01;
    private String Foto02;
    private String Foto03;
    private boolean ativo = true;

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Produto)) {
            return false;
        }
        Produto other = (Produto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Produto[ id=" + id + " ]";
    }

    private String isDados() {
        String erros = "";

        if (nome.equals("")) {
            erros += "Nome em branco.\n";
        }

        if (descricao.equals("")) {
            erros += "Descrição em branco.\n";
        }

        if (valor <= 0) {
            erros += "Valor zerado ou negativo.\n";
        }

        if (quant <= 0) {
            erros += "Quantidade zerada ou negativa.\n";
        }

        if (Foto01.equals("")) {
            erros += "Produto sem foto.\n";
        }

        return erros;
    }

    public void validar() throws Exception {
        String erros = isDados();
        if (!erros.equals("")) {
            throw new Exception(erros);
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public int getQuant() {
        return quant;
    }

    public void setQuant(int quant) {
        this.quant = quant;
    }

    public String getFoto01() {
        return Foto01;
    }

    public void setFoto01(String Foto01) {
        this.Foto01 = Foto01;
    }

    public String getFoto02() {
        return Foto02;
    }

    public void setFoto02(String Foto02) {
        this.Foto02 = Foto02;
    }

    public String getFoto03() {
        return Foto03;
    }

    public void setFoto03(String Foto03) {
        this.Foto03 = Foto03;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

}
