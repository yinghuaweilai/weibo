var dat = document.getElementById("shijian");
var tim = new Date().getHours();
if(tim>=0 && tim<6){
	dat.innerHTML="<h3>凌晨好!  Good early morning,sir! Sleep more time is good for your health!</h3>"
}else if(tim<11 && tim>=6){
    dat.innerHTML="<h3>早上好!  Good morning,sir! Have a good luck day!</h3>"
}else if(tim <13){
    dat.innerHTML="<h3>中午好!  Good noon,sir! Take a nap!</h3>"
}else if(tim<17){
    dat.innerHTML="<h3>下午好!  Good afternoon! Have a cup of tea!</h3>"
}else if(tim<19){
    dat.innerHTML="<h3>傍晚好!  Good dusk! Don't forget to eat dinner!</h3>"
}else if(tim<24){
	dat.innerHTML="<h3>晚上好!  Good evening! Have a good night, my friend!</h3>"
}

