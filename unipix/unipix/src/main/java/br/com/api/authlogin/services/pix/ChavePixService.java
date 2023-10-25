package br.com.api.authlogin.services.pix;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.api.authlogin.dto.ChavePixDTO;
import br.com.api.authlogin.exceptions.ResourceNotFoundException;
import br.com.api.authlogin.mapper.DozerMapper;
import br.com.api.authlogin.model.ChavePix;
import br.com.api.authlogin.repositories.ChavePixRepository;

@Service
public class ChavePixService {


	private Logger logger = Logger.getLogger(ChavePixService.class.getName());

	@Autowired
	private ChavePixRepository chavePixRepositories;

	public List<ChavePixDTO> findAll() {

		logger.info("Finding all ChavePix!");

		return DozerMapper.parseListObjects(chavePixRepositories.findAll(), ChavePixDTO.class);
	}

	public ChavePixDTO findById(String id) {

		logger.info("Finding one ChavePix!");

		var entity = chavePixRepositories.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
		return DozerMapper.parseObject(entity, ChavePixDTO.class);
	}

	public ChavePixDTO create(ChavePixDTO chavepix) {

		logger.info("Creating one chavepix!");
		var entity = DozerMapper.parseObject(chavepix, ChavePix.class);
		var vo = DozerMapper.parseObject(chavePixRepositories.save(entity), ChavePixDTO.class);
		return vo;
	}

	public ChavePixDTO update(ChavePixDTO chavepix) {

		logger.info("Updating one dados!");

		var entity = chavePixRepositories.findById(chavepix.getId())
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));

		entity.setId(chavepix.getId());
		entity.setChavee(chavepix.getChavee());
		entity.setTipo(chavepix.getTipo());
		
		var vo = DozerMapper.parseObject(chavePixRepositories.save(entity), ChavePixDTO.class);
		return vo;
	}

	public void delete(String id) {

		logger.info("Deleting one clinica!");

		var entity = chavePixRepositories.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
		chavePixRepositories.delete(entity);
	}
}
