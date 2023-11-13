CREATE OR REPLACE VIEW vw_report AS 
	select 
		aut.cod_au "codigo_autor", 
		aut.nome "autor", 
		liv.codl "codigo_livro", 
		liv.titulo "titulo_livro", 
		liv.valor "valor_livro", 
		liv.ano_publicacao "ano_livro", 
		ass.cod_as "codigo_assunto", 
		ass.descricao "assunto" 
	from 
		autor aut, 
		livro liv, 
		assunto ass, 
		livro_assunto livass, 
		livro_autor livau 
	where 
		aut.cod_au = livau.autor_cod_au and 
		liv.codl = livau.livro_codl and 
		ass.cod_as = livass.assunto_cod_as and 
		liv.codl = livass.livro_codl;