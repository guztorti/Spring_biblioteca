/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.egg.biblioteca.servicios;

import com.egg.biblioteca.entidades.Editorial;
import com.egg.biblioteca.repositorios.EditorialRepositorio;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author cecsa
 */
@Service
public class EditorialServicio {
    
    @Autowired
    private EditorialRepositorio editorialRepositorio;
    
    @Transactional
    public void crearEditorial(String nombre){
        Editorial editorial = new Editorial();
        
        editorial.setNombre(nombre);
        editorialRepositorio.save(editorial);
    }
    
    public List<Editorial> listarEditoriales(){
        return editorialRepositorio.findAll();
    }
    @Transactional
    public void modificarAutor(String idEditorial, String nombre){
         Optional<Editorial> respuesta = editorialRepositorio.findById(idEditorial);
         if(respuesta.isPresent()){
              Editorial editorial = respuesta.get();
              editorial.setNombre(nombre);
              editorialRepositorio.save(editorial);
         }
    }
}
