package com.mycompany.zhibernate.dao;



import com.mycompany.zhibernate.modelo.Amarre;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;
import org.hibernate.SessionFactory;

public class AmarreDAOImpl implements AmarreDAO {

    private SessionFactory sessionFactory;

    public AmarreDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void crear(Amarre amarre) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.save(amarre);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            System.err.println("Error al crear el amarre: " + e.getMessage());
        }
    }

    @Override
    public Amarre obtenerPorId(Long id) {
        Session session = sessionFactory.openSession();
        Amarre amarre = session.get(Amarre.class, id);
        session.close();
        return amarre;
    }

    @Override
    public List<Amarre> obtenerTodos() {
        Session session = sessionFactory.openSession();
        List<Amarre> amarres = session.createQuery("from Amarre", Amarre.class).list();
        session.close();
        return amarres;
    }

    @Override
    public void actualizar(Amarre amarre) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(amarre);
        transaction.commit();
        session.close();
    }

    @Override
    public void eliminar(Amarre amarre) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(amarre);
        transaction.commit();
        session.close();
    }
}
