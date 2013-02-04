<!DOCTYPE HTML>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-1.9.0.min.js"></script>
</head>
<body>
	<!--  Ajax Container. DO NOT REMOVE THE DIV CONTENT  FOR AJAX ACCESS! -->
    <div id="loginModal" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
        <h3 id="myModalLabel">Login</h3>
      </div>
	
      <div class="modal-body" id = "modal-body-sign-in"><!--Modal Body === Form -->
      		<s:actionerror/>
          <form class="contact_form" id = "sign-in" action="doLogin" method="post" name="contact_form">
              <ul>    
              		<span class="required_notification"><s:actionerror/> </span>           
                  <li>
                      <label for="email">Username:</label>
                      <input ="textfield" name="userBean.username" placeholder="user123@example.com" required />
                      <span class="form_hint">Proper format "name@something.com"</span>
                  </li>
                  <li>
                      <label for="website">Password:</label>
                      <input type="password" name="userBean.password" placeholder="********" required />
                      <span class="form_hint">Minimum of 9 characters</span>
                  </li>
              </ul>
             <button type = "submit" id = "hidden-submit-login" hidden ="true">Submit</button>
            </form>
      </div>

	      <div class="modal-footer">
	        <button class="btn" data-dismiss="modal" aria-hidden="true">Cancel</button>
	        <button class="submit" id = "submit-login"type="submit">Login</button>
	      </div>
	      <script>
	      $('#submit-login').on('click',function(e){
				$('#hidden-submit-login').click();
		})</script>
    </div>
 
</body>
</html>