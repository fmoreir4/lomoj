package util;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Login implements EntitysBase, Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

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
        if (!(object instanceof Login)) {
            return false;
        }
        Login other = (Login) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "util.Tipo[ id=" + id + " ]";
    }

    String login;
    String pws;
    String access;

    //Gets e Sets
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPws() {
        return pws;
    }

    public void setPws(String pws) {
        this.pws = pws;
    }

    public String getAccess() {
        return access;
    }

    public void setAccess(String access) {
        this.access = access;
    }

    //Validações
    private String isLogin(String confSenha) {
        String erros = "";

        if (login.equals("")) {
            erros += "Login em branco. \n";
        }

        if (pws.equals("")) {
            erros += "Senha em branco.\n";
        } else if (pws.length() < 6) {
            erros += "Senha muito curta. Mínimo de 6 caracteres.\n";
        } else if (!pws.equals(confSenha)) {
            erros += "Senhas diferentes.\n";
        }
        return erros;
    }

    public void validar(String confSenha) throws Exception {
        String erros = isLogin(confSenha);
        if (!erros.equals("")) {
            throw new Exception(erros);
        }
    }

}
