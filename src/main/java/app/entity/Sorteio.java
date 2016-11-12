package app.entity;

import java.io.*;
import javax.persistence.*;
import java.util.*;
import javax.xml.bind.annotation.*;
import com.fasterxml.jackson.annotation.JsonIgnore;




/**
 * Classe que representa a tabela SORTEIO
 * @generated
 */
@Entity
@Table(name = "\"SORTEIO\""


)
@XmlRootElement
public class Sorteio implements Serializable {

  /**
   * UID da classe, necessário na serialização 
   * @generated
   */
  private static final long serialVersionUID = -359930443l;
  
  /**
   * @generated
   */
  @Id
    
  @Column(name = "id", insertable=true, updatable=true)
  private java.lang.String id = UUID.randomUUID().toString().toUpperCase();
  
  /**
   * @generated
   */
  @Column(name = "premio", nullable = false, unique = false, insertable=true, updatable=true)
  private java.lang.String premio;
  
  /**
   * @generated
   */
  @Column(name = "sorteadoEm", nullable = true, unique = false, insertable=true, updatable=true)
  private java.lang.Long sorteadoEm;
  
  /**
   * @generated
   */
  @ManyToOne
  @JoinColumn(name="fk_aluno", referencedColumnName = "id", insertable=true, updatable=true)
  private Aluno aluno;
  
  
  /**
   * Construtor
   * @generated
   */
  public Sorteio(){
  }

  
  /**
   * Obtém id
   * @param id id
   * return id
   * @generated
   */
  public java.lang.String getId(){
    return this.id;
  }
  
  /**
   * Define id
   * @param id id
   * @generated
   */
  public Sorteio setId(java.lang.String id){
    this.id = id;
    return this;
  }
  
  /**
   * Obtém premio
   * @param premio premio
   * return premio
   * @generated
   */
  public java.lang.String getPremio(){
    return this.premio;
  }
  
  /**
   * Define premio
   * @param premio premio
   * @generated
   */
  public Sorteio setPremio(java.lang.String premio){
    this.premio = premio;
    return this;
  }
  
  /**
   * Obtém sorteadoEm
   * @param sorteadoEm sorteadoEm
   * return sorteadoEm
   * @generated
   */
  public java.lang.Long getSorteadoEm(){
    return this.sorteadoEm;
  }
  
  /**
   * Define sorteadoEm
   * @param sorteadoEm sorteadoEm
   * @generated
   */
  public Sorteio setSorteadoEm(java.lang.Long sorteadoEm){
    this.sorteadoEm = sorteadoEm;
    return this;
  }
  
  /**
   * Obtém aluno
   * @param aluno aluno
   * return aluno
   * @generated
   */
  public Aluno getAluno(){
    return this.aluno;
  }
  
  /**
   * Define aluno
   * @param aluno aluno
   * @generated
   */
  public Sorteio setAluno(Aluno aluno){
    this.aluno = aluno;
    return this;
  }
  
  /**
   * @generated
   */
  @Override
  public int hashCode() {
        final int prime = 31;
        int result = 1;

        result = prime * result + ((id == null) ? 0 : id.hashCode());

        return result;
    }
  
  /**
   * @generated
   */ 
  @Override
    public boolean equals(Object obj) {
    
      if(this == obj)
        return true;
      
      if(obj == null)
        return false;
      
      if(!(obj instanceof Sorteio))
        return false;
      
      Sorteio other = (Sorteio)obj;
      
    if(this.id == null && other.id != null)
        return false;
      else if(!this.id.equals(other.id))
        return false;
  

      return true;
      
  }
}
