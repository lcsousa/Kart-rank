package br.com.amil.kartrank.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import br.com.amil.kartrank.enums.CampoArquivoEnum;
 
/**
 * Classe utilitária responsável por alguns métodos gerais utilizados no progero
 * @author LUIS CARDOSO
 *
 */
public class GeralUtil {
	
	/**
	 * 
	 * @param palavra String inteira
	 * @param campo objeto com informação de posição da substring
	 * @return substring solicitada
	 */
	public static String getSubStringTrim(String palavra, CampoArquivoEnum campo) {
		String retorno = palavra;
		
		if(campo.getPosicaoFinal() == null){
			retorno = palavra.substring(campo.getPosicaoInicial()).trim();
			
		}else if(palavra!=null && palavra.length() > campo.getPosicaoFinal()){
			retorno = palavra.substring(campo.getPosicaoInicial(), campo.getPosicaoFinal()).trim();
		}			
		
		return retorno;
	}
	
	/**
	 * Formata horas no padrão 00:00:00.xxx
	 * @param horaEntrada hora a ser formatada
	 * @return hora formatada
	 */
	public static String completarHoraPadrao(String horaEntrada){
		String hora= horaEntrada;
		Matcher m = Pattern.compile(":",Pattern.DOTALL).matcher(horaEntrada);
		int quantidade = 0;
		while (m.find()){
			quantidade++;
		}
		
		if(quantidade == 0){
			if((horaEntrada.indexOf(".") == 1) || (horaEntrada.indexOf(".") == -1 && horaEntrada.length()==1)){
				hora="0"+hora;
			}
			hora="00:00:"+hora;
		}else if(quantidade == 1){
			if(horaEntrada.indexOf(":") == 1){
				hora="0"+hora;
			}
			hora="00:"+hora;
		}else if(quantidade == 2){
			if(horaEntrada.indexOf(":") == 1){
				hora="0"+hora;
			}
		}

		
		return hora;
	}
}
