package repositorio;

import java.util.List;

import javax.persistence.Query;

import modelo.Item;
import modelo.Produto;

public class Consultas {
	
	
	private Consultas () {
		
	}
	
	public static Produto buscarProduto(String codigo) {
		String sql = 
			"""
				SELECT * FROM produtos WHERE codigo = ?
			""";
		
		DAO<Produto> daoProduto = new DAO(Produto.class);
		Query query = daoProduto.criarConsulta(codigo, sql);
		
		query.setParameter(1, codigo);
		List<Produto> produtos = query.getResultList();
		
		if(produtos.size() > 0) {
			return produtos.get(0);
		}
		
		else {
			return null;
		}
	}
	
	
	public static Item buscarItem(String codigo) {
		String sql = 
			"""
				SELECT * FROM itens WHERE codigo = ?
			""";
		
		DAO<Item> daoItem = new DAO(Item.class);
		Query query = daoItem.criarConsulta(codigo, sql);
		
		query.setParameter(1, codigo);
		List<Item> itens = query.getResultList();
		
		if(itens == null) {
			return null;
		}
		
		else {
			return itens.get(0);
		}
	}
	
	
	
}
