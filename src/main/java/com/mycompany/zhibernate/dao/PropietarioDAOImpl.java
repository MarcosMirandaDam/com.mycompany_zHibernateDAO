
package com.mycompany.zhibernate.dao;

import com.mycompany.zhibernate.modelo.Propietario;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author Marcos Miranda
 */
public class PropietarioDAOImpl implements PropietarioDAO{
    
    private SessionFactory sessionFactory;                          //objeto sessionFactory

    public PropietarioDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void crear(Propietario propietario) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.save(propietario);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            System.err.println("Error al crear el propietario: " + e.getMessage());
        }
    }

    @Override
    public Propietario obtenerPorDni(String dni) {
        Session session = sessionFactory.openSession();
        Propietario propietario = session.get(Propietario.class, dni);
        session.close();
        return propietario;
    }

    @Override
    public List<Propietario> obtenerTodos() {
        Session session = sessionFactory.openSession();
        List<Propietario> amarres = session.createQuery("from Propietario", Propietario.class).list();
        session.close();
        return amarres;
        
    }

    @Override
    public void actualizar(Propietario propietario) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(propietario);
        transaction.commit();
        session.close();
    }

    @Override
    public void eliminar(Propietario propietario) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(propietario);
        transaction.commit();
        session.close();
    }
    
}
