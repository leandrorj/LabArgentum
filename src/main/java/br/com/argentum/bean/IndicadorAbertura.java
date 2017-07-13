package br.com.argentum.bean;

import br.com.argentum.indicadores.Indicador;
import br.com.argentum.modelo.SerieTemporal;

public class IndicadorAbertura implements Indicador {

	@Override
	public double calcula(int posicao, SerieTemporal serie) {
		// TODO Auto-generated method stub
		return serie.getCandle(posicao).getAbertura();
	}
	
	@Override
	public String toString() {
		return "Abertura";
	}

}
