package app.business;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import app.dao.AlunoDAO;
import app.entity.Aluno;
import app.entity.Sorteio;
import app.entity.SorteioAluno;

/**
 * Classe que representa a camada de negócios de AlunoBusiness
 * 
 * @generated
 **/
@Service("AlunoBusiness")
public class AlunoBusiness {

	/**
	 * Instância da classe AlunoDAO que faz o acesso ao banco de dados
	 * 
	 * @generated
	 */
	@Autowired
	@Qualifier("AlunoDAO")
	protected AlunoDAO repository;

	@Autowired
	@Qualifier("SorteioBusiness")
	private SorteioBusiness sorteioBusiness;

	// CRUD

	/**
	 * Serviço exposto para novo registro de acordo com a entidade fornecida
	 * 
	 * @generated
	 */
	public Aluno post(final Aluno entity) throws Exception {
		// begin-user-code  
		// end-user-code  
		repository.save(entity);
		// begin-user-code  
		// end-user-code  
		return entity;
	}

	/**
	 * Serviço exposto para recuperar a entidade de acordo com o id fornecido
	 * 
	 * @generated
	 */
	public Aluno get(java.lang.String id) throws Exception {
		// begin-user-code  
		// end-user-code        
		Aluno result = repository.findOne(id);
		// begin-user-code  
		// end-user-code        
		return result;
	}

	/**
	 * Serviço exposto para salvar alterações de acordo com a entidade fornecida
	 * 
	 * @generated
	 */
	public Aluno put(final Aluno entity) throws Exception {
		// begin-user-code  
		// end-user-code
		repository.saveAndFlush(entity);
		// begin-user-code  
		// end-user-code        
		return entity;
	}

	/**
	 * Serviço exposto para remover a entidade de acordo com o id fornecido
	 * 
	 * @generated
	 */
	public void delete(java.lang.String id) throws Exception {
		// begin-user-code  
		// end-user-code        
		repository.delete(id);
		// begin-user-code  
		// end-user-code        
	}

	// CRUD

	/**
	 * Lista com paginação de acordo com a NamedQuery
	 * 
	 * @generated
	 */
	public Page<Aluno> list(Pageable pageable) {
		// begin-user-code  
		// end-user-code        
		Page<Aluno> result = repository.list(pageable);
		// begin-user-code  
		// end-user-code        
		return result;
	}

	/**
	 * Lista com paginação de acordo com a NamedQuery
	 * 
	 * @generated
	 */
	public Page<Aluno> listByNaoPremiados(Pageable pageable) {
		// begin-user-code  
		// end-user-code        
		Page<Aluno> result = repository.listByNaoPremiados(pageable);
		// begin-user-code  
		// end-user-code        
		return result;
	}

	/**
	 * @generated modifiable
	 * OneToMany Relation
	 */
	public Page<Sorteio> findSorteio(java.lang.String id, Pageable pageable) {
		// begin-user-code
		// end-user-code  
		Page<Sorteio> result = repository.findSorteio(id, pageable);
		// begin-user-code  
		// end-user-code        
		return result;
	}

	/**
	 * @generated modifiable
	 * OneToMany Relation
	 */
	public Page<SorteioAluno> findSorteioAluno(java.lang.String id, Pageable pageable) {
		// begin-user-code
		// end-user-code  
		Page<SorteioAluno> result = repository.findSorteioAluno(id, pageable);
		// begin-user-code  
		// end-user-code        
		return result;
	}

	/**
	 * @generated modifiable
	 * ManyToMany Relation
	 */
	public Page<Sorteio> listSorteio_2(java.lang.String id, Pageable pageable) {
		// begin-user-code
		// end-user-code  
		Page<Sorteio> result = repository.listSorteio_2(id, pageable);
		// begin-user-code
		// end-user-code
		return result;
	}

	/**
	 * @generated modifiable
	 * ManyToMany Relation
	 */
	public int deleteSorteio_2(java.lang.String instanceId, java.lang.String relationId) {
		// begin-user-code
		// end-user-code  
		int result = repository.deleteSorteio_2(instanceId, relationId);
		// begin-user-code
		// end-user-code  
		return result;
	}

	public Aluno sorteio() {
		List<Aluno> alunos = this.list(new PageRequest(0, 100)).getContent();
		List<Sorteio> sorteios = sorteioBusiness.list(new PageRequest(0, 100)).getContent();
    List<Aluno> sorteados = new ArrayList<Aluno>();
    List<Aluno> candidatos = new ArrayList<Aluno>();
		
		for(Sorteio s : sorteios){
		  if(s.getAluno() != null)
		    sorteados.add(s.getAluno());
		}
		
		for(Aluno a: alunos){
		  boolean sorteado = false;
		  for(Aluno s: sorteados){
  		  if(a.getId().equals(s.getId())){
  		    sorteado = true;
  		  }
		  }
		  if(!sorteado)
		    candidatos.add(a);
		}
		
		Aluno premiado = null;
		int index = (new Random()).nextInt(candidatos.size());
		premiado = candidatos.get(index);

		return premiado;
	}
}