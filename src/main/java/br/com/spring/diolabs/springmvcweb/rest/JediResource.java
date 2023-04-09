package br.com.spring.diolabs.springmvcweb.rest;

import br.com.spring.diolabs.springmvcweb.model.Jedi;
import br.com.spring.diolabs.springmvcweb.repository.JediRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class JediResource {

    @Autowired
    public JediRepository repository;

    @GetMapping("jedi/all")
    public List<Jedi> getAllJedi() {

        return repository.findAll();
    }

    @GetMapping("/jedi/{id}")
    public ResponseEntity<Jedi> getJedi(@PathVariable("id") Long id) {

        final Optional<Jedi> jedi = repository.findById(id);
        if (jedi.isPresent()) {
            return ResponseEntity.ok(jedi.get());
        } else {
            //throw new JediNotFoundExpetion();
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("jedi/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Jedi create(@RequestBody Jedi jedi) {

        return repository.save(jedi);
    }

    @PutMapping("jedi/update/{id}")
    public ResponseEntity<Jedi> update(@PathVariable("id") Long id, @RequestBody Jedi jedi) {

        final Optional<Jedi> entity = repository.findById(id);
        if (entity.isPresent()) {
            entity.get().setName(jedi.getName());
            entity.get().setLastname(jedi.getLastname());
            return ResponseEntity.ok(repository.save(entity.get()));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("jedi/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {

        final Optional<Jedi> entity = repository.findById(id);
        if (entity.isPresent()) {
            repository.delete(entity.get());
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
