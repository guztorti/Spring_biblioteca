/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.egg.biblioteca.entidades;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author gustavotorti
 */
@Entity
public class Autor {
     @Id
     @GeneratedValue(generator = "uuid")
     @GenericGenerator(name = "uuid", strategy = "uuid2")
     private String id;
     private String nombre;
     @Temporal(TemporalType.DATE)
     private Date fechaNacimiento;
     
}
