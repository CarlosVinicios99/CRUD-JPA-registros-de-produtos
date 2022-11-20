package visao;

import java.util.Scanner;

import modelo.Item;
import modelo.Produto;
import repositorio.Consultas;
import repositorio.DAO;

public class TelaConsole {
	
	private Scanner entrada = new Scanner(System.in);
	@SuppressWarnings({"unchecked", "rawtypes"})
	private DAO<Produto> daoProduto = new DAO(Produto.class);
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private DAO<Item> daoItem = new DAO(Item.class);
	
	public TelaConsole() {
		exibirMenu();
	}
	
	private void exibirMenu() {
		int opcaoEscolhida = 0;
		
		while(opcaoEscolhida != 7) {	
			System.out.println("(1)Inserir Produto\n(2)Buscar Produto");
			System.out.println("(3)Atualizar Produto\n(4)Excluir Produto");
			System.out.println("(5)Inserir Item\n(6)Excluir Item\n(7)Sair");
			
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
				Produto produto = Consultas.buscarProduto(codigo);
				
				if(produto != null) {
					System.out.println(produto);
				}
				
				else {
					System.out.println("Produto Nao cadastrado!");
				}
				
				break;
				
			case 3:		
				System.out.print("Digite o codigo: ");
				codigo = entrada.nextLine();
				
				produto = Consultas.buscarProduto(codigo);
				
				if(produto != null) {
					System.out.print("Digite o novo nome: ");
					nome = entrada.nextLine();

					System.out.print("Digite o novo preco R$: ");
					preco = Double.parseDouble(entrada.nextLine());
					
					produto.setNome(nome);		
					produto.setPreco(preco);
					
					daoProduto.alterar(produto);
				}
				
				else {
					System.out.println("Produto Nao cadastrado!");
				}
			
				break;
				
			case 4:
				System.out.print("Digite o codigo: ");
				codigo = entrada.nextLine();
				
				produto = Consultas.buscarProduto(codigo);
				daoProduto.limparContextoTransacional(produto);
				
				if(produto != null) {
					daoProduto.remover(produto);
				}
				else {
					System.out.println("Produto Nao cadastrado!");
				}
				
				break;
				
			case 5:
				System.out.print("Digite o codigo do item: ");
				codigo = entrada.nextLine();
				
				System.out.print("Digite o codigo do produto: ");
				String codigoProduto = entrada.nextLine();
				
				System.out.print("Digite a quantidade: ");
				Integer quantidade = Integer.parseInt(entrada.nextLine());
				
				produto = Consultas.buscarProduto(codigoProduto);
				
				if(produto != null) {
					Item item = new Item(produto, quantidade, codigo);
					daoItem.inserir(item);
				}
				
				else {
					System.out.println("Produto nao cadastrado!");
				}
				
				break;
				
			case 6:
				System.out.print("Digite o codigo do item: ");
				codigo = entrada.nextLine();
				
				Item item = Consultas.buscarItem(codigo);
				daoItem.limparContextoTransacional(item);
				
				if(item != null) {
					daoItem.remover(item);
				}
				else {
					System.out.println("Produto Nao cadastrado!");
				}
					
				break;
				
			case 7:
				System.out.println("Saindo");
				break;
				
			default:
				System.out.println("Opcao Invalida\nTente Novamente!");
		
		}	
	}
}
 