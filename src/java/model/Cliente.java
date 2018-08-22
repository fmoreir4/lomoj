/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;

/**
 *
 * @author Aluno
 */
@Entity
public class Cliente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String nome;
    
    @Column(unique = true)
    private String email;
    
    private String pws;
    private String foto;   
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Calendar dataNasc;

    private boolean ativo = true;
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPws() {
        return pws;
    }

    public void setPws(String pws) {
        this.pws = pws;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cliente)) {
            return false;
        }
        Cliente other = (Cliente) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Cliente[ id=" + id + " ]";
    }

    private String isDados() {
        String erros = "";

        if (nome.equals("")) {
            erros += "Nome em branco.\n";
        }

        if (email.equals("")) {
            erros += "E-mail em branco.\n";
        }

        return erros;
    }

    private String isSenha(String confSenha) {
        String erros = "";
        if (pws.equals("")) {
            erros += "Senha em branco.\n";
        } else if (pws.length() < 6) {
            erros += "Senha muito curta. Mínimo de 6 caracteres.\n";
        } else if (!pws.equals(confSenha)) {
            erros += "Senhas diferentes.\n";
        }
        return erros;
    }

    public void validar() throws Exception {
        String erros = isDados();
        if (!erros.equals("")) {
            throw new Exception(erros);
        }
    }

    public void validar(String confSenha) throws Exception {
        String erros = isDados() + isSenha(confSenha);
        if (!erros.equals("")) {
            throw new Exception(erros);
        }
    }

    public Calendar getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(Calendar dataNasc) {
        this.dataNasc = dataNasc;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
    
}
