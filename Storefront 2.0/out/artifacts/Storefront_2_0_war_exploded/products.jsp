<!--Access Inventory and Product classes-->
<%@ page import="edu.wctc.my.mpetermann2.Inventory" %>
<%@ page import="edu.wctc.my.mpetermann2.Product" %>

<!--Search and cart operations-->
<script><%@include file="./search.js"%></script>
<script><%@include file="./addToCart.js"%></script>

<!--Jumbotron with title-->
<div class="jumbotron">
    <h1 class="display-1">Products</h1>
</div>

<!--Search bar-->
<form id="search">
    <div class="input-group mb-3">
        <input type="text" class="form-control form-control-lg" id="searchField" placeholder="Search">
        <div class="input-group-append">
            <button class="btn btn-success"><span class="fa fa-search"></span> Search</button>
        </div>
    </div>
</form>

<div id="products" class="card-deck mb-3">
    <!--Loop through all products in the iventory-->
    <% for(Product p : Inventory.getInventory()) { %>
        <!--Create a modal window for each item-->
        <div class="modal fade" id="_<%=p.getId()%>">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h4 class="modal-title"><%=p.getName()%></h4>
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                    </div>
                    <div class="modal-body">
                        <!--Have a carousel for all images of a product-->
                        <div id="carousel_<%=p.getId()%>" class="carousel slide mb-3" data-ride="carousel" data-interval="false">
                            <ul class="carousel-indicators">
                                <% if(p.getImageUrls().length > 1) { %>
                                    <% for(int i=0; i<p.getImageUrls().length; i++) { %>
                                        <li data-target="#carousel_<%=p.getId()%>" data-slide-to="<%=i%>" class=<%= i==0 ? "active" : "" %>></li>
                                    <% } %>
                                <% } %>
                            </ul>
                            <div class="carousel-inner">
                                <% for(int i=0; i<p.getImageUrls().length; i++) { %>
                                    <div class="carousel-item <%= i==0 ? "active" : "" %>">
                                        <img class="carousel-img" src=<%=p.getImageUrls()[i]%>>
                                    </div>
                                <% } %>
                            </div>
                            <% if(p.getImageUrls().length > 1) { %>
                                <a class="carousel-control-prev" href="#carousel_<%=p.getId()%>" data-slide="prev">
                                    <span class="carousel-control-prev-icon"></span>
                                </a>
                                <a class="carousel-control-next" href="#carousel_<%=p.getId()%>" data-slide="next">
                                    <span class="carousel-control-next-icon"></span>
                                </a>
                            <% } %>
                        </div>
                        <h4>$<%=p.getPrice()%></h4>
                        <p><%=p.getDescription()%></p>
                    </div>
                    <div class="modal-footer">
                        <!--Submit a form with quantity of this item-->
                        <form class="fullAdd" method="post" data-id="<%=p.getId()%>" data-modal="#_<%=p.getId()%>">
                            <div class="input-group">
                                <div class="input-group-prepend">
                                    <label class="input-group-text" for="quantity">Qty.</label>
                                </div>
                                <input type="number" name="quantity" id="quantity" class="form-control" value="1" min="1" step="1"/>
                                <div class="input-group-append">
                                    <button class="btn btn-success"><span class="fa fa-shopping-cart"></span> Add to Cart</button>
                                </div>
                            </div>
                        </form>
                        <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
                    </div>
                </div>
            </div>
        </div>

        <!--Display a card for each product-->
        <div class="card product-card" data-title="<%=p.getName()%>">
            <img class="card-img-top" src="<%=p.getImageUrls()[0]%>"/>
            <div class="card-body">
                <h4 class="card-title"><%=p.getName()%> <small>$<%=p.getPrice()%></small></h4>
                <p class="card-text"><%=p.getSummary()%></p>
            </div>
            <div class="card-footer">
                <!--Bind each card to its respective modal-->
                <button class="btn btn-primary" data-toggle="modal" data-target="#_<%=p.getId()%>">
                    <span class="fa fa-search-plus"></span> View More
                </button>
                <!--Quick add one of this item to the cart-->
                <form class="quickAdd" data-id="<%=p.getId()%>">
                    <button class="btn btn-success">
                        <span class="fa fa-shopping-cart"></span> Quick Add
                    </button>
                </form>
            </div>
        </div>
    <% } %>
</div>