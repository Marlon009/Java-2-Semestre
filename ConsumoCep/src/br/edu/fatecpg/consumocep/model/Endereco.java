package br.edu.fatecpg.consumocep.model;

import com.google.gson.annotations.SerializedName;



public class Endereco {
    private String cep;
    private String logradouro;
    private String estado;
    private String bairro;
    @SerializedName("localidade")
    private String cidade;
    private String traco = "---------------------------------------------";


    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }



    @Override
    public String toString() {
        return "\ncep: " + cep +
                "\nlogradouro: " + logradouro +
                "\nbairro: " + bairro +
                "\ncidade: " + cidade +
                "\nestado: " + estado +
                "\n"    +   traco;
    }
}




