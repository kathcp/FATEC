package br.sceweb.teste;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import br.sceweb.modelo.Controle;

public class UC01CadastrarEmpresa {
	
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
		System.out.println("UC01 - Set Up");
		controle = new Controle();
		//89.424.232/0001-80
		controle.cadastrarEmpresa(cnpj,nomeDaEmpresa,nomeFantasia,endereco,telefone);
		
	}
	
	/**
	 * obj - verificar o comportamento do sistema na inclusão de uma empresa com sucesso
	 */
	@Test
	public void CT01UC01FBCadastra_empresa_com_sucesso() {
		System.out.println("CT01UC01FB");
		controle.excluirEmpresa(cnpj);
		controle.cadastrarEmpresa(cnpj, nomeDaEmpresa, nomeFantasia, endereco, telefone);
	}
	/**
	 * obj - verificar o comportamento do sistema no cadastro com cnpj ja cadastrado
	 */
	@Test(expected = RuntimeException.class)
	public void CT02UC01A2Cadastra_empresa_cnpj_ja_cadastrado() {
		System.out.println("CT02UC01A2");
		try{
		controle.cadastrarEmpresa(cnpj, nomeDaEmpresa, nomeFantasia, endereco, telefone);
		controle.excluirEmpresa(cnpj);
		}catch (Exception e){
			assertEquals("CNPJ já cadastrado", e.getMessage());
			System.out.println("CT03UC01A2 - Exception");
		}
	
	}
	/**
	 * obj - verificar o comportamento do sistema no cadastro com cnpj invalido
	 */
	@Test
	public void CT03UC01A3Cadastra_empresa_cnpj_invalido() {
		System.out.println("CT03UC01A3");
		try {
			controle.cadastrarEmpresa("00000000000000", nomeDaEmpresa, nomeFantasia, endereco, telefone);
			fail("deveria disparar uma exception");
		} catch (Exception e) {
			assertEquals("CNPJ inválido!",e.getMessage());
			System.out.println("CT03UC01A3 - Exception");
		}
	}
	/**
	 * obj - verificar o comportamento do sistema no cadastro de uma empresa com dados invalidos
	 */
	@Test
	public void CT04UC01A4Cadastra_empresa_com_dados_invalidos() {
		System.out.println("CT04UC01A4");
		try {
			controle.cadastrarEmpresa("mklfeds", "gfdsgtr" , "hfesh", "ghsfdg", "gkmvlfeçd");
			fail("deveria disparar uma exception");
		} catch (Exception e) {
			assertEquals("dados da empresa são inválidos!",e.getMessage());
			System.out.println("CT03UC01A4 - Exception");
		}
	}
	/**
	 * obj - exclui o cnpj ao finalizar o teste
	 * @throws Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("UC01 - Tear Down");
		controle.excluirEmpresa(cnpj);
	}
}

