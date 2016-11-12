package api.rest.events.views.logged;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import app.business.AlunoBusiness;
import app.business.SorteioBusiness;
import app.entity.Aluno;
import app.entity.Sorteio;

@RestController
@RequestMapping(value = "/api/rest/events/SorteioREST ")
public class SorteioEventREST {

	@Autowired
	@Qualifier("AlunoBusiness")
	private AlunoBusiness alunoBusiness;

	@Autowired
	@Qualifier("SorteioBusiness")
	private SorteioBusiness sorteioBusiness;

	@RequestMapping(method = RequestMethod.POST, value = "/sorteiobuttonngclick")
	public Aluno SorteioButtonNgClick(@RequestBody Map<String, Object> object) throws Exception {
		String sorteioId = object.get("id").toString();
    
    Sorteio sorteio = sorteioBusiness.get(sorteioId);
    Aluno premiado = alunoBusiness.sorteio();
    
    try{
      sorteio.setAluno(premiado);
      sorteio.setSorteadoEm((new Date()).getTime());
      sorteioBusiness.put(sorteio);
    }catch(Exception ex){
      throw ex;
    }
    

		return premiado;
	}
	
	
	@RequestMapping(method = RequestMethod.POST, value = "/teste")
	public Aluno SorteioTeste() throws Exception {
		Aluno premiado = alunoBusiness.sorteio();
		return premiado;
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/reset")
	public boolean resetSorteio(@RequestBody Map<String, Object> object) throws Exception {
		String sorteioId = object.get("id").toString();

    Sorteio sorteio = sorteioBusiness.get(sorteioId);
    
    try{
      sorteio.setAluno(null);
      sorteio.setSorteadoEm(null);
      sorteioBusiness.put(sorteio);
    }catch(Exception ex){
      throw ex;
    }
    

		return true;
	}
	
}
