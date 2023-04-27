package com.mycompany.zhibernate;

import com.mycompany.zhibernate.dao.AmarreDAOImpl;
import com.mycompany.zhibernate.dao.PropietarioDAO;
import com.mycompany.zhibernate.dao.PropietarioDAOImpl;
import com.mycompany.zhibernate.dao.RegataDAO;
import com.mycompany.zhibernate.dao.RegataDAOImpl;
import com.mycompany.zhibernate.modelo.Amarre;
import com.mycompany.zhibernate.modelo.Barco;
import com.mycompany.zhibernate.modelo.Propietario;
import com.mycompany.zhibernate.modelo.Regata;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author Marcos Miranda
 */
public class ZHibernate {

    public static void main(String[] args) {
        // Configurar Hibernate
        Configuration configuration = new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        
        //Creo instancia de Propietario
        
        Propietario propietario1=new Propietario(1,"13158801H","Marcos","Miranda","30Junio1976",null);      //creo un propietario con lista barcos vacia    
        
        // Crear instancias de Barco , Amarre, Propietario
        Barco barco2 = new Barco(2, "Perla Negra", 32,null, null,null);
        
        Amarre amarre1 = new Amarre(10);
        // Establecer atributos del amarre1

        //Creada instancia de PropietarioDAOImpl
        PropietarioDAO propietarioDAO=new PropietarioDAOImpl(sessionFactory);
        // Crear una instancia de BarcoDAOImpl
        BarcoDAO barcoDAO = new BarcoDAOImpl(sessionFactory);

        // Utilizar BarcoDAOImpl para realizar operaciones CRUD y amarrar barcos
        barcoDAO.crear(barco2);
        barcoDAO.amarrar(barco2, amarre1);
        propietarioDAO.crear(propietario1);         //creo el propietario
        
        /*   EN ESTE COMENTARIO HA CREADO 1 ARRAY DE NOMBRES DE BARCOS Y OTRO DE ESLORA
        String[] nombresBarcos = {
            "Juan Sebastián Elcano", "Santa María", "Pinta", "Niña", "Victoria", "Trinidad", "San Juan Nepomuceno", "Álvaro de Bazán"};
        int[] esloraBarcos = {
            42, 60, 52, 70, 45, 32, 38, 36
        };
        
        // Crear barcos y amarres, amarrar los barcos
        for (int i = 0; i < nombresBarcos.length; i++) {

            Barco barco = new Barco(i, "Martina", i, amarre1, propietario1, null);

            barco.setEslora(esloraBarcos[i]);
            Amarre amarre = new Amarre(i + 1);

            barco.setAmarre(amarre);
            amarre.setBarco(barco);

            barcoDAO.crear(barco);
        }
        
        List<Barco> listaBarcos = barcoDAO.findByNombreContainingIgnoreCase("i");

        for (Barco barco : listaBarcos) {
            System.out.println(barco.getNombre());
        }
        */
        //creando una regata
        Regata cuttysark = new Regata(1, "cutty sark", new Date(), "A Coruña", null);
        RegataDAOImpl regataDAO = new RegataDAOImpl(sessionFactory);
        regataDAO.crear(cuttysark);
        
        //creo una regata
        Regata CaboPenias = new Regata(2,"cabo de peñas",new Date(),"Asturias",null);
        regataDAO.crear(CaboPenias);

        AmarreDAOImpl amarreDAO = new AmarreDAOImpl(sessionFactory);

        // Crear instancias de Barco, Amarre y Regata
        Barco mcQueen = new Barco(2, "McQueen3", 33, null,null, null);
        Amarre amarremcQueen = new Amarre(1001);

        // Establecer relaciones entre las instancias
        HashSet<Regata> regatas = new HashSet<>();
        regatas.add(cuttysark);
        mcQueen.setRegatas(regatas);
        HashSet<Barco> setBarcosRegata = new HashSet<>();
        //    setBarcosRegata.add(mcQueen);
        //    cuttysark.setBarcos(setBarcosRegata);
        barcoDAO.amarrar(mcQueen, amarremcQueen);

// Guardar las instancias de Amarre y Regata en la base de datos
// Asegúrate de implementar los métodos para guardar las instancias de Amarre y Regata en la base de datos
        //      amarreDAO.crear(amarremcQueen);
        //     regataDAO.crear(cuttysark);
// Guardar la instancia de Barco en la base de datos
        barcoDAO.crear(mcQueen);

        sessionFactory.close();
    }
}
