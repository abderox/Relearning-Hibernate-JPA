package com.example.demo1.web;

import com.example.demo1.entities.Produit;
import com.example.demo1.serices.ProduitService;
import com.example.demo1.serices.ProduitServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "produits",urlPatterns = "*.php")
public class ControllerServlet extends HttpServlet {
ProduitService produitService;
    @Override
    public void init() throws ServletException {
        produitService = new ProduitServiceImpl();
        produitService.initialize();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String path = req.getServletPath();

        System.out.println("***************** "+path);
        if(path.equals("/catalogue.php") && req.getMethod().equals("GET"))
        {
            List<Produit> produits = produitService.findAllProduits();
            req.setAttribute("produits",produits);
            req.getRequestDispatcher("views/produits.jsp").forward(req,resp);
        }
        else if(path.equals("/search.php") && req.getMethod().equals("GET"))
        {
            String keyword = req.getParameter("keyword");
            System.out.println("***************** "+keyword);

            List<Produit> produits = produitService.findByName(keyword);
            req.setAttribute("key",keyword);
            req.setAttribute("produits",produits);
            req.getRequestDispatcher("views/produits.jsp").forward(req,resp);

        }
        else if(path.equals("/delete.php"))
        {
            String id = req.getParameter("idx");
             produitService.delete(Long.parseLong(id));
            List<Produit> produits = produitService.findAllProduits();
            req.setAttribute("produits",produits);
            req.getRequestDispatcher("views/produits.jsp").forward(req,resp);

        }
        else if(path.equals("/ajouter.php") && req.getMethod().equals("GET"))
        {
            String designation = req.getParameter("designation");
            double prix =  Double.parseDouble(req.getParameter("prix"));
            System.out.println("************"+req.getParameter("prix") );
            produitService.save(new Produit(null, designation, prix));
            List<Produit> produits = produitService.findAllProduits();
            req.setAttribute("produits",produits);
            req.getRequestDispatcher("views/produits.jsp").forward(req,resp);

        }
        else if(path.equals("/modifier.php") && req.getMethod().equals("GET"))
        {
            String designation = req.getParameter("designationModif");
            double prix =  Double.parseDouble(req.getParameter("prixModif"));
            Long idP = Long.parseLong(req.getParameter("idP"));
            produitService.update(new Produit(idP, designation, prix));
            List<Produit> produits = produitService.findAllProduits();
            req.setAttribute("produits",produits);
            req.getRequestDispatcher("views/produits.jsp").forward(req,resp);

        }
        else {
            resp.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
