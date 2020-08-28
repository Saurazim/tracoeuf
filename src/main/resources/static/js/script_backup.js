function init(){
    var net = document.getElementById("net");
    
    if(net.checked==true) {
        disableTare();
    } else {
        ableTare();
    }

    toggleSelect();
    toggleCheck();
    toggleCheckPalette();

}

function toggleSelect(){
    var chpsText = document.getElementById("autre_fournisseur");
    var option = document.getElementById("id_fournisseur");
    if(option.value == 0){
        chpsText.classList.remove("hidden");
    } else {
        chpsText.classList.add("hidden");
    }

}

function toggleCheck(){
    var idRadioNb = document.getElementById("div_nb_alveole");
    var idRadioType = document.getElementById("div_type_palette");
    var inputTare = document.getElementById("nb_tare");
    
    if (document.getElementById("check_tare").checked == true) {
        inputTare.classList.remove("displayNone");
        idRadioNb.classList.add("displayNone");
        idRadioType.classList.add("displayNone");
    } else {
        inputTare.classList.add("displayNone");
        idRadioNb.classList.remove("displayNone");
        idRadioType.classList.remove("displayNone");
    
    }
}

function toggleCheckPalette() {
    var checkPalette = document.getElementById("check_palette");
    var newPal = document.getElementById("new_pal");
    if (checkPalette.checked == true) {
        newPal.classList.remove("hidden");
    } else {
        newPal.classList.add("hidden");
    }
}

function ableTare() {
    var divTare = document.getElementById("div_tare");
    divTare.classList.remove("disableDiv");
}

function disableTare() {
    var divTare = document.getElementById("div_tare");
    divTare.classList.add("disableDiv");
}

function toggleTare() {
    var check = document.getElementById("checkTypePoids");
    var tableTare = document.getElementById("tare");
    if(check.checked==true){
        tableTare.classList.add("disableDiv");
    } else {
        tableTare.classList.remove("disableDiv");
    }
}

function able_tare(){
    var check = document.getElementById("checkTypePoids");
    var table_tare = document.getElementById("table_tare");
    var nb_tare = document.getElementById("nombre_tare");
    if(check.checked==true){
        table_tare.classList.add("disableDiv");
        nb_tare.classList.add("disableDiv");
    } else {
        table_tare.classList.remove("disableDiv");
        nb_tare.classList.remove("disableDiv");
    }

}
