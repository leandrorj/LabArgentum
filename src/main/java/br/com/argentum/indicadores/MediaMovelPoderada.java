package br.com.argentum.indicadores;

import br.com.argentum.modelo.SerieTemporal;

public class MediaMovelPoderada implements Indicador {
	
	private Indicador outroIndicador = new IndicadorFechamento();
	
	public MediaMovelPoderada() {
	
	}
	
	public MediaMovelPoderada(Indicador outroIndicador) {
		this.outroIndicador = outroIndicador;
	}
	
	
	@Override
	public double calcula(int posicao, SerieTemporal serie) {
		double soma = 0;

		for (int i = posicao; i > posicao - 3; i--) {
			soma += outroIndicador.calcula(i, serie);
		}
		return soma/6;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "MMP de " + outroIndicador.toString();
	}

}
