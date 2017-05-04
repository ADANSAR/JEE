<%@ page import="car.tp4.entity.Panier" %>
<%@ page import="car.tp4.entity.Book" %>
<%@ page import="java.util.*" %>
<%@ page import="java.lang.*" %>
<%@page contentType="text/html" pageEncoding="iso-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
        <title>Home</title>
    </head>
    <body>
        <h2>Les commandes récentes</h2>
        <a href="/books">afficher tous les livres</a>
        <%
            if(request.getAttribute("commandes") != null )
                if(((HashMap<Long,List<Book>>) request.getAttribute("commandes")).size()>0){
                  for(Map.Entry<Long,List<Book>> entry : ((HashMap<Long,List<Book>>)request.getAttribute("commandes")).entrySet()) {
                      Long id = entry.getKey();
                      List<Book> commandes = entry.getValue();
                      out.print("<br/>");
                      out.print("Commande N "+id);
                      out.print("<br/>");
                      if(!(commandes.size()>0))
                      out.print("liste vide");
                       for(Book b : commandes) {
                         out.print("<br/>");
                          out.print("Author='"+b.getAuthor()+"', Title='"+b.getTitle()+"', Date='"+b.getYear()+"', Qte Acheté ="+b.getQte());
                          out.print("<br/>");
                      }
            }
          }
            else
                out.print("Vous n'avez pas encore passé des commandes");
        %>
    </body>
</html>
