package br.com.spring.diolabs.springmvcweb.rest;

import br.com.spring.diolabs.springmvcweb.model.Jedi;
import br.com.spring.diolabs.springmvcweb.service.JediService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/jedi")
public class JediResource {

    @Autowired
    public JediService service;

    @GetMapping("/all")
    public List<Jedi> getAllJedi() {

        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Jedi> getJedi(@PathVariable("id") Long id) {

        final Jedi jedi = service.findById(id);
        return ResponseEntity.ok(jedi);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Jedi create(@RequestBody Jedi jedi) {

        return service.save(jedi);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Jedi> update(@PathVariable("id") Long id, @RequestBody Jedi jedi) {

        return ResponseEntity.ok(service.update(id, jedi));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {

        service.delete(id);
        return ResponseEntity.ok().build();
    }

}
