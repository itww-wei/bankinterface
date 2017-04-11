<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../../commons/jsp/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta charset="utf-8">
  <title>银行接口</title>
  <meta charset="UTF-8">
  <meta name="renderer" content="webkit">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <title>首页</title>
  <link rel="stylesheet" href="${ctx }/css/style.css">
    
  <link rel="stylesheet" href="${ctx }/commons/layui/css/layui.css">
  <script src="${ctx }/commons/layui/layui.js"></script>
  <script>
	//一般直接写在一个js文件中
	/*layui.use(['layer', 'form'], function(){
	  var layer = layui.layer
	  ,form = layui.form();
	  
	  layer.msg('Hello World');
	});*/
	
 </script> 
</head>
<body>
  <!-- admin -->
  <div class="layui-layout layui-layout-admin">
  	<!-- header -->
    <div class="layui-header my-header">
    	 <a href="index.html">
            <div class="my-header-logo">银行接口后台管理系统</div>
        </a>
        <!-- Top 菜单导航 -->
        <ul class="layui-nav" lay-filter="top">
            <li class="layui-nav-item">
                <button class="layui-btn layui-btn-small btn-nav"><i class="layui-icon">&#xe620;</i></button>
            </li>
            <li class="layui-nav-item"><a href="javascript:;" href-url="demo/1.html">导航菜单1</a></li>
            <li class="layui-nav-item"><a href="javascript:; href-url="demo/2.html"">导航菜单2</a></li>
            <li class="layui-nav-item">
                <a href="javascript:;">导航菜单3</a>
                <dl class="layui-nav-child">
                    <dd><a href="javascript:;" href-url="demo/3-1.html">导航菜单3-1</a></dd>
                    <dd><a href="javascript:;" href-url="demo/3-2.html">导航菜单3-2</a></dd>
                    <dd><a href="javascript:;" href-url="demo/3-3.html">导航菜单3-3</a></dd>
                </dl>
            </li>
        </ul>
        
        <!-- 左上角 个人信息 -->
        <ul class="layui-nav my-header-user-nav">
            <li class="layui-nav-item"><a href="javascript:;" class="pay">支持作者</a></li>
            <li class="layui-nav-item">
                <a class="name" href="javascript:;"><img src="${ctx }/images/logo.png" alt="logo"> Admin </a>
                <dl class="layui-nav-child">
                    <dd><a href="javascript:;">个人信息</a></dd>
                    <dd><a href="javascript:;">修改密码</a></dd>
                    <dd><a href="javascript:;">退出</a></dd>
                </dl>
            </li>
        </ul>
    </div>
    
     <!-- side 左边导航栏菜单-->
    <div class="layui-side my-side">
    	 <div class="layui-side-scroll">
            <ul class="layui-nav layui-nav-tree" lay-filter="side">
            	<li class="layui-nav-item"><a href="javascript:;" href-url="${ctx }/project/project" data-type="tabAdd">项目虚拟账户管理</a></li>
            	<li class="layui-nav-item"><a href="javascript:;" href-url="${ctx }/project/testIndex" data-type="tabAdd">测试</a></li>
            	
                <li class="layui-nav-item"><a href="javascript:;" href-url="demo/btn.html" data-type="tabAdd">按钮</a></li>
                <li class="layui-nav-item"><a href="javascript:;" href-url="demo/form.html" data-type="tabAdd">表单</a></li>
                <li class="layui-nav-item"><a href="javascript:;" href-url="demo/table.html" data-type="tabAdd">表格</a></li>
                <li class="layui-nav-item"><a href="javascript:;" href-url="demo/tab-card.html" data-type="tabAdd">选项卡</a></li>
                <li class="layui-nav-item"><a href="javascript:;" href-url="demo/progress-bar.html" data-type="tabAdd">进度条</a></li>
                <li class="layui-nav-item"><a href="javascript:;" href-url="demo/folding-panel.html" data-type="tabAdd">折叠面板</a></li>
                <li class="layui-nav-item"><a href="javascript:;" href-url="demo/auxiliar.html" data-type="tabAdd">辅助元素</a></li>
                <li class="layui-nav-item layui-nav-itemed">
                    <a href="javascript:;">扩展</a>
                    <dl class="layui-nav-child">
                        <dd><a href="javascript:;" href-url="demo/login.html" data-type="tabAdd">登录页</a></dd>
                        <dd><a href="javascript:;" href-url="demo/map.html" data-type="tabAdd">图表</a></dd>
                        <dd><a href="javascript:;" href-url="demo/add-edit.html" data-type="tabAdd">添加-修改</a></dd>
                        <dd><a href="javascript:;" href-url="demo/data-table.html" data-type="tabAdd">data-table 表格页</a></dd>
                        <dd><a href="javascript:;" href-url="demo/tree-table.html" data-type="tabAdd">Tree table树表格页</a></dd>
                        <dd><a href="javascript:;" href-url="demo/404.html" data-type="tabAdd">404页</a></dd>
                        <dd><a href="javascript:;" href-url="demo/tips.html" data-type="tabAdd">提示页</a></dd>
                        <dd><a target="_blank" href="http://qm.qq.com/cgi-bin/qm/qr?k=jVYSxzwk9dZXNHdZq8owgzwzVjbzAp02">点击加入群下载源码</a>
                        </dd>
                    </dl>
                </li>
            </ul>
         </div>
    </div>
    
    <!-- body iframe-->
    <div class="layui-body my-body">
        <div class="layui-tab layui-tab-card my-tab" lay-filter="card" lay-allowClose="true">
            <ul class="layui-tab-title">
                <li class="layui-this" lay-id="0"><span>欢迎页</span></li>
            </ul>
            <div class="layui-tab-content">
                <div class="layui-tab-item layui-show">
                    <iframe id="iframe" src="${ctx }/commons/jsp/welcome.jsp" frameborder="0"></iframe>
                </div>
            </div>
        </div>
    </div>
    
    <!-- footer -->
    <div class="layui-footer my-footer">
    	<p><a href="" target="_blank">银行接口系统v1.0.0</a>&nbsp;&nbsp;&nbsp;&nbsp;</p>
        <p>2017 © copyright xxxx备xxxxx号</p>
    </div>
  </div>
  
  <script type="text/javascript">
    layui.use(['layer', 'element', 'util'], function () {
        var element = layui.element(), layer = layui.layer, $ = layui.jquery, util = layui.util; //导航的hover效果、二级菜单等功能，需要依赖element模块
        var side = $('.my-side');
        var body = $('.my-body');
        var footer = $('.my-footer');

        // 监听导航栏收缩
        $('.btn-nav').on('click', function(){
            if(localStorage.log == 0){
                localStorage.log = 1;
                navShow(1);
            }else{
                localStorage.log = 0;
                navHide(1);
            }
            //layer.msg(localStorage.log);
        });

        // 导航栏收缩
        function navHide(t){
            var time = t ? t : 100;
            side.animate({'left':-200},time);
            body.animate({'left':0},time);
            footer.animate({'left':0},time);
        }

        // 导航栏展开
        function navShow(t){
            var time = t ? t : 100;
            side.animate({'left':0},time);
            body.animate({'left':200},time);
            footer.animate({'left':200},time);
        }

        
 		
        element.on('nav', function (elem) {//监听所有的导航菜单 
        //element.on('nav(side)', function (elem) {监听导航(side):side对应--->lay-filter的值 点击切换页面: 左侧导航菜单
            var card    = 'card';                                   // 选项卡对象
            var title   = elem.text();                              // 导航栏text
            var src     = elem.children('a').attr('href-url');      // 导航栏跳转URL
            var id      = new Date().getTime();                     // ID
            var flag    = getTitleId(card, title);                  // 是否有该选项卡存在
            // 大于0就是有该选项卡了
            if(flag > 0){
                id = flag;
            }else{
                //新增
                element.tabAdd(card, {
                    title: '<span>'+title+'</span>'
                    , content: '<iframe src="' + src + '" frameborder="0"></iframe>'
                    , id: id
                });
            }
            // 切换相应的ID tab
            element.tabChange(card, id);
            // 提示信息
            //layer.msg(title);
            // 关闭弹窗
            layer.closeAll();
        });

        // 根据导航栏text获取lay-id
        function getTitleId(card,title){
            var id = -1;
            $(document).find(".layui-tab[lay-filter=" + card + "] ul li").each(function(){
                if(title === $(this).find('span').text()){
                    id = $(this).attr('lay-id');
                }
            });
            return id;
        }

        
        /***浏览器适配*/
        // 监听控制content高度
        function init(){
            // 起始判断收缩还是展开
            if(localStorage.log == 0){
                navHide(1);
            }else{
                navShow(1);
            }
            // 选项卡高度
            cardTitleHeight = $(document).find(".layui-tab[lay-filter='card'] ul.layui-tab-title").height();
            // 需要减去的高度
            height = $(window).height() - $('.layui-header').height() - cardTitleHeight - $('.layui-footer').height();
            // 设置高度
            $(document).find(".layui-tab[lay-filter='card'] div.layui-tab-content").height( height - 2 );
        }

        // 自适应
        $(window).on('resize', function() {
            if($(this).width() > 1024){
                navShow();
            }else{
                navHide();
            }
            init();
        });

        // 初始化
        init();

        
        // 分辨率小于1024  使用内部工具组件
        if ($(window).width() < 1024) {
            util.fixbar({
                bar1: '&#xe602;'
                , css: {left: 10, bottom: 54}
                , click: function (type) {
                    if (type === 'bar1') {
                        //iframe层
                        layer.open({
                            type: 1,                        // 类型
                            title: false,                   // 标题
                            offset: 'l',                    // 定位 左边
                            closeBtn: 0,                    // 关闭按钮
                            anim: 0,                        // 动画
                            shadeClose: true,               // 点击遮罩关闭
                            shade: 0.8,                     // 半透明
                            area: ['150px', '100%'],        // 区域
                            skin: 'my-mobile',              // 样式
                            content: $('body .my-side').html() // 内容
                        });
                    }
                    element.init();
                }
            });
            localStorage.log = 0;
            navHide(1);
        }

    });
  </script>
</body>
</html>