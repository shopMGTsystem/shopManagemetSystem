<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="zh">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" />
<title>修改密码 - 超市会员管理系统</title>
<link rel="icon" href="favicon.ico" type="image/ico">
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/materialdesignicons.min.css" rel="stylesheet">
<link href="css/style.min.css" rel="stylesheet">
<link href="css/layer.css" rel="stylesheet">
</head>
  
<body>
<div class="lyear-layout-web">
  <div class="lyear-layout-container">
    <!--左侧导航-->
    <aside class="lyear-layout-sidebar">
       
      <!-- logo -->
      <div id="logo" class="sidebar-header">
        <a href="user_homepage.jsp"><img src="images/logo-sidebar.png" title="shop_member_MGT" alt="LightYear" /></a>
      </div>
      <div class="lyear-layout-sidebar-scroll">
        
        <nav class="sidebar-main">
          <ul class="nav nav-drawer">
            <li class="nav-item active"> <a href="user_homepage.jsp"><i class="mdi mdi-home"></i> 首页</a> </li>
            <li class="nav-item"><a href="user_card_info.jsp"><i class="mdi mdi-credit-card"></i> 会员卡信息</a></li>
            <li class="nav-item"><a href="user_shop.jsp"><i class="mdi mdi-shopping"></i> 商品一览</a></li>
            <li class="nav-item"><a href="user_shoppingcar.jsp"><i class="mdi mdi-cart-outline"></i> 购物车</a></li>
            <li class="nav-item"><a href="user_purchase_history.jsp"><i class="mdi mdi-file-document-box"></i> 消费记录</a></li>
            <li class="nav-item"><a href="user_guestbook.jsp"><i class="mdi mdi-comment-text-outline"></i> 留言板</a></li>
          </ul>
        </nav>
        
        <div class="sidebar-footer">
          <p class="copyright">Copyright &copy; 2020.snow . All rights reserved. </p>
        </div>
      </div>
      
    </aside>
    <!--End 左侧导航-->
    
    <!--头部信息-->
    <header class="lyear-layout-header">
      
      <nav class="navbar navbar-default">
        <div class="topbar">
          
          <div class="topbar-left">
            <div class="lyear-aside-toggler">
              <span class="lyear-toggler-bar"></span>
              <span class="lyear-toggler-bar"></span>
              <span class="lyear-toggler-bar"></span>
            </div>
            <span class="navbar-page-title"> 修改密码 </span>
          </div>
          
          <ul class="topbar-right">
            <li class="dropdown dropdown-profile">
              <a href="javascript:void(0)" data-toggle="dropdown">
                <span><%=session.getAttribute("username")%><span class="caret"></span></span>
              </a>
              <ul class="dropdown-menu dropdown-menu-right">
                <li> <a href="user_profile.jsp"><i class="mdi mdi-account"></i> 个人信息</a> </li>
                <li> <a href="user_edit_pwd.jsp"><i class="mdi mdi-lock-outline"></i> 修改密码</a> </li>
                <li class="divider"></li>
                <li> <a href="javascript:location.href='user/logout'"><i class="mdi mdi-logout-variant"></i> 退出登录</a> </li>
              </ul>
            </li>
            <!--切换主题配色-->
		    <li class="dropdown dropdown-skin">
			  <span data-toggle="dropdown" class="icon-palette"><i class="mdi mdi-palette"></i></span>
			  <ul class="dropdown-menu dropdown-menu-right" data-stopPropagation="true">
                <li class="drop-title"><p>主题</p></li>
                <li class="drop-skin-li clearfix">
                  <span class="inverse">
                    <input type="radio" name="site_theme" value="default" id="site_theme_1" checked>
                    <label for="site_theme_1"></label>
                  </span>
                  <span>
                    <input type="radio" name="site_theme" value="dark" id="site_theme_2">
                    <label for="site_theme_2"></label>
                  </span>
                  <span>
                    <input type="radio" name="site_theme" value="translucent" id="site_theme_3">
                    <label for="site_theme_3"></label>
                  </span>
                </li>
			    <li class="drop-title"><p>LOGO</p></li>
				<li class="drop-skin-li clearfix">
                  <span class="inverse">
                    <input type="radio" name="logo_bg" value="default" id="logo_bg_1" checked>
                    <label for="logo_bg_1"></label>
                  </span>
                  <span>
                    <input type="radio" name="logo_bg" value="color_2" id="logo_bg_2">
                    <label for="logo_bg_2"></label>
                  </span>
                  <span>
                    <input type="radio" name="logo_bg" value="color_3" id="logo_bg_3">
                    <label for="logo_bg_3"></label>
                  </span>
                  <span>
                    <input type="radio" name="logo_bg" value="color_4" id="logo_bg_4">
                    <label for="logo_bg_4"></label>
                  </span>
                  <span>
                    <input type="radio" name="logo_bg" value="color_5" id="logo_bg_5">
                    <label for="logo_bg_5"></label>
                  </span>
                  <span>
                    <input type="radio" name="logo_bg" value="color_6" id="logo_bg_6">
                    <label for="logo_bg_6"></label>
                  </span>
                  <span>
                    <input type="radio" name="logo_bg" value="color_7" id="logo_bg_7">
                    <label for="logo_bg_7"></label>
                  </span>
                  <span>
                    <input type="radio" name="logo_bg" value="color_8" id="logo_bg_8">
                    <label for="logo_bg_8"></label>
                  </span>
				</li>
				<li class="drop-title"><p>头部</p></li>
				<li class="drop-skin-li clearfix">
                  <span class="inverse">
                    <input type="radio" name="header_bg" value="default" id="header_bg_1" checked>
                    <label for="header_bg_1"></label>                      
                  </span>                                                    
                  <span>                                                     
                    <input type="radio" name="header_bg" value="color_2" id="header_bg_2">
                    <label for="header_bg_2"></label>                      
                  </span>                                                    
                  <span>                                                     
                    <input type="radio" name="header_bg" value="color_3" id="header_bg_3">
                    <label for="header_bg_3"></label>
                  </span>
                  <span>
                    <input type="radio" name="header_bg" value="color_4" id="header_bg_4">
                    <label for="header_bg_4"></label>                      
                  </span>                                                    
                  <span>                                                     
                    <input type="radio" name="header_bg" value="color_5" id="header_bg_5">
                    <label for="header_bg_5"></label>                      
                  </span>                                                    
                  <span>                                                     
                    <input type="radio" name="header_bg" value="color_6" id="header_bg_6">
                    <label for="header_bg_6"></label>                      
                  </span>                                                    
                  <span>                                                     
                    <input type="radio" name="header_bg" value="color_7" id="header_bg_7">
                    <label for="header_bg_7"></label>
                  </span>
                  <span>
                    <input type="radio" name="header_bg" value="color_8" id="header_bg_8">
                    <label for="header_bg_8"></label>
                  </span>
				</li>
				<li class="drop-title"><p>侧边栏</p></li>
				<li class="drop-skin-li clearfix">
                  <span class="inverse">
                    <input type="radio" name="sidebar_bg" value="default" id="sidebar_bg_1" checked>
                    <label for="sidebar_bg_1"></label>
                  </span>
                  <span>
                    <input type="radio" name="sidebar_bg" value="color_2" id="sidebar_bg_2">
                    <label for="sidebar_bg_2"></label>
                  </span>
                  <span>
                    <input type="radio" name="sidebar_bg" value="color_3" id="sidebar_bg_3">
                    <label for="sidebar_bg_3"></label>
                  </span>
                  <span>
                    <input type="radio" name="sidebar_bg" value="color_4" id="sidebar_bg_4">
                    <label for="sidebar_bg_4"></label>
                  </span>
                  <span>
                    <input type="radio" name="sidebar_bg" value="color_5" id="sidebar_bg_5">
                    <label for="sidebar_bg_5"></label>
                  </span>
                  <span>
                    <input type="radio" name="sidebar_bg" value="color_6" id="sidebar_bg_6">
                    <label for="sidebar_bg_6"></label>
                  </span>
                  <span>
                    <input type="radio" name="sidebar_bg" value="color_7" id="sidebar_bg_7">
                    <label for="sidebar_bg_7"></label>
                  </span>
                  <span>
                    <input type="radio" name="sidebar_bg" value="color_8" id="sidebar_bg_8">
                    <label for="sidebar_bg_8"></label>
                  </span>
				</li>
			  </ul>
			</li>
            <!--切换主题配色-->
          </ul>
          
        </div>
      </nav>
      
    </header>
    <!--End 头部信息-->
    
    <!--页面主要内容-->
    <main class="lyear-layout-content">
      
      <div class="container-fluid">
        
        <div class="row">
          <div class="col-lg-12">
            <div class="card">
              <div class="card-body">
                
                <form method="post" action="#!" class="site-form">
                  <div class="form-group">
                    <label for="old-password">旧密码</label>
                    <span id="old_password_hint" style="font-size: 10px; color: orangered; display: none;">(最少6位，包括至少1个大写字母，1个小写字母，1个数字)</span>
                    <input type="password" class="form-control" name="oldpwd" id="old-password" placeholder="请输入原密码">
                  </div>
                  <div class="form-group">
                    <label for="new-password">新密码</label>
                    <span id="new_password_hint" style="font-size: 10px; color: orangered; display: none;">(最少6位，包括至少1个大写字母，1个小写字母，1个数字)</span>
                    <input type="password" class="form-control" name="newpwd" id="new-password" placeholder="请输入新密码">
                  </div>
                  <div class="form-group">
                    <label for="confirm-password">确认新密码</label>
                    <span id="confirm_password_hint" style="font-size: 10px; color: orangered; display: none;">(两次密码输入不一致)</span>
                    <input type="password" class="form-control" name="confirmpwd" id="confirm-password" placeholder="请再次输入新密码">
                  </div>
                  <button type="button" class="btn btn-primary" id="changepwd">修改密码</button>
                </form>
       
              </div>
            </div>
          </div>
          
        </div>
        
      </div>
      
    </main>
    <!--End 页面主要内容-->
  </div>
