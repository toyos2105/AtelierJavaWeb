/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atelierjavaweb.servlets;

import atelierjavaweb.entity.Pays;
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
@WebServlet(name = "ListerPaysServlet", urlPatterns = {"/lister_pays"})
public class ListerPaysServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        EntityManagerFactory myPersistence = Persistence.createEntityManagerFactory("PU");
        EntityManager em = myPersistence.createEntityManager();
       
        em.getTransaction().begin();
        
        Query query = em.createQuery("SELECT p FROM Pays p ORDER BY p.nom ASC");
        List<Pays> listeDesPays = (List<Pays>) query.getResultList();
        
        req.setAttribute("pays", listeDesPays);
        req.getRequestDispatcher("liste_pays.jsp").forward(req, resp);
    }

   
    
    
    
}
