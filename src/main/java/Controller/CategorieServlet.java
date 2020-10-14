package Controller;

import DAO.ICategorie;
import Entities.Categorie;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CategorieServlet", urlPatterns = "/categorie")
public class CategorieServlet extends HttpServlet {
    @EJB
    private ICategorie categorieDAO;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            String action=request.getParameter("action");
            if(action!=null){
                Categorie categorie=new Categorie();
                categorie.setLibelle(request.getParameter("libelle"));
                categorieDAO.add(categorie);
                getServletContext().getRequestDispatcher("/WEB-INF/Categorie/index.jsp").forward(request, response);
            }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            getServletContext().getRequestDispatcher("/WEB-INF/Categorie/index.jsp").forward(request, response);
            //response.getWriter().println("okey");
    }
}
