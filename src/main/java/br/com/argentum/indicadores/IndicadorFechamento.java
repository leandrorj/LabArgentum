package br.com.argentum.indicadores;

import br.com.argentum.modelo.SerieTemporal;

public class IndicadorFechamento implements Indicador  {

	@Override
	public double calcula(int posicao, SerieTemporal serie) {
		return serie.getCandle(posicao).getFechamento();
	}
	
	@Override
	public String toString() {
		return "Fechamento";
	}

}
