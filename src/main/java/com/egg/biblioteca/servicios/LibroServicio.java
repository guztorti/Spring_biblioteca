/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.egg.biblioteca.servicios;

import com.egg.biblioteca.entidades.Libro;
import com.egg.biblioteca.entidades.Autor;
import com.egg.biblioteca.entidades.Editorial;
import com.egg.biblioteca.excepciones.MiExcepcion;
import com.egg.biblioteca.repositorios.LibroRepositorio;
import com.egg.biblioteca.repositorios.AutorRepositorio;
import com.egg.biblioteca.repositorios.EditorialRepositorio;
import java.util.Date;
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
public class LibroServicio {

     @Autowired
     private LibroRepositorio libroRepositorio;
     @Autowired
     private AutorRepositorio autorRepositorio;
     @Autowired
     private EditorialRepositorio editorialRepositorio;

     @Transactional
     public void crearLibro(Long isbn, String titulo, Integer ejemplares, String idAutor, String idEditorial) throws MiExcepcion {
          
          validarDatos(isbn, titulo, idAutor, idEditorial, ejemplares);
          
          Libro libro = new Libro();
          Autor autor = autorRepositorio.findById(idAutor).get();
          Editorial editorial = editorialRepositorio.findById(idEditorial).get();

          libro.setIsbn(isbn);
          libro.setTitulo(titulo);
          libro.setEjemplares(ejemplares);

          libro.setFechaAlta(new Date());

          libroRepositorio.save(libro);
     }

     public List<Libro> listarLibros() {
          return libroRepositorio.findAll();
     }

     @Transactional
     public void modificarLibro(Long isbn, String titulo, String idAutor, String idEditorial, Integer ejemplares) throws MiExcepcion {
          
          validarDatos(isbn, titulo, idAutor, idEditorial, ejemplares);
          
          Optional<Libro> respuestaLibro = libroRepositorio.findById(isbn);
          Optional<Editorial> respuestaEditorial = editorialRepositorio.findById(idEditorial);
          Optional<Autor> respuestaAutor = autorRepositorio.findById(idAutor);
          Autor autor = null;
          Editorial editorial = null;
          if (respuestaAutor.isPresent()) {
       
               autor = respuestaAutor.get();
          }
          if (respuestaLibro.isPresent()) {
               editorial = respuestaEditorial.get();
          }
          if (respuestaLibro.isPresent()) {
               Libro libro = respuestaLibro.get();
               libro.setTitulo(titulo);
               libro.setAutor(autor);
               libro.setEditorial(editorial);
               libro.setEjemplares(ejemplares);
               
               libroRepositorio.save(libro);
          }
     }
     
     private void validarDatos(Long isbn, String nombre, String idAutor, String idEditorial, Integer ejemplares) throws MiExcepcion{
          if(isbn == null){
               throw new MiExcepcion("El ISBN no puede ser nulo");
          }
          if(nombre.isEmpty() || nombre == null){
               throw new MiExcepcion("El titulo no puede ser nulo ni vacio");
          }
          if(idAutor.isEmpty() || idAutor == null){
               throw new MiExcepcion("El autor no puede ser nulo ni vacio");
          }
          if(idEditorial.isEmpty() || idEditorial == null){
               throw new MiExcepcion("El editorial no puede ser nulo ni vacio");
          }
          if(ejemplares == null){
               throw new MiExcepcion("El ejemplares no puede ser nulo");
          }
     }
}
