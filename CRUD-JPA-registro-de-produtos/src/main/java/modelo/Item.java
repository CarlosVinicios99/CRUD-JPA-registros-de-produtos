package modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Item {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Produto produto;
	
	private Integer quantidade;
	
	
	public Item() {
		
	}
	
	public Item(Produto produto, Integer quantidade) {
		this.produto = produto;
		this.quantidade = quantidade;
	}

	public Long getId() {
		return id;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	
	
	public double obterValorTotal() {
		return produto.getPreco() * quantidade;
	}
	
	@Override
	public String toString() {
		return "\nID: " + id + "\nProduto: " + produto.getNome() + 
			"\nPreco: R$" + String.format(".2f", produto.getPreco()) + 
			"\nQuantidade: " + quantidade + "\nValor Total Item: R$" + 
			String.format(".2f", obterValorTotal());
	}
	
}