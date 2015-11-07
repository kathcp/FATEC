package br.sceweb.teste;


import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import br.sceweb.modelo.Controle;

public class UC02ConsultarEmpresa {

	static Controle controle;
	static String cnpj = "89424232000180";
	static String nomeDaEmpresa = "empresa x";
	static String nomeFantasia = "empresa x";
	static String endereco = "rua taquari" ;
	static String telefone = "2222";
	
	/**
	* cria os objetos que realizam o caso de uso cadastrar empresa
	* @throws Exception
	*/
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("UC02 - Set up");
		controle = new Controle();
		//89.424.232/0001-80
		controle.cadastrarEmpresa(cnpj,nomeDaEmpresa,nomeFantasia,endereco,telefone);
	}

	@Test
	public void CT01UC02FBConsulta_empresa_com_sucesso(){
		System.out.println("CT01UC02FB");
		controle.consultarEmpresa(cnpj);
	}
	
	@Test
	public void CT02UCA1Consulta_empresa_sem_sucesso(){
		System.out.println("CT02UC02A1");
		controle.excluirEmpresa(cnpj);
		controle.consultarEmpresa(cnpj);	
	}
	

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("UC02 - Tear Down");
		controle.excluirEmpresa(cnpj);
	}

}
