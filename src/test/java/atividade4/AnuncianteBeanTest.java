/**
 * 
 */
package atividade4;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;


/**
 * @author osboxes
 *
 */
class AnuncianteBeanTest {

	@Test
	void testCreateNewAnunciante() {
		ArrayList<URL> fotos = new ArrayList<URL>();
		try {
			URL fotoUrl = new URL("https://www.example.com/uno.png");	
			fotos.add(fotoUrl);
		} catch(MalformedURLException error) {
			error.printStackTrace();
		}
		
		ProdutoBean uno = new ProdutoBean("1","Fiat Uno 2010", "Fiat Uno 2010 usado", 20000.00, "usado");
		AnuncioBean anuncio = new AnuncioBean(uno, fotos, 0.1);
		
		ArrayList<AnuncioBean> anuncios = new ArrayList<AnuncioBean>();
		anuncios.add(anuncio);
		
		AnuncianteBean anunciante = new AnuncianteBean("Joao", "999.999.999-99", anuncios);
		
		assertEquals(anuncios, anunciante.getAnuncios());
		assertEquals("999.999.999-99", anunciante.getCPF());
		assertEquals("Joao", anunciante.getNome());
	}

	@Test
	void testCreateADefaultAnunciante() {
		ArrayList<AnuncioBean> anuncios = new ArrayList<AnuncioBean>();
		
		AnuncianteBean anunciante = new AnuncianteBean();
		
		assertEquals(anuncios, anunciante.getAnuncios());
		assertEquals("", anunciante.getCPF());
		assertEquals("", anunciante.getNome());
	}
	
	@Test
	void testToSetANewAnunciante() {
		ArrayList<URL> fotos = new ArrayList<URL>();
		try {
			URL fotoUrl = new URL("https://www.example.com/uno.png");	
			fotos.add(fotoUrl);
		} catch(MalformedURLException error) {
			error.printStackTrace();
		}
		
		ProdutoBean uno = new ProdutoBean("1","Fiat Uno 2010", "Fiat Uno 2010 usado", 20000.00, "usado");
		AnuncioBean anuncio = new AnuncioBean(uno, fotos, 0.1);
		
		ArrayList<AnuncioBean> anuncios = new ArrayList<AnuncioBean>();
		anuncios.add(anuncio);
		
		AnuncianteBean anunciante = new AnuncianteBean();
		
		anunciante.setNome("Maria");
		anunciante.setCPF("111.111.111-11");
		anunciante.setAnuncios(anuncios);
		
		assertEquals(anuncios, anunciante.getAnuncios());
		assertEquals("111.111.111-11", anunciante.getCPF());
		assertEquals("Maria", anunciante.getNome());
	}
	
	@Test
	void testAddAnuncioMethod() {
		ArrayList<URL> fotos = new ArrayList<URL>();
		try {
			URL fotoUrl = new URL("https://www.example.com/uno.png");	
			fotos.add(fotoUrl);
		} catch(MalformedURLException error) {
			error.printStackTrace();
		}
		
		ProdutoBean uno = new ProdutoBean("1","Fiat Uno 2010", "Fiat Uno 2010 usado", 20000.00, "usado");
		AnuncioBean anuncio = new AnuncioBean(uno, fotos, 0.1);
		
		ArrayList<AnuncioBean> anuncios = new ArrayList<AnuncioBean>();
		
		AnuncianteBean anunciante = new AnuncianteBean();
		
		anunciante.setNome("Maria");
		anunciante.setCPF("111.111.111-11");
		anunciante.setAnuncios(anuncios);
		
		assertEquals(anuncios.size(), 0);
		
		anunciante.addAnuncio(anuncio);
		
		assertEquals(anuncios, anunciante.getAnuncios());
		assertEquals(anuncios.size(), 1);
	}
	
	@Test
	void testRemoveAnuncioMethod() {
		ArrayList<URL> fotos = new ArrayList<URL>();
		try {
			URL fotoUrl = new URL("https://www.example.com/uno.png");	
			fotos.add(fotoUrl);
		} catch(MalformedURLException error) {
			error.printStackTrace();
		}
		
		ProdutoBean uno = new ProdutoBean("1","Fiat Uno 2010", "Fiat Uno 2010 usado", 20000.00, "usado");
		AnuncioBean anuncio = new AnuncioBean(uno, fotos, 0.1);
		
		ArrayList<AnuncioBean> anuncios = new ArrayList<AnuncioBean>();
		anuncios.add(anuncio);
		
		AnuncianteBean anunciante = new AnuncianteBean();
		
		anunciante.setNome("Maria");
		anunciante.setCPF("111.111.111-11");
		anunciante.setAnuncios(anuncios);

		assertEquals(anuncios.size(), 1);
		
		anunciante.removeAnuncio(0);
		
		assertEquals(anuncios, anunciante.getAnuncios());
		assertEquals(anuncios.size(), 0);
	}
	
	@Test
	void testValorMedioAnunciosMethod() {
		ArrayList<URL> fotosUnoUsado = new ArrayList<URL>();
		ArrayList<URL> fotosUnoNovo = new ArrayList<URL>();
		try {
			URL fotoUnoUrl = new URL("https://www.example.com/uno.png");	
			fotosUnoUsado.add(fotoUnoUrl);
			
			URL fotoUnoNovoUrl = new URL("https://www.example.com/uno_novo.png");	
			fotosUnoNovo.add(fotoUnoNovoUrl);
		} catch(MalformedURLException error) {
			error.printStackTrace();
		}
		
		ProdutoBean uno = new ProdutoBean("1","Fiat Uno 2010", "Fiat Uno 2010 usado", 20000.00, "usado");
		ProdutoBean unoNovo = new ProdutoBean("2","Fiat Uno 2024", "Fiat Uno 2024 novo", 80000.00, "novo");
		AnuncioBean anuncioUnoUsado = new AnuncioBean(uno, fotosUnoUsado, 0.1);
		AnuncioBean anuncioUnoNovo = new AnuncioBean(unoNovo, fotosUnoNovo, 0.25);
		
		ArrayList<AnuncioBean> anuncios = new ArrayList<AnuncioBean>();
		anuncios.add(anuncioUnoUsado);
		anuncios.add(anuncioUnoNovo);
		
		AnuncianteBean anunciante = new AnuncianteBean("Maria", "111.111.111-11", anuncios);
		
		assertEquals(2, anunciante.getAnuncios().size());
		// (18000 + 60000)/2 = 78000/2 = 39000
		assertEquals(39000, anunciante.valorMedioAnuncios());

	}
}
