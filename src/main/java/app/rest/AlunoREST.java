package app.rest;

import org.springframework.data.domain.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.annotation.*;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.PagedResources;

import org.springframework.http.*;
import org.springframework.beans.factory.annotation.*;

import java.util.*;

import app.entity.*;
import app.business.*;



/**
 * Controller para expor serviços REST de Aluno
 * 
 * @author Robson Ataide
 * @version 1.0
 * @generated
 **/
@RestController
@RequestMapping(value = "/api/rest/Aluno")
public class AlunoREST {

    /**
     * Classe de negócio para manipulação de dados
     * 
     * @generated
     */
    @Autowired
    @Qualifier("AlunoBusiness")
    private AlunoBusiness alunoBusiness;

    /**
     * @generated
     */
      @Autowired
      @Qualifier("SorteioBusiness")
      private SorteioBusiness sorteioBusiness;
    /**
     * @generated
     */
      @Autowired
      @Qualifier("SorteioAlunoBusiness")
      private SorteioAlunoBusiness sorteioAlunoBusiness;

    /**
     * Serviço exposto para novo registro de acordo com a entidade fornecida
     * 
     * @generated
     */
    @RequestMapping(method = RequestMethod.POST)
    public Aluno post(@Validated @RequestBody final Aluno entity) throws Exception {
        return alunoBusiness.post(entity);
    }

    /**
     * Serviço exposto para salvar alterações de acordo com a entidade fornecida
     * 
     * @generated
     */
    @RequestMapping(method = RequestMethod.PUT)
    public Aluno put(@Validated @RequestBody final Aluno entity) throws Exception {
        return alunoBusiness.put(entity);
    }

    /**
     * Serviço exposto para salvar alterações de acordo com a entidade e id fornecidos
     * 
     * @generated
     */
    @RequestMapping(method = RequestMethod.PUT, value = "/{id}")
    public Aluno put(@PathVariable("id") final java.lang.String id, @Validated @RequestBody final Aluno entity) throws Exception {
        return alunoBusiness.put(entity);
    }

    /**
     * Serviço exposto para remover a entidade de acordo com o id fornecido
     * 
     * @generated
     */
    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public void delete(@PathVariable("id") java.lang.String id) throws Exception {
        alunoBusiness.delete(id);
    }


  /**
   * NamedQuery list
   * @generated
   */
  @RequestMapping(method = RequestMethod.GET
  )    
  public  HttpEntity<PagedResources<Aluno>> listParams (Pageable pageable, PagedResourcesAssembler assembler){
      return new ResponseEntity<>(assembler.toResource(alunoBusiness.list(pageable   )), HttpStatus.OK);    
  }

  /**
   * NamedQuery listByNaoPremiados
   * @generated
   */
  @RequestMapping(method = RequestMethod.GET
  , value="/listByNaoPremiados")    
  public  HttpEntity<PagedResources<Aluno>> listByNaoPremiadosParams (Pageable pageable, PagedResourcesAssembler assembler){
      return new ResponseEntity<>(assembler.toResource(alunoBusiness.listByNaoPremiados(pageable   )), HttpStatus.OK);    
  }

  /**
   * OneToMany Relationship GET
   * @generated
   */
  @RequestMapping(method = RequestMethod.GET
  , value="/{instanceId}/Sorteio")    
  public HttpEntity<PagedResources<Sorteio>> findSorteio(@PathVariable("instanceId") java.lang.String instanceId, Pageable pageable, PagedResourcesAssembler assembler) {
    return new ResponseEntity<>(assembler.toResource(alunoBusiness.findSorteio(instanceId,  pageable )), HttpStatus.OK);
  }

  /**
   * OneToMany Relationship DELETE 
   * @generated
   */  
  @RequestMapping(method = RequestMethod.DELETE
  , value="/{instanceId}/Sorteio/{relationId}")    
  public void deleteSorteio(@PathVariable("relationId") java.lang.String relationId) throws Exception {
    this.sorteioBusiness.delete(relationId);
  }
  
  /**
   * OneToMany Relationship PUT
   * @generated
   */  
  @RequestMapping(method = RequestMethod.PUT
  , value="/{instanceId}/Sorteio/{relationId}")
  public Sorteio putSorteio(@Validated @RequestBody final Sorteio entity, @PathVariable("relationId") java.lang.String relationId) throws Exception {
	return this.sorteioBusiness.put(entity);
  }  
  
