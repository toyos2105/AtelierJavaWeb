/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atelierjavaweb.servlets;

import atelierjavaweb.entity.Film;
import java.io.IOException;
import java.nio.charset.Charset;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Formation
 */
@WebServlet(name = "AjouterFilmServlet", urlPatterns = {"/ajouter_film"})
public class AjouterFilmServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("ajouter_film.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Film f = new Film();
        
        f.setTitre( new String(req.getParameter("titre").getBytes(), Charset.forName("UTF-8")));
        f.setSynopsis(new String(req.getParameter("synopsis").getBytes(), Charset.forName("UTF-8")));
        f.setAnnee(Integer.valueOf(req.getParameter("annee")));
        f.setDuree(Integer.valueOf(req.getParameter("duree")));
        
        EntityManagerFactory myPersistence = Persistence.createEntityManagerFactory("PU");
        EntityManager em = myPersistence.createEntityManager();
        
        em.getTransaction().begin();
        em.persist(f);
        em.getTransaction().commit();
        resp.sendRedirect("lister_films");
        
    }
    
    
  

}
