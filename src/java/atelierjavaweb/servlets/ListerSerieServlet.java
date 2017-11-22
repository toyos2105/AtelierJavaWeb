/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atelierjavaweb.servlets;

import atelierjavaweb.entity.Serie;
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
@WebServlet(name = "ListerSerieServlet", urlPatterns = {"/lister_series"})
public class ListerSerieServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        EntityManagerFactory myPersistence = Persistence.createEntityManagerFactory("PU");
        EntityManager em = myPersistence.createEntityManager();
        
        em.getTransaction().begin();
        
        Query query = em.createQuery("SELECT s FROM Serie s");
        List<Serie> listeDesSeries = (List<Serie>) query.getResultList();
        
        req.setAttribute("series", listeDesSeries);
        req.getRequestDispatcher("liste_series.jsp").forward(req, resp);
        
    }
    

}
