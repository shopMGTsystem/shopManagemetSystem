<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="zh">

	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" />
		<title>购物车 - 超市会员管理系统</title>
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
						<a href="user_homepage.jsp"><img src="images/logo-sidebar.png" title="shop_member_MGT" alt="logo" /></a>
					</div>
					<div class="lyear-layout-sidebar-scroll">

						<nav class="sidebar-main">
							<ul class="nav nav-drawer">
								<li class="nav-item">
									<a href="user_homepage.jsp"><i class="mdi mdi-home"></i> 首页</a>
								</li>
								<li class="nav-item">
									<a href="user_card_info.jsp"><i class="mdi mdi-credit-card"></i> 会员卡信息</a>
								</li>
								<li class="nav-item">
									<a href="user_shop.jsp"><i class="mdi mdi-shopping"></i> 商品一览</a>
								</li>
								<li class="nav-item active">
									<a href="user_shoppingcar.jsp"><i class="mdi mdi-cart-outline"></i> 购物车</a>
								</li>
								<li class="nav-item">
									<a href="user_purchase_history.jsp"><i class="mdi mdi-file-document-box"></i> 消费记录</a>
								</li>
								<li class="nav-item">
									<a href="user_guestbook.jsp"><i class="mdi mdi-comment-text-outline"></i> 留言板</a>
								</li>
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
								<span class="navbar-page-title"> 购物车 </span>
							</div>

							<ul class="topbar-right">
								<li class="dropdown dropdown-profile">
									<a href="javascript:void(0)" data-toggle="dropdown">

										<span><%=session.getAttribute("username")%> <span class="caret"></span></span>
									</a>
									<ul class="dropdown-menu dropdown-menu-right">
										<li>
											<a href="user_profile.jsp"><i class="mdi mdi-account"></i> 个人信息</a>
										</li>
										<li>
											<a href="user_edit_pwd.jsp"><i class="mdi mdi-lock-outline"></i> 修改密码</a>
										</li>
										<li class="divider"></li>
										<li>
											<a href="javascript:location.href='user/logout'"><i class="mdi mdi-logout-variant"></i> 退出登录</a>
										</li>
									</ul>
								</li>
								<!--切换主题配色-->
								<li class="dropdown dropdown-skin">
									<span data-toggle="dropdown" class="icon-palette"><i class="mdi mdi-palette"></i></span>
									<ul class="dropdown-menu dropdown-menu-right" data-stopPropagation="true">
										<li class="drop-title">
											<p>主题</p>
										</li>
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
										<li class="drop-title">
											<p>LOGO</p>
										</li>
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
										<li class="drop-title">
											<p>头部</p>
										</li>
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
										<li class="drop-title">
											<p>侧边栏</p>
										</li>
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
									<div class="input-group">

									</div>
									<div class="card-toolbar clearfix">
										<span>总价：</span><span id="total_price"></span>
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										<span>预计可获得积分：</span><span id="total_point"></span>
										<div class="toolbar-btn-action pull-right ">
											<a class="btn btn-primary m-r-5" href="" onclick="buyChecked()"><i class="mdi mdi-plus"></i> 购买</a>
											<a class="btn btn-danger" href="" onclick="delChecked()"><i class="mdi mdi-window-close"></i> 删除</a>
										</div>
									</div>

									<div class="card-body">
										<div class="table-responsive">
											<table class="table table-hover">
												<thead>
													<tr>
														<th>
															<label class="lyear-checkbox checkbox-primary">
                            <input type="checkbox" id="check-all"><span></span>
                          </label>
														</th>
														<th>商品名称</th>
														<th>单价</th>
														<th>购买数量</th>
														<th>总价</th>
														<th>可获积分</th>
														<th>操作</th>
													</tr>
												</thead>
												<tbody id="carTable">

													<!-- 此处插入从数据库传来的商品数据 -->

												</tbody>
											</table>
										</div>
										<!-- 分页模块开始-->
										<nav>
											<ul class="pagination pagination-circle" id="pagelist">
												<!--
							                    <li class="disabled">
							                      <a href="#!">
							                        <span><i class="mdi mdi-chevron-left"></i></span>
							                      </a>
							                    </li>
							                    <li class="active"><a href="#">1</a></li>
							                    <li><a href="#!">2</a></li>
							                    <li><a href="#!">3</a></li>
							                    <li><a href="#!">4</a></li>
							                    <li><a href="#!">5</a></li>
							                    <li>
							                      <a href="#!">
							                        <span><i class="mdi mdi-chevron-right"></i></span>
							                      </a>
							                    </li>
							                    -->
											</ul>
										</nav>
										<!-- 分页模块结束-->
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
		<!--对话框-->
		<script src="js/jconfirm/jquery-confirm.min.js"></script>
		<script type="text/javascript">
			$(document).ready(function(e) {

				//搜索栏
				$('.search-bar .dropdown-menu a').click(function() {
					var field = $(this).data('field') || '';
					$('#search-field').val(field);
					$('#search-btn').html($(this).text() + ' <span class="caret"></span>');
				});

				//分页、商品展示
				carLoad(null);
			});
			
			

			//加载函数 显示分页效果
			function carLoad(currentPage) {
				var params = {
					currentPage: currentPage,
					username: '<%=session.getAttribute("username")%>'
				}
				//1.通过ajax获取后台数据展示所有路线
				$.getJSON("shoppingCar/findAllShoppingCar", params, function(pb) {
					//解析pageBean对象，展示到页面上
					//1.1 分页工具条的数据展示
					var lis = "";

					var firsPage = '<li class="disabled"><span>«</span></li>\n' +
						'<li onclick="javascript:carLoad(' + 1 + ')"><span>首页</span></li>';
					//计算上一页的页码
					var beforeNum = pb.currentPage - 1;
					if(beforeNum <= 0) {
						beforeNum = 1;
					}
					var beforePage = '<li onclick="carLoad(' + beforeNum + ')"><a href="javascript:void(0)">上一页</a></li>';
					lis += firsPage;
					lis += beforePage;
					//1.2 展示分页页码的详细情况

					//1.2.1定义开始位置begin,结束位置end
					var begin; //开始位置
					var end; //结束位置

					//1.2.2显示10个页码
					if(pb.totalPage < 10) {
						begin = 1;
						end = pb.totalPage;
					} else {
						//1.2.2.1一共显示十个页码，效果是前五后四
						begin = pb.currentPage - 5;
						end = pb.currentPage + 4;

						//1.2.2.2如果前面不够5个，后面补齐10个
						if(begin < 1) {
							begin = 1;
							end = 10;
						}

						//1.2.2.3如果后面不够四个，前面补齐十个
						if(end > pb.totalPage) {
							end = pb.totalPage;
							begin = end - 9;
						}
					}
					var li = "";
					for(var i = begin; i <= end; i++) {
						//1.2.3 当前页码是否等于i
						if(pb.currentPage == i) {
							li = '<li class="active" onclick="javascript:carLoad(' + i + ')"><a href="javascript:void(0)">' + i + '</a></li>';
						} else {
							//创建页码的li
							li = '<li onclick="javascript:carLoad(' + i + ')"><a href="javascript:void(0)">' + i + '</a></li>';
						}
						lis += li;
					}

					//计算下一页的页码
					var nextNum = pb.currentPage + 1;
					if(nextNum >= pb.totalPage) {
						nextNum = pb.totalPage;
					}
					var nextPage = '<li onclick="javascript:carLoad(' + nextNum + ')"><a href="javascript:">下一页</a></li>';
					var lastPage = '<li onclick="javascript:carLoad(' + pb.totalPage + ')"><a href="javascript:">末页</a></li>\n' +
						'                                                    <li><a href="javascript:void(0)">»</a></li>';
					lis += nextPage;
					lis += lastPage;
					//1.2.4 将lis的内容设置到ul中
					$('#pagelist').html(lis);

					/*在表格内显示用户数据*/
					var strlis = '';
					$.each(pb.list, function(i, car) {
						$.getJSON("goods/findGoodsByGid", {
							gID: car.gID
						}, function(goods) {
							var totalprice = (goods.gPrice * car.sCount).toFixed(2);
							str = '';
							str = '<tr>\n' +
								'	<td>' +
								'		<label class="lyear-checkbox checkbox-primary">' +
								'			<input type="checkbox" name="ids" value="' + car.gID + '"><span></span>' +
								'		</label>' +
								'   </td>\n' +
								'	<td>' + goods.gName + '</td>\n' +
								'	<td>' + goods.gPrice + '</td>\n' +
								'	<td>' + car.sCount + '</td>\n' +
								'	<td name="totalPrice">' + totalprice + '</td>\n' +
								'	<td name="totalPoint">' + (goods.gPoint * car.sCount) + '</td>\n' +
								'   <td>\n' +
								'   	<div class="btn-group">\n' +
								// '     		<a class="btn btn-xs btn-default" href="#!" title="添加到购物车" data-toggle="tooltip"><i class="mdi mdi-plus"></i></a>\n'+
								'      		<a class="btn btn-xs btn-default" id="' + goods.gID + '" href="" title="删除" data-toggle="tooltip" onclick="delShoppingCar(' + goods.gID + ')">\n' +
								'				<i class="mdi mdi-window-close"></i>\n' +
								'			</a>\n' +
								'    	</div>\n' +
								'  	</td>\n' +
								'</tr>\n';
							$("#carTable").append(str);
						});
					});
					$("#carTable").html(strlis);
				});
			}

			//获取复选框
			function checked() {
				var ids = document.getElementsByName("ids");
				
				var list = [];
				var tprice = 0;
				var tpoint = 0;
				for(var i = 0; i < ids.length; i++) {
					if(ids[i].checked) {
						var tr = ids[i].parentNode.parentNode.parentNode;
						$(tr).find("td").each(function(){
							if (this.getAttribute("name") === "totalPrice") {
								tprice += parseFloat(this.innerHTML);
							}
							if (this.getAttribute("name") === "totalPoint") {
								tpoint += parseFloat(this.innerHTML);
							}
						});
						list.push(ids[i].value);
					}
				}
				$("#total_price").html(tprice);
				$("#total_point").html(tpoint);
				return list;
			}
			
			//每隔一秒刷新总价和总积分函数
			setInterval(checked,1);
			
			//购买 点击事件
			function buyChecked(){
				var list = JSON.stringify(checked());
				
				var params = {
						username:'<%=session.getAttribute("username")%>',
						list:list			
					}
				
				$.post("purchaseHistory/addHistory",params,function(data){
					
					if (data) {
					
						layer.msg("购买成功!",{time:4000});
						window.location.reload();
						
					}else{
						
						layer.msg("购买失败",{time:4000});
						window.location.reload();
					}
				});
			}
			
			//test
			/*
			function f() {
				var list = JSON.stringify(checked());
				console.log(list);
			}*/

			//删除确认
			function delConfirm(gid) {
				$.confirm({
					title: '提示',
					content: '你确定要删除吗？',
					type: 'orange',
					typeAnimated: false,
					buttons: {
						confirm: {
							text: '确认',
							action: delShoppingCar(gid)
						},
						cancel: {
							text: '取消'
						}
					}
				});
			}

			//删除购物车 点击事件
			function delShoppingCar(gid) {

				var params = {
					username: '<%=session.getAttribute("username")%>',
					gid: gid
				}

				$.post("shoppingCar/delShoppingCar", params, function(data) {

					if(data) {

						layer.msg("删除成功!", {
							time: 4000
						});
						//	window.location.reload();

					} else {

						layer.msg("删除失败", {
							time: 4000
						});
						//	window.location.reload();
					}
				});

			}
		</script>
	</body>

</html>