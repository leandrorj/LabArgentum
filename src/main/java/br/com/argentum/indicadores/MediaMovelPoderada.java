package br.com.argentum.indicadores;

import br.com.argentum.modelo.SerieTemporal;

public class MediaMovelPoderada implements Indicador {

	@Override
	public double calcula(int posicao, SerieTemporal serie) {
		double soma = 0;

		for (int i = posicao; i > posicao - 3; i--) {
			soma += serie.getCandle(i).getFechamento();
		}
		return soma/6;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "MMP - Fechamento";
	}

}
