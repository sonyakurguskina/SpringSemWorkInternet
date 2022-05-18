// function error(xhr, ajaxOptions, thrownError){
//     if(xhr.status==404) {
//         alert(thrownError);
//     }
// }

var isNew = true;
var userId = null;
getall();

function addUser(){
    if($("#frmUser").valid()){
    var url = "";
    var data = "";
    var method;

    if(isNew == true){
    url = '/save';
    data = $("#frmUser").serialize();
    method = 'POST'
}
    else
{
    url = '/accounts';
    data = $("#frmUser").serialize() + "&userId" + userId;
    method ='Post'
}

    $.ajax({
    type:method,
    url:url,
    dataType : "JSON",
    data : data,

    success:function(data)
{
    $('#email').val("");
    $('#firsName').val("");
    console.log(data);
    getall();

    if(data.status == "success")
{
    alert("Record Added");
}
    else {
    alert("Error");
}
}
});
}
}

function getall()
{
    $('#users').dataTable().fnDestroy();
    $.ajax({
    url:"accounts/list",
    type: "GET",
    dataType: "JSON",
    success:function (data)
{
    $("users").dataTable({
    "data": data,
    "columns": [
{ data: 'email' },
{ data: 'firstName'},
    // {
    //     data: null,
    //     render: function (data, type, full, meta) {
    //         return $("#btn btn-success").attr("onclick","").click(function(){
    //             edit(data.id);
    //         });
    //         // '<button class = "btn btn-success" ="get_details(' + data.id + ')">Edit<button>';
    //     }
    // },
{
    data: null,
    render: function (data, type, full, meta) {
    return $("#btn btn-danger").attr("onclick","").click(function(){
    delete(data.id);
});
    // '<button class = "btn btn-danger" on="get_Delete(' + data.id + ')">Delete<button>';
}
}
    ]
});
}
})
}
