/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.zhibernate.modelo;


import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.*;
import lombok.*;


/**
 *
 * @author Marcos Miranda
 */


    @Entity
    @Table(name = "regata")
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public class Regata implements Serializable  {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;

        @Column(name = "nombre")
        private String nombre;

        @Column(name = "fecha")
        @Temporal(TemporalType.DATE)
        private Date fecha;

        @Column(name = "ubicacion")
        private String ubicacion;

        @ManyToMany(mappedBy = "regatas")
        private Set<Barco> barcos = new HashSet<>();


    
}
