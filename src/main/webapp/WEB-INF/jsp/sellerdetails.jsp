<html>
<head>
<style>
body{
	margin:0;
	color:#6a6f8c;
	background:#c8c8c8;
	font:600 16px/18px 'Open Sans',sans-serif;
}
*,:after,:before{box-sizing:border-box}
.clearfix:after,.clearfix:before{content:'';display:table}
.clearfix:after{clear:both;display:block}
a{color:inherit;text-decoration:none}

.login-wrap{
	width:100%;
	margin:auto;
	max-width:525px;
	min-height:670px;
	position:relative;
	background:url(https://raw.githubusercontent.com/khadkamhn/day-01-login-form/master/img/bg.jpg) no-repeat center;
	box-shadow:0 12px 15px 0 rgba(0,0,0,.24),0 17px 50px 0 rgba(0,0,0,.19);
}
.login-html{
	width:100%;
	height:100%;
	position:absolute;
	padding:90px 70px 50px 70px;
	background:rgba(40,57,101,.9);
}
.ques{
    float:left;
    width:33%;
    height:10%;
    margin: 5px 5px 5px 5px;
    background-color:#0760ef;
    color:white
}
.ans{
    float:right;
    width:58%;
    height:10%;
    margin:5px 5px 5px 5px;
    background-color:#4286f4;
    color:white
}

</style>
</head>
<body>
<div class="login-wrap">
	<div class="login-html">
	<input type="submit" class="ques" value="Seller Id" disabled>
	<input type="submit" class="ans" value="${sellerdetail.sellerId}" disabled>
	<input type="submit" class="ques" value="Seller Name" disabled>
	<input type="submit" class="ans" value="${sellerdetail.sellerName}" disabled>
	<input type="submit" class="ques" value="Company Name" disabled>
	<input type="submit" class="ans" value="${sellerdetail.companyName}" disabled>
	<input type="submit" class="ques" value="Address" disabled>
	<input type="submit" class="ans" value="${sellerdetail.address}" disabled>
	<input type="submit" class="ques" value="Email" disabled>
	<input type="submit" class="ans" value="${sellerdetail.email}" disabled>
	<input type="submit" class="ques" value="Contact Number" disabled>
	<input type="submit" class="ans" value="${sellerdetail.contactNumber}" disabled>
	<input type="submit" class="ques" value="GSTIN" disabled>
	<input type="submit" class="ans" value="${sellerdetail.gstin}" disabled>
	<input type="submit" class="ques" value="Status" disabled>
	<input type="submit" class="ans" value="${sellerdetail.status}" disabled>
	</div>
</div>
</body>
</html>