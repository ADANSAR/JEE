
<%@page contentType="text/html" pageEncoding="iso-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
        <title>R�capitulatif</title>
    </head>

    <body>
        <center>
            <h1>R�capitulatif de vos saisies</h1>
        </center>

        <p>
            <%
                // R�cup�ration des param�tres
                String titre = request.getParameter("titre");
                String auteur = request.getParameter("auteur");
                String parution = request.getParameter("annee");
                String qte = request.getParameter("qte");

                boolean erreur = false;

                // Affichage des param�tres (et v�rification)
                if(titre.isEmpty()){
                    erreur = true;
                    out.println("Veuillez saisir le titre du livre.");
                } else {
                    out.println("Titre saisi : " + titre);
                }

                out.println("<br/><br/>");

                if(auteur.isEmpty()){
                    erreur = true;
                    out.println("Veuillez indiquer l'auteur du livre.");
                } else {
                    out.println("Auteur saisie : " + auteur);
                }

                out.println("<br/><br/>");

                if(parution.isEmpty()){
                    erreur = true;
                    out.println("Veuillez indiquer la date de parution.");
                } else {
                    out.println("Date de parution saisie : " + parution);
                }


                out.println("<br/><br/>");

                if(qte.isEmpty()){
                    erreur = true;
                    out.println("Veuillez indiquer la quantit� du livre.");
                } else {
                    out.println("Quantit� saisie : " + qte);
                }


                // On affiche le r�sultat (saisie correcte ou non) et on affiche un lien
                if(erreur){
                    out.println("Saisie incorrecte, veuillez remplir tout les champs.");
                    out.println("<br/></br>");

                    out.println("<a href=\"retour.html\">R�essayer</a>");
                } else {
                    out.println("<br/></br>");
                    out.println("Saisie valid�e.");
                }

                out.println("<br/></br>");
                out.println("<a href=\"/\">Retour � l'accueil</a>");
            %>

            <form method="POST">
                Titre<br/><input type="text" value="<%= titre %>" name="titre" required="required"/>
                <br/>
                Nom de l'auteur<br/><input type="text" value="<%= auteur %>" name="auteur" required="required"/>
                <br/>
                Ann�e de parution<br/><input type="text" value="<%= parution %>" name="annee" required="required"/>
                <br/>
                Quantit�<br/><input type="text" value="<%= qte %>" name="qte" required="required"/>
                <br/>
                <input type="submit" value="Update">
                <input type="submit" value="ADD" formaction="/books">
            </form>
        </p>
    </body>
</html>
