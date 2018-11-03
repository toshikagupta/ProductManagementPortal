<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style type="text/css">
#container {
    width: 100%;
    margin: 5em auto;
    padding: 0;
    background:#fff;
}

.items {
    max-width:300px;
    height:300px;
    background:#ECECEC;
}

#left, #right { 
    margin: 30px;
}
.simages{
    width: 50px;
    height: 50px;

}
.simages ul{
    list-style: none;
    margin: 2px;
}

.change img{
	src:url("${productdetail.primaryImage}");
}

</style>
<script>
function pictureChange()
{
document.getElementById('carousel').src="http://31.media.tumblr.com/fca646cd8fe87906e605ad7e8d039903/tumblr_mmoz4fWT6U1soh1p8o1_500.png";
}
</script>
</head>
<body>
<div class="container">
<div *ngIf="product">

<ul class="nav nav-pills nav-justified">
    <li class="nav-item">
        <a  href="/productdetails">All Products</a>
    </li>
  </ul>

</div>

  <div class="row">
    <div class="col-md-1 simages">
      
      <c:forEach var="image" items="${secondaryimages}">
          
          <img src="${image}" height="50px" width="50px" onclick="pictureChange()">
         
        </c:forEach>
      

    </div>
    <div class="col-md-3 change">
      <img src="${productdetail.primaryImage}" height="400px" width="250px" id="carousel">

    </div>
    <div class="col-md-8">
      <h1>${productdetail.productName}</h1>
      <p>Desription: ${productdetail.shortDesc}</p>

      <table class="table">
        <thead>
          <tr>
            <th>MRP</th>
            <th>SSP</th>
            <th>YMP</th>
          </tr>

        </thead>
        <tbody>
          <tr>
            <td>${productdetail.mrp}</td>
            <td>${productdetail.ssp}</td>
            <td>${productdetail.ymp}</td>
          </tr>

        </tbody>
      </table>

      <p>${productdetail.dimensions}</p>
      <p>${productdetail.longDesc}</p>
      <!-- <a *ngIf="!longDesc" (click)="setDesc()"> More Details</a><br> -->

      <a >Download Pdf Manual&nbsp;&nbsp;</a>
      

    </div>

  </div>

</div>
</body>
</html>
