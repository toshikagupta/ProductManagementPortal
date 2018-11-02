<link href="//netdna.bootstrapcdn.com/bootstrap/3.0.3/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//netdna.bootstrapcdn.com/bootstrap/3.0.3/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!------ Include the above in your HEAD tag ---------->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<table class="table text-sm-center" id="tab">
                          <thead>
                                 <tr>
                                       <th>Seller id</th>
                                       <th>Seller Name</th>
                                       <th>Company Name</th>
                                       <th>Address</th>
                                       <th>Email</th>
                                       <th>Gstin</th>
                                       <th>Status</th>
                                       <th>Contact Number</th>
                                       </tr>
                                       </thead>
                                       <tbody>
	
                                       <tr>
                                              
                                              <td>${sellerdetail.sellerId}</td>
                                              <td>${sellerdetail.sellerName}</td>
                                              <td>${sellerdetail.companyName}</td>
                                              <td>${sellerdetail.address}</td>
                                              <td>${sellerdetail.email}</td>
                                              <td>${sellerdetail.gstin}</td>
                                              <td>${sellerdetail.status}</td>
                                              <td>${sellerdetail.contactNumber}</td>     
                                      
                                       </tr>
                                
                                 </tbody>
                                 </table>
                                 