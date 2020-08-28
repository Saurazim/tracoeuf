function toggleSelect(){
    var chpsText = document.querySelector("#fournisseurAutre");
    var option = document.querySelector("#fournisseurId");
    if(option.value == 0){
        chpsText.classList.remove("hidden");
    } else {
        chpsText.classList.add("hidden");
    }

}