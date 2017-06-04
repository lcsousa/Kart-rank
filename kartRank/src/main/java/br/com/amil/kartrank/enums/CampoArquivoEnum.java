package br.com.amil.kartrank.enums;

/*
 * Enum responsável por indicar a posição do registro na linha do arquivo de entrada(Log)
 */
public enum CampoArquivoEnum {

	HORA(0,18),
	PILOTO_CODIGO(18,21),
	PILOTO_NOME(24,44),
	NUMERO_VOLTA(44,50),
	TEMPO_VOLTA(50,70),
	VELOCIDADE_MEDIA(70);

	private CampoArquivoEnum(int posicaoInicial, int posicaoFinal) {
		this.posicaoInicial = posicaoInicial;
		this.posicaoFinal = posicaoFinal;
	}
	private CampoArquivoEnum(int posicaoInicial) {
		this.posicaoInicial = posicaoInicial;
	}
	private Integer posicaoInicial;
	private Integer posicaoFinal;
	
	public Integer getPosicaoInicial() {
		return posicaoInicial;
	}
	public Integer getPosicaoFinal() {
		return posicaoFinal;
	}
	
	

	
}
