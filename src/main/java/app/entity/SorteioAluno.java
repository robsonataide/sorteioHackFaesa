package app.entity;

import java.io.*;
import javax.persistence.*;
import java.util.*;
import javax.xml.bind.annotation.*;
import com.fasterxml.jackson.annotation.JsonIgnore;




/**
 * Classe que representa a tabela SORTEIOALUNO
 * @generated
 */
@Entity
@Table(name = "\"SORTEIOALUNO\""


)
@XmlRootElement
public class SorteioAluno implements Serializable {

  /**
   * UID da classe, necessário na serialização 
   * @generated
   */
  private static final long serialVersionUID = 1961793262l;
  
  /**
   * @generated
   */
  @Id
    
  @Column(name = "id", insertable=true, updatable=true)
  private java.lang.String id = UUID.randomUUID().toString().toUpperCase();
  
  /**
   * @generated
   */
  @ManyToOne
  @JoinColumn(name="fk_sorteio", referencedColumnName = "id", insertable=true, updatable=true)
  private Sorteio sorteio;
  
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
  public SorteioAluno(){
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
  public SorteioAluno setId(java.lang.String id){
    this.id = id;
    return this;
  }
  
  /**
   * Obtém sorteio
   * @param sorteio sorteio
   * return sorteio
   * @generated
   */
  public Sorteio getSorteio(){
    return this.sorteio;
  }
  
  /**
   * Define sorteio
   * @param sorteio sorteio
   * @generated
   */
  public SorteioAluno setSorteio(Sorteio sorteio){
    this.sorteio = sorteio;
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
  public SorteioAluno setAluno(Aluno aluno){
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
      
      if(!(obj instanceof SorteioAluno))
        return false;
      
      SorteioAluno other = (SorteioAluno)obj;
      
    if(this.id == null && other.id != null)
        return false;
      else if(!this.id.equals(other.id))
        return false;
  

      return true;
      
  }
}
