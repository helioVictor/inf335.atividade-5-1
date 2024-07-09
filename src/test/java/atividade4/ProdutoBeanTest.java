package atividade4;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class ProdutoBeanTest {
	@Test
	void testCreateNewProdutoByDefault() {
		ProdutoBean produtoNovo = new ProdutoBean();
		
		assertEquals("", produtoNovo.getCodigo());
		assertEquals("", produtoNovo.getNome());
		assertEquals("", produtoNovo.getDescricao());
		assertEquals(0, produtoNovo.getValor());
		assertEquals("", produtoNovo.getEstado());
		assertEquals(1, ProdutoBean.getSerialversionuid());
	}
	
	@Test
	void testGetProduto() {
		ProdutoBean uno = new ProdutoBean("1","Fiat Uno 2010", "Fiat Uno 2010 usado", 20000.00, "usado");
		
		assertEquals("1", uno.getCodigo());
		assertEquals("Fiat Uno 2010", uno.getNome());
		assertEquals("Fiat Uno 2010 usado", uno.getDescricao());
		assertEquals(20000.00, uno.getValor());
		assertEquals("usado", uno.getEstado());
	}
	
	@Test
	void testSetProduto() {
		ProdutoBean classic = new ProdutoBean();
		
		classic.setCodigo("1");
		classic.setNome("Chevrolet Classic");
		classic.setDescricao("Chevrolet Classic 2009 usado");
		classic.setValor(15000.00);
		classic.setEstado("usado");
		
		assertEquals("1", classic.getCodigo());
		assertEquals("Chevrolet Classic", classic.getNome());
		assertEquals("Chevrolet Classic 2009 usado", classic.getDescricao());
		assertEquals(15000.00, classic.getValor());
		assertEquals("usado", classic.getEstado());
	}
	
	@Test
	void testCompareToMethod() {
		ProdutoBean unoUsado = new ProdutoBean("1","Fiat Uno 2010", "Fiat Uno 2010 usado", 20000.00, "usado");
		ProdutoBean unoNovo = new ProdutoBean("2","Fiat Uno 2024", "Fiat Uno 2024 novo", 80000.00, "novo");
		
		assertEquals(0, unoUsado.compareTo(unoUsado));
		assertEquals(1, unoNovo.compareTo(unoUsado));
		assertEquals(-1, unoUsado.compareTo(unoNovo));
	}
}
