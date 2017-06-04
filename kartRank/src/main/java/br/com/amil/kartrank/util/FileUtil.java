package br.com.amil.kartrank.util;

import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Classe utilitária responsável por manipulação de arquivos
 * @author LUIS CARDOSO
 *
 */
public class FileUtil {

	/**
	 * Ler arquivo e retorna todas linhas do arquivo
	 * @param nome nome do arquivo
	 * @return Lista contendo todas linhas do arquivo
	 * @throws Exception 
	 */
	public static List<String> getLinhas(String nome) throws Exception {
		URL resource = FileUtil.class.getClassLoader().getResource(nome);
		if(resource == null){
			throw new Exception("Arquivo não encontrado");
		}
		try {
			List<String> listaLinhas = new ArrayList<String>();
			
			Path path = Paths.get(resource.toURI());
			Stream<String> lines = Files.lines(path);
			listaLinhas = lines.collect(Collectors.toList());
			lines.close();
			return listaLinhas;
		} catch (Exception e) {
			
			throw new Exception("Erro ao ler arquivo");
		}

	}

}
