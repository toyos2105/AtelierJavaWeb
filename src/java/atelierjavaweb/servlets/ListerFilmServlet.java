/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atelierjavaweb.servlets;

import atelierjavaweb.entity.Film;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Formation
 */
@WebServlet(name = "ListerFilmServlet", urlPatterns = {"/lister_films"})
public class ListerFilmServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        EntityManagerFactory myPersistence = Persistence.createEntityManagerFactory("PU");
        EntityManager em = myPersistence.createEntityManager();
        
        em.getTransaction().begin();
        
        Query query = em.createQuery("SELECT f FROM Film f");
        List<Film> films = (List<Film>) query.getResultList();
        
        req.setAttribute("films", films);
        req.getRequestDispatcher("liste_films.jsp").forward(req, resp);
        
    }
    

}
