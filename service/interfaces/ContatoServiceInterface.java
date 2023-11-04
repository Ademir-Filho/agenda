package com.ademir.agenda.service.interfaces;

import java.util.List;
import java.util.Optional;

import com.ademir.agenda.model.Contato;


public interface ContatoServiceInterface {
	Contato save(Contato contato);
	Optional<Contato> getById(Long id);
	List<Contato> getAll();
	Contato update(Contato contato);
	void delete(Long id);
}
