package br.com.rodrigomsantana.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.rodrigomsantana.cursomc.domain.Categoria;
import br.com.rodrigomsantana.cursomc.repositories.CategoriaRepository;
import br.com.rodrigomsantana.cursomc.services.exceptions.ObjectNotFoundException;


@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository repo;
	
	public Categoria find(Integer id) {
		
		Optional<Categoria> obj = repo.findById(id);
		
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! id: " + id + ", Tipo: " + Categoria.class.getName()));
	}

}
