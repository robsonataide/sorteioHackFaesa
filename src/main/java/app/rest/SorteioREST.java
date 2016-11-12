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
 * Controller para expor serviços REST de Sorteio
 * 
 * @author Robson Ataide
 * @version 1.0
 * @generated
 **/
@RestController
@RequestMapping(value = "/api/rest/Sorteio")
public class SorteioREST {

    /**
     * Classe de negócio para manipulação de dados
     * 
     * @generated
     */
    @Autowired
    @Qualifier("SorteioBusiness")
    private SorteioBusiness sorteioBusiness;

    /**
     * @generated
     */
      @Autowired
      @Qualifier("AlunoBusiness")
      private AlunoBusiness alunoBusiness;
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
    public Sorteio post(@Validated @RequestBody final Sorteio entity) throws Exception {
        return sorteioBusiness.post(entity);
    }

    /**
     * Serviço exposto para salvar alterações de acordo com a entidade fornecida
     * 
     * @generated
     */
    @RequestMapping(method = RequestMethod.PUT)
    public Sorteio put(@Validated @RequestBody final Sorteio entity) throws Exception {
        return sorteioBusiness.put(entity);
    }

    /**
     * Serviço exposto para salvar alterações de acordo com a entidade e id fornecidos
     * 
     * @generated
     */
    @RequestMapping(method = RequestMethod.PUT, value = "/{id}")
    public Sorteio put(@PathVariable("id") final java.lang.String id, @Validated @RequestBody final Sorteio entity) throws Exception {
        return sorteioBusiness.put(entity);
    }

    /**
     * Serviço exposto para remover a entidade de acordo com o id fornecido
     * 
     * @generated
     */
    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public void delete(@PathVariable("id") java.lang.String id) throws Exception {
        sorteioBusiness.delete(id);
    }


  /**
   * NamedQuery list
   * @generated
   */
  @RequestMapping(method = RequestMethod.GET
  )    
  public  HttpEntity<PagedResources<Sorteio>> listParams (Pageable pageable, PagedResourcesAssembler assembler){
      return new ResponseEntity<>(assembler.toResource(sorteioBusiness.list(pageable   )), HttpStatus.OK);    
  }

  /**
   * OneToMany Relationship GET
   * @generated
   */
  @RequestMapping(method = RequestMethod.GET
  , value="/{instanceId}/SorteioAluno")    
  public HttpEntity<PagedResources<SorteioAluno>> findSorteioAluno(@PathVariable("instanceId") java.lang.String instanceId, Pageable pageable, PagedResourcesAssembler assembler) {
    return new ResponseEntity<>(assembler.toResource(sorteioBusiness.findSorteioAluno(instanceId,  pageable )), HttpStatus.OK);
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
	Sorteio sorteio = this.sorteioBusiness.get(instanceId);
	entity.setSorteio(sorteio);
	return this.sorteioAlunoBusiness.post(entity);
  }   


  /**
   * ManyToMany Relationship GET
   * @generated
   */
  @RequestMapping(method = RequestMethod.GET
  ,value="/{instanceId}/Aluno")
  public HttpEntity<PagedResources<Aluno>> listAluno(@PathVariable("instanceId") java.lang.String instanceId,  Pageable pageable, PagedResourcesAssembler assembler ) {
    return new ResponseEntity<>(assembler.toResource(sorteioBusiness.listAluno(instanceId,  pageable )), HttpStatus.OK); 
  }

  /**
   * ManyToMany Relationship POST
   * @generated
   */  
  @RequestMapping(method = RequestMethod.POST
  ,value="/{instanceId}/Aluno")
  public Sorteio postAluno(@Validated @RequestBody final Aluno entity, @PathVariable("instanceId") java.lang.String instanceId) throws Exception {
      SorteioAluno newSorteioAluno = new SorteioAluno();

      Sorteio instance = this.sorteioBusiness.get(instanceId);

      newSorteioAluno.setAluno(entity);
      newSorteioAluno.setSorteio(instance);
      
      this.sorteioAlunoBusiness.post(newSorteioAluno);

      return newSorteioAluno.getSorteio();
  }   

  /**
   * ManyToMany Relationship DELETE
   * @generated
   */  
  @RequestMapping(method = RequestMethod.DELETE
  ,value="/{instanceId}/Aluno/{relationId}")
  public void deleteAluno(@PathVariable("instanceId") java.lang.String instanceId, @PathVariable("relationId") java.lang.String relationId) {
	  this.sorteioBusiness.deleteAluno(instanceId, relationId);
  }  



    /**
     * Serviço exposto para recuperar a entidade de acordo com o id fornecido
     * 
     * @generated
     */
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public Sorteio get(@PathVariable("id") java.lang.String id) throws Exception {
        return sorteioBusiness.get(id);
    }
}
