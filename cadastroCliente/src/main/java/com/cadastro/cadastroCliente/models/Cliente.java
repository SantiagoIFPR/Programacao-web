package com.cadastro.cadastroCliente.models;

public class Cliente {
    private String nome;
    private String rg;
    private String cpf;
    private String telefone;
    private String estado;
    private String cidade;
    private String endereco;
    
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRg() {
    	return rg;
    }
    public void setRg (String rg) {
    	this.rg = rg;
    }
    
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    
    public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	public String getEstado() {
    	return estado;
    }
    public void setEstado(String estado) {
    	this.estado = estado;
    }
    
    public String getCidade () {
    	return cidade;
    }
    public void setCidade(String cidade) {
    	this.cidade = cidade;
    }
    
    public String getEndereco() {
        return endereco;
    }
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
}
