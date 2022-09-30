package com.ifpe.emprestimo;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.ifpe.ado.emprestimo.RepositorioEmprestimo;
import com.ifpe.ado.item.RepositorioItem;
import com.ifpe.ado.professor.RepositorioProfessor;
import com.ifpe.excecoes.SiapeInvalidoException;
import com.ifpe.excecoes.TelefoneInvalidoException;
import com.ifpe.item.Item;
import com.ifpe.professor.Professor;
import com.ifpe.utils.DbUtils;

public class EmprestimoTest {

private static DbUtils db = new DbUtils();
	
	@Before
	public void init() throws Exception {
		db.abrirConexao();
	}
	
	@Test
	public void inserirTest() throws TelefoneInvalidoException, SiapeInvalidoException {
		
		Professor professor = new Professor("Mikael", "87996771179", "77777");
        RepositorioProfessor repProf = new RepositorioProfessor();
        repProf.inserir(professor);
        Item novoItem = new Item("1","teclado");
		RepositorioItem repItem = new RepositorioItem();
		repItem.inserir(novoItem);
		Emprestimo novoEmprestimo = new Emprestimo("77777", "1", "09/12/2021");
		RepositorioEmprestimo repEmprest = new RepositorioEmprestimo();
		int emprestimo = repEmprest.efetuarEmprestimo(novoEmprestimo);
		assertEquals(1, emprestimo);
		
	}
	
	@Test
	public void removerItem() throws TelefoneInvalidoException, SiapeInvalidoException {
		
		Professor professor = new Professor("Mikael", "87996771179", "77777");
        RepositorioProfessor repProf = new RepositorioProfessor();
        repProf.inserir(professor);
        Item novoItem = new Item("1","teclado");
		RepositorioItem repItem = new RepositorioItem();
		repItem.inserir(novoItem);
		Emprestimo novoEmprestimo = new Emprestimo("77777", "1", "09/12/2021");
		RepositorioEmprestimo repEmprest = new RepositorioEmprestimo();
		repEmprest.efetuarEmprestimo(novoEmprestimo);
		int remover = repEmprest.removerEmprestimo(77777);
		assertEquals(1, remover);
		
	}

}
