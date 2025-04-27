
package com.defensoria.model;

/**
 * Classe que representa um Assistido da Defensoria Pública
 * Contém todas as informações pessoais e de endereço do assistido
 */
public class Assistee {
    // Informações pessoais
    private String fullName;        // Nome completo do assistido
    private String cpf;            // CPF do assistido (identificador único)
    private String personalIdentity; // RG ou outro documento de identidade
    
    // Informações de endereço
    private String cep;            // CEP do endereço
    private String logradouro;     // Nome da rua/avenida
    private String numero;         // Número do endereço
    private String bairro;         // Bairro
    private String cidade;         // Cidade
    private String estado;         // Estado (UF)
    private String complemento;    // Complemento do endereço
    
    // Informações demográficas
    private String gender;         // Gênero do assistido
    private String racialIdentity; // Identidade racial do assistido

    /**
     * Construtor padrão necessário para o Spring
     */
    public Assistee() {}

    /**
     * Construtor com todos os campos obrigatórios
     */
    public Assistee(String fullName, String cpf, String cep, String logradouro, String numero, 
                   String bairro, String cidade, String estado, String complemento,
                   String gender, String racialIdentity) {
        this.fullName = fullName;
        this.cpf = cpf;
        this.cep = cep;
        this.logradouro = logradouro;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.complemento = complemento;
        this.gender = gender;
        this.racialIdentity = racialIdentity;
    }

    // Getters e Setters com comentários explicativos
    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }

    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }

    public String getPersonalIdentity() { return personalIdentity; }
    public void setPersonalIdentity(String personalIdentity) { this.personalIdentity = personalIdentity; }

    public String getCep() { return cep; }
    public void setCep(String cep) { this.cep = cep; }

    public String getLogradouro() { return logradouro; }
    public void setLogradouro(String logradouro) { this.logradouro = logradouro; }

    public String getNumero() { return numero; }
    public void setNumero(String numero) { this.numero = numero; }

    public String getBairro() { return bairro; }
    public void setBairro(String bairro) { this.bairro = bairro; }

    public String getCidade() { return cidade; }
    public void setCidade(String cidade) { this.cidade = cidade; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }

    public String getComplemento() { return complemento; }
    public void setComplemento(String complemento) { this.complemento = complemento; }

    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }

    public String getRacialIdentity() { return racialIdentity; }
    public void setRacialIdentity(String racialIdentity) { this.racialIdentity = racialIdentity; }
}
