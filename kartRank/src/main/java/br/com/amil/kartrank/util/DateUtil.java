package br.com.amil.kartrank.util;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * Classe utilit�ria respons�vel por opera��es envolvendo datas
 * @author LUIS CARDOSO
 *
 */
public class DateUtil {
	private static final DateTimeFormatter FORMATO_PADRAO_TEMPO = DateTimeFormatter.ofPattern("HH:mm:ss.SSS");

	/**
	 * Converte data no formato String para um num�rio em nanosegundos
	 * @param texto Data para convers�o
	 * @return data convertida para nanosegundos
	 */
	public static long converterHorarioEmInteiro(String texto) {
		return LocalTime.parse(GeralUtil.completarHoraPadrao(texto), FORMATO_PADRAO_TEMPO).toNanoOfDay();
	}

	/**
	 * Converte um num�rico em nano segundos para String 
	 * @param tempo data em nanosegundos
	 * @return data convertida para String
	 */
	public static String converterInteiroEmEmHorario(long tempo) {
		return LocalTime.ofNanoOfDay(tempo).format(FORMATO_PADRAO_TEMPO);
	}

}
