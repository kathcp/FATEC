package br.sceweb.modelo;

public class Controle {
	
	EmpresaDAO empresaDAO;

	public Controle() {
		empresaDAO = new EmpresaDAO();
	}

	public String cadastrarEmpresa(String cnpj, String nomeDaEmpresa, String nomeFantasia, 
			String endereco,String telefone) {
		
		String msg = "";
		Empresa empresa = new Empresa();
		EmpresaDAO empresaDAO = new EmpresaDAO();
		
		try {
			empresa.setCnpj(cnpj);
			empresa.setNomeDaEmpresa(nomeDaEmpresa);
			empresa.setNomeFantasia(nomeFantasia);
			empresa.setEndereco(endereco);
			empresa.setTelefone(telefone);
			empresaDAO.adiciona(empresa);
			System.out.println("Controle - Cadastra empresa");
			msg = "cadastro realizado com sucesso";

		} catch (Exception e) {
			System.out.println("Controle - ERRO Cadastra empresa");
			msg = e.getMessage();
		}

		return msg;
	}

	public String excluirEmpresa(String cnpj) {
		String msg = "";
		try {
			empresaDAO.exclui(cnpj);
			System.out.println("Controle - Exclui empresa");
			msg = "excluido com sucesso";
		} catch (Exception e) {
			System.out.println("Controle - ERRO Exclui empresa");
			msg = e.getMessage();
		}

		return msg;
	}
	
	public String consultarEmpresa(String cnpj){
		System.out.println("Controle - Consulta empresa");
		return "Modulo em construcao" ;
		
	}
	
}
