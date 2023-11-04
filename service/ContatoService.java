package com.ademir.agenda.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ademir.agenda.model.Contato;
import com.ademir.agenda.repository.ContatoRepository;
import com.ademir.agenda.service.interfaces.ContatoServiceInterface;



@Service
public class ContatoService implements ContatoServiceInterface {

	private ContatoRepository contatoRepository;
	
	@Autowired
	public ContatoService(ContatoRepository contatoRepository) {
		this.contatoRepository = contatoRepository;
	}
	
	@Override
	public Contato save(Contato contato) {
		return contatoRepository.save(contato);
	}

	@Override
	public Optional<Contato> getById(Long id) {
		return contatoRepository.findById(id);
	}

	@Override
	public List<Contato> getAll() {
		return contatoRepository.findAll();
	}

	@Override
	public Contato update(Contato contato) {
		//encontrei o produto
		Optional<Contato> upContato = contatoRepository.findById(contato.getId());
		
		//se ele existir, atualizar:
		if(upContato.isPresent()) {
			Contato newContato = upContato.get();
			newContato.setContato(contato.getContato());
			newContato.setTipo(contato.getTipo());
			newContato.setPessoa(contato.getPessoa());
			return contatoRepository.save(newContato);
		}
		return contato;
	}

	@Override
	public void delete(Long id) {
		contatoRepository.deleteById(id);
	}

}
