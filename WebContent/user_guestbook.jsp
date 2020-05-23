<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="zh">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" />
<title>留言板 - 超市会员管理系统</title>
<link rel="icon" href="favicon.ico" type="image/ico">
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/materialdesignicons.min.css" rel="stylesheet">
<link href="css/style.min.css" rel="stylesheet">
<link href="css/layer.css" rel="stylesheet">
<style>
.show-grid [class^=user] {
    padding-top: 10px;
    padding-bottom: 10px;
    background-color: #eee;
    background-color: rgba(86,61,124,.15);
    border: 1px solid #ddd;
    border: 1px solid rgba(86,61,124,.2);
}

.admin {
	margin-left: 50px;
}

.show-grid {
    margin-bottom: 15px;
}
</style>
</head>
  
<body>
<div class="lyear-layout-web">
  <div class="lyear-layout-container">
    <!--左侧导航-->
    <aside class="lyear-layout-sidebar">
      
      <!-- logo -->
      <div id="logo" class="sidebar-header">
        <a href="user_homepage.jsp"><img src="images/logo-sidebar.png" title="shop_member_MGT" alt="logo" /></a>
      </div>
      <div class="lyear-layout-sidebar-scroll"> 
        
        <nav class="sidebar-main">
          <ul class="nav nav-drawer">
            <li class="nav-item"> <a href="user_homepage.jsp"><i class="mdi mdi-home"></i> 首页</a> </li>
            <li class="nav-item"><a href="user_card_info.jsp"><i class="mdi mdi-credit-card"></i> 会员卡信息</a></li>
            <li class="nav-item"><a href="user_shop.jsp"><i class="mdi mdi-shopping"></i> 商品一览</a></li>
            <li class="nav-item"><a href="user_shoppingcar.jsp"><i class="mdi mdi-cart-outline"></i> 购物车</a></li>
            <li class="nav-item"><a href="user_purchase_history.jsp"><i class="mdi mdi-file-document-box"></i> 消费记录</a></li>
            <li class="nav-item active"><a href="user_guestbook.jsp"><i class="mdi mdi-comment-text-outline"></i> 留言板</a></li>
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
            <span class="navbar-page-title"> 留言板 </span>
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
        	  <div class="card-header">
        		<h4>留言板</h4>
        		
        		<button type="button" class="btn btn-primary pull-right" data-toggle="modal" data-target="#myModal">
                  	我要留言
                </button>
                
                
        	  </div>
        	  
        	  <div class="card-body" style="width: 100%; height:90%; overflow-y:scroll;">
        	  
	        	  <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
	                  <div class="modal-dialog" role="document">
	                    <div class="modal-content">
	                      <div class="modal-header">
	                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	                        <h4 class="modal-title" id="myModalLabel">快留下您的宝贵意见吧~</h4>
	                      </div>
	                      <div class="modal-body">
	                        <textarea style="width: 100%; height: 200px;" id="comment"></textarea>
	                      </div>
	                      <div class="modal-footer">
	                        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
	                        <button type="button" class="btn btn-primary" onclick="addComment()">点击提交</button>
	                      </div>
	                    </div>
	                  </div>
	                </div>
	                
	                <ul class="list-group" id="show">
	                	
						
						<!--<li class="list-group-item show-grid">
							<p class="user list-group-item">
								<span>用户名：kgdin</span><span class="pp2 pull-right">留言时间: 2018-09-07 21:13:40</span>
							</p>
							<p class="list-group-item list-group-item-warning">
								今天下载的WAP手机版的模板 出现的这种问题，权限啥的都修改过来
								<a class="btn btn-xs btn-default pull-right">删除</a>
							</p>
							<p class="list-group-item list-group-item-info admin">admin回复：你已Q上联系过</p>
						</li>
						                    
						<li class="list-group-item show-grid">
							<p class="user list-group-item"><i></i>
								<span>用户名：womuban</span><span class="pull-right">留言时间: 2018-06-23 12:47:03</span>
							</p>
							<p class="list-group-item">	
								妙笔阁的模板没有登录和注册啊
								<a class="btn btn-xs btn-default pull-right">删除</a>
							</p>
							<p class="list-group-item list-group-item-info admin" >admin回复：你已Q上联系过</p>
						</li>
						                    
						<li class="list-group-item show-grid">
							<p class="user"><i></i><span class="pp1">user：我可以</span><span class="pull-right">留言时间: 2018-06-03 23:42:23</span></p>
							<p class="list-group-item">不错不错..</p>
						</li>
						
						<li class="list-group-item show-grid">
							<p class="user">
								<i></i><span>user：151772</span><span class="pull-right">留言时间: 2018-05-13 15:46:45</span>
							</p>
							<p class="list-group-item">新版模板下载不了是怎么回事？</p>
							<p class="list-group-item list-group-item-info admin">admin回复：抱歉，现已经可以下载，谢谢。<span class="pp2 pull-right">回复时间: 2018-05-13 15:46:45</span></p>
						</li>                
											                    
						<li  class="list-group-item show-grid">
							<p class="user"><i></i>
								<span>user：xiao</span><span class="pull-right">留言时间: 2018-05-06 00:36:52</span>
							</p>
							<p class="list-group-item">改版了，比旧版看起来顺眼很多</p>
							<p class="list-group-item list-group-item-info admin">admin回复：嗯嗯 ^_^</p>
						</li>-->
						                    
					</ul>
        	  		</div>
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
$(document).ready(function(e) {
	$.post("guestbook/showAll",function(guestbooks){
		
		/*在表格内显示用户数据*/
	    var strlis = '';
	   
	    $.each($.parseJSON(guestbooks), function(i, guestbook) {
	    	console.log("guestbook:"+guestbook); //Object型
			str = '';
			str ='<li class="list-group-item show-grid">\n'+ 
			     '	<p class="user list-group-item">\n'+
			     '		<span>用户名：'+guestbook.user.userName+'</span>\n'+
			     '		<span class="pull-right">留言时间: '+guestbook.addtime+'</span>\n'+
			     '	</p>\n'+
			     '	<p class="list-group-item list-group-item-warning">\n'+
			     '		'+guestbook.content+'\n';
			    
			if(guestbook.user.userName == '<%=session.getAttribute("username")%>'){
	        	str += '<a class="btn btn-xs btn-default pull-right">删除</a>\n';
	        }
			 str += '	</p>\n';
			 $.ajax({
				async:false,
				url:"reply/searchOne",
				type:"post",
				dataType:"json",
				data: {gbid:guestbook.gbID},
				success:function(reply){
					
	 				 console.log("reply:"+reply);//String型
					 console.log("typeof reply:"+typeof reply); 
//	 				 console.log("reply.content:"+reply.content);
					 if(reply != null){ 
						 console.log("1");
						 str += '	<p class="list-group-item list-group-item-info admin">\n'+
					        	'		<span>admin回复：'+reply.content+'</span>\n'+
					        	'		<span class="pull-right">回复时间: '+reply.replytime+'</span>\n'+
					        	'	</p>\n';
						 console.log("2");
					 }    
				 }
			 });
			 str += '</li>\n';console.log("str:"+str);
			 strlis += str; 			
		});
	    $("#show").html(strlis);
  	});
});

//提交留言点击事件
function addComment(){

	var params = {
		comment:$('#comment').val(),
		username:'<%=session.getAttribute("username")%>'
	}
	
	$.post("guestbook/addComment", params ,function(result){
		//留言添加成功时
  		if (result) {
  			layer.msg("留言添加成功!",{time:4000});
			window.location.reload();
  			
  		//留言添加失败时	
		}else{
			layer.msg("留言添加失败，请稍后重试",{time:3000});
			window.location.reload();
		}
  	});
  	
}

</script>
</body>
</html>