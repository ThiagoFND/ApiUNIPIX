package br.com.api.authlogin.controller.pix;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.authlogin.dto.ChavePixDTO;
import br.com.api.authlogin.services.pix.ChavePixService;

@RestController
@RequestMapping("/api/pix/chavePix")
public class ChavePixController {

	@Autowired
	private ChavePixService chavePixServices;

	// Endpoint para adicionar um novo contato na agenda
	@PostMapping(value = "/create",
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ChavePixDTO create(@RequestBody ChavePixDTO chavepix) {
		return chavePixServices.create(chavepix);
	}
	
	// Endpoint para obter todos os contatos da agenda
	@GetMapping(value = "/list",
		produces = MediaType.APPLICATION_JSON_VALUE)
	public List<ChavePixDTO> findAll() {
		return chavePixServices.findAll();
	}
	
	// Endpoint para atualizar os dados da agenda
	@PutMapping(value = "/update/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
	public ChavePixDTO update(@PathVariable String id, @RequestBody ChavePixDTO exameFisico) {
		// Verifique se o ID é válido (não nulo)
		if (id == null) {
			throw new IllegalArgumentException("O ID não pode ser nulo.");
		}
		// Configure o ID no objeto 'exames'
		exameFisico.setId(id);

		// Chame o serviço 'examesService' para atualizar o exame
		ChavePixDTO updatedExame = chavePixServices.update(exameFisico);
		return updatedExame;
	}
	
	// Endpoint para excluir um contato pelo id
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> delete(@PathVariable(value = "id") String id) {
		chavePixServices.delete(id);
		return ResponseEntity.noContent().build();
	}
}
