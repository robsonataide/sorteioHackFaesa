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
 * Controller para expor serviços REST de SorteioAluno
 * 
 * @author Robson Ataide
 * @version 1.0
 * @generated
 **/
@RestController
@RequestMapping(value = "/api/rest/SorteioAluno")
public class SorteioAlunoREST {

    /**
     * Classe de negócio para manipulação de dados
     * 
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
    public SorteioAluno post(@Validated @RequestBody final SorteioAluno entity) throws Exception {
        return sorteioAlunoBusiness.post(entity);
    }

    /**
     * Serviço exposto para salvar alterações de acordo com a entidade fornecida
     * 
     * @generated
     */
    @RequestMapping(method = RequestMethod.PUT)
    public SorteioAluno put(@Validated @RequestBody final SorteioAluno entity) throws Exception {
        return sorteioAlunoBusiness.put(entity);
    }

    /**
     * Serviço exposto para salvar alterações de acordo com a entidade e id fornecidos
     * 
     * @generated
     */
    @RequestMapping(method = RequestMethod.PUT, value = "/{id}")
    public SorteioAluno put(@PathVariable("id") final java.lang.String id, @Validated @RequestBody final SorteioAluno entity) throws Exception {
        return sorteioAlunoBusiness.put(entity);
    }

    /**
     * Serviço exposto para remover a entidade de acordo com o id fornecido
     * 
     * @generated
     */
    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public void delete(@PathVariable("id") java.lang.String id) throws Exception {
        sorteioAlunoBusiness.delete(id);
    }




    /**
     * Serviço exposto para recuperar a entidade de acordo com o id fornecido
     * 
     * @generated
     */
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public SorteioAluno get(@PathVariable("id") java.lang.String id) throws Exception {
        return sorteioAlunoBusiness.get(id);
    }
}
