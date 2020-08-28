function toggleSelect(){
    var chpsText = document.querySelector("autre_fournisseur");
    var option = document.querySelector("id_fournisseur");
    if(option.value == 0){
        chpsText.classList.remove("hidden");
    } else {
        chpsText.classList.add("hidden");
    }

}