$(document).ready(function() {
    var token="GA221211104231";
    var api ="https://script.google.com/macros/s/AKfycbyoBhxuklU5D3LTguTcYAS85klwFINHxxd-FroauC4CmFVvS0ua/exec";
    $("#txt_archivo").change(function() {
    subirFoto("txt_archivo");
});

    $("#btn_notificar").click(function() {
    var  payload = {"op": "registermessage","token_qr": token, "mensajes": [
{"numero": $("#txt_celular").val(),"mensaje": "pruebas desde javascript Documento es *"+$("#txt_documento").val()+"*"},
{"numero": $("#txt_celular").val(),"imagenbase64":$("#txt_archivo_base64").val()}]};
    $.ajax({
    url: api,
    jsonp: "callback",
    method: 'POST',
    data : JSON.stringify(payload),
    async: false,
    success: function(respuestaSolicitud) {
    alert(respuestaSolicitud.message);
}
});
});
});

    function base64(file, callback){
    var coolFile = {};
    function readerOnload(e){
    var base64 = btoa(e.target.result);
    coolFile.base64 = base64;
    callback(coolFile)
};

    var reader = new FileReader();
    reader.onload = readerOnload;

    var file = file[0].files[0];
    coolFile.filetype = file.type;
    coolFile.size = file.size;
    coolFile.filename = file.name;
    reader.readAsBinaryString(file);
}
    async function subirFoto(id){
    var foto = await new Promise((resolve, reject) => {
    base64( $('#'+id), function(data){
    resolve(data.base64)
});
});
    $("#"+id+"_base64").val(foto);
    console.log(foto);
}
