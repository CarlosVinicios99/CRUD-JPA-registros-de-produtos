package repositorio;

import java.util.List;

import javax.persistence.Query;

import modelo.Produto;

public class Consultas {
	
	
	private Consultas () {
		
	}
	
	public static Produto buscarProduto(String codigo) {
		String sql = 
			"""
				SELECT * FROM produtos WHERE codigo = ?
			""";
		
		DAO<Produto> daoItem = new DAO(Produto.class);
		Query query = daoItem.criarConsulta(codigo, sql);
		
		query.setParameter(1, codigo);
		List<Produto> produtos = query.getResultList();
		
		if(produtos == null) {
			return null;
		}
		
		else {
			return produtos.get(0);
		}
	}
	
	
	
	
	
}
