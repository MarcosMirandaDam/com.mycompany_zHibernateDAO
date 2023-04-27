
package com.mycompany.zhibernate;

/**
 *
 * @author Marcos Miranda
 */
import com.mycompany.zhibernate.modelo.Amarre;
import com.mycompany.zhibernate.modelo.Barco;
import com.mycompany.zhibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

public class BarcoDAOImpl implements BarcoDAO {

    private SessionFactory sessionFactory;

    public BarcoDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    
    // 
    @Override
public void crear(Barco barco) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(barco);
            transaction.commit();
            
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            System.err.println("Error al crear el barco: " + e.getMessage());
          
        }
    }

    @Override
    public Barco obtenerPorId(Long id) {
        Session session = sessionFactory.openSession();
        Barco barco = session.get(Barco.class, id);
        session.close();
        return barco;
    }

    @Override
    public List<Barco> obtenerTodos() {
        Session session = sessionFactory.openSession();
        List<Barco> barcos = session.createQuery("from Barco", Barco.class).list();
        session.close();
        return barcos;
    }

    @Override
    public void actualizar(Barco barco) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(barco);
        transaction.commit();
        session.close();
    }

    @Override
    public void eliminar(Barco barco) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(barco);
        transaction.commit();
        session.close();
    }

    @Override
    public void amarrar(Barco barco, Amarre amarre) {
        barco.setAmarre(amarre);
        amarre.setBarco(barco);
        amarre.setOcupado(true);
        actualizar(barco);
    }

    @Override
    public void desamarrar(Barco barco, Amarre amarre) {
        barco.setAmarre(null);
        amarre.setBarco(null);
        amarre.setOcupado(false);
        actualizar(barco);
    }

    @Override

    // Aqui utilizo el HibernateUtil para las sesiones a modo de ejemplo (abria que cambiar el main)
    // se utiliza HQL para  la consulta
    // se usa la convención de nombres de Spring Data JPA
    public List<Barco> findByNombreContainingIgnoreCase(String nombre) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Barco> query = session.createQuery("FROM Barco WHERE lower(nombre) LIKE :nombre", Barco.class);
            query.setParameter("nombre", "%" + nombre.toLowerCase() + "%");
            return query.list();

            // Usando SQL nativo
            /*
            String sql = "SELECT * FROM barco WHERE LOWER(nombre) LIKE :nombre";
            List<Barco> barcos = session.createNativeQuery(sql, Barco.class)
                    .setParameter("nombre", "%" + nombre.toLowerCase() + "%")
                    .getResultList();
            return barcos;
             */
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Barco> findByNombreOrderByEsloraDesc(String nombre) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Barco> query = session.createQuery("FROM Barco WHERE nombre = :nombre ORDER BY eslora DESC", Barco.class);
            query.setParameter("nombre", nombre);
            return query.list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
