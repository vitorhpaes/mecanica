package sistema;

public abstract class Pessoa {

    private int id;
    private String nome;
    private String cpf;
    private String email;
    private String cep;
    private String numero;
    private String telefone;

    public Pessoa() {
    }

    public Pessoa(String nome, String cpf, String email, String cep, String numero, String telefone) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.cep = cep;
        this.numero = numero;
        this.telefone = telefone;
    }

    public String getNome() {
        if (!nome.isEmpty()) {
            return nome;
        } else {
            return null;
        }
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        if (!cpf.isEmpty()) {
            return cpf;
        } else {
            return null;
        }
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        if (!email.isEmpty()) {
            return email;
        } else {
            return null;
        }
    }

    public String getNumero() {
        if (!numero.isEmpty()) {
            return numero;
        } else {
            return null;
        }
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCep() {
        if (!cep.isEmpty()) {
            return cep;
        } else {
            return null;
        }
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getTelefone() {
        if (!telefone.isEmpty()) {
            return telefone;
        } else {
            return null;
        }
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
