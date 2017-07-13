package br.com.argentum.ws;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import br.com.argentum.modelo.Negociacao;
import br.com.argentum.reader.LeitorXml;

// Client para o Webservice
public class ClientWebService {
	
	public static final String URL_WERSERVICE = "http://argentumws.caelum.com.br/negociacoes";

	public List<Negociacao> getNegociacoes() {

		HttpURLConnection conection = null;

		try {
			URL url = new URL(URL_WERSERVICE); //URL faz referencia a um recurso na Web, seja ele um arquivo ou até mesmo um diretório 
			conection = (HttpURLConnection) url.openConnection(); //openConnection faz uma requisicao Http

			InputStream content = conection.getInputStream(); //pega a lista de negociacoes

			return new LeitorXml().carrega(content);

		} catch (IOException e) {
			throw new RuntimeException(e);
		} finally {
			conection.disconnect();

		}

	}
	
	public static void main(String[] args) {
		
		ClientWebService ws = new ClientWebService();
		
		List<Negociacao> negociacoes = ws.getNegociacoes();
		
		for(Negociacao negociacao : negociacoes){
			System.out.println(negociacao.getPreco());
		}
		
	}

}
