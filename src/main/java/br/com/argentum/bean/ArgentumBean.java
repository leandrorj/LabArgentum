package br.com.argentum.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;

import org.primefaces.model.chart.LineChartModel;

import br.com.argentum.graficos.GeradorDeModeloGrafico;
import br.com.argentum.indicadores.IndicadorFechamento;
import br.com.argentum.indicadores.MediaMovelSimples;
import br.com.argentum.modelo.Candle;
import br.com.argentum.modelo.CandleFactory;
import br.com.argentum.modelo.Negociacao;
import br.com.argentum.modelo.SerieTemporal;
import br.com.argentum.ws.ClientWebService;

@ViewScoped  //a classe fica com duracao de um view (nao recarrega a requisicao)
@ManagedBean
public class ArgentumBean implements Serializable {
	
	private List<Negociacao> negociacoes;
	
	private LineChartModel modeloGrafico;


	public ArgentumBean(){
		this.negociacoes = new ClientWebService().getNegociacoes();
		
		List<Candle> candles = new CandleFactory().constroiCandles(negociacoes);
		
		SerieTemporal serie = new SerieTemporal(candles);
		
		
		GeradorDeModeloGrafico geradorModelo = new GeradorDeModeloGrafico(serie, 2, serie.getUltimaPosicao());
		geradorModelo.plotaIndicador(new MediaMovelSimples(new IndicadorAbertura()));
		this.modeloGrafico = geradorModelo.getModeloGrafico();
		
		
		
		/*this.modeloGrafico = new LineChartModel();
		this.modeloGrafico.setTitle("Meu primeiro Gráfico");
		this.modeloGrafico.setLegendPosition("w"); //legenda do grafico
		
		LineChartSeries linha = new LineChartSeries();  //criacao da linha
		linha.setLabel("Valores"); //
		linha.set(1, 10.5);  //pontos da linha
		linha.set(2, 13.0);
		linha.set(3, 12.0);
		this.modeloGrafico.addSeries(linha);*/
		
	}
	
	public LineChartModel getModeloGrafico() {
		return modeloGrafico;
	}
	
	
	
	public List<Negociacao> getNegociacao(){
		return this.negociacoes;
	}
	
	
	

}
