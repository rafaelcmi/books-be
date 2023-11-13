package br.com.spassu.books;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.spassu.books.models.Livro;
import br.com.spassu.books.repositories.LivroRepository;
import br.com.spassu.books.services.LivroService;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
class BooksApplicationTests {	
	
	@InjectMocks
	private LivroService livroService;
	
	@Mock
	private LivroRepository livroRepository;
	
	@Test
	public void testListarLivrosEmpty() {
		// SIMULA O RETORNO ESPERADO
		when(livroRepository.findAll()).thenReturn(Collections.emptyList());
		
		// OBTEM OS LIVROS PELO SERVICE 
		List<Livro> livros = livroService.list();
		
		// GARANTE QUE NAO EXISTEM LIVROS
		assertTrue(livros.isEmpty());
		assertEquals(livros.size(), 0);
	}
	
	@Test
	public void testListarLivrosExistentes() {
		Integer livroId1 = 1;
		Livro livroMock1 = new Livro();
		livroMock1.setCodigo(livroId1);
		livroMock1.setTitulo("Spassu1");
		
		Integer livroId2 = 2;
		Livro livroMock2 = new Livro();
		livroMock2.setCodigo(livroId2);
		livroMock2.setTitulo("Spassu2");		
		
		List<Livro> livrosRepo = new ArrayList<Livro>();
		livrosRepo.add(livroMock1);
		livrosRepo.add(livroMock2);
		
		// SIMULA O RETORNO ESPERADO
		when(livroRepository.findAll()).thenReturn(livrosRepo);
		
		// OBTEM OS LIVROS PELO SERVICE		
		List<Livro> livros = this.livroService.list();
		
		// GARANTE QUE A LISTA NAO ESTA VAZIA
		assertTrue(!livros.isEmpty());
		
		// GARANTE QUE A QUANTIDADE RETORNADA EQUIVALE
        assertEquals(livros.size(), 2);
        
        // GARANTE OS LIVROS NA LISTA
		assertTrue(livros.contains(livroMock1));
		assertTrue(livros.contains(livroMock2));
	}
	
	@Test
	public void obterLivroById() {
		Integer livroId = 1;
		Livro livroMock = new Livro();
		livroMock.setCodigo(livroId);
		livroMock.setTitulo("Spassu");
		
		// SIMULA O RETORNO ESPERADO		
		when(livroRepository.findById(livroId)).thenReturn(Optional.of(livroMock));
		
		// OBTEM O LIVRO POR ID
		Livro livro = livroService.getById(livroId);

		// GARANTE QUE O RETORNO REPRESENTA O LIVRO DESEJADO
        assertNotNull(livro);
        assertEquals(livroMock.getCodigo(), livro.getCodigo());
	}
	
	@Test
	public void saveLivro() {
		Livro livroMock = new Livro();
		livroMock.setTitulo("Java TOP");
		livroMock.setEdicao(1);
		livroMock.setValor(new BigDecimal(10.5));
		livroMock.setEditora("Spassu");
		
		List<Livro> livros = new ArrayList<Livro>();
		livros.add(livroMock);
		
		// SIMULA O RETORNO ESPERADO
		when(livroRepository.save(livroMock)).thenReturn(livroMock);
		
		// EFETUA A CHAMADA AO METODO DO SERVICO
		Livro livro = this.livroService.save(livroMock);
		
		// GARANTE O LIVRO SALVO
		assertEquals(livro, livroMock);
	}
	
	
	@Test
	public void saveLivro2() {
		Integer livroId = 1;
		String titulo = "Spassu Antes";
		String titulo2 = "Spassu Depois";
		
		Livro livroMock = new Livro();
		livroMock.setCodigo(livroId);
		livroMock.setTitulo(titulo);
		livroMock.setEdicao(1);
		livroMock.setValor(new BigDecimal(10.5));
		livroMock.setEditora("Spassu");
		
		// SIMULA A EXISTENCIA DO LIVRO
		when(livroRepository.findById(livroId)).thenReturn(Optional.of(livroMock));

		// EFETUA A CHAMADA AO METODO DO SERVICO
		Livro livro1 = this.livroService.getById(livroId);
		
		// GARANTE QUE O LIVRO MENCIONADO FOI RETORNADO
		assertEquals(livroId, livro1.getCodigo());
		assertNotEquals(titulo2, livro1.getTitulo());
		assertEquals(titulo, livro1.getTitulo());

		// EFETUA A ATUALIZACAO DA COLUNA DESEJADA	
		livro1.setTitulo(titulo2);

		// SIMULA A GRAVACAO
		when(livroRepository.save(livro1)).thenReturn(livro1);
		
		// EFETUA A CHAMADA AO METODO DO SERVICO
		Livro livro2 = this.livroService.save(livro1);
		
		// GARANTE QUE O LIVRO MENCIONADO FOI ALTERADO
		assertEquals(livro1.getCodigo(), livro2.getCodigo());
		assertNotEquals(titulo, livro2.getTitulo());
		assertEquals(titulo2, livro2.getTitulo());
	}
}
