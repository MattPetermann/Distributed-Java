<script><%@include file="./cartAnimations.js"%></script>
<script><%@include file="./getCart.js"%></script>
<script><%@include file="./editCart.js"%></script>
<script><%@include file="./getBill.js"%></script>
<div class="jumbotron">
    <h1 class="display-1">Shopping Cart</h1>
</div>
<div class="container">
    <div id="bill"></div>
    <h4 id="empty">Your cart is currently empty.</h4>
    <table class="table table-striped table-bordered table-hover" id="cartTable">
        <thead>
            <th style="width: 5%"></th>
            <th style="width: 75%">Product Name</th>
            <th style="width: 10%" class="center-text">Quantity</th>
            <th style="width: 10%" class="center-text">Remove</th>
        </thead>
        <tbody id="cartList"></tbody>
    </table>
    <button class="btn btn-success" id="checkout"><span class="fa fa-dollar-sign"></span> Checkout</button>
</div>