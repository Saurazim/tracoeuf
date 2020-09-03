$(document).ready(function() {
    $("button#impression").click(function(event) {
        event.preventDefault();

        essai_impression();
    })
})

function essai_impression() {
    var impr = {},
        file,
        chemin="/tracoeuf/impression";

        $("button#impression").prop("disabled", true); 
        
        file = $("input#file").val();
        file = file.replace(/.*[\/\\]/, '');
        impr["nom"]=file;
        $('#feedback').html(impr)
        $.ajax({
            type: "POST",
            contentType: "application/json",
            url: chemin,
            data: JSON.stringify(impr),
            dataType: 'json',
            cache: false,
            timeout: 6000,
            success: function(data) {
                var json = "<h4>Ajax Response</h4><pre>"
                + JSON.stringify(data, null, 4) + "</pre>";
                $('#feedback').html(json);
                $("button#impression").prop("disabled", false);
            },
            error: function(e) {
                alert("Erreur : "+e.msg)
                $("button#impression").prop("disabled", false);
            }
        });
}

function setInCode(str){
    return str.substring(0, 3).toUpperCase()
}

function toggleSelect(){
    var chpsText = document.querySelector("#fournisseurAutre");
    var option = document.querySelector("#fournisseurId");
    if(option.value == 0){
        chpsText.classList.remove("hidden");
    } else {
        chpsText.classList.add("hidden");
    }
}