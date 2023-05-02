package com.mycompany.zhibernate.dao;


import com.mycompany.zhibernate.modelo.Puerto;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author Marcos Miranda
 */
public class PuertoDAOImpl implements PuertoDAO{
    
    private SessionFactory sessionFactory;                          //objeto sessionFactory

    public PuertoDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void crear(Puerto puerto) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.save(puerto);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            System.err.println("Error al crear el puerto: " + e.getMessage());
        }
    }

    @Override
    public Puerto obtenerPorCiudad(String ciudad) {
        Session session = sessionFactory.openSession();
        Puerto puerto = session.get(Puerto.class, ciudad);
        session.close();
        return puerto;
    }

    @Override
    public List<Puerto> obtenerTodos() {
        Session session = sessionFactory.openSession();
        List<Puerto> listaPuertos = session.createQuery("from Puerto", Puerto.class).list();
        session.close();
        return listaPuertos;
    }

    @Override
    public void actualizar(Puerto puerto) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(puerto);
        transaction.commit();
        session.close();
    }

    @Override
    public void eliminar(Puerto puerto) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(puerto);
        transaction.commit();
        session.close();
    }
    
}
