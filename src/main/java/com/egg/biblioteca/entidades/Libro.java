/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.egg.biblioteca.entidades;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Gustavo Torti
 */
@Entity
public class Libro {
    @Id
    private Long isbn;
    private String titulo;
    private Integer ejemplares;
    @Temporal(TemporalType.DATE)
    private Date fechaAlta;
    
    private Autor autor;
}
