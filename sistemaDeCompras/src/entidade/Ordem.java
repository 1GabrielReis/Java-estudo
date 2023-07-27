package entidade;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import entidade.enums.Status;

public class Ordem {
	
	private SimpleDateFormat formato= new SimpleDateFormat("dd/MM/yyyy HH:mm");
	
	private Date moment;
	private Status statusPedido;
	
	private Clientes cliente;
	private List<Item> itemCompra= new ArrayList<Item>();
	
	
	// Construtores
	public Ordem() {
		
	}

	public Ordem(Date moment, Status statusPedido, Clientes cliente) {
		this.moment = moment;
		this.statusPedido = statusPedido;
		this.cliente = cliente;
	}

	
	// get e set 
	public Date getMomento() {
		return moment;
	}

	public void setMomento(Date momento) {
		this.moment = momento;
	}

	public Status getStatusPedido() {
		return statusPedido;
	}

	public void setStatusPedido(Status statusPedido) {
		this.statusPedido = statusPedido;
	}

	public Clientes getCliente() {
		return cliente;
	}

	public void setCliente(Clientes cliente) {
		this.cliente = cliente;
	}

	public List<Item> getItemCompra() {
		return itemCompra;
	}
	
	//metodos 
	public void addItem(Item itemCompras) {
		itemCompra.add(itemCompras);
	}
	public void removerItem(Item  itemCompras) {
		 itemCompra.remove( itemCompras);
	}

	public Double total() {
		Double total= 0.00;
		for (Item c: itemCompra) {
			total+= c.total(); 
		}
		return total;
	}
	
	public String toString() {
		double valorTotal= 0;
		StringBuilder textoFormato= new StringBuilder();
		textoFormato.append(" Momento do pedido: ");
		textoFormato.append(formato.format(moment)+"\n ");
		textoFormato.append("Status do pedido: ");
		textoFormato.append(getStatusPedido()+" \n");
		textoFormato.append(cliente.toString()+"\n");
		textoFormato.append("itens \n");
		for(Item c: itemCompra) {
			textoFormato.append(c.toString()+"\n");
			valorTotal+= c.total(); 
		}
		textoFormato.append("Preço total: ");
		textoFormato.append(String.format("%.2f",valorTotal));
		return textoFormato.toString();
		
	}
	
	
	
	 
	
	
	
}
