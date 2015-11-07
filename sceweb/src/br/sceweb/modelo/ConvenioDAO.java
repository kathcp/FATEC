package br.sceweb.modelo;

public class ConvenioDAO {
	
	private Convenio convenio;
	private String dataInicio = "07/11/2015";
	
	
	public int adiciona(Convenio convenio){
		convenio.setDataInicio(dataInicio);
		return 1;
	}
	
	public int exclui(String cnpj){
		return 1;
	}

}
