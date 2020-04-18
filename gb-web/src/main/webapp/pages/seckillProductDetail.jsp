<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort() +request.getContextPath()+"/";
%>
<!DOCTYPE html>
<html>
<head>
	<base href="<%=basePath %>">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>秒杀商品详情页</title>
    <link rel="stylesheet" type="text/css" href="<%=basePath %>/static/js/easyui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="<%=basePath %>/static/js/easyui/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="../demo.css">
    <script type="text/javascript" src="<%=basePath %>/static/js/easyui/jquery.min.js"></script>
    <script type="text/javascript" src="<%=basePath %>/static/js/easyui/jquery.easyui.min.js"></script>
</head>
<body>
    <center>
        <table width="300px" heiht="400px" border="1px">
            <tr>
                <td align="center">
                    <p>
                        <img src="http://192.168.25.133/group1/M00/00/05/wKgZhVzgwPGAangvAABD_zdjoXY679.jpg" style="width: 100px;height: 150px">
                    </p>
                    <p>原价：5999，现在只要：<span style="text-decoration: line-through;color: red">599￥</span></p>
                    <p>
                        <input type="hidden" name="seckillId" value="1">
                        <input type="hidden" name="uName" value="zhangsan">
                        <button id="seckillProduct">立即抢购</button>
                    </p>
                </td>
            </tr>
        </table>
    </center>

    <script type="text/javascript">
        $(function(){
            //当点击立即抢购时，开始秒杀。去请求秒杀接口
            $("#seckillProduct").click(function(){
                $.ajax({
                    url:"http://localhost:8089/seckill/joinSeckillProduct",
                    type:"post",
                    dataType:"JSON",
                    data:{
                        "seckillId":$("input[name=seckillId]").val(),
                        "uName":$("input[name=uName]").val()
                    },
                    success:function(rs){
                        console.log(rs);
                        //1、如果status="0"，代表秒杀成功
                        //2、如果status="1",代表秒杀失败
                    },
                    error:function(rs){
                        alert("哎呀，由于人数较多，秒杀失败了");
                    }
                });
            });
        });
    </script>
</body>
</html>