</div>

<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/perfect-scrollbar.min.js"></script>
<script type="text/javascript" src="js/main.min.js"></script>
<script type="text/javascript" src="js/layer.js"></script>
<script type="text/javascript">
	
$(document).ready(function() {
	$('#changepwd').attr("disabled",true);
	/*
	if(old_password_test() && new_password_test()  && password_same()){
		alert("1");
		$('#changepwd').attr("disabled",false);
	}*/

});
//修改密码点击事件
$("#changepwd").on('click',function(){

	var oldpwd = $('#old-password').val();
	var newpwd = $('#new-password').val();
	var confirmpwd = $('#confirm-password').val();
	
	var params1 = {
		username:'<%=session.getAttribute("username")%>',
		oldpwd:oldpwd
	}
	
	var params2 = {
		username:'<%=session.getAttribute("username")%>',
		newpwd:newpwd
	}
	
	$.post("user/checkPwd", params1 ,function(result){
		//检查旧密码是否与数据库中密码一致
  		if (result == 1) {
  			//检查两次新密码输入是否一直
  			if (newpwd == confirmpwd){
  				//将新密码传入数据库
				$.post("user/updatePwd",params2,function(data){
			  		if (data) {
			  			layer.msg("修改密码成功",{time:3000});
			  			window.location.reload();
  					} else {
  						layer.msg("修改密码失败",{time:3000});
  						window.location.reload()
  					}
			  	});
			} else {
				layer.msg("两次新密码输入不一致，请重新输入",{time:3000});	
				$("#new-password").val('');
				$("#confirm-password").val('');
			}
  			
		}else{
			layer.msg("旧密码不正确，请重新输入",{time:3000});
			$("#old-password").val('');
			$("#new-password").val('');
			$("#confirm-password").val('');
		}
  	});
  	
});