  /**
   * OneToMany Relationship POST
   * @generated
   */  
  @RequestMapping(method = RequestMethod.POST
  , value="/{instanceId}/Sorteio")
  public Sorteio postSorteio(@Validated @RequestBody final Sorteio entity, @PathVariable("instanceId") java.lang.String instanceId) throws Exception {
	Aluno aluno = this.alunoBusiness.get(instanceId);
	entity.setAluno(aluno);
	return this.sorteioBusiness.post(entity);
  }   

  /**
   * OneToMany Relationship GET
   * @generated
   */
  @RequestMapping(method = RequestMethod.GET
  , value="/{instanceId}/SorteioAluno")    
  public HttpEntity<PagedResources<SorteioAluno>> findSorteioAluno(@PathVariable("instanceId") java.lang.String instanceId, Pageable pageable, PagedResourcesAssembler assembler) {
    return new ResponseEntity<>(assembler.toResource(alunoBusiness.findSorteioAluno(instanceId,  pageable )), HttpStatus.OK);
  }

  /**
   * OneToMany Relationship DELETE 
   * @generated
   */  
  @RequestMapping(method = RequestMethod.DELETE
  , value="/{instanceId}/SorteioAluno/{relationId}")    
  public void deleteSorteioAluno(@PathVariable("relationId") java.lang.String relationId) throws Exception {
    this.sorteioAlunoBusiness.delete(relationId);
  }
  
  /**
   * OneToMany Relationship PUT
   * @generated
   */  
  @RequestMapping(method = RequestMethod.PUT
  , value="/{instanceId}/SorteioAluno/{relationId}")
  public SorteioAluno putSorteioAluno(@Validated @RequestBody final SorteioAluno entity, @PathVariable("relationId") java.lang.String relationId) throws Exception {
	return this.sorteioAlunoBusiness.put(entity);
  }  
  
  /**
   * OneToMany Relationship POST
   * @generated
   */  
  @RequestMapping(method = RequestMethod.POST
  , value="/{instanceId}/SorteioAluno")
  public SorteioAluno postSorteioAluno(@Validated @RequestBody final SorteioAluno entity, @PathVariable("instanceId") java.lang.String instanceId) throws Exception {
	Aluno aluno = this.alunoBusiness.get(instanceId);
	entity.setAluno(aluno);
	return this.sorteioAlunoBusiness.post(entity);
  }   


  /**
   * ManyToMany Relationship GET
   * @generated
   */
  @RequestMapping(method = RequestMethod.GET
  ,value="/{instanceId}/Sorteio_2")
  public HttpEntity<PagedResources<Sorteio>> listSorteio_2(@PathVariable("instanceId") java.lang.String instanceId,  Pageable pageable, PagedResourcesAssembler assembler ) {
    return new ResponseEntity<>(assembler.toResource(alunoBusiness.listSorteio_2(instanceId,  pageable )), HttpStatus.OK); 
  }

  /**
   * ManyToMany Relationship POST
   * @generated
   */  
  @RequestMapping(method = RequestMethod.POST
  ,value="/{instanceId}/Sorteio_2")
  public Aluno postSorteio_2(@Validated @RequestBody final Sorteio entity, @PathVariable("instanceId") java.lang.String instanceId) throws Exception {
      SorteioAluno newSorteioAluno = new SorteioAluno();

      Aluno instance = this.alunoBusiness.get(instanceId);

      newSorteioAluno.setSorteio(entity);
      newSorteioAluno.setAluno(instance);
      
      this.sorteioAlunoBusiness.post(newSorteioAluno);

      return newSorteioAluno.getAluno();
  }   

  /**
   * ManyToMany Relationship DELETE
   * @generated
   */  
  @RequestMapping(method = RequestMethod.DELETE
  ,value="/{instanceId}/Sorteio_2/{relationId}")
  public void deleteSorteio_2(@PathVariable("instanceId") java.lang.String instanceId, @PathVariable("relationId") java.lang.String relationId) {
	  this.alunoBusiness.deleteSorteio_2(instanceId, relationId);
  }  



    /**
     * Serviço exposto para recuperar a entidade de acordo com o id fornecido
     * 
     * @generated
     */
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public Aluno get(@PathVariable("id") java.lang.String id) throws Exception {
        return alunoBusiness.get(id);
    }
}
