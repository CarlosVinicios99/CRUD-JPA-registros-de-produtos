package visao;

import java.util.Scanner;

import modelo.Item;
import modelo.Produto;
import repositorio.DAO;

public class TelaConsole {
	
	private Scanner entrada = new Scanner(System.in);
	private DAO<Produto> daoProduto = new DAO(Produto.class);
	private DAO<Item> daoItem = new DAO(Item.class);
	
	public TelaConsole() {
		exibirMenu();
	}
	
	private void exibirMenu() {
		int opcaoEscolhida = 0;
		
		while(opcaoEscolhida != 7) {	
			System.out.println("(1)Inserir Produto\n(2)Buscar Produto");
			System.out.println("(3)Atualizar Produto\n(4)Excluir Produto");
			System.out.println("(5)Inserir Item\n(6)Excluir Item\nSair");
			
			opcaoEscolhida = Integer.parseInt(entrada.nextLine());
			realizarOpcaoEscolhida(opcaoEscolhida);
			System.out.println();
		}
	}
	
	private void realizarOpcaoEscolhida(int opcao) {
		
		switch(opcao) {
		
			case 1:
				System.out.print("Digite o codigo: ");
				String codigo = entrada.nextLine();
				
				System.out.print("Digite o nome: ");
				String nome = entrada.nextLine();
				
				System.out.print("Digite o preco R$: ");
				Double preco = Double.parseDouble(entrada.nextLine());
				
				Produto novoProduto = new Produto(codigo, nome, preco);
				
				daoProduto.inserir(novoProduto);
				
				break;
				
			case 2:
				System.out.print("Digite o codigo: ");
				codigo = entrada.nextLine();
				//chamar a classe de consulta
				break;
				
			case 3:
				System.out.print("Digite o novo nome: ");
				nome = entrada.nextLine();

				System.out.print("Digite o novo preco R$: ");
				preco = Double.parseDouble(entrada.nextLine());
				
				//chamar funcao de consulta e alterar
				break;
				
			case 4:
				System.out.print("Digite o codigo: ");
				codigo = entrada.nextLine();
				//chamar funcao de consulta e excluir
				break;
				
			case 5:
				System.out.print("Digite o codigo do item: ");
				codigo = entrada.nextLine();
				
				System.out.print("Digite o codigo do produto: ");
				String codigoProduto = entrada.nextLine();
				
				System.out.print("Digite a quantidade: ");
				Integer quantidade = Integer.parseInt(entrada.nextLine());
				
				//chamar a funcao para consultar o produto e inserir item
				
				break;
				
			case 6:
				System.out.print("Digite o codigo do item: ");
				codigo = entrada.nextLine();
				
				//chamar a funcao para consultar e excluir o Item
				
				break;
				
			case 7:
				System.out.println("Saindo");
				break;
				
			default:
				System.out.println("Opcao Invalida\nTente Novamente!");
		
		}	
	}
}
