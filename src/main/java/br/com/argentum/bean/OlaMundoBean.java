package br.com.argentum.bean;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class OlaMundoBean {

	
	private String mensagem = "esssa msg veio direto do bean";
	private String nome;
	
	public String getMensagem() {
		return this.mensagem;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void botaoClicado(){
		System.out.println("O botão foi clicado! Seu nome é: " + this.nome);
	}
	
}
