/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas._carlosramirezroblas;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Carlos
 */
@WebServlet(name = "ContadorDeVisitasSesiones", urlPatterns = {"/ContadorDeVisitasSesiones"})
public class ContadorDeVisitasSesiones extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ContadorDeVisitasSesiones</title>");
            out.println("<link rel=\"stylesheet\" type=\"text/css\" href='" + request.getContextPath() + "/CSS/servlet.css' media=\"all\" />");
            out.println("</head>");
            out.println("<body>");
            out.println("<form action=\"ContadorDeVisitasSesiones\" method=\"post\">");
            HttpSession miSession = request.getSession();
            if (request.getParameter("marcado") != null) {
                Integer contador = 0;
                miSession.setAttribute("contador", contador);
                
               
            } 
            if(request.getParameter("Enviar")!=null){
                Integer cont =(Integer)miSession.getAttribute("contador");
                if(cont != null){
                miSession.setAttribute("contador", (cont.intValue()+1) );
                }
            }

            if (request.getParameter("Borrar") != null) {
             miSession.invalidate();
            }else if(miSession.getAttribute("contador")!=null){
            out.println("<h1>Eres el visitante numero "+ miSession.getAttribute("contador")+" </h1></br>");
            out.println("<input type=\"submit\" name=\"Enviar\" value=\"Enviar\"formaction=\"ContadorDeVisitasSesiones\" />");
            out.println("<input type=\"submit\" name=\"Borrar\" value=\"Borrar\"formaction=\"ContadorDeVisitasSesiones\" />");
            }else {
            out.println("<h1>Bienvenido al contador de visitas con sesiones</h1></br>");
            out.println("<label>Marca aqui para iniciar el contador</label>");
            out.println("<input type=\"checkbox\" name=\"marcado\" ");
            out.println("</br>");
            out.println("</br>");
            out.println("<input type=\"submit\" name=\"Enviar\" value=\"Enviar\" formaction=\"ContadorDeVisitasSesiones\" />");
            out.println("<input type=\"submit\" name=\"Borrar\" value=\"Borrar\" formaction=\"ContadorDeVisitasSesiones\" />");

            
            
            }
            out.println("</br> <a href='" + request.getContextPath() + "/index.html' > Enlace a index </a>");
            out.println("</form>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