//检查旧密码格式是否正确
function old_password_test(){
	//密码正则，最少6位，包括至少1个大写字母，1个小写字母，1个数字
	var pPattern = /^.*(?=.{6,})(?=.*\d)(?=.*[A-Z])(?=.*[a-z]).*$/;
	var password = $("#old-password").val();
	//密码格式验证
	var ptest = pPattern.test(password);
	
	if(ptest && password != ''){
		$("#old_password_hint").css("display","none");
	//	$('#changepwd').attr("disabled",true);
		return true;
	}else{
		$("#old_password_hint").css("display","inline");
	//	$('#changepwd').attr("disabled",true);
		return false;
	}
	return false;
}

//检查新密码格式是否正确
function new_password_test(){
	//密码正则，最少6位，包括至少1个大写字母，1个小写字母，1个数字
	var pPattern = /^.*(?=.{6,})(?=.*\d)(?=.*[A-Z])(?=.*[a-z]).*$/;
	var password = $("#new-password").val();
	//密码格式验证
	var ptest = pPattern.test(password);
	
	if(ptest && password != ''){
		$("#new_password_hint").css("display","none");
	//	$('#changepwd').attr("disabled",true);
		return true;
	}else{
		$("#new_password_hint").css("display","inline");
	//	$('#changepwd').attr("disabled",true);
		return false;
	}
	return false;
}

//两次密码是否一致
function password_same(){
	var password = $('#new-password').val();
	var repassword = $('#confirm-password').val();
	
	if((password == repassword) && repassword != '') {
		$("#confirm_password_hint").css("display","none");
		$('#changepwd').attr("disabled",false);
		return true;
	}else{
		$("#confirm_password_hint").css("display","inline");
	//	$("#changepwd").attr("disabled",true);
		return false;
	}
	return false;
}

$('#old-password').blur(old_password_test);
$('#new-password').blur(new_password_test);
$('#confirm-password').blur(password_same);



</script>
</body>
</html>