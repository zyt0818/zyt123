var datagrid;
	var editRow=undefined;
	var op;
	var flag;
	datagrid=$('#profile_dataInfo').datagrid({   
	   // url:'profileServlet',  
	    //queryParams: {op:"findProfileByPage"},
		url:'user/list',
	    fitColumns:true,
	    loadMsg:"数据加载中",
	    striped:true,
	    pagination:true,
	   
	    fit:true,
	    rownumbers:true,
	    
	    sortName:"id",
	    remoteSort:false,
	
	    columns:[[   
	              {field:'id',title:'编号',width:100},   
	              {field:'name',title:'姓名',width:100},   
	              {field:'birthday',title:'生日',width:100} ,
	              {field:'gender',title:'性别',width:100} ,
	              {field:'career',title:'职业',width:100} ,
	              {field:'address',title:'地址',width:100} ,
	              {field:'mobile',title:'号码',width:100} ,
	              {field:'_operate',title:'操作',width:140,align:'center',formatter:function(val,row,index){
		  	        	return "<a href='javascript:selectProfileInfo("+JSON.stringify(row)+")' class='icon-search icon-padding'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;详细</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href='javascript:updateProfileInfo("+JSON.stringify(row)+")' class='icon-edit1 icon-padding'>修改</a>"
		              }}
	  	        ]]   

	});  
function updateProfileInfo(row){
	$("#profile_update").dialog("open");
	$("#uid").val(row.id);
	$("#uname").val(row.name);
	$("#ubirthday").val(row.birthday);
	$("#ugender").val(row.gender);
	$("#ucareer").val(row.career);
	$("#uaddress").val(row.address);
	$("#uid").val(row.id);
	$("#umobile").val(row.mobile);
	
}
function selectProfileInfo(row){
	$("#profile_detail").dialog("open");
	$("#did").val(row.id);
	$("#dname").val(row.name);
	$("#dbirthday").val(row.birthday);
	$("#dgender").val(row.gender);
	$("#dcareer").val(row.career);
	$("#daddress").val(row.address);
	$("#did").val(row.id);
	$("#dmobile").val(row.mobile);
	
}
$("#closeBtn").linkbutton({
	iconCls:"icon-cancel"
	
	
});
function close(){
		$("#profile_update").dialog("close");
}
function close1(){
	$("#profile_detail").dialog("close");
}
function update_adminInfo(){
	$('#modifyProfile').submit();  
	

	
}
$('#modifyProfile').form({   
    url:"user/modify",   
     
    success:function(data){   
        var data=data.trim();
        if(data=="true"){
        	$('#profile_dataInfo').datagrid("reload");
        	$("#profile_update").dialog("close");
        	
        }
        $.messager.show({
        	title:'修改用户',
        	msg:data=="true" ? "修改成功" :"修改失败",
        	timeout:5000,
        	showType:'slide'
        });


    }   
});   
