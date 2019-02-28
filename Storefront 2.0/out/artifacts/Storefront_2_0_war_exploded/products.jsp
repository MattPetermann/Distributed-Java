<%@ page import="edu.wctc.my.mpetermann2.Inventory" %>
<%@ page import="edu.wctc.my.mpetermann2.Product" %>
<div class="jumbotron">
    <h1 class="display-1">Products</h1>
</div>
<div id="products" class="card-deck">
    <% for(Product p : Inventory.getInventory()) { %>
    <div class="card product-card">
        <img class="card-img-top" src="https://placehold.it/500x500"/>
        <div class="card-body">
            <h4 class="card-title"><%=p.getName()%> <small>$<%=p.getPrice()%></small></h4>
            <p class="card-text"><%=p.getDescription()%></p>
            <button class="btn btn-primary">View More</button>
            <button class="btn btn-success">Add to Cart</button>
        </div>
    </div>
    <% } %>
</div>