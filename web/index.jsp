<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>Bootstrap 101 Template</title>

  <!-- Bootstrap -->
  <link href="css/bootstrap.min.css" rel="stylesheet">
  <style>
      .page-header{
        margin:2px 0px;
      }
    .navbar{
      margin-bottom:2px;
    }

  </style>
</head>
<body>
  <!--页头-->
  <div class="page-header">
      <img src="image/timg.gif" width="100%" height="130px" />
  </div>
  <!--页头end-->
  <!--导航-->
  <nav class="navbar navbar-default" role="navigation">
    <div class="container-fluid">
      <!-- Brand and toggle get grouped for better mobile display -->
      <div class="navbar-header">
        <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
          <span class="sr-only">Toggle navigation</span>
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
        </button>
        <a class="navbar-brand" href="#">书籍管理系统</a>
      </div>

      <!-- Collect the nav links, forms, and other content for toggling -->
      <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
        <ul class="nav navbar-nav">
          <li class="active"><a href="#">首页</a></li>
        </ul>

        <ul class="nav navbar-nav navbar-right">

          <li class="dropdown">
            <a href="#" class="dropdown-toggle"
               data-toggle="dropdown">更多... <span class="caret"></span></a>
            <ul class="dropdown-menu" role="menu">
              <li><a href="#">登陆</a></li>
              <li class="divider"></li>
              <li><a href="#">注册</a></li>
            </ul>
          </li>
        </ul>
      </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
  </nav>
  <!--导航 end-->
  <div class="container-fluid">
      <div class="row">
          <div class="col-md-4">
            <div class="list-group">
              <a href="#" class="list-group-item active">
               书籍管理系统
              </a>
              <a href="addca.jsp" target="et" class="list-group-item">添加类别</a>
              <a href="addbook.jsp" target="et" class="list-group-item">添加书籍</a>
              <a href="booklist.jsp" target="et" class="list-group-item">书籍列表</a>
              <a href="booklist.jsp" target="et" class="list-group-item">报表显示</a>
            </div>
          </div>
          <div class="col-md-8">
              <iframe src="welcome.jsp" frameborder="0"
                      height="1000px" width="100%" name="et"></iframe>

          </div>
      </div>

  </div>
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="js/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="js/bootstrap.min.js"></script>
</body>
</html>
