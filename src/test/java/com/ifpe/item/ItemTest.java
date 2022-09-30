package com.ifpe.item;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.ifpe.ado.item.RepositorioItem;
import com.ifpe.utils.DbUtils;

public class ItemTest {

	private static DbUtils db = new DbUtils();
	
	@Before
	public void init() throws Exception {
		db.abrirConexao();
	}

	
	@Test 
	public void insertTest() {
		
		Item item = new Item("221244", "Miitor");
		RepositorioItem resItem = new RepositorioItem();
		int inserir = resItem.inserir(item);
		assertEquals(1, inserir);
		
	}
	
	@Test
	public void deletar() {
		Item item = new Item("221244", "Miitor");
		RepositorioItem resItem = new RepositorioItem();
		int inserir = resItem.inserir(item);
		int remover = resItem.remover("221244");
		assertEquals(1, remover);
	}
	
	
}
