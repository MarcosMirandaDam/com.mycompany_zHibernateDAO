package com.mycompany.zhibernate.modelo;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.NonNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "barcos")
public class Barco implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @NonNull
    @Column(name = "nombre")
    private String nombre;

    @Column(name = "eslora")
    private int eslora;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "amarre_id", referencedColumnName = "id")
    private Amarre amarre;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name = "barco_regata",
            joinColumns = @JoinColumn(name = "barco_id"),
            inverseJoinColumns = @JoinColumn(name = "regata_id"))
    private Set<Regata> regatas = new HashSet<>(); 
    
    
    @ManyToOne
    @JoinColumn(name="IdPropietario")
    private Propietario propietario;
    
      
    
    

    
    
    // Lombok genera automáticamente los getters, setters y constructores
}
