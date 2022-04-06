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
</head>
<body>
<form class="form-horizontal" role="form" action="addbook_book.action" method="POST"
enctype="multipart/form-data">

  <div class="form-group">
    <label for="name" class="col-sm-2 control-label">名字:</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="name"
             name="book.name" placeholder="请输入书籍名字">
    </div>
  </div>
  <!--作者-->
  <div class="form-group">
    <label for="author" class="col-sm-2 control-label">作者:</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="author"
             name="book.author" placeholder="请输入书籍作者">
    </div>
  </div>
  <!--价格-->
  <div class="form-group">
    <label for="price" class="col-sm-2 control-label">价格:</label>
    <div class="col-sm-10">
      <input type="number" class="form-control" id="price"
             name="book.price" placeholder="请输入书籍价格">
    </div>
  </div>
  <!--出版日期-->
  <div class="form-group">
    <label for="publishdate" class="col-sm-2 control-label">出版日期:</label>
    <div class="col-sm-10">
      <input type="date" class="form-control" id="publishdate"
             name="book.publishdate" >
    </div>
  </div>
  <!--所在类别-->
  <div class="form-group">
    <label for="categoryid" class="col-sm-2 control-label">所在类别:</label>
    <div class="col-sm-10">
      <select class="form-control" id="categoryid"
             name="book.ca.id" >
      </select>
    </div>
  </div>
  <!--状态-->
  <div class="form-group">
    <label for="status" class="col-sm-2 control-label">状态:</label>
    <div class="col-sm-10">
      <select class="form-control" id="status"
             name="book.status" >
        <option value="1">==上架==</option>
        <option value="0">==下架==</option>
      </select>
    </div>
  </div>
  <!--图片-->
  <div class="form-group">
    <button type="button" class="btn btn-primary"
            onclick="addpic()">上传图片</button>
    <div class="col-sm-10" id="pics">

    </div>
  </div>
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <button type="submit" class="btn btn-default">提交</button>
    </div>
  </div>
</form>
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="js/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="js/bootstrap.min.js"></script>
<script>
  $(function(){
     //查询所有的类别信息
      queryAllCas();
  });
  function queryAllCas(){
      $.ajax({
          type:"post",
          url:"queryAllCas_book.action",

          dataType:"json",
          success:function(msg){//msg----->List<Category>
              console.log(msg);
              var ops="<option value='-1'>==请选择==</option>";
              $.each(msg,function(i,ca){
                 ops+="<option value='"+ca.id+"'>"+ca.name+"</option>";
              });
              $("#categoryid").html(ops);
          }

      });
  }
  let i=0;
    function addpic(){
        let ss="请选择:<input type='file' name='pic'/>是否是封面" +
            ":<input type='radio' name='fm' value='"+(i++)+"' />"
        $("#pics").append(ss);
    }

</script>
</body>
</html>
