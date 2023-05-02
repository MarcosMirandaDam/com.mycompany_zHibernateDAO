package com.mycompany.zhibernate.modelo;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author Marcos Miranda
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "puertos")
public class Puerto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "ciudad")
    private String ciudad;
    @Column(name = "longitud")
    private String longitud;
    @Column(name = "latitud")
    private String latitud;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name = "puerto_regata",
            joinColumns = {@JoinColumn(name = "puerto_id")},
            inverseJoinColumns = {@JoinColumn(name = "regata_id")})
    private Set<Regata> regatas = new HashSet<>(); 

}
