package app.dao;

import app.entity.*;



import org.springframework.stereotype.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.domain.*;
import org.springframework.data.repository.query.*;
import org.springframework.transaction.annotation.*;



/**
 * Realiza operação de Create, Read, Update e Delete no banco de dados.
 * Os métodos de create, edit, delete e outros estão abstraídos no JpaRepository
 * 
 * @see org.springframework.data.jpa.repository.JpaRepository
 * 
 * @generated
 */
@Repository("SorteioDAO")
@Transactional(transactionManager="app-TransactionManager")
public interface SorteioDAO extends JpaRepository<Sorteio, java.lang.String> {

  /**
   * Obtém a instância de Sorteio utilizando os identificadores
   * 
   * @param id
   *          Identificador 
   * @return Instância relacionada com o filtro indicado
   * @generated
   */    
  @Query("SELECT entity FROM Sorteio entity WHERE entity.id = :id")
  public Sorteio findOne(@Param(value="id") java.lang.String id);

  /**
   * Remove a instância de Sorteio utilizando os identificadores
   * 
   * @param id
   *          Identificador 
   * @return Quantidade de modificações efetuadas
   * @generated
   */    
  @Modifying
  @Query("DELETE FROM Sorteio entity WHERE entity.id = :id")
  public void delete(@Param(value="id") java.lang.String id);

  /**
   * Lista com paginação de acordo com a NamedQuery
   * 
   * @generated
   */
  @Query("select s from Sorteio s")
  public Page<Sorteio> list ( Pageable pageable );
  

  /**
   * OneToMany Relation
   * @generated
   */
  @Query("SELECT entity FROM SorteioAluno entity WHERE entity.sorteio.id = :id")
  public Page<SorteioAluno> findSorteioAluno(@Param(value="id") java.lang.String id,  Pageable pageable );



  /**
   * ManyToOne Relation
   * @generated
   */
  @Query("SELECT entity.aluno FROM SorteioAluno entity WHERE entity.sorteio.id = :id")
  public Page<Aluno> listAluno(@Param(value="id") java.lang.String id,  Pageable pageable);

    /**
     * ManyToOne Relation Delete
     * @generated
     */
    @Modifying
    @Query("DELETE FROM SorteioAluno entity WHERE entity.sorteio.id = :instanceId AND entity.aluno.id = :relationId")
    public int deleteAluno(@Param(value="instanceId") java.lang.String instanceId, @Param(value="relationId") java.lang.String relationId);




}