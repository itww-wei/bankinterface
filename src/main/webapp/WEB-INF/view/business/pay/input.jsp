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

<blockquote class="layui-elem-quote">
    请填写缴纳保证金信息
</blockquote>

<fieldset class="layui-elem-field" style="margin-top: 20px;">
    <legend>信息</legend>
<form class="layui-form" action="">
	<input type="hidden" name="projectBankId" value="${project.id }">
    <div class="layui-form-item">
        <label class="layui-form-label">户名</label>
        <div class="layui-input-block">
            <input type="text" name="inName" lay-verify="required" autocomplete="off" placeholder="请输入户名" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">账号</label>
        <div class="layui-input-block">
            <input type="text" name="inAcct" lay-verify="num" placeholder="请输入账号" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">金额</label>
        <div class="layui-input-inline">
            <input type="number" name="inAmount" lay-verify="required"  class="layui-input">
        </div>
    </div>
    
    <div class="layui-form-item">
        <div class="layui-input-block">
            <button class="layui-btn" lay-submit="" lay-filter="submit">立即提交</button>
            <button type="reset" class="layui-btn layui-btn-primary">重置</button>
        </div>
    </div>
</form>
</fieldset>
<!-- jQuery -->
<script type="text/javascript" charset="utf8" src="${ctx }/commons/js/jquery-1.8.0.min.js"></script>
<script type="text/javascript" src="${ctx }/commons/js/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="${ctx }/commons/layui/js/table-tool.js"></script>
<script type="text/javascript">
	layui.use(['form', 'layedit', 'laydate'], function(){
    var form = layui.form()
            ,layer = layui.layer
            ,layedit = layui.layedit
            ,laydate = layui.laydate;
     
    //自定义验证规则
    form.verify({
        title: function(value){
            if(value.length < 5){
                return '标题至少得5个字符啊';
            }
        }
        ,num: [/^[0-9]*$/, '只能输入数字']
    });
    
    //监听提交
    form.on('submit(submit)', function(data){
        //parent.layer.alert(JSON.stringify(data.field), {
           // title: '最终的提交信息'
       // });
        //return false;
        
        //手动Ajax提交
        //显示加载动画
     	var loading = parent.layer.load(0, {shade: false}); //0代表加载的风格，支持0-2
        $.ajax({
             type: "POST",
             url: "${ctx}/pay/save", 
             cache: false,  //禁用缓存
             data: data.field,//封装表单数据
             success: function (result) {
            	 if(result=="success"){
            		parent.layer.msg("提交成功");
                  	//关闭加载层
                  	parent.layer.close(loading);
                  	//关闭窗体
                  	var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
					parent.layer.close(index); //再执行 窗体关闭
					
					parent.location.reload(); // 父页面刷新  
            	 }
             },
             error:function(){
            	 parent.layer.msg("提交失败");
            	 parent.layer.close(loading);
             }
         });
        
        return false;
    });
    });
</script>
</body>
</html>