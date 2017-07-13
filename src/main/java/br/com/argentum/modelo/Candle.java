package br.com.argentum.modelo;

import java.time.LocalDateTime;
/*
 * Esta classe serve para resumir graficamente 
 * as principais informa��es sobre as negocia��es 
 * daquele dia, 
 */
public final class Candle {

	private final double abertura;
	private final double fechamento;
	private final double maximo;
	private final double minimo;
	private final double volume;
	private final LocalDateTime data;

	public Candle(double abertura, double fechamento, double maximo, double minimo, double volume,
			LocalDateTime data) {
		
		if(maximo < minimo){
			throw new IllegalArgumentException("O valor maximo n�o pode ser maior que o minimo");
		}
		
		this.abertura = abertura;
		this.fechamento = fechamento;
		this.maximo = maximo;
		this.minimo = minimo;
		this.volume = volume;
		this.data = data;
	}

	public double getAbertura() {
		return abertura;
	}

	public double getFechamento() {
		return fechamento;
	}

	public double getMaximo() {
		return maximo;
	}

	public double getMinimo() {
		return minimo;
	}

	public double getVolume() {
		return volume;
	}

	public LocalDateTime getData() {
		return data;
	}

	public boolean isAlta() {
		return this.fechamento >= this.abertura;
	}

	public boolean isBaixa() {
		return this.fechamento < this.abertura;
	}

}
