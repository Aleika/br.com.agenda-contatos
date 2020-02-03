package br.com.agenda.contatos.contato;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.agenda.contatos.contato.ContatoDAO;
import br.com.agenda.contatos.contato.Contato;

@ManagedBean(name="contatoBean")
@SessionScoped
public class ContatoBean {

	private Contato novoContato = new Contato();
	
	private ArrayList<Contato> listaContato = new ArrayList<Contato>();
	
	public String inserir() {
		ContatoDAO contatoDAO = new ContatoDAO();
		contatoDAO.salvarContato(novoContato);
		
		return "listaContatos.xhtml?faces-redirect=true";
	}
	
	public List<Contato> listar() {
		ContatoDAO contatoDAO = new ContatoDAO();

		List<Contato> contatoLista = contatoDAO.listarContatos();
		List<Contato> lista = new ArrayList<Contato>();
		
		for(int i=0; i< contatoLista.size();i++) {
	    	lista.add(contatoLista.get(i));
	    }
	      
	    return lista;
	}
	
	public String pegarContato(Contato contato) {
		novoContato = contato;
		return "visualizarContato.xhtml?faces-redirect=true";
	}
	
	
	public Contato getNovoContato() {
		return novoContato;
	}
	
	public String remover(Contato contato) {
		ContatoDAO contatoDAO = new ContatoDAO();
		contatoDAO.deletarContato(contato);
		
		return "listaContatos.xhtml?faces-redirect=true";
		
	}
	
	public String editar(Contato contato) {
		ContatoDAO contatoDAO = new ContatoDAO();
		contatoDAO.editarContato(contato, contato.getId());
		
		return "listaContatos.xhtml?faces-redirect=true";

	}
	
	public Contato show() {
		return novoContato;
	}
	
	public String cancelar() {
		return "listaContatos.xhtml?faces-redirect=true";

	}

	public String viewNovoContato() {
		novoContato = new Contato();
		return "novoContato.xhtml?faces-redirect=true";
	}
	
	public void setNovoContato(Contato novoContato) {
		this.novoContato = novoContato;
	}

	public ArrayList<Contato> getListaContato() {
		ContatoDAO contatoDAO = new ContatoDAO();
		
		return (ArrayList<Contato>)contatoDAO.listarContatos();
	}

	public void setListaContato(ArrayList<Contato> listaContato) {
		this.listaContato = listaContato;
	}
}
