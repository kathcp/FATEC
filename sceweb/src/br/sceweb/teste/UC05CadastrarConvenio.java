package br.sceweb.teste;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import br.sceweb.modelo.Convenio;
import br.sceweb.modelo.ConvenioDAO;

public class UC05CadastrarConvenio {
	
	static Convenio convenio;
	static ConvenioDAO convenioDAO;
	static String dataInicio;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("UC05 - Set Up");
		convenio = new Convenio();
		convenioDAO = new ConvenioDAO();
		dataInicio = "07/11/2015";
	}
	
	@Test
	public void CT01UC05CadastrarConvenio_com_sucesso_data_valida() {
		System.out.println("CT01UC05FB");
		dataInicio = "29/10/2015";
		assertTrue(convenio.validaData(dataInicio));
	}
	
	@Test
	public void CT02UC05CadastrarConvenio_com_data_invalida(){
		System.out.println("CT02UC05");
		dataInicio = "42/52/0514";
		assertFalse(convenio.validaData(dataInicio));
		
	}
	
	@Test
	public void CT03UC05CadastrarConvenio_com_sucesso_data_valida(){
		System.out.println("CT03UC05");
		dataInicio = "07/11/2015";
		convenio.setDataInicio(dataInicio);
		assertTrue(dataInicio.equals(convenio.getDataInicio()));
	}
	
	@Test
	public void CT04UC05CadastrarConvenio_com_data_invalida(){
		System.out.println("CT04UC05");
		convenio.setDataInicio("510/25/2015");
	}
	
	@Test
	public void CT05UC05CadastrarConvenio_com_sucesso(){
		System.out.println("CT05UC05");
		convenioDAO.adiciona(convenio);
		assertTrue(convenio.equals(convenioDAO.adiciona(convenio)));
		convenioDAO.exclui(convenio.getCNPJ());
		
	}
	
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	
	}
}
