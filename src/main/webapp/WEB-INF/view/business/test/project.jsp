<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../../../commons/jsp/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="UTF-8">
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>Test</title>
	<link rel="stylesheet" href="${ctx }/css/style.css">
	<link rel="stylesheet" href="${ctx }/commons/layui/css/layui.css">
	<script src="${ctx }/commons/layui/layui.js"></script>
	
</head>
<body class="body">

<fieldset class="layui-elem-field layui-field-title">
    <legend>
        <span class="layui-breadcrumb">
            <a href="javascript:;">项目虚拟账户管理</a>
            <a><cite>Test</cite></a>
        </span>
    </legend>
</fieldset>

<div class="my-btn-box">
    <span class="fl">
        <a class="layui-btn layui-btn-danger radius btn-delect" id="btn-delete-all">批量删除</a>
        <a class="layui-btn btn-add btn-default" id="btn-add-article">发布文章</a>
    </span>
    <form id="searchForm">
    <span class="fr">
        <span class="layui-form-label">搜索条件：</span>
        <div class="layui-input-inline">
            <input type="text" id="projectNo" name="projectNo" value="" autocomplete="off" placeholder="请输入项目编号" class="layui-input">
        </div>
        <button class="layui-btn mgl-20 search">查询</button>
    </span>
    </form>
</div>

<table id="dateTable" class="layui-table">
    <thead>
    <tr>
        <th><input type="checkbox" class="my-checkbox" /></th>
        <th>项目ID</th>
        <th>项目编号</th>
        <th>虚拟子账号</th>
        <th>授权码</th>
        <th>创建时间</th>
        <th>操作</th>
    </tr>
    </thead>
    <tbody>
   
    </tbody>
</table>

