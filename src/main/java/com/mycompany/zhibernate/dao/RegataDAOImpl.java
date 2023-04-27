/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.zhibernate.dao;

import com.mycompany.zhibernate.modelo.Regata;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;
import org.hibernate.SessionFactory;

public class RegataDAOImpl implements RegataDAO {

    private SessionFactory sessionFactory;

    public RegataDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void crear(Regata regata) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.save(regata);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            System.err.println("Error al crear la regata: " + e.getMessage());
        }
    }

    @Override
    public Regata obtenerPorId(Long id) {
        Session session = sessionFactory.openSession();
        Regata regata = session.get(Regata.class, id);
        session.close();
        return regata;
    }

    @Override
    public List<Regata> obtenerTodos() {
        Session session = sessionFactory.openSession();
        List<Regata> regatas = session.createQuery("from Regata", Regata.class).list();
        session.close();
        return regatas;
    }

    @Override
    public void actualizar(Regata regata) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(regata);
        transaction.commit();
        session.close();
    }

    @Override
    public void eliminar(Regata regata) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(regata);
        transaction.commit();
        session.close();
    }

}
