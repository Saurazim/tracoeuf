<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8" />
        <title>Welcome</title>
        
    </head>
    <body>
        <h1>Welcome</h1>
        <h2>${message}</h2>
        <p>
            Ceci est un ${essai}<br/>

            <%
                String attribut = (String) request.getAttribute("id");
                out.println(attribut);
            %>
        </p>
    </body>
</html>