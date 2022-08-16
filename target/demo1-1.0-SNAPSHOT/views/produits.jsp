<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.example.demo1.entities.Produit" %>
<%@ page import="java.util.List" %>
<%
    List<Produit> listprods = (List<Produit>) request.getAttribute("produits");
    String key = request.getAttribute("key") != null ? (String) request.getAttribute("key") : "" ;

%>
<html>
<head>
    <title>Catalogue</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css"
          integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
    <link rel="stylesheet"
          href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200"/>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.min.js"
            integrity="sha384-+sLIOodYLS7CIrQpBjl+C7nPvqq+FbNUBDunl/OZv93DB7Ln/533i8e/mZXLi/P+"
            crossorigin="anonymous"></script>
</head>
<body>


<div class="mx-auto " style="max-width: 600px; padding: 60px 10px ;">
    <h1 class="display-4">Catalogue des produits</h1>
</div>
<div class="container">


    <form method="get" action="search.php">
        <div class=" m-4 d-flex justify-content-center">
            <div class="">
                <input class="form-control me-2" name="keyword" type="text" placeholder="search by name..."
                       aria-label="Search" value=<%=key%>>
            </div>
            <div class="ml-2">
                <button class="btn btn-outline-success" type="submit">Search</button>
            </div>
        </div>
    </form>

    <div class="card text-center">
        <div class="card-header">
            Produits
        </div>
        <div class="card-body">

            <table class="table table-bordered table-striped">
                <thead class="thead-dark">
                <tr>
                    <th scope="col">Id</th>
                    <th scope="col">Name</th>
                    <th scope="col">Price</th>
                    <th scope="col" colspan="2">Actions</th>
                </tr>
                </thead>
                <tbody>
                <tr class="table-warning"> <th scope="row">Ajout</th>
                    <form method="get" action="ajouter.php">
                    <td><input class="form-control me-2" type="text" placeholder="designation ..." name="designation"></td>
                    <td><span class="material-symbols-outlined" style="margin-bottom: -2px ;">
                        shopping_cart
                        </span>
                        <input class="form-control m-2 d-inline-block" style="width:70%" type="number" min="1"
                               max="1000000" step="0.1" placeholder="prix ..." name="prix">
                        <span class="secondary-text fst-italic">MAD</span>
                    </td>
                    <td colspan="2" >  <button class="btn btn-success btn-block" type="submit">Ajouter</button> </td>
                    </form>
                </tr>
                <%
                    for (Produit produit : listprods) {%>
                <tr>
                    <form method="get" action="modifier.php">
                    <th scope="row"><%=produit.getId( )%> <input type="hidden" name="idP" value=<%=produit.getId( )%>>
                    </th>

                    <td><input class="form-control me-2" type="text" name ="designationModif" value=<%=produit.getName( )%>>
                    </td>
                    <td><span class="material-symbols-outlined" style="margin-bottom: -2px ;">
                        shopping_cart
                        </span>
                        <input class="form-control m-2 d-inline-block" style="width:70%" type="number" min="1"
                               max="1000000" step="0.1" name="prixModif" value=<%=produit.getPrice( )%>>
                        <span class="secondary-text fst-italic">MAD</span>
                    </td>
                    <td>
                        <button class="btn btn-primary" type="submit" >Update</button>
                    </td>

                    <td>
                        <a class="text-decoration-none" href="delete.php?idx=<%=produit.getId( )%>" style="cursor: pointer;"> <span
                                class="material-symbols-outlined">
                        delete_forever
                        </span> </a>

                    </td>
                    </form>
                </tr>
                <%
                    }
                %>
                </tbody>

            </table>

        </div>
        <div class="card-footer text-muted">
            All products
        </div>
    </div>

</div>
</body>
</html>
