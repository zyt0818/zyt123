<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<base href="/ums/">
<meta charset="UTF-8">
<title>用户信息</title>
<link rel="stylesheet" type="text/css" href="easyui/css/easyui.css">
<link rel="stylesheet" type="text/css" href="easyui/css/icon.css">
<link rel="stylesheet" type="text/css" href="easyui/css/demo.css">




</head>
<body>
	<div id="profile_update" class="easyui-dialog" title="修改管理员信息"
		data-options="iconCls:'icon-add',resizable:true,modal:true,fit:true,closed:true">
		<form id="modifyProfile" method="post">
			<p>
				<input name="id" readonly="readonly" id="uid" />
			</p>
			<p>
				<input name="name" id="uname" required="required"
					placeholder="请输入姓名" />
			</p>
			<p>
				<input type="date" name="birthday" id="ubirthday"
					required="required" placeholder="请输入生日" />
			</p>
			<p>
				<input name="gender" id="ugender" required="required"
					placeholder="请输入性别" />
			</p>
			<p>
				<input name="career" id="ucareer" required="required"
					placeholder="请输入职位" />
			</p>
			<p>
				<input name="address" id="uaddress" required="required"
					placeholder="请输入地址" />
			</p>
			<p>
				<input type="tel" name="mobile" id="umobile" required="required"
					placeholder="请输入号码" />
			</p>

			<a id="closeBtn" href='javascript:close()'>关闭</a> <a
				href="javascript:update_adminInfo()" class="easyui-linkbutton"
				data-options="iconCls:'icon-ok'">修改</a>
		</form>




	</div>
	<div id="profile_detail" class="easyui-dialog" title="查看管理员信息"
		data-options="iconCls:'icon-add',resizable:true,modal:true,fit:true,closed:true">
		<form>
			<p>
				编号：<input name="id" readonly="readonly" id="did" />
			</p>
			<p>
				姓名<input name="name" id="dname" readonly="readonly" />
			</p>
			<p>
				生日：<input type="date" name="birthday" id="dbirthday" />
			</p>
			<p>
				性别：<input name="gender" id="dgender" readonly="readonly"/>
			</p>
			<p>
				职位：<input name="career" id="dcareer" readonly="readonly"/>
			</p>
			<p>
				地址：<input name="address" id="daddress" readonly="readonly"/>
			</p>
			<p>
				电话：<input type="tel" name="mobile" id="dmobile" readonly="readonly"
					 />
			</p>

			<a id="closeBtn" href='javascript:close1()'  class="easyui-linkbutton"
				data-options="iconCls:'icon-no'">关闭</a> 
				
		</form>




	</div>
	<table id="profile_dataInfo"></table>

	<script type="text/javascript" src="easyui/js/jquery-1.12.4.js"></script>
	<script type="text/javascript" src="easyui/js/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="easyui/js/easyui-lang-zh_CN.js"></script>
	<script type="text/javascript" src="js/list.js"></script>

</body>
</html>