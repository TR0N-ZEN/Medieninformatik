var txt, filex;
xhttp = new XMLHttpRequest();

xhttp.onreadystatechange = function(){
    if(this.readyState == 4 && this.status == 200){
        filex = this.responseXML;
        for(i=0; i<length(filex.getElementsByTagName("Oeffnungszeiten")[0]); i++){
            txt += "<li>" + filex.getElementsByTagName("Oeffnungszeiten")[0].childValue[i].nodeValue + "</li>";
        }
        document.getElementById("unorderedlist").innerHTML = txt;
    }
};
xhttp.open("GET", "index.xml", true);
xhttp.send();

console.log(length(filex.getElementsByTagName("Oeffnungszeiten")[0]));