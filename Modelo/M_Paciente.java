
package Modelo;

import java.io.FileInputStream;
import java.io.InputStream;
import javax.naming.BinaryRefAddr;

public class M_Paciente {
    private Integer id_paciente;
    private String nome;
    private Integer carsus;
    private Integer id_estado;
    private String nascimento;
    private Integer id_cidade;
    private String cpf;
    private String rg;
    private String telefone;
    private String naturalidade;
    private String endereco;
    private String numero;
    private String estado_civil;
    private String cep;
    private String nomepai;
    private String nomemae;
    private String celular;
    private String bairro;
    private String sexo;
    private InputStream foto;

    /**
     * @return the id_paciente
     */
    public Integer getId_paciente() {
        return id_paciente;
    }

    /**
     * @param id_paciente the id_paciente to set
     */
    public void setId_paciente(Integer id_paciente) {
        this.id_paciente = id_paciente;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the carsus
     */
    public Integer getCarsus() {
        return carsus;
    }

    /**
     * @param carsus the carsus to set
     */
    public void setCarsus(Integer carsus) {
        this.carsus = carsus;
    }

    /**
     * @return the id_estado
     */
    public Integer getId_estado() {
        return id_estado;
    }

    /**
     * @param id_estado the id_estado to set
     */
    public void setId_estado(Integer id_estado) {
        this.id_estado = id_estado;
    }

    /**
     * @return the nascimento
     */
    public String getNascimento() {
        return nascimento;
    }

    /**
     * @param nascimento the nascimento to set
     */
    public void setNascimento(String nascimento) {
        this.nascimento = nascimento;
    }

    /**
     * @return the id_cidade
     */
    public Integer getId_cidade() {
        return id_cidade;
    }

    /**
     * @param id_cidade the id_cidade to set
     */
    public void setId_cidade(Integer id_cidade) {
        this.id_cidade = id_cidade;
    }

    /**
     * @return the cpf
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * @param cpf the cpf to set
     */
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    /**
     * @return the rg
     */
    public String getRg() {
        return rg;
    }

    /**
     * @param rg the rg to set
     */
    public void setRg(String rg) {
        this.rg = rg;
    }

    /**
     * @return the telefone
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     * @param telefone the telefone to set
     */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    /**
     * @return the naturalidade
     */
    public String getNaturalidade() {
        return naturalidade;
    }

    /**
     * @param naturalidade the naturalidade to set
     */
    public void setNaturalidade(String naturalidade) {
        this.naturalidade = naturalidade;
    }

    /**
     * @return the endereco
     */
    public String getEndereco() {
        return endereco;
    }

    /**
     * @param endereco the endereco to set
     */
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }


    /**
     * @return the estado_civil
     */
    public String getEstado_civil() {
        return estado_civil;
    }

    /**
     * @param estado_civil the estado_civil to set
     */
    public void setEstado_civil(String estado_civil) {
        this.estado_civil = estado_civil;
    }

    /**
     * @return the cep
     */
    public String getCep() {
        return cep;
    }

    /**
     * @param cep the cep to set
     */
    public void setCep(String cep) {
        this.cep = cep;
    }

    /**
     * @return the nomepai
     */
    public String getNomepai() {
        return nomepai;
    }

    /**
     * @param nomepai the nomepai to set
     */
    public void setNomepai(String nomepai) {
        this.nomepai = nomepai;
    }

    /**
     * @return the nomemae
     */
    public String getNomemae() {
        return nomemae;
    }

    /**
     * @param nomemae the nomemae to set
     */
    public void setNomemae(String nomemae) {
        this.nomemae = nomemae;
    }

    /**
     * @return the celular
     */
    public String getCelular() {
        return celular;
    }

    /**
     * @param celular the celular to set
     */
    public void setCelular(String celular) {
        this.celular = celular;
    }

    /**
     * @return the bairro
     */
    public String getBairro() {
        return bairro;
    }

    /**
     * @param bairro the bairro to set
     */
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    /**
     * @return the sexo
     */
    public String getSexo() {
        return sexo;
    }

    /**
     * @param sexo the sexo to set
     */
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    /**
     * @return the foto
     */
    public InputStream getFoto() {
        return foto;
    }

    /**
     * @param foto the foto to set
     */
    public void setFoto(InputStream foto) {
        this.foto = foto;
    }

    /**
     * @return the numero
     */
    public String getNumero() {
        return numero;
    }

    /**
     * @param numero the numero to set
     */
    public void setNumero(String numero) {
        this.numero = numero;
    }

}
