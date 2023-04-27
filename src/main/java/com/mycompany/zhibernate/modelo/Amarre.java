/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.zhibernate.modelo;

/**
 *
 * @author Marcos Miranda
 */


import java.io.Serializable;
import javax.persistence.*;
import lombok.*;


@Entity
@Table(name = "amarres")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Amarre implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "numero")
    private int numero;

    @Column(name = "categoria")
    @Enumerated(EnumType.STRING)
    private Categoria categoria;

    @Column(name = "ocupado")
    private boolean ocupado;

    @OneToOne(mappedBy = "amarre", cascade = CascadeType.ALL)
    private Barco barco;

    public Amarre(int numero) {
        this.numero = numero;
    }

    public enum Categoria {
        PEQUENO,
        MEDIANO,
        GRANDE,
        EXTRA_GRANDE
    }

}
