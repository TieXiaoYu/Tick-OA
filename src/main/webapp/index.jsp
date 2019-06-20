<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport"
          content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>滴答办公系统-主页</title>
    <link rel="stylesheet" href="media/layui/css/layui.css" media="all">
    <!-- <link rel="stylesheet" type="text/css" href="http://www.jq22.com/jquery/font-awesome.4.6.0.css"> -->
    <link rel="stylesheet" href="media/css/app.css" media="all">
    <link rel="stylesheet" href="media/css/font-awesome.min.css">
    <style type="text/css">
        iframe{
            width: 98%;
            height: 98%;
        }
        .layui-tab-item{
            height: 98%;
        }
    </style>
</head>

<body>
<div class="layui-layout layui-layout-admin kit-layout-admin">
    <div class="layui-header">
        <div class="layui-logo">
            <img src="media/images/qf_logo.png" style="margin-right: 10px" /><span
                style="font-size: 22px">滴答办公系统</span>
        </div>

        <!-- 头部区域（可配合layui已有的水平导航） -->
        <ul class="layui-nav layui-layout-left">
            <li class="layui-nav-item kit-side-fold" lay-unselect >
                <a href="javascript:flexible();" title="侧边伸缩">
                    <i class="layui-icon layui-icon-shrink-right" id="LAY_flexible"></i>
                </a>

            </li>
            <li class="layui-nav-item" lay-unselect>
                <a layadmin-event="refresh" title="刷新">
                    <i class="layui-icon layui-icon-refresh-3"></i>
                </a>
            </li>
            <li class="layui-nav-item layui-hide-xs" lay-unselect>
                <input type="text" placeholder="搜索..." autocomplete="off" class="layui-input layui-input-search" layadmin-event="serach" lay-action="template/search.html?keywords=">
            </li>

        </ul>
        <ul class="layui-nav layui-layout-right">
            <li class="layui-nav-item" style="margin-right: 20px">
                <a href="javascript:showTab(1001,'processlist.html','待办事项');">待办事项<span class="layui-badge">99+</span></a>
            </li>
            <li class="layui-nav-item">
                <a href="javascript:;">
                    <img src="media/images/qf_logo.png" class="layui-nav-img">
                   ${userInfo}
                </a>
                <dl class="layui-nav-child">
                    <dd><a href="javascript:showTab(1001,'user.html','我的信息');">我的信息</a></dd>
                    <dd><a href="javascript:showTab(1001,'user.html','更改头像');">更改头像</a></dd>
                    <dd><a href="javascript:showTab(1002,'user.html','修改密码');">修改密码</a></dd>
                </dl>
            </li>
            <li class="layui-nav-item"><a href="user/loginOut.do">注销</a></li>
        </ul>
    </div>

    <div class="layui-side layui-bg-black ">
        <div class="layui-side-scroll">

            <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
            <ul class="layui-nav layui-nav-tree"  lay-shrink="all" id="lm">
            </ul>
        </div>
    </div>
    <div class="layui-body" id="container" >
        <!-- 内容主体区域 -->
        <div class="layui-tab" lay-filter="demo" style="width: 100%;height: 90%">
            <ul class="layui-tab-title"></ul>
            <div class="layui-tab-content" style="width: 99%;height: 98%"></div>
        </div>
    </div>

    <div class="layui-footer">
        <p>
            Copyright 2011-2018 <a href="http://www.1000phone.com/"
                                   rel="nofollow" target="_blank" title="千锋互联">北京滴答科技有限公司 Feri
            版权所有</a> 京ICP备12003911号-3 京公网安备11010802011455号
        </p>
    </div>
</div>

<script src="media/js/jquery.min.js"></script>
<script src="media/layui/layui.js"></script>

<script type="text/javascript">
    var _id = 0;
    $(function () {
        _id = decodeURI(location.search).substr(4);
        $("[title = '刷新']").prop("href","index.jsp?id="+_id);
    })
</script>

<script>
    //JavaScript代码区域
    var element;
    var tid=-1;
    function showTab(id,u,n) {
        if(tid>0){
            element.tabDelete('demo',tid);
        }
        element.tabAdd('demo', {
            title:n
            ,content: '<iframe data-frameid="'+id+'" scrolling="auto" frameborder="0" src="'+u+'?id='+_id+'"></iframe>' //支持传入html
            ,id:id
        });
        element.tabChange('demo', id);
        element.render();
        tid=id;
    }
    
    function loadPage() {
        layui.config({
            base: 'media/layui/lay/modules/'
        }).use(['element','app'], function(){
            element = layui.element;
            $.ajax({
                type:"get",
                url:"user/findPerms.do?id="+_id,
                dataType:"json",
                success:function (data) {
                    $("#lm").empty();
                    element.render();
                    var s;
                    for(i=0;i<data.info.length;i++){
                        var parent=data.info[i];
                        s+="<li class='layui-nav-item '> <a href='javascript:;' id='"+_id+"'></i>&nbsp;"+parent.aTitle+"</a>";
                        if(parent.voMenuList.length>0){
                            s+="<dl class='layui-nav-child'>";
                            for(j=0;j<parent.voMenuList.length;j++){
                                var child=parent.voMenuList[j];
                                s+="<dd><a href='javascript:;' id='"+_id+"' onclick='showTab("+child.id+",\""+child.aUrl+"\",\""+child.aTitle+"\")'>&nbsp;&nbsp;&nbsp;&nbsp;"+child.aTitle+"</a></dd>";
                            }
                            s+="</dl>";
                        }
                        s+="</li>";
                    }
                    $("#lm").append(s);
                    element.render();
                }
            });
            showTab(20000,"main.html","首页");
        });
    }
    
    
    $(function () {
        loadPage();
    });
</script>
<script>
    function flexible() {

        $("body").toggleClass("big-page");

    }
</script>
<style>
    .big-page .layui-layout-admin .layui-side{top:60px;width:0px;overflow-x:hidden}
</style>
</body>

</html>