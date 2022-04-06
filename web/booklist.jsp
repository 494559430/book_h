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
<!--查询区域-->
<div class="panel-group" id="accordion" role="tablist" aria-multiselectable="true">
  <div class="panel panel-default">
    <div class="panel-heading" role="tab" id="headingOne">
      <h4 class="panel-title">
        <a data-toggle="collapse" data-parent="#accordion" href="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
          条件查询
        </a>
      </h4>
    </div>
    <div id="collapseOne" class="panel-collapse collapse in" role="tabpanel" aria-labelledby="headingOne">
      <div class="panel-body">
        <form class="form-inline" role="form">
          <div class="form-group">
            <label  for="bookname">书名:</label>
            <input type="text" class="form-control"
                   id="bookname" name="bookname"
                   placeholder="请输入书名">
          </div>
          <div class="form-group">
            <label  for="caid">类别:</label>
            <select class="form-control"
                   id="caid" name="caid"></select>
          </div>

          <button type="button" class="btn btn-primary" onclick="queryByTj()">查询</button>
          <button type="button" class="btn btn-success" onclick="export2Excel()">导出到EXCEL</button>
          <button type="button" class="btn btn-danger" onclick="delbat()">删除</button>
        </form>
      </div>
    </div>
  </div>
</div>
<!--查询区域 end-->
<table class="table table-bordered table-responsive table-striped
table-condensed table-hover" id="tb">
</table>

<!--Modal-->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
        <h4 class="modal-title" id="myModalLabel">Modal title</h4>
      </div>
      <div class="modal-body">
        <form class="form-horizontal" role="form" action="updateBook_book.action" method="POST"
              enctype="multipart/form-data">
          <input type="hidden" id="id" name="book.id">
          <div class="form-group">
            <label for="tupian" class="col-sm-2 control-label">封面:</label>
            <div class="col-sm-10" id="tupian"></div>
          </div>

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
                      name="book.ca.id"  >
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

          <button type="submit" class="btn btn-primary">更新</button>
        </form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>

      </div>
    </div>
  </div>
</div>
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="js/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="js/bootstrap.min.js"></script>

<script src="js/bootstrap-table.js"></script>
<script src="js/bootstrap-table-zh-CN.js"></script>
<script src="js/ajaxfileupload.js"></script>
<script>
    $(function () {
        queryAllCas();
        queryData();

    });
    let name="";
    let caid="";
    function queryByTj() {
        name = $("#bookname").val();
        caid=$("#caid").val();
        tb.bootstrapTable("refresh",{query:{"pageNumber":1}})
    }
    let tb="";
    let start="";

    function queryData() {
        tb=$("#tb").bootstrapTable({
            url: "querySome_book.action",
            pagination: true,
            sidePagination: "server",
            pageNumber: 1,
            pageSize: 4,
            pageList: [3, 4, 5],
            queryParamsType: "undefined",
            queryParams: function (p) {
                start=(p.pageNumber-1)*p.pageSize;
                var np = {
                    "pageNumber": p.pageNumber,
                    "pageSize": p.pageSize,
                    "name": name,
                    "ca.id": caid
                }
                return np;
            }, columns: [{
                field: "id",
                title: "序号",
                formatter:function (value,row,index) {
                    return index+start+1;
                }
            }, {
                field: "name",
                title: "书名"
            }, {
                field: "author",
                title: "作者"
            }, {
                field: "price",
                title: "价格"
            }, {
                field: "pdate",
                title: "出版日期"
            }, {
                field: "ca.name",
                title: "所在类别"
            }, {
                field: "status",
                title: "状态",
                formatter:function (value,row,index) {
                    if (value=="0")
                        return "下架";
                    if (value=="1")
                        return "上架";
        }
            }, {
                field: "del",
                title: "是否删除"

            }, {

                title: "操作",
                formatter:function(value,row,index){
                    let update = "<a href='javascript:void(0)' id='update'>更新</a>";
                    let del = "<a href='javascript:void(0)' id='del'>删除</a>";
                    return update+"||"+del;
                },
                events:caozuo
            }]

        });

    }
    window.caozuo={
        'click #update':function (event,value,row,index) {
            $.each(row.bps,function (index,pic) {
                $("#tupian").append("<img src='/book_hs"+pic.savepath+"'>")
            })
            $("#id").val(row.id);
            $("#name").val(row.name);

            $("#author").val(row.author);
            $("#publishdate").val(row.pdate);
            $("#price").val(row.price);
            $("#status").val(row.status);
            //$("#categoryid").val(row.ca.name);
            $("option[value='"+row.ca.id+"']").attr("selected", true);
            $("#myModal").modal("show");
            },
        'click #del':function (event,value,row,index) {
            $("#del").parent().prev().html("已 删除");
        }
    }
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
              //查询的下拉菜单
              $("#caid").html(ops);
              //模态框的下拉菜单
          $("#categoryid").html(ops);
    }

      });
  }

</script>

</body>
</html>
