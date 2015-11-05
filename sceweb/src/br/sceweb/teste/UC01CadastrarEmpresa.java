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
		controle = new Controle();
		//89.424.232/0001-80
		controle.cadastrarEmpresa(cnpj,nomeDaEmpresa,nomeFantasia,endereco,telefone);
	}
	
	/**
	 * obj - verificar o comportamento do sistema na inclusão de uma empresa com sucesso
	 */
	@Test
	public void CT01UC01FBCadastra_empresa_com_sucesso() {
		
		controle.excluirEmpresa(cnpj);
		controle.cadastrarEmpresa(cnpj, nomeDaEmpresa, nomeFantasia, endereco, telefone);
		controle.excluirEmpresa(cnpj);
	}
	/**
	 * obj - verificar o comportamento do sistema no cadastro com cnpj ja cadastrado
	 */
	@Test(expected = RuntimeException.class)
	public void CT02UC01A2Cadastra_empresa_cnpj_ja_cadastrado() {
		controle.cadastrarEmpresa(cnpj, nomeDaEmpresa, nomeFantasia, endereco, telefone);
		controle.cadastrarEmpresa(cnpj, nomeDaEmpresa, nomeFantasia, endereco, telefone);
		controle.excluirEmpresa(cnpj);
	}
	/**
	 * obj - verificar o comportamento do sistema no cadastro com cnpj invalido
	 */
	@Test
	public void CT03UC01A3Cadastra_empresa_cnpj_invalido() {
		try {
			controle.cadastrarEmpresa("00000000000000", nomeDaEmpresa, nomeFantasia, endereco, telefone);
			fail("deveria disparar uma exception");
		} catch (Exception e) {
			assertEquals("CNPJ inválido!",e.getMessage());
		}
	}
	/**
	 * obj - verificar o comportamento do sistema no cadastro de uma empresa com dados invalidos
	 */
	@Test
	public void CT04UC01A4Cadastra_empresa_com_dados_invalidos() {
		
		try {
			controle.cadastrarEmpresa("mklfeds", "gfdsgtr" , "hfesh", "ghsfdg", "gkmvlfeçd");
			fail("deveria disparar uma exception");
		} catch (Exception e) {
			assertEquals("dados da empresa são inválidos!",e.getMessage());
		}
	}
	/**
	 * obj - exclui o cnpj ao finalizar o teste
	 * @throws Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		controle.excluirEmpresa(cnpj);
	}
}

