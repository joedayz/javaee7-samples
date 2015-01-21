var rootURL = "http://localhost:8080/DemoRS/resources/ofertas";

findAll();


$("#ofertaList a").live('click', function(){
   findById($(this).data('identity')); 
});

//funciones

var actualOferta;

function findById(id){
    console.log('Estoy en findById ' + id);
    $.ajax({
       type: 'GET',
       url: rootURL + '/' + id,
       dataType: "json",
       success: function(data){
           actualOferta = data;
           renderDetalle(actualOferta);
       }
    });
}

function renderDetalle(oferta){
    $('#ofertaId').val(oferta.id);
    $('#titulo').val(oferta.titulo);
    $('#descripcion').val(oferta.descripcion);
}

function findAll(){
    console.log("Llamando al metodo findAll")    
   
    $.ajax({
       type: 'GET',
       url: rootURL,
       dataType: 'json',
       success: renderList //muestra ofertas en el html
    });
}

function renderList(data){

    var list = data == null ? [] : (data instanceof Array  ? data: [data] );
    
    $('#ofertaList li').remove();
    $.each(list, function(index, oferta){
        $('#ofertaList').append('<li><a href="#" data-identity="'+ oferta.id+'">'+oferta.titulo+'</a></li>');
    });
}