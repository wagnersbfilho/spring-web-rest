package br.com.spring.diolabs.springmvcweb.service;

import br.com.spring.diolabs.springmvcweb.exception.JediNotFoundException;
import br.com.spring.diolabs.springmvcweb.model.Jedi;
import br.com.spring.diolabs.springmvcweb.repository.JediRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JediService {

    @Autowired
    JediRepository repository;

    public List<Jedi> findAll() {
        return repository.findAll();
    }

    public Jedi findById(Long id) {

        final Optional<Jedi> jedi = repository.findById(id);
        if (jedi.isPresent()) {
            return jedi.get();
        } else {
            throw new JediNotFoundException();
        }
    }

    public Jedi save(Jedi jedi) {
        return repository.save(jedi);
    }

    public Jedi update(Long id, Jedi jedi) {

        final Jedi entity = this.findById(id);
        entity.setName(jedi.getName());
        entity.setLastname(jedi.getLastname());

        return repository.save(entity);
    }

    public void delete(Long id) {
        final Jedi jedi = this.findById(id);
        repository.delete(jedi);
    }
}
