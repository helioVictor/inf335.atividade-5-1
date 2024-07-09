package atividade4;

import java.net.MalformedURLException;

import java.net.URL;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


class AnuncioBeanTest {

	@Test
	void testCreateNewAnuncio() {
		ArrayList<URL> fotos = new ArrayList<URL>();
		try {
			URL fotoUrl = new URL("https://www.example.com/uno.png");	
			fotos.add(fotoUrl);
		} catch(MalformedURLException error) {
			error.printStackTrace();
		}
		
		ProdutoBean uno = new ProdutoBean("1","Fiat Uno 2010", "Fiat Uno 2010 usado", 20000.00, "usado");
		AnuncioBean anuncio = new AnuncioBean(uno, fotos, 0.1);
		
		assertEquals(0.1, anuncio.getDesconto());
		assertEquals(fotos, anuncio.getFotosUrl());
		assertEquals(uno, anuncio.getProduto());
		assertEquals(18000, anuncio.getValor());
		assertEquals(1, AnuncioBean.getSerialversionuid());
	}
	
	@Test
	void testSetAnuncio() {
		ArrayList<URL> fotos = new ArrayList<URL>();
		try {
			URL fotoUrl = new URL("https://www.example.com/uno.png");	
			fotos.add(fotoUrl);
		} catch(MalformedURLException error) {
			error.printStackTrace();
		}
		
		ProdutoBean uno = new ProdutoBean("1","Fiat Uno 2010", "Fiat Uno 2010 usado", 20000.00, "usado");
		AnuncioBean anuncio = new AnuncioBean();
		
		anuncio.setProduto(uno);
		anuncio.setFotosUrl(fotos);
		anuncio.setDesconto(0.1);
		
		assertEquals(0.1, anuncio.getDesconto());
		assertEquals(fotos, anuncio.getFotosUrl());
		assertEquals(uno, anuncio.getProduto());
		assertEquals(18000, anuncio.getValor());
	}
	

}
