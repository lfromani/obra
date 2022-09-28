package com.luizfelipe.obra.resources;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import com.luizfelipe.obra.domain.Movimento;
import com.luizfelipe.obra.domain.Obra;
import com.luizfelipe.obra.domain.Produto;
import com.luizfelipe.obra.domain.dtos.ConsultaHomeObraDTO;
import com.luizfelipe.obra.domain.dtos.MovimentoDTO;
import com.luizfelipe.obra.services.MovimentoService;
import com.luizfelipe.obra.vo.MovimentoVO;

@RestController
@RequestMapping(value = "/movimentos")
public class MovimentoResource {
	
	@Autowired
	private MovimentoService service;	
	
	@PostMapping
	public ResponseEntity<MovimentoDTO> create(@Valid @RequestBody MovimentoDTO objDTO) {
		Movimento obj = service.create(objDTO);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdMovimento()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@GetMapping
	public ResponseEntity<List<ConsultaHomeObraDTO>> findMovimentosHome() {
		List<ConsultaHomeObraDTO> listDTO = service.findMovimentosHome();
		return ResponseEntity.ok().body(listDTO);
	}

	@GetMapping(value = "/findByIdObra/{idObra}")
	public ResponseEntity<List<MovimentoVO>> findByIdObra(@PathVariable Long idObra) {
		List<Movimento> movimentos = service.findByIdObra(idObra);
		List<MovimentoVO> movimentosVO = new ArrayList<>();
		
		for (Movimento movimento : movimentos) {
			MovimentoVO vo = new MovimentoVO();
			vo.setIdMovimento(movimento.getIdMovimento());
			vo.setDataLancamento(movimento.getDataLancamento());
			vo.setQuantidade(movimento.getQuantidade());
			vo.setProduto(montarProduto(movimento.getProduto()));
			vo.setObra(montarObra(movimento.getObra()));
			
			movimentosVO.add(vo);
		}
		
		return ResponseEntity.ok().body(movimentosVO);
	}

	private String montarObra(Obra obra) {
		return obra.getIdObra().toString() + " - " + obra.getDescricao(); 
	}

	private String montarProduto(Produto produto) {
		return produto.getIdProduto().toString() + " - " + produto.getDescricao();
	}
	
}
