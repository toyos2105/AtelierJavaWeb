/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atelierjavaweb.servlets;

import atelierjavaweb.entity.Personne;
import java.io.IOException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Formation
 */
@WebServlet(name = "ListerPersonneServlet", urlPatterns = {"/lister_personnes"})
public class ListerPersonneServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        EntityManagerFactory myPersistence = Persistence.createEntityManagerFactory("PU");
        EntityManager em = myPersistence.createEntityManager();

        em.getTransaction().begin();

        Query query = em.createQuery("SELECT p FROM Personne p");
        List<Personne> listeDesPersonnes = (List<Personne>) query.getResultList();

        req.setAttribute("personnes", listeDesPersonnes);
        req.getRequestDispatcher("liste_personnes.jsp").forward(req, resp);
    }

}
