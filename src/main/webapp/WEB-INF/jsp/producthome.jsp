<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<style>
body {
	margin: 0;
	color: #6a6f8c;
	background: #c8c8c8;
	font: 600 16px/18px 'Open Sans', sans-serif;
}

*, :after, :before {
	box-sizing: border-box
}

.clearfix:after, .clearfix:before {
	content: '';
	display: table
}

.clearfix:after {
	clear: both;
	display: block
}

a {
	color: inherit;
	text-decoration: none
}

.login-wrap {
	width: 100%;
	height: 100%;
	margin: auto;
	position: relative;
	background:
		url(https:// raw.githubusercontent.com/khadkamhn/day-01-login-form/master/img/bg.jpg)
		no-repeat center;
	box-shadow: 0 12px 15px 0 rgba(0, 0, 0, .24), 0 17px 50px 0
		rgba(0, 0, 0, .19);
}

.login-html {
	width: 100%;
	height: 100%;
	position: absolute;
	padding: 90px 70px 50px 70px;
	background: rgba(40, 57, 101, .9);
}

.login-html .sign-in-htm, .login-html .sign-up-htm {
	top: 0;
	left: 0;
	right: 0;
	bottom: 0;
	position: absolute;
	transform: rotateY(180deg);
	backface-visibility: hidden;
	transition: all .4s linear;
}

.login-html .sign-in, .login-html .sign-up, .login-form .group .check {
	display: none;
}

.login-html .tab, .login-form .group .label, .login-form .group .button
	{
	text-transform: uppercase;
}

.login-html .tab {
	font-size: 22px;
	margin-right: 15px;
	padding-bottom: 5px;
	margin: 0 15px 10px 0;
	display: inline-block;
	border-bottom: 2px solid transparent;
}

.login-html .sign-in:checked+.tab, .login-html .sign-up:checked+.tab {
	color: #fff;
	border-color: #1161ee;
}

.login-form {
	min-height: 345px;
	position: relative;
	perspective: 1000px;
	transform-style: preserve-3d;
}

.login-form .group {
	margin-bottom: 15px;
}

.login-form .group .label, .login-form .group .input, .login-form .group .button
	{
	width: 100%;
	color: #fff;
	display: block;
}

.login-form .group .input, .login-form .group .button {
	border: none;
	padding: 15px 20px;
	border-radius: 25px;
	background: rgba(255, 255, 255, .1);
}

.login-form .group input[data-type="password"] {
	text-security: circle;
	-webkit-text-security: circle;
}

.login-form .group .label {
	color: #aaa;
	font-size: 12px;
}

.login-form .group .button {
	background: #1161ee;
}

.login-form .group label .icon {
	width: 15px;
	height: 15px;
	border-radius: 2px;
	position: relative;
	display: inline-block;
	background: rgba(255, 255, 255, .1);
}

.login-form .group label .icon:before, .login-form .group label .icon:after
	{
	content: '';
	width: 10px;
	height: 2px;
	background: #fff;
	position: absolute;
	transition: all .2s ease-in-out 0s;
}

.login-form .group label .icon:before {
	left: 3px;
	width: 5px;
	bottom: 6px;
	transform: scale(0) rotate(0);
}

.hr {
	height: 2px;
	margin: 80px 0 50px 0;
	background: rgba(255, 255, 255, .2);
}

.foot-lnk {
	text-align: center;
}

.dropbtn {
	background-color: #1161ee;
	color: white;
	padding: 16px;
	font-size: 16px;
	border: none;
	cursor: pointer;
}

/* The container <div> - needed to position the dropdown content */
.dropdown {
	position: relative;
	display: inline-block;
}

/* Dropdown Content (Hidden by Default) */
.dropdown-content {
	display: none;
	position: absolute;
	background-color: #f9f9f9;
	min-width: 160px;
	box-shadow: 0px 8px 16px 0px rgba(0, 0, 0, 0.2);
	z-index: 1;
	right: 0;
}

/* Links inside the dropdown */
.dropdown-content a {
	color: black;
	padding: 12px 16px;
	text-decoration: none;
	display: block;
}

/* Change color of dropdown links on hover */
.dropdown-content a:hover {
	background-color: #f1f1f1
}

/* Show the dropdown menu on hover */
.dropdown:hover .dropdown-content {
	display: block;
}

/*
 * Change the background color of the dropdown button when the dropdown content
 * is shown
 */
.dropdown:hover .dropbtn {
	background-color: #4286f4;
}
td a:hover{ 
	text-decoration: underline;
	color: #cccccc;
	}
</style>
</head>
<body>
	<div class="login-wrap">
		<div class="login-html">
			<label for="tab-1" class="tab">Product Details</label>
			<a href="/sellerdetails" class="tab">Seller Details</a>
			<div class="login-form">
				<form action="/approveproducts" method="post">
						<label style="color: white;">Search By:</label>
						<div class="group" style="margin-top: 5%">
							<input type="radio" name="searchp" value="productCode">
							Product Code <input type="radio" name="searchp"
								value="productName"> Product Name <input type="radio"
								name="searchp" value="productId"> Product ID
								<input type="radio"
									name="searchpf" value="status"> Status <input type="radio"
										name="searchpf" value="sellerId"> Seller Id <input type="radio"
											name="searchpf" value="companyName"> Company Name <input type="radio"
												name="searchpf" value="category"> Category
						</div>
						<div class="group">
							<input id="search" type="search" class="input" data-type="text"
								style="width: 70%; float: left" name="searchText"> <input type="submit"
								class="button" value="Search" style="width: 25%; float: right;" formaction="/searchproduct">
						</div>

						<div style="margin-top: 15%;">
							<font color="red">${errorMessage}</font>
							<table class="group" id="tab2">
								<thead>
									<tr>
										<th></th>
										<th>Product Name</th>
										<th>Status</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="productdetail" items="${product}">
										<tr>
											<td><input type="checkbox" name="selectProduct"
												value="${productdetail.productId}" id="check1"></td>
											<td><a href="products/${productdetail.productId}">${productdetail.productName}</td>
											<td>${productdetail.status}</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
						<div class="dropdown" style="float: right;">
							<button class="dropbtn" disabled>Filter By:</button>
							<div class="dropdown-content">
								<a href="/mrp">MRP</a> <a href="/ssp">SSP</a> <a href="/ymp">YMP</a> <a
									href="/time">Registration Time</a>
							</div>
						</div>
						<div class="hr"></div>
						<div class="group">
							<input type="submit" class="button" value="Approve"
								style="float: left; width: 25%"> <input
								style="float: right; width: 25%" type="submit" class="button"
								value="Reject" formaction="/rejectproducts">
						</div>
					
				</form>
			</div>
		</div>
	</div>
	
	 <c:if test="${currentPage != 1}">
        <td><a href="/viewproductpage?page=${currentPage - 1}">Previous</a></td>
    </c:if>
 
    
    <table border="1" cellpadding="5" cellspacing="5">
        <tr>
            <c:forEach begin="1" end="${noOfPages}" var="i">
                <c:choose>
                    <c:when test="${currentPage eq i}">
                        <td>${i}</td>
                    </c:when>
                    <c:otherwise>
                        <td><a href="/viewproductpage?page=${i}">${i}</a></td>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </tr>
    </table>
     
    
    <c:if test="${currentPage lt noOfPages}">
        <td><a href="/viewproductpage?page=${currentPage + 1}">Next</a></td>
    </c:if>
</body>
</html>