<!-- jQuery -->
<script type="text/javascript" charset="utf8" src="${ctx }/commons/js/jquery-1.8.0.min.js"></script>
<script type="text/javascript" src="${ctx }/commons/js/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="${ctx }/commons/layui/js/table-tool.js"></script>
<script type="text/javascript">
	
	
    layui.use(['element','layer'], function(){
        var $ = layui.jquery,element = layui.element,layer = layui.layer;
      	//封装请求参数
        var param ={};
      	
        //初始化表格
        var table = $("#dateTable").dataTable({
        	dom: '<"top">rt<"bottom"flp><"clear">',//每页显示多少条选项 放置左下角
            language: {                           // 国际化
                "url":'${ctx}/commons/i18n/Chinese.json'
            },  //提示信息
            autoWidth: false,  //禁用自动调整列宽
            stripeClasses: ["odd", "even"],  //为奇偶行加上样式，兼容不支持CSS伪类的场合
            processing: false,  //隐藏加载提示,自行处理
            serverSide: true,  //启用服务器端分页
			bDestroy: true,
			SortCellsTop: true,
            searching: false,  //禁用原生搜索
            orderMulti: false,  //启用多列排序
            order: [],  //取消默认排序查询,否则复选框一列会出现小箭头
            renderer: "bootstrap",  //渲染样式：Bootstrap和jquery-ui
            pagingType: "full_numbers",  //分页样式：simple,simple_numbers,full,full_numbers
            info: true,
            createdRow: function( row, data, dataIndex ) {
            	$(row).children('td').attr('style', 'text-align: center;')
            	//让第一列和第二列居中显示：
                //$(row).children('td').eq(0).attr('style', 'text-align: center;')
                //$(row).children('td').eq(1).attr('style', 'text-align: center;')
            },
            columnDefs: [{
                "targets": [0,5],  //列的样式名
                "orderable": false    //包含上样式名‘nosort’的禁止排序
            }],
            ajax: function (data, callback, settings) {
            	//显示加载动画
        		var loading = layer.load(0, {shade: false}); //0代表加载的风格，支持0-2
            	
        		 //封装表单数据
                //param=$("#searchForm").serialize();
        		//param.projectNo=$("#projectNo").val();
                //alert($("#searchForm").serialize());
        		
                //封装请求参数
                param.limit = data.length;//页面显示记录条数，在页面显示每页显示多少项的时候
                param.start = data.start;//开始的记录序号
                param.page = (data.start / data.length)+1;//当前页码
                
                
                //ajax请求数据
                $.ajax({
                    type: "POST",
                    url: "${ctx}/project/list?"+param,  //传入组装的参数
                    cache: false,  //禁用缓存
                    data: $("#searchForm").serialize(),//封装表单数据
                    dataType: "json",
                    success: function (result) {
                    	//关闭加载层
                    	layer.close(loading);
                        //封装返回数据
                        var returnData = {};
                        returnData.draw = data.draw;//这里直接自行返回了draw计数器,应该由后台返回
                        returnData.recordsTotal = result.total;//返回数据全部记录
                        returnData.recordsFiltered = result.total;//后台不实现过滤功能，每次查询均视作全部结果
                        returnData.data = result.data;//返回的数据列表
                        //console.log(returnData);
                        //调用DataTables提供的callback方法，代表数据已封装完成并传回DataTables进行渲染
                        //此时的数据需确保正确无误，异常判断应在执行此回调前自行处理完毕
                        callback(returnData);
                    }
                });
            },
            //列表表头字段
            columns: [
				{ "data": "id" ,"mRender":function(data,type,full){
						var html="";
						html+='<input type="checkbox" class="my-checkbox" data-id="'+data+'" />';
						return html;
					}
				},
				{ "data": "name"},
				{ "data": "position"}, 
				{ "data": "salary"},
				{ "data": "start_date"},
				{ "data": "start_date"},
				{ "data": "id","mRender":function(data,type,full){
						var html="";
						html+='<button class="layui-btn layui-btn-small">查看</button>';
						html+='<button class="layui-btn layui-btn-small layui-btn-normal">编辑</button>';
						html+='<button class="layui-btn layui-btn-small layui-btn-danger">删除</button>';
						return html;
					}
				}
            ]
        }).api();
        //此处需调用api()方法,否则返回的是JQuery对象而不是DataTables的API对象
        
        
        
        // 初始化表格
       /* var table=$('#dateTable').DataTable({
            "dom": '<"top">rt<"bottom"flp><"clear">',
            "autoWidth": false,                     // 自适应宽度
            "stateSave": false,                      // 刷新后保存页数
            "order": [[ 1, "desc" ]],               // 排序
            "searching": false,                     // 本地搜索
            "info": true,                           // 控制是否显示表格左下角的信息
            "stripeClasses": ["odd", "even"],       // 为奇偶行加上样式，兼容不支持CSS伪类的场合
            "aoColumnDefs": [{                      // 指定列不参与排序
                "orderable": false,
                "aTargets": [0,5]                   // 对应你的表格的列数
            }],
            "pagingType": "full_numbers",         // 分页样式 simple,simple_numbers,full,full_numbers
            "language": {                           // 国际化
                "url":'${ctx}/commons/i18n/Chinese.json'
            },
            "createdRow": function( row, data, dataIndex ) {
            	$(row).children('td').attr('style', 'text-align: center;')
            	//让第一列和第二列居中显示：
                //$(row).children('td').eq(0).attr('style', 'text-align: center;')
                //$(row).children('td').eq(1).attr('style', 'text-align: center;')
            },
            "bProcessing" : true,
			"bServerSide" : true,
			"bDestroy": true,
			"bSortCellsTop": true,
            "sAjaxSource": '${ctx}/project/test', //${ctx}/commons/json/data.json
	        "aoColumns":  [ 
				{ "mData": "id", 'sClass':'left',"mRender":function(data,type,full){
						var html="";
						html+='<input type="checkbox" class="my-checkbox" data-id="'+data+'" />';
						return html;
					}
				},
				{ "mData": "name", 'sClass':'left'},
	        	{ "mData": "position", 'sClass':'center'}, 
	        	{ "mData": "salary",'sClass':'left'},
	        	{ "mData": "start_date", 'sClass':'left'},
	        	{ "mData": "start_date", 'sClass':'left'},
				{ "mData": "id",'sClass':'center',"mRender":function(data,type,full){
						var html="";
						html+='<button class="layui-btn layui-btn-small">查看</button>';
						html+='<button class="layui-btn layui-btn-small layui-btn-normal">编辑</button>';
						html+='<button class="layui-btn layui-btn-small layui-btn-danger">删除</button>';
						return html;
					}
				}
			
			],
			//数据加载成功后调用的事件
	        "fnServerData" : function(sSource, aoData, fnCallback) {
	        	//alert(JSON.stringify(jQuery("searchForm").serialize()));
				$.ajax({
					"type" : 'post',
					"url" : sSource,
					"dataType" : "json",
					"data" : 
						{
							aoData : JSON.stringify(aoData)//参数
						}
						//JSON.stringify(aoData)//参数
						//iDisplayLength:22
						//$("searchForm").serialize()
					,
					"success" : function(resp) {
						alert(JSON.stringify(aoData));
						fnCallback(resp);
					}
				});
			},
			//添加查询参数
			"fnServerParams" : function (aoData) {
                    aoData.push(
                        { "name": "test", "value": "wangwei" }
                    );
                }
        });*/

        // 例:获取ids
        $(document).on('click','#btn-delete-all', function(){
            // getIds(table对象,获取input为id的属性)
            var list = getIds($('#dateTable'),'data-id');
            if(list == null || list == ''){
                layer.msg('未选择');
            }else{
                layer.msg(list);
            }
        });

        // you code ...
        //查询按钮事件
        $('.search').on('click',function(){
        	//alert(22);
        	//table.draw();//刷新数据
        	//param = $("#searchForm").serialize();
        	//alert(param);
        	//table.dataTable().fnDraw(false);//刷新数据
        	//$("#dateTable").dataTable();
        	//table.draw();
        	
        	//1、加parent 遮罩层包括父窗体
        	//parent.layer.alert(layer.v + ' - 贤心出品 sentsin.com');
        	
        	//2、遮罩层在子窗体打开
        	//layer.alert(layer.v + ' - 贤心出品 sentsin.com');
        	
        	//3、 加载层
        	//var index = parent.layer.load(0, {shade: false}); //0代表加载的风格，支持0-2
        	//关闭加载层
        	//parent.layer.close(index);
        	
        	//4、msg 提示
        	//eg1
        	//layer.msg('只想弱弱提示');
        	//eg2
        	//layer.msg('有表情地提示', {icon: 6}); 
        	//eg3
        	//layer.msg('关闭后想做些什么', function(){ alert(2); }); 
        	//eg4
        	/*layer.msg('同上', {
        	  icon: 1,
        	  time: 2000 //2秒关闭（如果不配置，默认是3秒）
        	}, function(){
        		alert(2);
        	});*/
        	
        	//5、打开模态化窗体
        	//iframe层
        	/*layer.open({
        	      type: 2,
        	      title: '很多时候，我们想最大化看，比如像这个页面。',
        	      shadeClose: true,
        	      maxmin: true, //开启最大化最小化按钮
        	      shade: 0.8,
        	      area: ['893px', '600px'],
        	      content: 'http://fly.layui.com/'
        	  });*/
        	    
        	
        	// 带按钮的
        	//示范一个公告层
            layer.open({
              type: 2
              ,title: '标题'
           	  ,content: '${ctx}/pay/pay'
              ,shadeClose: true//开启关闭按钮
              ,maxmin: true //开启最大化最小化按钮
    	      ,area: ['900px', '600px']
              ,shade: 0.8//遮罩层(透明度)
              ,id: 'LAY_layuipro' //设定一个id，防止重复弹出
              ,btn: ['保存', '提交','取消']
              ,yes: function(index, layero){
        	     //按钮【保存】的回调
        	     layer.msg('保存回调');
        		 layer.close(index); //如果设定了yes回调，需进行手工关闭
        	  }
        	  ,btn2: function(index, layero){
        	    //按钮【提交】的回调
        		 layer.msg('提交回调');
        	  }
        	  ,btn3: function(index, layero){
          	    //按钮【提交】的回调
          		 layer.msg('取消回调');
          	  }
        	  ,cancel: function(){ 
          	    //右上角关闭回调
          	    layer.msg('右上角关闭回调');
          	    //return false 开启该代码可禁止点击该按钮关闭
          	  }
              ,moveType: 1 //拖拽模式，0或者1
            });/**/
            
            //6、在子窗体中获取本窗体的参数
          	//var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
			//parent.layer.full(index); //再执行 窗体最大化操作
            
			//7、得到iframe的body的全部html元素
			//var html=layer.getChildFrame("html")//.html();
			
        	return false;
        });
        	
	      

    });
    
</script>
</body>
</html>