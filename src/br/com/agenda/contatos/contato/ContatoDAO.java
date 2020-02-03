package br.com.agenda.contatos.contato;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.com.agenda.contatos.contato.Contato;

/**
 * Classe utilizada para fazer realizar as operações de banco de dados sobre a entity Contato.
 */
public class ContatoDAO {
  /**
   * Método utilizado para obter o entity manager.
   * @return
   */
	EntityManagerFactory factory = null;
    EntityManager entityManager = null;
    
    public ContatoDAO() {
    	
        try {
	        factory = Persistence.createEntityManagerFactory("persistence-name");
        	entityManager = factory.createEntityManager();

        } catch (Exception e) {
        	System.out.println("Ocorreu um erro! " + e.getMessage());
        }
    }
    
    public void salvarContato(Contato contato) {
    	 try {
             entityManager.getTransaction().begin();
             Query q = entityManager.createNativeQuery("delete contato from contato where id ="+contato.getId());
             entityManager.merge(contato);
         	 entityManager.getTransaction().commit();
         	  
          } catch (Exception ex) {
             ex.printStackTrace();
             entityManager.getTransaction().rollback();

          } finally {
        	  factory.close();
          }    	 
    }
    
    public void deletarContato(Contato contato) {
    	
    	 try {
             entityManager.getTransaction().begin();
             Query q = entityManager.createNativeQuery("delete contato from contato where id ="+contato.getId());
         	 q.executeUpdate();
             entityManager.getTransaction().commit();
          } catch (Exception ex) {
             ex.printStackTrace();
             entityManager.getTransaction().rollback();
          } finally {
        	  factory.close();
          }
    }
    
    public List<Contato> listarContatos(){	
    	 try {
    		 entityManager.getTransaction().begin();
	    	 Query q = entityManager.createQuery("SELECT contato FROM Contato contato ORDER BY nome");
	    	 List<Contato> lista = q.getResultList();
	    	 entityManager.getTransaction().commit();
	    	 
	     	return lista;

          } catch (Exception ex) {
             ex.printStackTrace();
             entityManager.getTransaction().rollback();
          } finally {
        	  factory.close();
          }
    	return null;
    }
    
    public void editarContato(Contato contato, Integer id) {
    	
   	 try {
   		entityManager.getTransaction().begin();
    	Query q = entityManager.createQuery("UPDATE Contato SET nome = '"+contato.getNome().toString()+"', email = '"+contato.getEmail()+
    			"', numero = '"+contato.getNumero()+"' WHERE id = " + id);
    	q.executeUpdate();
    	entityManager.getTransaction().commit();
    	
      } catch (Exception ex) {
         ex.printStackTrace();
         entityManager.getTransaction().rollback();
      } finally {
    	  factory.close();
      }

    }
}