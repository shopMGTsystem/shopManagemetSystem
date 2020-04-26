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
            <li class="nav-item"><a href="user_card_info.jsp"><i class="mdi mdi-file-account"></i> 会员卡信息</a></li>
            <li class="nav-item"><a href="user_shop.jsp"><i class="mdi mdi-shopping"></i> 商品一览</a></li>
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
            	</div>
							<div class="lyshow">
						    <ul>
											<li>
												<p class="username"><i></i><span class="pp1">user：kgdin</span><span class="pp2">留言时间: 2018-09-07 21:13:40</span></p><p class="lytext">今天下载的WAP手机版的模板 出现的这种问题，权限啥的都修改过来</p>
											</li>	
											<li>
												<p class="username"><i></i><span class="pp1">user：womuban</span><span class="pp2">留言时间: 2018-06-23 12:47:03</span></p><p class="lytext">妙笔阁的模板没有登录和注册啊</p>
												<p class="regbook">17模板回复：你已Q上联系过</p>
											</li>
						    
											<li>
												<p class="username"><i></i><span class="pp1">user：我可以</span><span class="pp2">留言时间: 2018-06-03 23:42:23</span></p><p class="lytext">不错不错..</p>
											</li>
											                    
											<li>
												<p class="username"><i></i><span class="pp1">user：151772</span><span class="pp2">留言时间: 2018-05-13 15:46:45</span></p><p class="lytext">新版模板下载不了是怎么回事？</p>
												<p class="regbook">17模板回复：抱歉，现已经可以下载，谢谢。</p>
											</li>
											                    
											<li>
												<p class="username"><i></i><span class="pp1">user：开明王朝</span><span class="pp2">留言时间: 2018-05-07 12:50:35</span></p><p class="lytext">注册激活邮件收了几次才收到</p>
												<p class="regbook">17模板回复：如收不到邮件可反馈账号问题，反馈账号问题不需要登录。</p>
											</li>
											                    
											<li>
												<p class="username"><i></i><span class="pp1">user：xiao</span><span class="pp2">留言时间: 2018-05-06 00:36:52</span></p><p class="lytext">改版了，比旧版看起来顺眼很多</p>
												<p class="regbook">17模板回复：嗯嗯 ^_^</p>
											</li>
						    
										</ul>
						  	<div class="listpage"></div>
							</div>
							<div class="lypost">
            <p class="tip">请在下面输入你想说的话（您对17模板网的建议、或者意见、鼓励和支持），对所有访客可见，需登录。https://www.17mb.com/ly0.html</p>
						<form method="post" action="#!" class="site-form">
                  
                  <div class="form-group">
                    <label for="remark">想说的的话:</label>
                    <textarea class="form-control" name="remark" id="remark" rows="3"></textarea>
                  </div>
                  <div class="col-xs-7">
			            	<input type="text" name="captcha" class="form-control" placeholder="验证码">
			            	<span class="mdi mdi-check-all form-control-feedback" aria-hidden="true"></span>
			          	</div>
			          	<div class="col-xs-4">
			            	<img src="images/captcha.png" class="pull-right" id="captcha" style="cursor: pointer;" onclick="this.src=this.src+'?d='+Math.random();" title="点击刷新" alt="captcha">
			          	</div>
                  <button type="submit" class="btn btn-primary">确认提交</button>
                </form>	    
	   				<!--某网站的留言板
	   				<form action="/e/enews/index.php" method="post" name="form1" id="form1">
						-->
            	<table>
            		<tr>
            			<td class="l">想说的话：</td>
            			<td class="r"><textarea name="lytext" id="lytext"></textarea></td>
            		</tr>
            		<tr>
            			<td class="l">验证码：</td>
            			<td class="r yzm">
            				<input type=text name=key size=6>
            				<span class="s1"><img id="lykey" src="/e/ShowKey/?v=gbook" height="23" onclick="reloadcode()" title="看不清楚,点击刷新" /></span><span class="s2">点击图片刷新验证码</span>
            			</td>
            		</tr>
            		<tr>
            			<td class="l">&nbsp;</td>
            			<td class="r "><input type="submit" name="Submit3" value="确认提交" class="btn17mb"/></td>
            		</tr>
            		<tr>
            			<td>&nbsp;</td>
            			<td>&nbsp;</td>
            		</tr>
            	</table>
            	<input name="enews" type="hidden" id="enews" value="AddGbook" />
            	<input name="name" type="hidden" id="name" value="17模板会员"/>
            	<input name="email" type="hidden" id="email" value="members@17mb.com" />
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

<!--图表插件-->
<script type="text/javascript" src="js/Chart.js"></script>
<script type="text/javascript">
$(document).ready(function(e) {
    var $dashChartBarsCnt  = jQuery( '.js-chartjs-bars' )[0].getContext( '2d' ),
        $dashChartLinesCnt = jQuery( '.js-chartjs-lines' )[0].getContext( '2d' );
    
    var $dashChartBarsData = {
		labels: ['周一', '周二', '周三', '周四', '周五', '周六', '周日'],
		datasets: [
			{
				label: '注册用户',
                borderWidth: 1,
                borderColor: 'rgba(0,0,0,0)',
				backgroundColor: 'rgba(51,202,185,0.5)',
                hoverBackgroundColor: "rgba(51,202,185,0.7)",
                hoverBorderColor: "rgba(0,0,0,0)",
				data: [2500, 1500, 1200, 3200, 4800, 3500, 1500]
			}
		]
	};
    var $dashChartLinesData = {
		labels: ['2003', '2004', '2005', '2006', '2007', '2008', '2009', '2010', '2011', '2012', '2013', '2014'],
		datasets: [
			{
				label: '交易资金',
				data: [20, 25, 40, 30, 45, 40, 55, 40, 48, 40, 42, 50],
				borderColor: '#358ed7',
				backgroundColor: 'rgba(53, 142, 215, 0.175)',
                borderWidth: 1,
                fill: false,
                lineTension: 0.5
			}
		]
	};
    
    new Chart($dashChartBarsCnt, {
        type: 'bar',
        data: $dashChartBarsData
    });
    
    var myLineChart = new Chart($dashChartLinesCnt, {
        type: 'line',
        data: $dashChartLinesData,
    });
});
</script>
</body>
</html>