package br.com.spring.diolabs.springmvcweb.model;

import javax.persistence.*;

@Entity
public class Jedi {

    @Id
    @Column(name = "jedi_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "jedi_name")
    private String name;

    @Column(name = "jedi_lastanme")
    private String lastname;

    public Jedi(String name, String lastname) {
        this.name = name;
        this.lastname = lastname;
    }

    public Jedi() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}