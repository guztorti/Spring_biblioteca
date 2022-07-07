/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.egg.biblioteca.servicios;

import com.egg.biblioteca.entidades.Autor;
import com.egg.biblioteca.entidades.Libro;
import com.egg.biblioteca.repositorios.AutorRepositorio;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author cecsa
 */
@Service
public class AutorServicio {
    @Autowired
    private AutorRepositorio autorRepositorio;
    
    @Transactional
    public void crearAutor(String nombre){
        Autor autor = new Autor();
        autor.setNombre(nombre);
        
        autorRepositorio.save(autor);
    }
    
    public List<Autor> listarAutores(){
        return autorRepositorio.findAll();
    }
}
