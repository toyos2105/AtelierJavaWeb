/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atelierjavaweb.servlets;

import atelierjavaweb.entity.Film;
import atelierjavaweb.entity.Genre;
import java.io.IOException;
import java.nio.charset.Charset;
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
@WebServlet(name = "AjouterFilmServlet", urlPatterns = {"/ajouter_film"})
public class AjouterFilmServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        EntityManagerFactory myPersistence = Persistence.createEntityManagerFactory("PU");
        EntityManager em = myPersistence.createEntityManager();
       
        em.getTransaction().begin();
        
        Query query = em.createQuery("SELECT g FROM Genre g ORDER BY g.nom ASC");
        List<Genre> listeDesGenres = (List<Genre>) query.getResultList();
        
        req.setAttribute("genres", listeDesGenres);
        
        req.getRequestDispatcher("ajouter_film.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Film f = new Film();
 
        EntityManagerFactory myPersistence = Persistence.createEntityManagerFactory("PU");
        EntityManager em = myPersistence.createEntityManager();
        em.getTransaction().begin();
        
        f.setTitre( new String(req.getParameter("titre").getBytes(), Charset.forName("UTF-8")));
        f.setSynopsis(new String(req.getParameter("synopsis").getBytes(), Charset.forName("UTF-8")));
        f.setAnnee(Integer.valueOf(req.getParameter("annee")));
        f.setDuree(Integer.valueOf(req.getParameter("duree")));
        
        // On récupère le genre d'ID=genre_id
        
        Genre g = em.find(Genre.class, Long.valueOf(req.getParameter("genre_id")));
        f.setGenre(g);
        g.getFilms().add(f);
        
        em.persist(f);
        em.getTransaction().commit();
        resp.sendRedirect("lister_films");
    }
}
